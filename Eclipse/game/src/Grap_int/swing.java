package Grap_int;

import javax.swing.*;
import java.awt.event.*;

public class swing extends JFrame {

   public swing() {
      super("Mr Jack Pocket");

      WindowListener l = new WindowAdapter() {
         public void windowClosing(WindowEvent e){
            System.exit(0);
         }
      };

      JFrame f = new JFrame("ma fenetre");
      f.setSize(300,100);
      JPanel pannel = new JPanel(); 

      JLabel jLabel1 =new JLabel("Mon texte dans JLabel 1"); 

      JLabel jLabel2 =new JLabel("Mon texte dans JLabel 2"); 

      JButton bouton1 = new JButton("Bouton1");
      bouton1.addActionListener( new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            pannel.add(jLabel1);
            pannel.add(jLabel2);
            f.getContentPane().add(pannel);
         }
      });

      pannel.add(bouton1);
      f.getContentPane().add(pannel);
      f.setVisible(true);
   }

   public static void main(String [] args){
      JFrame frame = new swing();
   }
}