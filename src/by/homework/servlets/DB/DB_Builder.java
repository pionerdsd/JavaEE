package by.homework.servlets.DB;



public class DB_Builder {
    //public static boolean existsBD = false;

    public static void createDB(String url, String name, String login, String password) {
        //if (new DB_Builder_Helper().ShowDB(new DB("jdbc:mysql://127.0.0.1/","root", "root")) == false) {

        // if (existsBD == false) {
        DB db = new DB(url, "", login, password);
        db.update("CREATE DATABASE " + name);
        db.update("USE " + name);

        db.update("CREATE TABLE Users (id INT AUTO_INCREMENT,"
                + "Login VARCHAR(255) NOT  NULL UNIQUE,"
                + "Password VARCHAR(255) NOT  NULL,"
                + "Email VARCHAR(255) NOT  NULL,"
                + "Role INT(1)  DEFAULT '2',"
                + "BlackList INT(1)  DEFAULT '2', PRIMARY KEY (id))");


        db.update("CREATE TABLE Statuses (id INT(1), " +
                "StatusType VARCHAR(11) NOT  NULL UNIQUE, " +
                "PRIMARY KEY (id))");


        db.update("CREATE TABLE Products "
                + "(id INT AUTO_INCREMENT,"
                + "Type VARCHAR (255) NOT  NULL,"
                + "Price INT NOT  NULL,"
                + "Quantity INT,"
                + "Ordered INT DEFAULT '0',"
                + "PRIMARY KEY (id))");

        db.update("CREATE TABLE Orders (id INT AUTO_INCREMENT,"
                + "User_id INT,"
                + "Product_id INT,"
                + "Quantity INT,"
                + "Price INT,"
                + "Date VARCHAR(255) NOT NULL,"
                + "Status_id INT(1) DEFAULT '1' ,"
                + "Payed int(1) DEFAULT '1',"
                + "PRIMARY KEY (id),"
                + "FOREIGN KEY (User_id) REFERENCES users (id),"
                + "FOREIGN KEY (Product_id) REFERENCES products (id),"
                + "FOREIGN KEY (Status_id) REFERENCES Statuses (id))");
        //db.update("ALTER  TABLE orders ADD FOREIGN KEY (Status_id) REFERENCES users (id)");
        //Statuses
     /*   db.update("INSERT INTO Statuses  VALUES('1', 'Waiting')");
        db.update("INSERT INTO Statuses  VALUES('2', 'Created')");
        db.update("INSERT INTO Statuses  VALUES('3', 'Registred')");
        db.update("INSERT INTO Statuses  VALUES('4', 'Canceled')");


//Users id, Login, Password, Role, BlackList;
        db.update("INSERT INTO  Users (id,login,password,role) VALUES  ('1', 'Admin', 'Admin', '1')");
        db.update("INSERT INTO  Users (login,password) VALUES  ('User', 'User')");
        // db.update("INSERT INTO  Users (login,password) VALUES  ('User2', 'User2')");
        // db.update("INSERT INTO  Users (login,password) VALUES  ('User3', 'User33')");

//Products  id, Type, Price, Quantity, Ordered;

        db.update("INSERT INTO Products VALUES (1, 'Bread', 2, 30 , 0)");
        db.update("INSERT INTO Products(Type,Price,Quantity) VALUES ('Salt', 1, 200)");
        db.update("INSERT INTO Products(Type,Price,Quantity) VALUES ('Butter', 3, 15)");
        db.update("INSERT INTO Products(Type,Price,Quantity) VALUES ('Milk', 5, 10)");
        db.update("INSERT INTO Products(Type,Price,Quantity) VALUES ('Pork', 10, 10)");
        db.update("INSERT INTO Products(Type,Price,Quantity) VALUES ('Beaf', 12, 10)");
        db.update("INSERT INTO Products(Type,Price,Quantity) VALUES ('Chicken', 6, 10)");

//Orders (id, User_id, Product_id, Quantity, Price, Date, Status_id, Payed);
        //  db.update("INSERT INTO Orders  VALUES ('1', '1', '1', '1', '5', '2017-12-03 23:30:30', '1', '1')");

//        db.update("INSERT INTO Orders (User_id, Product_id, Quantity, Price, Date)  VALUES ('2', '2', '2', (SELECT price FROM products WHERE id=2), '2017-12-05 13:30:30')");
//        db.update("INSERT INTO Orders (User_id, Product_id, Quantity, Price, Date)  VALUES ('1', '3', '2', (SELECT price FROM products WHERE id=3), '2017-12-05 13:30:30')");
        //      db.update("INSERT INTO Orders (User_id, Product_id, Quantity, Price, Date)  VALUES ('1', '4', '2', (SELECT price FROM products WHERE id=4), '2017-12-05 13:30:30')");

        //db.update("INSERT INTO Orders (User_id, Product_id, Quantity, Price, Date) select (2, id, 2, price, timestamp) where ID=2");
        //db.update("INSERT INTO Orders (User_id, Product_id, Quantity, Price, Date)  VALUES ('4', '4', '1', '2', '2017-12-05 11:30:30')");


//Select


/*
        db.showTable(db.query("SELECT * FROM Users"));
        System.out.println();
        db.showTable(db.query("SELECT * FROM Products"));
        System.out.println();
        db.showTable(db.query("SELECT * FROM Orders"));
        db.showTable(db.query("SELECT * FROM Statuses"));
        */
        //    existsBD = true;
        System.out.println("Database" + name + " has created!");

        //  } else System.out.println("Database" + name + " is exist!");
    }

    public static void deleteDB(String url, String name, String login, String password) {
        DB db = new DB(url, "", login, password);
        db.update("DROP DATABASE IF EXISTS " + name);
        // existsBD = false;
        System.out.println("Database" + name + " has deleted!");


    }


}
