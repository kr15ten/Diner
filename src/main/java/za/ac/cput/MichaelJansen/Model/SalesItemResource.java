package za.ac.cput.MichaelJansen.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Michael on 16/09/2015.
 */
public class SalesItemResource extends ResourceSupport {

    private int id;

    private int menuItemId;
    private int tableId;
    private String extra;

    protected SalesItemResource(){}

    public SalesItemResource(Builder builder){
        this.id = builder.id;
        this.menuItemId = builder.menuItemId;
        this.tableId = builder.tableId;
        this.extra = builder.extra;
    }

    public static class Builder{
        private int id;
        private int menuItemId;
        private int tableId;
        private String extra;

        public Builder(int id,int menuItemId,int tableId){
            this.id = id;
            this.menuItemId = menuItemId;
            this.tableId = tableId;
        }

        public Builder menuItemId(int menuItemId){
            this.menuItemId = menuItemId;
            return this;
        }

        public Builder tableId(int tableId){
            this.tableId = tableId;
            return this;
        }

        public Builder extra(String extra){
            this.extra = extra;
            return this;
        }

        public Builder copy(SalesItemResource salesItem){
            this.id = salesItem.id;
            this.menuItemId = salesItem.menuItemId;
            this.tableId = salesItem.tableId;
            this.extra = salesItem.extra;
            return this;
        }

        public SalesItemResource build(){return new SalesItemResource(this);}
    }

    public int getSalesItemId() {
        return id;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public int getTableId() {
        return tableId;
    }

    public String getExtra() {
        return extra;
    }

}
