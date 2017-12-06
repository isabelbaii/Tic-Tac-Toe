public class tttV4{

  static String[][] board = new String [3][3];

  public static void main(String[] args){


    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++){
        board[i][j] = "-";
      }
    }

    for (int i=0;i<3;i++) {
      for (int j=0; j<3; j++){
        TextIO.put(" "+board[i][j]);
      }
      TextIO.putf("%n");
    }
    int x;
    int y;
    int heqi=0;
    do{//method
      TextIO.put("next move for X");
      TextIO.put("\nx-axis:");
      x = TextIO.getlnInt();
      TextIO.put("\ny-axis:");
      y = TextIO.getlnInt();



      board[y][x] = "X";
      //we call the check method there

// below print out the board
      for (int i=0;i<3;i++) {//
        for (int j=0; j<3; j++){
          TextIO.put(" "+board[i][j]);
        }
        TextIO.putf("%n");
      }
      heqi++;

      if (!check()) {break;}
      if (heqi==9) {TextIO.put("Draw game!"); break;}

      TextIO.put("next move for O");// create the method print instruction
      TextIO.put("\nx-axis:");
      x = TextIO.getlnInt();
      TextIO.put("\ny-axis:");
      y = TextIO.getlnInt();
      board[y][x] = "O";

      for (int i=0;i<3;i++) { // print out the board
        for (int j=0; j<3; j++){
          TextIO.put(" "+board[i][j]);
        }
        TextIO.putf("%n");
      }
      heqi++;
    } while (check());
  }


  public static boolean check(){

// checking if anyone wins
    int count = 0;
    boolean[][] boardcheck = new boolean [3][3];


    for (int A = 0; A<3; A++){
      for (int B = 0; B<3; B++) {
        if (board[A][B].equals("X")) {
          boardcheck[A][B]=true;
        }
      }
    }
//check

    for (int k=0; k<3; k++) {
      for (int l=0; l<3; l++){
        if(boardcheck[k][l]){
          count++;
        }
      }
      if (count == 3){
        TextIO.put("X wins!");
        return false;

      } else {count = 0;}
    }

    for (int k=0; k<3; k++) {
      for (int l=0; l<3; l++){
        if(boardcheck[l][k]){
          count++;
        }
      }
      if (count == 3){
        TextIO.put("X wins!");
        return false;

      } else {count = 0;}
    }


    for (int l=0; l<3; l++){
      if(boardcheck[l][l]){
        count++;
      }
    }
    if (count == 3){
      TextIO.put("X wins!");
      return false;
    } else {count = 0;}

    for (int l=0; l<3; l++){
      if(boardcheck[l][2-l]){
        count++;
      }
    }
    if (count == 3){
      TextIO.put("X wins!");
      return false;
    } else {count = 0;}



    //repeat to check the other player
    count = 0;

    for ( int A = 0; A<3; A++){
      for ( int B = 0; B<3; B++) {

        boardcheck[A][B]=false;

      }
    }

    for ( int A = 0; A<3; A++){
      for (int B = 0; B<3; B++) {
        if (board[A][B].equals("O")){
          boardcheck[A][B]=true;
        }
      }
    }

    for ( int k=0; k<3; k++) {
      for (int  l=0; l<3; l++){
        if(boardcheck[k][l]){
          count++;
        }
      }
      if (count == 3){
        TextIO.put("O wins!");
        return false;

      } else {count = 0;}
    }

    for ( int k=0; k<3; k++) {
      for (int l=0; l<3; l++){
        if(boardcheck[l][k]){
          count++;
        }
      }
      if (count == 3){
        TextIO.put("O wins!");
        return false;

      } else {count = 0;}
    }


    for ( int l=0; l<3; l++){
      if(boardcheck[l][l]){
        count++;
      }
    }
    if (count == 3){
      TextIO.put("O wins!");
      return false;
    } else {count = 0;}

    for (int l=0; l<3; l++){
      if(boardcheck[l][2-l]){
        count++;
      }
    }
    if (count == 3){
      TextIO.put("O wins!");
      return false;
    } else {count = 0;}

    return true;
  }
}
public static boolean checkTaken(int x, int y){
  if(board[x][y].equals("X")||board[x][y].equals("O")){
    return false;
  }else{
    return true;
  }



}
