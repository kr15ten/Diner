package za.ac.cput.MichaelJansen.conf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.Domain.Order;

import java.util.ArrayList;

/**
 * Created by Michael on 07/09/2015.
 */
public class TestOrderFactory {

    MenuItem menuItem;

    private int id;
    private String itemName;
    private String type;
    private String description;
    private float price;
    private String optionalExtras;

    private Order order;
    private ArrayList<MenuItem> items;
    private String extras;

    @Before
    public void setUp() throws Exception
    {
        id = 305;
        itemName = "Harold's hot sauce hamburger";
        description = "devilishly hot sauce for burgers that will set fire to many a mouth";
        type = "Burgers";
        price = 30.00f;
        optionalExtras = "Mayonaisse";

        menuItem = new MenuItem.Builder(id,itemName,type,description,price).build();

        items = new ArrayList<MenuItem>();
        items.add(menuItem);
        extras = "extra hot sauce";

        order = OrderFactory.createOrder(items,extras);
    }

    @Test
    public void createOrder() throws Exception
    {
        Assert.assertNotNull(order);
        Assert.assertEquals(order.getItems().get(0).getId(),305);
        Assert.assertEquals(order.getExtra(), extras);
    }

    @After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
