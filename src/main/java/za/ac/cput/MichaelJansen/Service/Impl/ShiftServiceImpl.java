package za.ac.cput.MichaelJansen.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MichaelJansen.Domain.Shift;
import za.ac.cput.MichaelJansen.Repository.ShiftRepository;
import za.ac.cput.MichaelJansen.Service.ShiftService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
@Service
public class ShiftServiceImpl implements ShiftService {
    
    @Autowired
    ShiftRepository repository;

    public List<Shift> getShifts(){

        List<Shift> allShifts = new ArrayList<Shift>();

        Iterable<Shift> shifts = repository.findAll();
        for(Shift shift: shifts)
        {
            allShifts.add(shift);
        }

        return allShifts;
    }

    public Shift getShift(int id){
        Shift shift;

        shift = repository.findOne(id);

        return shift;
    }
}
