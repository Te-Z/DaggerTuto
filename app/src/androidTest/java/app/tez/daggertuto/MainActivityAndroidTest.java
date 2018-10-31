package app.tez.daggertuto;




import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import app.tez.daggertuto.di.AndroidTestComponent;
import app.tez.daggertuto.di.AppModule;
import app.tez.daggertuto.di.DaggerAndroidTestComponent;
import app.tez.daggertuto.di.StorageModule;
import app.tez.daggertuto.di.UtilsTestModule;
import app.tez.daggertuto.utils.SharedPrefsUtils;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Terence Zafindratafa on 30/10/2018
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityAndroidTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setup(){
        DaggerTutoApplication app = (DaggerTutoApplication) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();

        AndroidTestComponent component = DaggerAndroidTestComponent.builder()
                .appModule(new AppModule(app))
                .storageModule(new StorageModule())
                .utilsTestModule(new UtilsTestModule())
                .build();
        app.tutoComponent = component;
        component.inject(this);
    }

    @Test
    public void isMainActivityOpening(){
        assertEquals(mActivityTestRule.getActivity().getClass().getName(), MainActivity.class.getName());
    }

    @Test
    public void isTheRightDateDisplaying(){
        onView(withId(R.id.activity_main_date)).check(matches(withText("Sat Oct 19 00:00:00 GMT+01:00 1991")));
    }

    @Test
    public void isTheRightEmailSaving(){
        // Before test
        SharedPrefsUtils prefsUtils = mActivityTestRule.getActivity().prefs;
        prefsUtils.saveCurrentEmail("elvis@hotmail.com");

        // Actual test
        onView(withId(R.id.activity_main_editText)).perform(typeText("hello@world.fr"));
        onView(withId(R.id.activity_main_button)).perform(click());
        onView(withId(R.id.activity_main_saved_email)).check(matches(withText("hello@world.fr")));
    }
}
