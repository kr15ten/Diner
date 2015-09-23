package za.ac.cput.MichaelJansen.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.*;
import za.ac.cput.MichaelJansen.conf.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Michael on 08/09/2015.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class TestTableRepository extends AbstractTestNGSpringContextTests {

    int id;

    @Autowired
    private TableRepository repository;

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

        seats = 6;

        orders = new ArrayList<Order>();
        orders.add(order);

        available = true;

        table = new Table.Builder(seats,available).build();

        repository.save(table);
        id = table.getId();

        Assert.assertNotNull(table.getId());
    }

    //@Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        table = repository.findOne(id);

        Assert.assertEquals(id, table.getId());
    }


    //@Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Table newTable = new Table.Builder(seats,false).build();

        repository.save(newTable);
        id = newTable.getId();
        Table updatedTable = repository.findOne(id);

        Assert.assertEquals(id, updatedTable.getId());
    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        table = repository.findOne(id);
        repository.delete(table);
        Table newerTable = repository.findOne(id);
        Assert.assertNull(newerTable);
    }

    //@AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }

}
