package app.tez.daggertuto;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PrefModule {
    public static final String MY_PREF = "MY_PREF";
    private final DaggerTutoApplication application;

    public PrefModule(DaggerTutoApplication app) {this.application = app; }

    @Provides
    @Singleton
    public Context providesApplicationContext(){ return application; }

    @Provides
    @Singleton
    public SharedPreferences providesSharedPreferences(Context app) {
        return app.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
    }

    @Provides
    public Resources providesResources(){
        return application.getResources();
    }
}
