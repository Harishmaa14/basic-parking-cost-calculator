import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Carparking
{
String carid;
String carno;
int entryh;
int entrym;
int exith;
int exitm;
String type;
Carparking()
{
}
Carparking(String carid,String carno,int entryh,int entrym,int exith,int exitm,String type)
  {
this.carid=carid;
this.carno=carno;
this.entryh=entryh;
this.entrym=entrym;
this.exith=exith;
this.exitm=exitm;
this.type=type;
   }
int calculatecharge(String type,int entryh,int entrym,int exith,int exitm)
      {
         int charge=0;
if(type.equals("NV"))
         {
         int totalh=exith-entryh;
         int totalm=exitm-entrym;
         if(totalh<0) 
         {
          totalh=totalh+24;
          }
        if(totalh>24) 
         {
          totalh=totalh-24;
          } 
        if(totalm<0) 
         {
          totalh=totalh-1;
          }
 if(totalm>60) 
         {
          totalh=totalh+1;
          }
if(totalm<10 && totalh==0)
                {
                  charge=0;
                 }
        else if(totalm>10 && totalm<30 && totalh==0)
                {
                 charge=50;
                }
        else if(totalm>30 && totalh<12)
                {
                 charge=80;
                }
          else if(totalm>12 && totalh<24)
                {
                 charge=120;
                }
           else
                {
               charge=150;
              }
         }
   else if(type.equals("SV"))
         {
         int totalh=exith-entryh;
         int totalm=exitm-entrym;
                  if(totalm<30 && totalh==0)
                {
                  charge=0;
                 }
         else if(totalm<30 && totalh==0)
                {
                  charge=45;
                 }
        else if(totalm>30 && totalh<=12)
                {
                 charge=60;
                }
        else if(totalh>12 && totalh<=24)
                {
                 charge=90;
                }
           else
                {
               charge=120;
              }
         }
        return charge;
   }
}
class Parking extends Carparking implements ActionListener
{
JFrame f;
JTextField t1,t2,t3,t4,t5,t6,t7;
JLabel l1,l2,l3,l4,l5,l6,l7;
JButton b1;
JTextArea a;
Parking()
{
f=new JFrame("car parking zone");
t1=new JTextField(10);
t2=new JTextField(10);
t3=new JTextField(10);
t4=new JTextField(10);
t5=new JTextField(10);
t6=new JTextField(10);
t7=new JTextField(10);
l1=new JLabel("Car id");
l2=new JLabel("Car no");
l3=new JLabel("entry time in hours");
l4=new JLabel("entry time in mins");
l5=new JLabel("exit time in hours");
l6=new JLabel("exit time in mins");
l7=new JLabel("type");
b1=new JButton("calculate");
a=new JTextArea();
f.add(l1);
f.add(t1);
f.add(l2);
f.add(t2);
f.add(l3);
f.add(t3);
f.add(l4);
f.add(t4);
f.add(l5);
f.add(t5);
f.add(l6);
f.add(t6);
f.add(l7);
f.add(t7);
f.add(b1);
f.add(a);
f.setSize(500,500);
f.setLayout(new GridLayout(8,2));
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
b1.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
int enh=Integer.parseInt(t3.getText());
int exh=Integer.parseInt(t5.getText());
int enm=Integer.parseInt(t4.getText());
int exm=Integer.parseInt(t6.getText());
int charge=calculatecharge(t7.getText(),enh,enm,exh,exm);
String charge1=String.valueOf(charge);
a.setText(charge1);
}
}
class Mainparking
{
public static void main(String args[])
{
Parking p=new Parking();
}
}