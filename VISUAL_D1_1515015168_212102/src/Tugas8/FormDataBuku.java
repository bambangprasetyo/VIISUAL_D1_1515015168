package Tugas8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JhonTralala
 */

import Tugas7.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FormDataBuku extends javax.swing.JFrame {

String judul,penulis,harga;
DefaultTableModel tabMode;
    
public boolean UbahData(String id, String judul, String penulis, String harga){
    try{
        String sql = "UPDATE buku set judul ='"+judul+"', penulis='"+penulis+"', harga="+harga+ "WHERE id="+id+";";
        stt = con.createStatement();
        stt.executeUpdate(sql);
        return true;}
    catch(SQLException a){
        System.out.println(a.getMessage());
        return false;
    
    }
}

public boolean Hapusdata(String id){
    try{
        String sql = "DELETE FROM buku WHERE id="+id+";";
        stt = con.createStatement();
        stt.executeUpdate(sql);
        return true;
    }
    catch(SQLException a){
        System.out.println(a.getMessage());
        return false;
    }
}

private void PencarianData(String by, String cari){
    try{
        String sql = "SELECT * FROM buku where "+by+"LIKE'%"+cari+"%';";
        stt = con.createStatement();
        rss = stt.executeQuery(sql);
        while(rss.next()){
            Object[] data = new Object[4];
            data[0] = rss.getString("id");
            data[1] = rss.getString("judul");
            data[2] = rss.getString("penulis");
            data[3] = rss.getInt("harga");
            model.addRow(data);
        }
    }catch(Exception a){
        System.out.println(a.getMessage());
        
    }
}


private void TampilData(){
        try{
            String sql = "Select * FROM buku";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            //rss = stt.executeUpdate(sql);
            while(rss.next()){   
            Object[] a = new Object [4];
            a[0] = rss.getString("id");
            a[1] = rss.getString("Judul");
            a[2] = rss.getString("Penulis");
            a[3] = rss.getString("Harga");
            model.addRow(a);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
    }
    }
    private void TambahData(String judul, String penulis, String harga){
        try{
            String sql = "INSERT INTO buku VALUES (NULL,'"+judul+"','"+penulis+"',"+harga+")";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            model.addRow(new Object[]{judul,penulis,harga});
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
        }
    }
    private void search(String sql){
        String header[] = {"JUDUL","PENULIS","HARGA"};
        DefaultTableModel a = new DefaultTableModel(null, header);
        jTable1.setModel(a);
        for (int i=0;i<jTable1.getRowCount();i++){
            a.removeRow(i);
        }
        try{
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while (rss.next()){
                String judul = rss.getString(1);
                String penulis = rss.getString(2);
                String harga = rss.getString(3);
                Object baris[] = {judul, penulis, harga};
                a.addRow(baris);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
        public void hapustabel(){
        int row=model.getRowCount();
        for(int i=0;i<row;i++){
            model.removeRow(0);
        }
    }
    public void tampildataketabel(){
        hapustabel();
        try{
            String sql="Select * from buku ORDER BY judul DESC";
            Statement stat=con.createStatement();
            ResultSet set=stat.executeQuery(sql);
            while (set.next()){
                judul=set.getString("judul");
                penulis=set.getString("penulis");
                harga=set.getString("harga");
                String[] data={judul,penulis,harga};
                model.addRow(data);
            }
        }
        catch(Exception e){

        }

    }
    
    public void data(){
      judul=txtJudul.getText();
      harga=txtHarga.getText();
      penulis=(String)comboPenulis.getSelectedItem();
      
    }
    public void bersih(){
        txtJudul.setText("");
        txtHarga.setText("");
        
    }
   

    private void InitTable(){
        model = new DefaultTableModel();
        model.addColumn("ID BUKU");
        model.addColumn("JUDUL");
        model.addColumn("PENULIS");
        model.addColumn("HARGA");
        
        jTable1.setModel(model);
    }
   private DefaultTableModel model;
   private Connection con = Koneksi.getConnection();
   private Statement stt;
   private ResultSet rss;
   
   public FormDataBuku() {
        initComponents();
    }
   public void simpandata(){

      judul=txtJudul.getText();
      harga=txtHarga.getText();
      penulis=(String)comboPenulis.getSelectedItem();
        try{
            
            Statement statement=con.createStatement();
            String sql="insert into buku values ('"+judul+"','"+penulis+"','"+harga+"');";
            statement.executeUpdate(sql);
       statement.close();
    }
        catch (Exception e){

        }

    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboPenulis = new javax.swing.JComboBox<>();
        txtJudul = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Keluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cari = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        by = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 0));

        jPanel2.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 255));
        jLabel1.setText("FORM DATA BUKU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 255));

        jLabel2.setText("Judul");

        jLabel3.setText("Penulis");

        jLabel4.setText("Harga");

        comboPenulis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tere Liye", "W.S Rendra", "Felix Siaw", "Asma Nadia", "Dewi Lestari" }));

        txtJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJudulActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtJudul))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHarga)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(comboPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 0, 255));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);

        jButton3.setText("Ubah");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jButton4.setText("Hapus");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);

        Keluar.setText("Keluar");
        Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeluarActionPerformed(evt);
            }
        });
        jPanel4.add(Keluar);

        jTable1.setBackground(new java.awt.Color(0, 0, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "JUDUL", "PENULIS", "HARGA"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 51, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        cari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                cariCaretUpdate(evt);
            }
        });
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        jLabel5.setText("By :");

        by.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Judul", "Pengarang", "Harga" }));
        by.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byActionPerformed(evt);
            }
        });

        jLabel6.setText("Search :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(by, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(by, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJudulActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        InitTable();
        TampilData();
    }//GEN-LAST:event_formComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String judul = txtJudul.getText();
        String penulis = comboPenulis.getSelectedItem().toString();
        String harga = txtHarga.getText();
        TambahData(judul, penulis, harga);
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarActionPerformed
        // TODO add your handling code here:
        System.exit(1);
        
    }//GEN-LAST:event_KeluarActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       int baris = jTable1.getSelectedRow();
       String id = jTable1.getValueAt(baris,0).toString();
       if(Hapusdata(id))
           JOptionPane.showMessageDialog(null, "Berhasil Hapus");
       else 
           JOptionPane.showConfirmDialog(null, "Gagal Hapus Data");
       InitTable();
       TampilData();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:

      data();
      try
      {
      Statement statement=con.createStatement();
      String sql="delete from buku where judul=('"+judul+"','"+penulis+"','"+harga+"');";
       statement.executeUpdate(sql);
       statement.close();
       con.close();
       JOptionPane.showMessageDialog(null, "Data telah terhapus!");

        }
      catch (Exception e)
      {
         System.out.println("Error :"+e);
      }
       bersih();
       tampildataketabel();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        if(judul.equals(""))
         {
             JOptionPane.showMessageDialog(null, "Judul Buku Anda");
         }

        else{
      try
      {
      Statement statement=con.createStatement();
      String sql="update buku set judul='"+judul+"','"+penulis+"','"+harga+"');";
       statement.executeUpdate(sql);
       statement.close();
       con.close();
       JOptionPane.showMessageDialog(null, "Data telah terubah!");

        }
      catch (Exception e)
      {
         System.out.println("Error :"+e);
      }
       simpandata();
       bersih();
       tampildataketabel();
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void byActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byActionPerformed
        // TODO add your handling code here:
        try {
            String a = cari.getText(); //mendfinisikan variabel combo cari variabel a
            Statement statement=con.createStatement(); //Mendefinisikan conection di variabel statement
            String sql="select * from buku where judul like '"+a+"'";//memasukan perintah menampilkan isi tabel ke dalam variabel sql
            ResultSet rss=statement.executeQuery(sql); //mendefinisikan tempat menampung data ke dalam variabel rss kemdian mengeksekusi variabel sql yang berisi query.
            if(rss.next()) {//kondisi jika data yang ada di rss terisi maka lari ke statement dengan perintah next
                txtJudul.setText(rss.getString(1)); //variabel txtjudul di set kemudian isi dari data di tampung di rss lalu mengambil nilai rss dengan perintah getString
                comboPenulis.setSelectedItem(rss.getString(2));//variabel combopenulis di set kemudian isi dari data di tampung di rss lalu mengambil nilai rss dengan perintah getString
                txtHarga.setText(rss.getString(3));//variabel txtharga di set kemudian isi dari data di tampung di rss lalu mengambil nilai rss dengan perintah getString
                
            } else{//jika tidak sesuai kendisi maka lari ke statement di bawah
                JOptionPane.showMessageDialog(null, "DATA TIDAK ADA DALAM DATABASE");

            }
            statement.close();//statement di tutup dengan perintah close
            con.close(); //koneksi di tutup dengan perintah close
        } catch (Exception ex) {
            System.out.println("Error: "+ex);
        }
    }//GEN-LAST:event_byActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        
        txtJudul.setText(jTable1.getValueAt(baris, 1).toString());
        comboPenulis.setSelectedItem(jTable1.getValueAt(baris,2).toString());
        txtHarga.setText(jTable1.getValueAt(baris,3).toString());
                
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(baris, 0).toString();
        String judul = txtJudul.getText();
        String penulis = comboPenulis.getSelectedItem().toString();
        String harga = txtHarga.getText();
        if(UbahData(id, judul, penulis, harga))
            JOptionPane.showMessageDialog(null, "Berhasil Ubah Data");
        else 
            JOptionPane.showMessageDialog(null, "Gagal Ubah data");
        InitTable();
        TampilData();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_cariCaretUpdate
        // TODO add your handling code here:
        InitTable();
        if(cari.getText().length()==0){
            TampilData();
        }else{
            PencarianData(by.getSelectedItem().toString(), cari.getText());
        }
    }//GEN-LAST:event_cariCaretUpdate

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
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDataBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Keluar;
    private javax.swing.JComboBox<String> by;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> comboPenulis;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJudul;
    // End of variables declaration//GEN-END:variables
}
