package za.ac.cput.MichaelJansen.Model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.MichaelJansen.Domain.Order;

import java.util.List;

/**
 * Created by Michael on 16/09/2015.
 */
public class TableResource extends ResourceSupport {

    private int tableId;

    private int seats;

    private List<Order> orders;
    private Boolean available;

    public TableResource(Builder builder){
        this.tableId = builder.tableId;
        this.seats = builder.seats;
        this.orders = builder.orders;
        this.available = builder.available;
    }

    protected TableResource() {
    }

    public static class Builder {
        private int tableId;
        private int seats;
        private List<Order> orders;
        private Boolean available;

        public Builder(int tableId,int seats,List<Order> orders,Boolean available){
            this.tableId = tableId;
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

        public Builder copy(TableResource table) {
            this.tableId = table.tableId;
            this.seats = table.seats;
            this.orders = table.orders;
            this.available = table.available;
            return this;
        }

        public TableResource build() {
            return new TableResource(this);
        }
    }

    public int getTableId() { return tableId; }

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
