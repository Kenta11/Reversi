// Reverci Program

class Reverci{
  public static void main(String[] args){
    Model M = new Model();
    View V = new View();
    int indexX;
    int indexY;

    while(M.playable()){
      do{
        indexX = V.getClickedIndexX();
	indexY = V.getClickedIndexY();
      while(M.judge(indexX, indexY) == false);
      M.putcoin(V.getC
    }
    do{
      v.puttable(m);
      while(true){
        c.readcoord();
        if(m.infield(c.inx, c.iny))
          break;
      }
      m.putcoin(c.inx, c.iny);
      m.revercecoin(c.inx, c.iny);
      m.countcoin();
      m.player = -m.player;
    }while(m.black + m.white < 64);

  }
}
