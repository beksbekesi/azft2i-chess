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
    public boolean isValidMove(int newX, int newY) {
        int deltaX = Math.abs(newX - this.xPosition);
        int deltaY = newY - this.yPosition;


        // Fehér gyalog
        if (color == Color.WHITE) {
            // 1 mező előre, hopphopp
            if (deltaX == 1 && (deltaY == 0)) {
                return true;
            }
            // Kezdő pozícióban kettőt is léphet előre, ha az első pozícióban van még az első kordinátája
            else if (xPosition == 1 && deltaX == 2 && deltaY == 0) {
                return true;
            }
            // Ütés jobbra vagy balra
            else if (deltaX == 1 && Math.abs(deltaY) == 1 && xPosition < newX) {
                return true;
            }
        }

        // Fekete gyalog
        if (color == Color.BLACK) {
            // Előre lépés
            if (deltaX == 0 && (deltaY == -1)) {
                return true;
            }
            // Kezdő pozícióban kettőt is léphet előre
            else if (xPosition == 6 && deltaX == 2 && deltaY == 0) {
                return true;
            }
            // Ütés jobbra vagy balra
            else if (deltaX == 1 && deltaY == -1 && xPosition > newX) {
                return true;
            }
        }

        return false;
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
