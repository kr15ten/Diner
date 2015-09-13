package za.ac.cput.MichaelJansen.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.conf.MenuItemFactory;

import java.util.ArrayList;

/**
 * Created by Michael on 13/09/2015.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestMenuItemRepository extends AbstractTestNGSpringContextTests {

    @Autowired
    private MenuItemRepository repository;

    MenuItem menuItem;

    private int id;
    private String itemName;
    private String type;
    private String description;
    private float price;
    private String extras;

    @Test
    public void create() throws Exception
    {

        id = 305;
        itemName = "Harold's hot sauce hamburger";
        description = "devilishly hot sauce for burgers that will set fire to many a mouth";
        type = "Burgers";
        price = 30.00f;
        extras = "Mayonaisse";

        menuItem = new MenuItem.Builder(id,itemName,type,description,price).extras(extras).build();

        repository.save(menuItem);
        id = menuItem.getId();

        Assert.assertNotNull(menuItem.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        menuItem = repository.findOne(id);

        Assert.assertEquals(id, menuItem.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        menuItem = MenuItemFactory.createMenuItem(id, itemName, type, description, price, extras);

        repository.save(menuItem);
        id = menuItem.getId();
        menuItem = repository.findOne(id);

        Assert.assertEquals(id, menuItem.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        menuItem = repository.findOne(id);
        repository.delete(menuItem);
        menuItem = repository.findOne(id);
        Assert.assertNull(menuItem);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}

