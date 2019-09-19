// Activity #4 - Android testing with RoboElectric
// Siva Prasad Uppalapati - C0744659
// Manoj Kumar Goud Anapurapu - C0743896

package com.example.droidcafewsettings;


import static org.hamcrest.CoreMatchers.equalTo;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowToast;

import android.support.design.widget.FloatingActionButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

@RunWith(RobolectricTestRunner.class)

public class MainActivityTest {

    private MainActivity activity;
    private OrderActivity cartPage;


    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    // Siva Prasad Uppalapati - C0744659
    // Manoj Kumar Goud Anapurapu - C0743896

    @Test
    public void activityIsNotNull() throws Exception {
        assertNotNull(activity);
    }

    // Siva Prasad Uppalapati - C0744659
    // Manoj Kumar Goud Anapurapu - C0743896
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

    // Siva Prasad Uppalapati - C0744659
    // Manoj Kumar Goud Anapurapu - C0743896
    @Test
    public void testShoppingCartPage() throws Exception{

        // Getting the OrderActivity page by id
        FloatingActionButton cartIcon = (FloatingActionButton) activity.findViewById(R.id.fab);

        // Performing Click to open shopping cart page
        cartIcon.performClick();

        // Starting OrderActivity page
        cartPage = Robolectric.buildActivity(OrderActivity.class)
                .create()
                .resume()
                .get();

        // Getting the name field and adding name
        EditText name = (EditText) cartPage.findViewById(R.id.name_text);
        name.setText("SivaPrasad Uppalapati");

        // Getting the address field and adding the address
        EditText address = (EditText) cartPage.findViewById(R.id.address_text);
        address.setText("35 Benroyal Crescent");

        // Getting the phone field and adding phone number
        EditText Phone = (EditText) cartPage.findViewById(R.id.phone_text);
        Phone.setText("4379883339");

        // Getting the Note field and adding note
        EditText note = (EditText) cartPage.findViewById(R.id.note_text);
        note.setText("Please call me when you arrive for delivery");

        // Selecting the radio button
        RadioButton sday = (RadioButton) cartPage. findViewById(R.id.sameday);
        sday.setChecked(true);

        // Saving the data
        Button saveCustinfo = (Button) cartPage.findViewById(R.id.saveButton);
        saveCustinfo.performClick();

        // Going to Main Activity
        cartPage.onBackPressed();

        // Performing the click on the cart Icon to check the data.
        cartIcon.performClick();

        // Comparing the Expected and Actuals
        assertThat(name.getText().toString(),equalTo("SivaPrasad Uppalapati"));
        assertThat(address.getText().toString(),equalTo("35 Benroyal Crescent"));
        assertThat(Phone.getText().toString(),equalTo("4379883339"));
        assertThat(note.getText().toString(),equalTo("Please call me when you arrive for delivery"));
        assertTrue(sday.isChecked());

    }


}
