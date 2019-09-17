
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
public class Authority extends javax.swing.JFrame {

    /**
     * Creates new form Authority
     */
      Database ob = new Database();
     DefaultTableModel stors;
     DefaultTableModel deli;
    DefaultTableModel model1;
    DefaultTableModel receive;
    DefaultTableModel sparcel,rparcel;
    String OfficeName;
    String addr;
    String check;
    public Authority() {
        initComponents();
         this.setLocationRelativeTo(null);
         function();
    }
   
    
    public Authority(int c,String office,String Address){
       initComponents();
        this.setLocationRelativeTo(null);
        
        OfficeName=office;
        addr=Address;
        add.setText(Address);
        branch.setText(office+" Branch");
        function();
    }
       public Authority(String office,String Address){
       initComponents();
        this.setLocationRelativeTo(null);
        
        OfficeName=office;
        addr=Address;
        add.setText(Address);
        branch.setText(office+" Branch");
  
        function();
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
         
    void parcelss(String sendparcel,String Receiveparcel)
    {    
        String tran,name;
         String user;
       String  phone;
       String  road;
       String  house;
       String  lan;
      String  ldelivery="Delivery";
            String  parcel="Yes";
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
        searches = new javax.swing.JComboBox();
        serach1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Store = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        searchcombo5 = new javax.swing.JComboBox();
        serach5 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        delivery = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        searchcombo4 = new javax.swing.JComboBox();
        serach4 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Receive = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        par = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        branch = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Con = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        add = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Authority");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Trust Courier");

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        searches.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TransectionID", "Phone", "To", "User" }));

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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

        jButton12.setText("LogOut");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searches, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(serach1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(serach1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searches))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Store", jPanel1);

        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        searchcombo5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TransectionID", "Phone", "To", "User" }));

        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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

        jButton11.setText("LogOut");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(searchcombo5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(serach5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchcombo5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(serach5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Deleviry", jPanel2);

        jButton7.setText("Reset");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        searchcombo4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TransectionID", "SPhone", "To", "User", "RPhone" }));

        jButton8.setText("Search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        Receive.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TrucsectionID", "RPhone", "User", "Sphone", "From", "To", "Price", "Weidth", "Date", "Month", "Year", "Percel", "Status"
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

        jButton9.setText("LogOut");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(searchcombo4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(serach4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchcombo4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(serach4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Recevice", jPanel3);

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

        jButton15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton15.setText("LogOut");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 906, Short.MAX_VALUE)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        jTabbedPane1.addTab("Parcel", jPanel4);

        branch.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        branch.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton1.setText("Click");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Con.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        Con.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Load", "Unload" }));
        Con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Courier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jButton14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton14.setText("Delivery");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Con, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Con, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         
    Database ob = new Database();
     int c=searches.getSelectedIndex();
     
 
        
        if(c==0){
            System.out.print("hello");
            
            
            String stores="Select * from Storeoffice where Transe='"+serach1.getText()+"' and fcity='"+OfficeName+"'";
            Stores(stores);
        }
        
        else if(c==1){
            System.out.print("hello");
            
             
            String stores="Select * from Storeoffice where fphone='"+serach1.getText()+"' and fcity='"+OfficeName+"'";
             Stores(stores);
        }
         else if(c==2){
            System.out.print("hello");
            
             
            String stores="Select * from Storeoffice where tcity='"+serach1.getText()+"' and fcity='"+OfficeName+"'";
             Stores(stores);
        }
          else if(c==3){
            System.out.print("hello");
            
           
            String stores="Select * from Storeoffice where FUser='"+serach1.getText()+"' and fcity='"+OfficeName+"'";
             Stores(stores);
        }
      
    
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
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
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
  //Database ob = new Database();
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
            
           
            String Received="Select * from Receive where tphone='"+serach4.getText()+"' and tcity='"+OfficeName+"'";
           Receives(Received);;
          }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void ConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     int a=2;
        
        Courier1 ob1=new Courier1(a,OfficeName,addr);
       ob1.setVisible(true);
       dispose();
        
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        int cond=Con.getSelectedIndex();
        
       if(cond==0){
         int  a=1;
          Load ob=new Load(OfficeName,a); 
          ob.setVisible(true);
          dispose();
       }
       
       else{
          int a=1;
           Unload ob=new Unload(OfficeName,addr,a); 
          ob.setVisible(true);
          dispose();
       }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
     int a=2;
       Delivery  ob1=new Delivery(a,OfficeName,addr);
       ob1.setVisible(true);
       dispose();
      
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       function();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         function();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
           function();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Authority_LogIn ob1=new Authority_LogIn();
        ob1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
         Authority_LogIn ob1=new Authority_LogIn();
        ob1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         Authority_LogIn ob1=new Authority_LogIn();
        ob1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
           Authority_LogIn ob1=new Authority_LogIn();
        ob1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

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
                new Authority().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Con;
    private javax.swing.JTable Receive;
    private javax.swing.JTable Store;
    private javax.swing.JLabel add;
    private javax.swing.JLabel branch;
    private javax.swing.JTable delivery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable par;
    private javax.swing.JComboBox searchcombo4;
    private javax.swing.JComboBox searchcombo5;
    private javax.swing.JComboBox searches;
    private javax.swing.JTextField serach1;
    private javax.swing.JTextField serach4;
    private javax.swing.JTextField serach5;
    // End of variables declaration//GEN-END:variables
}
