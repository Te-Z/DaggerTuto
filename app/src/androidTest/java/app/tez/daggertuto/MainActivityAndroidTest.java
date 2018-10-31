package app.tez.daggertuto;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import app.tez.daggertuto.utils.SharedPrefsUtils;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Terence Zafindratafa on 30/10/2018
 */
public class MainActivityAndroidTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void isMainActivityOpen(){
        assertEquals(mActivityTestRule.getActivity().getClass().getName(), MainActivity.class.getName());
        SharedPrefsUtils utils = mActivityTestRule.getActivity().prefs;
        utils.saveCurrentEmail("coucou");
    }
}
