package za.ac.cput.MichaelJansen.Service;

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
import za.ac.cput.MichaelJansen.Domain.Table;
import za.ac.cput.MichaelJansen.Repository.TableRepository;
import za.ac.cput.MichaelJansen.conf.OrderFactory;
import za.ac.cput.MichaelJansen.conf.SalesItemFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestTableService extends AbstractTestNGSpringContextTests {

    @Autowired
    TableService service;

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

    List<Table> tables = new ArrayList<Table>();

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

        seats = 6;

        orders = new ArrayList<Order>();
        orders.add(order);

        available = true;

        table = new Table.Builder(seats,available).build();

        repository.save(table);
        id = table.getId();

        Assert.assertNotNull(table.getId());
    }

    @Test(dependsOnMethods = "create")
    public void testGetTables() throws Exception {
        tables = service.getTables();
        Assert.assertEquals(1, tables.size());
    }

    @Test(dependsOnMethods = "create")
    public void testGetTable() throws Exception {
        table = service.getTable(id);

        Assert.assertEquals(seats,table.getSeats());
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }

}
