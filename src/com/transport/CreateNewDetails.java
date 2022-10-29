
package com.transport;

import static com.transport.Welcome.*;
import static com.transport.InsertTableValue.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class CreateNewDetails {

Date bdate;

//For Inserting New Party Details into Database

boolean newPartyValidation(){
String partyname = pname.getText();
String partygst = pgst.getText();
String partyaddress = paddress.getText();
String partycity = pcity.getText();
String partystate = pstate.getText();
String partypincode = ppincode.getText();
String partymob = pmob.getText();

if(partyname.equals("")){
JOptionPane.showMessageDialog(null, "Party Details Section is Mandatory");
return false;
}

if(partygst.equals("")){
JOptionPane.showMessageDialog(null, "Party Details Section is Mandatory");
return false;
}

checkGstNo();

if(partygst.equals(dbGstNo)){
JOptionPane.showMessageDialog(null, "Party already exist");
return false;
}

if(partyaddress.equals("")){
JOptionPane.showMessageDialog(null, "Party Details Section is Mandatory");
return false;
}

if(partycity.equals("")){
JOptionPane.showMessageDialog(null, "Party Details Section is Mandatory");
return false;
}

if(partystate.equals("")){
JOptionPane.showMessageDialog(null, "Party Details Section is Mandatory");
return false;
}

if(partypincode.equals("")){
JOptionPane.showMessageDialog(null, "Party Details Section is Mandatory");
return false;
}

if(partymob.equals("")){
JOptionPane.showMessageDialog(null, "Party Mobile Number is Mandatory");
return false;
}
return true;
}
    
void createNewParty(){

String partyname = "NA";
String partygst = "NA";
String partyaddress = "NA";
String partycity = "NA";
String partystate = "NA";
String partypincode = "NA";
String partymob = "NA";
String partyemail = "NA";
String partybankname = "NA";
String partyholdername = "NA";
String partyaccountno = "NA";
String partyifsc = "NA";
        
partyname = toUpperCase(pname.getText());
partygst = toUpperCase(pgst.getText());
partyaddress = toUpperCase(paddress.getText());
partycity = toUpperCase(pcity.getText());
partystate = toUpperCase(pstate.getText());
partypincode = ppincode.getText();
partymob = pmob.getText();
partyemail = toUpperCase(pemail.getText());
partybankname = toUpperCase(pbankaccount.getText());
partyaccountno = paccountno.getText();
partyholdername = toUpperCase(pholdername.getText());
partyifsc = toUpperCase(pifsc.getText());

try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "INSERT INTO `newparty`(`partyname`, `gstno`, `address`, `city`, `state`, `pincode`, `mobileno`, `email`, `bankaccountname`, `accountno`, `accountholdername`, `ifsc`, `username`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
PreparedStatement stmt = con.prepareStatement(querry);

                    stmt.setString(1, partyname);
                    stmt.setString(2, partygst);
                    stmt.setString(3, partyaddress);
                    stmt.setString(4, partycity);
                    stmt.setString(5, partystate);
                    stmt.setString(6, partypincode);
                    stmt.setString(7, partymob);
                    stmt.setString(8, partyemail);
                    stmt.setString(9, partybankname);
                    stmt.setString(10, partyaccountno);
                    stmt.setString(11, partyholdername);
                    stmt.setString(12, partyifsc);
                    stmt.setString(13, user);

int i = stmt.executeUpdate();
if (i>0){
JOptionPane.showMessageDialog(null, "Saved Successfully");
}else{
JOptionPane.showMessageDialog(null,"Value out of range");
}

}
catch(Exception e){
e.printStackTrace();
JOptionPane.showMessageDialog(null,"Fill all the details correctly");
}
}


//For Inserting New Driver Details into Database

boolean NewDriverValidation(){

String drivername = dname.getText();
String driverlicenceno = dlnum.getText();
String driverpanno = dpnum.getText();
String driveraddress = daddress.getText();
String driverstate = dstate.getText();
String driverpincode = dpincode.getText();
String drivermob = dmob.getText();

if(drivername.equals("")){
JOptionPane.showMessageDialog(null, "Driver Details Section is Mandatory");
return false;
}

if(driverlicenceno.equals("")){
JOptionPane.showMessageDialog(null, "Driver Details Section is Mandatory");
return false;
}

if(driverpanno.equals("")){
JOptionPane.showMessageDialog(null, "Driver Details Section is Mandatory");
return false;
}

if(driveraddress.equals("")){
JOptionPane.showMessageDialog(null, "Driver Details Section is Mandatory");
return false;
}

if(driverstate.equals("")){
JOptionPane.showMessageDialog(null, "Driver Details Section is Mandatory");
return false;
}

if(driverpincode.equals("")){
JOptionPane.showMessageDialog(null, "Driver Details Section is Mandatory");
return false;
}

if(drivermob.equals("")){
JOptionPane.showMessageDialog(null, "Driver Mobile Number is Mandatory");
return false;
}

return true;
}

void insertNewDriverDetails(){

String drivername = "NA";
String driverlicenceno = "NA";
String driverpanno = "NA";
String driveraddress = "NA";
String driverstate = "NA";
String driverpincode = "NA";
String drivermob = "NA";
String driveremail = "NA";
String driverbankname = "NA";
String driverholdername = "NA";
String driveraccountno = "NA";
String driverifsc = "NA";

drivername = toUpperCase(dname.getText());
driverlicenceno = toUpperCase(dlnum.getText());
driverpanno = toUpperCase(dpnum.getText());
driveraddress = toUpperCase(daddress.getText());
driverstate = toUpperCase(dstate.getText());
driverpincode = dpincode.getText();
drivermob = dmob.getText();
driveremail = toUpperCase(demail.getText());
driverbankname = toUpperCase(dbankaccount.getText());
driveraccountno = daccountno.getText();
driverholdername = toUpperCase(dholdername.getText());
driverifsc = toUpperCase(difsc.getText());

try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "INSERT INTO `newdriver`(`driverfullname`, `licencenumber`, `pannumber`, `address`, `state`, `pincode`, `mobileno`, `email`, `bankaccountname`, `accountholdername`, `accountno`, `ifsc`, `username`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
PreparedStatement stmt = con.prepareStatement(querry);

                    stmt.setString(1, drivername);
                    stmt.setString(2, driverlicenceno);
                    stmt.setString(3, driverpanno);
                    stmt.setString(4, driveraddress);
                    stmt.setString(5, driverstate);
                    stmt.setString(6, driverpincode);
                    stmt.setString(7, drivermob);
                    stmt.setString(8, driveremail);
                    stmt.setString(9, driverbankname);
                    stmt.setString(10, driverholdername);
                    stmt.setString(11, driveraccountno);
                    stmt.setString(12, driverifsc);
                    stmt.setString(13, user);

int i = stmt.executeUpdate();
if (i>0){
JOptionPane.showMessageDialog(null,"Saved Successfully");
}else{
JOptionPane.showMessageDialog(null,"Value out of range");
}

}
catch(Exception e){
e.printStackTrace();
JOptionPane.showMessageDialog(null,"Fill all the details correctly");
}
}

//For Inserting New Vehicle Details into Database


boolean NewVehicleValidation(){

String vehicleno = vnum.getText();
String vehicletype = vtype.getText();
String ownername = vname.getText();
String owneraddress = vaddress.getText();
String ownerrstate = vstate.getText();
String ownerpincode = vpincode.getText();
String ownermob = vmob.getText();

if(vehicleno.equals("")){
JOptionPane.showMessageDialog(null, "Vehicle Details Section is Mandatory");
return false;
}

checkVehicleNo();

if(vehicleno.equals(dbVehicleNo)){
JOptionPane.showMessageDialog(null, "Vehicle Number already exist");
return false;
}

if(vehicletype.equals("")){
JOptionPane.showMessageDialog(null, "Vehicle Details Section is Mandatory");
return false;
}

if(ownername.equals("")){
JOptionPane.showMessageDialog(null, "Vehicle Details Section is Mandatory");
return false;
}

if(owneraddress.equals("")){
JOptionPane.showMessageDialog(null, "Vehicle Details Section is Mandatory");
return false;
}

if(ownerrstate.equals("")){
JOptionPane.showMessageDialog(null, "Vehicle Details Section is Mandatory");
return false;
}

if(ownerpincode.equals("")){
JOptionPane.showMessageDialog(null, "Vehicle Details Section is Mandatory");
return false;
}

if(ownermob.equals("")){
JOptionPane.showMessageDialog(null, "Owner Mobile Number is Mandatory");
return false;
}

return true;
}

void insertNewVehicleDetails(){

String vehiclenumber = "NA";
String vehicletype = "NA";
String ownername = "NA";
String owneraddress = "NA";
String ownerstate = "NA";
String ownerpincode = "NA";
String ownermob = "NA";
String owneremail = "NA";
String ownerbankname = "NA";
String ownerholdername = "NA";
String owneraccountno = "NA";
String ownerifsc = "NA";

vehiclenumber = toUpperCase(vnum.getText());
vehicletype = toUpperCase(vtype.getText());
ownername = toUpperCase(vname.getText());
owneraddress = toUpperCase(vaddress.getText());
ownerstate = toUpperCase(vstate.getText());
ownerpincode = vpincode.getText();
ownermob = vmob.getText();
owneremail = toUpperCase(vemail.getText());
ownerbankname = toUpperCase(vbankaccount.getText());
owneraccountno = vaccountno.getText();
ownerholdername = toUpperCase(vholdername.getText());
ownerifsc = toUpperCase(vifsc.getText());

try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "INSERT INTO `newvehicle`(`vehiclenumber`, `vehicletype`, `ownername`, `address`, `state`, `pincode`, `mobileno`, `email`, `bankaccountname`, `accountholdername`, `accountno`, `ifsc`, `username`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
PreparedStatement stmt = con.prepareStatement(querry);

                    stmt.setString(1, vehiclenumber);
                    stmt.setString(2, vehicletype);
                    stmt.setString(3, ownername);
                    stmt.setString(4, owneraddress);
                    stmt.setString(5, ownerstate);
                    stmt.setString(6, ownerpincode);
                    stmt.setString(7, ownermob);
                    stmt.setString(8, owneremail);
                    stmt.setString(9, ownerbankname);
                    stmt.setString(10, ownerholdername);
                    stmt.setString(11, owneraccountno);
                    stmt.setString(12, ownerifsc);
                    stmt.setString(13, user);

int i = stmt.executeUpdate();
if (i>0){
JOptionPane.showMessageDialog(null,"Saved Successfully");
}else{
JOptionPane.showMessageDialog(null,"Value out of range");
}

}
catch(Exception e){
e.printStackTrace();
JOptionPane.showMessageDialog(null,"Fill all the details correctly");
}
}

boolean NewBillValidation(){

SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy"); 

String billdate = d.format(ndate.getDate());
String billno = nbill.getText();
String partyname = nparty.getSelectedItem().toString();
String from = nfrom.getText();
String to = nto.getText();
String vehicleno = nvehicle.getSelectedItem().toString();
String drivername = ndriver.getSelectedItem().toString();
String nfreight = c1.getText();


if(billdate == null){

JOptionPane.showMessageDialog(null, "Fill all the details");
return false;
}

if(billno.equals("")){

JOptionPane.showMessageDialog(null, "Fill all the details");
return false;
}

checkBillNo();

if(billno.equals(dbBillNo)){
JOptionPane.showMessageDialog(null, "Bill number already exist");
return false;
}

if(partyname.equals("")){

JOptionPane.showMessageDialog(null, "Fill all the details");
return false;
}

if(from.equals("")){

JOptionPane.showMessageDialog(null, "Fill all the details");
return false;
}

if(to.equals("")){

JOptionPane.showMessageDialog(null, "Fill all the details");
return false;
}

if(vehicleno.equals("")){

JOptionPane.showMessageDialog(null, "Fill all the details");
return false;
}

if(drivername.equals("")){

JOptionPane.showMessageDialog(null, "Fill all the details");
return false;
}

if(billdate.equals("")){

JOptionPane.showMessageDialog(null, "Fill all the details");
return false;
}

if(nfreight.equals("")){

JOptionPane.showMessageDialog(null, "Freight connot be null");
return false;
}

return true;
}

void insertNewBillDetails(){

SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd"); 
String billdate = d.format(ndate.getDate());
String billno = toUpperCase(nbill.getText());
String partyname = toUpperCase(nparty.getSelectedItem().toString());
String from = toUpperCase(nfrom.getText());
String to = toUpperCase(nto.getText());
String vehicleno = toUpperCase(nvehicle.getSelectedItem().toString());
String drivername = toUpperCase(ndriver.getSelectedItem().toString());
Double nfreight = Double.parseDouble(c1.getText());
Double nparking = Double.parseDouble(c2.getText());
Double nother = Double.parseDouble(c3.getText());
Double ntotal = Double.parseDouble(ct.getText());
String remarks = toUpperCase(remark.getText());


try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "INSERT INTO `newbill`(`date`, `billno`, `partyname`, `dispatchedfrom`, `destination`, `vehicleno`, `driver`, `freight`, `parking`, `othercharges`, `total`, `remarks`, `username`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
PreparedStatement stmt = con.prepareStatement(querry);

                    stmt.setString(1, billdate);
                    stmt.setString(2, billno);
                    stmt.setString(3, partyname);
                    stmt.setString(4, from);
                    stmt.setString(5, to);
                    stmt.setString(6, vehicleno);
                    stmt.setString(7, drivername);
                    stmt.setDouble(8, nfreight);
                    stmt.setDouble(9, nparking);
                    stmt.setDouble(10, nother);
                    stmt.setDouble(11, ntotal);
                    stmt.setString(12, remarks);
                    stmt.setString(13, user);

int i = stmt.executeUpdate();
if (i>0){
JOptionPane.showMessageDialog(null,"Saved Successfully");
}else{
JOptionPane.showMessageDialog(null,"Value out of range");
}

}
catch(Exception e){
e.printStackTrace();
JOptionPane.showMessageDialog(null,"Fill all the details correctly");
}
}


}
