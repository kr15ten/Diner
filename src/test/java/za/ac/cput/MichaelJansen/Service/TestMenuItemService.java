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
import za.ac.cput.MichaelJansen.Repository.MenuItemRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestMenuItemService extends AbstractTestNGSpringContextTests {

    @Autowired
    MenuItemService service;

    int id;

    @Autowired
    private MenuItemRepository repository;

    MenuItem menuItem;

    private String itemName;
    private String type;
    private String description;
    private float price;
    private String extras;

    List<MenuItem> menuItems = new ArrayList<MenuItem>();

    @Test
    public void create() throws Exception {

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
    public void testGetMenuItems() throws Exception {
        menuItems = service.getMenuItems();
        Assert.assertEquals(1, menuItems.size());
    }

    @Test(dependsOnMethods = "create")
    public void testGetMenuItem() throws Exception {
        menuItem = service.getMenuItem(id);

        Assert.assertEquals(extras,menuItem.getExtras());
    }

    @Test(dependsOnMethods = "create")
    public void testGetType() throws Exception{
        menuItems = service.getType("Burgers");

        Assert.assertEquals(1,menuItems.size());
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
