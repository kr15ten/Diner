package za.ac.cput.MichaelJansen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.Manager;
import za.ac.cput.MichaelJansen.Domain.Salary;
import za.ac.cput.MichaelJansen.Repository.ManagerRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */

//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class TestManagerService extends AbstractTestNGSpringContextTests{
    @Autowired
    ManagerService service;

    int id;

    @Autowired
    ManagerRepository repository;

    Manager manager;

    String name;
    String surname;
    Salary salary;

    String password = "Noodlez";

    List<Manager> chefs = new ArrayList<Manager>();

    //@Test
    public void create() throws Exception
    {

        name = "Craeton";
        surname = "Lavish";
        salary = new Salary.Builder(1500.00f).build();
        password = "Noodles";

        manager = new Manager.Builder(name,surname,salary,password).build();

        repository.save(manager);
        id = manager.getId();

        Assert.assertNotNull(manager.getId());
    }

    //@Test(dependsOnMethods = "create")
    public void testGetManagers() throws Exception {
        chefs = service.getManagers();
        Assert.assertEquals(1, chefs.size());
    }

    //@Test(dependsOnMethods = "create")
    public void testGetManager() throws Exception {
        manager = service.getManager(id);

        Assert.assertEquals("Noodles",password);
    }

    //@AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}