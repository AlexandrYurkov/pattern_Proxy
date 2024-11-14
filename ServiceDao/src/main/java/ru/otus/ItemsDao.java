package ru.otus;

import java.sql.*;

public class ItemsDao {
    public static Connection connection = null;
    public static Statement statement;
    public static ResultSet resultSet;


    public ItemsDao() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DataSource.getDataSourceSing();
        CreateDB();
    }

    private void CreateDB() throws SQLException {
        statement = connection.createStatement();
        statement.execute("CREATE TABLE if not exists 'list' " +
                "('id' INT, 'title' text, 'price' INT);");

    }

    public void Create(Item item) throws SQLException {
        String s = "INSERT INTO 'list' ('id', 'title', 'price') VALUES ("
                + item.getId() +", "
                + "'" + item.getTitle() + "', "
                + item.getPrice() + ");";
        statement.executeUpdate(s);
    }

    public void Read() throws SQLException {
        if(statement == null)
            statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM list");
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            int price = resultSet.getInt("price");
            System.out.println( "ID = " + id );
            System.out.println( "title = " + title );
            System.out.println( "price = " + price );
            System.out.println();
        }
    }

    public void Update(Item item) throws SQLException {
        Delete(item.getId());
        item.setPrice(item.getPrice()*2);
        Create(item);
    }


    public void Delete(int id) throws SQLException {
        statement.executeUpdate(("DELETE FROM 'list' WHERE id = " + id + ";"));
    }

    public void DeleteAll() throws SQLException {
        statement.executeUpdate("DELETE FROM 'list';");
    }

    public void Closed() throws SQLException {
        DeleteAll();
        if(!connection.isClosed()){
            connection.close();
            connection = null;
        }
        if(!statement.isClosed()) {
            statement.close();
            statement = null;
        }
        if(!resultSet.isClosed())
            resultSet.close();
    }
}
