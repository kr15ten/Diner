package za.ac.cput.MichaelJansen.Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 06/09/2015.
 */
public class TestMenu {

    MenuItem menuItem;

    private int id;
    private String itemName;
    private String type;
    private String description;
    private float price;
    private String extras;

    Menu menu;
    ArrayList<MenuItem> menuItems;

        @Before
        public void setUp() throws Exception{
            id = 305;
            itemName = "Harold's hot sauce hamburger";
            description = "devilishly hot sauce for burgers that will set fire to many a mouth";
            type = "Burgers";
            price = 30.00f;
            extras = "Mayonaisse";

            menuItem = new MenuItem.Builder(id,itemName,type,description,price).extras(extras).build();
            menuItems = new ArrayList<MenuItem>();
            menuItems.add(menuItem);
        }

        @Test
        public void testShiftCreation() throws Exception{
            menu = new Menu.Builder(menuItems).build();
            Assert.assertNotNull(menu);
            Assert.assertEquals("Harold's hot sauce hamburger",menu.getMenuItems().get(0).getItemName());
        }

        @After
        public void tearDown() throws Exception{

        }
}
