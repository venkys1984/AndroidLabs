package dummy.surface.view;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class dummy.surface.view.MovieActivityTest \
 * dummy.surface.view.tests/android.test.InstrumentationTestRunner
 */
public class MovieActivityTest extends ActivityInstrumentationTestCase2<MovieActivity> {

    public MovieActivityTest() {
        super("dummy.surface.view", MovieActivity.class);
    }

}
