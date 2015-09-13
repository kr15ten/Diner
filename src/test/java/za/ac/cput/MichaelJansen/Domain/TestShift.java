package za.ac.cput.MichaelJansen.Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Michael on 06/09/2015.
 */
public class TestShift
{
    Shift shift;

    Date date;
    Time startTime;
    Time endTime;
    String empId;

    @Before
    public void setUp() throws Exception{
        date = new Date(2015,11,11);
        startTime = new Time(8,30,00);
        endTime = new Time(15,00,00);
        empId = "W1";
        shift = new Shift.Builder(date,startTime,endTime,empId).build();
    }

    @Test
    public void testShiftCreation() throws Exception{
        Assert.assertNotNull(shift);
        Assert.assertEquals(startTime,shift.getStartTime());
    }

    @After
    public void tearDown() throws Exception{

    }
}
