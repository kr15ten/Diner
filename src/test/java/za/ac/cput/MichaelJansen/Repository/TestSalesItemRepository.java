package za.ac.cput.MichaelJansen.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
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
public class TestSalesItemRepository  extends AbstractTestNGSpringContextTests {
    int id;

    @Autowired
    private SalesItemRepository repository;

    SalesItem salesItem;

    private int menuItemId;
    private int tableId;
    private String extra;

    @Test
    public void create() throws Exception
    {
        menuItemId = 305;
        tableId = 3;
        extra = "Extra cheese";

        salesItem = SalesItemFactory.createSalesItem(menuItemId, tableId, extra);

        repository.save(salesItem);
        id = salesItem.getId();

        Assert.assertNotNull(salesItem.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        salesItem = repository.findOne(id);

        Assert.assertEquals(id, salesItem.getId());
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        SalesItem newSalesItem = new SalesItem.Builder(menuItemId, 4).extra(extra).build();

        repository.save(newSalesItem);
        id = newSalesItem.getId();
        SalesItem updatedSalesItem = repository.findOne(id);

        Assert.assertEquals(id, updatedSalesItem.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        salesItem = repository.findOne(id);
        repository.delete(salesItem);
        salesItem = repository.findOne(id);
        Assert.assertNull(salesItem);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }


}
