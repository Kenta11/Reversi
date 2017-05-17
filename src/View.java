// Window for Reversi

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event;

public class View implements MouseListener{
  private JFrame frame;
  private JPanel board;
  private JButton button[][];
  private int clicked[2] = new int[2];
  clicked[0] = 3;
  clicked[1] = 3;

  private ImageIcon nocoin = new ImageIcon("./res/nocoin.png");
  private ImageIcon black  = new ImageIcon("./res/black.png");
  private ImageIcon white  = new ImageIcon("./res/white.png");

  // Default Constructor
  public View(){
    frame = new JFrame();
    frame.setTitle("Reversi");
    frame.getContentPane().setPreferredSize(new Dimension(400, 400));
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container p = frame.getContentPane();
    p.setLayout(null);

    button = new JButton[8][8];
    for(int y = 0; y < 8; y++){
      for(int x = 0; x < 8; x++){
 	if((x < 3 || x > 4) || (y < 3 || y > 4)){
	  button[y][x] = new JButton(nocoin);
	}else if((x == 3 && y == 3) || (x == 4 && y == 4)){
	  button[y][x] = new JButton(black);
	}else if((x == 3 && y == 4) || (x == 4 && y == 3)){
	  button[y][x] = new JButton(white);
	}
        button[y][x].setBounds(x * 50, y * 50, 50, 50);
	button[y][x].addMouseListener(this);
	button[y][x].setActionCommand(Integer.toString(x) + "," + Integer.toString(y));
	p.add(button[y][x]);
      }
    }
    frame.setVisible(true);
  }

  public void update_button(int x, int y, int attribute){
    if(Model.BLACK){
      button[y][x] = new JButton(black);
    }else if(Model.WHITE){
      button[y][x] = new JButton(white);
    }else if(Model.NO_COIN){
      button[y][x] = new JButton(nocoin);
    }
  }

  public void update_button(int board[][]){
    for(int y = 0; y < 8; y++){
      for(int x = 0; x < 8; x++){
        update_button(y, x, board[y][x]);
      }
    }
    repaint();
  }

  public int[] getClickedIndex(){
    return clicked;
  }

  // mouse event method
  private mouseClicked(MouseEvent e){
    JButton clickedButton = (JButton)e.getComponent();
    String indexOfTheBoard[] = clickedButton.getActionCommand().split(",", 0);
    clicked[0] = indexOfTheBoard[0];
    clicked[1] = indexOfTheBoard[1];
  }

  private mouseEntered(MouseEvent e){
  }

  private mouseExited(MouseEvent e){
  }

  private mousePressed(MouseEvent e){
  }

  private mouseReleased(MouseEvent e){
  }

}
