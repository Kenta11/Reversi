// Reverci model

import java.util.Random;

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
    player = BLACK;
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

  // select color
  private void randomColor(){
    Random rm = new Random();
    if(rm.nextInt(100)%2 == 1)
      player = BLACK;
    else
      player = WHITE;
  }

  // put a coin on a board
  public void putCoin(int x, int y){
    table[y][x] = player;
  }

  // checking whether (x, y) is in a board
  public boolean InField(int x, int y){
    return (0 <= x && x < 8 && 0 <= y && y < 8);
  }

  // checking whether (x, y) is able to be put a coin
  public boolean judge(int x, int y){
    int dx,dy;	// displacement
    int curX,curY;  // current coordinate

    for(dx = -1;dx <= 1;dx++){
      for(dy = -1;dy <= 1;dy++){
        if(dx == 0 && dy == 0)
          continue;

        curX = dx;
        curY = dy;

        // checking reverce or not
        while(this.InField(x+curX, y+curY)){
          if(player == -table[x+curX][y+curY]){
            curX += dx;
            curY += dy;
          }else if(player == table[x+curX][y+curY] && (curX != dx || curY != dy)){
            return true;
          }else
            break;
        }
      }
    }
    return false;
  }

  // reverce coins
  public void reverceCoin(int x, int y){
    int dx,dy;	// displacement
    int curX,curY;  // current coordinate

    for(dx = -1;dx <= 1;dx++){
      for(dy = -1;dy <= 1;dy++){
        if(dx == 0 && dy == 0)
          continue;

        curX = dx;
        curY = dy;

        // enable to reverce coins or not
        while(this.InField(x+curX, y+curY)){
          if(table[x][y] == -table[x+curX][y+curY]){
            curX += dx;
            curY += dy;
          }else
            break;
        }

        // reverce
        if(this.InField(x+curX, y+curY)){
        	if(table[x][y] == table[x+curX][y+curY]){
        	  while(true){
                curX -= dx;
                curY -= dy;
                if(curX != 0 || curY != 0)
            	    table[x+curX][y+curY] = -table[x+curX][y+curY];
                else
              	    break;
        	  }
            }
        }

      }
    }
  }

  // update enable
  private void updateEnable(){
    for(int y = 0; y < 8; y++){
      for(int x = 0; x < 8; x++){
        enable[y][x] = judge(x, y);
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

  // getter for player;
  public int getPlayer(){
    return player;
  }

  // getter for table
  public int[][] getTable(){
    return table;
  }

}
