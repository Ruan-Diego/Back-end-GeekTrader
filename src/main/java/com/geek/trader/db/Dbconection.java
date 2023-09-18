//package com.geek.trader.db;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class Dbconection {
//    Connection conexcao;
//
//    public void con(){
//        try {
//            conexcao = DriverManager.getConnection("jdbc:postgresql://localhost:8080/ruan", "postgres", "2626");
//            if(conexcao!=null){
//                System.out.println("yes");
//            } else {
//                System.out.println("no :(");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
