package ru.otus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsService implements Service{
    private ItemsDao dao;
    List<Item> items;

    public ItemsService() {
        try {
            dao = new ItemsDao();
            items = new ArrayList<>();
        } catch (Exception e) {
            System.err.println(e.fillInStackTrace().toString());
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void Generated() throws SQLException {
        for (int i = 1; i <= 100; i++) {
            items.add(new Item(i, "title_" + i, i * 10));
        }
        for (Item it : items) {
            dao.Create(it);
        }

    }
    public void ReadTable() throws SQLException {
        dao.Read();
    }

    public void UpdateTable() throws SQLException {
        for(Item it : items)
            dao.Update(it);
    }

    public void ClosetedConnection() throws SQLException {
        dao.Closed();
    }

    @Override
    public void run() throws SQLException {
        Generated();
        ReadTable();
    }
}
