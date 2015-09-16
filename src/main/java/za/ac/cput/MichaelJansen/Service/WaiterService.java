package za.ac.cput.MichaelJansen.Service;

import za.ac.cput.MichaelJansen.Domain.Waiter;

import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
public interface WaiterService {

    List<Waiter> getWaiters();

    Waiter getWaiter(int id);

}
