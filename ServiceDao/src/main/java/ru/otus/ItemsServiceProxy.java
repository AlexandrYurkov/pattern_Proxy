package ru.otus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsServiceProxy implements Service{
    private ItemsService service;
    private final List<Item> items;

    public ItemsServiceProxy() {
        items = new ArrayList<>();
    }

    @Override
    public void run() throws SQLException {
        if(service == null) {
            service = new ItemsService();
            service.run();
            items.addAll(service.getItems());
        }
        else
            service.ReadTable();
    }

    public void UpdateTable() throws SQLException {
        if(service == null){
            service = new ItemsService();
            service.run();
            items.addAll(service.getItems());
        }else {
            service.UpdateTable();
            service.ReadTable();
        }
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public void ClosetedConnection() throws SQLException {
        service.ClosetedConnection();
    }
}
