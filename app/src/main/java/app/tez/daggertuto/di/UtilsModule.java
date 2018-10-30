package app.tez.daggertuto.di;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Singleton;

import app.tez.daggertuto.utils.DateUtils;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Terence Zafindratafa on 24/10/2018
 */

@Module
public class UtilsModule {

    @Provides
    @Singleton
    public DateUtils provideDateUtils(){
        return new DateUtils();
    }
}
