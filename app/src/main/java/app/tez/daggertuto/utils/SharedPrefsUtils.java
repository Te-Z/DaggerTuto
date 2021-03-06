package app.tez.daggertuto.utils;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by Terence Zafindratafa on 24/10/2018
 */
public class SharedPrefsUtils {

    private static final String MY_PREF = "MY_PREF";
    private static final String KEY_CURRENT_EMAIL = "KEY_CURRENT_EMAIL";
    private SharedPreferences prefs;

    public SharedPrefsUtils(Context context){
        prefs = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
    }

    public void saveCurrentEmail(String email){
        prefs.edit().putString(KEY_CURRENT_EMAIL, email).apply();
    }

    public String getCurrentEmail(){
        return prefs.getString(KEY_CURRENT_EMAIL, "");
    }
}
