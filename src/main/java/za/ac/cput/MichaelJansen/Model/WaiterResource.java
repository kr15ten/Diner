package za.ac.cput.MichaelJansen.Model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.MichaelJansen.Domain.Salary;

/**
 * Created by Michael on 16/09/2015.
 */
public class WaiterResource extends ResourceSupport {

    private int id;
    private String name;
    private String surname;
    private Salary salary;

    private float tip;

    protected WaiterResource(){}

    public WaiterResource(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.salary = builder.salary;
        this.tip = builder.tip;
    }

    public static class Builder{
        private int id;
        private String name;
        private String surname;
        private Salary salary;
        private float tip;

        public Builder(int id,String name,String surname,Salary salary){
            this.id = id;
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

        public Builder copy(WaiterResource waiter){
            this.id = waiter.id;
            this.name = waiter.name;
            this.surname = waiter.surname;
            this.salary = waiter.salary;
            this.tip = waiter.tip;
            return this;
        }

        public WaiterResource build(){
            return new WaiterResource(this);
        }

    }

    public float getTip() {
        return tip;
    }

    public int getWaiterId() {
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
