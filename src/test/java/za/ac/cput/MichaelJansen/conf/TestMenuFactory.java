package za.ac.cput.MichaelJansen.conf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MichaelJansen.Domain.Menu;
import za.ac.cput.MichaelJansen.Domain.MenuItem;

import java.util.ArrayList;

/**
 * Created by Michael on 07/09/2015.
 */
public class TestMenuFactory {
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
        menu = MenuFactory.createMenu(menuItems);
        Assert.assertNotNull(menu);
        Assert.assertEquals("Harold's hot sauce hamburger",menu.getMenuItems().get(0).getItemName());
    }

    @After
    public void tearDown() throws Exception{

    }
}
