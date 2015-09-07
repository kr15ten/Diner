package za.ac.cput.MichaelJansen.conf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MichaelJansen.Domain.Shift;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Michael on 07/09/2015.
 */
public class TestShiftFactory {
    Shift shift;

    Date date;
    Time startTime;
    Time endTime;

    @Before
    public void setUp() throws Exception{
        date = new Date(2015,11,11);
        startTime = new Time(8,30,00);
        endTime = new Time(15,00,00);


    }

    @Test
    public void testShiftCreation() throws Exception{
        shift = ShiftFactory.createShift(date,startTime,endTime);
        Assert.assertNotNull(shift);
        Assert.assertEquals(startTime,shift.getStartTime());
    }

    @After
    public void tearDown() throws Exception{

    }
}
