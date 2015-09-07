package za.ac.cput.MichaelJansen.Domain;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Michael on 01/09/2015.
 */
@Entity
public class Table implements Serializable {

    private int id;

    private int seats;
    private List<Order> orders;
    private Boolean available;

    public Table(Builder builder){
        this.id = builder.id;
        this.seats = builder.seats;
        this.orders = builder.orders;
        this.available = builder.available;
    }

    public static class Builder {
        private int id;
        private int seats;
        private List<Order> orders;
        private Boolean available;

        public Builder(int id,int seats,List<Order> orders,Boolean available){
            this.id = id;
            this.seats = seats;
            this.orders = orders;
            this.available = available;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
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
            this.id = table.id;
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
        return id;
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