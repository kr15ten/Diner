package za.ac.cput.MichaelJansen.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.Shift;
import za.ac.cput.MichaelJansen.conf.ShiftFactory;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Michael on 13/09/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestShiftRepository  extends AbstractTestNGSpringContextTests {

    @Autowired
    ShiftRepository repository;

    int id;

    Shift shift;

    Date date;
    Time startTime;
    Time endTime;
    String empId;

    @Test
    public void create() throws Exception
    {
        date = new Date(2015,11,11);
        startTime = new Time(8,30,00);
        endTime = new Time(15,00,00);
        empId = "W1";

        shift = ShiftFactory.createShift(date, startTime, endTime, empId);

        repository.save(shift);
        id = shift.getId();

        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        shift = repository.findOne(id);

        Assert.assertEquals(id, shift.getId());
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        shift = new Shift.Builder(date,startTime,endTime,"W2").build();

        repository.save(shift);
        id = shift.getId();
        shift = repository.findOne(id);

        Assert.assertEquals(id,shift.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        shift = repository.findOne(id);
        repository.delete(shift);
        shift = repository.findOne(id);
        Assert.assertNull(shift);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }

}
