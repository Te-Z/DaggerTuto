package app.tez.daggertuto.di;

import javax.inject.Singleton;

import app.tez.daggertuto.AndroidTestDaggerTutoApplication;
import dagger.Component;

/**
 * Created by Terence Zafindratafa on 29/10/2018
 */
@Singleton
@Component(modules = {StorageTestModule.class, UtilsTestModule.class, AppModule.class})
public interface AndroidTestComponent extends  TutoComponent{

    void inject(AndroidTestDaggerTutoApplication application);
}
