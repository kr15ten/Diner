package za.ac.cput.MichaelJansen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.Domain.Order;
import za.ac.cput.MichaelJansen.Domain.SalesItem;
import za.ac.cput.MichaelJansen.Repository.MenuItemRepository;
import za.ac.cput.MichaelJansen.Repository.OrderRepository;
import za.ac.cput.MichaelJansen.conf.OrderFactory;
import za.ac.cput.MichaelJansen.conf.SalesItemFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */

//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class TestOrderService extends AbstractTestNGSpringContextTests {

    @Autowired
    OrderService service;

    int id;

    @Autowired
    private OrderRepository repository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    MenuItem menuItem;

    private String itemName;
    private String type;
    private String description;
    private float price;

    SalesItem salesItem;

    private int menuItemId;
    private int tableId;
    private String extra;

    private Order order;
    private ArrayList<SalesItem> items;
    private String extras;

    List<Order> orders = new ArrayList<Order>();

    List<MenuItem> menuItems = new ArrayList<MenuItem>();

    //@Test
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

        id = 305;
        itemName = "Harold's hot sauce hamburger";
        description = "devilishly hot sauce for burgers that will set fire to many a mouth";
        type = "Burgers";
        price = 30.00f;

        menuItem = new MenuItem.Builder(id,itemName,type,description,price).build();

        menuItemRepository.save(menuItem);

        Assert.assertNotNull(menuItem.getId());

        Assert.assertNotNull(order.getOrderId());
    }

    //@Test(dependsOnMethods = "create")
    public void testGetOrders() throws Exception {
        orders = service.getOrders();
        Assert.assertEquals(1, orders.size());
    }

    //@Test(dependsOnMethods = "create")
    public void testGetOrder() throws Exception {

        order = service.getOrder(order.getOrderId());

        Assert.assertEquals(extras,order.getExtra());
    }

    //@Test(dependsOnMethods = "create")
    public void testGetOrderedItems() throws Exception{
         menuItems = service.getOrderedMenuItems(order.getOrderId());

        Assert.assertEquals(1,menuItems.size());
    }

    //@AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
