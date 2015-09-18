package za.ac.cput.MichaelJansen.Model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.MichaelJansen.Domain.Salary;

/**
 * Created by Michael on 16/09/2015.
 */
public class ChefResource extends ResourceSupport {

    private int id;

    private String name;
    private String surname;
    private Salary salary;

    private String speciality;

    public ChefResource(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.salary = builder.salary;
        this.speciality = builder.speciality;
    }

    protected ChefResource() {
    }

    public static class Builder {
        private int id;
        private String name;
        private String surname;
        private Salary salary;
        private String speciality;


        public Builder(int id,String name, String surname, Salary salary) {
            this.name = name;
            this.surname = surname;
            this.salary = salary;
            this.id = id;
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

        public Builder copy(ChefResource chef) {
            this.name = chef.name;
            this.surname = chef.surname;
            this.salary = chef.salary;
            this.speciality = chef.speciality;
            return this;
        }

        public ChefResource build() {
            return new ChefResource(this);
        }

    }

    public Integer getChefId() {
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
