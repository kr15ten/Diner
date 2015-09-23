package za.ac.cput.MichaelJansen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.Chef;
import za.ac.cput.MichaelJansen.Domain.Salary;
import za.ac.cput.MichaelJansen.Repository.ChefRepository;
import za.ac.cput.MichaelJansen.conf.ChefFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
  // @SpringApplicationConfiguration(classes = App.class)
   //@WebAppConfiguration
   public class TestChefService extends AbstractTestNGSpringContextTests {

    @Autowired
    ChefService service;

    int id;

    @Autowired
    private ChefRepository repository;

    Chef chef;

    String name;
    String surname;
    Salary salary;

    String speciality = "Noodlez";

    List<Chef> chefs = new ArrayList<Chef>();

    //@Test
    public void create() throws Exception {

        name = "Craeton";
        surname = "Lavish";
        salary = new Salary.Builder(1500.00f).build();
        speciality = "Noodles";
        chef = ChefFactory.createChef(name, surname, salary, speciality);
        repository.save(chef);
        id = chef.getId();

        Assert.assertNotNull(chef.getId());
    }

    //@Test(dependsOnMethods = "create")
    public void testGetChefs() throws Exception {
        chefs = service.getChefs();
        Assert.assertEquals(1, chefs.size());
    }

    //@Test(dependsOnMethods = "create")
    public void testGetChef() throws Exception {
        chef = service.getChef(id);

        Assert.assertEquals("Noodles",speciality);
    }

   // @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
