package za.ac.cput.MichaelJansen.Repository;

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
import za.ac.cput.MichaelJansen.Domain.Shift;
import za.ac.cput.MichaelJansen.conf.ChefFactory;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Michael on 08/09/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestChefRepository extends AbstractTestNGSpringContextTests {
    int id;

    @Autowired
    private ChefRepository repository;

    Chef chef;

    String name;
    String surname;
    Salary salary;

    private String speciality = "Noodlez";



    @Test
    public void create() throws Exception
    {

        name = "Craeton";
        surname = "Lavish";
        salary = new Salary.Builder(1500.00f).build();
        speciality = "Noodles";
        chef = ChefFactory.createChef(name,surname,salary,speciality);
        repository.save(chef);
        id = chef.getId();

        Assert.assertNotNull(chef.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Chef chef1 = repository.findOne(id);

        Assert.assertEquals(id, chef1.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Chef newChef = new Chef.Builder("Layton",surname,salary).speciality(speciality).build();

        repository.save(newChef);
        id = newChef.getId();
        Chef updatedChef = repository.findOne(id);

        Assert.assertEquals(id, updatedChef.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Chef chef2 = repository.findOne(id);
        repository.delete(chef2);
        Chef deletedChef = repository.findOne(id);
        Assert.assertNull(deletedChef);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
       repository.deleteAll();
    }
}
