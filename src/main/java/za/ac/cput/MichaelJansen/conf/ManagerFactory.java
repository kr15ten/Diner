package za.ac.cput.MichaelJansen.conf;

import za.ac.cput.MichaelJansen.Domain.Manager;
import za.ac.cput.MichaelJansen.Domain.Salary;
import za.ac.cput.MichaelJansen.Domain.Shift;

import java.util.List;

/**
 * Created by Michael on 07/09/2015.
 */
public class ManagerFactory {
    public static Manager createManager(String name, String surname, Salary salary,List<Shift> shifts,String password)
    {
        Manager manager = new Manager.Builder(name,surname,salary,password).
                shifts(shifts).
                build();
        return manager;
    }
}
