package za.ac.cput.MichaelJansen.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.*;
import za.ac.cput.MichaelJansen.conf.MenuFactory;
import za.ac.cput.MichaelJansen.conf.MenuItemFactory;
import za.ac.cput.MichaelJansen.conf.TableFactory;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Michael on 08/09/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestTableRepository extends AbstractTestNGSpringContextTests {

    @Autowired
    private TableRepository repository;

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

    private int seats;
    private List<Order> orders;
    private Boolean available;


    @Test
    public void create() throws Exception
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

        seats = 6;

        orders = new ArrayList<Order>();
        orders.add(order);

        available = true;

        table = TableFactory.createTable(seats, orders, available);

        repository.save(table);
        id = table.getId();

        Assert.assertNotNull(table.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        table = repository.findOne(id);

        Assert.assertEquals(id, table.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        items.remove(0);
        items.add(MenuItemFactory.createMenuItem(306, itemName, type, description, price, extras));
        Table newTable = table = TableFactory.createTable(seats, orders, available);

        repository.save(table);
        id = newTable.getId();
        Table updatedTable = repository.findOne(id);

        Assert.assertEquals(id, updatedTable.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        table = repository.findOne(id);
        repository.delete(table);
        Table newerTable = repository.findOne(id);
        Assert.assertNull(newerTable);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }

}
