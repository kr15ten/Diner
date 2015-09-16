package za.ac.cput.MichaelJansen.Service;

import za.ac.cput.MichaelJansen.Domain.Shift;

import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
public interface ShiftService {

    List<Shift> getShifts();

    Shift getShift(int id);
}
