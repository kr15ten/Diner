package za.ac.cput.MichaelJansen.Domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Michael on 01/09/2015.
 */
@Embeddable
public class Salary implements Serializable
{
    private float basicSalary;
    private float deductions;
    private float tips;

    public Salary(Builder builder)
    {
        this.basicSalary = builder.basicSalary;
        this.deductions = builder.deductions;
        this.tips = builder.tips;
    }
    public static class Builder {

        private float basicSalary;
        private float deductions;
        private float tips;

        public Builder(float basicSalary) {
            this.basicSalary = basicSalary;
        }

        public Builder deductions(float deductions) {
            this.deductions = deductions;
            return this;
        }

        public Builder tips(float tips) {
            this.tips = tips;
            return this;
        }

        public Builder copy(Salary salary) {
            this.basicSalary = salary.basicSalary;
            this.deductions = salary.deductions;
            this.tips = salary.tips;
            return this;
        }

        public Salary build() {
            return new Salary(this);
        }
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public float getDeductions() {
        return deductions;
    }

    public float getTips(){
        return tips;
    }
}
