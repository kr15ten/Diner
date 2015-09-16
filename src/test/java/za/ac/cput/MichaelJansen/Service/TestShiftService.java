package za.ac.cput.MichaelJansen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.Shift;
import za.ac.cput.MichaelJansen.Repository.ShiftRepository;
import za.ac.cput.MichaelJansen.conf.ShiftFactory;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestShiftService extends AbstractTestNGSpringContextTests {

    @Autowired
    ShiftService service;

    @Autowired
    ShiftRepository repository;

    int id;

    Shift shift;

    Date date;
    Time startTime;
    Time endTime;
    String empId;

    List<Shift> shifts = new ArrayList<Shift>();

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
    public void testGetShifts() throws Exception {
        shifts = service.getShifts();
        Assert.assertEquals(1, shifts.size());
    }

    @Test(dependsOnMethods = "create")
    public void testGetShift() throws Exception {
        shift = service.getShift(id);

        Assert.assertEquals(empId,shift.getEmpId());
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }

}
