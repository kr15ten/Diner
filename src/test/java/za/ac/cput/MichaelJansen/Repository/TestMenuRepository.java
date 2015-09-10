package za.ac.cput.MichaelJansen.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.Menu;
import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.conf.MenuFactory;
import za.ac.cput.MichaelJansen.conf.MenuItemFactory;

import java.util.ArrayList;

/**
 * Created by Michael on 08/09/2015.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestMenuRepository extends AbstractTestNGSpringContextTests {

    @Autowired
    private MenuRepository repository;

    Menu menu;

    MenuItem menuItem;

    private int id;
    private String itemName;
    private String type;
    private String description;
    private float price;
    private String extras;

    ArrayList<MenuItem> menuItems;

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
        menuItems = new ArrayList<MenuItem>();
        menuItems.add(menuItem);

        menu = MenuFactory.createMenu(menuItems);

        repository.save(menu);
        id = menu.getId();

        Assert.assertNotNull(menu.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Menu menu1 = repository.findOne(id);

        Assert.assertEquals(id, menu1.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        menuItems.remove(0);
        menuItems.add(MenuItemFactory.createMenuItem(306,itemName,type,description,price,extras));
        Menu newMenu = MenuFactory.createMenu(menuItems);

        repository.save(newMenu);
        id = newMenu.getId();
        Menu updatedMenu = repository.findOne(id);

        Assert.assertEquals(id, updatedMenu.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Menu menu2 = repository.findOne(id);
        repository.delete(menu2);
        Menu newerMenu = repository.findOne(id);
        Assert.assertNull(newerMenu);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
