package app.tez.daggertuto.utils;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by Terence Zafindratafa on 24/10/2018
 */
public class SharedPrefsUtils {

    private static final String NUMBER = "NUMBER";
    private SharedPreferences prefs;

    @Inject
    public SharedPrefsUtils(SharedPreferences sharedPreferences){
        prefs = sharedPreferences;
    }

    public void putNumber(int nb){
        prefs.edit().putInt(NUMBER, nb).apply();
    }

    public int getNumber(){
        return prefs.getInt(NUMBER, 0);
    }
}
