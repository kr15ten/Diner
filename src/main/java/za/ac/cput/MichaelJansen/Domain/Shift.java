package za.ac.cput.MichaelJansen.Domain;

import org.hibernate.annotations.GeneratorType;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Michael on 01/09/2015.
 */
@Entity
public class Shift implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    Date day;
    Time startTime;
    Time endTime;
    String empId;

    public Shift(){}

    public Shift(Builder builder) {
        this.day = builder.day;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.empId = builder.empId;
    }

    public static class Builder {
        Date day;
        Time startTime;
        Time endTime;
        String empId;

        public Builder(Date day, Time startTime, Time endTime,String empId) {
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

        public Builder copy(Shift shift) {
            this.day = shift.day;
            this.startTime = shift.startTime;
            this.endTime = shift.endTime;
            this.empId = shift.empId;
            return this;
        }

        public Shift build() {
            return new Shift(this);
        }
    }

    public Date getDay() {
        return day;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public String getEmpId(){return empId;}

    public int getId() { return id; }
}
