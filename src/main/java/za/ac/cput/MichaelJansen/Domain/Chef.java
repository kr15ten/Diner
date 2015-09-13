package za.ac.cput.MichaelJansen.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Michael on 01/09/2015.
 */

@SequenceGenerator(initialValue = 1,allocationSize = 100,name = "chefSeq")
@Entity
public class Chef implements Serializable
{

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "chefSeq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String surname;
    private Salary salary;

    private String speciality;

    public Chef(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.salary = builder.salary;
        this.speciality = builder.speciality;
    }

    protected Chef() {
    }

    public static class Builder {
        private String name;
        private String surname;
        private Salary salary;
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

    public String getSpeciality() {
        return speciality;
    }

    public String getType(){return "C";}
}
