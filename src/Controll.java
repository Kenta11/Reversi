
import java.io.*;

class Controll{
  private int inX, inY;

  public controll(){

  }

  public void readCoord() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;

    do{
      str = br.readLine();

      inX = Character.getNumericValue(str.charAt(2)) - 1;
      inY = Character.getNumericValue(str.charAt(0)) - 1;
    }while(!(-1 < inX && inX < 8 && -1 < inY && inY < 8));
  }

  public int getX(){
    return inX;
  }

  public int getY(){
    return inY;
  }

}
