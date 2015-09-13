package za.ac.cput.MichaelJansen.conf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MichaelJansen.Domain.Salary;
import za.ac.cput.MichaelJansen.Domain.Shift;
import za.ac.cput.MichaelJansen.Domain.Waiter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Michael on 07/09/2015.
 */
public class TestWaiterFactory {


    Waiter waiter;

    private String name;
    private String surname;
    private Salary salary;
    private float tip;

    @Before
    public void setUp() throws Exception
    {
        name = "Craeton";
        surname = "Lavish";
        salary = new Salary.Builder(1500.00f).build();

        tip = 1500.00f;
    }

    @Test
    public void testWaiterCreation() throws Exception
    {
        waiter = WaiterFactory.createWaiter(name,surname,salary,tip);
        Assert.assertNotNull(waiter);
        Assert.assertEquals(1500.00f,waiter.getTip(),0.001);
    }

    @After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
