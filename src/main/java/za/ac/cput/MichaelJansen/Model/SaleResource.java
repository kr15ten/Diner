package za.ac.cput.MichaelJansen.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Michael on 16/09/2015.
 */
public class SaleResource extends ResourceSupport {

    private int id;

    private int tableId;
    private int waiterId;
    private float tip;

    public SaleResource(Builder builder){
        this.waiterId = builder.waiterId;
        this.tableId = builder.tableId;
        this.tip = builder.tip;
    }

    protected SaleResource(){}

    public static class Builder {
        private int id;
        private int tableId;
        private int waiterId;
        private float tip;

        public Builder(int id,int waiterId,int tableId,float tip) {
            this.id = id;
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

        public Builder copy(SaleResource sale) {
            this.id = sale.id;
            this.waiterId = sale.waiterId;
            this.tableId = sale.tableId;
            this.tip = sale.tip;
            return this;
        }

        public SaleResource build() {
            return new SaleResource(this);
        }
    }

    public int getSaleId() {
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
