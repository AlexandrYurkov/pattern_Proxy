package ru.otus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Service service = new ItemsServiceProxy();
        service.run();
        service.UpdateTable();
        service.ClosetedConnection();
        System.out.println("Hello world!");
    }
}