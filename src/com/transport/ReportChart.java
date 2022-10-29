
package com.transport;

import static com.transport.InsertTableValue.user;
import static com.transport.Welcome.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class ReportChart {

    public void showBarChart(){

try {

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT date_format(date, '%M'),sum(total) from newbill WHERE username = ? GROUP BY year(date), month(date) ORDER BY year(date), month(date)";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, user);

ResultSet rs = pst.executeQuery();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

while(rs.next()){  
        dataset.setValue(rs.getDouble("sum(total)"), "Amount", rs.getString("date_format(date, '%M')"));
        

}
        JFreeChart chart = ChartFactory.createBarChart("Contribution","Monthly","Amount", dataset, PlotOrientation.VERTICAL, true,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.setRangeGridlinePaint(Color.BLUE);
       
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204,0,51);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        barchart.removeAll();
        barchart.add(barpChartPanel, BorderLayout.CENTER);
        barchart.validate();


} catch(Exception e){
e.printStackTrace();
}

}

    public void showTableChart(){

try {

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT date_format(date, '%M'),sum(total) from newbill WHERE username = ? GROUP BY year(date), month(date) ORDER BY year(date), month(date)";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, user);

ResultSet rs = pst.executeQuery();

int i =1;


      
while(rs.next()){

String month = rs.getString("date_format(date, '%M')");
String amount = String.valueOf(rs.getDouble("sum(total)"));


Object[] obj = {String.valueOf(i),month,amount};
DefaultTableModel model = (DefaultTableModel)reporttable.getModel();
model.addRow(obj);

i++;
}  



} catch(Exception e){
e.printStackTrace();
}

}

    public void showReportValue(){

try {

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","");
String querry = "SELECT COUNT(id), SUM(total) from newbill WHERE username = ?";
PreparedStatement pst = con.prepareStatement(querry);
pst.setString(1, user);

ResultSet rs = pst.executeQuery();

if(rs.next()){

String count = rs.getString("COUNT(id)");
String tamount = String.valueOf(rs.getDouble("SUM(total)"));

tnbill.setText(count);
tcharge.setText(tamount);

}  
        



} catch(Exception e){
e.printStackTrace();
}

}


}
