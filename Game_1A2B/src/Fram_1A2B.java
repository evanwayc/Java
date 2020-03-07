

import javafx.scene.media.AudioClip;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Fram_1A2B extends javax.swing.JFrame {

    //設定環境變數
    //建立並取得答案
    int[] Ans = F_1A2B.creatAns();
    //建立觀看答案Label的陣列
    String SAns[] = {String.valueOf(Ans[0]), String.valueOf(Ans[1]), String.valueOf(Ans[2]), String.valueOf(Ans[3])};
    //建立A位置是否被猜到的判斷變數
    int A1, A2, A3, A4 = 0;
    //建立猜測次數
    int GuestNumberOfTime = 0;
    //結果欄位初始化的文字
    String FirstStr = "次數\t時間\t猜過的數字\t結果\n";
    //建立第一次猜測的時間變數
    Date FirstDate = new Date();
    //建立全部猜對時的時間變數
    Date FinalDate = new Date();
    //建立聲音
    AudioClip Wrong_Answer = new AudioClip(getClass().getResource("Audio/Wrong_Answer.wav").toExternalForm());
    AudioClip CrrectAnsAudio = new AudioClip(getClass().getResource("Audio/Crrect_Answer.wav").toExternalForm());
    AudioClip All_Crrect_Answer = new AudioClip(getClass().getResource("Audio/All_Crrect_Answer.wav").toExternalForm());

    //F計算視窗至中的位置
    public Point GetPositionPoint(int FIH, int FIW) {
        Dimension SDimensionWH = Toolkit.getDefaultToolkit().getScreenSize();
        Double SDW = SDimensionWH.getWidth();
        Double SDH = SDimensionWH.getHeight();
        int SIW = SDW.intValue();
        int SIH = SDH.intValue();
        int PW = ((SIW / 2) - (FIH / 2));
        int PH = ((SIH / 2) - (FIW / 2));
        Point PP = new Point(PW, PH);
        return PP;
    }

    //建構子
    public Fram_1A2B() {
        initComponents();

        //設定視窗至中
        int FIW = this.getWidth();
        int FIH = this.getHeight();
        Point PP = GetPositionPoint(FIH, FIW);
        setLocation(PP);

        //設定Icon
        setIcon();

        //取得答案並且顯示在螢幕上
        newStart();

        //初始化結果視窗
        jTextPane1.setText(FirstStr);
    }

    //F設定Icon
    private void setIcon() {
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
//        setIconImage(new ImageIcon("icon.png").getImage());
//        Application.getApplication().setDockIconImage(
//            new ImageIcon("icon.png").getImage());
    }

    //F設定顯示答案的
    public void SeeAns() {
        jLabelAns.setForeground(java.awt.Color.red);
        jLabelAns.setText("" + Ans[0] + Ans[1] + Ans[2] + Ans[3]);
    }

    //F設定顯示已猜對的答案數字
    public void ShowA() {
        jLabelAns.setForeground(java.awt.Color.black);
        if (A1 > 0) {
            SAns[0] = String.valueOf(Ans[0]);
        } else {
            SAns[0] = "*";
        }
        if (A2 > 0) {
            SAns[1] = String.valueOf(Ans[1]);
        } else {
            SAns[1] = "*";
        }
        if (A3 > 0) {
            SAns[2] = String.valueOf(Ans[2]);
        } else {
            SAns[2] = "*";
        }
        if (A4 > 0) {
            SAns[3] = String.valueOf(Ans[3]);
        } else {
            SAns[3] = "*";
        }
        jLabelAns.setText("" + SAns[0] + SAns[1] + SAns[2] + SAns[3]);
    }

    //F定義重新開始函式
    public void newStart() {
        Ans = F_1A2B.creatAns();
        GuestNumberOfTime = 0;
        String AnsStr = Arrays.toString(Ans);
        A1 = 0;
        A2 = 0;
        A3 = 0;
        A4 = 0;
        jLabelAns.setForeground(java.awt.Color.black);
        jLabelAns.setText("****");
        jTextPane1.setText(jTextPane1.getText() + "------------------------------------\n答案已更新為      " + AnsStr + "\n" + FirstStr);
    }

    //F送出數字比對
    public void Submit() {
        //取得輸入欄位上的文字
        String GuestStr = jTextField1.getText();
        //清除輸入欄位內的文字
        jTextField1.setText("");

        //檢查輸入的長度
        boolean checkGuestStrLength = F_1A2B.checkGuestStrLength(GuestStr);
        if (checkGuestStrLength == false) {
            JOptionPane.showMessageDialog(null, "輸入的長度不對");
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
                    //執行比對
                    Compare(GuestStr);
                }
            }
        }
    }

    //F送出數字去比對判斷
    void Compare(String GuestStr) {
        //猜測次數+1
        GuestNumberOfTime++;
        //取得時間
        SimpleDateFormat sdFormat = new SimpleDateFormat("hh:mm:ss");
        Date Date = new Date();
        String DateStr = sdFormat.format(Date);
        //取得第一次猜測的時間
        if (GuestNumberOfTime == 1) {
            FirstDate = Date;
        }

        //取得結果 by List
        List ResultAL = new ArrayList();
        ResultAL = F_1A2B.showResult(GuestStr, Ans);
        String ResultABStr = (String) ResultAL.get(0);
        String ShowAStr = (String) ResultAL.get(1);

//        //取得結果 by Str "xAxBxxxx"
//        String ResultAB = F_1A2B.showResult(GuestStr, Ans);
//        //取得前四個字的 "xAxB" 結果
//        String Result = ResultAB.substring(0, 4);
//        //取得後四個字的 "xxxx" 結果
//        String StrShowA = ResultAB.substring(4, 8);
        //轉換後四位數所代表的數字位置意義
        A1 = Character.getNumericValue(ShowAStr.charAt(0));
        A2 = Character.getNumericValue(ShowAStr.charAt(1));
        A3 = Character.getNumericValue(ShowAStr.charAt(2));
        A4 = Character.getNumericValue(ShowAStr.charAt(3));
        //顯示已被猜中的A的數字
        ShowA();
        //輸出結果
        jTextPane1.setText(jTextPane1.getText() + GuestNumberOfTime + "\t" + DateStr + "\t" + GuestStr + "\t" + ResultABStr + "\n");

        //如果結果為"0A0B"
        if (ResultABStr.equals("0A0B")) {
            Wrong_Answer.play();
        }

        //如果結果有A有B
        if (Character.getNumericValue(ResultABStr.charAt(0)) > 0 || Character.getNumericValue(ResultABStr.charAt(2)) > 0) {
            if (!ResultABStr.equals("4A0B")) {
                CrrectAnsAudio.play();
            }
        }
        //如果結果為"4A0B"
        if (ResultABStr.equals("4A0B")) {
            //播放答對聲音
            All_Crrect_Answer.play();
            //設定顯示答案為綠色
            jLabelAns.setForeground(java.awt.Color.green);
            //取得全部猜對時的時間
            FinalDate = Date;
            //計算第一次猜測到全部猜對的時間差
            long longCostTime = (FinalDate.getTime() - FirstDate.getTime());
            System.out.println(longCostTime);

            //跳出選項視窗
            int PassOption = JOptionPane.showConfirmDialog(null, "恭喜答對，是否重新開始", "!!!可喜可賀!!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch (PassOption) {
                case JOptionPane.OK_OPTION:
                    newStart();
                    break;
                case JOptionPane.NO_OPTION:
                    jTextPane1.setText(jTextPane1.getText() + "答案無更新\n");
                    break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButtonSubmit = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButtonNewStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabelAns = new javax.swing.JLabel();

        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("猜數字");
        setLocation(new java.awt.Point(0, 0));

        jButtonSubmit.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        jButtonSubmit.setText("送出答案");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButtonNewStart.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        jButtonNewStart.setText("重新開始");
        jButtonNewStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewStartActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        jLabel1.setText("輸入四位數字：");

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        jLabel2.setText("答案：");

        jScrollPane2.setViewportView(jTextPane1);

        jLabelAns.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelAns.setText("****");
        jLabelAns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAnsMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAnsMouseEntered(evt);
            }
        });

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
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabelAns)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSubmit)
                            .addComponent(jButtonNewStart, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSubmit)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAns)
                    .addComponent(jLabel2)
                    .addComponent(jButtonNewStart))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //按鈕1 - 送出數字比對
    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        Submit();
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    //按鈕2 - 重新開始
    private void jButtonNewStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewStartActionPerformed
        newStart();
    }//GEN-LAST:event_jButtonNewStartActionPerformed

    //輸入框內按下Enter - 送出數字比對
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Submit();
        }
        jTextField1KeyReleased(evt);
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jLabelAnsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAnsMouseEntered
        SeeAns();
    }//GEN-LAST:event_jLabelAnsMouseEntered

    private void jLabelAnsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAnsMouseExited
        ShowA();
    }//GEN-LAST:event_jLabelAnsMouseExited

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        jTextField1KeyReleased(evt);
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if (jTextField1.getText().length() == 4) {
            Submit();
        }
    }//GEN-LAST:event_jTextField1KeyReleased

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
            java.util.logging.Logger.getLogger(Fram_1A2B.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fram_1A2B.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fram_1A2B.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fram_1A2B.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButtonNewStart;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAns;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

}
