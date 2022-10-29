
package com.transport;

import static com.transport.InsertTableValue.user;
import static com.transport.PrintBill.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class Welcome extends javax.swing.JFrame {

    public Welcome() {
        initComponents();
        dt();
        times();
        setTitle("Transport Management");
        this.setExtendedState(Login.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/tansport/images/truck_30px.png")));
    }


Color defaultcolor = new Color(173,239,209);
public static double firstNum, secondNum, answer;
public static String operator, dbBillNo, dbVehicleNo, dbGstNo;


InsertTableValue itv = new InsertTableValue();
CreateNewDetails cnd = new CreateNewDetails();
InsertComboBoxValue cbv = new InsertComboBoxValue();
ColorOfMenuOption cmo = new ColorOfMenuOption();
ClearData cd = new ClearData();
EditPrint ep = new EditPrint();
PrintBill pb = new PrintBill();
ReportChart rc = new ReportChart();




public void dt(){

Date d = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("dd MMM, YYYY");
String dd = sdf.format(d);
lDate.setText(dd);

}


Timer t ;
SimpleDateFormat st;

public void times(){


t = new Timer(0, new ActionListener(){

@Override
public void actionPerformed(ActionEvent e){

Date dt = new Date();
st = new SimpleDateFormat("hh:mm:ss a");

String tt = st.format(dt);

lTime.setText(tt);
}

});

t.start();

}





public static void checkBillNo(){

String bno = toUpperCase(nbill.getText());
ResultSet rs = null;

try{
        
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "select * from newbill where billno ='"+bno+"' and username ='"+user+"'";
Statement st = con.createStatement();
rs = st.executeQuery(querry);

if(rs.next()){
dbBillNo = rs.getString("billno");

  } else{

}   
 }catch(Exception e){
e.printStackTrace();
}


}

public static void checkVehicleNo(){

String vno = toUpperCase(vnum.getText());
ResultSet rs = null;

try{
        
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "select * from newbill where billno ='"+vno+"' and username ='"+user+"'";
Statement st = con.createStatement();
rs = st.executeQuery(querry);

if(rs.next()){
dbVehicleNo = rs.getString("vehiclenumber");

  } else{

}   
 }catch(Exception e){
e.printStackTrace();
}


}

public static void checkGstNo(){

String gstno = toUpperCase(pgst.getText());
ResultSet rs = null;

try{
        
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "select * from newparty where gstno ='"+gstno+"' and username ='"+user+"'";
Statement st = con.createStatement();
rs = st.executeQuery(querry);

if(rs.next()){
dbGstNo = rs.getString("gstno");

  } else{

}   
 }catch(Exception e){
e.printStackTrace();
}


}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainscreen = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        wel = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        lDate = new javax.swing.JLabel();
        lTime = new javax.swing.JLabel();
        wel1 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notedata = new javax.swing.JTextArea();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        sc = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        btnback1 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btnsub = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btndot = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnequal = new javax.swing.JButton();
        btndiv = new javax.swing.JButton();
        btnmul = new javax.swing.JButton();
        btncls = new javax.swing.JButton();
        dscreen = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        nc = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        nto = new javax.swing.JTextField();
        ct = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        remark = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel64 = new javax.swing.JLabel();
        nvehicle = new javax.swing.JComboBox<>();
        nbill = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel66 = new javax.swing.JLabel();
        c1 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        nfrom = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        c2 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        ndriver = new javax.swing.JComboBox<>();
        c3 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel73 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        savebill = new javax.swing.JButton();
        clearbill = new javax.swing.JButton();
        nparty = new javax.swing.JComboBox<>();
        ndate = new com.toedter.calendar.JDateChooser();
        jLabel76 = new javax.swing.JLabel();
        updatebill = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        pgst = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        pcity = new javax.swing.JTextField();
        ppincode = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        paddress = new javax.swing.JTextField();
        pstate = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        pbankaccount = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        pemail = new javax.swing.JTextField();
        pmob = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        paccountno = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        pifsc = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel90 = new javax.swing.JLabel();
        pholdername = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        vtype = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        vnum = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        vaddress = new javax.swing.JTextField();
        vpincode = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        vname = new javax.swing.JTextField();
        vstate = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        vbankaccount = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        vemail = new javax.swing.JTextField();
        vmob = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        vaccountno = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        vifsc = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel105 = new javax.swing.JLabel();
        vholdername = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        newv = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        dlnum = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        dname = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        daddress = new javax.swing.JTextField();
        dpincode = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        dpnum = new javax.swing.JTextField();
        dstate = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        dbankaccount = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        demail = new javax.swing.JTextField();
        dmob = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        daccountno = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        difsc = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel120 = new javax.swing.JLabel();
        dholdername = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billtable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        brshow = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        bfrom = new javax.swing.JLabel();
        bdnshow = new javax.swing.JLabel();
        bvnshow = new javax.swing.JLabel();
        bto = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        bsearch = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        drivertable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        danshow = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        dashow = new javax.swing.JLabel();
        dbnshow = new javax.swing.JLabel();
        dahnshow = new javax.swing.JLabel();
        deshow = new javax.swing.JLabel();
        difscshow = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        partytable = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        panshow = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        pashow = new javax.swing.JLabel();
        pbnshow = new javax.swing.JLabel();
        pahnshow = new javax.swing.JLabel();
        pgstshow = new javax.swing.JLabel();
        pifscshow = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        vehicletable = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        vanshow = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        vashow = new javax.swing.JLabel();
        vbnshow = new javax.swing.JLabel();
        vahnshow = new javax.swing.JLabel();
        veshow = new javax.swing.JLabel();
        vifscshow = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        barchart = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tnbill = new javax.swing.JLabel();
        tcharge = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        reporttable = new javax.swing.JTable();
        lscreen = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        ldriver = new javax.swing.JLabel();
        lhome = new javax.swing.JLabel();
        lcreate = new javax.swing.JLabel();
        ibill = new javax.swing.JLabel();
        laccount = new javax.swing.JLabel();
        lparty = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lvehicle = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        partylabel = new javax.swing.JLabel();
        homelabel = new javax.swing.JLabel();
        billlabel = new javax.swing.JLabel();
        driverlabel = new javax.swing.JLabel();
        vehiclelabel = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        editbill = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(173, 239, 209));
        jPanel11.setPreferredSize(new java.awt.Dimension(2000, 980));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(173, 239, 209));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel11.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1710, 50));

        jPanel14.setBackground(new java.awt.Color(0, 32, 63));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wel.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        wel.setForeground(new java.awt.Color(173, 239, 209));
        wel.setText("(DESIGNED BY ASHWANI & AKASH)");
        jPanel14.add(wel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 230, 30));

        jLabel50.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(173, 239, 209));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tansport/images/logout_20px.png"))); // NOI18N
        jLabel50.setText("LOG OUT");
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(1820, 10, 90, 30));

        lDate.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        lDate.setForeground(new java.awt.Color(173, 239, 209));
        jPanel14.add(lDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 230, 30));

        lTime.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        lTime.setForeground(new java.awt.Color(173, 239, 209));
        lTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel14.add(lTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1710, 50, 200, 30));

        wel1.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        wel1.setForeground(new java.awt.Color(173, 239, 209));
        wel1.setText("welcome to Transport management system");
        jPanel14.add(wel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jPanel11.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 2000, 90));

        jPanel15.setBackground(new java.awt.Color(0, 32, 63));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(173, 239, 209));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 32, 63), 4));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setBackground(new java.awt.Color(0, 32, 63));
        jLabel51.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 32, 63));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("NOTEPAD");
        jPanel16.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, 30));

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        notedata.setColumns(20);
        notedata.setRows(5);
        notedata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                notedataKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                notedataKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(notedata);

        jPanel17.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 250));

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 250));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 210, 320));

        jPanel18.setBackground(new java.awt.Color(173, 239, 209));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 32, 63), 4));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                scKeyTyped(evt);
            }
        });
        jPanel19.add(sc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 50));

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 50));

        jLabel52.setBackground(new java.awt.Color(0, 32, 63));
        jLabel52.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 32, 63));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("CALCULATOR");
        jPanel18.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, 30));

        btnback1.setText("<");
        btnback1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnback1ActionPerformed(evt);
            }
        });
        jPanel18.add(btnback1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, 30));

        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel18.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 40, 30));

        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel18.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 40, 30));

        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel18.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 40, 30));

        btnsub.setText("-");
        btnsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubActionPerformed(evt);
            }
        });
        jPanel18.add(btnsub, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 40, 30));

        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel18.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 40, 30));

        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel18.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 40, 30));

        btnadd.setText("+");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel18.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 40, 70));

        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel18.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 40, 30));

        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel18.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 40, 30));

        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel18.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 40, 30));

        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel18.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 40, 30));

        btndot.setText(".");
        btndot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndotActionPerformed(evt);
            }
        });
        jPanel18.add(btndot, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 40, 30));

        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        jPanel18.add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 40, 30));

        btnequal.setText("=");
        btnequal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnequalActionPerformed(evt);
            }
        });
        jPanel18.add(btnequal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 90, 30));

        btndiv.setText("/");
        btndiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndivActionPerformed(evt);
            }
        });
        jPanel18.add(btndiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 40, 30));

        btnmul.setText("*");
        btnmul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmulActionPerformed(evt);
            }
        });
        jPanel18.add(btnmul, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, 30));

        btncls.setText("C");
        btncls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclsActionPerformed(evt);
            }
        });
        jPanel18.add(btncls, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 30));

        jPanel15.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, 320));

        jPanel11.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 180, 210, 800));

        dscreen.setBackground(new java.awt.Color(173, 239, 209));
        dscreen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(173, 239, 209)));
        dscreen.setMinimumSize(new java.awt.Dimension(1070, 760));
        dscreen.setPreferredSize(new java.awt.Dimension(1070, 780));

        jPanel21.setBackground(new java.awt.Color(0, 32, 63));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(173, 239, 209));
        jLabel58.setText("name of company");
        jPanel21.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 160, 30));

        jSeparator4.setBackground(new java.awt.Color(173, 239, 209));
        jPanel21.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1080, 20));

        nc.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        nc.setForeground(new java.awt.Color(173, 239, 209));
        jPanel21.add(nc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, 30));

        dscreen.addTab("tab1", jPanel21);

        jPanel22.setBackground(new java.awt.Color(0, 32, 63));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(173, 239, 209));
        jLabel61.setText("TO :");
        jPanel22.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 50, 30));

        jLabel62.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(173, 239, 209));
        jLabel62.setText("Remarks :");
        jPanel22.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 750, 90, 30));

        nto.setBackground(new java.awt.Color(173, 239, 209));
        nto.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jPanel22.add(nto, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, 200, 30));

        ct.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        ct.setForeground(new java.awt.Color(173, 239, 209));
        ct.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel22.add(ct, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 690, 150, 30));

        jLabel63.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(173, 239, 209));
        jLabel63.setText("from :");
        jPanel22.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 50, 30));

        remark.setBackground(new java.awt.Color(173, 239, 209));
        remark.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        remark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remarkActionPerformed(evt);
            }
        });
        jPanel22.add(remark, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 750, 330, 30));

        jSeparator2.setBackground(new java.awt.Color(173, 239, 209));
        jPanel22.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1070, 10));

        jSeparator3.setBackground(new java.awt.Color(173, 239, 209));
        jPanel22.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 720, 150, 10));

        jLabel64.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(173, 239, 209));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("amount");
        jPanel22.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 200, 70, 30));

        nvehicle.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        nvehicle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "na" }));
        jPanel22.add(nvehicle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 260, 30));

        nbill.setBackground(new java.awt.Color(173, 239, 209));
        nbill.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jPanel22.add(nbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 120, 30));

        jSeparator5.setBackground(new java.awt.Color(173, 239, 209));
        jPanel22.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1070, 10));

        jLabel66.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(173, 239, 209));
        jLabel66.setText("bill no :");
        jPanel22.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 70, 30));

        c1.setBackground(new java.awt.Color(173, 239, 209));
        c1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        c1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        c1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                c1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c1KeyTyped(evt);
            }
        });
        jPanel22.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 250, 120, 30));

        jLabel67.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(173, 239, 209));
        jLabel67.setText("date :");
        jPanel22.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 30));

        nfrom.setBackground(new java.awt.Color(173, 239, 209));
        nfrom.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jPanel22.add(nfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 200, 30));

        jLabel69.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(173, 239, 209));
        jLabel69.setText("freight");
        jPanel22.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 160, 30));

        jLabel70.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(173, 239, 209));
        jLabel70.setText("parking");
        jPanel22.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 160, 30));

        c2.setBackground(new java.awt.Color(173, 239, 209));
        c2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        c2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        c2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                c2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c2KeyTyped(evt);
            }
        });
        jPanel22.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 300, 120, 30));

        jLabel71.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(173, 239, 209));
        jLabel71.setText("driver :");
        jPanel22.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 70, 30));

        ndriver.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        ndriver.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "na" }));
        jPanel22.add(ndriver, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 260, 30));

        c3.setBackground(new java.awt.Color(173, 239, 209));
        c3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        c3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        c3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                c3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c3KeyTyped(evt);
            }
        });
        jPanel22.add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 350, 120, 30));

        jLabel72.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(173, 239, 209));
        jLabel72.setText("other charges");
        jPanel22.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 160, 30));

        jSeparator6.setBackground(new java.awt.Color(173, 239, 209));
        jPanel22.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 1070, 10));

        jLabel73.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(173, 239, 209));
        jLabel73.setText("total :");
        jPanel22.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 690, 70, 30));

        jSeparator7.setBackground(new java.awt.Color(173, 239, 209));
        jPanel22.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1070, 10));

        jLabel74.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(173, 239, 209));
        jLabel74.setText("vehicle n0 :");
        jPanel22.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, 30));

        jLabel75.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(173, 239, 209));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("particulars");
        jPanel22.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 120, 30));

        savebill.setBackground(new java.awt.Color(173, 239, 209));
        savebill.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        savebill.setText("Save");
        savebill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebillActionPerformed(evt);
            }
        });
        jPanel22.add(savebill, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 750, 160, 30));

        clearbill.setBackground(new java.awt.Color(173, 239, 209));
        clearbill.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        clearbill.setText("clear");
        clearbill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbillActionPerformed(evt);
            }
        });
        jPanel22.add(clearbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 750, 160, 30));

        nparty.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        nparty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cash" }));
        jPanel22.add(nparty, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 260, 30));

        ndate.setForeground(new java.awt.Color(173, 239, 209));
        ndate.setDateFormatString("dd/MM/yyyy");
        ndate.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                ndateComponentMoved(evt);
            }
        });
        jPanel22.add(ndate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 140, 30));

        jLabel76.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(173, 239, 209));
        jLabel76.setText("party's A/C name :");
        jPanel22.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 160, 30));

        updatebill.setBackground(new java.awt.Color(173, 239, 209));
        updatebill.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        updatebill.setText("save");
        updatebill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebillActionPerformed(evt);
            }
        });
        jPanel22.add(updatebill, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 750, 160, 30));

        dscreen.addTab("tab2", jPanel22);

        jPanel23.setBackground(new java.awt.Color(0, 32, 63));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(173, 239, 209));
        jLabel79.setText("gst number :");
        jPanel23.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 180, 30));

        pgst.setBackground(new java.awt.Color(173, 239, 209));
        pgst.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        pgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pgstActionPerformed(evt);
            }
        });
        jPanel23.add(pgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 240, 30));

        jLabel80.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(173, 239, 209));
        jLabel80.setText("party's name :");
        jPanel23.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 200, 30));

        pname.setBackground(new java.awt.Color(173, 239, 209));
        pname.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnameActionPerformed(evt);
            }
        });
        jPanel23.add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 240, 30));

        jLabel81.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(173, 239, 209));
        jLabel81.setText("pincode :");
        jPanel23.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 180, 30));

        jLabel82.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(173, 239, 209));
        jLabel82.setText("city :");
        jPanel23.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 180, 30));

        pcity.setBackground(new java.awt.Color(173, 239, 209));
        pcity.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        pcity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcityActionPerformed(evt);
            }
        });
        jPanel23.add(pcity, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 240, 30));

        ppincode.setBackground(new java.awt.Color(173, 239, 209));
        ppincode.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        ppincode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppincodeActionPerformed(evt);
            }
        });
        ppincode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ppincodeKeyTyped(evt);
            }
        });
        jPanel23.add(ppincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 240, 30));

        jLabel83.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(173, 239, 209));
        jLabel83.setText("address :");
        jPanel23.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, 30));

        paddress.setBackground(new java.awt.Color(173, 239, 209));
        paddress.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        paddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paddressActionPerformed(evt);
            }
        });
        jPanel23.add(paddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 240, 30));

        pstate.setBackground(new java.awt.Color(173, 239, 209));
        pstate.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        pstate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pstateActionPerformed(evt);
            }
        });
        jPanel23.add(pstate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 240, 30));

        jLabel84.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(173, 239, 209));
        jLabel84.setText("sTATE :");
        jPanel23.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 30));

        jLabel85.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(173, 239, 209));
        jLabel85.setText("BANK ACCOUNT NAME :");
        jPanel23.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 200, 30));

        pbankaccount.setBackground(new java.awt.Color(173, 239, 209));
        pbankaccount.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        pbankaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbankaccountActionPerformed(evt);
            }
        });
        jPanel23.add(pbankaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 600, 240, 30));

        jLabel86.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(173, 239, 209));
        jLabel86.setText("eMAIL :");
        jPanel23.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 180, 30));

        pemail.setBackground(new java.awt.Color(173, 239, 209));
        pemail.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        pemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pemailActionPerformed(evt);
            }
        });
        jPanel23.add(pemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 410, 240, 30));

        pmob.setBackground(new java.awt.Color(173, 239, 209));
        pmob.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        pmob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmobActionPerformed(evt);
            }
        });
        pmob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pmobKeyTyped(evt);
            }
        });
        jPanel23.add(pmob, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 240, 30));

        jLabel87.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(173, 239, 209));
        jLabel87.setText("mOBILE NUMBER :");
        jPanel23.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 200, 30));

        jLabel88.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(173, 239, 209));
        jLabel88.setText("aCCOUNT NUMBER :");
        jPanel23.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 180, 30));

        paccountno.setBackground(new java.awt.Color(173, 239, 209));
        paccountno.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        paccountno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paccountnoActionPerformed(evt);
            }
        });
        paccountno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                paccountnoKeyTyped(evt);
            }
        });
        jPanel23.add(paccountno, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 600, 240, 30));

        jLabel89.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(173, 239, 209));
        jLabel89.setText("ifsc CODE :");
        jPanel23.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 660, 180, 30));

        pifsc.setBackground(new java.awt.Color(173, 239, 209));
        pifsc.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        pifsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pifscActionPerformed(evt);
            }
        });
        jPanel23.add(pifsc, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 660, 240, 30));

        jSeparator8.setBackground(new java.awt.Color(173, 239, 209));
        jPanel23.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1070, 10));

        jSeparator9.setBackground(new java.awt.Color(173, 239, 209));
        jPanel23.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1070, 10));

        jSeparator10.setBackground(new java.awt.Color(173, 239, 209));
        jPanel23.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1070, 10));

        jSeparator11.setBackground(new java.awt.Color(173, 239, 209));
        jPanel23.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1070, 10));

        jSeparator12.setBackground(new java.awt.Color(173, 239, 209));
        jPanel23.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1070, 10));

        jSeparator13.setBackground(new java.awt.Color(173, 239, 209));
        jPanel23.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1070, 10));

        jLabel90.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(173, 239, 209));
        jLabel90.setText("ACCOUNT HOLDER NAME:");
        jPanel23.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 200, 30));

        pholdername.setBackground(new java.awt.Color(173, 239, 209));
        pholdername.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        pholdername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pholdernameActionPerformed(evt);
            }
        });
        jPanel23.add(pholdername, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 660, 240, 30));

        jButton1.setBackground(new java.awt.Color(173, 239, 209));
        jButton1.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 730, 160, 30));

        jButton2.setBackground(new java.awt.Color(173, 239, 209));
        jButton2.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 730, 160, 30));

        jLabel91.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(173, 239, 209));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("ACCOUNT DETAILS");
        jPanel23.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1070, 30));

        jLabel92.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(173, 239, 209));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("PARTY DETAILS");
        jPanel23.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1070, 30));

        jLabel93.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(173, 239, 209));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("CONTACT DETAILS");
        jPanel23.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1070, 30));

        dscreen.addTab("tab3", jPanel23);

        jPanel24.setBackground(new java.awt.Color(0, 32, 63));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel94.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(173, 239, 209));
        jLabel94.setText("vehicle type :");
        jPanel24.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 180, 30));

        vtype.setBackground(new java.awt.Color(173, 239, 209));
        vtype.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        vtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vtypeActionPerformed(evt);
            }
        });
        jPanel24.add(vtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 240, 30));

        jLabel95.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(173, 239, 209));
        jLabel95.setText("vehicle Number :");
        jPanel24.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 200, 30));

        vnum.setBackground(new java.awt.Color(173, 239, 209));
        vnum.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        vnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vnumActionPerformed(evt);
            }
        });
        jPanel24.add(vnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 240, 30));

        jLabel96.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(173, 239, 209));
        jLabel96.setText("pincode :");
        jPanel24.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 180, 30));

        jLabel97.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(173, 239, 209));
        jLabel97.setText("address :");
        jPanel24.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 180, 30));

        vaddress.setBackground(new java.awt.Color(173, 239, 209));
        vaddress.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        vaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaddressActionPerformed(evt);
            }
        });
        jPanel24.add(vaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 240, 30));

        vpincode.setBackground(new java.awt.Color(173, 239, 209));
        vpincode.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        vpincode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vpincodeActionPerformed(evt);
            }
        });
        vpincode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vpincodeKeyTyped(evt);
            }
        });
        jPanel24.add(vpincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 240, 30));

        jLabel98.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(173, 239, 209));
        jLabel98.setText("owner name :");
        jPanel24.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, 30));

        vname.setBackground(new java.awt.Color(173, 239, 209));
        vname.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        vname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vnameActionPerformed(evt);
            }
        });
        jPanel24.add(vname, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 240, 30));

        vstate.setBackground(new java.awt.Color(173, 239, 209));
        vstate.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        vstate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vstateActionPerformed(evt);
            }
        });
        jPanel24.add(vstate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 240, 30));

        jLabel99.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(173, 239, 209));
        jLabel99.setText("state :");
        jPanel24.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 30));

        jLabel100.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(173, 239, 209));
        jLabel100.setText("BANK ACCOUNT NAME :");
        jPanel24.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 200, 30));

        vbankaccount.setBackground(new java.awt.Color(173, 239, 209));
        vbankaccount.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        vbankaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vbankaccountActionPerformed(evt);
            }
        });
        jPanel24.add(vbankaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 600, 240, 30));

        jLabel101.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(173, 239, 209));
        jLabel101.setText("eMAIL :");
        jPanel24.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 180, 30));

        vemail.setBackground(new java.awt.Color(173, 239, 209));
        vemail.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        vemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vemailActionPerformed(evt);
            }
        });
        jPanel24.add(vemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 410, 240, 30));

        vmob.setBackground(new java.awt.Color(173, 239, 209));
        vmob.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        vmob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vmobActionPerformed(evt);
            }
        });
        vmob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vmobKeyTyped(evt);
            }
        });
        jPanel24.add(vmob, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 240, 30));

        jLabel102.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(173, 239, 209));
        jLabel102.setText("mOBILE NUMBER :");
        jPanel24.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 200, 30));

        jLabel103.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(173, 239, 209));
        jLabel103.setText("aCCOUNT NUMBER :");
        jPanel24.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 180, 30));

        vaccountno.setBackground(new java.awt.Color(173, 239, 209));
        vaccountno.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        vaccountno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaccountnoActionPerformed(evt);
            }
        });
        vaccountno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vaccountnoKeyTyped(evt);
            }
        });
        jPanel24.add(vaccountno, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 600, 240, 30));

        jLabel104.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(173, 239, 209));
        jLabel104.setText("ifsc CODE :");
        jPanel24.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 660, 180, 30));

        vifsc.setBackground(new java.awt.Color(173, 239, 209));
        vifsc.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        vifsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vifscActionPerformed(evt);
            }
        });
        jPanel24.add(vifsc, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 660, 240, 30));

        jSeparator14.setBackground(new java.awt.Color(173, 239, 209));
        jPanel24.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1070, 10));

        jSeparator15.setBackground(new java.awt.Color(173, 239, 209));
        jPanel24.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1070, 10));

        jSeparator16.setBackground(new java.awt.Color(173, 239, 209));
        jPanel24.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1070, 10));

        jSeparator17.setBackground(new java.awt.Color(173, 239, 209));
        jPanel24.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1070, 10));

        jSeparator18.setBackground(new java.awt.Color(173, 239, 209));
        jPanel24.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1070, 10));

        jSeparator19.setBackground(new java.awt.Color(173, 239, 209));
        jPanel24.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1070, 10));

        jLabel105.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(173, 239, 209));
        jLabel105.setText("ACCOUNT HOLDER NAME:");
        jPanel24.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 200, 30));

        vholdername.setBackground(new java.awt.Color(173, 239, 209));
        vholdername.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        vholdername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vholdernameActionPerformed(evt);
            }
        });
        jPanel24.add(vholdername, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 660, 240, 30));

        jButton3.setBackground(new java.awt.Color(173, 239, 209));
        jButton3.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel24.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 730, 160, 30));

        jButton4.setBackground(new java.awt.Color(173, 239, 209));
        jButton4.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jButton4.setText("SAVE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel24.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 730, 160, 30));

        jLabel106.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(173, 239, 209));
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel106.setText("ACCOUNT DETAILS");
        jPanel24.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1070, 30));

        jLabel107.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(173, 239, 209));
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("vehicle details");
        jPanel24.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1070, 30));

        jLabel108.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(173, 239, 209));
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("CONTACT DETAILS");
        jPanel24.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1070, 30));

        dscreen.addTab("tab4", jPanel24);

        newv.setBackground(new java.awt.Color(0, 32, 63));
        newv.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel109.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(173, 239, 209));
        jLabel109.setText("licence number :");
        newv.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 180, 30));

        dlnum.setBackground(new java.awt.Color(173, 239, 209));
        dlnum.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        dlnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlnumActionPerformed(evt);
            }
        });
        newv.add(dlnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 240, 30));

        jLabel110.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(173, 239, 209));
        jLabel110.setText("driver full name :");
        newv.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 200, 30));

        dname.setBackground(new java.awt.Color(173, 239, 209));
        dname.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        dname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnameActionPerformed(evt);
            }
        });
        newv.add(dname, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 240, 30));

        jLabel111.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(173, 239, 209));
        jLabel111.setText("pincode :");
        newv.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 180, 30));

        jLabel112.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(173, 239, 209));
        jLabel112.setText("address :");
        newv.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 180, 30));

        daddress.setBackground(new java.awt.Color(173, 239, 209));
        daddress.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        daddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daddressActionPerformed(evt);
            }
        });
        newv.add(daddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 240, 30));

        dpincode.setBackground(new java.awt.Color(173, 239, 209));
        dpincode.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        dpincode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpincodeActionPerformed(evt);
            }
        });
        dpincode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dpincodeKeyTyped(evt);
            }
        });
        newv.add(dpincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 240, 30));

        jLabel113.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(173, 239, 209));
        jLabel113.setText("pan number :");
        newv.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, 30));

        dpnum.setBackground(new java.awt.Color(173, 239, 209));
        dpnum.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        dpnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpnumActionPerformed(evt);
            }
        });
        newv.add(dpnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 240, 30));

        dstate.setBackground(new java.awt.Color(173, 239, 209));
        dstate.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        dstate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dstateActionPerformed(evt);
            }
        });
        newv.add(dstate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 240, 30));

        jLabel114.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(173, 239, 209));
        jLabel114.setText("state :");
        newv.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 30));

        jLabel115.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(173, 239, 209));
        jLabel115.setText("BANK ACCOUNT NAME :");
        newv.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 200, 30));

        dbankaccount.setBackground(new java.awt.Color(173, 239, 209));
        dbankaccount.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        dbankaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbankaccountActionPerformed(evt);
            }
        });
        newv.add(dbankaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 600, 240, 30));

        jLabel116.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(173, 239, 209));
        jLabel116.setText("eMAIL :");
        newv.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 180, 30));

        demail.setBackground(new java.awt.Color(173, 239, 209));
        demail.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        demail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demailActionPerformed(evt);
            }
        });
        newv.add(demail, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 410, 240, 30));

        dmob.setBackground(new java.awt.Color(173, 239, 209));
        dmob.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        dmob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dmobActionPerformed(evt);
            }
        });
        dmob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dmobKeyTyped(evt);
            }
        });
        newv.add(dmob, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 240, 30));

        jLabel117.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(173, 239, 209));
        jLabel117.setText("mOBILE NUMBER :");
        newv.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 200, 30));

        jLabel118.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(173, 239, 209));
        jLabel118.setText("aCCOUNT NUMBER :");
        newv.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 180, 30));

        daccountno.setBackground(new java.awt.Color(173, 239, 209));
        daccountno.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        daccountno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daccountnoActionPerformed(evt);
            }
        });
        daccountno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                daccountnoKeyTyped(evt);
            }
        });
        newv.add(daccountno, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 600, 240, 30));

        jLabel119.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(173, 239, 209));
        jLabel119.setText("ifsc CODE :");
        newv.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 660, 180, 30));

        difsc.setBackground(new java.awt.Color(173, 239, 209));
        difsc.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        difsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                difscActionPerformed(evt);
            }
        });
        newv.add(difsc, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 660, 240, 30));

        jSeparator20.setBackground(new java.awt.Color(173, 239, 209));
        newv.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1070, 10));

        jSeparator21.setBackground(new java.awt.Color(173, 239, 209));
        newv.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1070, 10));

        jSeparator22.setBackground(new java.awt.Color(173, 239, 209));
        newv.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1070, 10));

        jSeparator23.setBackground(new java.awt.Color(173, 239, 209));
        newv.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1070, 10));

        jSeparator24.setBackground(new java.awt.Color(173, 239, 209));
        newv.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1070, 10));

        jSeparator25.setBackground(new java.awt.Color(173, 239, 209));
        newv.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1070, 10));

        jLabel120.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(173, 239, 209));
        jLabel120.setText("ACCOUNT HOLDER NAME:");
        newv.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 200, 30));

        dholdername.setBackground(new java.awt.Color(173, 239, 209));
        dholdername.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        dholdername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dholdernameActionPerformed(evt);
            }
        });
        newv.add(dholdername, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 660, 240, 30));

        jButton5.setBackground(new java.awt.Color(173, 239, 209));
        jButton5.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jButton5.setText("CLEAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        newv.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 730, 160, 30));

        jLabel121.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(173, 239, 209));
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("ACCOUNT DETAILS");
        newv.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1070, 30));

        jLabel122.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(173, 239, 209));
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("driver details");
        newv.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1070, 30));

        jLabel123.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(173, 239, 209));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("CONTACT DETAILS");
        newv.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1070, 30));

        jButton7.setBackground(new java.awt.Color(173, 239, 209));
        jButton7.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jButton7.setText("SAVE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        newv.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 730, 160, 30));

        dscreen.addTab("tab5", newv);

        jPanel1.setBackground(new java.awt.Color(0, 32, 63));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        billtable.setBackground(new java.awt.Color(173, 239, 209));
        billtable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        billtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Bill No.", "Party Name", "Freight", "Parking", "Other Charges", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        billtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billtableMouseClicked(evt);
            }
        });
        billtable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                billtableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(billtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 940, 480));

        jLabel5.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(173, 239, 209));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Bill details");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1070, 40));

        jPanel2.setBackground(new java.awt.Color(173, 239, 209));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel124.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(0, 32, 63));
        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel124.setText("To :");
        jPanel2.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 200, 30));

        jLabel125.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(0, 32, 63));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel125.setText("Vehicle Number :");
        jPanel2.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 200, 30));

        brshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        brshow.setForeground(new java.awt.Color(0, 32, 63));
        brshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(brshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 790, 30));

        jLabel127.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(0, 32, 63));
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel127.setText("Driver Name :");
        jPanel2.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 30));

        jLabel128.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(0, 32, 63));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel128.setText("Remarks :");
        jPanel2.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 30));

        jLabel129.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(0, 32, 63));
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel129.setText("From :");
        jPanel2.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 30));

        bfrom.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        bfrom.setForeground(new java.awt.Color(0, 32, 63));
        bfrom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(bfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 330, 30));

        bdnshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        bdnshow.setForeground(new java.awt.Color(0, 32, 63));
        bdnshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(bdnshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 290, 30));

        bvnshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        bvnshow.setForeground(new java.awt.Color(0, 32, 63));
        bvnshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(bvnshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 280, 30));

        bto.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        bto.setForeground(new java.awt.Color(0, 32, 63));
        bto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(bto, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 280, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, 940, 110));

        jPanel4.setBackground(new java.awt.Color(173, 239, 209));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bsearch.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        bsearch.setForeground(new java.awt.Color(0, 32, 63));
        bsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsearchActionPerformed(evt);
            }
        });
        jPanel4.add(bsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 250, 30));

        jLabel131.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(0, 32, 63));
        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel131.setText("search :");
        jPanel4.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 30));

        jButton6.setBackground(new java.awt.Color(173, 239, 209));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tansport/images/search_20px.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 40, 30));

        jButton10.setBackground(new java.awt.Color(173, 239, 209));
        jButton10.setFont(new java.awt.Font("Algerian", 0, 13)); // NOI18N
        jButton10.setText("print");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 80, 30));

        jButton11.setBackground(new java.awt.Color(173, 239, 209));
        jButton11.setFont(new java.awt.Font("Algerian", 0, 13)); // NOI18N
        jButton11.setText("edit");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 80, 30));

        jButton8.setBackground(new java.awt.Color(173, 239, 209));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tansport/images/refresh_20px.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 40, 30));

        jButton9.setBackground(new java.awt.Color(173, 239, 209));
        jButton9.setFont(new java.awt.Font("Algerian", 0, 13)); // NOI18N
        jButton9.setText("delete");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 80, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 940, 70));

        dscreen.addTab("tab6", jPanel1);

        jPanel6.setBackground(new java.awt.Color(0, 32, 63));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        drivertable.setBackground(new java.awt.Color(173, 239, 209));
        drivertable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        drivertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. No.", "Driver Name", "Licence Number", "Pan Number", "Mobile Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        drivertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drivertableMouseClicked(evt);
            }
        });
        drivertable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                drivertableKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(drivertable);
        if (drivertable.getColumnModel().getColumnCount() > 0) {
            drivertable.getColumnModel().getColumn(0).setMinWidth(50);
            drivertable.getColumnModel().getColumn(0).setPreferredWidth(50);
            drivertable.getColumnModel().getColumn(0).setMaxWidth(50);
            drivertable.getColumnModel().getColumn(0).setHeaderValue("S. No.");
            drivertable.getColumnModel().getColumn(1).setHeaderValue("Driver Name");
            drivertable.getColumnModel().getColumn(2).setHeaderValue("Licence Number");
            drivertable.getColumnModel().getColumn(3).setHeaderValue("Pan Number");
            drivertable.getColumnModel().getColumn(4).setHeaderValue("Mobile Number");
        }

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 940, 480));

        jLabel6.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(173, 239, 209));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("driver details");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1070, 40));

        jPanel7.setBackground(new java.awt.Color(173, 239, 209));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel134.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(0, 32, 63));
        jLabel134.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel134.setText("Ifsc code :");
        jPanel7.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 200, 30));

        jLabel135.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(0, 32, 63));
        jLabel135.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel135.setText("Email :");
        jPanel7.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 70, 30));

        jLabel136.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(0, 32, 63));
        jLabel136.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel136.setText("Account holder name :");
        jPanel7.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 200, 30));

        danshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        danshow.setForeground(new java.awt.Color(0, 32, 63));
        danshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel7.add(danshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 260, 30));

        jLabel138.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(0, 32, 63));
        jLabel138.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel138.setText("bank name :");
        jPanel7.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 30));

        jLabel139.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(0, 32, 63));
        jLabel139.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel139.setText("account number :");
        jPanel7.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, 30));

        jLabel140.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(0, 32, 63));
        jLabel140.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel140.setText("Address :");
        jPanel7.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 30));

        dashow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        dashow.setForeground(new java.awt.Color(0, 32, 63));
        dashow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel7.add(dashow, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 450, 30));

        dbnshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        dbnshow.setForeground(new java.awt.Color(0, 32, 63));
        dbnshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel7.add(dbnshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 300, 30));

        dahnshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        dahnshow.setForeground(new java.awt.Color(0, 32, 63));
        dahnshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel7.add(dahnshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 280, 30));

        deshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        deshow.setForeground(new java.awt.Color(0, 32, 63));
        deshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel7.add(deshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 280, 30));

        difscshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        difscshow.setForeground(new java.awt.Color(0, 32, 63));
        difscshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel7.add(difscshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 280, 30));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 940, 160));

        dscreen.addTab("tab7", jPanel6);

        jPanel8.setBackground(new java.awt.Color(0, 32, 63));
        jPanel8.setPreferredSize(new java.awt.Dimension(1070, 780));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        partytable.setBackground(new java.awt.Color(173, 239, 209));
        partytable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        partytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. No.", "Party Name", "GST Number", "Mobile Number", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        partytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partytableMouseClicked(evt);
            }
        });
        partytable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                partytableKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(partytable);
        if (partytable.getColumnModel().getColumnCount() > 0) {
            partytable.getColumnModel().getColumn(0).setMinWidth(50);
            partytable.getColumnModel().getColumn(0).setPreferredWidth(50);
            partytable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel8.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 940, 480));

        jPanel9.setBackground(new java.awt.Color(173, 239, 209));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel146.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(0, 32, 63));
        jLabel146.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel146.setText("Ifsc code :");
        jPanel9.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 200, 30));

        jLabel147.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(0, 32, 63));
        jLabel147.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel147.setText("GSt Number :");
        jPanel9.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 110, 30));

        jLabel148.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(0, 32, 63));
        jLabel148.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel148.setText("Account holder name :");
        jPanel9.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 200, 30));

        panshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        panshow.setForeground(new java.awt.Color(0, 32, 63));
        panshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel9.add(panshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 260, 30));

        jLabel150.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(0, 32, 63));
        jLabel150.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel150.setText("bank name :");
        jPanel9.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 100, 30));

        jLabel151.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(0, 32, 63));
        jLabel151.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel151.setText("account number :");
        jPanel9.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, 30));

        jLabel152.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(0, 32, 63));
        jLabel152.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel152.setText("Address :");
        jPanel9.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 30));

        pashow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        pashow.setForeground(new java.awt.Color(0, 32, 63));
        pashow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel9.add(pashow, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 420, 30));

        pbnshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        pbnshow.setForeground(new java.awt.Color(0, 32, 63));
        pbnshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel9.add(pbnshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 300, 30));

        pahnshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        pahnshow.setForeground(new java.awt.Color(0, 32, 63));
        pahnshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel9.add(pahnshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 280, 30));

        pgstshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        pgstshow.setForeground(new java.awt.Color(0, 32, 63));
        pgstshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel9.add(pgstshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 280, 30));

        pifscshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        pifscshow.setForeground(new java.awt.Color(0, 32, 63));
        pifscshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel9.add(pifscshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 280, 30));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 940, 160));

        jLabel7.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(173, 239, 209));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("party details");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1070, 40));

        dscreen.addTab("tab8", jPanel8);

        jPanel10.setBackground(new java.awt.Color(0, 32, 63));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(173, 239, 209));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("vehicle details");
        jPanel10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1070, 40));

        vehicletable.setBackground(new java.awt.Color(173, 239, 209));
        vehicletable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        vehicletable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. No.", "Vehicle Number", "Vehicle Type", "Vehicle Owner", "Mobile Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vehicletable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vehicletableMouseClicked(evt);
            }
        });
        vehicletable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vehicletableKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(vehicletable);
        if (vehicletable.getColumnModel().getColumnCount() > 0) {
            vehicletable.getColumnModel().getColumn(0).setMinWidth(50);
            vehicletable.getColumnModel().getColumn(0).setPreferredWidth(50);
            vehicletable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel10.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 940, 480));

        jPanel25.setBackground(new java.awt.Color(173, 239, 209));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel158.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(0, 32, 63));
        jLabel158.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel158.setText("Ifsc code :");
        jPanel25.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 200, 30));

        jLabel159.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(0, 32, 63));
        jLabel159.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel159.setText("Email :");
        jPanel25.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 70, 30));

        jLabel160.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(0, 32, 63));
        jLabel160.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel160.setText("Account holder name :");
        jPanel25.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 200, 30));

        vanshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        vanshow.setForeground(new java.awt.Color(0, 32, 63));
        vanshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel25.add(vanshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 260, 30));

        jLabel162.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(0, 32, 63));
        jLabel162.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel162.setText("bank name :");
        jPanel25.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 30));

        jLabel163.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(0, 32, 63));
        jLabel163.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel163.setText("account number :");
        jPanel25.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, 30));

        jLabel164.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(0, 32, 63));
        jLabel164.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel164.setText("Address :");
        jPanel25.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 30));

        vashow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        vashow.setForeground(new java.awt.Color(0, 32, 63));
        vashow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel25.add(vashow, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 460, 30));

        vbnshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        vbnshow.setForeground(new java.awt.Color(0, 32, 63));
        vbnshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel25.add(vbnshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 300, 30));

        vahnshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        vahnshow.setForeground(new java.awt.Color(0, 32, 63));
        vahnshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel25.add(vahnshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 280, 30));

        veshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        veshow.setForeground(new java.awt.Color(0, 32, 63));
        veshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel25.add(veshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 280, 30));

        vifscshow.setFont(new java.awt.Font("Algerian", 0, 15)); // NOI18N
        vifscshow.setForeground(new java.awt.Color(0, 32, 63));
        vifscshow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel25.add(vifscshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 280, 30));

        jPanel10.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 940, 160));

        dscreen.addTab("tab9", jPanel10);

        jPanel27.setBackground(new java.awt.Color(0, 32, 63));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barchart.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.add(barchart, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 930, 460));

        jPanel29.setBackground(new java.awt.Color(173, 239, 209));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel2.setText("Total Amount :");
        jPanel29.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 130, 20));

        jLabel3.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel3.setText("Total number of bills :");
        jPanel29.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 200, 20));

        tnbill.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jPanel29.add(tnbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 200, 20));

        tcharge.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jPanel29.add(tcharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 270, 20));

        jPanel27.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 590, 210));

        jLabel9.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(173, 239, 209));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("report");
        jPanel27.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1070, 40));

        jPanel28.setBackground(new java.awt.Color(173, 239, 209));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reporttable.setBackground(new java.awt.Color(173, 239, 209));
        reporttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. No", "Month", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(reporttable);
        if (reporttable.getColumnModel().getColumnCount() > 0) {
            reporttable.getColumnModel().getColumn(0).setMinWidth(50);
            reporttable.getColumnModel().getColumn(0).setPreferredWidth(50);
            reporttable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel28.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 190));

        jPanel27.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 310, 210));

        dscreen.addTab("tab10", jPanel27);

        jPanel11.add(dscreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 1080, 830));

        jPanel3.setBackground(new java.awt.Color(0, 32, 63));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 800));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ldriver.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        ldriver.setForeground(new java.awt.Color(173, 239, 209));
        ldriver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ldriver.setText("DRIVER DETAILS");
        ldriver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ldriverMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ldriverMousePressed(evt);
            }
        });
        jPanel3.add(ldriver, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 230, 30));

        lhome.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        lhome.setForeground(new java.awt.Color(255, 255, 255));
        lhome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lhome.setText("Home");
        lhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lhomeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lhomeMousePressed(evt);
            }
        });
        jPanel3.add(lhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 230, 30));

        lcreate.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        lcreate.setForeground(new java.awt.Color(173, 239, 209));
        lcreate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lcreate.setText("create NEW");
        lcreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lcreateMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lcreateMousePressed(evt);
            }
        });
        jPanel3.add(lcreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 230, 30));

        ibill.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        ibill.setForeground(new java.awt.Color(173, 239, 209));
        ibill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ibill.setText("BILL DETAILS");
        ibill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ibillMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ibillMousePressed(evt);
            }
        });
        ibill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ibillKeyPressed(evt);
            }
        });
        jPanel3.add(ibill, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 230, 30));

        laccount.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        laccount.setForeground(new java.awt.Color(173, 239, 209));
        laccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        laccount.setText("Report");
        laccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laccountMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                laccountMousePressed(evt);
            }
        });
        jPanel3.add(laccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 600, 230, 30));

        lparty.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        lparty.setForeground(new java.awt.Color(173, 239, 209));
        lparty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lparty.setText("PARTY DETAILS");
        lparty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lpartyMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lpartyMousePressed(evt);
            }
        });
        jPanel3.add(lparty, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 230, 30));

        jPanel5.setBackground(new java.awt.Color(0, 32, 63));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 800));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(173, 239, 209));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("DRIVER DETAILS");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 230, 30));

        jLabel21.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(173, 239, 209));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("NEW BILL");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 230, 30));

        jLabel22.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(173, 239, 209));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("ACCOUNT INFO");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 230, 30));

        jLabel23.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(173, 239, 209));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("DRIVER DETAILS");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 230, 30));

        jLabel24.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(173, 239, 209));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("DRIVER DETAILS");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 230, 30));

        jLabel25.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(173, 239, 209));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("DRIVER DETAILS");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 230, 30));

        jLabel26.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(173, 239, 209));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("ACCOUNT INFO");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 230, 30));

        jLabel27.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(173, 239, 209));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("DRIVER DETAILS");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 230, 30));

        jLabel28.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(173, 239, 209));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("ACCOUNT INFO");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 230, 30));

        jLabel29.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(173, 239, 209));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("DRIVER DETAILS");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 230, 30));

        jLabel30.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(173, 239, 209));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("DRIVER DETAILS");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 230, 30));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 110, -1, -1));

        lvehicle.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        lvehicle.setForeground(new java.awt.Color(173, 239, 209));
        lvehicle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lvehicle.setText("VEHICLE DETAILS");
        lvehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lvehicleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lvehicleMousePressed(evt);
            }
        });
        jPanel3.add(lvehicle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 230, 30));

        lscreen.addTab("h", jPanel3);

        jPanel12.setBackground(new java.awt.Color(0, 32, 63));
        jPanel12.setPreferredSize(new java.awt.Dimension(500, 800));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        partylabel.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        partylabel.setForeground(new java.awt.Color(173, 239, 209));
        partylabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        partylabel.setText("NEW PARTY");
        partylabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partylabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                partylabelMousePressed(evt);
            }
        });
        jPanel12.add(partylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 230, 30));

        homelabel.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        homelabel.setForeground(new java.awt.Color(173, 239, 209));
        homelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homelabel.setText("back");
        homelabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homelabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homelabelMousePressed(evt);
            }
        });
        jPanel12.add(homelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 230, 30));

        billlabel.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        billlabel.setForeground(new java.awt.Color(173, 239, 209));
        billlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        billlabel.setText("NEW BILL");
        billlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billlabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                billlabelMousePressed(evt);
            }
        });
        jPanel12.add(billlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 230, 30));

        driverlabel.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        driverlabel.setForeground(new java.awt.Color(173, 239, 209));
        driverlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        driverlabel.setText("NEW DRIVER");
        driverlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                driverlabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                driverlabelMousePressed(evt);
            }
        });
        jPanel12.add(driverlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 230, 30));

        vehiclelabel.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        vehiclelabel.setForeground(new java.awt.Color(173, 239, 209));
        vehiclelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vehiclelabel.setText("NEW VEHICLE");
        vehiclelabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vehiclelabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vehiclelabelMousePressed(evt);
            }
        });
        jPanel12.add(vehiclelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 230, 30));

        jPanel13.setBackground(new java.awt.Color(0, 32, 63));
        jPanel13.setPreferredSize(new java.awt.Dimension(500, 800));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(173, 239, 209));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("DRIVER DETAILS");
        jPanel13.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 230, 30));

        jLabel38.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(173, 239, 209));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("NEW BILL");
        jPanel13.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 230, 30));

        jLabel40.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(173, 239, 209));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("ACCOUNT INFO");
        jPanel13.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 230, 30));

        jLabel41.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(173, 239, 209));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("DRIVER DETAILS");
        jPanel13.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 230, 30));

        jLabel42.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(173, 239, 209));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("DRIVER DETAILS");
        jPanel13.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 230, 30));

        jLabel43.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(173, 239, 209));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("DRIVER DETAILS");
        jPanel13.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 230, 30));

        jLabel44.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(173, 239, 209));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("ACCOUNT INFO");
        jPanel13.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 230, 30));

        jLabel45.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(173, 239, 209));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("DRIVER DETAILS");
        jPanel13.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 230, 30));

        jLabel46.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(173, 239, 209));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("ACCOUNT INFO");
        jPanel13.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 230, 30));

        jLabel47.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(173, 239, 209));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("DRIVER DETAILS");
        jPanel13.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 230, 30));

        jLabel48.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(173, 239, 209));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("DRIVER DETAILS");
        jPanel13.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 230, 30));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 110, -1, -1));

        lscreen.addTab("n", jPanel12);

        jPanel26.setBackground(new java.awt.Color(0, 32, 63));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(173, 239, 209));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel26.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 170, -1));

        editbill.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        editbill.setForeground(new java.awt.Color(255, 255, 255));
        editbill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editbill.setText("edit bill");
        jPanel26.add(editbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 170, -1));

        lscreen.addTab("e", jPanel26);

        jPanel11.add(lscreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 150, 470, 830));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Copyright © 2022 Transport Management System");
        jPanel11.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 1000, 320, 30));

        mainscreen.addTab("tab1", jPanel11);

        getContentPane().add(mainscreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1920, 1110));

        setSize(new java.awt.Dimension(1938, 1122));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void partylabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partylabelMouseClicked
        if(dscreen.getSelectedIndex() > 0){
        int dialog = JOptionPane.showConfirmDialog(this, "Do you want to continue without saving details?", "Confirm", JOptionPane.YES_NO_OPTION);
        if(dialog == JOptionPane.YES_OPTION){
        cd.ClearNewBill();
        cd.ClearNewParty();
        cd.ClearNewVehicle();
        cd.ClearNewDriver();
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(2);
        lscreen.setSelectedIndex(1);
        }
        else{
        cmo.setMenuColor();
        }
       }
       else{
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(2);
        lscreen.setSelectedIndex(1);
       }
    }//GEN-LAST:event_partylabelMouseClicked

    private void partylabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partylabelMousePressed
        homelabel.setForeground(defaultcolor);
        billlabel.setForeground(defaultcolor);
        partylabel.setForeground(Color.white);
        vehiclelabel.setForeground(defaultcolor);
        driverlabel.setForeground(defaultcolor);
    }//GEN-LAST:event_partylabelMousePressed

    private void homelabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelabelMouseClicked
        if(dscreen.getSelectedIndex() > 0){
        int dialog = JOptionPane.showConfirmDialog(this, "Do you want to continue without saving details?", "Confirm", JOptionPane.YES_NO_OPTION);
        if(dialog == JOptionPane.YES_OPTION){
        cd.ClearNewBill();
        cd.ClearNewParty();
        cd.ClearNewVehicle();
        cd.ClearNewDriver();
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(0);
        lscreen.setSelectedIndex(0);
        }
       }
       else{
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(0);
        lscreen.setSelectedIndex(0);
       }


    }//GEN-LAST:event_homelabelMouseClicked

    private void homelabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelabelMousePressed
        ColorOfMenuOption c = new ColorOfMenuOption();
        c.colorHomeLabel();
    }//GEN-LAST:event_homelabelMousePressed

    private void billlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billlabelMouseClicked
        cbv.partyComboBox();
        cbv.driverComboBox();
        cbv.vehicleComboBox();
        updatebill.setVisible(false);
        savebill.setVisible(true);
        clearbill.setVisible(true);
        nbill.setEditable(true);
        if(dscreen.getSelectedIndex() > 0){

        int dialog = JOptionPane.showConfirmDialog(this, "Do you want to continue without saving details?", "Confirm", JOptionPane.YES_NO_OPTION);
        if(dialog == JOptionPane.YES_OPTION){
        cd.ClearNewBill();
        cd.ClearNewParty();
        cd.ClearNewVehicle();
        cd.ClearNewDriver();
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(1);
        lscreen.setSelectedIndex(1);
        }

        else{
        cmo.setMenuColor();
        }
       
       }
       else {

        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(1);
        lscreen.setSelectedIndex(1);

       }




    }//GEN-LAST:event_billlabelMouseClicked

    private void billlabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billlabelMousePressed
        homelabel.setForeground(defaultcolor);
        billlabel.setForeground(Color.white);
        partylabel.setForeground(defaultcolor);
        vehiclelabel.setForeground(defaultcolor);
        driverlabel.setForeground(defaultcolor);
    }//GEN-LAST:event_billlabelMousePressed

    private void driverlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_driverlabelMouseClicked
        if(dscreen.getSelectedIndex() > 0){
        int dialog = JOptionPane.showConfirmDialog(this, "Do you want to continue without saving details?", "Confirm", JOptionPane.YES_NO_OPTION);
        if(dialog == JOptionPane.YES_OPTION){
        cd.ClearNewBill();
        cd.ClearNewParty();
        cd.ClearNewVehicle();
        cd.ClearNewDriver();
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(4);
        lscreen.setSelectedIndex(1);
        }
        else{
        cmo.setMenuColor();
        }
       }
       else{
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(4);
        lscreen.setSelectedIndex(1);
       }



    }//GEN-LAST:event_driverlabelMouseClicked

    private void driverlabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_driverlabelMousePressed
        homelabel.setForeground(defaultcolor);
        billlabel.setForeground(defaultcolor);
        partylabel.setForeground(defaultcolor);
        vehiclelabel.setForeground(defaultcolor);
        driverlabel.setForeground(Color.white);
    }//GEN-LAST:event_driverlabelMousePressed

    private void vehiclelabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vehiclelabelMouseClicked
        if(dscreen.getSelectedIndex() > 0){
        int dialog = JOptionPane.showConfirmDialog(this, "Do you want to continue without saving details?", "Confirm", JOptionPane.YES_NO_OPTION);
        if(dialog == JOptionPane.YES_OPTION){
        cd.ClearNewBill();
        cd.ClearNewParty();
        cd.ClearNewVehicle();
        cd.ClearNewDriver();
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(3);
        lscreen.setSelectedIndex(1);
        }
        else{
        cmo.setMenuColor();
        }
       }
       else{
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(3);
        lscreen.setSelectedIndex(1);
       }       


    }//GEN-LAST:event_vehiclelabelMouseClicked

    private void vehiclelabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vehiclelabelMousePressed
        homelabel.setForeground(defaultcolor);
        billlabel.setForeground(defaultcolor);
        partylabel.setForeground(defaultcolor);
        vehiclelabel.setForeground(Color.white);
        driverlabel.setForeground(defaultcolor);
    }//GEN-LAST:event_vehiclelabelMousePressed

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        int dialog = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Confirm", JOptionPane.YES_NO_OPTION);
        if(dialog == JOptionPane.YES_OPTION){
Login l = new Login();
l.setVisible(true);
dispose();
l.jTabbedPane1.setSelectedIndex(0);
}
    }//GEN-LAST:event_jLabel50MouseClicked

    private void btnback1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnback1ActionPerformed
if(!sc.getText().equals("")){        
sc.setText(sc.getText().substring(0,sc.getText().length()-1));
} else{sc.setText("");}
    }//GEN-LAST:event_btnback1ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        sc.setText(sc.getText()+btn9.getText());
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        sc.setText(sc.getText()+btn8.getText());
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        sc.setText(sc.getText()+btn7.getText());
    }//GEN-LAST:event_btn7ActionPerformed

    private void btnsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubActionPerformed
        String a = sc.getText();
        firstNum = Double.parseDouble(a);
        operator = "-";
        sc.setText("");
    }//GEN-LAST:event_btnsubActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        sc.setText(sc.getText()+btn4.getText());
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        sc.setText(sc.getText()+btn5.getText());
    }//GEN-LAST:event_btn5ActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        String a = sc.getText();
        firstNum = Double.parseDouble(a);
        operator = "+";
        sc.setText("");
    }//GEN-LAST:event_btnaddActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        sc.setText(sc.getText()+btn6.getText());
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        sc.setText(sc.getText()+btn1.getText());
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        sc.setText(sc.getText()+btn2.getText());
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        sc.setText(sc.getText()+btn3.getText());
    }//GEN-LAST:event_btn3ActionPerformed

    private void btndotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndotActionPerformed
        sc.setText(sc.getText()+btndot.getText());
    }//GEN-LAST:event_btndotActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        sc.setText(sc.getText()+btn0.getText());
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnequalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnequalActionPerformed
        String b = sc.getText();
        secondNum = Double.parseDouble(b);
        switch(operator)
        {
            case "+":
            answer = firstNum+secondNum;
            break;
            case "-":
            answer = firstNum-secondNum;
            break;
            case "*":
            answer = firstNum*secondNum;
            break;
            case "/":
            answer = firstNum/secondNum;
            break;
        }
        sc.setText(Double.toString(answer));
    }//GEN-LAST:event_btnequalActionPerformed

    private void btndivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndivActionPerformed
        String a = sc.getText();
        firstNum = Double.parseDouble(a);
        operator = "/";
        sc.setText("");
    }//GEN-LAST:event_btndivActionPerformed

    private void btnmulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmulActionPerformed
        String a = sc.getText();
        firstNum = Double.parseDouble(a);
        operator = "*";
        sc.setText("");
    }//GEN-LAST:event_btnmulActionPerformed

    private void btnclsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclsActionPerformed
        sc.setText("");
    }//GEN-LAST:event_btnclsActionPerformed

    private void pgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pgstActionPerformed

    private void pnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnameActionPerformed

    private void pcityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcityActionPerformed

    private void ppincodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppincodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ppincodeActionPerformed

    private void paddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paddressActionPerformed

    private void pstateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pstateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pstateActionPerformed

    private void pbankaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbankaccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pbankaccountActionPerformed

    private void pemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pemailActionPerformed

    private void pmobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pmobActionPerformed

    private void paccountnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paccountnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paccountnoActionPerformed

    private void pifscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pifscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pifscActionPerformed

    private void pholdernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pholdernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pholdernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    cd.ClearNewParty();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cnd.newPartyValidation()){        
        cnd.createNewParty();
        cd.ClearNewParty();
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void vtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vtypeActionPerformed

    private void vnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vnumActionPerformed

    private void vaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vaddressActionPerformed

    private void vpincodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vpincodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vpincodeActionPerformed

    private void vnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vnameActionPerformed

    private void vstateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vstateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vstateActionPerformed

    private void vbankaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vbankaccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vbankaccountActionPerformed

    private void vemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vemailActionPerformed

    private void vmobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vmobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vmobActionPerformed

    private void vaccountnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaccountnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vaccountnoActionPerformed

    private void vifscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vifscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vifscActionPerformed

    private void vholdernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vholdernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vholdernameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    cd.ClearNewVehicle();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(cnd.NewVehicleValidation()){
         cnd.insertNewVehicleDetails();
         cd.ClearNewVehicle();
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void dlnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlnumActionPerformed

    private void dnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dnameActionPerformed

    private void daddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daddressActionPerformed

    private void dpincodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpincodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dpincodeActionPerformed

    private void dpnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dpnumActionPerformed

    private void dstateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dstateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dstateActionPerformed

    private void dbankaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbankaccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dbankaccountActionPerformed

    private void demailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_demailActionPerformed

    private void dmobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dmobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dmobActionPerformed

    private void daccountnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daccountnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daccountnoActionPerformed

    private void difscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_difscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_difscActionPerformed

    private void dholdernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dholdernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dholdernameActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    cd.ClearNewDriver();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void lhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lhomeMouseClicked

mainscreen.setSelectedIndex(0);
dscreen.setSelectedIndex(0);
lscreen.setSelectedIndex(0); 

    }//GEN-LAST:event_lhomeMouseClicked

    private void lhomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lhomeMousePressed
        ColorOfMenuOption c = new ColorOfMenuOption();
        c.colorHomeLabel();
    }//GEN-LAST:event_lhomeMousePressed

    private void lcreateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lcreateMousePressed
        homelabel.setForeground(defaultcolor);
        billlabel.setForeground(defaultcolor);
        partylabel.setForeground(defaultcolor);
        vehiclelabel.setForeground(defaultcolor);
        driverlabel.setForeground(defaultcolor);
    }//GEN-LAST:event_lcreateMousePressed

    private void lcreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lcreateMouseClicked
       
mainscreen.setSelectedIndex(0);
dscreen.setSelectedIndex(0);
lscreen.setSelectedIndex(1);

    }//GEN-LAST:event_lcreateMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(cnd.NewDriverValidation()){
        cnd.insertNewDriverDetails();
         cd.ClearNewDriver();
         }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void savebillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebillActionPerformed
    if(cnd.NewBillValidation()){
     cnd.insertNewBillDetails();
     cd.ClearNewBill();
    }
    }//GEN-LAST:event_savebillActionPerformed

    private void clearbillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbillActionPerformed
    cd.ClearNewBill();
    }//GEN-LAST:event_clearbillActionPerformed

    private void c1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c1KeyReleased

Double freight,parking,other,total;

if(c1.getText().equals("")){
freight = 0.0;
} else{
freight = Double.valueOf(c1.getText());
}

if(c2.getText().equals("")){
parking = 0.0;
} else{
parking = Double.valueOf(c2.getText());
}

if(c3.getText().equals("")){
other = 0.0;
} else{
other = Double.valueOf(c3.getText());
}

total = freight + parking + other;
ct.setText(String.valueOf(total));

    }//GEN-LAST:event_c1KeyReleased

    private void c2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c2KeyReleased
Double freight,parking,other,total;

if(c1.getText().equals("")){
freight = 0.0;
} else{
freight = Double.valueOf(c1.getText());
}

if(c2.getText().equals("")){
parking = 0.0;
} else{
parking = Double.valueOf(c2.getText());
}

if(c3.getText().equals("")){
other = 0.0;
} else{
other = Double.valueOf(c3.getText());
}

total = freight + parking + other;
ct.setText(String.valueOf(total));
    }//GEN-LAST:event_c2KeyReleased

    private void c3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c3KeyReleased
Double freight,parking,other,total;

if(c1.getText().equals("")){
freight = 0.0;
} else{
freight = Double.valueOf(c1.getText());
}

if(c2.getText().equals("")){
parking = 0.0;
} else{
parking = Double.valueOf(c2.getText());
}

if(c3.getText().equals("")){
other = 0.0;
} else{
other = Double.valueOf(c3.getText());
}

total = freight + parking + other;
ct.setText(String.valueOf(total));

    }//GEN-LAST:event_c3KeyReleased

    private void c1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c1KeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_c1KeyTyped

    private void c2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c2KeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_c2KeyTyped

    private void c3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c3KeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_c3KeyTyped

    private void remarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remarkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remarkActionPerformed

    private void lpartyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lpartyMouseClicked
        cd.clearPartyTableLabel();
        DefaultTableModel model = (DefaultTableModel)partytable.getModel();
        model.setRowCount(0);
        itv.insertPartyTable();
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(7);
        lscreen.setSelectedIndex(0);
    }//GEN-LAST:event_lpartyMouseClicked

    private void ibillKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ibillKeyPressed

    }//GEN-LAST:event_ibillKeyPressed

    private void ibillMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ibillMousePressed
        ColorOfMenuOption c = new ColorOfMenuOption();
        c.colorBillLabel();

    }//GEN-LAST:event_ibillMousePressed

    private void ldriverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ldriverMousePressed
        ColorOfMenuOption c = new ColorOfMenuOption();
        c.colorDriverLabel();
    }//GEN-LAST:event_ldriverMousePressed

    private void ibillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ibillMouseClicked
        cd.clearBillTableLabel();
        DefaultTableModel model = (DefaultTableModel)billtable.getModel();
        model.setRowCount(0);        
        itv.insertBillTable();
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(5);
        lscreen.setSelectedIndex(0);
        bsearch.setText("");
        String searchString = toUpperCase(bsearch.getText());
        itv.searchBill(searchString);
    }//GEN-LAST:event_ibillMouseClicked

    private void ldriverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ldriverMouseClicked
        cd.clearDriverTableLabel();
        DefaultTableModel model = (DefaultTableModel)drivertable.getModel();
        model.setRowCount(0);
        itv.insertDriverTable();
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(6);
        lscreen.setSelectedIndex(0);
    }//GEN-LAST:event_ldriverMouseClicked

    private void lpartyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lpartyMousePressed
        ColorOfMenuOption c = new ColorOfMenuOption();
        c.colorPartyLabel();
    }//GEN-LAST:event_lpartyMousePressed

    private void lvehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lvehicleMouseClicked
        cd.clearVehicleTableLabel();
        DefaultTableModel model = (DefaultTableModel)vehicletable.getModel();
        model.setRowCount(0);
        itv.insertVehicleTable();
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(8);
        lscreen.setSelectedIndex(0);
    }//GEN-LAST:event_lvehicleMouseClicked

    private void lvehicleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lvehicleMousePressed
        ColorOfMenuOption c = new ColorOfMenuOption();
        c.colorVehicleLabel();
    }//GEN-LAST:event_lvehicleMousePressed

    private void ppincodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ppincodeKeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_ppincodeKeyTyped

    private void pmobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pmobKeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_pmobKeyTyped

    private void paccountnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paccountnoKeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_paccountnoKeyTyped

    private void vpincodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vpincodeKeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_vpincodeKeyTyped

    private void vmobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vmobKeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_vmobKeyTyped

    private void vaccountnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vaccountnoKeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_vaccountnoKeyTyped

    private void dpincodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dpincodeKeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_dpincodeKeyTyped

    private void dmobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dmobKeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_dmobKeyTyped

    private void daccountnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_daccountnoKeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_daccountnoKeyTyped

    private void scKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scKeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_scKeyTyped

    private void ndateComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ndateComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_ndateComponentMoved

    private void vehicletableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vehicletableMouseClicked
        int rowNo = vehicletable.getSelectedRow();
        TableModel model = vehicletable.getModel();
        
        String vehno = model.getValueAt(rowNo, 1).toString();
        itv.showVehicleValues(vehno);
    }//GEN-LAST:event_vehicletableMouseClicked

    private void drivertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drivertableMouseClicked
        int rowNo = drivertable.getSelectedRow();
        TableModel model = drivertable.getModel();
        
        String panno = model.getValueAt(rowNo, 3).toString();
        itv.showDriverValues(panno);
    }//GEN-LAST:event_drivertableMouseClicked

    private void partytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partytableMouseClicked
        int rowNo = partytable.getSelectedRow();
        TableModel model = partytable.getModel();
        
        String gstno = model.getValueAt(rowNo, 2).toString();
        itv.showPartyValues(gstno);
    }//GEN-LAST:event_partytableMouseClicked

    private void billtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billtableMouseClicked
        int rowNo = billtable.getSelectedRow();
        TableModel model = billtable.getModel();
        
        String bno = model.getValueAt(rowNo, 1).toString();
        itv.showBillValues(bno);
    }//GEN-LAST:event_billtableMouseClicked

    private void bsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bsearchActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    String searchString = toUpperCase(bsearch.getText());
    itv.searchBill(searchString);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void partytableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_partytableKeyReleased
        int rowNo = partytable.getSelectedRow();
        TableModel model = partytable.getModel();
        
        String gstno = model.getValueAt(rowNo, 2).toString();
        itv.showPartyValues(gstno);
    }//GEN-LAST:event_partytableKeyReleased

    private void vehicletableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vehicletableKeyReleased
        int rowNo = vehicletable.getSelectedRow();
        TableModel model = vehicletable.getModel();
        
        String vehno = model.getValueAt(rowNo, 1).toString();
        itv.showVehicleValues(vehno);
    }//GEN-LAST:event_vehicletableKeyReleased

    private void drivertableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_drivertableKeyReleased
        int rowNo = drivertable.getSelectedRow();
        TableModel model = drivertable.getModel();
        
        String panno = model.getValueAt(rowNo, 3).toString();
        itv.showDriverValues(panno);
    }//GEN-LAST:event_drivertableKeyReleased

    private void billtableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billtableKeyReleased
        int rowNo = billtable.getSelectedRow();
        TableModel model = billtable.getModel();
        
        String bno = model.getValueAt(rowNo, 1).toString();
        itv.showBillValues(bno);
    }//GEN-LAST:event_billtableKeyReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int rowNo = billtable.getSelectedRow();
        if(rowNo >= 0){
        TableModel model = billtable.getModel();
        
        String bno = model.getValueAt(rowNo, 1).toString();
        ep.editBillValues(bno);
        ep.editBill();  
} else{
JOptionPane.showMessageDialog(null, "Select bill");
} 
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
 int dialog = JOptionPane.showConfirmDialog(this, "Do you want to continue without saving details?", "Confirm", JOptionPane.YES_NO_OPTION);
        if(dialog == JOptionPane.YES_OPTION){
        cd.ClearNewBill();        
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(5);
        lscreen.setSelectedIndex(0);
        cmo.colorBillLabel();
}
    }//GEN-LAST:event_jLabel1MouseClicked

    private void updatebillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebillActionPerformed
        if(ep.updateBillValidation()){
        ep.updateNewBillDetails();
         }
    }//GEN-LAST:event_updatebillActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int rowNo = billtable.getSelectedRow();
        if(rowNo >= 0){
        TableModel model = billtable.getModel();
        
        String bno = model.getValueAt(rowNo, 1).toString();
        String pname = model.getValueAt(rowNo, 2).toString();
        pb.setVisible(true);
        if(pname.equals("CASH")){
        pb.getCompanyData();
        pb.getBillData(bno);
        ppname.setText(pname); 
        } else{
        pb.getCompanyData();
        pb.getPartyData(pname);
        pb.getBillData(bno);          
         }
} else{
JOptionPane.showMessageDialog(null, "Select bill");
}
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
cd.clearBillTableLabel();
DefaultTableModel model = (DefaultTableModel)billtable.getModel();
model.setRowCount(0);        
itv.insertBillTable();
bsearch.setText("");
String searchString = toUpperCase(bsearch.getText());
itv.searchBill(searchString);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void notedataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notedataKeyReleased

    }//GEN-LAST:event_notedataKeyReleased

    private void notedataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notedataKeyTyped

    }//GEN-LAST:event_notedataKeyTyped

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        int rowNo = billtable.getSelectedRow();
        if(rowNo >= 0){
        int dialog = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
        if(dialog == JOptionPane.YES_OPTION){
        TableModel model = billtable.getModel();
        String bno = model.getValueAt(rowNo, 1).toString();
        ep.deleteBillDetails(bno);
        
 } 
}
else{
JOptionPane.showMessageDialog(null, "Select bill");
} 
    }//GEN-LAST:event_jButton9ActionPerformed

    private void laccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laccountMousePressed
        cmo.colorReportLabel();
    }//GEN-LAST:event_laccountMousePressed

    private void laccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laccountMouseClicked
        DefaultTableModel model = (DefaultTableModel)reporttable.getModel();
        model.setRowCount(0);
        mainscreen.setSelectedIndex(0);
        dscreen.setSelectedIndex(9);
        lscreen.setSelectedIndex(0);
        rc.showBarChart();
        rc.showTableChart();
        rc.showReportValue();
    }//GEN-LAST:event_laccountMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
                //insertDriverT();

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel barchart;
    public static javax.swing.JLabel bdnshow;
    public static javax.swing.JLabel bfrom;
    public static javax.swing.JLabel billlabel;
    public static javax.swing.JTable billtable;
    public static javax.swing.JLabel brshow;
    public static javax.swing.JTextField bsearch;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnback1;
    private javax.swing.JButton btncls;
    private javax.swing.JButton btndiv;
    private javax.swing.JButton btndot;
    private javax.swing.JButton btnequal;
    private javax.swing.JButton btnmul;
    private javax.swing.JButton btnsub;
    public static javax.swing.JLabel bto;
    public static javax.swing.JLabel bvnshow;
    public static javax.swing.JTextField c1;
    public static javax.swing.JTextField c2;
    public static javax.swing.JTextField c3;
    public static javax.swing.JButton clearbill;
    public static javax.swing.JLabel ct;
    public static javax.swing.JTextField daccountno;
    public static javax.swing.JTextField daddress;
    public static javax.swing.JLabel dahnshow;
    public static javax.swing.JLabel danshow;
    public static javax.swing.JLabel dashow;
    public static javax.swing.JTextField dbankaccount;
    public static javax.swing.JLabel dbnshow;
    public static javax.swing.JTextField demail;
    public static javax.swing.JLabel deshow;
    public static javax.swing.JTextField dholdername;
    public static javax.swing.JTextField difsc;
    public static javax.swing.JLabel difscshow;
    public static javax.swing.JTextField dlnum;
    public static javax.swing.JTextField dmob;
    public static javax.swing.JTextField dname;
    public static javax.swing.JTextField dpincode;
    public static javax.swing.JTextField dpnum;
    public static javax.swing.JLabel driverlabel;
    public static javax.swing.JTable drivertable;
    public static javax.swing.JTabbedPane dscreen;
    public static javax.swing.JTextField dstate;
    public static javax.swing.JLabel editbill;
    public static javax.swing.JLabel homelabel;
    public static javax.swing.JLabel ibill;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    public static javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lDate;
    private javax.swing.JLabel lTime;
    public static javax.swing.JLabel laccount;
    public static javax.swing.JLabel lcreate;
    public static javax.swing.JLabel ldriver;
    public static javax.swing.JLabel lhome;
    public static javax.swing.JLabel lparty;
    public static javax.swing.JTabbedPane lscreen;
    public static javax.swing.JLabel lvehicle;
    public static javax.swing.JTabbedPane mainscreen;
    public static javax.swing.JTextField nbill;
    public static javax.swing.JLabel nc;
    public static com.toedter.calendar.JDateChooser ndate;
    public static javax.swing.JComboBox<String> ndriver;
    private javax.swing.JPanel newv;
    public static javax.swing.JTextField nfrom;
    private javax.swing.JTextArea notedata;
    public static javax.swing.JComboBox<String> nparty;
    public static javax.swing.JTextField nto;
    public static javax.swing.JComboBox<String> nvehicle;
    public static javax.swing.JTextField paccountno;
    public static javax.swing.JTextField paddress;
    public static javax.swing.JLabel pahnshow;
    public static javax.swing.JLabel panshow;
    public static javax.swing.JLabel partylabel;
    public static javax.swing.JTable partytable;
    public static javax.swing.JLabel pashow;
    public static javax.swing.JTextField pbankaccount;
    public static javax.swing.JLabel pbnshow;
    public static javax.swing.JTextField pcity;
    public static javax.swing.JTextField pemail;
    public static javax.swing.JTextField pgst;
    public static javax.swing.JLabel pgstshow;
    public static javax.swing.JTextField pholdername;
    public static javax.swing.JTextField pifsc;
    public static javax.swing.JLabel pifscshow;
    public static javax.swing.JTextField pmob;
    public static javax.swing.JTextField pname;
    public static javax.swing.JTextField ppincode;
    public static javax.swing.JTextField pstate;
    public static javax.swing.JTextField remark;
    public static javax.swing.JTable reporttable;
    public static javax.swing.JButton savebill;
    private javax.swing.JTextField sc;
    public static javax.swing.JLabel tcharge;
    public static javax.swing.JLabel tnbill;
    public static javax.swing.JButton updatebill;
    public static javax.swing.JTextField vaccountno;
    public static javax.swing.JTextField vaddress;
    public static javax.swing.JLabel vahnshow;
    public static javax.swing.JLabel vanshow;
    public static javax.swing.JLabel vashow;
    public static javax.swing.JTextField vbankaccount;
    public static javax.swing.JLabel vbnshow;
    public static javax.swing.JLabel vehiclelabel;
    public static javax.swing.JTable vehicletable;
    public static javax.swing.JTextField vemail;
    public static javax.swing.JLabel veshow;
    public static javax.swing.JTextField vholdername;
    public static javax.swing.JTextField vifsc;
    public static javax.swing.JLabel vifscshow;
    public static javax.swing.JTextField vmob;
    public static javax.swing.JTextField vname;
    public static javax.swing.JTextField vnum;
    public static javax.swing.JTextField vpincode;
    public static javax.swing.JTextField vstate;
    public static javax.swing.JTextField vtype;
    public static javax.swing.JLabel wel;
    public static javax.swing.JLabel wel1;
    // End of variables declaration//GEN-END:variables
}
