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
public class Manager implements Serializable
{
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String surname;
    private Salary salary;
    private List<Shift> shifts;
    private String password;

    public Manager(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.salary = builder.salary;
        this.password = builder.password;
    }

    public static class Builder{
        private String name;
        private String surname;
        private Salary salary;
        private List<Shift> shifts;
        private String password;


        public Builder(String name,String surname,Salary salary,String password){
            this.name = name;
            this.surname = surname;
            this.salary = salary;
            this.password = password;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder shifts(List<Shift> shifts){
            this.shifts = shifts;
            return this;
        }

        public Builder salary(Salary salary){
            this.salary = salary;
            return this;
        }



        public Builder copy(Manager manager){
            this.name = manager.name;
            this.surname = manager.surname;
            this.shifts = manager.shifts;
            this.salary = manager.salary;
            this.password = manager.password;
            return this;
        }

        public Manager build(){
            return new Manager(this);
        }

    }

    public String getPassword() { return password; }

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
}
