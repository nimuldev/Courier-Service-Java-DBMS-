
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class Main_Office extends javax.swing.JFrame {

    /**
     * Creates new form Authority
     */
    
     Database ob = new Database();
     String OfficeName;
      String addr="Jossore";
     String str1 = "Select * from create";
    DefaultTableModel model1;
     
    DefaultTableModel stors;
     DefaultTableModel deli;
    DefaultTableModel model;
    DefaultTableModel receive;
    DefaultTableModel sparcel,rparcel,transec;
    DefaultTableModel fenie,jo,sa,si;
    public Main_Office() {
        initComponents();
        this.setLocationRelativeTo(null);
          Start();
         
   function();
    }
    
     public Main_Office(String office) {
        
        
         initComponents();
         
        this.setLocationRelativeTo(null);
       OfficeName=office;
           function();
        Start();
     
    }
     
  void function(){
    String stores = "Select * from Storeoffice where fcity='"+OfficeName+"'";   
       
    Stores(stores);
   String deliverys = "Select * from Deli where fcity='"+OfficeName+"'"; 
    
    delivery(deliverys);
      String Received = "Select * from Receive where tcity='"+OfficeName+"'"; 
    
    Receives(Received);
    String  ldelivery="Delivery";
            String  parcel="Yes";
     String  sendparcel= "Select * from StoreDB where tcity='"+OfficeName+"'";  
   String  Receiveparcel= "Select * from Receive where tcity='"+OfficeName+"' and delivery<>'"+ldelivery+"' and  toParcel='"+parcel+"'";
   
     parcelss(sendparcel,Receiveparcel);
    
    String  tran= "Select tranc from feild";
     reansections(tran);
   
     String  fenii= "Select * from FeniTruck"; 
     
     String  joss= "Select * from JossoreTruck";
     
     String  siraj= "Select * from SirajgonjTruck";
     
     String  sathkir= "Select * from SatkhiraTruck";
     truckss(fenii,joss,siraj,sathkir);
  }
  
      void truckss(String  fenii,String  joss,String  siraj,String  sathkir) {
          
    String tran,status;
        String aname ;//= null;
         String user; //= null;
        String phone,from,to;
      
        fenie= (DefaultTableModel) feniii.getModel();   
         fenie.setRowCount(0); 
        
         si= (DefaultTableModel) sirajj.getModel();   
         si.setRowCount(0); 
         
         jo= (DefaultTableModel) jossr.getModel();   
         jo.setRowCount(0);
         
         sa= (DefaultTableModel) saths.getModel();   
         sa.setRowCount(0);
         
        ResultSet rs1 =null;            
        rs1=ob.select(fenii);    
        
        ResultSet rs2 =null;            
        rs2=ob.select(joss);  
        
        ResultSet rs3 =null;            
        rs3=ob.select(siraj);  
        
        ResultSet rs4 =null;            
        rs4=ob.select(sathkir);  
    try {
        while (rs1.next())
                {
                    tran=rs1.getString("transe");
                    aname=rs1.getString("FName");
                    user=rs1.getString("FUser");
                    phone=rs1.getString("fphone");
                    // user=rs1.getString("email");
                     from=rs1.getString("fcity");
                    to=rs1.getString("tcity");
                    status=rs1.getString("delivery");
              
                Object[] objs = {tran,aname,phone,user,from,to,status};
                    fenie.addRow(objs);
                }
              
        while (rs2.next())
                {
                    tran=rs2.getString("transe");
                    aname=rs2.getString("FName");
                    user=rs2.getString("FUser");
                    phone=rs2.getString("fphone");
                    // user=rs1.getString("email");
                     from=rs2.getString("fcity");
                    to=rs2.getString("tcity");
                    status=rs2.getString("delivery");
              
                Object[] objs = {tran,aname,phone,user,from,to,status};
                    jo.addRow(objs);
                }
        while (rs3.next())
                {
                    tran=rs3.getString("transe");
                    aname=rs3.getString("FName");
                    user=rs3.getString("FUser");
                    phone=rs3.getString("fphone");
                    // user=rs1.getString("email");
                     from=rs3.getString("fcity");
                    to=rs3.getString("tcity");
                    status=rs3.getString("delivery");
              
                Object[] objs = {tran,aname,phone,user,from,to,status};
                    si.addRow(objs);
                }
        while (rs4.next())
                {
                    tran=rs4.getString("transe");
                    aname=rs4.getString("FName");
                    user=rs4.getString("FUser");
                    phone=rs4.getString("fphone");
                    // user=rs1.getString("email");
                     from=rs4.getString("fcity");
                    to=rs4.getString("tcity");
                    status=rs4.getString("delivery");
              
                Object[] objs = {tran,aname,phone,user,from,to,status};
                    sa.addRow(objs);
                }
    }
      catch (SQLException ex) {
                Logger.getLogger(Main_Office.class.getName()).log(Level.SEVERE, null, ex);
            
      }
}
  
  
  
  
  
  void reansections(String  tran){
         String record,record1;
        String aname ;//= null;
         String user; //= null;
        String phone;//= null;
        
        String from; //= null;
        String to; //= null;
        String price ;//= null;
       //= null;
       String service ;
        String status, weidth ;//= null;
       
      
      transec= (DefaultTableModel) transection.getModel();   
              
        transec.setRowCount(0);    
      
      
          ResultSet rs1 =null;            
        rs1=ob.select(tran);        
  
         try {
                while (rs1.next())
                {
                    
             record=rs1.getString("tranc");
               //System.out.print(record+"\n"); 
                   
            String  transtore= "Select * from StoreDB where transe='"+record+"'";
            String  transtoreoff= "Select * from Storeoffice where transe='"+record+"'";
            String  transdeli= "Select * from Deli where transe='"+record+"'";
            ResultSet rsst =null;            
               rsst=ob.select(transtore);
               //System.out.print(rsst);
               ResultSet rsstof =null;            
              rsstof=ob.select(transtoreoff);
              //System.out.print(rsstof);
                ResultSet rsdi =null;            
               rsdi=ob.select(transdeli);
               // System.out.print(rsdi);
               
                 if (rsst.next())
                {
                     record1=rsst.getString("transe");
                    aname=rsst.getString("FName");
                    user=rsst.getString("FUser");
                    phone=rsst.getString("fphone");
                    // user=rs1.getString("email");
                     from=rsst.getString("fcity");
                    to=rsst.getString("tcity");
                    price=rsst.getString("price");
                     weidth=rsst.getString("Weight");
                    service=rsst.getString("toParcel");  
                   status="";
                    
                    System.out.print("1");
                    
                    Object[] objs = {record1,phone,user,from,to,price,weidth,service,status};
                    transec.addRow(objs);
                }
              //System.out.print("1");
                
                 else if (rsstof.next())
                {
                     record1=rsstof.getString("transe");
                    aname=rsstof.getString("FName");
                    user=rsstof.getString("FUser");
                    phone=rsstof.getString("fphone");
                    // user=rs1.getString("email");
                     from=rsstof.getString("fcity");
                    to=rsstof.getString("tcity");
                    price=rsstof.getString("price");
                     weidth=rsstof.getString("Weight");
                    service=rsstof.getString("toParcel");  
                   status=rsstof.getString("delivery");  
                    
                    System.out.print("2");
                    
                    Object[] objs = {record1,phone,user,from,to,price,weidth,service,status};
                    transec.addRow(objs);
                }
               else if (rsdi.next())
                {
                     record1=rsdi.getString("transe");
                    aname=rsdi.getString("FName");
                    user=rsdi.getString("FUser");
                    phone=rsdi.getString("fphone");
                    // user=rs1.getString("email");
                     from=rsdi.getString("fcity");
                    to=rsdi.getString("tcity");
                    price=rsdi.getString("price");
                     weidth=rsdi.getString("Weight");
                    service=rsdi.getString("toParcel");  
                   status=rsdi.getString("delivery");  
                    
                    System.out.print("3");
                    
                    Object[] objs = {record1,phone,user,from,to,price,weidth,service,status};
                    transec.addRow(objs);
                }
               

           //record
                   /* aname=rs1.getString("name");
                    auser=rs1.getString("cuser");
                    aphone=rs1.getString("phone");
                     aemail=rs1.getString("email");
                     aday=rs1.getString("date");
                    amonth=rs1.getString("month");
                    ayear=rs1.getString("year");
                    
                    
                   xnid=rs1.getInt("NID");
                   anid=String.valueOf(xnid);
                    agender=rs1.getString("gender");
                    acity=rs1.getString("city");
                    
                    
                    Object[] objs = {record,aname,aphone,auser,aemail,agender,acity,anid,aday,amonth,ayear};
                    model1.addRow(objs);
                   */
                   
                   
                   
                   
                }
         }
             catch (SQLException ex) {
                Logger.getLogger(Main_Office.class.getName()).log(Level.SEVERE, null, ex);
            }
  
         
  
  }
  
  
  
  
  
     
    public void Start(){
         
         //account
        ResultSet rs1 =null;            
        rs1=ob.select(str1);
        
           int record;
        String aname ;//= null;
         String auser; //= null;
        String aphone;//= null;
        
        String aemail; //= null;
        String agender; //= null;
        String acity ;//= null;
       int xnid ;//= null;
       String anid ;
        String aday ;//= null;
        String amonth ;//= null;
        String ayear ;//= null;
        
       
       
        model1= (DefaultTableModel) account.getModel();   
              
        model1.setRowCount(0);    
        
        
        try {
                while (rs1.next())
                {
                   record=rs1.getInt("ID");
                  //record
                    aname=rs1.getString("name");
                    auser=rs1.getString("cuser");
                    aphone=rs1.getString("phone");
                     aemail=rs1.getString("email");
                     aday=rs1.getString("date");
                    amonth=rs1.getString("month");
                    ayear=rs1.getString("year");
                    
                    
                   xnid=rs1.getInt("NID");
                   anid=String.valueOf(xnid);
                    agender=rs1.getString("gender");
                    acity=rs1.getString("city");
                    
                    
                    Object[] objs = {record,aname,aphone,auser,aemail,agender,acity,anid,aday,amonth,ayear};
                    model1.addRow(objs);
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(Main_Office.class.getName()).log(Level.SEVERE, null, ex);
            }
        
      
     }
    
    public void Search(String sea){
         ResultSet rs1 =null;
        
        
        rs1=ob.select(sea);
        
           int record;
        String aname ;//= null;
         String auser; //= null;
        String aphone;//= null;
        
        String aemail; //= null;
        String agender; //= null;
        String acity ;//= null;
       int xnid ;//= null;
       String anid ;
        String aday ;//= null;
        String amonth ;//= null;
        String ayear ;//= null;
        
       
       
        model1= (DefaultTableModel) account.getModel();   
              
        model1.setRowCount(0);    
        
        
        try {
                while (rs1.next())
                {
                   record=rs1.getInt("ID");
                  //record
                    aname=rs1.getString("name");
                    auser=rs1.getString("cuser");
                    aphone=rs1.getString("phone");
                     aemail=rs1.getString("email");
                     aday=rs1.getString("date");
                    amonth=rs1.getString("month");
                    ayear=rs1.getString("year");
                    
                    
                   xnid=rs1.getInt("NID");
                   anid=String.valueOf(xnid);
                    agender=rs1.getString("gender");
                    acity=rs1.getString("city");
                    
                    
                    Object[] objs = {record,aname,aphone,auser,aemail,agender,acity,anid,aday,amonth,ayear};
                    model1.addRow(objs);
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(Main_Office.class.getName()).log(Level.SEVERE, null, ex);
            }      
    }
    
    void Stores(String stores)
    {    
        String tran;
         String user;
       
       
       
       
       String  frophone;
       String  froprice;
       String  frowight;
       //String  frolan;
       String frocity;
       
       String TOcity;
        String parcel;
      
        
        String day;
        String month;
        String year;
        
    
        
    ResultSet rs =null;
    rs=ob.select(stores);
      
        //stors
        
         stors= (DefaultTableModel) Store.getModel();   
              
        stors.setRowCount(0);  
        
        try {
                while (rs.next())
                {
                   //record=rs1.getInt("ID");
                   System.out.print("3");
                   
                    tran=rs.getString("transe");
                   
                    frophone=rs.getString("fphone");
                     user=rs.getString("FUser");
                     froprice=rs.getString("Price");
                    
                     frowight=rs.getString("Weight");
                    frocity=rs.getString("fcity");
                    TOcity=rs.getString("tcity");
                    parcel=rs.getString("toParcel");
                    day=rs.getString("day");
                    month=rs.getString("month");
                    year=rs.getString("year");
                    System.out.print("2");
                    
                    Object[] objs = {tran,frophone,user,frocity,TOcity,froprice,frowight,parcel,day,month,year};
                     stors.addRow(objs);
                   
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(Main_Office.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
      void delivery(String deliverys)
    {    
        String tran;
         String user;
       
       
       
       
       String  frophone;
       String  froprice;
       String  frowight;
      String  status;
       String frocity;
       
       String TOcity;
        String parcel;
      
        
        String day;
        String month;
        String year;
        
    
        
    ResultSet rs =null;
    rs=ob.select(deliverys);
      
        //stors
        
         deli= (DefaultTableModel) delivery.getModel();   
              
        deli.setRowCount(0);  
        
      try {
                while (rs.next())
                {
                   //record=rs1.getInt("ID");
                   System.out.print("3");
                   
                    tran=rs.getString("transe");
                   
                    frophone=rs.getString("fphone");
                     user=rs.getString("FUser");
                     froprice=rs.getString("Price");
                    
                     frowight=rs.getString("Weight");
                    frocity=rs.getString("fcity");
                    TOcity=rs.getString("tcity");
                    parcel=rs.getString("toParcel");
                    day=rs.getString("day");
                    month=rs.getString("month");
                    year=rs.getString("year");
                    status=rs.getString("delivery");
                    System.out.print("2");
                    
                     Object[] objs = {tran,frophone,user,frocity,TOcity,froprice,frowight,day,month,year,parcel,status};
                     deli.addRow(objs);
                   
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(Main_Office.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }
         void Receives(String Received)
    {    
        String tran;
         String user;
       
       
       
       
       String  frophone;
       String  froprice;
       String  frowight;
      String  status;
       String frocity;
       
       String TOcity;
        String parcel;
      
        
        String day;
        String month;
        String year,tophone;
        
 
        
    ResultSet rs =null;
    rs=ob.select(Received);
      
        //stors
        
         receive= (DefaultTableModel) Receive.getModel();   
              
        receive.setRowCount(0);  
        
      try {
                while (rs.next())
                {
                   //record=rs1.getInt("ID");
                   System.out.print("3");
                   
                    tran=rs.getString("transe");
                   
                    frophone=rs.getString("fphone");
                    tophone=rs.getString("tphone");
                     user=rs.getString("FUser");
                     froprice=rs.getString("Price");
                    
                     frowight=rs.getString("Weight");
                    frocity=rs.getString("fcity");
                    TOcity=rs.getString("tcity");
                    parcel=rs.getString("toParcel");
                    day=rs.getString("day");
                    month=rs.getString("month");
                    year=rs.getString("year");
                    status=rs.getString("delivery");
                    System.out.print("2");
                    
                     Object[] objs = {tran,tophone,user,frophone,frocity,TOcity,frowight,froprice,day,month,year,parcel,status};
                     receive.addRow(objs);
                   
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(Main_Office.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }
         
    void parcelss(String  sendparcel,String  Receiveparcel)
    {    
        String tran,name;
         String user;
       String  phone;
       String  road;
       String  house;
       String  lan;
    
       String  froprice;
       String  frowight;
      String  take;
      String  provide;
       String frocity;
       
       String TOcity;
       
        
        String day;
        String month;
        String year;
        
  
        
    ResultSet rs1 =null;
    rs1=ob.select(sendparcel);
    
         
    ResultSet rs =null;
    rs=ob.select(Receiveparcel);
      
        //stors
        
         rparcel= (DefaultTableModel) par.getModel();   
              
         rparcel.setRowCount(0);  
         
          sparcel= (DefaultTableModel) par.getModel();   
              
         sparcel.setRowCount(0);
        
      try {
                while (rs1.next())
                {
                   //record=rs1.getInt("ID");
                   System.out.print("3");
                   
                    tran=rs1.getString("transe");
                   name=rs1.getString("FName");
                    phone=rs1.getString("fphone");
                  
                     user=rs1.getString("FUser");
                      frocity=rs1.getString("fcity");
                   
                      
                      TOcity=rs1.getString("tcity");
                    
                        road=rs1.getString("froad");
                    house=rs1.getString("fhnum");
                    lan=rs1.getString("flan");
                      take="Yes";
                    
                     provide="NO";
                   
                    
                    
                   
                    
                     Object[] objs = {tran,name,phone,user,frocity,TOcity,road,house,lan,take,provide};
                     sparcel.addRow(objs);
                   
                }
               while (rs.next())
                {
                   //record=rs1.getInt("ID");
                   System.out.print("3");
                   
                    tran=rs.getString("transe");
                   name=rs.getString("tname");
                    phone=rs.getString("tphone");
                  
                     user=rs.getString("FUser");
                      frocity=rs.getString("fcity");
                   
                      
                      TOcity=rs.getString("tcity");
                    
                        road=rs.getString("troad");
                    house=rs.getString("thnum");
                    lan=rs.getString("tlan");
                      take="NO";
                    
                     provide="Yes";
                   
                    day=rs.getString("tlan");
                    month=rs.getString("tlan");
                    year=rs.getString("tlan");
                   
                    
                     Object[] objs = {tran,name,phone,user,frocity,TOcity,road,house,lan,take,provide,day,month,year};
                     rparcel.addRow(objs); 
                   
                } 
                
               
            } catch (SQLException ex) {
                Logger.getLogger(Main_Office.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        searchcombo = new javax.swing.JComboBox();
        serach = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Store = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        searchcombo5 = new javax.swing.JComboBox();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        serach5 = new javax.swing.JTextField();
        jButton28 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        delivery = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        searchcombo4 = new javax.swing.JComboBox();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        serach4 = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Receive = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jossr = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        saths = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        sirajj = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        feniii = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        account = new javax.swing.JTable();
        searchcombo1 = new javax.swing.JComboBox();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        serach1 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        transection = new javax.swing.JTable();
        searchcombo2 = new javax.swing.JComboBox();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        serach2 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        par = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Con = new javax.swing.JComboBox();
        jButton8 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Delivery = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Authority");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Courier");

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton14.setText("Reset");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton15.setText("LogOut");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        searchcombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        searchcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TransectionID", "Phone", "To", "User" }));

        serach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        Store.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TrucsectionID", "Phone", "User", "From", "To", "Price", "Width", "Percel", "Day", "Month", "Year"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Store);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(serach, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 577, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchcombo)
                    .addComponent(serach))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Store", jPanel1);

        searchcombo5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TransectionID", "Phone", "To", "User" }));

        jButton26.setText("LogOut");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setText("Reset");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setText("Search");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        delivery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TrancsectionID", "Phone", "User", "From", "To", "Price", "Width", "Day", "Month", "Year", "Percel", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(delivery);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchcombo5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(serach5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 577, Short.MAX_VALUE)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchcombo5)
                    .addComponent(serach5))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Deleviry", jPanel2);

        searchcombo4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TransectionID", "SPhone", "From", "User", "RPhone" }));

        jButton23.setText("LogOut");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setText("Reset");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText("Search");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        Receive.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TrucsectionID", "RPhone", "User", "Sphone", "From", "To", "Price", "Weidth", "Date", "Month", "Year", "Percel", "Satus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(Receive);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchcombo4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serach4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 573, Short.MAX_VALUE)
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serach4)
                    .addComponent(searchcombo4))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Recevice", jPanel3);

        jTabbedPane2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jossr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TrunsectionID", "Name", "Phone", "User", "From", "To", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane17.setViewportView(jossr);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 1217, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Jossor113", jPanel5);

        saths.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TrunsectionID", "Name", "Phone", "User", "From", "To", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane16.setViewportView(saths);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 1217, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Sathkira331", jPanel6);

        sirajj.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TrunsectionID", "Name", "Phone", "User", "From", "To", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane15.setViewportView(sirajj);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 1217, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Sirajgonj551", jPanel7);

        feniii.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TrunsectionID", "Name", "Phone", "User", "From", "To", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane13.setViewportView(feniii);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 1217, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Feni991", jPanel9);

        jButton20.setText("LogOut");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("Reset");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Truck", jPanel4);

        account.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        account.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        account.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial", "Name", "Phone", "User", "Email", "Gender", "City", "NID", "Day", "Month", "Year"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane8.setViewportView(account);

        searchcombo1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        searchcombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Phone", "Name", "User", "Email", "NID" }));

        jButton16.setText("LogOut");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Reset");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton9.setText("Search");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchcombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(serach1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchcombo1)
                    .addComponent(serach1))
                .addGap(4, 4, 4))
        );

        jTabbedPane1.addTab("Account", jPanel10);

        transection.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TrucsectionID", "Phone", "User", "From", "To", "Price", "Width", "Service", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane14.setViewportView(transection);
        if (transection.getColumnModel().getColumnCount() > 0) {
            transection.getColumnModel().getColumn(7).setResizable(false);
        }

        searchcombo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TransectionID", "Phone", "To", "From", "User" }));

        jButton18.setText("LogOut");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Reset");

        jButton12.setText("Search");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchcombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(serach2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchcombo2)
                    .addComponent(serach2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Treansection", jPanel11);

        par.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tra", "Name", "Phone", "User", "From", "To", "RoadName", "HouseNumber", "Lan", "Takas", "Provide", "Day", "month", "Year"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(par);

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("LogOut");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 1112, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Parcel", jPanel12);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Head Office Jossor Branch");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Click");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Con.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Con.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Load", "Unload" }));

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("Courier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Delivery.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Delivery.setText("Delivery");
        Delivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeliveryActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Jossor,Sonkorpur,623/A");

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton5.setText("Feild");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Con, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Delivery, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Con, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Delivery, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       Database ob = new Database();
     int c=searchcombo1.getSelectedIndex();
     
     
        
        if(c==0){
            System.out.print("hello");
            
            
            String Sea="Select * from create where phone='"+serach1.getText()+"'";
            Search(Sea);
        }
        
        else if(c==1){
            System.out.print("hello");
            
             
            String Sea="Select * from create where Name='"+serach1.getText()+"'";
            Search(Sea);
        }
         else if(c==2){
            System.out.print("hello");
            
             
            String Sea="Select * from create where cUser='"+serach1.getText()+"'";
            Search(Sea);
        }
          else if(c==3){
            System.out.print("hello");
            
           
            String Sea="Select * from create where Email='"+serach1.getText()+"'";
            Search(Sea);
        }
         else if(c==4){
            System.out.print("hello");
            
           
            String Sea="Select * from create where NID='"+serach1.getText()+"'";
            Search(Sea);
        }
        
        
         
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
       new Authority_LogIn().setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
      Start();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
         new Authority_LogIn().setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
         new Authority_LogIn().setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        new Authority_LogIn().setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
          new Authority_LogIn().setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
       
        new Authority_LogIn().setVisible(true);
       dispose();
       
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int a=1;
        
         Courier1 ob1=new Courier1(a,OfficeName,addr);
       ob1.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Database ob = new Database();
     int c=searchcombo.getSelectedIndex();
     
 
        
        if(c==0){
            System.out.print("hello");
            
            
            String stores="Select * from Storeoffice where Transe='"+serach.getText()+"' and fcity='"+OfficeName+"'";
            Stores(stores);
        }
        
        else if(c==1){
            System.out.print("hello");
            
             
            String stores="Select * from Storeoffice where fphone='"+serach.getText()+"' and fcity='"+OfficeName+"'";
             Stores(stores);
        }
         else if(c==2){
            System.out.print("hello");
            
             
            String stores="Select * from Storeoffice where tcity='"+serach.getText()+"' and fcity='"+OfficeName+"'";
             Stores(stores);
        }
          else if(c==3){
            System.out.print("hello");
            
           
            String stores="Select * from Storeoffice where FUser='"+serach.getText()+"' and fcity='"+OfficeName+"'";
             Stores(stores);
        }
      
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         int cond=Con.getSelectedIndex();
        
       if(cond==0){
           int c=0;
          Load ob=new Load(OfficeName,c); 
          ob.setVisible(true);
          dispose();
       }
        else{
        
           Unload ob=new Unload(OfficeName); 
          ob.setVisible(true);
          dispose();
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeliveryActionPerformed

         int a=1;
       Delivery  ob1=new Delivery(a,OfficeName,addr);
       ob1.setVisible(true);
       dispose();
        
    }//GEN-LAST:event_DeliveryActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
         function();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        Database ob = new Database();
     int c=searchcombo5.getSelectedIndex();
     
 
        
        if(c==0){
            System.out.print("hello");
            
            
            String deliverys="Select * from Deli where Transe='"+serach5.getText()+"' and fcity='"+OfficeName+"'";
            delivery(deliverys);
        }
        
        else if(c==1){
            System.out.print("hello");
            
             
            String deliverys="Select * from Deli where fphone='"+serach5.getText()+"' and fcity='"+OfficeName+"'";
            delivery(deliverys);
        }
         else if(c==2){
            System.out.print("hello");
            
             
            String deliverys="Select * from Deli where tcity='"+serach5.getText()+"' and fcity='"+OfficeName+"'";
             delivery(deliverys);
        }
          else if(c==3){
            System.out.print("hello");
            
           
            String deliverys="Select * from Deli where FUser='"+serach5.getText()+"' and fcity='"+OfficeName+"'";
             delivery(deliverys);
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        function();
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Authority_LogIn ob1=new Authority_LogIn();
        ob1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
       Database ob = new Database();
     int c=searchcombo4.getSelectedIndex();
     
 
        
        if(c==0){
            System.out.print("hello");
            
            
            String Received="Select * from Receive where Transe='"+serach4.getText()+"' and tcity='"+OfficeName+"'";
             Receives(Received);
        }
        
        else if(c==1){
            System.out.print("hello");
            
             
            String Received="Select * from Receive where fphone='"+serach4.getText()+"' and tcity='"+OfficeName+"'";
            Receives(Received);
        }
         else if(c==2){
            System.out.print("hello");
            
             
            String Received="Select * from Receive where fcity='"+serach4.getText()+"' and tcity='"+OfficeName+"'";
            Receives(Received);
        }
          else if(c==3){
            System.out.print("hello");
            
           
            String Received="Select * from Receive where FUser='"+serach4.getText()+"' and tcity='"+OfficeName+"'";
           Receives(Received);;
          }
           else if(c==4){
            System.out.print("hello");
            
             
            String Received="Select * from Receive where fphone='"+serach4.getText()+"' and tcity='"+OfficeName+"'";
            Receives(Received);
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        function();
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         Feild ob1=new Feild(OfficeName);
       ob1.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
      Delete ob=new Delete(OfficeName);
      ob.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(Authority.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Authority.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Authority.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authority.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Office().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Con;
    private javax.swing.JButton Delivery;
    private javax.swing.JTable Receive;
    private javax.swing.JTable Store;
    private javax.swing.JTable account;
    private javax.swing.JTable delivery;
    private javax.swing.JTable feniii;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jossr;
    private javax.swing.JTable par;
    private javax.swing.JTable saths;
    private javax.swing.JComboBox searchcombo;
    private javax.swing.JComboBox searchcombo1;
    private javax.swing.JComboBox searchcombo2;
    private javax.swing.JComboBox searchcombo4;
    private javax.swing.JComboBox searchcombo5;
    private javax.swing.JTextField serach;
    private javax.swing.JTextField serach1;
    private javax.swing.JTextField serach2;
    private javax.swing.JTextField serach4;
    private javax.swing.JTextField serach5;
    private javax.swing.JTable sirajj;
    private javax.swing.JTable transection;
    // End of variables declaration//GEN-END:variables
}
