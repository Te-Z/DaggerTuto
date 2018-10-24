package app.tez.daggertuto;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Inject SharedPreferences prefs;
    @Inject Context context;
    @Inject Resources res;

    private TextView mTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DaggerTutoApplication) getApplication()).getTutoComponent().inject(this);

        Log.d(TAG, "onCreate: value before the change "+ prefs.getInt("Number", 0));

        prefs.edit().putInt("Number", 6).apply();

        Log.d(TAG, "onCreate: value after the change "+ prefs.getInt("Number", 0));

        mTextview = (TextView) findViewById(R.id.tv);
        mTextview.setBackgroundColor(res.getColor(android.R.color.darker_gray));
    }
}
