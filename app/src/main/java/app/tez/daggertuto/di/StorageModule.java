package app.tez.daggertuto.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import javax.inject.Singleton;

import app.tez.daggertuto.DaggerTutoApplication;
import app.tez.daggertuto.utils.SharedPrefsUtils;
import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {

    @Provides
    @Singleton
    public SharedPrefsUtils providesSharedPreferences(Context app) {
        return new SharedPrefsUtils(app);
    }
}
