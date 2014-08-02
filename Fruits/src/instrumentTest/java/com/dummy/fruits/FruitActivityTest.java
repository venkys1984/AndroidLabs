package com.dummy.fruits;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.dummy.fruits.FruitActivityTest \
 * com.dummy.fruits.tests/android.test.InstrumentationTestRunner
 */
public class FruitActivityTest extends ActivityInstrumentationTestCase2<FruitActivity> {

    public FruitActivityTest() {
        super("com.dummy.fruits", FruitActivity.class);
    }

}
