package za.ac.cput.MichaelJansen.Domain;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by Michael on 01/09/2015.
 */
@Entity
public class Menu
{
    private List<MenuItem> menuItems;

    public Menu(Builder builder){
        this.menuItems = builder.menuItems;
    }

    public static class Builder{

        private List<MenuItem> menuItems;

        public Builder(List<MenuItem> menuItems){
            this.menuItems = menuItems;
        }

        public Builder menuItems(List<MenuItem> menuItems){
            this.menuItems = menuItems;
            return this;
        }

        public Menu build(){
            return new Menu(this);
        }
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
