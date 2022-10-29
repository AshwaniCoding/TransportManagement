
package com.transport;

import static com.transport.Welcome.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



public class InsertTableValue {

public static String user;

public static void insertDriverTable(){

try{


Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT * FROM newdriver where username = ?";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, user);
ResultSet rs = pst.executeQuery();

int i = 1;
while(rs.next()){

String drivername = rs.getString("driverfullname");
String licencenumber = rs.getString("licencenumber");
String pannumber = rs.getString("pannumber");
String mobilenumber = rs.getString("mobileno");


Object[] obj = {String.valueOf(i),drivername,licencenumber,pannumber,mobilenumber};
DefaultTableModel model = (DefaultTableModel)drivertable.getModel();
model.addRow(obj);

i++;
}

}
catch (Exception e){
e.printStackTrace();
}



}

public static void insertPartyTable(){

try{


Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT * FROM newparty where username = ?";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, user);
ResultSet rs = pst.executeQuery();

int i = 1;
while(rs.next()){

String partyname = rs.getString("partyname");
String gstnumber = rs.getString("gstno");
String mobilenumber = rs.getString("mobileno");
String email = rs.getString("email");


Object[] obj = {String.valueOf(i),partyname,gstnumber,mobilenumber,email};
DefaultTableModel model = (DefaultTableModel)partytable.getModel();
model.addRow(obj);

i++;
}

}
catch (Exception e){
e.printStackTrace();
}



}

public static void insertVehicleTable(){

try{


Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT * FROM newvehicle where username = ?";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, user);
ResultSet rs = pst.executeQuery();

int i = 1;
while(rs.next()){

String vehicleno = rs.getString("vehiclenumber");
String vehicletype = rs.getString("vehicletype");
String vehicleowner = rs.getString("ownername");
String mobilenumber = rs.getString("mobileno");


Object[] obj = {String.valueOf(i),vehicleno,vehicletype,vehicleowner,mobilenumber};
DefaultTableModel model = (DefaultTableModel)vehicletable.getModel();
model.addRow(obj);

i++;
}

}
catch (Exception e){
e.printStackTrace();
}



}
public static void insertBillTable(){

try{


Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT * FROM newbill where username = ?";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, user);
ResultSet rs = pst.executeQuery();


while(rs.next()){
SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
String date = d.format(rs.getDate("date"));
String billnumber = rs.getString("billno");
String partname = rs.getString("partyname");
Double freight = rs.getDouble("freight");
Double parking = rs.getDouble("parking");
Double other = rs.getDouble("othercharges");
Double total = rs.getDouble("total");

Object[] obj = {date,billnumber,partname,String.valueOf(freight),String.valueOf(parking),String.valueOf(other),String.valueOf(total)};
DefaultTableModel model = (DefaultTableModel)billtable.getModel();
model.addRow(obj);


}

}
catch (Exception e){
e.printStackTrace();
}



}

public static void showVehicleValues(String vehno){

        ResultSet rs = null;

try{
        
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "select * from newvehicle where vehiclenumber ='"+vehno+"' and username ='"+user+"'";
Statement st = con.createStatement();
rs = st.executeQuery(querry);

if(rs.next()){
String address = rs.getString("address");
String state = rs.getString("state");
String pincode = rs.getString("pincode");
String email = rs.getString("email");
String bankname = rs.getString("bankaccountname");
String holdername = rs.getString("accountholdername");
String accountno = rs.getString("accountno");
String accountifsc = rs.getString("ifsc");

vashow.setText(address + " " + state + " " + pincode);
veshow.setText(email);
vbnshow.setText(bankname);
vahnshow.setText(holdername);
vanshow.setText(accountno);
vifscshow.setText(accountifsc);

  } else{

}   
 }catch(Exception e){
e.printStackTrace();
}

}

public static void showPartyValues(String gstno){

        ResultSet rs = null;

try{
        
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "select * from newparty where gstno ='"+gstno+"' and username ='"+user+"'";
Statement st = con.createStatement();
rs = st.executeQuery(querry);

if(rs.next()){
String address = rs.getString("address");
String state = rs.getString("state");
String pincode = rs.getString("pincode");
String gstnumber = rs.getString("gstno");
String bankname = rs.getString("bankaccountname");
String holdername = rs.getString("accountholdername");
String accountno = rs.getString("accountno");
String accountifsc = rs.getString("ifsc");

pashow.setText(address + " " + state + " " + pincode);
pgstshow.setText(gstnumber);
pbnshow.setText(bankname);
pahnshow.setText(holdername);
panshow.setText(accountno);
pifscshow.setText(accountifsc);

  } else{

}   
 }catch(Exception e){
e.printStackTrace();
}

}

public static void showDriverValues(String panno){

        ResultSet rs = null;

try{
        
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "select * from newdriver where pannumber ='"+panno+"' and username ='"+user+"'";
Statement st = con.createStatement();
rs = st.executeQuery(querry);

if(rs.next()){
String address = rs.getString("address");
String state = rs.getString("state");
String pincode = rs.getString("pincode");
String email = rs.getString("email");
String bankname = rs.getString("bankaccountname");
String holdername = rs.getString("accountholdername");
String accountno = rs.getString("accountno");
String accountifsc = rs.getString("ifsc");

dashow.setText(address + " " + state + " " + pincode);
deshow.setText(email);
dbnshow.setText(bankname);
dahnshow.setText(holdername);
danshow.setText(accountno);
difscshow.setText(accountifsc);

  } else{

}   
 }catch(Exception e){
e.printStackTrace();
}

}

public static void showBillValues(String bno){

        ResultSet rs = null;

try{
        
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "select * from newbill where billno ='"+bno+"' and username ='"+user+"'";
Statement st = con.createStatement();
rs = st.executeQuery(querry);

if(rs.next()){
String from = rs.getString("dispatchedfrom");
String to = rs.getString("destination");
String drivername = rs.getString("driver");
String vehicleno = rs.getString("vehicleno");
String remarks = rs.getString("remarks");

bfrom.setText(from);
bto.setText(to);
bdnshow.setText(drivername);
bvnshow.setText(vehicleno);
brshow.setText(remarks);

  } else{

}   
 }catch(Exception e){
e.printStackTrace();
}

}


public void searchBill(String str){

DefaultTableModel model = (DefaultTableModel)billtable.getModel();
TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
billtable.setRowSorter(trs);
trs.setRowFilter(RowFilter.regexFilter(str));

}

}
