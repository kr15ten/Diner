package za.ac.cput.MichaelJansen.conf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.Domain.Order;
import za.ac.cput.MichaelJansen.Domain.SalesItem;

import java.util.ArrayList;

/**
 * Created by Michael on 07/09/2015.
 */
public class TestOrderFactory {

    SalesItem salesItem;

    private int menuItemId;
    private int tableId;
    private String extra;

    private Order order;
    private ArrayList<SalesItem> items;
    private String extras;

    //@Before
    public void setUp() throws Exception
    {
        menuItemId = 305;
        tableId = 3;
        extra = "Extra cheese";

        salesItem = SalesItemFactory.createSalesItem(menuItemId,tableId,extra);

        items = new ArrayList<SalesItem>();
        items.add(salesItem);
        extras = "extra hot sauce";

        order = OrderFactory.createOrder(items,extras);
    }

    //@Test
    public void createOrder() throws Exception
    {
        Assert.assertNotNull(order);
        Assert.assertEquals(order.getItems().get(0).getMenuItemId(),305);
        Assert.assertEquals(order.getExtra(), extras);
    }

    //@After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
