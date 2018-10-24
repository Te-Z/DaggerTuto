package app.tez.daggertuto.di;

import javax.inject.Singleton;

import app.tez.daggertuto.DaggerTutoApplication;
import app.tez.daggertuto.MainActivity;
import dagger.Component;

@Singleton
@Component(modules = {PrefModule.class, DateModule.class})
public interface TutoComponent {

    void inject(DaggerTutoApplication application);

    void inject(MainActivity mainActivity);
}
