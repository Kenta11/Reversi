// Reverci Program

class Reverci{
  public static void main(String[] args){
    Model M = new Model();
    View V = new View();

    while(M.playable){
      
    }
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

  }
}
