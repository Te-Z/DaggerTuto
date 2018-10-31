package app.tez.daggertuto;

import app.tez.daggertuto.DaggerTutoApplication;
import app.tez.daggertuto.di.AndroidTestComponent;
import app.tez.daggertuto.di.AppModule;
import app.tez.daggertuto.di.DaggerAndroidTestComponent;
import app.tez.daggertuto.di.StorageTestModule;
import app.tez.daggertuto.di.TutoComponent;
import app.tez.daggertuto.di.UtilsTestModule;

/**
 * Created by Terence Zafindratafa on 25/10/2018
 */
public class AndroidTestDaggerTutoApplication extends DaggerTutoApplication {

    @Override
    public TutoComponent getTutoComponent() {
        AndroidTestComponent mComponent = DaggerAndroidTestComponent.builder()
                .appModule(new AppModule(this))
                .utilsTestModule(new UtilsTestModule())
                .storageTestModule(new StorageTestModule())
                .build();

        mComponent.inject(this);

        return mComponent;
    }
}
