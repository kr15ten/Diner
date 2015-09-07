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
public class TestSale {

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

    Sale sale;
    private List<Order> orderItems;
    private Waiter waiter;
    private float tip;

    private String name;
    private String surname;
    private Salary salary;

    @Before
    public void setUp() throws Exception
    {

        id = 305;
        itemName = "Harold's hot sauce hamburger";
        description = "devilishly hot sauce for burgers that will set fire to many a mouth";
        type = "Burgers";
        price = 30.00f;
        optionalExtras = "Mayonaisse";

        items = new ArrayList<MenuItem>();
        items.add(menuItem);
        extras = "extra hot sauce";

        order = new Order.Builder(items,extras).build();

        orderItems = new ArrayList<Order>();
        orderItems.add(order);

        name = "Craeton";
        surname = "Lavish";
        salary = new Salary.Builder(1500.00f).build();

        waiter = new Waiter.Builder(name,surname,salary).build();

    }

    @Test
    public void testSaleCreation() throws Exception
    {
        sale = new Sale.Builder(waiter,orderItems,tip).build();
        Assert.assertNotNull(sale);
        Assert.assertEquals("extra hot sauce",sale.getItems().get(0).getExtra());
    }


    @After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
