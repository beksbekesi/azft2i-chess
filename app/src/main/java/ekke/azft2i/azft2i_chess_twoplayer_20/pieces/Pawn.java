package ekke.azft2i.azft2i_chess_twoplayer_20.pieces;

import ekke.azft2i.azft2i_chess_twoplayer_20.R;

public class Pawn extends ChessPiece {

    public Pawn(int xPosition, int yPosition, Color color) {
        super(xPosition, yPosition, color);
    }

    /**
     * Ellenőrzi, hogy a gyalog léphet-e az adott célmezőre.
     * A gyalog bábu az alábbiak szerint tehet érvényes lépést:
     * - A gyalog előre léphet egy mezőt vagy kettőt (az első lépésében).
     * - A gyalog átlósan egy mezővel előre üthet.
     *
     * @param newX Az új X koordináta, ahová a gyalog lépni szeretne.
     * @param newY Az új Y koordináta, ahová a gyalog lépni szeretne.
     * @return Igaz, ha a lépés megtehető, egyébként hamis.
     */
    @Override
    public boolean isValidMove(int newX, int newY, ChessPiece[][] board, boolean isWhiteMove) {
        int deltaX = Math.abs(newX - this.xPosition);
        int deltaY = Math.abs(newY - this.yPosition);
        int diffX = newX - this.xPosition;
        int diffY = newX - this.xPosition;





        if (color == Color.WHITE) {
            //ha egyértelműen szabálytalan lépés
            if((xPosition != 1 && diffX > 1)            //nem kezdőpoziban van és többet lépne mint 1
                    || (xPosition == 1 && diffX > 2)    //kezdőpoziban van és többet lépne mint 2
                    || deltaY > 1                       //bármilyen poziban, többet mozogna oldalra mint 1
                    || (deltaY == 1 && diffX != 1)      //ha ütni akar akkor a mozgás átlósan kell történjen
                    || diffX <=0){                      //ha hátrafele lépne
                return false;
            }

            //ha átlósan lép megnézzük szabályos-e
            if(deltaY == 1 && diffX == 1){
                ChessPiece attackedTarget = board[newX][newY];
                // ha nincs ott bábu, vagy saját bábut ütne, nem engedjük
                if(attackedTarget == null || attackedTarget.getColor() == this.getColor()){
                    return false;
                }
            }

            //ha előre lép megnézzük szabad-e
            if((diffX == 1 || diffX == 2) && deltaY==0) {
                for (int x = xPosition + 1; x <= newX; x++) {
                    if (board[x][yPosition] != null) {
                        return false;
                    }
                }
            }
        }

        // Fekete gyalog
        if (color == Color.BLACK) {
            if((xPosition != 6 && diffX < -1)         //nem kezdőpoziban van és többet lépne mint 1
                    || (xPosition == 6 && diffX < -2) //kezdőpoziban van és többet lépne mint 2
                    || deltaY > 1                    //bármilyen poziban, többet mozogna oldalra mint 1
                    || (deltaY == 1 && diffX != -1)  //ha ütni akar akkor a mozgás átlósan kell történjen
                    || diffX >= 0){                  ////ha hátrafele lépne
                return false;
            }

            //ha átlósan lép megnézzük szabályos-e
            if(deltaY == 1 && diffX == -1){
                // ha nincs ott bábu, vagy saját bábut ütne, nem engedjük
                ChessPiece attackedTarget = board[newX][newY];
                // ha nincs ott bábu, vagy saját bábut ütne, nem engedjük
                if(attackedTarget == null || attackedTarget.getColor() == this.getColor()){
                    return false;
                }
            }

            //ha előre lép megnézzük szabad-e
            if((diffX == -1 || diffX == -2) && deltaY==0) {
                for (int x = xPosition - 1; x >= newX; x--) {
                    if (board[x][yPosition] != null) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    @Override
    public String getSymbol() {
        return "P";
    }

    @Override
    public String getPieceName() {
        return "Gyalog";
    }

    /**
     * Visszaadja a bábu képének az "erőforrás" azonosítóját primitív int-ként.
     * A képnek az alkalmazás drawable mappájában kell lennie.
     * Ha a bábu fehér, akkor a fehér bábu képének az "erőforrás" azonosítója kerül visszaadásra,
     * ellenkező esetben a fekete bábu képének az "erőforrás" azonosítója.
     *
     * @return a bábu képének az erőforrás azonosítója (int) a képnek
     *         az alkalmazás erőforrás mappájában
     */
    @Override
    public int getImageFileName() {
        if (color == Color.WHITE) {
            return R.drawable.piece_pawn_white;
        } else {
//            return R.drawable.piece_pawn_black;
            return R.drawable.piece_pawn_black_r180;
        }
    }

}
