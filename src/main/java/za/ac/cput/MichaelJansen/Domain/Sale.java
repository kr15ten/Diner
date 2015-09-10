package za.ac.cput.MichaelJansen.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 * Created by Michael on 03/09/2015.
 */
@Entity
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "tableOrders")
    private List<Order> orders;
    private int waiterId;
    private float tip;

    public Sale(Builder builder){
        this.waiterId = builder.waiterId;
        this.orders = builder.orders;
        this.tip = builder.tip;
    }

    protected Sale(){}

    public static class Builder {
        private List<Order> orders;
        private int waiterId;
        private float tip;

        public Builder(int waiterId,List<Order> orders,float tip) {
            this.waiterId = waiterId;
            this.orders = orders;
            this.tip = tip;
        }

        public Builder waiter(int waiterId) {
            this.waiterId = waiterId;
            return this;
        }

        public Builder orders(List<Order> orders) {
            this.orders = orders;
            return this;
        }

        public Builder tip(float tip) {
            this.tip = tip;
            return this;
        }

        public Builder copy(Sale sale) {
            this.waiterId = sale.waiterId;
            this.orders = sale.orders;
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

    public List<Order> getOrders() {
        return orders;
    }

    public float getTip() {
        return tip;
    }
}