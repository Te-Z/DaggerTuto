package app.tez.daggertuto;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        final TextView textview = (TextView) findViewById(R.id.tv);
        textview.setText(dateUtils.getCurrentDate().toString());

        final EditText email = (EditText) findViewById(R.id.activity_main_editText);
        Button saveBtn = (Button) findViewById(R.id.activity_main_button);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String savedEmail = email.getText().toString();
                prefs.saveCurrentEmail(savedEmail);
                textview.setText(prefs.getCurrentEmail());
            }
        });
    }
}