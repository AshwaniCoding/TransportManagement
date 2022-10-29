
package com.transport;

import static com.transport.Welcome.*;
import java.awt.Color;

public class ColorOfMenuOption {

Color defaultcolor = new Color(173,239,209);

void colorBillLabel(){

lhome.setForeground(defaultcolor);
lcreate.setForeground(defaultcolor);
ibill.setForeground(Color.white);
ldriver.setForeground(defaultcolor);
lparty.setForeground(defaultcolor);
lvehicle.setForeground(defaultcolor);
laccount.setForeground(defaultcolor);

}

void colorPartyLabel(){

lhome.setForeground(defaultcolor);
lcreate.setForeground(defaultcolor);
ibill.setForeground(defaultcolor);
ldriver.setForeground(defaultcolor);
lparty.setForeground(Color.white);
lvehicle.setForeground(defaultcolor);
laccount.setForeground(defaultcolor);

}

void colorDriverLabel(){

lhome.setForeground(defaultcolor);
lcreate.setForeground(defaultcolor);
ibill.setForeground(defaultcolor);
ldriver.setForeground(Color.white);
lparty.setForeground(defaultcolor);
lvehicle.setForeground(defaultcolor);
laccount.setForeground(defaultcolor);

}

void colorVehicleLabel(){

lhome.setForeground(defaultcolor);
lcreate.setForeground(defaultcolor);
ibill.setForeground(defaultcolor);
ldriver.setForeground(defaultcolor);
lparty.setForeground(defaultcolor);
lvehicle.setForeground(Color.white);
laccount.setForeground(defaultcolor);

}

void colorHomeLabel(){

lhome.setForeground(Color.white);
lcreate.setForeground(defaultcolor);
ibill.setForeground(defaultcolor);
ldriver.setForeground(defaultcolor);
lparty.setForeground(defaultcolor);
lvehicle.setForeground(defaultcolor);
laccount.setForeground(defaultcolor);

}

void colorReportLabel(){

lhome.setForeground(defaultcolor);
lcreate.setForeground(defaultcolor);
ibill.setForeground(defaultcolor);
ldriver.setForeground(defaultcolor);
lparty.setForeground(defaultcolor);
lvehicle.setForeground(defaultcolor);
laccount.setForeground(Color.white);

}

void setMenuColor(){
        int s = dscreen.getSelectedIndex();
        if (s == 1){
        homelabel.setForeground(defaultcolor);
        billlabel.setForeground(Color.white);
        partylabel.setForeground(defaultcolor);
        vehiclelabel.setForeground(defaultcolor);
        driverlabel.setForeground(defaultcolor);
        }

        if (s == 2){
        homelabel.setForeground(defaultcolor);
        billlabel.setForeground(defaultcolor);
        partylabel.setForeground(Color.white);
        vehiclelabel.setForeground(defaultcolor);
        driverlabel.setForeground(defaultcolor);
        }

        if (s == 3){
        homelabel.setForeground(defaultcolor);
        billlabel.setForeground(defaultcolor);
        partylabel.setForeground(defaultcolor);
        vehiclelabel.setForeground(Color.white);
        driverlabel.setForeground(defaultcolor);
        }

        if (s == 4){
        homelabel.setForeground(defaultcolor);
        billlabel.setForeground(defaultcolor);
        partylabel.setForeground(defaultcolor);
        vehiclelabel.setForeground(defaultcolor);
        driverlabel.setForeground(Color.white);
        }
}



    
}
