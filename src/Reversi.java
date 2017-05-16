
import java.io.*;
import javax.swing.JFrame;

class Reverce{
  public static void main(String[] args) throws IOException {
    Model M = new Model();
    View V = new View(M);
    Controll C = new Controll();
    JFrame frame = new JFrame("Reversi");

    frame.setVisible(true);

    do{
      V.PutTable(M);
      while(true){
        C.readCoord();
        if(M.InField(C.inX, C.inY))
          break;
      }
      M.putCoin(C.inX, C.inY);
      M.reverceCoin(C.inX, C.inY);
      M.countCoin();
      M.player = -M.player;
    }while(M.black + M.white < 64);

    V.PutTable(M);
    System.out.println("ゲーム終了！");
    if(M.black > M.white)
      System.out.println("blackの勝ち");
    else if(M.black < M.white)
      System.out.println("whiteの勝ち");
    else
      System.out.println("引き分け");

  }
}
