package za.ac.cput.MichaelJansen.Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Michael on 06/09/2015.
 */
public class TestManager
{
    Manager manager;

    String name;
    String surname;
    Salary salary;
    String password = "Noodlez";

    //@Before
    public void setUp() throws Exception
    {
        name = "Craeton";
        surname = "Lavish";
        salary = new Salary.Builder(1500.00f).build();
        password = "Noodles";
    }

    //@Test
    public void testManagerCreation() throws Exception
    {
        manager = new Manager.Builder(name,surname,salary,password).build();
        Assert.assertNotNull(manager);
        Assert.assertEquals("Noodles",manager.getPassword());
    }

    //@After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
