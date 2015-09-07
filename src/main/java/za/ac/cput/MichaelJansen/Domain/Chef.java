package za.ac.cput.MichaelJansen.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Michael on 01/09/2015.
 */

@Entity
public class Chef implements Serializable
{

    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    protected String name;
    protected String surname;
    protected Salary salary;
    protected List<Shift> shifts;
    private String speciality;

    public Chef(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.shifts = builder.shifts;
        this.salary = builder.salary;
        this.speciality = builder.speciality;
    }

    public static class Builder {
        private String name;
        private String surname;
        private Salary salary;
        private List<Shift> shifts;
        private String speciality;


        public Builder(String name, String surname, Salary salary) {
            this.name = name;
            this.surname = surname;
            this.salary = salary;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder shifts(List<Shift> shifts) {
            this.shifts = shifts;
            return this;
        }

        public Builder salary(Salary salary) {
            this.salary = salary;
            return this;
        }

        public Builder speciality(String speciality) {
            this.speciality = speciality;
            return this;
        }


        public Builder copy(Chef chef) {
            this.name = chef.name;
            this.surname = chef.surname;
            this.shifts = chef.shifts;
            this.salary = chef.salary;
            this.speciality = chef.speciality;
            return this;
        }

        public Chef build() {
            return new Chef(this);
        }

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Salary getSalary() {
        return salary;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public String getSpeciality() {
        return speciality;
    }
}
