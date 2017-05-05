



import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Khush
 */
public class about extends JDialog {
    
    notepad samp;
    JButton btn;
    
    public about(notepad ref)
    {
        samp  = ref;
        
        this.setLayout(new FlowLayout());
        
        String about = "<html>" +
                "<body>" +
                "Created By...<br>" +
                "Khush Chandawat <br>" +                
                "Cathedral High School<br>" +
                "<br><br><br>" +
                "Contact: +919481457123<br>" +
                "E-Mail: khushchandawat@rocketmail.com<br>" +
                "Web:<a href=http://www.aiitcorporation.webs.com> http://www.aiitcorporation.webs.com</a><br><br>" +
                "Version: 1.00<br>" +
                "Built Date: December 08, 2012<br><br><br>" +
                "</body>" +
                "</html>"; 
        
        
        JLabel l = new JLabel("",  SwingConstants.LEFT);
        l.setText(about);
        l.setVerticalTextPosition(SwingConstants.TOP);
        l.setIconTextGap(20);
        this.add(l);
        
             
        
        
        int w = 340;
        int h = 250;
        this.setSize(w,h);
        // set window position
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        this.setLocation(center.x-w/2, center.y-h/2+25);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
     this.setVisible(false);
        
        
    }
}
