/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.HoaDon;

import DAO.*;
import Model.*;
import static View.HoaDon.jf_editHD.*;
import View.Run;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author ThangIKCU
 */
public class jd_SoLuongHD extends javax.swing.JDialog {
    
    int sl = 0;
    List<ThucDon> listTD;
    public String gioden, mamon, tenban, mahd;
    public int maban;
    public float dongia;
    CTHoaDonDAO cthdDAO = new CTHoaDonDAO();
    ThucDonDAO tdDAO = new ThucDonDAO();
    HoaDonDAO hdDAO = new HoaDonDAO();
    BanDAO banDAO = new BanDAO();
    CTHoaDon cthd;
    HoaDon hd;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    /**
     * Creates new form NewJDialog
     */
    
    /**
     * Creates new form NewJDialog
     * @param parent
     * @param modal
     * @param MaMon
     * @param tenban
     * @param MaBan
     * @param DonGia
     * @param MaHD
     */
    public jd_SoLuongHD(java.awt.Frame parent, boolean modal, String MaMon, String TenBan, int MaBan, float DonGia, String MaHD) {
        super(parent, modal);
        initComponents();
        mamon = MaMon;
        tenban = TenBan;
        maban = MaBan;
        dongia = DonGia;
        mahd = MaHD;
        view();
        hd = hdDAO.GetHoaDonByMaBan(MaBan, mahd);
        if (hd != null) {
            cthd = cthdDAO.getCTHDbyMaHDAndMaMon(hd.getMahd(), Integer.valueOf(MaMon));
            if (cthd != null) {
                lblThanhTien.setText(String.valueOf(cthd.getThanhtien()));
                txtSoLuong.setText(String.valueOf(cthd.getSoluong()));
            }
        }
        lblThanhTien.setText(String.format("%,.0f", DonGia));

    }
    private void view(){
        listTD = tdDAO.getListTDByMaMon(Integer.parseInt(mamon));
        txtSoLuong.setText("1");
        lblBan.setText(tenban + " ");
        
        lblTenMon.setText(listTD.get(0).getTenmon());
        lblDVT.setText(listTD.get(0).getDvtinh());
        lblThanhTien.setText(String.valueOf(listTD.get(0).getDongia()));
    }
    
    private float ThanhTien(){
        listTD = tdDAO.getListTDByMaMon(Integer.parseInt(mamon));
        float sl = Float.parseFloat(txtSoLuong.getText());
        float dg = Float.parseFloat(String.valueOf(listTD.get(0).getDongia()));
        return sl*dg;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTenMon = new javax.swing.JLabel();
        lblDVT = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btOK = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        btGiam = new javax.swing.JButton();
        btTang = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblBan = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(140, 140, 6));
        setLocation(new java.awt.Point(500, 200));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblTenMon.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTenMon.setForeground(new java.awt.Color(51, 0, 0));
        lblTenMon.setText("Cà phê sữa");

        lblDVT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDVT.setText("Ly");

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyReleased(evt);
            }
        });

        btOK.setBackground(new java.awt.Color(0, 255, 0));
        btOK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btOK.setForeground(new java.awt.Color(255, 255, 255));
        btOK.setText("Đồng ý");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        btClose.setBackground(new java.awt.Color(255, 0, 0));
        btClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btClose.setForeground(new java.awt.Color(255, 255, 255));
        btClose.setText("Hủy");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        btGiam.setBackground(new java.awt.Color(255, 255, 255));
        btGiam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tru(-).png"))); // NOI18N
        btGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGiamActionPerformed(evt);
            }
        });

        btTang.setBackground(new java.awt.Color(255, 255, 255));
        btTang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cong(+).png"))); // NOI18N
        btTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTangActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Số lượng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Thành tiền");

        lblBan.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblBan.setForeground(new java.awt.Color(0, 51, 0));
        lblBan.setText("Bàn1");

        lblThanhTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblThanhTien.setForeground(java.awt.Color.red);
        lblThanhTien.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btTang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBan, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(lblTenMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTangActionPerformed
            sl = Integer.parseInt(txtSoLuong.getText());
            if(sl < 30){
                sl++;
                txtSoLuong.setText(String.valueOf(sl));
                lblThanhTien.setText(String.format("%,.0f",ThanhTien()));
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_btTangActionPerformed

    private void btGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGiamActionPerformed
        try{
            sl = Integer.parseInt(txtSoLuong.getText());
            if(sl != 1 && sl != 0){
                sl--;
                txtSoLuong.setText(String.valueOf(sl));
                lblThanhTien.setText(String.format("%,.0f",ThanhTien()));
            }
        }catch(Exception e){
                txtSoLuong.setText("1");
        }

    }//GEN-LAST:event_btGiamActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btCloseActionPerformed

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        if (cthd != null) {
            CTHoaDon cthd1 = new CTHoaDon();
            cthd1.setMahd(mahd);
            cthd1.setMamon(Integer.parseInt(mamon));
            cthd1.setSoluong(Integer.parseInt(txtSoLuong.getText()));
            cthd1.setThanhtien(ThanhTien());
            cthdDAO.updateCTHoaDon(cthd1);
        }
        if (cthd == null) {
            CTHoaDon cthd2 = new CTHoaDon();
            cthd2.setMahd(hd.getMahd());
            cthd2.setThanhtien(ThanhTien());
            cthd2.setMamon(Integer.parseInt(mamon));
            cthd2.setTenmon(lblTenMon.getText());
            cthd2.setDvtinh(lblDVT.getText());
            cthd2.setSoluong(Integer.parseInt(txtSoLuong.getText()));
            cthd2.setDongia(dongia);
            cthdDAO.addCTHoaDon(cthd2);
        }
        jf_editHD.edit.TableCTHD();
        jf_editHD.edit.ThanhToan();
        this.dispose();
    }//GEN-LAST:event_btOKActionPerformed

    private void txtSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyReleased
        try{
            sl = Integer.parseInt(txtSoLuong.getText());
            if(txtSoLuong.getText().equals("0") || sl > 30){
                txtSoLuong.setText("1");
            }
            lblThanhTien.setText(String.format("%,.0f",ThanhTien()));
        }catch(Exception e){
           txtSoLuong.setText("1");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongKeyReleased

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.getRootPane().setDefaultButton(btOK);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btGiam;
    private javax.swing.JButton btOK;
    private javax.swing.JButton btTang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBan;
    private javax.swing.JLabel lblDVT;
    private javax.swing.JLabel lblTenMon;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
