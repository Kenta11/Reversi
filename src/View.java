// Window for Reversi

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;

public class View implements MouseListener{
  private JFrame frame;
  private JPanel board;
  private JButton button[][];
  private int clicked[] = {3, 3};

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

  public void updateButton(int x, int y, int attribute){
    switch(attribute){
      case Model.BLACK:   button[y][x] = new JButton(black);
      case Model.WHITE:   button[y][x] = new JButton(white);
      case Model.NO_COIN: button[y][x] = new JButton(nocoin);
      default: // have to throw exception...
    }
  }

  public void updateButton(int board[][]){
    for(int y = 0; y < 8; y++){
      for(int x = 0; x < 8; x++){
        updateButton(x, y, board[y][x]);
      }
    }
    frame.repaint();
  }

  public int getClickedIndexX(){
    return clicked[0];
  }

  public int getClickedIndexY(){
    return clicked[1];
  }

  // mouse event method
  public void mouseClicked(MouseEvent e){
    JButton clickedButton = (JButton)e.getComponent();
    String indexOfTheBoard[] = clickedButton.getActionCommand().split(",", 0);
    clicked[0] = Integer.parseInt(indexOfTheBoard[0]);
    clicked[1] = Integer.parseInt(indexOfTheBoard[1]);
  }

  public void mouseEntered(MouseEvent e){
  }

  public void mouseExited(MouseEvent e){
  }

  public void mousePressed(MouseEvent e){
  }

  public void mouseReleased(MouseEvent e){
  }

}
