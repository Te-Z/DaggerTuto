package app.tez.daggertuto.base

import app.tez.daggertuto.DaggerTutoApplication
import app.tez.daggertuto.di.DaggerTutoComponent
import app.tez.daggertuto.di.UtilsModule
import app.tez.daggertuto.di.StorageModule
import app.tez.daggertuto.di.TutoComponent
import java.util.*

/**
 * Created by Terence Zafindratafa on 29/10/2018
 */
class InstTestDaggerTutoApplication: DaggerTutoApplication() {

    lateinit var component: TutoComponent

    override fun onCreate() {
        super.onCreate()

        val cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, 19)
        cal.set(Calendar.MONTH, Calendar.SEPTEMBER)
        cal.set(Calendar.YEAR, 1991)

        component = DaggerTutoComponent.builder()
                .prefModule(StorageModule(this))
                .dateModule(UtilsModule(cal))
                .build()
    }

    override fun getTutoComponent(): TutoComponent = component
}