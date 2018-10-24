package app.tez.daggertuto;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import app.tez.daggertuto.di.PrefModule;
import app.tez.daggertuto.utils.DateUtils;
import app.tez.daggertuto.utils.SharedPrefsUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Inject SharedPrefsUtils prefs;
    @Inject Context context;
    @Inject Resources res;
    @Inject DateUtils date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DaggerTutoApplication) getApplication()).getTutoComponent().inject(this);

        Log.d(TAG, "onCreate: value before the change " + prefs.getNumber());

        prefs.putNumber(6);

        Log.d(TAG, "onCreate: value after the change " + prefs.getNumber());

        TextView textview = (TextView) findViewById(R.id.tv);
        textview.setBackgroundColor(res.getColor(android.R.color.holo_blue_bright));
        textview.setText(date.getCurrentDate());
    }
}