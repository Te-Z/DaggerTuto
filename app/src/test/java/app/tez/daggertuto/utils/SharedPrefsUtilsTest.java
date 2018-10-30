package app.tez.daggertuto.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Terence Zafindratafa on 29/10/2018
 */
public class SharedPrefsUtilsTest extends SharedPrefsUtils {

    private static final String MY_PREF = "MY_PREF";
    private static final String KEY_CURRENT_EMAIL = "KEY_CURRENT_EMAIL";
    private SharedPreferences prefs;

    public SharedPrefsUtilsTest(Context context) {
        super(context);
        prefs = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        saveCurrentEmail("jon_snow@gmail.com");
    }

    public void saveCurrentEmail(String email){
        prefs.edit().putString(KEY_CURRENT_EMAIL, email).apply();
    }

    public String getCurrentEmail(){
        return prefs.getString(KEY_CURRENT_EMAIL, "");
    }
}
