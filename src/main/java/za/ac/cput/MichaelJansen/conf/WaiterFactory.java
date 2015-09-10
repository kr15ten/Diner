package za.ac.cput.MichaelJansen.conf;

import za.ac.cput.MichaelJansen.Domain.Salary;
import za.ac.cput.MichaelJansen.Domain.Shift;
import za.ac.cput.MichaelJansen.Domain.Waiter;

import java.util.List;

/**
 * Created by Michael on 07/09/2015.
 */
public class WaiterFactory {
    public static Waiter createWaiter(String name,String surname,Salary salary,List<Shift>shifts,float tip)
    {
        Waiter waiter = new Waiter
                .Builder(name, surname, salary).shifts(shifts).tip(tip).build();
        return waiter;
    }
}
