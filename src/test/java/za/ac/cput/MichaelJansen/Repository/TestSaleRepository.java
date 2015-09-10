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
import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.conf.SaleFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 08/09/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestSaleRepository extends AbstractTestNGSpringContextTests {

    @Autowired
    private SaleRepository repository;

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


    @Test
    public void create() throws Exception
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

        sale = SaleFactory.createSale(orders,waiterId,tip);

        repository.save(sale);
        id = sale.getId();

        Assert.assertNotNull(sale.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Sale sale1 = repository.findOne(id);

        Assert.assertEquals(id, sale1.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Sale newSale = SaleFactory.createSale(orders,waiterId,tip);

        repository.save(newSale);
        id = newSale.getId();
        Sale updatedSale = repository.findOne(id);

        Assert.assertEquals(id, updatedSale.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Sale sale2 = repository.findOne(id);
        repository.delete(sale2);
        Sale newerSale = repository.findOne(id);
        Assert.assertNull(newerSale);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
