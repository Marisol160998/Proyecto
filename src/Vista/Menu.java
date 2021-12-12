package Vista;
import java.awt.Image;
import java.awt.Toolkit;
/* @author Marisol */
public class Menu extends javax.swing.JFrame {
    public Menu() {
        initComponents();
    }
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Icon/logo.jpg"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        Registrar_Venta = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        Registrar_Producto = new javax.swing.JMenuItem();
        Modificar_Producto = new javax.swing.JMenuItem();
        Eliminar_Producto = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        Registrar_Compra = new javax.swing.JMenuItem();
        Modificar_Compra = new javax.swing.JMenuItem();
        Eliminar_Compra = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        Registrar_Proveedor = new javax.swing.JMenuItem();
        Modificar_Datos_Proveedor = new javax.swing.JMenuItem();
        Eliminar_Proveedor = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenu();
        salir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(215, 215, 216));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/633.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Goudy Stout", 1, 20)); // NOI18N
        jLabel2.setText("FERRETERÍA \"EL FERRERO\"");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(353, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 255));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setAlignmentX(10.0F);
        jMenuBar1.setAlignmentY(10.0F);

        jMenu5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/shopping-cart_icon-icons.com_72552.png"))); // NOI18N
        jMenu5.setText("    VENTA          ");
        jMenu5.setAlignmentX(10.0F);

        Registrar_Venta.setText("Registrar venta");
        Registrar_Venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Registrar_VentaMousePressed(evt);
            }
        });
        jMenu5.add(Registrar_Venta);

        jMenuBar1.add(jMenu5);

        jMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/353439-basket-buy-cart-ecommerce-online-purse-shop-shopping_107515.png"))); // NOI18N
        jMenu1.setText("    PRODUCTO          ");

        Registrar_Producto.setText("Registrar");
        Registrar_Producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Registrar_ProductoMousePressed(evt);
            }
        });
        jMenu1.add(Registrar_Producto);

        Modificar_Producto.setText("Modificar");
        Modificar_Producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Modificar_ProductoMousePressed(evt);
            }
        });
        jMenu1.add(Modificar_Producto);

        Eliminar_Producto.setText("Eliminar");
        Eliminar_Producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Eliminar_ProductoMousePressed(evt);
            }
        });
        jMenu1.add(Eliminar_Producto);

        jMenuBar1.add(jMenu1);

        jMenu6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/truck_delivery_icon_137071.png"))); // NOI18N
        jMenu6.setText("    COMPRA          ");

        Registrar_Compra.setText("Registrar Nuevas Compras");
        Registrar_Compra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Registrar_CompraMousePressed(evt);
            }
        });
        jMenu6.add(Registrar_Compra);

        Modificar_Compra.setText("Modificar");
        Modificar_Compra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Modificar_CompraMousePressed(evt);
            }
        });
        jMenu6.add(Modificar_Compra);

        Eliminar_Compra.setText("Eliminar");
        Eliminar_Compra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Eliminar_CompraMousePressed(evt);
            }
        });
        jMenu6.add(Eliminar_Compra);

        jMenuBar1.add(jMenu6);

        jMenu4.setBackground(new java.awt.Color(0, 0, 0));
        jMenu4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/user_follow_icon_143485.png"))); // NOI18N
        jMenu4.setText("    PROVEEDOR     ");
        jMenu4.setAutoscrolls(true);

        Registrar_Proveedor.setText("Registrar proveedor");
        Registrar_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Registrar_ProveedorMousePressed(evt);
            }
        });
        jMenu4.add(Registrar_Proveedor);

        Modificar_Datos_Proveedor.setText("Modificar datos del proveedor");
        Modificar_Datos_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Modificar_Datos_ProveedorMousePressed(evt);
            }
        });
        jMenu4.add(Modificar_Datos_Proveedor);

        Eliminar_Proveedor.setText("Eliminar proveedor");
        Eliminar_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Eliminar_ProveedorMousePressed(evt);
            }
        });
        jMenu4.add(Eliminar_Proveedor);

        jMenuBar1.add(jMenu4);

        Salir.setText("                                                                                                                                                                                                                          ");
        Salir.setAlignmentX(10.0F);
        Salir.setAlignmentY(10.0F);
        jMenuBar1.add(Salir);

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/remove_delete_exit_close_1545 (1).png"))); // NOI18N
        salir.setText("CERRAR SESIÓN");
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                salirMousePressed(evt);
            }
        });
        jMenuBar1.add(salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Registrar_ProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Registrar_ProductoMousePressed
        Producto p=new Producto();
        p.setVisible(true);
    }//GEN-LAST:event_Registrar_ProductoMousePressed

    private void Registrar_CompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Registrar_CompraMousePressed
        Compras c=new Compras();
        c.setVisible(true);
    }//GEN-LAST:event_Registrar_CompraMousePressed

    private void Registrar_ProveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Registrar_ProveedorMousePressed
        Proveedor p=new Proveedor();
        p.setVisible(true);
    }//GEN-LAST:event_Registrar_ProveedorMousePressed

    private void Registrar_VentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Registrar_VentaMousePressed
        Venta V=new Venta();
        V.setVisible(true);        
    }//GEN-LAST:event_Registrar_VentaMousePressed

    private void salirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMousePressed
        System.exit(0);
    }//GEN-LAST:event_salirMousePressed

    private void Eliminar_ProveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Eliminar_ProveedorMousePressed
        Eliminar_Proveedor ep=new Eliminar_Proveedor();
        ep.setVisible(true);
    }//GEN-LAST:event_Eliminar_ProveedorMousePressed

    private void Modificar_Datos_ProveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Modificar_Datos_ProveedorMousePressed
        Modificar_Datos_Proveedor mdp=new Modificar_Datos_Proveedor();
        mdp.setVisible(true);
    }//GEN-LAST:event_Modificar_Datos_ProveedorMousePressed

    private void Eliminar_CompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Eliminar_CompraMousePressed
        Eliminar_Compra ec=new Eliminar_Compra();
        ec.setVisible(true);
    }//GEN-LAST:event_Eliminar_CompraMousePressed

    private void Modificar_CompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Modificar_CompraMousePressed
        Modificar_Datos_Compra mdc=new Modificar_Datos_Compra();
        mdc.setVisible(true);
    }//GEN-LAST:event_Modificar_CompraMousePressed

    private void Eliminar_ProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Eliminar_ProductoMousePressed
        Eliminar_Producto ep=new Eliminar_Producto();
        ep.setVisible(true);
    }//GEN-LAST:event_Eliminar_ProductoMousePressed

    private void Modificar_ProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Modificar_ProductoMousePressed
        Modificar_Datos_Producto mdp=new Modificar_Datos_Producto();
        mdp.setVisible(true);
    }//GEN-LAST:event_Modificar_ProductoMousePressed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
//        Inicio i=new Inicio();
//        i.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar_Compra;
    private javax.swing.JMenuItem Eliminar_Producto;
    private javax.swing.JMenuItem Eliminar_Proveedor;
    private javax.swing.JMenuItem Modificar_Compra;
    private javax.swing.JMenuItem Modificar_Datos_Proveedor;
    private javax.swing.JMenuItem Modificar_Producto;
    private javax.swing.JMenuItem Registrar_Compra;
    private javax.swing.JMenuItem Registrar_Producto;
    private javax.swing.JMenuItem Registrar_Proveedor;
    private javax.swing.JMenuItem Registrar_Venta;
    private javax.swing.JMenu Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu salir;
    // End of variables declaration//GEN-END:variables
}
