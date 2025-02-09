import java.awt.Color;
import java.awt.event.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class frame extends JFrame implements ActionListener{
    butt[][] b=new butt[4][4];
    int ch=4;
    int array[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    Eval Evaluate = new Eval();
    ResetButton Reset=new ResetButton();
    lab displaymessage = new lab("Answer",200,450);
    String[] options = {"4","3","2"};
    JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(options));

    frame(){
        setSize(600,600);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(32,250,255));
        comboBox.setBounds(200, 130, 140, 20);

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                b[i][j]=new butt(200+j*50,200+i*50);
                b[i][j].addActionListener(this);
            }
        }

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                add(b[i][j]);
            }
        }
        
        comboBox.addActionListener(this);
        Evaluate.addActionListener(this);
        Reset.addActionListener(this);

        add(new lab("K-Map Solver",200,0));
        add(Evaluate);
        add(comboBox);
        add(Reset);
        add(displaymessage);
        displaymessage.setOpaque(true);
        displaymessage.setBackground(new Color(100,100,100));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==comboBox){
            switch((comboBox.getSelectedItem()).toString()){
                case "2":
                    for(int i=0;i<4;i++){
                        for(int j=0;j<4;j++){
                            if(i<2&&j<2)
                                b[i][j].setVisible(true);
                            else b[i][j].setVisible(false);
                        }
                    }
                    break;
                case "3":
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        if(i<2)
                            b[i][j].setVisible(true);
                        else b[i][j].setVisible(false);
                    }
                }
                    break;
                case "4":
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        b[i][j].setVisible(true);
                    }
                }
            }
        }

        if(e.getSource()==Evaluate){
            switch(comboBox.getSelectedItem().toString()){
                case "2":
                    check2 c2=new check2(array);
                    displaymessage.setText(c2.anscheck2());
                    break;
                case "3":
                    check3 c3=new check3(array);
                    displaymessage.setText(c3.anscheck3());
                    break;
                case "4":
                    check4 c4=new check4(array);
                    displaymessage.setText(c4.anscheck4());
                    break;
            }
        }

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(e.getSource()==b[i][j]){
                    b[i][j].onclick();
                    array[i][j]=(array[i][j]+1)%2;
                }
                if(e.getSource()==Reset){
                    b[i][j].reset();
                    array[i][j]=0;
                }
                
            }
        }
    }
}
