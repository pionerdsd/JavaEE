package by.homework.servlets.DB;

import java.sql.*;

public class DB {


    private Connection cn;

    public Statement getSt() {
        return st;
    }

    private Statement st;

    public Connection getCn() {
        return cn;
    }

    public DB(String url, String login, String password) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, password);
            st = cn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public DB(String url, String name, String login, String password) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url + name, login, password);
            st = cn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void update(String sql) {

        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql) {
        ResultSet rs = null;
        try {

            rs = st.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void showTable(ResultSet rs) {

        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rsmd.getColumnName(i) + "\t" + "\t" + "\t" + "\t");
            }
            while (rs.next()) {
                System.out.println();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t" + "\t" + "\t" + "\t" + "\t");
                }
            }
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }





}
