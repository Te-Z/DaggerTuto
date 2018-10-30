package app.tez.daggertuto.di;

import javax.inject.Singleton;

import app.tez.daggertuto.utils.DateUtils;
import app.tez.daggertuto.utils.DateUtilsTest;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Terence Zafindratafa on 24/10/2018
 */

@Module
public class UtilsTestModule {

    @Provides
    @Singleton
    public DateUtils provideDateUtils(){
        return new DateUtilsTest();
    }
}
