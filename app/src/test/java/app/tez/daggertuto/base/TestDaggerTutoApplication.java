package app.tez.daggertuto.base;

import java.util.Calendar;

import app.tez.daggertuto.DaggerTutoApplication;
import app.tez.daggertuto.di.DaggerTutoComponent;
import app.tez.daggertuto.di.DateModule;
import app.tez.daggertuto.di.PrefModule;
import app.tez.daggertuto.di.TutoComponent;

/**
 * Created by Terence Zafindratafa on 25/10/2018
 */
public class TestDaggerTutoApplication extends DaggerTutoApplication {

    TutoComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.DAY_OF_MONTH, 19);
        mCalendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
        mCalendar.set(Calendar.YEAR, 1991);

        mComponent = DaggerTutoComponent.builder()
                .prefModule(new PrefModule(this))
                .dateModule(new DateModule(mCalendar))
                .build();
    }

    @Override
    public TutoComponent getTutoComponent() {
        return mComponent;
    }
}
