package app.tez.daggertuto.di;

import android.content.Context;

import javax.inject.Singleton;

import app.tez.daggertuto.utils.SharedPrefsUtils;
import app.tez.daggertuto.utils.SharedPrefsUtilsTest;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Terence Zafindratafa on 30/10/2018
 */
@Module
public class StorageTestModule{

    @Provides
    @Singleton
    public SharedPrefsUtils providesSharedPreferences(Context app) {
        return new SharedPrefsUtilsTest(app);
    }
}