package app.tez.daggertuto;

import android.app.Application;
import android.content.Context;

import androidx.test.runner.AndroidJUnitRunner;

/**
 * Created by Terence Zafindratafa on 30/10/2018
 */
public class TestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return super.newApplication(cl, AndroidTestDaggerTutoApplication.class.getName(), context);
    }
}
