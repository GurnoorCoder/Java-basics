import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
 
public class GridCalculator extends JFrame implements ActionListener { 
    JTextField tf; 
    double a, b, result; 
    String operator; 
 
    GridCalculator() { 
        tf = new JTextField(); 
        tf.setEditable(false); 
        setLayout(new BorderLayout()); 
        add(tf, BorderLayout.NORTH); 
 
        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5)); 
        String[] buttons = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", 
"=", "C", "/" }; 
        for (String text : buttons) { 
            JButton btn = new JButton(text); 
            btn.addActionListener(this); 
            panel.add(btn); 
        } 
        add(panel, BorderLayout.CENTER); 
 
        setTitle("Calculator"); 
        setSize(300, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true); 
    } 
 
    public void actionPerformed(ActionEvent e) { 
        String command = e.getActionCommand(); 
 
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9')) { 
            tf.setText(tf.getText() + command); 
        } else if (command.equals("C")) { 
            tf.setText(""); 
        } else if (command.equals("=")) { 
            b = Double.parseDouble(tf.getText()); 
            switch (operator) { 
                case "+": result = a + b; break; 
                case "-": result = a - b; break; 
                case "*": result = a * b; break; 
                case "/": result = b != 0 ? a / b : 0; break; 
            } 
            tf.setText(String.valueOf(result)); 
        } else { 
            a = Double.parseDouble(tf.getText()); 
            operator = command; 
            tf.setText(""); 
        } 
    } 
 
    public static void main(String[] args) { 
        new GridCalculator(); 
    } 
} 
 
