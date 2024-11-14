package ru.otus;

import java.sql.SQLException;

public interface Service {
    public void run() throws SQLException;
    public void UpdateTable() throws SQLException;
    public void ClosetedConnection() throws SQLException;
}
