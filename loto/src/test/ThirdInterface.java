package test;



import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
 
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument.Content;
 
public class ThirdInterface extends JFrame{
     
    JFrame pane = new JFrame();
     
    JPanel UpperPanel = new JPanel();
    JPanel BorderPanel = new JPanel();
    JPanel LeftPanel = new JPanel();
     
    //Upper tab
    JLabel space = new JLabel("            "); // add space
    JLabel space1 = new JLabel("            "); // add space
    JLabel label1 = new JLabel("Username: ");
    JLabel label11 = new JLabel("name");
    JLabel label2 = new JLabel("Oponent name: ");
    JLabel label22 = new JLabel("name");
    JLabel label = new JLabel();
    JLabel Timelabel = new JLabel();
    Locale alocal = new Locale("CANADA");
    Date today = new Date();
    DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT,alocal);
    String dateOut = dateFormatter.format(today);
    Calendar cal = new GregorianCalendar();
    int hour12 = cal.get(Calendar.HOUR);            // 0..11
    int hour24 = cal.get(Calendar.HOUR_OF_DAY);     // 0..23
    int min = cal.get(Calendar.MINUTE);             // 0..59
    int sec = cal.get(Calendar.SECOND);             // 0..59
    int ms = cal.get(Calendar.MILLISECOND);         // 0..999
    int ampm = cal.get(Calendar.AM_PM);             // 0=AM, 1=PM
    String time = ""+ hour12 + ":"+ min + ":"+ sec ;
     
    // Left tab
    JLabel myInfo = new JLabel("My Information:");
    JTextArea list = new JTextArea(10,25);
    JButton scores = new JButton(" My Scores ");
    JButton oponents = new JButton(" My Oponents ");
    JButton logout = new JButton(" Logout ");
     
    // Board
    private int currentPlayer;
    JLabel[][] slots = new JLabel[7][6];
     
     
     
    public void init(){
         
         
        pane.getContentPane();
        pane.setLayout(new BorderLayout());
        pane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.pack();
        pane.setVisible(true);
          
        // Upper tab
        UpperPanel.setLayout(new CardLayout());
        UpperPanel.add(label1);
        UpperPanel.add(label11);
        UpperPanel.add(space);
        UpperPanel.add(label2);
        UpperPanel.add(label22);
        UpperPanel.add(space1);
        UpperPanel.add(label);
        UpperPanel.add(Timelabel);
         
        // Border
        BorderPanel.setLayout(new GridLayout(7,7));
        for (int row=5; row>=0; row--) {
            for (int column=0; column<7; column++) {
            slots[column][row] = new JLabel();
            slots[column][row].setFont(new Font("SansSerif", Font.BOLD, 18));
            slots[column][row].setHorizontalAlignment(SwingConstants.CENTER);
            slots[column][row].setBorder(new LineBorder(Color.BLACK));
            BorderPanel.add(slots[column][row]);
            }
        }
        currentPlayer = 1;
         
        // Left tab
        LeftPanel.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
//        LeftPanel.add(Box.createVerticalStrut(10));
        myInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
//        LeftPanel.add(myInfo);
        list.setAlignmentX(Component.CENTER_ALIGNMENT);
        list.setEditable(false);
//        LeftPanel.add(list);
//        LeftPanel.add(Box.createVerticalStrut(10));
      /*  scores.setAlignmentX(Component.CENTER_ALIGNMENT);
        LeftPanel.add(scores);
        oponents.setAlignmentX(Component.CENTER_ALIGNMENT);
        LeftPanel.add(oponents);
        logout.setAlignmentX(Component.CENTER_ALIGNMENT);
        LeftPanel.add(logout);
         */
        pane.add(UpperPanel) ;
        pane.add(BorderPanel);
      //  pane.add(LeftPanel);
 
    }
     
     
    public static void main(String[] args){
        ThirdInterface ti = new ThirdInterface();
        ti.init();
         
    }
}
