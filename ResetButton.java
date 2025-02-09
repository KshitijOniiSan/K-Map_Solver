import java.awt.Font;

public class ResetButton extends butt{
    ResetButton(){
        super(0,0);
        setBounds(270,400,60,30);
        setFont(new Font("Arial",Font.PLAIN,10));
        setText("Reset");
        setFocusable(false);
    }
}