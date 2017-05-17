// Reversi Program

class Reversi{
  private Model M;
  private View V;
  private int indexX;
  private int indexY;

  public Reversi(){
    M = new Model();
    V = new View();
  }

  public void play(){
    while(M.playable()){
      do{
        indexX = V.getClickedIndexX();
        indexY = V.getClickedIndexY();
      }while(M.judge(indexX, indexY) == false);
      M.putCoin(indexX, indexY);
      M.reverceCoin(indexX, indexY);
      M.changePlayer();
      V.updateButton(M.getTable());
    }
  }
}
