package za.ac.cput.MichaelJansen.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MichaelJansen.Domain.Waiter;
import za.ac.cput.MichaelJansen.Repository.WaiterRepository;
import za.ac.cput.MichaelJansen.Service.WaiterService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
@Service
public class WaiterServiceImpl implements WaiterService {

    @Autowired
    WaiterRepository repository;

    public List<Waiter> getWaiters(){

        List<Waiter> allWaiters = new ArrayList<Waiter>();

        Iterable<Waiter> waiters = repository.findAll();
        for(Waiter waiter: waiters)
        {
            allWaiters.add(waiter);
        }

        return allWaiters;
    }

    public Waiter getWaiter(int id){
        Waiter waiter;

        waiter = repository.findOne(id);

        return waiter;
    }
}
