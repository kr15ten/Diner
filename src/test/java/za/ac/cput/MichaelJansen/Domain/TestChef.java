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
public class TestChef
{
    Chef chef;

    private String name;
    private String surname;
    private Salary salary;

    private String speciality = "Noodles";

    @Before
    public void setUp() throws Exception
    {
        name = "Craeton";
        surname = "Lavish";
        salary = new Salary.Builder(1500.00f).build();
        speciality = "Noodles";

    }

    @Test
    public void testChefCreation() throws Exception
    {
        chef = new Chef.Builder(name,surname,salary).speciality(speciality).build();
        Assert.assertNotNull(chef);
        Assert.assertEquals("Noodles",chef.getSpeciality());
    }

    @After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
