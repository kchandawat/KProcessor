/*
 * Created By...
 * Khush
 * **/





import com.sun.org.apache.bcel.internal.generic.RETURN;


import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;


public class notepad extends JFrame implements ActionListener
{
    Container c;
    public JScrollPane sc;
    public JTextArea t;    
    
    private JMenuBar menubar;
    private JPopupMenu pm;
    private JMenu file;
    private JMenuItem file_new;
    private JMenuItem file_open;
    private JSeparator file_sep1;
    private JMenuItem file_save;
    private JMenuItem file_save_as;
    private JSeparator file_sep2;
    private JMenuItem file_print;
    private JSeparator file_sep3;
    private JMenuItem file_close;
    private JMenuItem file_exit;    
    private JMenuItem cs;
    private JMenuItem css;
          private JMenuItem cut;
     private  JMenuItem copy;
      private JMenuItem paste;
   
     private  JMenuItem undo1;
      private JMenuItem redo;
   
       private  JMenuItem open;
      
      private JMenuItem new1;
   
      private JMenuItem save;
     
    
     private  JMenuItem date;
     
    
     private  JMenuItem find;
   
    
     private JMenuItem exit;
    private JMenu edit;
    private JMenuItem edit_undo;
    private JMenuItem edit_redo;
    private JSeparator edit_sep1;
    private JMenuItem edit_copy;
    private JMenuItem edit_cut;
    private JMenuItem edit_paste;
    private JMenuItem edit_delete;
    private JSeparator edit_sep2;
    private JMenuItem edit_find;
    private JMenuItem edit_find_next;
    private JMenuItem edit_replace;
    private JSeparator edit_sep3;
    public JFileChooser li ;
    private JMenuItem edit_selectall;
    private JMenuItem edit_timedate;
    private JMenuItem a;
    private JMenuItem b;
    private JMenuItem cd;
    private JMenuItem d;
    private JMenuItem ef;
    private JMenuItem fg;
    private JMenuItem  gh;
    private JMenu format;
    private JMenuItem format_font;
    private JMenu convert;
    private JMenuItem str2uppr, str2lwr;
    private JCheckBoxMenuItem format_wordwarp;
    public File myfile;
    private JMenu help;
    private JMenuItem help_about;
    
    UndoManager undo = new UndoManager();
    UIManager.LookAndFeelInfo lnf[];
    
    find finder;
    font_chooser fc;
    about abt;
    
    String path, content;
    
    
    public notepad(){
        super("untitled - KProcessor");
      int kj=1;
   
      



        
        
        Container c = getContentPane();
        t = new JTextArea("", 5,5);
        t.setFont(new Font("Verdana",Font.PLAIN, 12));
        sc = new JScrollPane(t, sc.VERTICAL_SCROLLBAR_AS_NEEDED, sc.HORIZONTAL_SCROLLBAR_AS_NEEDED); //adding scrollbar to text area;
        c.add(sc); 
      
        menubar = new JMenuBar();
        
        file = new JMenu("File");         
        file_new = new JMenuItem("New");
        file_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        file_new.addActionListener(this);
        file.add(file_new);        
        file_open = new JMenuItem("Open");
        file_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        file_open.addActionListener(this);
        file.add(file_open);        
        file_sep1 = new JSeparator();
        file.add(file_sep1);        
        file_save = new JMenuItem("Save");
        file_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        file_save.addActionListener(this);
        file.add(file_save);        
        file_save_as = new JMenuItem("Save As");
        file_save_as.addActionListener(this);
        file.add(file_save_as);        
        file_sep2 = new JSeparator();
        file.add(file_sep2);        
        file_print = new JMenuItem("Print");
        file_print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
        file_print.addActionListener(this);        
        file.add(file_print);             
        file_sep3 = new JSeparator();
        file.add(file_sep3);        
        file_close = new JMenuItem("Close");
        file_close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));
        file_close.addActionListener(this);
        file.add(file_close);        
        file_exit = new JMenuItem("Exit"); 
        file_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
        file_exit.addActionListener(this);
        file.add(file_exit);
        menubar.add(file);
        
        edit = new JMenu("Edit");       
        edit_undo = new JMenuItem("Undo");
        edit_undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
        edit_undo.addActionListener(this);
        edit.add(edit_undo);
        edit_redo = new JMenuItem("Redo");
        edit_redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
        edit_redo.addActionListener(this);
        edit.add(edit_redo);        
        edit_sep1 = new JSeparator();
        edit.add(edit_sep1);        
        edit_copy = new JMenuItem("Copy");
        edit_copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        edit_copy.addActionListener(this);        
        edit.add(edit_copy);        
        edit_cut = new JMenuItem("Cut");
        edit_cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        edit_cut.addActionListener(this);
        edit.add(edit_cut);        
        edit_paste = new JMenuItem("Paste");
        edit_paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        edit_paste.addActionListener(this);
        edit.add(edit_paste);        
        edit_delete = new JMenuItem("Delete");
        edit_delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        edit_delete.addActionListener(this);
        edit.add(edit_delete);        
        edit_sep2 = new JSeparator();
        edit.add(edit_sep2);        
        edit_find = new JMenuItem("Find");
        edit_find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        edit_find.addActionListener(this);
        edit.add(edit_find);        
        edit_find_next = new JMenuItem("Find Next");
        edit_find_next.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        edit_find_next.addActionListener(this);
        edit.add(edit_find_next);       
        edit_replace = new JMenuItem("Replace");
        edit_replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
        edit_replace.addActionListener(this);
        edit.add(edit_replace);        
        edit_sep3 = new JSeparator();
        edit.add(edit_sep3);        
        edit_selectall = new JMenuItem("Select All");
        edit_selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        edit_selectall.addActionListener(this);
        edit.add(edit_selectall);        
        edit_timedate = new JMenuItem("Time/Date");
        edit_timedate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
        edit_timedate.addActionListener(this);
        edit.add(edit_timedate);        
        menubar.add(edit);
        
        format = new JMenu("Format");        
        format_font = new JMenuItem("Font");
        format_font.addActionListener(this);
        format.add(format_font);
        cs=new JMenuItem("Backround Colour");
        css=new JMenuItem("Text Colour");
        format.add(cs);
        format.add(css);
        createPopupMenu();        
        convert = new JMenu("Convert");
        str2uppr = new JMenuItem("To Uppercase...");
        str2uppr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.CTRL_MASK));
        str2uppr.addActionListener(this);
        convert.add(str2uppr);
        str2lwr = new JMenuItem("To Lowercase...");
        str2lwr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.CTRL_MASK));
        str2lwr.addActionListener(this);        
        convert.add(str2lwr);        
        format.add(convert);
     
        format_wordwarp = new JCheckBoxMenuItem("Word Warp");
        format_wordwarp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
        format_wordwarp.addActionListener(this);
        format.add(format_wordwarp);        
        menubar.add(format);
         JScrollPane ka=new JScrollPane();
        help = new JMenu("Help");        
        help_about = new JMenuItem("About");
        help_about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        help_about.addActionListener(this);
        help.add(help_about);         
        menubar.add(help); 
        cs.addActionListener(this);
        css.addActionListener(this);
        c.add(menubar, BorderLayout.NORTH);  
       
        // undo manager
        Document doc= t.getDocument();
        doc.addUndoableEditListener(
                new UndoableEditListener( )
                {
                    public void undoableEditHappened( UndoableEditEvent event )
                    {
                        undo.addEdit(event.getEdit());
                    }
                }
        );
        
        // find_window
        finder = new find(this);
        finder.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
        // font chooser
        fc = new font_chooser(this);
        abt = new about(this);

       
        
        // set window size
        int w = 400;
        int h = 450;
        setSize(400, 450);
        // set window position
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        setLocation(center.x-w/2, center.y-h/2);
        this.setVisible(true);
        path = "";
    }
     
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==file_new)
            file_new();
        else if(e.getSource()==file_open)
            file_open();
        else if(e.getSource()==file_save)
            file_save();
    
        else if(e.getSource()==file_save_as)
            file_save_as();
        else if(e.getSource()==file_print)
            file_print();
        else if(e.getSource()==file_close)
            file_close();
        else if(e.getSource()==file_exit)
            file_exit();
      
          
         
        else if(e.getSource()==edit_undo)
            edit_undo();
        else if(e.getSource()==edit_redo)
            edit_redo();
        else if(e.getSource()==edit_cut)
            edit_cut();
        else if(e.getSource()==edit_copy)
            edit_copy();
        else if(e.getSource()==edit_paste)
            edit_paste();
        else if(e.getSource()==cs)
            
            Cs();
        else if(e.getSource()==css)
        { 
            
            Css();
        }
        else if(e.getSource()==edit_delete)
            edit_delete();
        else if(e.getSource()==edit_find)
            edit_find();
        else if(e.getSource()==edit_find_next)
            edit_find_next();
        else if(e.getSource()==edit_replace)
            edit_replace();
        else if(e.getSource()==edit_selectall)
            edit_selectall();
        else if(e.getSource()==edit_timedate)
            edit_timedate();
        
            
        else if(e.getSource()==format_font)                
            format_font();
        else if(e.getSource()==str2uppr)
            str2uppr();
        else if(e.getSource()==str2lwr)
            str2lwr();
        else if(e.getSource()==format_wordwarp)
            format_wordwarp();
            
        
        else if(e.getSource()==help_about)
            help_about();
         else if(e.getSource()==open)
        file_open();
        else if(e.getSource()==cut)
        edit_cut();
        else if(e.getSource()==paste)
             edit_paste();
        else if(e.getSource()==copy)
            edit_copy(); 
        else if(e.getSource()==undo1)
           edit_undo();
        else if(e.getSource()==new1)
            file_new();
        else if(e.getSource()==redo)
             edit_redo();
        else if(e.getSource()==date)
            edit_timedate();
        else if(e.getSource()==exit)
           file_exit();
        else if(e.getSource()==save)
       file_save();
  
      
        else if(e.getSource()==find)
         edit_find();    
    }
    
     public void createPopupMenu(){
         
    pm=new JPopupMenu();
    JSeparator a=new JSeparator();
    JSeparator b=new JSeparator();
     cut=new JMenuItem("Cut");
     copy=new JMenuItem("Copy");
    paste=new JMenuItem("Paste");
   
   undo1=new JMenuItem("Undo");
    redo=new JMenuItem("Redo");
         new1=new JMenuItem("New");
       open=new JMenuItem("Open");
      open.addActionListener(this);
      cut.addActionListener(this);
      copy.addActionListener(this);
      paste.addActionListener(this);
      undo1.addActionListener(this);
      redo.addActionListener(this);
      new1.addActionListener(this);
      
   
   
     save=new JMenuItem("Save");
     JSeparator c=new JSeparator();
    
     date=new JMenuItem("Date");
    JSeparator d=new JSeparator();
    
    find=new JMenuItem("Find");
   JSeparator e=new JSeparator();
    
   exit=new JMenuItem("Exit");
   JSeparator f=new JSeparator();
   save.addActionListener(this);
      date.addActionListener(this);
      find.addActionListener(this);
      exit.addActionListener(this);
   
    pm.add(cut);pm.add(copy);pm.add(paste); pm.add(a);pm.add(undo1);pm.add(redo); pm.add(b);pm.add(open);pm.add(new1);pm.add(save);pm.add(c);pm.add(date);pm.add(d);pm.add(find);pm.add(e);pm.add(exit);pm.add(f);
    new1.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e){}
  });

    t.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me){
				if(me.isPopupTrigger()){
					pm.show(me.getComponent(), me.getX(), me.getY());
				}
			}
			public void mouseReleased(MouseEvent Me){
				if(Me.isPopupTrigger()){
					pm.show(Me.getComponent(), Me.getX(), Me.getY());pm.enable(true);
				}
			}
		});
    
}
    public void Cs(){
 
    Color k=JColorChooser.showDialog(this, "Background Colour Chooser",t.getBackground());
    t.setBackground(k);
    }
     public void Css(){
    Color k=JColorChooser.showDialog(t, "Text Colour Chooser",t.getForeground());
    t.setForeground(k);
    }
    public void file_new(){
    if(t.getText().equals("") || t.getText().equals(content))
        {
            t.setText("");
            content = "";
            path = "";
            setTitle("untitled - KProcessor");
        }
        else
        {
            int a = JOptionPane.showConfirmDialog(null, "The text has been changed\nDo you want to save the changes?");
            if(a==0)
                file_save();
            else if(a==1)
            {
                t.setText("");
                path = "";
                setTitle("untitled - KProcessor");
            }
            else if(a==2)
                return;
        }    
    }
   
    
    
    public void file_open(){
         li = new JFileChooser();
        li.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int r=li.showOpenDialog(this); 
 
        if(r==li.CANCEL_OPTION)
            return;        
         myfile = li.getSelectedFile();
        if(myfile == null || myfile.getName().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Select a file!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            
        }
        try
        {
            BufferedReader input = new BufferedReader(new FileReader(myfile));
            StringBuffer str = new StringBuffer();
            String line;
            while((line = input.readLine()) != null) // st is declared as string avobe
                str.append(line+"\n");
            t.setText(str.toString());
            content = t.getText();
            path = myfile.toString();
            setTitle(myfile.getName()+" - KProcessor");
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "File not found: "+e);
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "IO ERROR: "+e);
        }
    }
    
    public void file_save(){
        if(this.path.equals(""))
        {
            file_save_as();
            return;
        }
        try
        {
            FileWriter fw = new FileWriter(path);
            fw.write(t.getText());
            content = t.getText();
            fw.close();
        }
        catch(IOException i)
        {
            JOptionPane.showMessageDialog(this,"Failed to save the file","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void file_save_as(){
        
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);        
        int r = fc.showSaveDialog(this);        
        if(r==fc.CANCEL_OPTION)
            return;
        File myfile = fc.getSelectedFile();     
        if(myfile==null || myfile.getName().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter a file name!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(myfile.exists())
        {
            r = JOptionPane.showConfirmDialog(this, "A file with same name already exists!\nAre you sure want to overwrite?");
            if(r != 0) 
                return;
        }        
        try
        {
    
          
            FileWriter fw = new FileWriter(myfile);
            fw.write(t.getText());
            content = t.getText();            setTitle(myfile.getName()+" - KProcessor");
            fw.close();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(this,"Failed to save the file","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void file_print() {
        PrinterJob printer = PrinterJob.getPrinterJob();
        //printer.setPrintable( this);
        HashPrintRequestAttributeSet printAttr = new HashPrintRequestAttributeSet();
        if(printer.printDialog(printAttr))     // Display print dialog
        {            // If true is returned...
            try
            {
                printer.print(printAttr);    // then print
            }
            catch(PrinterException e)
            {
                JOptionPane.showMessageDialog(this,"Failed to print the file: "+e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void file_close(){
        if(t.getText().equals("") || t.getText().equals(content))
        {
            t.setText("");
            path = "";
            setTitle("untitled - KProcessor");
        }
        else
        {
            int a = JOptionPane.showConfirmDialog(null, "The text has been changed\nDo you want to save the changes?");
            if(a==0)
                file_save();
            else if(a==1)
            {
                t.setText("");
                path = "";
                setTitle("untitled - KProcessor");
            }
            else if(a==2)
                return;
        }
    
    }
    
    public void file_exit(){
        
        if(t.getText().equals("") || t.getText().equals(content))
            System.exit(0);
    	else
    	{
         
            int b = JOptionPane.showConfirmDialog(null, 
                                  "Do you want to save changes to "+this.getTitle(), 
                                  "KProcessor", 
                                  JOptionPane.YES_NO_CANCEL_OPTION); 


            if (b==JOptionPane.YES_OPTION){
                    file_save();
            if(t.getText().equals("") || t.getText().equals(content)){System.exit(0);
            }
                
                }
            else if(b==JOptionPane.NO_OPTION)
                    System.exit(0);
          		
    	}
    }
    
    public void edit_undo() {
        if( undo.canUndo())
        {
            try
            {
                undo.undo();
            }
            catch(CannotUndoException e)
            {                
            }
        }           
    }
    
    public void edit_redo(){
        if( undo.canRedo())
        {
            try
            {
                undo.redo();
            }
            catch(CannotRedoException e)
            {                
            }
        }
    }
    
    public void edit_cut(){
        t.cut();
    }
    
    public void edit_copy(){
        t.copy();
    }
    
    public void edit_paste(){
        t.paste();
    }
    
    public void edit_delete(){
        String temp = t.getText();
        t.setText(temp.substring(0, t.getSelectionStart())+temp.substring(t.getSelectionEnd()));
    }
    
    public void edit_find(){
        finder.setVisible(true);
        finder.setTitle("Find");
    }
    
    public void edit_find_next(){
        finder.find_next();
    }
    
    public void edit_replace(){
        finder.setVisible(true);finder.setTitle("Find/Replace");
    }
    
    public void edit_selectall(){
        t.selectAll();
    }
    
    public void edit_timedate(){
        
        try
        {
        int start = t.getSelectionStart();
        int end   = t.getSelectionEnd();        
        Calendar cal = Calendar.getInstance();
      String timeStamp  = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
                       
        String temp1 = t.getText().substring(0,start);
        String temp2 = t.getText().substring(end);        
        t.setText(temp1+" "+timeStamp+" "+temp2);
        
        }
        catch(NullPointerException e){}
    }
     
      
    public void format_font(){
        fc.setVisible(true);fc.setTitle("Font Chooser");
    }
    
    public void str2uppr(){
        try
        {
        int start = t.getSelectionStart();
        int end   = t.getSelectionEnd();
        String temp1 = t.getText().substring(0,start);
        String temp2 = t.getText().substring(end);
        String conv  = t.getSelectedText().toUpperCase();
        t.setText(temp1+conv+temp2);
        t.select(start, end);
        }
        catch(NullPointerException e){}
    }
    
    public void str2lwr(){
        try
        {
        int start = t.getSelectionStart();
        int end   = t.getSelectionEnd();
        String temp1 = t.getText().substring(0,start);
        String temp2 = t.getText().substring(end);
        String conv  = t.getSelectedText().toLowerCase();
        t.setText(temp1+conv+temp2);
        t.select(start, end);
        }
        catch(NullPointerException e){}
    }
    
    public void format_wordwarp(){
        if(t.getLineWrap()==false)
            t.setLineWrap(true);
        else
            t.setLineWrap(false);
    }
    
    public void help_about(){
        abt.setVisible(true);abt.setTitle("About");
    }

    @Override
    public synchronized void addWindowListener(WindowListener l) {
        super.addWindowListener(l);file_close();
    }
   
  
   
    
}
class TextFilter implements FileFilter {

  public boolean accept(File f) {
    if (f.isDirectory())
      return true;
    String s = f.getName();
    int i = s.lastIndexOf('.');

    if (i > 0 && i < s.length() - 1)
      if (s.substring(i + 1).toLowerCase().equals("txt"))
        return true;

    return false;
  }

  public String getDescription() {
    return "Accepts txt files only.";
  }
}

