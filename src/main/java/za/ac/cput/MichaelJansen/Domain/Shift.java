package za.ac.cput.MichaelJansen.Domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Michael on 01/09/2015.
 */
@Embeddable
public class Shift implements Serializable
{
    Date day;
    Time startTime;
    Time endTime;

    public Shift(Builder builder) {
        this.day = builder.day;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
    }

    public static class Builder {
        Date day;
        Time startTime;
        Time endTime;

        public Builder(Date day,Time startTime,Time endTime) {
            this.day = day;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Builder startTime(Time startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(Time endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder copy(Shift shift) {
            this.day = shift.day;
            this.startTime = shift.startTime;
            this.endTime = shift.endTime;
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
}
