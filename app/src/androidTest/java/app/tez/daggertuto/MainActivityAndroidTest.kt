package app.tez.daggertuto



import android.support.test.runner.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import app.tez.daggertuto.base.InstTestDaggerTutoApplication
import app.tez.daggertuto.di.DaggerTutoComponent
import app.tez.daggertuto.di.UtilsModule
import app.tez.daggertuto.di.StorageModule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

/**
 * Created by Terence Zafindratafa on 26/10/2018
 */

private const val MATCHING_DATE = "19/09/1991"

@RunWith(AndroidJUnit4::class)
class MainActivityAndroidTest {

    @Rule
    val activityMainTestRule: ActivityTestRule<MainActivity> = object: ActivityTestRule<MainActivity>(MainActivity::class.java){
        override fun beforeActivityLaunched() {
            val myApp = InstrumentationRegistry.getInstrumentation().targetContext as InstTestDaggerTutoApplication

            val cal = Calendar.getInstance()
            cal.set(Calendar.DAY_OF_MONTH, 19)
            cal.set(Calendar.MONTH, Calendar.SEPTEMBER)
            cal.set(Calendar.YEAR, 1991)

            val component = DaggerTutoComponent.builder()
                    .appModule(myApp)
                    .build()

            myApp.component = component
        }
    }

    /*@Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        val myApp = InstrumentationRegistry
                .getInstrumentation()
                .targetContext
                .applicationContext as InstTestDaggerTutoApplication

        val cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, 19)
        cal.set(Calendar.MONTH, Calendar.SEPTEMBER)
        cal.set(Calendar.YEAR, 1991)

        val component = DaggerTutoComponent.builder()
                .prefModule(StorageModule(myApp))
                .dateModule(UtilsModule(cal))
                .build()

        myApp.component = component
    }*/

    @Test
    fun shouldShowProperDate(){
        onView(withId(R.id.tv)).perform(click())
        onView(withId(R.id.tv)).check(matches(withText(MATCHING_DATE)))
    }


}