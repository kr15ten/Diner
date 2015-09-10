package za.ac.cput.MichaelJansen.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Michael on 01/09/2015.
 */
@Entity
public class Waiter implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String surname;
    private Salary salary;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "waiterShifts")
    private List<Shift> shifts;

    private float tip;

    protected Waiter(){}

    public Waiter(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.shifts = builder.shifts;
        this.salary = builder.salary;
        //this.tables = builder.tables;
        this.tip = builder.tip;
    }

    public static class Builder{
        private String name;
        private String surname;
        private Salary salary;
        private List<Shift> shifts;
        //private List<Integer> tables;
        private float tip;

        public Builder(String name,String surname,Salary salary){
            this.name = name;
            this.surname = surname;
            this.salary = salary;
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

        /*public Builder tables(List<Integer> tables){
            this.tables = tables;
            return this;
        }*/

        public Builder tip(float tip){
            this.tip = tip;
            return this;
        }

        public Builder copy(Waiter waiter){
            this.name = waiter.name;
            this.surname = waiter.surname;
            this.shifts = waiter.shifts;
            this.salary = waiter.salary;
           // this.tables = waiter.tables;
            this.tip = waiter.tip;
            return this;
        }

        public Waiter build(){
            return new Waiter(this);
        }

    }

    /*public List<Integer> getTables() {
        return tables;
    }*/

    public float getTip() {
        return tip;
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
}
