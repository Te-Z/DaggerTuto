package app.tez.daggertuto.di;

import javax.inject.Singleton;

import app.tez.daggertuto.MainActivityAndroidTest;
import dagger.Component;

/**
 * Created by Terence Zafindratafa on 29/10/2018
 */
@Singleton
@Component(modules = {StorageModule.class, UtilsTestModule.class, AppModule.class})
public interface AndroidTestComponent extends  TutoComponent{

    void inject(MainActivityAndroidTest test);
}
