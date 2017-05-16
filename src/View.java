// Window for Reversi

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Container;

public class View{
  private JFrame frame;
  private JPanel board;
  private JButton button[][];

  private ImageIcon nocoin = new ImageIcon("./res/nocoin.png");
  private ImageIcon black  = new ImageIcon("./res/black.png");
  private ImageIcon white  = new ImageIcon("./res/white.png");

  // Default Constructor
  public View(){
    frame = new JFrame();
    frame.setTitle("Reversi");
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container p = frame.getContentPane();
    p.setLayout(null);

    button = new JButton[8][8];
    for(int y = 0; y < 8; y++){
      for(int x = 0; x < 8; x++){
 	if((x != 3 || x != 4) && (y != 3 || y != 4)){
	  button[y][x] = new JButton(nocoin);
	}else if((x == 3 && y == 3) || (x == 4 && y == 4)){
	  button[y][x] = new JButton(black);
	}else if((x == 3 && y == 4) || (x == 4 && y == 3)){
	  button[y][x] = new JButton(white);
	}
        button[y][x].setBounds(x * 50, y * 50, 50, 50);
	p.add(button[y][x]);
      }
    }
    frame.setVisible(true);
  }

//  public View(Model M){
//    frame = new JFrame();
//    frame.setTitle("Reversi");
//    frame.setSize(400, 430);
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    Container p = frame.getContentPane();
//    p.setLayout(null);
//
//    button = new JButton[8][8];
//    for(int y = 0; y < 8; y++){
//      for(int x = 0; x < 8; x++){
// 	if((x != 3 || x != 4) && (y != 3 || y != 4)){
//	  button[y][x] = new JButton(nocoin);
//	}else if((x == 3 && y == 3) || (x == 4 && y == 4)){
//	  button[y][x] = new JButton(black);
//	}else if((x == 3 && y == 4) || (x == 4 && y == 3)){
//	  button[y][x] = new JButton(white);
//	}
//        button[y][x].setBounds(x * 50, y * 50, 50, 50);
//	p.add(button[y][x]);
//      }
//    }
//    frame.setVisible(true);
//  }

}
