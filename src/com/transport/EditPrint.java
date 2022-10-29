
package com.transport;

import static com.transport.InsertComboBoxValue.driverComboBox;
import static com.transport.InsertComboBoxValue.partyComboBox;
import static com.transport.InsertComboBoxValue.vehicleComboBox;
import static com.transport.InsertTableValue.user;
import static com.transport.Welcome.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;


public class EditPrint {

ColorOfMenuOption cmo = new ColorOfMenuOption();
ClearData cd = new ClearData();
InsertTableValue itv = new InsertTableValue();
PrintBill pb = new PrintBill();
InsertComboBoxValue icb = new InsertComboBoxValue();   

public void editBill(){

mainscreen.setSelectedIndex(0);
dscreen.setSelectedIndex(1);
lscreen.setSelectedIndex(2);
cmo.colorBillLabel();
updatebill.setVisible(true);
savebill.setVisible(false);
clearbill.setVisible(false);
nbill.setEditable(false);


}

public static void editBillValues(String bno){

        ResultSet rs = null;

try{
        
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "select * from newbill where billno ='"+bno+"' and username ='"+user+"'";
Statement st = con.createStatement();
rs = st.executeQuery(querry);

if(rs.next()){
Date date = rs.getDate("date");
String from = rs.getString("dispatchedfrom");
String to = rs.getString("destination");
String partyname = rs.getString("partyname");
String drivername = rs.getString("driver");
String vehicleno = rs.getString("vehicleno");
Double freight = rs.getDouble("freight");
Double parking = rs.getDouble("parking");
Double other = rs.getDouble("othercharges");
Double total = rs.getDouble("total");
String remarks = rs.getString("remarks");

nbill.setText(bno);
ndate.setDate(date);
nfrom.setText(from);
nto.setText(to);
partyComboBox();
driverComboBox();
vehicleComboBox();
nparty.setSelectedItem(partyname);
ndriver.setSelectedItem(drivername);
nvehicle.setSelectedItem(vehicleno);
c1.setText(String.valueOf(freight));
c2.setText(String.valueOf(parking));
c3.setText(String.valueOf(other));
ct.setText(String.valueOf(total));
remark.setText(remarks);

  } else{

}   
 }catch(Exception e){
e.printStackTrace();
}

}

boolean updateBillValidation(){

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

void updateNewBillDetails(){

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
String querry = "UPDATE `newbill` SET `date`=?,`partyname`=?,`dispatchedfrom`=?,`destination`=?,`vehicleno`=?,`driver`=?,`freight`=?,`parking`=?,`othercharges`=?,`total`=?,`remarks`=? WHERE `billno`=? and `username`=?";
PreparedStatement stmt = con.prepareStatement(querry);

                    stmt.setString(1, billdate);
                    stmt.setString(2, partyname);
                    stmt.setString(3, from);
                    stmt.setString(4, to);
                    stmt.setString(5, vehicleno);
                    stmt.setString(6, drivername);
                    stmt.setDouble(7, nfreight);
                    stmt.setDouble(8, nparking);
                    stmt.setDouble(9, nother);
                    stmt.setDouble(10, ntotal);
                    stmt.setString(11, remarks);
                    stmt.setString(12, billno);
                    stmt.setString(13, user);

int i = stmt.executeUpdate();
if (i>0){
JOptionPane.showMessageDialog(null,"Saved Successfully");
mainscreen.setSelectedIndex(0);
dscreen.setSelectedIndex(5);
lscreen.setSelectedIndex(0);
cd.ClearNewBill();
cd.clearBillTableLabel();
DefaultTableModel model = (DefaultTableModel)billtable.getModel();
model.setRowCount(0);        
itv.insertBillTable();
}else{
JOptionPane.showMessageDialog(null,"Value out of range");
}

}
catch(Exception e){
e.printStackTrace();
JOptionPane.showMessageDialog(null,"Fill all the details correctly");
}
}

void deleteBillDetails(String billno){


try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "DELETE FROM `newbill` WHERE billno =? and username =?";
PreparedStatement stmt = con.prepareStatement(querry);

                    stmt.setString(1, billno);
                    stmt.setString(2, user);

stmt.executeUpdate();
cd.clearBillTableLabel();
DefaultTableModel model = (DefaultTableModel)billtable.getModel();
model.setRowCount(0);        
itv.insertBillTable();

}
catch(Exception e){
e.printStackTrace();
JOptionPane.showMessageDialog(null,"Fill all the details correctly");
}
}

public void printBill(){

PrinterJob job = PrinterJob.getPrinterJob();
job.setJobName("Print Data");
            
job.setPrintable(new Printable(){
  public int print(Graphics pg,PageFormat pf, int pageNum){
   pf.setOrientation(PageFormat.LANDSCAPE);
   if(pageNum > 0){
    return Printable.NO_SUCH_PAGE;
   }
                
   Graphics2D g2 = (Graphics2D)pg;
   g2.translate(pf.getImageableX(), pf.getImageableY());
   g2.scale(0.47,0.47);
                
   pb.printpanel.print(g2);
         
               
   return Printable.PAGE_EXISTS;
                         
                
 }
  });
 boolean ok = job.printDialog();
   if(ok){
    try{
            
        job.print();
        }
        catch (PrinterException ex){
	 ex.printStackTrace();
        }
    }

}



}
