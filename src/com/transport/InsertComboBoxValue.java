
package com.transport;

import static com.transport.InsertTableValue.user;
import static com.transport.Welcome.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class InsertComboBoxValue {
 
public static void partyComboBox(){
try {

//nparty.setMaximumRowCount(0);
nparty.removeAllItems();
nparty.addItem("CASH");

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT partyname from newparty where username = ?";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, user);

ResultSet rs = pst.executeQuery();


while(rs.next()){
nparty.addItem(rs.getString("partyname"));
}


} catch(Exception e){
e.printStackTrace();
}

}

public static void vehicleComboBox(){
try {

nvehicle.removeAllItems();
nvehicle.addItem("NA");

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT vehiclenumber from newvehicle where username = ?";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, user);

ResultSet rs = pst.executeQuery();


while(rs.next()){
nvehicle.addItem(rs.getString("vehiclenumber"));
}


} catch(Exception e){
e.printStackTrace();
}

}

public static void driverComboBox(){
try {

ndriver.removeAllItems();
ndriver.addItem("NA");

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT driverfullname from newdriver where username = ?";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, user);

ResultSet rs = pst.executeQuery();


while(rs.next()){
ndriver.addItem(rs.getString("driverfullname"));
}


} catch(Exception e){
e.printStackTrace();
}

}

   
}
