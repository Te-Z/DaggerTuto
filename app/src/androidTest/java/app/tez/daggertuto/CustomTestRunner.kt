package app.tez.daggertuto

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.os.StrictMode
import androidx.test.runner.AndroidJUnitRunner
import app.tez.daggertuto.base.InstTestDaggerTutoApplication

/**
 * Created by Terence Zafindratafa on 29/10/2018
 */
class CustomTestRunner: AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle?) {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        super.onCreate(arguments)
    }

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, InstTestDaggerTutoApplication::class.java.name, context)
    }
}