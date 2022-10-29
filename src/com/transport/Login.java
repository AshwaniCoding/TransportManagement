package com.transport;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class Login extends javax.swing.JFrame {

public static String company_name, address, state, city, pincode, email, gst_number, username, password, confirmpwd, securityQuestion, securityAnswer, uid, yes;
Date company_start_date, financial_year_from;

int id = 0;

public Login() {
        initComponents();
        Label();
        setTitle("Transport Management");
        this.setExtendedState(Login.MAXIMIZED_BOTH);
        this.setResizable(false);
        cross.setVisible(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/tansport/images/truck_30px.png")));
    }

public int getId(){
ResultSet rs = null;
try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "select max(id) from signup";
Statement st = con.createStatement();
rs = st.executeQuery(querry);
while(rs.next()){

id = rs.getInt(1);
id++;
}
}
catch(Exception e){
e.printStackTrace();
}
return id;
}

boolean companyValidation(){


    company_name = toUpperCase(Login.cName.getText());
   address = toUpperCase(Login.cAddress.getText());
   state = toUpperCase(Login.cState.getText());
   city = toUpperCase(Login.cCity.getText());
   pincode = toUpperCase(Login.cPincode.getText());
   email = toUpperCase(Login.cEmail.getText());
   gst_number = toUpperCase(Login.cGst.getText());
company_start_date = jcstartdate.getDate();
financial_year_from = jcfystartdate.getDate();

if (company_name.equals("")){
cn.setVisible(true);
return false;
} else{cn.setVisible(false);}

if (address.equals("")){
ca.setVisible(true);
return false;
} else{ca.setVisible(false);}

if (state.equals("")){
cs.setVisible(true);
return false;
} else{cs.setVisible(false);}

if (city.equals("")){
cc.setVisible(true);
return false;
} else{cc.setVisible(false);}

if (pincode.equals("")){
cp.setVisible(true);
return false;
} else{cp.setVisible(false);}

if (email.equals("")){
ce.setVisible(true);
return false;
} else{ce.setVisible(false);}

if (gst_number.equals("")){
cg.setVisible(true);
return false;
} else{cg.setVisible(false);}

if (company_start_date == null){
lcsstartdate.setVisible(true);
return false;
} else{lcsstartdate.setVisible(false);}

if (financial_year_from == null){
lcfystartdate.setVisible(true);
return false;
} else{lcfystartdate.setVisible(false);}


return true;

}

boolean userValidation(){

       username = toUpperCase(ru.getText());
       password = toUpperCase(String.valueOf(rp.getPassword()));
       confirmpwd = toUpperCase(String.valueOf(rcp.getPassword())); 
       securityQuestion = toUpperCase(secq.getSelectedItem());
       securityAnswer = toUpperCase(seca.getText());

if (username.equals("")){
fu.setText("Enter Username");
fu.setVisible(true);
return false;
} else{fu.setText("");}

if(username.length()<=5){
fu.setText("Username should be more than 5 characters");
fu.setVisible(true);
return false;
}

checkUsername();

if (username.equals(yes)){
fu.setText("Username already exist");
fu.setVisible(true);
return false;
} else{fu.setText("");}

if (password.equals("")){
fp.setText("Enter Password");
fp.setVisible(true);
return false;
} else{fp.setText("");}


if (!password.equals(confirmpwd)){
fcp.setVisible(true);
fcp.setText("Password not matched");
return false;
} else{fcp.setVisible(false);}

if (securityAnswer.equals("")){
fsa.setVisible(true);
fsa.setText("Enter Security Answer");
return false;
} else{fsa.setVisible(false);}

return true;
}

public void Label(){
cn.setVisible(false);
ca.setVisible(false);
cs.setVisible(false);
cc.setVisible(false);
cp.setVisible(false);
ce.setVisible(false);
cg.setVisible(false);
lcsstartdate.setVisible(false);
lcfystartdate.setVisible(false);
fu.setVisible(false);
fp.setVisible(false);
fcp.setVisible(false);
fsa.setVisible(false);
}

public void checkUsername(){
String u = toUpperCase(ru.getText());
if(u.length()<=5){
fu.setVisible(true);
fu.setText("Username should be more than 5 characters");

} 
else if(u.length()>5){

ResultSet rs = null;

try{
        
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "select * from signup where username ='"+u+"'";
Statement st = con.createStatement();
rs = st.executeQuery(querry);

if(rs.next()){
yes = rs.getString("username");
fu.setVisible(false);
}
    
}catch(Exception e){
e.printStackTrace();
}

}
}

public void checkPassword(){
String p = rp.getText();
if(p.length()<7){
fp.setVisible(true);
fp.setText("Password should be of 8 character");
} else{
fp.setText("");
fp.setVisible(false);}
}

public void BackToLogin(){
       int dialog = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
       if (dialog == JOptionPane.YES_OPTION){
         cName.setText("");
         cAddress.setText("");
         cState.setText("");
         cCity.setText("");
         cPincode.setText("");
         cEmail.setText("");
         cGst.setText("");
         jcstartdate.setDate(null);
         jcfystartdate.setDate(null);
         jTabbedPane1.setSelectedIndex(0);
       } 
else if(dialog == JOptionPane.NO_OPTION){remove(dialog);}
else {remove(dialog);}        
}

public void BackToHome(){
         cName.setText("");
         cAddress.setText("");
         cState.setText("");
         cCity.setText("");
         cPincode.setText("");
         cEmail.setText("");
         cGst.setText("");
         jcstartdate.setDate(null);
         jcfystartdate.setDate(null);
         ru.setText("");
         rp.setText("");
         rcp.setText("");
         secq.setSelectedItem(0);
         seca.setText("");
}

void insertDetails(){
        
SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

   String csd = dateformat.format(jcstartdate.getDate());
   String fyf = dateformat.format(jcfystartdate.getDate());
try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "INSERT INTO `signup`(`id`, `companyname`, `address`, `state`, `city`, `pincode`, `email`, `gst`, `startdate`, `financialyeardate`, `username`, `password`, `securityquestion`, `securityanswer`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
PreparedStatement stmt = con.prepareStatement(querry);

                    stmt.setInt(1, getId());
                    stmt.setString(2, company_name);
                    stmt.setString(3, address);
                    stmt.setString(4, state);
                    stmt.setString(5, city);
                    stmt.setString(6, pincode);
                    stmt.setString(7, email);
                    stmt.setString(8, gst_number);
                    stmt.setString(9, csd);
                    stmt.setString(10, fyf);
                    stmt.setString(11, username);
                    stmt.setString(12, password);
                    stmt.setString(13, securityQuestion);
                    stmt.setString(14, securityAnswer);

int i = stmt.executeUpdate();
if (i>0){
JOptionPane.showMessageDialog(this, "Registered Successfully");
BackToHome();
jTabbedPane1.setSelectedIndex(0);
}else{
JOptionPane.showMessageDialog(this,"Not Registered");
}

}
catch(Exception e){
e.printStackTrace();
fu.setText("Username alresdy exist");
fu.setVisible(true);
}
}

void userVerification(String username, String password){
try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry1 = "SELECT * FROM signup WHERE username = ? and password = ?";
PreparedStatement pst = con.prepareStatement(querry1);
pst.setString(1, username);
pst.setString(2, password);
ResultSet rs = pst.executeQuery();

if(rs.next()){

Welcome w = new Welcome();
InsertTableValue itv = new InsertTableValue();

w.setVisible(true);
dispose();
w.mainscreen.setSelectedIndex(0);
w.dscreen.setSelectedIndex(0);
w.lscreen.setSelectedIndex(0);

String m = rs.getString(2);
w.nc.setText(m);

itv.user = username;
} else {
JOptionPane.showMessageDialog(this, "Wrong Username & Password");
}

}
catch(Exception a){
a.printStackTrace();
}
}

void getUsername(){
String forgetuser = toUpperCase(em.getText());
if(!forgetuser.equals("")){
try{

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry1 = "SELECT * FROM signup WHERE email = ?";
PreparedStatement pst = con.prepareStatement(querry1);
pst.setString(1, forgetuser);
ResultSet rs = pst.executeQuery();

if (rs.next()){
String n = rs.getString(11);
showusername.setText(n);
}else {
JOptionPane.showMessageDialog(this, "Username not found");
 }
}
catch(Exception e){
e.printStackTrace();
  }
 }
else{
eu.setText("Please enter registered email");
 }
}

void forgetPassword(String username, String securityQ, String securityA, String newPwd){
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry1 = "SELECT * FROM signup WHERE username = ? and securityquestion = ? and securityanswer = ?";
PreparedStatement pst = con.prepareStatement(querry1);
pst.setString(1, username);
pst.setString(2, securityQ);
pst.setString(3, securityA);
ResultSet rs = pst.executeQuery();

if (rs.next()){
pst.executeUpdate("update signup set password ='"+newPwd+"' where username = '"+username+"'");
JOptionPane.showMessageDialog(this, "Password Changed Successfully");
fuser.setText("");
fsecq.setSelectedItem(0);
fseca.setText("");
fpass.setText("");
fcpass.setText("");
}else {
JOptionPane.showMessageDialog(this, "Username not found");
 }
}
catch(Exception e){
e.printStackTrace();
  }

}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        login = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        luser = new javax.swing.JTextField();
        lpass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Check = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        passerror = new javax.swing.JLabel();
        usererror = new javax.swing.JLabel();
        cross = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        register = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        cdetails = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cAddress = new javax.swing.JTextField();
        cState = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cCity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cPincode = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cEmail = new javax.swing.JTextField();
        cGst = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ca = new javax.swing.JLabel();
        cn = new javax.swing.JLabel();
        cc = new javax.swing.JLabel();
        cs = new javax.swing.JLabel();
        ce = new javax.swing.JLabel();
        cp = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jcfystartdate = new com.toedter.calendar.JDateChooser();
        cg = new javax.swing.JLabel();
        lcfystartdate = new javax.swing.JLabel();
        jcstartdate = new com.toedter.calendar.JDateChooser();
        lcsstartdate = new javax.swing.JLabel();
        ce1 = new javax.swing.JLabel();
        cg1 = new javax.swing.JLabel();
        userdetails = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        createaccount = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        rcp = new javax.swing.JPasswordField();
        rp = new javax.swing.JPasswordField();
        jLabel22 = new javax.swing.JLabel();
        ru = new javax.swing.JTextField();
        secq = new javax.swing.JComboBox<>();
        fu = new javax.swing.JLabel();
        fcp = new javax.swing.JLabel();
        fp = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        seca = new javax.swing.JTextField();
        fsa = new javax.swing.JLabel();
        forget = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        forgetpane = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        fuser = new javax.swing.JTextField();
        fseca = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        bl = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        cs1 = new javax.swing.JLabel();
        ce2 = new javax.swing.JLabel();
        cp1 = new javax.swing.JLabel();
        cg2 = new javax.swing.JLabel();
        ce3 = new javax.swing.JLabel();
        cg3 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        fsecq = new javax.swing.JComboBox<>();
        fpass = new javax.swing.JPasswordField();
        fcpass = new javax.swing.JPasswordField();
        jLabel32 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        showusername = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        em = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        showusername1 = new javax.swing.JLabel();
        eu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setBackground(new java.awt.Color(173, 239, 209));
        login.setPreferredSize(new java.awt.Dimension(1920, 980));
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 32, 63));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        luser.setBackground(new java.awt.Color(173, 239, 209));
        luser.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        luser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        luser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luserActionPerformed(evt);
            }
        });
        jPanel2.add(luser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 240, 30));

        lpass.setBackground(new java.awt.Color(173, 239, 209));
        lpass.setFont(new java.awt.Font("Algerian", 0, 13)); // NOI18N
        lpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lpassActionPerformed(evt);
            }
        });
        jPanel2.add(lpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 240, 30));

        jLabel3.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(173, 239, 209));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("fORGET PASSWORD?");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 160, 30));

        jLabel5.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(173, 239, 209));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("WELCOME");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 400, 30));

        jButton1.setBackground(new java.awt.Color(173, 239, 209));
        jButton1.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 160, 30));

        jLabel7.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(173, 239, 209));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("REGISTER NEW COMPANY");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 180, 30));

        Check.setBackground(new java.awt.Color(0, 32, 63));
        Check.setFont(new java.awt.Font("Algerian", 0, 13)); // NOI18N
        Check.setForeground(new java.awt.Color(173, 239, 209));
        Check.setText("Show Password");
        Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckActionPerformed(evt);
            }
        });
        jPanel2.add(Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 140, 20));

        jLabel18.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(173, 239, 209));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tansport/images/username_20px.png"))); // NOI18N
        jLabel18.setText("USERNAME");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 240, 30));

        jLabel23.setFont(new java.awt.Font("Algerian", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(173, 239, 209));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tansport/images/password_20px.png"))); // NOI18N
        jLabel23.setText("PASSWORD");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 240, 30));

        passerror.setForeground(new java.awt.Color(255, 0, 0));
        passerror.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(passerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 240, 20));

        usererror.setForeground(new java.awt.Color(255, 0, 0));
        usererror.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(usererror, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 240, 20));

        login.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 470, 610));

        cross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tansport/images/cancel_50px.png"))); // NOI18N
        cross.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crossMouseClicked(evt);
            }
        });
        login.add(cross, new org.netbeans.lib.awtextra.AbsoluteConstraints(1860, 0, 50, 60));

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Copyright © 2022 Transport Management System");
        login.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 980, 320, -1));

        jTabbedPane1.addTab("login", login);

        register.setBackground(new java.awt.Color(173, 239, 209));
        register.setMinimumSize(new java.awt.Dimension(1920, 980));
        register.setPreferredSize(new java.awt.Dimension(2000, 980));
        register.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(173, 239, 209));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        register.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 1230, 40));

        cdetails.setBackground(new java.awt.Color(0, 32, 63));
        cdetails.setPreferredSize(new java.awt.Dimension(1200, 700));
        cdetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(173, 239, 209));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("register NEW COMPANY");
        cdetails.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1200, 40));

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(173, 239, 209));
        jLabel1.setText("COMPANY NAME");
        cdetails.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 230, 30));

        cName.setBackground(new java.awt.Color(173, 239, 209));
        cName.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        cName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cNameKeyReleased(evt);
            }
        });
        cdetails.add(cName, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 230, 30));

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(173, 239, 209));
        jLabel2.setText("ADDRESS");
        cdetails.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 230, 30));

        cAddress.setBackground(new java.awt.Color(173, 239, 209));
        cAddress.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        cAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cAddressKeyReleased(evt);
            }
        });
        cdetails.add(cAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 230, 30));

        cState.setBackground(new java.awt.Color(173, 239, 209));
        cState.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        cState.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cStateKeyReleased(evt);
            }
        });
        cdetails.add(cState, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 230, 30));

        jLabel9.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(173, 239, 209));
        jLabel9.setText("STATE");
        cdetails.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 230, 30));

        jLabel10.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(173, 239, 209));
        jLabel10.setText("CITY");
        cdetails.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 230, 30));

        cCity.setBackground(new java.awt.Color(173, 239, 209));
        cCity.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        cCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cCityKeyReleased(evt);
            }
        });
        cdetails.add(cCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 230, 30));

        jLabel11.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(173, 239, 209));
        jLabel11.setText("PINCODE");
        cdetails.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 230, 30));

        cPincode.setBackground(new java.awt.Color(173, 239, 209));
        cPincode.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        cPincode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cPincodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cPincodeKeyTyped(evt);
            }
        });
        cdetails.add(cPincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 230, 30));

        jLabel12.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(173, 239, 209));
        jLabel12.setText("EMAIL");
        cdetails.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 230, 30));

        cEmail.setBackground(new java.awt.Color(173, 239, 209));
        cEmail.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        cEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cEmailKeyReleased(evt);
            }
        });
        cdetails.add(cEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 230, 30));

        cGst.setBackground(new java.awt.Color(173, 239, 209));
        cGst.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        cGst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cGstKeyReleased(evt);
            }
        });
        cdetails.add(cGst, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 230, 30));

        jLabel13.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(173, 239, 209));
        jLabel13.setText("GST NUMBER");
        cdetails.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 220, 30));

        jLabel14.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(173, 239, 209));
        jLabel14.setText("COMPANY START DATE");
        cdetails.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 250, 30));

        next.setBackground(new java.awt.Color(173, 239, 209));
        next.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        next.setText("Next");
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
        });
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        cdetails.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, 160, 30));

        jLabel15.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(173, 239, 209));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("ALREADY A USER? LOGIN");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        cdetails.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 620, 280, 30));
        cdetails.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 420, -1));

        ca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ca.setForeground(new java.awt.Color(255, 0, 0));
        ca.setText("Enter Company Address");
        cdetails.add(ca, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, 210, 30));

        cn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cn.setForeground(new java.awt.Color(255, 0, 0));
        cn.setText("Enter Company Name");
        cdetails.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 210, 30));

        cc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cc.setForeground(new java.awt.Color(255, 0, 0));
        cc.setText("Enter City Name");
        cdetails.add(cc, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 250, 210, 30));

        cs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cs.setForeground(new java.awt.Color(255, 0, 0));
        cs.setText("Enter State Name");
        cdetails.add(cs, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, 210, 30));

        ce.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ce.setForeground(new java.awt.Color(255, 0, 0));
        ce.setText("Enter Email");
        cdetails.add(ce, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 350, 210, 30));

        cp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cp.setForeground(new java.awt.Color(255, 0, 0));
        cp.setText("Enter Pincode");
        cdetails.add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 300, 210, 30));

        jLabel16.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(173, 239, 209));
        jLabel16.setText("FINANCIAL YEAR FROM");
        cdetails.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 250, 30));

        jcfystartdate.setBackground(new java.awt.Color(173, 239, 209));
        jcfystartdate.setDateFormatString("dd MMM, yyyy");
        jcfystartdate.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jcfystartdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcfystartdateKeyReleased(evt);
            }
        });
        cdetails.add(jcfystartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, 230, 30));

        cg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cg.setForeground(new java.awt.Color(255, 0, 0));
        cg.setText("Enter GST Number");
        cdetails.add(cg, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, 210, 30));

        lcfystartdate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lcfystartdate.setForeground(new java.awt.Color(255, 0, 0));
        lcfystartdate.setText("Select Financial Year Start Date");
        cdetails.add(lcfystartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, 210, 30));

        jcstartdate.setBackground(new java.awt.Color(173, 239, 209));
        jcstartdate.setDateFormatString("dd MMM, yyyy");
        jcstartdate.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jcstartdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcstartdateKeyReleased(evt);
            }
        });
        cdetails.add(jcstartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 230, 30));

        lcsstartdate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lcsstartdate.setForeground(new java.awt.Color(255, 0, 0));
        lcsstartdate.setText("Select Company Start Date");
        cdetails.add(lcsstartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, 210, 30));

        ce1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ce1.setForeground(new java.awt.Color(255, 0, 0));
        cdetails.add(ce1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, 210, 30));

        cg1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cg1.setForeground(new java.awt.Color(255, 0, 0));
        cdetails.add(cg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, 210, 30));

        jTabbedPane2.addTab("tab1", cdetails);

        userdetails.setBackground(new java.awt.Color(0, 32, 63));
        userdetails.setPreferredSize(new java.awt.Dimension(1200, 700));
        userdetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(173, 239, 209));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("register NEW COMPANY");
        userdetails.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1200, 40));

        jLabel19.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(173, 239, 209));
        jLabel19.setText("password");
        userdetails.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 230, 30));

        jLabel20.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(173, 239, 209));
        jLabel20.setText("set security question");
        userdetails.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 230, 30));

        createaccount.setBackground(new java.awt.Color(173, 239, 209));
        createaccount.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        createaccount.setText("create account");
        createaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createaccountActionPerformed(evt);
            }
        });
        userdetails.add(createaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, 160, 30));

        jLabel21.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(173, 239, 209));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("ALREADY A USER? LOGIN");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        userdetails.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 540, 280, 30));
        userdetails.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 420, 10));

        rcp.setBackground(new java.awt.Color(173, 239, 209));
        rcp.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        userdetails.add(rcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 230, 30));

        rp.setBackground(new java.awt.Color(173, 239, 209));
        rp.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        rp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rpKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rpKeyTyped(evt);
            }
        });
        userdetails.add(rp, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 230, 30));

        jLabel22.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(173, 239, 209));
        jLabel22.setText("username");
        userdetails.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 230, 30));

        ru.setBackground(new java.awt.Color(173, 239, 209));
        ru.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        ru.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ruKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ruKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ruKeyTyped(evt);
            }
        });
        userdetails.add(ru, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 230, 30));

        secq.setFont(new java.awt.Font("Algerian", 0, 13)); // NOI18N
        secq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Favourite teacher name?", "First school name?", "Favourite person name?", "First pet name?", "First mobile name? ", " " }));
        userdetails.add(secq, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 230, 30));

        fu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fu.setForeground(new java.awt.Color(255, 0, 0));
        userdetails.add(fu, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 290, 30));

        fcp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fcp.setForeground(new java.awt.Color(255, 0, 0));
        userdetails.add(fcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 290, 30));

        fp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fp.setForeground(new java.awt.Color(255, 0, 0));
        userdetails.add(fp, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 230, 290, 30));

        jLabel25.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(173, 239, 209));
        jLabel25.setText("confirm password");
        userdetails.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 230, 30));

        jLabel26.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(173, 239, 209));
        jLabel26.setText("Security answer");
        userdetails.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 230, 30));

        seca.setBackground(new java.awt.Color(173, 239, 209));
        seca.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        userdetails.add(seca, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 230, 30));

        fsa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fsa.setForeground(new java.awt.Color(255, 0, 0));
        userdetails.add(fsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 380, 290, 30));

        jTabbedPane2.addTab("tab2", userdetails);

        register.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 1200, 700));

        jTabbedPane1.addTab("register", register);

        forget.setBackground(new java.awt.Color(173, 239, 209));
        forget.setPreferredSize(new java.awt.Dimension(1920, 980));
        forget.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(173, 239, 209));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        forget.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 1110, 50));

        forgetpane.setBackground(new java.awt.Color(0, 32, 63));
        forgetpane.setPreferredSize(new java.awt.Dimension(1200, 700));
        forgetpane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(173, 239, 209));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("forget password");
        forgetpane.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1200, 40));

        jLabel31.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(173, 239, 209));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Forget username");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        forgetpane.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, 140, 30));

        fuser.setBackground(new java.awt.Color(173, 239, 209));
        fuser.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        forgetpane.add(fuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 230, 30));

        fseca.setBackground(new java.awt.Color(173, 239, 209));
        fseca.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        forgetpane.add(fseca, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 230, 30));

        jLabel33.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(173, 239, 209));
        jLabel33.setText("security answer");
        forgetpane.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 230, 30));

        jLabel34.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(173, 239, 209));
        jLabel34.setText("new password");
        forgetpane.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 230, 30));

        jLabel35.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(173, 239, 209));
        jLabel35.setText("confirm new password");
        forgetpane.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 230, 30));

        jButton5.setBackground(new java.awt.Color(173, 239, 209));
        jButton5.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jButton5.setText("forget");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        forgetpane.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 160, 30));

        bl.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        bl.setForeground(new java.awt.Color(173, 239, 209));
        bl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bl.setText("back to LOGIN");
        bl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blMouseClicked(evt);
            }
        });
        forgetpane.add(bl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, 140, 30));
        forgetpane.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 380, -1));

        cs1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cs1.setForeground(new java.awt.Color(255, 0, 0));
        forgetpane.add(cs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, 210, 30));

        ce2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ce2.setForeground(new java.awt.Color(255, 0, 0));
        forgetpane.add(ce2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, 210, 30));

        cp1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cp1.setForeground(new java.awt.Color(255, 0, 0));
        forgetpane.add(cp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, 210, 30));

        cg2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cg2.setForeground(new java.awt.Color(255, 0, 0));
        forgetpane.add(cg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 390, 210, 30));

        ce3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ce3.setForeground(new java.awt.Color(255, 0, 0));
        forgetpane.add(ce3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, 210, 30));

        cg3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cg3.setForeground(new java.awt.Color(255, 0, 0));
        forgetpane.add(cg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, 210, 30));

        jLabel27.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(173, 239, 209));
        jLabel27.setText("set security question");
        forgetpane.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 230, 30));

        fsecq.setFont(new java.awt.Font("Algerian", 0, 13)); // NOI18N
        fsecq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Favourite teacher name?", "First school name?", "Favourite person name?", "First pet name?", "First mobile name? ", " " }));
        forgetpane.add(fsecq, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 230, 30));

        fpass.setBackground(new java.awt.Color(173, 239, 209));
        fpass.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        forgetpane.add(fpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 230, 30));

        fcpass.setBackground(new java.awt.Color(173, 239, 209));
        fcpass.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        forgetpane.add(fcpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 230, 30));

        jLabel32.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(173, 239, 209));
        jLabel32.setText("username");
        forgetpane.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 230, 30));

        jTabbedPane4.addTab("tab1", forgetpane);

        jPanel1.setBackground(new java.awt.Color(0, 32, 63));
        jPanel1.setForeground(new java.awt.Color(0, 32, 63));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(173, 239, 209));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("forget username");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1190, 40));

        jLabel37.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(173, 239, 209));
        jLabel37.setText("enter Registered Email");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 300, 30));

        showusername.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        showusername.setForeground(new java.awt.Color(255, 255, 51));
        jPanel1.add(showusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 140, 30));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 350, 20));

        em.setBackground(new java.awt.Color(173, 239, 209));
        em.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        jPanel1.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 300, 30));

        jLabel28.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(173, 239, 209));
        jLabel28.setText("Your Username :");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 140, 30));

        jButton2.setBackground(new java.awt.Color(173, 239, 209));
        jButton2.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        jButton2.setText("get username");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, -1, 30));

        jLabel38.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(173, 239, 209));
        jLabel38.setText("back to login");
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 200, 30));

        jLabel39.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(173, 239, 209));
        jLabel39.setText("back to Forget password");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 200, 30));

        showusername1.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        showusername1.setForeground(new java.awt.Color(173, 239, 209));
        jPanel1.add(showusername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 140, 30));

        eu.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(eu, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 290, 230, 30));

        jTabbedPane4.addTab("tab2", jPanel1);

        forget.add(jTabbedPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 1200, 700));

        jTabbedPane1.addTab("forget", forget);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1920, 1120));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void luserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_luserActionPerformed

    private void lpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lpassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

String loginuser = toUpperCase(luser.getText());
String loginpass = toUpperCase(String.valueOf(lpass.getPassword()));


if (loginuser.trim().equals("") && loginpass.trim().equals("")){
usererror.setText("Please Enter Username");
passerror.setText("Please Enter Password");
} else if(!loginuser.trim().equals("") && loginpass.trim().equals("")){
usererror.setText("");
passerror.setText("Please Enter Password");
} else if(loginuser.trim().equals("") && !loginpass.trim().equals("")){
usererror.setText("Please Enter Username");
passerror.setText("");
} else{
userVerification(loginuser, loginpass);
usererror.setText("");
passerror.setText("");

}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked

    jTabbedPane1.setSelectedIndex(1);
    jTabbedPane2.setSelectedIndex(0);

    }//GEN-LAST:event_jLabel7MouseClicked

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
if(companyValidation() == true){
   
jTabbedPane1.setSelectedIndex(1);
jTabbedPane2.setSelectedIndex(1);

}
    }//GEN-LAST:event_nextActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked

BackToLogin();

    }//GEN-LAST:event_jLabel15MouseClicked

    private void createaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createaccountActionPerformed
  

if(companyValidation() == true){
 if (userValidation() == true){
insertDetails();
 }
}
        
    }//GEN-LAST:event_createaccountActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked

    jTabbedPane1.setSelectedIndex(0);
    BackToHome();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckActionPerformed

        if(Check.isSelected())
        {lpass.setEchoChar((char)0);}
        else {lpass.setEchoChar('*');}

    }//GEN-LAST:event_CheckActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
    
    jTabbedPane1.setSelectedIndex(2);
    jTabbedPane4.setSelectedIndex(0);

    }//GEN-LAST:event_jLabel3MouseClicked

    private void cNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cNameKeyReleased


    }//GEN-LAST:event_cNameKeyReleased

    private void cAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cAddressKeyReleased

    }//GEN-LAST:event_cAddressKeyReleased

    private void cStateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cStateKeyReleased

    }//GEN-LAST:event_cStateKeyReleased

    private void cCityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cCityKeyReleased

    }//GEN-LAST:event_cCityKeyReleased

    private void cPincodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPincodeKeyReleased

    }//GEN-LAST:event_cPincodeKeyReleased

    private void cEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cEmailKeyReleased
 
    }//GEN-LAST:event_cEmailKeyReleased

    private void cGstKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cGstKeyReleased
    
    }//GEN-LAST:event_cGstKeyReleased

    private void jcstartdateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcstartdateKeyReleased
      
    }//GEN-LAST:event_jcstartdateKeyReleased

    private void jcfystartdateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcfystartdateKeyReleased
    
    }//GEN-LAST:event_jcfystartdateKeyReleased

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nextMouseClicked

    private void rpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rpKeyPressed
        
    }//GEN-LAST:event_rpKeyPressed

    private void ruKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ruKeyReleased

    }//GEN-LAST:event_ruKeyReleased

    private void rpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rpKeyReleased

    }//GEN-LAST:event_rpKeyReleased

    private void rpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rpKeyTyped

    }//GEN-LAST:event_rpKeyTyped

    private void ruKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ruKeyPressed

    }//GEN-LAST:event_ruKeyPressed

    private void ruKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ruKeyTyped

    }//GEN-LAST:event_ruKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String fusername = toUpperCase(fuser.getText().trim());
        String fsecurityq = toUpperCase(fsecq.getSelectedItem());
        String fsecuritya = toUpperCase(fseca.getText().trim());
        String fnewpass = fpass.getText();
        String fnewcpass = fcpass.getText();
        
        if(fnewpass.equals(fnewcpass)){
          String newpass = toUpperCase(fpass.getText());
          forgetPassword(fusername,fsecurityq,fsecuritya,newpass); 
           }
        else{
         cg2.setText("New Password not matched");
         }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void blMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blMouseClicked
        int dialog = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (dialog == JOptionPane.YES_OPTION){
          
           jTabbedPane1.setSelectedIndex(0); 
           fuser.setText("");
           fsecq.setSelectedItem(0);
           fseca.setText("");
           fpass.setText("");
           fcpass.setText(""); 
        }
        else if(dialog == JOptionPane.NO_OPTION){remove(dialog);}
        else {remove(dialog);}
    }//GEN-LAST:event_blMouseClicked

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
jTabbedPane1.setSelectedIndex(0);
em.setText("");
showusername.setText("");
    }//GEN-LAST:event_jLabel38MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
jTabbedPane1.setSelectedIndex(2);
jTabbedPane4.setSelectedIndex(0);
em.setText("");
showusername.setText("");
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
jTabbedPane1.setSelectedIndex(2);
jTabbedPane4.setSelectedIndex(1);
fuser.setText("");
fsecq.setSelectedItem(0);
fseca.setText("");
fpass.setText("");
fcpass.setText("");
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        getUsername();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cPincodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPincodeKeyTyped
char c  = evt.getKeyChar();
if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
getToolkit().beep();
evt.consume();
}
    }//GEN-LAST:event_cPincodeKeyTyped

    private void crossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossMouseClicked
        this.dispose();
    }//GEN-LAST:event_crossMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Check;
    private javax.swing.JLabel bl;
    public static javax.swing.JTextField cAddress;
    public static javax.swing.JTextField cCity;
    public static javax.swing.JTextField cEmail;
    public static javax.swing.JTextField cGst;
    public static javax.swing.JTextField cName;
    public static javax.swing.JTextField cPincode;
    public static javax.swing.JTextField cState;
    public static javax.swing.JLabel ca;
    public static javax.swing.JLabel cc;
    private javax.swing.JPanel cdetails;
    public static javax.swing.JLabel ce;
    private javax.swing.JLabel ce1;
    private javax.swing.JLabel ce2;
    private javax.swing.JLabel ce3;
    public static javax.swing.JLabel cg;
    private javax.swing.JLabel cg1;
    private javax.swing.JLabel cg2;
    private javax.swing.JLabel cg3;
    public static javax.swing.JLabel cn;
    public static javax.swing.JLabel cp;
    private javax.swing.JLabel cp1;
    private javax.swing.JButton createaccount;
    private javax.swing.JLabel cross;
    public static javax.swing.JLabel cs;
    private javax.swing.JLabel cs1;
    private javax.swing.JTextField em;
    private javax.swing.JLabel eu;
    private javax.swing.JLabel fcp;
    private javax.swing.JPasswordField fcpass;
    public static javax.swing.JPanel forget;
    private javax.swing.JPanel forgetpane;
    private javax.swing.JLabel fp;
    private javax.swing.JPasswordField fpass;
    private javax.swing.JLabel fsa;
    public static javax.swing.JTextField fseca;
    private javax.swing.JComboBox<String> fsecq;
    private javax.swing.JLabel fu;
    public static javax.swing.JTextField fuser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    public static com.toedter.calendar.JDateChooser jcfystartdate;
    public static com.toedter.calendar.JDateChooser jcstartdate;
    public static javax.swing.JLabel lcfystartdate;
    public static javax.swing.JLabel lcsstartdate;
    public static javax.swing.JPanel login;
    private javax.swing.JPasswordField lpass;
    private javax.swing.JTextField luser;
    public static javax.swing.JButton next;
    private javax.swing.JLabel passerror;
    private javax.swing.JPasswordField rcp;
    private javax.swing.JPanel register;
    private javax.swing.JPasswordField rp;
    private javax.swing.JTextField ru;
    private javax.swing.JTextField seca;
    private javax.swing.JComboBox<String> secq;
    private javax.swing.JLabel showusername;
    private javax.swing.JLabel showusername1;
    private javax.swing.JPanel userdetails;
    private javax.swing.JLabel usererror;
    // End of variables declaration//GEN-END:variables
}
