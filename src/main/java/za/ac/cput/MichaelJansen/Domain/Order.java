package za.ac.cput.MichaelJansen.Domain;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 01/09/2015.
 */
@Embeddable
public class Order implements Serializable
{

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private List<MenuItem> items;
    private String extra;

    public Order(Builder builder){
        this.items = builder.items;
        this.extra = builder.extra;
    }

    public static class Builder {
        private List<MenuItem> items;
        private String extra;

        public Builder(List<MenuItem> items,String extra) {
            this.items = items;
            this.extra = extra;
        }

        public Builder items(List<MenuItem> items) {
            this.items = items;
            return this;
        }

        public Builder extra(String extra) {
            this.extra = extra;
            return this;
        }

        public Builder copy(Order order) {
            this.items = order.items;
            this.extra = order.extra;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public String getExtra() {
        return extra;
    }
}
