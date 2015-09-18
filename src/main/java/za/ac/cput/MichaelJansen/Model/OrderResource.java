package za.ac.cput.MichaelJansen.Model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.MichaelJansen.Domain.SalesItem;

import java.util.List;

/**
 * Created by Michael on 16/09/2015.
 */
public class OrderResource extends ResourceSupport {

    private int id;

    private List<SalesItem> items;
    private String extra;

    protected OrderResource(){}

    public OrderResource(Builder builder){
        this.items = builder.items;
        this.extra = builder.extra;
    }

    public static class Builder {
        private int id;
        private List<SalesItem> items;
        private String extra;

        public Builder(int id,String extra){
            this.id = id;
            this.extra = extra;
        }

        public Builder(int id,List<SalesItem> items,String extra) {
            this.id = id;
            this.items = items;
            this.extra = extra;
        }

        public Builder items(List<SalesItem> items) {
            this.items = items;
            return this;
        }

        public Builder extra(String extra) {
            this.extra = extra;
            return this;
        }

        public Builder copy(OrderResource order) {
            this.items = order.items;
            this.extra = order.extra;
            return this;
        }

        public OrderResource build() {
            return new OrderResource(this);
        }
    }

    public int getOrderId() {
        return id;
    }

    public List<SalesItem> getItems() {
        return items;
    }

    public String getExtra() {
        return extra;
    }

}
