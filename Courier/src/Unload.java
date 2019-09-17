
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class Unload extends javax.swing.JFrame {

    /**
     * Creates new form Load
     */
    
  String off;
      //String off1="Satkhira";
       // String off="Sirajgonj";  
       // String off3="Feni";
        
    String joss ="JossoreTruck";
String Satz ="SatkhiraTruck";
String Siraj ="SirajgonjTruck";
String Fen ="FeniTruck";
 Database ob = new Database();
    DefaultTableModel Courier1;
     DefaultTableModel Trucks;
    String transf =null;
    String truckId =null;
         String Phonef=null;
         String prif =null;
         String froms =null;
         String weif =null;
          String loadsf =null;
          String Hnumf =null;
          String fromf =null;
          String tof =null;
          String loadf;
      int index;  
      String trid;
      
      String   lmonth;
            String  lday;
              String  lyear;
              String addr;
    
 int check;

    public Unload() {
        initComponents();
        received();
        Trucklist();
    }
    
       public Unload(String office) {
        initComponents();
        off=office;
        bran.setText(office+" Branch");
        received();
        Trucklist();
    }
       
           public Unload(String office,String Address,int c) {
        initComponents();
        off=office;
        check=c;
        addr=Address;
        bran.setText(office+" Branch");
        received();
        Trucklist();
    }
           
           
           
     void Trucklist(){
         String trid,from,now,status; 
          String strFrom1 = "Select * from TruckLocation where location='"+off+"'"; 
            ResultSet rs =null;
         rs=ob.select(strFrom1);
         Trucks= (DefaultTableModel) truck.getModel();   
              
        Trucks.setRowCount(0);
       try {
                while (rs.next())
                {
                   
                         //record=rs1.getInt("ID");
                   System.out.print("3");
                   
                    trid=rs.getString("TruckID");
                    now=rs.getString("location");
                   
                    from=rs.getString("Fromcity");
                     status=rs.getString("position");
                    
                    Object[] objs = {trid,from,now,status};
                   Trucks.addRow(objs);
                   
                }   
                    
                    
                    
                    
                 
                
                   }
        catch (SQLException ex) {
                Logger.getLogger(Main_Office.class.getName()).log(Level.SEVERE, null, ex);
            }
         
     }      

        void received(){
        
         
        System.out.print("0");
           
      //String strFrom1 = "Select * from Storeoffice where fcity='"+off+"' and tcity<>'"+off+"'"; 
      String jossr = "Select * from JossoreTruck where tcity='"+off+"' and TruckCode='"+joss+"'";
     String sathkhi = "Select * from SatkhiraTruck where tcity='"+off+"'and TruckCode='"+Satz+"'";
    String sirajs = "Select * from SirajgonjTruck where tcity='"+off+"' and TruckCode='"+Siraj+"'";
  String fenii = "Select * from FeniTruck where tcity='"+off+"' and TruckCode='"+Fen+"'";
      //System.out.print(strFrom);
      ResultSet rsj =null; 
         ResultSet rssa =null; 
            ResultSet rssi =null;    
            ResultSet rsf =null; 
            
      
    rsj=ob.select(jossr); //jave
     rssa=ob.select(sathkhi);
   rssi=ob.select(sirajs);
     rsf=ob.select(fenii);
      
          Courier1= (DefaultTableModel) courier.getModel();   
              
        Courier1.setRowCount(0); 
        
       
        
         System.out.print("1");
         try {
                while (rsj.next())
                {
                   //record=rs1.getInt("ID");
                   System.out.print("3");
                   
                    transf=rsj.getString("transe");
                    truckId=rsj.getString("TruckCode");
                   
                    froms=rsj.getString("fcity");
                     prif=rsj.getString("Price");
                     weif=rsj.getString("Weight");
                    
                     tof=rsj.getString("tcity");
                    loadf=rsj.getString("delivery");
                    
                    
                    Object[] objs = {transf,truckId,froms,tof,prif,weif,loadf};
                   Courier1.addRow(objs);
                   
                }
                while (rssa.next())
                {
                   //record=rs1.getInt("ID");
                   System.out.print("3");
                   
                    transf=rssa.getString("transe");
                   truckId=rssa.getString("TruckCode");
                   
                    froms=rssa.getString("fcity");
                     prif=rssa.getString("Price");
                     weif=rssa.getString("Weight");
                    
                     tof=rssa.getString("tcity");
                    loadf=rssa.getString("delivery");
                    
                    
                    Object[] objs = {transf,truckId,froms,tof,prif,weif,loadf};
                   Courier1.addRow(objs);
                   
                }
                while (rssi.next())
                {
                   //record=rssi.getInt("ID");
                   System.out.print("3");
                   
                    transf=rssi.getString("transe");
                    truckId=rssi.getString("TruckCode");
                   
                    froms=rssi.getString("fcity");
                     prif=rssi.getString("Price");
                     weif=rssi.getString("Weight");
                    
                     tof=rssi.getString("tcity");
                    loadf=rssi.getString("delivery");
                    
                    
                    Object[] objs = {transf,truckId,froms,tof,prif,weif,loadf};
                   Courier1.addRow(objs);
                   
                }
                while (rsf.next())
                {
                   //record=rs1.getInt("ID");
                   System.out.print("3");
                   
                    transf=rsf.getString("transe");
                    truckId=rsf.getString("TruckCode");
                   
                    froms=rsf.getString("fcity");
                     prif=rsf.getString("Price");
                     weif=rsf.getString("Weight");
                    
                     tof=rsf.getString("tcity");
                    loadf=rsf.getString("delivery");
                    
                    
                    Object[] objs = {transf,truckId,froms,tof,prif,weif,loadf};
                   Courier1.addRow(objs);
                   
                }
              
            } catch (SQLException ex) {
                Logger.getLogger(Main_Office.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
       
       
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
    JossoreTruck
SatkhiraTruck
SirajgonjTruck
FeniTruck 
     
     
     
     */
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bran = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        mm = new javax.swing.JComboBox();
        dd = new javax.swing.JComboBox();
        yy = new javax.swing.JComboBox();
        SID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        truck = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        courier = new javax.swing.JTable();
        setcitys = new javax.swing.JComboBox();
        truckid = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Load");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Trust Courier");

        bran.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        bran.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("TruckID");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("SecretCode");

        jLabel6.setText("Receive");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Receive");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Date");

        mm.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        dd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        yy.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        yy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2019", "2020" }));

        SID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Set the time");

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        truck.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TruckID", "From", "NowTruck", "Status"
            }
        ));
        jScrollPane2.setViewportView(truck);

        jTabbedPane1.addTab("TruckList", jScrollPane2);

        courier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TransectionID", "TruckID", "From", "To", "Price", "Weight", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(courier);

        jTabbedPane1.addTab("Courier", jScrollPane3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );

        setcitys.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        setcitys.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jossore", "Satkhira", "Sirajgonj", "Feni" }));

        truckid.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        truckid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JossoreTruck", "SatkhiraTruck", "SirajgonjTruck", "FeniTruck" }));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Set From City");

        jButton3.setText("LogOut");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(setcitys, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(truckid, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SID, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yy, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(bran, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(bran, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dd)
                            .addComponent(mm)
                            .addComponent(yy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(setcitys, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(truckid, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(7, 7, 7)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String  city =setcitys.getSelectedItem().toString();
         trid=truckid.getSelectedItem().toString();
         String Scode=SID.getText();
         int check=truckid.getSelectedIndex();
         
         
         
      
       try {         
        
         if(check==0){
          
         
           String str = "Select * from JossoreTruck where  fcity='"+city+"' and tcity='"+off+"' and SIcode='"+Scode+"'";
           
           ResultSet  rs =null; 
            rs=ob.select(str);
           if (rs.next()){
           
              setup(str);
           
            String remove = "delete from JossoreTruck where fcity='"+city+"' and tcity='"+off+"' and SIcode='"+Scode+"'";
          
            
           ob.delete(remove);
           
           
           received();
           }
           else{
            
           JOptionPane.showMessageDialog(null,"Wrong Transection","Error",JOptionPane.ERROR_MESSAGE); 
        }
           
           }
          
        
         
          else if(check==1){
           
           String str = "Select * from SatkhiraTruck where  fcity='"+city+"' and tcity='"+off+"' and SIcode='"+Scode+"'"; 
          
           ResultSet  rs =null; 
            rs=ob.select(str);
           if (rs.next()){
          
               setup(str);
          
           String remove = "delete from SatkhiraTruck where fcity='"+city+"' and tcity='"+off+"' and SIcode='"+Scode+"'";
         
           ob.delete(remove); 
           received();
         }
             else{
            
           JOptionPane.showMessageDialog(null,"Wrong Transection","Error",JOptionPane.ERROR_MESSAGE); 
        }
          }
          
           else if(check==2){
             String str  = "Select * from SirajgonjTruck where  fcity='"+city+"' and tcity='"+off+"' and SIcode='"+Scode+"'";
           ResultSet  rs =null; 
            rs=ob.select(str);
           if (rs.next()){
               
              setup(str);
               String remove = "delete from SirajgonjTruck where fcity='"+city+"' and tcity='"+off+"' and SIcode='"+Scode+"'";
      
             
            ob.delete(remove); 
            received();
         }
          else{
            
           JOptionPane.showMessageDialog(null,"Wrong Transection","Error",JOptionPane.ERROR_MESSAGE); 
        } 
           }
         
           else if(check==3){
             
              String str  = "Select * from FeniTruck where  fcity='"+city+"' and tcity='"+off+"' and SIcode='"+Scode+"'";
              ResultSet  rs =null; 
            rs=ob.select(str);
           if (rs.next()){
              
               setup(str);
               String remove = "delete from FeniTruck  where fcity='"+city+"' and tcity='"+off+"' and SIcode='"+Scode+"'";
           
              
             
              ob.delete(remove);
         
         received();
           }
            else{
            
           JOptionPane.showMessageDialog(null,"Wrong Transections","Error",JOptionPane.ERROR_MESSAGE); 
        } 
           
                }
         
           else{
             JOptionPane.showMessageDialog(null,"You are Courier is Successfull Unloaded \n"+"Thank You","Success",JOptionPane.INFORMATION_MESSAGE);  
          
           }
         
            
    }
        
         catch (SQLException ex) {
                Logger.getLogger(Main_Office.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  if(check==0){
        Main_Office ob1=new Main_Office(off);
       ob1.setVisible(true);
       dispose();
        }
        else{
            
           Authority ob1=new Authority(off,addr);
       ob1.setVisible(true);
       dispose(); 
        }          
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          LogIn ob1=new LogIn();
        ob1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    void setup(String strFrom){
        
           
             String tru;
       String dis;
       
        String tid;
       String Citys;
       String truc;
     
      String lfname;
         String     lfuser;
            String  lfphone;
           String    lfcity;
           String    ltname;
           String    ltphone;
           String    ltcity;
           String       ltranse;
          String   ltoParcel;
          String   lmonth=mm.getSelectedItem().toString();
            String  lday=dd.getSelectedItem().toString();
              String  lyear=yy.getSelectedItem().toString();
           String  lweight;
          String   lprice;
           String    ldelivery;
           String   ltrucode;
           String   ltroad;
            String  lthnum;
           String   ltlan; 
            String  truckid;
           String   scode; 
    
     System.out.print("3");
      try {
      
        
          
      
     // System.out.print(Citys);
            
            
          // String strFrom = "Select * from Storeoffice where fcity='"+off+"' and tcity<>'"+off+"' and transe='"+tranid.getText()+"'";
        System.out.print(strFrom);
        ResultSet  rs =null; 
        rs=ob.select(strFrom);
        System.out.print(rs);
          ldelivery="UnLoaded";
                   String pos="UnLoaded";
         while (rs.next())
                {
                lfname=rs.getString("FName");
                System.out.print( lfname);
                lfuser=rs.getString("Fuser");
                lfphone=rs.getString("fphone");
                lfcity=rs.getString("fcity");
               ltname=rs.getString("tname");
                ltphone=rs.getString("tphone");
               ltcity=rs.getString("tcity");
                ltranse=rs.getString("transe");
                ltoParcel=rs.getString("toParcel");
                //lday=rs.getString("day");
                // lmonth=rs.getString("month");
                // lyear=rs.getString("year");
                   lweight=rs.getString("weight"); 
                   lprice=rs.getString("price");
                  
                   // ltrucode=rs.getString("");
                   ltroad=rs.getString("troad");
                  lthnum=rs.getString("thnum");
                  ltlan=rs.getString("tlan");
                 truckid=rs.getString("TruckCode");
                  scode =rs.getString("SICode");
               String sql = "insert into Receive (FName,Fuser,fphone,fcity,tname,tphone,troad,thnum,tlan,tcity,transe,toParcel,day,month,year,weight,price,delivery,TruckCode,SiCode) values('"+lfname+"','"+lfuser+"','"+lfphone+"','"+lfcity+"','"+ltname+"','"+ltphone+"','"+ ltroad+"','"+lthnum+"','"+ ltlan+"','"+ltcity+"','"+ltranse+"','"+ltoParcel+"','"+lday+"','"+lmonth+"','"+lyear+"','"+lweight+"','"+lprice+"','"+ldelivery+"','"+truckid+"','"+scode+"')";             
                 ob.insert(sql) ;
                 
               String sql1= "UPDATE Deli SET delivery = '"+ldelivery+"' where fcity='"+lfcity+"' and tcity='"+ltcity+"' and SIcode='"+scode+"'";
         ob.update(sql1);
         
          //String trucks= "UPDATE Truck SET position = '"+ldelivery+"' where Fromcity='"+lfcity+"' and location='"+ltcity+"' and secretID='"+scode+"'";
        // ob.update(trucks);
               
                }
         String trucks= "UPDATE TruckLocation SET position = '"+ldelivery+"' where location='"+off+"'"; //and location='"+ltcity+"' and secretID='"+scode+"'";
        ob.update(trucks);
         
        
        
        
      }
         catch (SQLException ex) {
                Logger.getLogger(Main_Office.class.getName()).log(Level.SEVERE, null, ex);
            }
        
         
         
    }
           
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(Load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Unload().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SID;
    private javax.swing.JLabel bran;
    private javax.swing.JTable courier;
    private javax.swing.JComboBox dd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox mm;
    private javax.swing.JComboBox setcitys;
    private javax.swing.JTable truck;
    private javax.swing.JComboBox truckid;
    private javax.swing.JComboBox yy;
    // End of variables declaration//GEN-END:variables
}
