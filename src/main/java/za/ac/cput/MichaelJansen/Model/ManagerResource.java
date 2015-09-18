package za.ac.cput.MichaelJansen.Model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.MichaelJansen.Domain.Salary;

/**
 * Created by Michael on 16/09/2015.
 */
public class ManagerResource extends ResourceSupport {

    private int id;

    private String name;
    private String surname;
    private Salary salary;


    private String password;

    protected ManagerResource(){}

    public ManagerResource(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.salary = builder.salary;
        this.password = builder.password;
    }

    public static class Builder{
        private int id;
        private String name;
        private String surname;
        private Salary salary;
        private String password;


        public Builder(int id,String name,String surname,Salary salary,String password){
            this.id = id;
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

        public Builder salary(Salary salary){
            this.salary = salary;
            return this;
        }

        public Builder copy(ManagerResource manager){
            this.id = manager.id;
            this.name = manager.name;
            this.surname = manager.surname;
            this.salary = manager.salary;
            this.password = manager.password;
            return this;
        }

        public ManagerResource build(){
            return new ManagerResource(this);
        }

    }

    public String getPassword() { return password; }

    public int getManagerId() { return id; }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Salary getSalary() {
        return salary;
    }

    public String getType(){return "M";}


}
