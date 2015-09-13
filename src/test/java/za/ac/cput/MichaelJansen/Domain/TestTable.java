package za.ac.cput.MichaelJansen.Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MichaelJansen.conf.OrderFactory;
import za.ac.cput.MichaelJansen.conf.SalesItemFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 06/09/2015.
 */
public class TestTable
{


    SalesItem salesItem;

    private int menuItemId;
    private int tableId;
    private String extra;

    private Order order;
    private ArrayList<SalesItem> items;
    private String extras;


    Table table;

    private int seats;
    private List<Order> orders;
    private Boolean available;



    @Before
    public void setUp() throws Exception
    {
        menuItemId = 305;
        tableId = 3;
        extra = "Extra cheese";

        salesItem = SalesItemFactory.createSalesItem(menuItemId, tableId, extra);

        items = new ArrayList<SalesItem>();
        items.add(salesItem);
        extras = "extra hot sauce";

        order = OrderFactory.createOrder(items, extras);

        seats = 6;

        orders = new ArrayList<Order>();
        orders.add(order);

        available = true;
    }

    @Test
    public void testTableCreation() throws Exception
    {
        table = new Table.Builder(seats,orders,available).build();
        Assert.assertNotNull(table);
        Assert.assertEquals(6,table.getSeats());
        Assert.assertEquals("extra hot sauce",table.getOrders().get(0).getExtra());
    }


    @After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
