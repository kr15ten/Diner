package za.ac.cput.MichaelJansen.Repository;

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

/**
 * Created by Michael on 13/09/2015.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class TestWaiterRepository extends AbstractTestNGSpringContextTests {

    int id;

    @Autowired
    private WaiterRepository repository;

    Waiter waiter;

    String name;
    String surname;
    Salary salary;

    float tip;

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
    public void read() throws Exception
    {
        Waiter waiter1 = repository.findOne(id);

        Assert.assertEquals(id, waiter1.getId());
    }

    //@Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Waiter newWaiter = new Waiter.Builder("Layton",surname,salary).tip(160.00f).build();

        repository.save(newWaiter);
        id = newWaiter.getId();
        Waiter updatedWaiter = repository.findOne(id);

        Assert.assertEquals(id, updatedWaiter.getId());
    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Waiter waiter2 = repository.findOne(id);
        repository.delete(waiter2);
        Waiter newerWaiter = repository.findOne(id);
        Assert.assertNull(newerWaiter);
    }

    //@AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
    }
