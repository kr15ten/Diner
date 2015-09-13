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
    int id;

    Sale sale;
    int waiterId;
    int tableId;
    float tip;

    @Test
    public void create() throws Exception
    {

        waiterId = 1;
        tableId = 1;
        tip = 150.00f;

        sale = SaleFactory.createSale(tableId,waiterId,tip);

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
        Sale newSale = SaleFactory.createSale(2,waiterId,tip);

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
