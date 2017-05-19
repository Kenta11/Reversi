// Reversi Program

import java.awt.Point;

class Reversi{
  private Model M;
  private View V;
  private Point index;

  public Reversi(){
    M = new Model();
    V = new View();
  }

  public void play(){
    while(M.playable()){
      do{
        index = V.getClickedIndex();
      }while(M.judge(index) == false);
      M.putCoin(index);
      M.reverceCoin(index);
      V.updateButton(M.getTable());
      M.changePlayer();
    }
  }
}
