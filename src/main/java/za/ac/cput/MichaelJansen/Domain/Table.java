package za.ac.cput.MichaelJansen.Domain;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Michael on 01/09/2015.
 */
@Entity
@javax.persistence.Table(name = "Tables")
public class Table implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tableId;

    private int seats;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_orders")
    private List<Order> orders;
    private Boolean available;

    public Table(Builder builder){
        this.seats = builder.seats;
        this.orders = builder.orders;
        this.available = builder.available;
    }

    protected Table() {
    }

    public static class Builder {
        private int seats;
        private List<Order> orders;
        private Boolean available;

        public Builder(int seats,List<Order> orders,Boolean available){
            this.seats = seats;
            this.orders = orders;
            this.available = available;
        }

        public Builder(int seats,Boolean available){
            this.seats = seats;
            this.available = available;
        }

        public Builder seats(int seats) {
            this.seats = seats;
            return this;
        }

        public Builder orders(List<Order> orders) {
            this.orders = orders;
            return this;
        }

        public Builder available(Boolean available) {
            this.available = available;
            return this;
        }

        public Builder copy(Table table) {
            this.seats = table.seats;
            this.orders = table.orders;
            this.available = table.available;
            return this;
        }

        public Table build() {
            return new Table(this);
        }
    }


    public int getId() {
        return tableId;
    }

    public int getSeats() {
        return seats;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Boolean getAvailable() {
        return available;
    }
}