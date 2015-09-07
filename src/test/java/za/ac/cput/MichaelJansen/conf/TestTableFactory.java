package za.ac.cput.MichaelJansen.conf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.Domain.Order;
import za.ac.cput.MichaelJansen.Domain.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 07/09/2015.
 */
public class TestTableFactory {
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

    Table table;

    private int tableId;

    private int seats;
    private List<Order> orders;
    private Boolean available;



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

        order = new Order.Builder(items,extras).build();

        tableId = 305;
        seats = 6;

        orders = new ArrayList<Order>();
        orders.add(order);

        available = true;
    }

    @Test
    public void testTableCreation() throws Exception
    {
        table = TableFactory.createTable(id,seats,orders,available);
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
