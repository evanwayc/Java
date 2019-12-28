
package level_2;

import java.awt.Button;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class n33_MyFrame_1 {

    JFrame f = new JFrame();
    
    public n33_MyFrame_1() {
        f.setSize(300,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        
        f.add( new JButton("123"));
        f.add( new JTextArea());
    }
}
