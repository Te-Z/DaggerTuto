package app.tez.daggertuto.di;

import javax.inject.Singleton;

import app.tez.daggertuto.base.TestDaggerTutoApplication;
import dagger.Component;

/**
 * Created by Terence Zafindratafa on 29/10/2018
 */
@Singleton
@Component(modules = {StorageModule.class, UtilsTestModule.class, AppModule.class})
public interface TestComponent extends  TutoComponent{

    void inject(TestDaggerTutoApplication application);
}
