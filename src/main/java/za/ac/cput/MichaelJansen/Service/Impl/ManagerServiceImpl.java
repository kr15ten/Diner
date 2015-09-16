package za.ac.cput.MichaelJansen.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MichaelJansen.Domain.Manager;
import za.ac.cput.MichaelJansen.Repository.ManagerRepository;
import za.ac.cput.MichaelJansen.Service.ManagerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
@Service
public class ManagerServiceImpl implements ManagerService {


    @Autowired
    ManagerRepository repository;

    public List<Manager> getManagers(){

        List<Manager> allManagers = new ArrayList<Manager>();

        Iterable<Manager> managers = repository.findAll();
        for(Manager manager: managers)
        {
            allManagers.add(manager);
        }

        return allManagers;
    }

    public Manager getManager(int id){
        Manager manager;

        manager = repository.findOne(id);

        return manager;
    }
}
