// Window for Reversi

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Point;

public class View implements MouseListener{
  private JFrame frame;
  private JPanel board;
  private JButton button[][];
  private Point clicked = new Point(3, 3);

  private ImageIcon nocoin = new ImageIcon("./res/nocoin.png");
  private ImageIcon black  = new ImageIcon("./res/black.png");
  private ImageIcon white  = new ImageIcon("./res/white.png");
  private int width = 100;

  // Default Constructor
  public View(){
    frame = new JFrame();
    frame.setTitle("Reversi");
    frame.getContentPane().setPreferredSize(new Dimension(width * 8, width * 8));
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    InitButton();
    frame.setVisible(true);
  }

  public void InitButton(){
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
        button[y][x].setBounds(x * width, y * width, width, width);
	button[y][x].addMouseListener(this);
	button[y][x].setActionCommand(Integer.toString(x) + "," + Integer.toString(y));
	p.add(button[y][x]);
      }
    }
  }

  public void updateButton(int x, int y, int attribute){
    switch(attribute){
      case Model.BLACK:   button[y][x].setIcon(black);
                          break;
      case Model.WHITE:   button[y][x].setIcon(white);
                          break;
      case Model.NO_COIN: button[y][x].setIcon(nocoin);
                          break;
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

  public Point getClickedIndex(){
    return clicked;
  }

  // mouse event method
  @Override
  public void mouseClicked(MouseEvent e){
    JButton clickedButton = (JButton)e.getComponent();
    String indexOfTheBoard[] = clickedButton.getActionCommand().split(",", 0);
    clicked = new Point(Integer.parseInt(indexOfTheBoard[0]), Integer.parseInt(indexOfTheBoard[1]));
    System.out.println("clicked on " + clicked.x + "," + clicked.y);
  }

  @Override
  public void mouseEntered(MouseEvent e){
  }

  @Override
  public void mouseExited(MouseEvent e){
  }

  @Override
  public void mousePressed(MouseEvent e){
  }

  @Override
  public void mouseReleased(MouseEvent e){
  }

}
