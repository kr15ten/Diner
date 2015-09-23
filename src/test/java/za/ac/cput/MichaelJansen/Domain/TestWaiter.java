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
public class TestWaiter {

    Waiter waiter;

    private String name;
    private String surname;
    private Salary salary;
    private float tip;

    //@Before
    public void setUp() throws Exception
    {
        name = "Craeton";
        surname = "Lavish";
        salary = new Salary.Builder(1500.00f).build();
        tip = 1500.00f;
    }

    //@Test
    public void testWaiterCreation() throws Exception
    {
        waiter = new Waiter.Builder(name,surname,salary).tip(tip).build();
        Assert.assertNotNull(waiter);
        Assert.assertEquals(1500.00f,waiter.getTip(),0.001);
    }

    //@After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}