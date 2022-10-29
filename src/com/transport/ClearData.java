
package com.transport;

import static com.transport.Welcome.*;


public class ClearData {
    
void ClearNewParty(){

pname.setText("");
pgst.setText("");
paddress.setText("");
pstate.setText("");
pcity.setText("");
ppincode.setText("");
pmob.setText("");
pemail.setText("");
pbankaccount.setText("");
pholdername.setText("");
paccountno.setText("");
pifsc.setText("");
}

void ClearNewVehicle(){

vnum.setText("");
vtype.setText("");
vname.setText("");
vaddress.setText("");
vstate.setText("");
vpincode.setText("");
vmob.setText("");
vemail.setText("");
vbankaccount.setText("");
vholdername.setText("");
vaccountno.setText("");
vifsc.setText("");
}

void ClearNewDriver(){

dname.setText("");
dlnum.setText("");
dpnum.setText("");
daddress.setText("");
dstate.setText("");
dpincode.setText("");
dmob.setText("");
demail.setText("");
dbankaccount.setText("");
dholdername.setText("");
daccountno.setText("");
difsc.setText("");
}

void ClearNewBill(){
ndate.setDate(null);
nbill.setText("");
nparty.setSelectedIndex(0);
nfrom.setText("");
nto.setText("");
nvehicle.setSelectedIndex(0);
ndriver.setSelectedIndex(0);
nbill.setText("");
c1.setText("");
c2.setText("");
c3.setText("");
ct.setText("");
remark.setText("");
}

void clearPartyTableLabel(){

pashow.setText("");
pgstshow.setText("");
pbnshow.setText("");
panshow.setText("");
pahnshow.setText("");
pifscshow.setText("");

}

void clearVehicleTableLabel(){

vashow.setText("");
veshow.setText("");
vbnshow.setText("");
vanshow.setText("");
vahnshow.setText("");
vifscshow.setText("");

}

void clearDriverTableLabel(){

dashow.setText("");
deshow.setText("");
dbnshow.setText("");
danshow.setText("");
dahnshow.setText("");
difscshow.setText("");

}

void clearBillTableLabel(){

bfrom.setText("");
bto.setText("");
bdnshow.setText("");
bvnshow.setText("");
brshow.setText("");
bsearch.setText("");

}

}
