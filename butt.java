import javax.swing.JButton;
import java.awt.Font;
public class butt extends JButton{
    int cnt=0;
    butt(int x,int y){
        setBounds(x,y,50,50);
        setFont(new Font("Arial",Font.PLAIN,20));
        setText("0");
        setFocusable(false);
    }
    void onclick(){
        setText(""+((++cnt)%2));
    }
    void reset(){
        cnt=-1;
        onclick();
    }
}
