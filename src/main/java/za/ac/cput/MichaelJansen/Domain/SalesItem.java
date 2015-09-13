package za.ac.cput.MichaelJansen.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Michael on 12/09/2015.
 */

@Entity
public class SalesItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int menuItemId;
    private int tableId;
    private String extra;

    protected SalesItem(){}

    public SalesItem(Builder builder){
        this.menuItemId = builder.menuItemId;
        this.tableId = builder.tableId;
        this.extra = builder.extra;
    }

    public static class Builder{
        private int menuItemId;
        private int tableId;
        private String extra;

        public Builder(int menuItemId,int tableId){
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

        public Builder copy(SalesItem salesItem){
            this.menuItemId = salesItem.menuItemId;
            this.tableId = salesItem.tableId;
            this.extra = salesItem.extra;
            return this;
        }

        public SalesItem build(){return new SalesItem(this);}
    }

    public int getId() {
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
