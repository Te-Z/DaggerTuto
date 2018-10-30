package app.tez.daggertuto;

import android.app.Application;

import java.util.Calendar;

import app.tez.daggertuto.di.AppModule;
import app.tez.daggertuto.di.DaggerTutoComponent;
import app.tez.daggertuto.di.StorageModule;
import app.tez.daggertuto.di.UtilsModule;
import app.tez.daggertuto.di.TutoComponent;

public class DaggerTutoApplication extends Application {

    TutoComponent tutoComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        tutoComponent = DaggerTutoComponent.builder()
                .appModule(new AppModule(this))
                .storageModule(new StorageModule())
                .utilsModule(new UtilsModule())
                .build();

        tutoComponent.inject(this);
    }

    public TutoComponent getTutoComponent() { return tutoComponent; }
}
