package za.ac.cput.MichaelJansen.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MichaelJansen.Domain.Chef;
import za.ac.cput.MichaelJansen.Repository.ChefRepository;
import za.ac.cput.MichaelJansen.Service.ChefService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 13/09/2015.
 */
@Service
public class ChefServiceImpl implements ChefService {


    @Autowired
    ChefRepository repository;

    public List<Chef> getChefs(){

        List<Chef> allChefs = new ArrayList<Chef>();

        Iterable<Chef> chefs = repository.findAll();
        for(Chef chef: chefs)
        {
            allChefs.add(chef);
        }

        return allChefs;
    }

    public Chef getChef(int id){
        Chef chef;

        chef = repository.findOne(id);

        return chef;
    }
}
