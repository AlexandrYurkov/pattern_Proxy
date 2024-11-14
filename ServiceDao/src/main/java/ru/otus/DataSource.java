package ru.otus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DataSource {
   private static DataSource dataSource = null;
   private static Connection connection = null;

   private DataSource() {
       try {
           connection = DriverManager.getConnection("jdbc:sqlite:test1.db");
           dataSource = this;
       } catch (SQLException ignored){
           System.err.println("БД нет!");
       }

   }
   public static synchronized Connection getDataSourceSing(){
       if(dataSource == null){
           new DataSource();
           getDataSourceSing();
       }
       return connection;
   }

}
