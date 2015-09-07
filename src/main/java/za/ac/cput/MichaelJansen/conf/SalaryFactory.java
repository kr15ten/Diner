package za.ac.cput.MichaelJansen.conf;

import za.ac.cput.MichaelJansen.Domain.Salary;

/**
 * Created by Michael on 07/09/2015.
 */
public class SalaryFactory {
    public static Salary createSalary(float basicSalary,float deductions,float tips)
    {
        Salary salary = new Salary.Builder(basicSalary).deductions(deductions).tips(tips).build();
        return salary;
    }
}
