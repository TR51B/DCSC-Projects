import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
  public static void main(String[] args) {
  JFrame frame = new JFrame("pluh");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,400);
    

    JLabel label = new JLabel("just a label");
    label.setHorizontalAlignment(JLabel.CENTER);
    frame.add(label);
    
    JButton button = new JButton("touch me");
    //button.addActionListener(e -> label.setText("still a label");});
    button.addActionListener(new ActionListener() {
      @Override  
      public void actionPerformed(ActionEvent e) {
        label.setText("still a label");
      }
    });
    frame.add(button, BorderLayout.SOUTH);
    

    frame.getContentPane().setBackground(Color.CYAN);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}

