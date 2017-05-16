// the Reverci model

import java.util.Random;

class model{
  private int[][] table = new int[8][8];
  private int black, white;
  private int player;
  private static int BLACK = 1;
  private static int WHITE = -1;
  private static int NO_COIN = 0;

  private boolean[][] enable = new boolean[8][8];

  // Default constructor
  // initializing all variable
  // decide the first player
  public model(){
    for(int i=0;i<8;i++){
      for(int j=0;j<8;j++)
        table[i][j] = NO_COIN;
    }
    table[3][3] = BLACK;
    table[3][4] = WHITE;
    table[4][3] = WHITE;
    table[4][4] = BLACK;
    black = 2;
    white = 2;
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

  // checking whether (x, y) is able to put a coin
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

//  //オセロの枚数を確認するメソッド
//  public void countCoin(){
//    black = 0;
//    white = 0;
//    for(int i=0;i<8;i++){
//      for(int j=0;j<8;j++){
//        if(table[i][j] == 1)
//          black++;
//        else if(table[i][j] == -1)
//          white++;
//      }
//    }
//  }

  private void enable_board(){
    for(int y = 0; y < 8; y++){
      for(int x = 0; x < 8; x++){
        enable[y][x] = judge[y][x];
      }
    }
  }

  public boolean get_enable(int y, int x){
    return enable[y][x];
  }

}
