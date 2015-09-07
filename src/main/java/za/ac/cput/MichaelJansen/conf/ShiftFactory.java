package za.ac.cput.MichaelJansen.conf;

import za.ac.cput.MichaelJansen.Domain.Shift;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Michael on 07/09/2015.
 */
public class ShiftFactory {
    public static Shift createShift(Date day, Time startTime, Time endTime)
    {
        Shift shift = new Shift.Builder(day,startTime,endTime)
                .build();
        return shift;
    }
}
