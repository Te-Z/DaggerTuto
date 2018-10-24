package app.tez.daggertuto.di;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Terence Zafindratafa on 24/10/2018
 */

@Module
public class DateModule {

    private final Calendar cal;

    public DateModule(Calendar cal) { this.cal = cal; }

    @Provides
    @Singleton
    public Date providesCurrentDate(){ return cal.getTime(); }
}
