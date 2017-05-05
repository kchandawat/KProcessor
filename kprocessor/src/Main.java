



/**
 *
 * @author Khush
 */
import ch.randelshofer.quaqua.QuaquaManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JDialog;
import javax.swing.UIManager;

        
   
public class Main   {
    private static File File;
    public static void main(String arg[]) throws Exception{
        
    
       
        try { 
          // set system properties here that affect Quaqua
          // for example the default layout policy for tabbed
          // panes:
              QuaquaManager.setProperty(
                 "Quaqua.tabLayoutPolicy","wrap"

             );

         // configure the class loader of the UIManager.
            
         // set the Quaqua Look and Feel in the UIManager.
             UIManager.setLookAndFeel(
               ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel()
             );
             notepad.setDefaultLookAndFeelDecorated(true);
             JDialog.setDefaultLookAndFeelDecorated(true);
          } catch (Exception e) {
              // take an appropriate action here
          e.printStackTrace();
          }
  final notepad mynote = new notepad();    

     try {if (arg[0]==null){}else{File a=new File(arg[0]);mynote.show();
    BufferedReader fg = new BufferedReader(new FileReader(a));
            StringBuffer str = new StringBuffer();
            String line;
            while((line = fg.readLine()) != null) // st is declared as string avobe
                str.append(line+"\n");
            mynote.t.setText(str.toString());
            mynote.content = mynote.t.getText();
            mynote.path = a.toString();
            mynote.setTitle(a.getName()+" - KProcessor");
            
    }  }catch(Exception e) {}
 
        mynote.createPopupMenu(); 
  mynote.setDefaultCloseOperation(mynote.DO_NOTHING_ON_CLOSE);     
 
mynote.addWindowListener(new WindowAdapter() {


                        public void windowClosing(WindowEvent e) {


                                mynote.file_exit();


                        }

           


                });

}
}