package app.tez.daggertuto;

import android.app.Application;

public class DaggerTutoApplication extends Application {

    TutoComponent tutoComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        tutoComponent = DaggerTutoComponent.builder().prefModule(new PrefModule(this)).build();

        tutoComponent.inject(this);
    }

    public TutoComponent getTutoComponent() { return tutoComponent; }
}
