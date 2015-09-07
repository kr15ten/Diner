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

    private String name;
    private String surname;
    private Salary salary;
    private List<Shift> shifts;

    private String password = "Noodlez";

    Shift shift;

    Date date;
    Time startTime;
    Time endTime;

    @Before
    public void setUp() throws Exception
    {
        name = "Craeton";
        surname = "Lavish";
        salary = new Salary.Builder(1500.00f).build();
        password = "Noodles";

        date = new Date(2015,11,11);
        startTime = new Time(8,30,00);
        endTime = new Time(15,00,00);

        shift = new Shift.Builder(date,startTime,endTime).build();

        shifts = new ArrayList<Shift>();
        shifts.add(shift);

    }

    @Test
    public void testManagerCreation() throws Exception
    {
        manager = new Manager.Builder(name,surname,salary,password).shifts(shifts).build();
        Assert.assertNotNull(manager);
        Assert.assertEquals("Noodles",manager.getPassword());
    }

    @After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
