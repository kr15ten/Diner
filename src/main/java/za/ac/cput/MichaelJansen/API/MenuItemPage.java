package za.ac.cput.MichaelJansen.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.Model.MenuItemResource;
import za.ac.cput.MichaelJansen.Service.MenuItemService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 18/09/2015.
 */
@RestController
@RequestMapping("/api/menuItems/**")
public class MenuItemPage {

    @Autowired
    private MenuItemService menuItemService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String menuItemIndex()
    {
        return "View Menu";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<MenuItemResource> getMenuItems()
    {
        List<MenuItemResource> hateoas = new ArrayList<MenuItemResource>();
        List<MenuItem> menuItems = menuItemService.getMenuItems();

        for(MenuItem menuItem: menuItems)
        {
            MenuItemResource res = new MenuItemResource
                    .Builder(menuItem.getId(),menuItem.getItemName(),menuItem.getType(),menuItem.getDescription(),menuItem.getPrice())
                    .build();

            Link allMenuItems = new
                    Link("http://localhost:8181/api/menuItems/all").
                    withRel("menuItems");

            res.add(allMenuItems);
            hateoas.add(res);
        }

        return hateoas;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MenuItemResource getMenuItem(@PathVariable Integer id)
    {
        MenuItemResource hateoas;
        MenuItem menuItem = menuItemService.getMenuItem(id);

        MenuItemResource res = new MenuItemResource
                .Builder(menuItem.getId(),menuItem.getItemName(),menuItem.getType(),menuItem.getDescription(),menuItem.getPrice())
                .build();

        Link menuItems = new
                Link("http://localhost:8181/api/menuItems/" + res.getMenuItemId()).
                withRel("menuItems");

        res.add(menuItems);
        hateoas = res;

        return hateoas;
    }
}
