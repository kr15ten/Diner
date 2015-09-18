package za.ac.cput.MichaelJansen.Model;

import org.springframework.hateoas.ResourceSupport;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Michael on 16/09/2015.
 */
public class ShiftResource extends ResourceSupport {

    int id;
    Date day;
    Time startTime;
    Time endTime;
    String empId;

    public ShiftResource(){}

    public ShiftResource(Builder builder) {
        this.id = builder.id;
        this.day = builder.day;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.empId = builder.empId;
    }

    public static class Builder {
        int id;
        Date day;
        Time startTime;
        Time endTime;
        String empId;

        public Builder(int id,Date day, Time startTime, Time endTime,String empId) {
            this.id = id;
            this.day = day;
            this.startTime = startTime;
            this.endTime = endTime;
            this.empId = empId;
        }

        public Builder startTime(Time startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(Time endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder day(Date day)
        {
            this.day=day;
            return this;
        }

        public Builder empId(String empId){
            this.empId = empId;
            return this;
        }

        public Builder copy(ShiftResource shift) {
            this.id = shift.id;
            this.day = shift.day;
            this.startTime = shift.startTime;
            this.endTime = shift.endTime;
            this.empId = shift.empId;
            return this;
        }

        public ShiftResource build() {
            return new ShiftResource(this);
        }
    }

    public Date getDay() { return day; }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public String getEmpId(){return empId;}

    public int getShiftId() { return id; }

}
