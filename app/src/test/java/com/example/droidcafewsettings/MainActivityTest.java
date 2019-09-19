package com.example.droidcafewsettings;


import static org.hamcrest.CoreMatchers.equalTo;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowToast;

import android.widget.ImageView;

@RunWith(RobolectricTestRunner.class)

public class MainActivityTest {

    private MainActivity activity;


    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void activityIsNotNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void testFroyoItem() throws Exception {
        assertNotNull(activity);

        // Getting the item froyo by id
        ImageView itemFroyo = (ImageView) activity.findViewById(R.id.froyo);

        // Performing click on Froyo Image
        itemFroyo.performClick();

        // Comparing the Toast Message
        assertThat(ShadowToast.getTextOfLatestToast().toString(), equalTo("You ordered a FroYo."));
    }


}
