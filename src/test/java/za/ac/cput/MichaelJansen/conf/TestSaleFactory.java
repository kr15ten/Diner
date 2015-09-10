package za.ac.cput.MichaelJansen.conf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MichaelJansen.Domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 07/09/2015.
 */
public class TestSaleFactory {

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
    private List<Order> orders;
    private int waiterId;
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

        orders = new ArrayList<Order>();
        orders.add(order);

        name = "Craeton";
        surname = "Lavish";
        salary = new Salary.Builder(1500.00f).build();

        waiterId = 1;

    }

    @Test
    public void testSaleCreation() throws Exception
    {
        sale = SaleFactory.createSale(orders,waiterId,tip);
        Assert.assertNotNull(sale);
        Assert.assertEquals("extra hot sauce",sale.getOrders().get(0).getExtra());
    }


    @After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
