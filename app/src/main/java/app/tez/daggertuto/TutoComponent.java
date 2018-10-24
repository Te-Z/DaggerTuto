package app.tez.daggertuto;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PrefModule.class})
public interface TutoComponent {

    void inject(DaggerTutoApplication application);

    void inject(MainActivity mainActivity);
}
