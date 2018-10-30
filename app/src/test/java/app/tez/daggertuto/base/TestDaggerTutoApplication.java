package app.tez.daggertuto.base;

import app.tez.daggertuto.DaggerTutoApplication;
import app.tez.daggertuto.di.AppModule;
import app.tez.daggertuto.di.DaggerTestComponent;
import app.tez.daggertuto.di.StorageTestModule;
import app.tez.daggertuto.di.TestComponent;
import app.tez.daggertuto.di.TutoComponent;
import app.tez.daggertuto.di.UtilsTestModule;

/**
 * Created by Terence Zafindratafa on 25/10/2018
 */
public class TestDaggerTutoApplication extends DaggerTutoApplication {

    @Override
    public TutoComponent getTutoComponent() {
        TestComponent mComponent = DaggerTestComponent.builder()
                .appModule(new AppModule(this))
                .utilsTestModule(new UtilsTestModule())
                .storageTestModule(new StorageTestModule())
                .build();

        mComponent.inject(this);

        return mComponent;
    }
}
