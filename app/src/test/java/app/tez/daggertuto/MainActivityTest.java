package app.tez.daggertuto;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import app.tez.daggertuto.base.TestDaggerTutoApplication;
import app.tez.daggertuto.utils.SharedPrefsUtils;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Terence Zafindratafa on 24/10/2018
 */

@RunWith(RobolectricTestRunner.class)
@Config(application = TestDaggerTutoApplication.class)
public class MainActivityTest {

    private MainActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void shouldShowProperDate() throws Exception {
        TextView date = (TextView) activity.findViewById(R.id.activity_main_textview);
        assertEquals("Sat Oct 19 00:00:00 CET 1991", date.getText());
    }

    @Test
    public void shouldStoreProperEmail() throws Exception {
        SharedPrefsUtils prefsUtils = activity.prefs;
        prefsUtils.saveCurrentEmail("test@hotmail.com");
        assertEquals("test@hotmail.com", prefsUtils.getCurrentEmail());
    }
}
