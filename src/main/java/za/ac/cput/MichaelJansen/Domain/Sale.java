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

    private int tableId;
    private int waiterId;
    private float tip;

    public Sale(Builder builder){
        this.waiterId = builder.waiterId;
        this.tableId = builder.tableId;
        this.tip = builder.tip;
    }

    protected Sale(){}

    public static class Builder {
        private int tableId;
        private int waiterId;
        private float tip;

        public Builder(int waiterId,int tableId,float tip) {
            this.waiterId = waiterId;
            this.tableId = tableId;
            this.tip = tip;
        }

        public Builder waiter(int waiterId) {
            this.waiterId = waiterId;
            return this;
        }

        public Builder tableId(int tableId) {
            this.tableId = tableId;
            return this;
        }

        public Builder tip(float tip) {
            this.tip = tip;
            return this;
        }

        public Builder copy(Sale sale) {
            this.waiterId = sale.waiterId;
            this.tableId = sale.tableId;
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

    public int getWaiterId() { return waiterId; }

    public int getTableId() {
        return tableId;
    }

    public float getTip() {
        return tip;
    }
}