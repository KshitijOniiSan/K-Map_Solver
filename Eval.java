import javax.swing.JButton;
import java.awt.Font;
//import java.awt.Color;

public class Eval extends JButton{
    Eval(){
        setBounds(400,400,75,30);
        setFont(new Font("Arial",Font.PLAIN,10));
        setText("Evaluate");
        setFocusable(false);
        //setBackground(new Color(0,255,0));
    }
    
}