



import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Khush
 */
public class font_chooser extends JDialog implements ActionListener, ListSelectionListener{
    
    notepad samp;
    
    JLabel flist_label, fsize_label, fstyle_label, fprev_label, preview;
    JList flist, fsize, fstyle;
    ScrollPane flist_sc, fstyle_sc, fsize_sc;
    JButton ok, cancel;
    
    GraphicsEnvironment ge; // graphics env
    String font_names[]; // font names array
    Font sample;
    
    String font_name;
    int font_size, font_style;
    
    public font_chooser(notepad ref)
    {
        samp  = ref;
        this.setLayout(null);
       
        
        // creating font name list
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        font_names = ge.getAvailableFontFamilyNames();
        flist = new JList(font_names);
        flist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        flist_label  = new JLabel("Font: ");        
        this.add(flist_label);
        flist_label.setBounds(10, 10, 120, 20);        
        flist_sc = new ScrollPane();
        flist_sc.add(flist);
        flist_sc.setBounds(10, 30, 120, 200);
        this.add(flist_sc);
        flist.addListSelectionListener(this);
        flist.putClientProperty(

   "Quaqua.List.style", "striped"

);

         
        // font style box
        String styles[] = {"Regular", "Bold", "Italic", "Bold Italic"};
        fstyle = new JList(styles);
        fstyle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fstyle_label = new JLabel("Style: ");
        this.add(fstyle_label);
        fstyle_label.setBounds(140, 10, 80, 20);
        fstyle_sc = new ScrollPane();
        fstyle_sc.add(fstyle);
        fstyle_sc.setBounds(140, 30, 80, 70);
        this.add(fstyle_sc);
        fstyle.addListSelectionListener(this);
        fstyle.putClientProperty(

   "Quaqua.List.style", "striped"

);
        // font size box
        Vector<String> a = new Vector<String>(40, 1);
        for (int i = 8; i <= 100; i += 2)
            a.addElement(String.valueOf(i));
        fsize = new JList(a);
        fsize.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fsize_label = new JLabel("Size: ");
        fsize_label.setBounds(140, 110, 80, 20);
        this.add(fsize_label);
        fsize_sc = new ScrollPane();
        fsize_sc.add(fsize);
        fsize_sc.setBounds(140, 130, 80, 100);
        this.add(fsize_sc);
        fsize.addListSelectionListener(this);
        fsize.putClientProperty(

   "Quaqua.List.style", "striped"

);
        // ok and cancel button
        ok = new JButton("OK");
        ok.setBounds(230, 30, 75, 20);
        ok.addActionListener(this);
        this.add(ok);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(230, 50, 75, 20);
        cancel.addActionListener(this);
        this.add(cancel);
        
        
        fprev_label  = new JLabel("Preview: ");
        fprev_label.setBounds(10, 230, 300, 20);
        this.add(fprev_label);
        
        // preview
        preview = new JLabel("Sample Text");
        preview.setBounds(10, 250, 290, 85);
        preview.setHorizontalAlignment(SwingConstants.CENTER);
        preview.setOpaque(true);
        preview.setBackground(Color.white);
        preview.setBorder(new LineBorder(Color.black, 1));
        this.add(preview);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        int w = 320;
        int h = 380;
        this.setSize(w,h);
        // set this position
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        this.setLocation(center.x-w/2, center.y-h/2+25);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(false);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==ok)
            ok();
        else if(e.getSource()==cancel)
            cancel();
    }
    
    public void valueChanged(ListSelectionEvent l)
    {
        if(l.getSource()==flist)
        {
            preview.setText( flist.getSelectedValue().toString() );
            changeFontSample();
        }
        else if(l.getSource()==fsize)
        {
            changeFontSample();
        }
        else if(l.getSource()==fstyle)
        {
            changeFontSample();
        }
    }
    
    private void changeFontSample()
    {

        try
        {
        font_name = flist.getSelectedValue().toString();
        }
        catch(NullPointerException npe)
        {
            font_name = "Verdana";
        }
        try
        {
            font_style = getStyle();
        }
        catch(NullPointerException npe)
        {
            font_style = Font.PLAIN;
        }
        try
        {
            font_size = Integer.parseInt(fsize.getSelectedValue().toString());
        }
        catch(NullPointerException npe)
        {
            font_size = 12;
        }
        sample = new Font(font_name, font_style, font_size);
        preview.setFont(sample);
    }
    
    private int getStyle()
    {
        if( fstyle.getSelectedValue().toString().equals("Bold") )
            return Font.BOLD;
        if(fstyle.getSelectedValue().toString().equals("Italic") )
            return Font.ITALIC;
        if(fstyle.getSelectedValue().toString().equals("Bold Italic")) 
            return Font.BOLD+Font.ITALIC;
        
        return Font.PLAIN;	
    }
    
    private void ok()
    {
        try
        {
        samp.t.setFont(sample);
        }
        catch(NullPointerException npe){}
        this.setVisible(false);
    }
    
    private void cancel()
    {
       this.setVisible(false);
    }

  
  

}
