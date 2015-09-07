package za.ac.cput.MichaelJansen.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.List;
/**
 * Created by Michael on 03/09/2015.
 */
@Entity
public class Sale implements Serializable {
    @GeneratedValue
    private int id;

    private List<Order> items;
    private Waiter waiter;
    private float tip;

    public Sale(Builder builder){
        this.waiter = builder.waiter;
        this.items = builder.items;
        this.tip = builder.tip;
    }

    private Sale(){}

    public static class Builder {
        private List<Order> items;
        private Waiter waiter;
        private float tip;

        public Builder(Waiter waiter,List<Order> items,float tip) {
            this.waiter = waiter;
            this.items = items;
            this.tip = tip;
        }

        public Builder waiter(Waiter waiter) {
            this.waiter = waiter;
            return this;
        }

        public Builder items(List<Order> items) {
            this.items = items;
            return this;
        }

        public Builder tip(float tip) {
            this.tip = tip;
            return this;
        }

        public Builder copy(Sale sale) {
            this.waiter = sale.waiter;
            this.items = sale.items;
            this.tip = sale.tip;
            return this;
        }

        public Sale build() {
            return new Sale(this);
        }
    }

    public int getId() {
        return id;
    }

    public List<Order> getItems() {
        return items;
    }

    public float getTip() {
        return tip;
    }
}