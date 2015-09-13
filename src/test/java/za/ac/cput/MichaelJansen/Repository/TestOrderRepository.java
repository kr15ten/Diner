package za.ac.cput.MichaelJansen.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.Order;
import za.ac.cput.MichaelJansen.Domain.SalesItem;
import za.ac.cput.MichaelJansen.conf.OrderFactory;
import za.ac.cput.MichaelJansen.conf.SalesItemFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 13/09/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestOrderRepository extends AbstractTestNGSpringContextTests {

    int id;

    @Autowired
    private OrderRepository repository;

    SalesItem salesItem;

    private int menuItemId;
    private int tableId;
    private String extra;

    private Order order;
    private ArrayList<SalesItem> items;
    private String extras;


    @Test
    public void create() throws Exception
    {
        menuItemId = 305;
        tableId = 3;
        extra = "Extra cheese";

        salesItem = SalesItemFactory.createSalesItem(menuItemId, tableId, extra);

        items = new ArrayList<SalesItem>();
        items.add(salesItem);
        extras = "extra hot sauce";

        order = OrderFactory.createOrder(items, extras);

        repository.save(order);
        id = order.getOrderId();

        Assert.assertNotNull(order.getOrderId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        order = repository.findOne(id);

        Assert.assertEquals(id, order.getOrderId());
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        order = new Order.Builder(extra).build();

        repository.save(order);
        id = order.getOrderId();
        order = repository.findOne(id);

        Assert.assertEquals(id,order.getOrderId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        order = repository.findOne(id);
        repository.delete(order);
        order = repository.findOne(id);
        Assert.assertNull(order);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }

}

