package level_2;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;

public class Fram_1A2B extends javax.swing.JFrame {

    //固定Ans在階層之上
    int[] Ans = F_1A2B.creatAns();

    //建構子
    public Fram_1A2B() {
        initComponents();

        //取得答案並且顯示在螢幕上
        newStar();
        jTextPane1.setText("時間\t猜過的數字\t結果\n");
    }

    //定義重新開始函式
    public void newStar() {
        Ans = F_1A2B.creatAns();
        String AnsStr = Arrays.toString(Ans);
        jTextField2.setText("" + Ans[0] + Ans[1] + Ans[2] + Ans[3]);
        jTextPane1.setText(jTextPane1.getText() + "\n答案已更新為      " + AnsStr + "\n時間\t猜過的數字\t結果\n");
    }

    //送出數字比對
    public void Submit() {
        //取得輸入欄位上的文字
        String GuestStr = jTextField1.getText();

        //檢查輸入的長度
        boolean checkGuestStrLength = F_1A2B.checkGuestStrLength(GuestStr);
        if (checkGuestStrLength == false) {
            JOptionPane.showMessageDialog(null, "你輸入的長度不對");
        } else {
            //檢查輸入的是否全數字
            boolean checkGuestIsInt = F_1A2B.checkGuestIsInt(GuestStr);
            if (checkGuestIsInt == false) {
                JOptionPane.showMessageDialog(null, "請輸入數字");
            } else {
                //檢查輸入的是否有重複
                boolean checkGuestNoRp = F_1A2B.checkGuestNoRp(GuestStr);
                if (checkGuestNoRp == false) {
                    JOptionPane.showMessageDialog(null, "請勿輸入一樣的數字");
                } else {
                    //比對答案&顯示時間+猜測數字+結果
                    //取得時間
                    SimpleDateFormat sdFormat = new SimpleDateFormat("hh:mm:ss");
                    Date Date = new Date();
                    String DateStr = sdFormat.format(Date);
                    //取得AB結果
                    String Result = F_1A2B.showResult(GuestStr, Ans);
                    jTextPane1.setText(jTextPane1.getText() + DateStr + "\t" + GuestStr + "\t" + Result + "\n");
                    if (Result.equals("4A0B")) {
                        int PassOption = JOptionPane.showConfirmDialog(null, "恭喜答對，是否重新開始", "可喜可賀", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        switch (PassOption) {
                            case JOptionPane.OK_OPTION:
                                newStar();
                                break;
                            case JOptionPane.NO_OPTION:
                                jTextPane1.setText(jTextPane1.getText() + "答案無更新\n");
                                break;
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("猜數字");

        jButton1.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        jButton1.setText("送出答案");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        jButton2.setText("重新開始");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        jLabel1.setText("請輸入四位數字：");

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        jLabel2.setText("答案：");

        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //按鈕1 - 送出數字比對
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Submit();
    }//GEN-LAST:event_jButton1ActionPerformed

    //按鈕2 - 重新開始
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        newStar();
    }//GEN-LAST:event_jButton2ActionPerformed

    //輸入框內按下Enter - 送出數字比對
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Submit();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

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
            java.util.logging.Logger.getLogger(Fram_1A2B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fram_1A2B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fram_1A2B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fram_1A2B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fram_1A2B().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
