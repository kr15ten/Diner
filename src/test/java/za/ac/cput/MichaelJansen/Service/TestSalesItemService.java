package za.ac.cput.MichaelJansen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.SalesItem;
import za.ac.cput.MichaelJansen.Repository.SalesItemRepository;
import za.ac.cput.MichaelJansen.conf.SalesItemFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class TestSalesItemService extends AbstractTestNGSpringContextTests{

    @Autowired
    SalesItemService service;

    int id;

    @Autowired
    private SalesItemRepository repository;

    SalesItem salesItem;

    private int menuItemId;
    private int tableId;
    private String extra;

    List<SalesItem> salesItems = new ArrayList<SalesItem>();

    //@Test
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

    //@Test(dependsOnMethods = "create")
    public void testGetSalesItems() throws Exception {
        salesItems = service.getSalesItems();
        Assert.assertEquals(1, salesItems.size());
    }

    //@Test(dependsOnMethods = "create")
    public void testGetSalesItem() throws Exception {
        salesItem = service.getSalesItem(id);

        Assert.assertEquals(extra,salesItem.getExtra());
    }

    //@AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }


}
