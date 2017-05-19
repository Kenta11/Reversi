// Reverci model

import java.awt.Point;

class Model{
  private int[][] table = new int[8][8];
  private int black, white;
  private int player;
  public static final int BLACK = 1;
  public static final int WHITE = -1;
  public static final int NO_COIN = 0;

  private boolean[][] enable = new boolean[8][8];

  // Default constructor
  public Model(){
    initBoard();
    updateEnable();
  }

  // initialize a board
  private void initBoard(){
    for(int y = 0; y < 8; y++){
      for(int x = 0; x < 8; x++){
        table[y][x] = NO_COIN;
      }
    }
    table[3][3] = BLACK;
    table[3][4] = WHITE;
    table[4][3] = WHITE;
    table[4][4] = BLACK;
    black = 2;
    white = 2;
  }

  // put a coin on a board
  public void putCoin(Point p){
    table[p.y][p.x] = player;
  }

  // checking whether (x, y) is in a board
  public boolean InField(Point p){
    return (0 <= p.x && p.x < 8 && 0 <= p.y && p.y < 8);
  }

  // checking one direction whether you can put a coin in (x, y)
  private boolean judge(Point p, Point dp){
    int x = p.x;
    int y = p.y;
    int dx = dp.x;
    int dy = dp.y;

    // check arguments
    if(InField(new Point(x, y)) == false)
      return false;
    if((dx < -1 && dx > 1 && dy < -1 && dy > 1) || (dx == 0 && dy == 0))
      return false;

    // starting to check
    // checking the (x, y) coin
    if(table[y][x] != 0)
      return false;

    // checking the (x + dx, y + dy) coin
    int curX = x + dx;
    int curY = y + dy;
    if(InField(new Point(curX, curY)) == false)
      return false;
    if(player != -table[curY][curX])
      return false;

    // checking other coins
    for(int d = 1; d < 8; d++){
      curX += dx;
      curY += dy;

      if(InField(new Point(curX, curY)) == false)
        return false;

      if(player == -table[curY][curX]){
        continue;
      }else if(player == table[curY][curX]){
	return true;
      }else{
        return false;
      }
    }
    return false;
  }

  // checking whether you are able to put a coin
  public boolean judge(Point p){
    for(int dy = -1; dy <= 1; dy++){
      for(int dx = -1; dx <= 1; dx++){
        if(dx == 0 && dy == 0)
	  continue;
        if(judge(p, new Point(dx, dy)))
	  return true;
      }
    }
    return false;
  }

  // checking whether you are able to reverce coins
  private void reverceCoin(Point p, Point dp){
    int x = p.x;
    int y = p.y;
    int dx = dp.x;
    int dy = dp.y;

    // check arguments
    if(InField(p) == false)
      return;
    if((dx < -1 && dx > 1 && dy < -1 && dy > 1) || (dx == 0 && dy == 0))
      return;

    if(table[y][x] != player)
      return;

    int d = 1;
    while(true){
      if(InField(new Point(x + dx * d, y + dy * d)) == false)
        return;
      
      if(table[y + dy * d][x + dx * d] == player){
        break;
      }else if(table[y + dy * d][x + dx * d] == -player){
        d++;
      }else{
        return;
      }
    }

    if(d == 1)
      return;

    for(d = d - 1; d > 0; d--){
      table[y + dy * d][x + dx * d] = player;
    }
  }

  public void reverceCoin(Point p){
    int x = p.x;
    int y = p.y;

    for(int dy = -1; dy <= 1; dy++){
      for(int dx = -1; dx <= 1; dx++){
        if(dx == 0 && dy == 0)
	  continue;
        reverceCoin(new Point(x, y), new Point(dx, dy));
      }
    }
  }

  // update enable
  private void updateEnable(){
    for(int y = 0; y < 8; y++){
      for(int x = 0; x < 8; x++){
        enable[y][x] = judge(new Point(x, y));
      }
    }
  }

  // return enable[y][x]
  public boolean[][] getEnable(){
    return enable;
  }

  // whether you can put a coin
  public boolean playable(){
    for(int y = 0; y < 8; y++){
      for(int x = 0; x < 8; x++){
        if(enable[y][x]) return true;
      }
    }
    return false;
  }

  // change player
  public void changePlayer(){
    player *= -1;
  }

  // setter for player()
  public void setPlayer(int player){
    this.player = player;
  }

  // getter for player;
  public int getPlayer(){
    return player;
  }

  // getter for table
  public int[][] getTable(){
    return table;
  }

}
