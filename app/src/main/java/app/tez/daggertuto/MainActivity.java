package app.tez.daggertuto;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import app.tez.daggertuto.utils.DateUtils;
import app.tez.daggertuto.utils.SharedPrefsUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Inject SharedPrefsUtils prefs;
    @Inject DateUtils dateUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DaggerTutoApplication) getApplication()).getTutoComponent().inject(this);

        Log.d(TAG, "onCreate: value before the change " + prefs.getCurrentEmail());

        prefs.saveCurrentEmail("toto@mail.fr");

        Log.d(TAG, "onCreate: value after the change " + prefs.getCurrentEmail());

        TextView textview = (TextView) findViewById(R.id.tv);
        textview.setText(dateUtils.getCurrentDate().toString());
    }
}