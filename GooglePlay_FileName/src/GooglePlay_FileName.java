
import java.awt.Dimension;
import java.awt.Toolkit;

public class GooglePlay_FileName extends javax.swing.JFrame {

    String Name;
    String Language;
    String ID;
    String FinalString;

    public void goChange() {
        if (!jTextFieldName.getText().equals("")){
            Name = jTextFieldName.getText();
        } else {
            Name = "(片名)";
        }
        
        if (!jTextFieldLanguage.getText().equals("")){
            Language = jTextFieldLanguage.getText();
        } else {
            Language = "(發音)";
        }
        
        if (!jTextFieldID.getText().equals("")){
            ID = jTextFieldID.getText();
        } else {
            ID = "(ContentID)";
        }
        
        FinalString = "AVJET_" + Name + "_cmn-TW_PosterArt_" + ID + "\n"
                + "\n"
                + "AVJET_" + Name + "_cmn-TW_Forced_" + ID + "\n"
                + "\n"
                + "AVJET_" + Name + "_cmn-TW_Full_" + ID + "\n"
                + "\n"
                + "AVJET_" + Name + "_" + Language + "_Fully_Feature_" + ID + "\n"
                + "\n"
                + "AVJET_" + Name + "_" + Language + "_Sub_Trailer_" + ID + "";
        jTextArea1.setText(FinalString);
    }

    public GooglePlay_FileName() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (screenSize.getWidth() - getWidth()) / 2, (int) (screenSize.getHeight() - getHeight()) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldName = new javax.swing.JTextField();
        jTextFieldLanguage = new javax.swing.JTextField();
        jTextFieldID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelName = new javax.swing.JLabel();
        jLabelLanguage = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jButtonClean = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Google Play - File Name");

        jTextFieldName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNameKeyReleased(evt);
            }
        });

        jTextFieldLanguage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldLanguageKeyReleased(evt);
            }
        });

        jTextFieldID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIDKeyReleased(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("AVJET_(片名)_cmn-TW_PosterArt_(ContentID)\n\nAVJET_(片名)_cmn-TW_Forced_(ContentID)\n\nAVJET_(片名)_cmn-TW_Full_(ContentID)\n\nAVJET_(片名)_(發音)_Fully_Feature_(ContentID)\n\nAVJET_(片名)_(發音)_Sub_Trailer_(ContentID)");
        jScrollPane1.setViewportView(jTextArea1);

        jLabelName.setText("片名：");

        jLabelLanguage.setText("發音：");

        jLabelID.setText("ID：");

        jButtonClean.setText("清除");
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelLanguage)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextFieldLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonClean)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelID)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelName)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 209, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLanguage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonClean)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
        // TODO add your handling code here:
        jTextFieldName.setText("");
        jTextFieldLanguage.setText("");
        jTextFieldID.setText("");

        FinalString = "AVJET_(片名)_cmn-TW_PosterArt_(ContentID)\n"
                + "\n"
                + "AVJET_(片名)_cmn-TW_Forced_(ContentID)\n"
                + "\n"
                + "AVJET_(片名)_cmn-TW_Full_(ContentID)\n"
                + "\n"
                + "AVJET_(片名)_(發音)_Fully_Feature_(ContentID)\n"
                + "\n"
                + "AVJET_(片名)_(發音)_Sub_Trailer_(ContentID)";
        jTextArea1.setText(FinalString);
    }//GEN-LAST:event_jButtonCleanActionPerformed

    private void jTextFieldNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNameKeyReleased
        // TODO add your handling code here:
        goChange();
    }//GEN-LAST:event_jTextFieldNameKeyReleased

    private void jTextFieldLanguageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLanguageKeyReleased
        // TODO add your handling code here:
        goChange();
    }//GEN-LAST:event_jTextFieldLanguageKeyReleased

    private void jTextFieldIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIDKeyReleased
        // TODO add your handling code here:
        goChange();
    }//GEN-LAST:event_jTextFieldIDKeyReleased

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
            java.util.logging.Logger.getLogger(GooglePlay_FileName.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GooglePlay_FileName.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GooglePlay_FileName.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GooglePlay_FileName.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GooglePlay_FileName().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClean;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelLanguage;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLanguage;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
