
package com.transport;
import static com.transport.InsertTableValue.user;
import static com.transport.Welcome.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


public class PrintBill extends javax.swing.JFrame {

String partyname;

    public PrintBill() {
        initComponents();
        this.setResizable(false);
        this.setExtendedState(PrintBill.NORMAL);
        scpane.getVerticalScrollBar().setUnitIncrement(16);
    }



public void getCompanyData(){


try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT * FROM signup where username = ?";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, user);
ResultSet rs = pst.executeQuery();

if(rs.next()){

String companyname = rs.getString("companyname");
String companyaddress = rs.getString("address");
String companycity = rs.getString("city");
String companystate = rs.getString("state");
String companypincode = rs.getString("pincode");
String gstnumber = rs.getString("gst");
String email = rs.getString("email");

pcname.setText(companyname);
pcaddress.setText(companyaddress+" "+companycity);
pcstate.setText(companystate+" "+companypincode);
pcgstno.setText(gstnumber);
pcemail.setText(email);


}

}
catch (Exception e){
e.printStackTrace();
}



}

public void getBillData(String bno){


try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT * FROM newbill where billno = ? and username = ?";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, bno);
pst.setString(2, user);
ResultSet rs = pst.executeQuery();

if(rs.next()){

SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");

//partyname = rs.getString("companyname");
Double freight = rs.getDouble("freight");
Double parking = rs.getDouble("parking");
Double other = rs.getDouble("othercharges");
Double total = rs.getDouble("total");
String from = rs.getString("dispatchedfrom");
String to = rs.getString("destination");
String billdate = d.format(rs.getDate("date"));
String drivername = rs.getString("driver");
String vehicleno = rs.getString("vehicleno");

pbillno.setText(bno);
pbilldate.setText(billdate);
pfrom.setText(from);
pto.setText(to);
pdname.setText(drivername);
pvno.setText(vehicleno);
pfreight.setText(String.valueOf(freight));
pparking.setText(String.valueOf(parking));
pother.setText(String.valueOf(other));
ptotal.setText(String.valueOf(total));

}

}
catch (Exception e){
e.printStackTrace();
}



}

public void getPartyData(String partyname){


try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT * FROM newparty where partyname = ? and username = ?";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, partyname);
pst.setString(2, user);
ResultSet rs = pst.executeQuery();

if(rs.next()){

String partyaddress = rs.getString("address");
String partycity = rs.getString("city");
String partystate = rs.getString("state");
String partypincode = rs.getString("pincode");
String partygstnumber = rs.getString("gstno");
String partyemail = rs.getString("email");
String partycontact = rs.getString("mobileno");

ppname.setText(partyname);
ppaddress.setText(partyaddress+" "+partycity+" "+partystate+" "+partypincode);
ppgstno.setText(partygstnumber);
ppemail.setText(partyemail);
ppcontact.setText(partycontact);

}

}
catch (Exception e){
e.printStackTrace();
}



}




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scpane = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        pppbill = new javax.swing.JPanel();
        printpanel = new javax.swing.JPanel();
        pcname = new javax.swing.JLabel();
        pcstate = new javax.swing.JLabel();
        ppname = new javax.swing.JLabel();
        pcgstno = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cGstNo1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pcemail = new javax.swing.JLabel();
        pcaddress = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pto = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pfrom = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        cGstNo2 = new javax.swing.JLabel();
        pfreight = new javax.swing.JLabel();
        cGstNo4 = new javax.swing.JLabel();
        painwords = new javax.swing.JLabel();
        cGstNo6 = new javax.swing.JLabel();
        ptotal = new javax.swing.JLabel();
        cGstNo8 = new javax.swing.JLabel();
        pother = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        cGstNo10 = new javax.swing.JLabel();
        pparking = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        cGstNo12 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        ccc2 = new javax.swing.JLabel();
        pbilldate = new javax.swing.JLabel();
        pbillno = new javax.swing.JLabel();
        ccc3 = new javax.swing.JLabel();
        cGstNo14 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        cGstNo15 = new javax.swing.JLabel();
        ppaddress = new javax.swing.JLabel();
        cGstNo17 = new javax.swing.JLabel();
        ppgstno = new javax.swing.JLabel();
        ccc4 = new javax.swing.JLabel();
        ppemail = new javax.swing.JLabel();
        ccc5 = new javax.swing.JLabel();
        ppcontact = new javax.swing.JLabel();
        ccc6 = new javax.swing.JLabel();
        pdname = new javax.swing.JLabel();
        ccc7 = new javax.swing.JLabel();
        pvno = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Print Preview");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scpane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scpane.setToolTipText("");

        jPanel1.setMinimumSize(new java.awt.Dimension(1370, 1450));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pppbill.setBackground(new java.awt.Color(255, 255, 255));
        pppbill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        printpanel.setBackground(new java.awt.Color(255, 255, 255));
        printpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        printpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pcname.setFont(new java.awt.Font("Algerian", 1, 48)); // NOI18N
        pcname.setForeground(new java.awt.Color(0, 32, 63));
        pcname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pcname.setText("COMPANY NAME");
        printpanel.add(pcname, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 570, 60));

        pcstate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pcstate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pcstate.setText("STATE PINCODE");
        printpanel.add(pcstate, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 350, 20));

        ppname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printpanel.add(ppname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 630, 20));

        pcgstno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printpanel.add(pcgstno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 220, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("GST NO :");
        printpanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 20));

        cGstNo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cGstNo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cGstNo1.setText("AMOUNT");
        printpanel.add(cGstNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, 130, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("EMAIL :");
        printpanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, 20));

        pcemail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printpanel.add(pcemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 360, 20));

        pcaddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pcaddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pcaddress.setText("COMPANY ADDRESS");
        printpanel.add(pcaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 350, 20));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.black));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        pto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(pto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 150, 60));

        printpanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 290, 150, 90));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.black));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pfrom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pfrom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(pfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 150, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FROM");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        printpanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 190, 150, 90));
        printpanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 440, 10));
        printpanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1100, 10));
        printpanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 860, 10));

        cGstNo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cGstNo2.setText("PARTY NAME :");
        printpanel.add(cGstNo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 120, 20));

        pfreight.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pfreight.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        printpanel.add(pfreight, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 460, 130, 30));

        cGstNo4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cGstNo4.setText("PARTICULARS");
        printpanel.add(cGstNo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 130, 30));

        painwords.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printpanel.add(painwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 790, 480, 30));

        cGstNo6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cGstNo6.setText("PARKING");
        printpanel.add(cGstNo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 130, 30));

        ptotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ptotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        printpanel.add(ptotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 1160, 130, 30));

        cGstNo8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cGstNo8.setText("OTHER");
        printpanel.add(cGstNo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 130, 30));

        pother.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pother.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        printpanel.add(pother, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 540, 130, 30));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        printpanel.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, 20, 790));
        printpanel.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1190, 1100, 10));

        cGstNo10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cGstNo10.setText("FREIGHT");
        printpanel.add(cGstNo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 130, 30));

        pparking.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pparking.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        printpanel.add(pparking, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 500, 130, 30));
        printpanel.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 1100, 10));
        printpanel.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1150, 1100, 10));

        cGstNo12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cGstNo12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cGstNo12.setText("SEAL & SIGN");
        printpanel.add(cGstNo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 1240, 120, 40));
        printpanel.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 1100, 10));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        printpanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, 20, 230));

        ccc2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ccc2.setText("BILL DATE :");
        printpanel.add(ccc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, 20));

        pbilldate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printpanel.add(pbilldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 120, 20));

        pbillno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printpanel.add(pbillno, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 130, 20));

        ccc3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ccc3.setText("BILL NO :");
        printpanel.add(ccc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 80, 20));

        cGstNo14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cGstNo14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cGstNo14.setText("TOTAL");
        printpanel.add(cGstNo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1160, 70, 30));
        printpanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 860, 10));

        cGstNo15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cGstNo15.setText("ADDRESS :");
        printpanel.add(cGstNo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 130, 20));

        ppaddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printpanel.add(ppaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 670, 20));

        cGstNo17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cGstNo17.setText("GST NO :");
        printpanel.add(cGstNo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 130, 20));

        ppgstno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printpanel.add(ppgstno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 520, 20));

        ccc4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ccc4.setText("EMAIL :");
        printpanel.add(ccc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 100, 20));

        ppemail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printpanel.add(ppemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 370, 20));

        ccc5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ccc5.setText("CONTACT :");
        printpanel.add(ccc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 100, 20));

        ppcontact.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printpanel.add(ppcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 190, 20));

        ccc6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ccc6.setText("DRIVER NAME :");
        printpanel.add(ccc6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 20));

        pdname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printpanel.add(pdname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 240, 20));

        ccc7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ccc7.setText("VEHICLE NO :");
        printpanel.add(ccc7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 120, 20));

        pvno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printpanel.add(pvno, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 150, 20));

        pppbill.add(printpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 1100, 1300));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Copyright © 2022 Transport Management System");
        pppbill.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 1440, 320, -1));

        jPanel1.add(pppbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1370, 1470));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(173, 239, 209));
        jButton1.setFont(new java.awt.Font("Algerian", 0, 13)); // NOI18N
        jButton1.setText("print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 120, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 100));

        scpane.setViewportView(jPanel1);

        getContentPane().add(scpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 990));

        setSize(new java.awt.Dimension(1410, 1547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                pf.setOrientation(PageFormat.PORTRAIT);
                if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.47,0.47);

                pppbill.print(g2);

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
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cGstNo1;
    private javax.swing.JLabel cGstNo10;
    private javax.swing.JLabel cGstNo12;
    private javax.swing.JLabel cGstNo14;
    private javax.swing.JLabel cGstNo15;
    private javax.swing.JLabel cGstNo17;
    private javax.swing.JLabel cGstNo2;
    private javax.swing.JLabel cGstNo4;
    private javax.swing.JLabel cGstNo6;
    private javax.swing.JLabel cGstNo8;
    private javax.swing.JLabel ccc2;
    private javax.swing.JLabel ccc3;
    private javax.swing.JLabel ccc4;
    private javax.swing.JLabel ccc5;
    private javax.swing.JLabel ccc6;
    private javax.swing.JLabel ccc7;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel painwords;
    public static javax.swing.JLabel pbilldate;
    public static javax.swing.JLabel pbillno;
    public static javax.swing.JLabel pcaddress;
    public static javax.swing.JLabel pcemail;
    public static javax.swing.JLabel pcgstno;
    public static javax.swing.JLabel pcname;
    public static javax.swing.JLabel pcstate;
    public static javax.swing.JLabel pdname;
    private javax.swing.JLabel pfreight;
    private javax.swing.JLabel pfrom;
    private javax.swing.JLabel pother;
    private javax.swing.JLabel ppaddress;
    private javax.swing.JLabel pparking;
    public static javax.swing.JLabel ppcontact;
    public static javax.swing.JLabel ppemail;
    private javax.swing.JLabel ppgstno;
    public static javax.swing.JLabel ppname;
    private javax.swing.JPanel pppbill;
    public static javax.swing.JPanel printpanel;
    private javax.swing.JLabel pto;
    private javax.swing.JLabel ptotal;
    public static javax.swing.JLabel pvno;
    private javax.swing.JScrollPane scpane;
    // End of variables declaration//GEN-END:variables
}
