package app.tez.daggertuto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import app.tez.daggertuto.utils.DateUtils;
import app.tez.daggertuto.utils.SharedPrefsUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView dateTv, emailTv;

    @Inject SharedPrefsUtils prefs;
    @Inject DateUtils dateUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.configureDI();
        this.setCurrentDate();
        this.setEmailForm();
    }

    private void configureDI(){
        ((DaggerTutoApplication) getApplication()).getTutoComponent().inject(this);
    }

    private void setCurrentDate(){
        dateTv = (TextView) findViewById(R.id.activity_main_date);
        dateTv.setText(dateUtils.getCurrentDate().toString());
    }

    private void setEmailForm(){
        emailTv = (TextView) findViewById(R.id.activity_main_saved_email);
        final EditText email = (EditText) findViewById(R.id.activity_main_editText);
        Button saveBtn = (Button) findViewById(R.id.activity_main_button);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String savedEmail = email.getText().toString();
                prefs.saveCurrentEmail(savedEmail);
                emailTv.setText(prefs.getCurrentEmail());
            }
        });
    }
}