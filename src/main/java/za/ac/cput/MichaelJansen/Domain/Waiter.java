package za.ac.cput.MichaelJansen.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Michael on 01/09/2015.
 */
@SequenceGenerator(initialValue = 1,allocationSize = 100,name = "waitSeq")
@Entity
public class Waiter implements Serializable
{
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "waitSeq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private Salary salary;

    private float tip;

    protected Waiter(){}

    public Waiter(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.salary = builder.salary;
        this.tip = builder.tip;
    }

    public static class Builder{
        private String name;
        private String surname;
        private Salary salary;
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

        public Builder salary(Salary salary){
            this.salary = salary;
            return this;
        }

        public Builder tip(float tip){
            this.tip = tip;
            return this;
        }

        public Builder copy(Waiter waiter){
            this.name = waiter.name;
            this.surname = waiter.surname;
            this.salary = waiter.salary;
            this.tip = waiter.tip;
            return this;
        }

        public Waiter build(){
            return new Waiter(this);
        }

    }

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

    public Salary getSalary() { return salary; }

    public String getType() {return "W";}
}