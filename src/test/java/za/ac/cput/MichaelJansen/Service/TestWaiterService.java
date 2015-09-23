package za.ac.cput.MichaelJansen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.Salary;
import za.ac.cput.MichaelJansen.Domain.Waiter;
import za.ac.cput.MichaelJansen.Repository.WaiterRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */

//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class TestWaiterService extends AbstractTestNGSpringContextTests {

    @Autowired
    WaiterService service;


    int id;

    @Autowired
    private WaiterRepository repository;

    Waiter waiter;

    String name;
    String surname;
    Salary salary;

    float tip;

    List<Waiter> waiters = new ArrayList<Waiter>();

    //@Test
    public void create() throws Exception
    {

        name = "Craeton";
        surname = "Lavish";
        salary = new Salary.Builder(1500.00f).build();
        tip = 150.00f;

        waiter = new Waiter.Builder(name,surname,salary).tip(tip).build();

        repository.save(waiter);
        id = waiter.getId();

        Assert.assertNotNull(waiter.getId());
    }

    //@Test(dependsOnMethods = "create")
    public void testGetTables() throws Exception {
        waiters = service.getWaiters();
        Assert.assertEquals(1, waiters.size());
    }

    //@Test(dependsOnMethods = "create")
    public void testGetTable() throws Exception {
        waiter = service.getWaiter(id);

        Assert.assertEquals(tip,waiter.getTip());
    }

/*   //@AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
*/
}
