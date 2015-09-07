package za.ac.cput.MichaelJansen.conf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MichaelJansen.Domain.Salary;

/**
 * Created by Michael on 07/09/2015.
 */
public class TestSalaryFactory {
    float basicSalary;
    float deductions;
    float tips;

    Salary salary;

    @Before
    public void setUp() throws Exception
    {
        basicSalary = (float)1500.00;
        deductions = (float) 100.00;
        tips = (float) 300.00;
    }

    @Test
    public void createSalary() throws Exception
    {
        salary = SalaryFactory.createSalary(basicSalary,deductions,tips);
        Assert.assertNotNull(salary);
        Assert.assertEquals(basicSalary,(float)1500.00,0.001);
    }


    @After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
