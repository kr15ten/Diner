package za.ac.cput.MichaelJansen.Domain;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 05/09/2015.
 */

public class TestSalary {
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
        salary = new Salary.Builder(basicSalary).deductions(deductions).tips(tips).build();
        Assert.assertNotNull(salary);
        Assert.assertEquals(basicSalary,(float)1500.00,0.001);
    }


    @After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
