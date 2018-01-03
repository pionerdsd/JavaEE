package by.homework.servlets.dao;


import by.homework.servlets.DB.DB;
import by.homework.servlets.entity.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by dmurashko on 07.12.2017.
 */
public class DaoUsers implements daoInterface<Users> {
    public DB db;// если  в поле класса заносим объет, то можно обращаться к полям этого объекта тк же как если бы мы создали его через new?

    public DaoUsers(DB db) {
        this.db = db;
    }

    @Override
    public void insert(Users o) {
        try {
            PreparedStatement ps = db.getCn().prepareStatement("INSERT INTO Users VALUES (?,?,?,?,?,?)");
            ps.setInt(1, o.getId());
            ps.setString(2, o.getLogin());
            ps.setString(3, o.getPassword());
            ps.setString(4, o.getEmail());
            ps.setInt(5, o.getRole());
            ps.setInt(6, o.getBlackList());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void insertLP(Users o) {
        try {
            PreparedStatement ps = db.getCn().prepareStatement("INSERT INTO Users (Login, Password, Email) VALUES (?,?,?)");

            ps.setString(1, o.getLogin());
            ps.setString(2, o.getPassword());
            ps.setString(3, o.getEmail());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }





    @Override
    public void delete(Users o) {
        try {
            PreparedStatement ps = db.getCn().prepareStatement("DELETE FROM Users WHERE id=?");
            ps.setInt(1, o.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Users o) {
        try {
            PreparedStatement ps = db.getCn().prepareStatement("UPDATE users SET Login=?,Password=?,Email=?,Role=?,BlackList=? WHERE id=?");
            ps.setString(1, o.getLogin());
            ps.setString(2, o.getPassword());
            ps.setString(3, o.getEmail());
            ps.setInt(4, o.getRole());
            ps.setInt(5, o.getBlackList());
            ps.setInt(6,o.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Users get(int id) {

        ResultSet rs = null;
        try {
            rs = db.getSt().executeQuery("SELECT * FROM users WHERE id=" + id);


            if (rs.next()) {
                return new Users(rs.getInt("id"), rs.getString("login"), rs.getString("password"),rs.getString("email"), rs.getInt("role"), rs.getInt("BlackList"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<Users> get() {

        LinkedList<Users> list = new LinkedList <> ();

            try {
                ResultSet rs = db.getSt().executeQuery("SELECT * FROM users");

               while (rs.next()) {

                    list.add(new Users(rs.getInt("id"), rs.getString("login"), rs.getString("password"),rs.getString("email"), rs.getInt("role"), rs.getInt("BlackList")));

                }



            } catch (SQLException e) {
                e.printStackTrace();
                       }


        return list;
    }


    public  int getId(String table){

        try {
            ResultSet rs = db.query("SELECT max(id) FROM "+table);

            if(rs.next()){

                return  rs.getInt("max(id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


}
