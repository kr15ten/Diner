package za.ac.cput.MichaelJansen.conf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MichaelJansen.Domain.MenuItem;

/**
 * Created by Michael on 07/09/2015.
 */
public class TestMenuItemFactory {
    MenuItem menuItem;

    private int id;
    private String itemName;
    private String type;
    private String description;
    private float price;
    private String extras;

    //@Before
    public void setUp() throws Exception {
        id = 305;
        itemName = "Harold's hot sauce hamburger";
        description = "devilishly hot sauce for burgers that will set fire to many a mouth";
        type = "Burgers";
        price = 30.00f;
        extras = "Mayonaisse";
    }

    //@Test
    public void testMenuItemCreation()
    {
        menuItem = MenuItemFactory.createMenuItem(id,itemName,type,description,price,extras);
        Assert.assertNotNull(menuItem);
        Assert.assertEquals(id,305);
    }

    //@After
    public void tearDown() throws Exception{

    }
}
