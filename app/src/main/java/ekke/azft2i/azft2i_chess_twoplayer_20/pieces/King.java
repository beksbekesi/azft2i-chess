package ekke.azft2i.azft2i_chess_twoplayer_20.pieces;

import ekke.azft2i.azft2i_chess_twoplayer_20.R;

public class King extends ChessPiece {

    public King(int xPosition, int yPosition, Color color) {
        super(xPosition, yPosition, color);
    }
    /**
     * Ellenőrzi, hogy a király léphet-e az adott célmezőre.
     * A király egyetlen mezőt léphet bármely irányba.
     *
     * @param newX Az új X koordináta, ahová a király lépni szeretne.
     * @param newY Az új Y koordináta, ahová a király lépni szeretne.
     * @return Igaz, ha a lépés megtehető, egyébként hamis.
     */
    @Override
    public boolean isValidMove(int newX, int newY, ChessPiece[][] board, boolean isWhiteMove) {
        // A király az egyetlen mezőt tud lépni vízszintesen, függőlegesen vagy átlósan
        int deltaX = Math.abs(newX - xPosition);
        int deltaY = Math.abs(newY - yPosition);

        if(board[newX][newY] != null && board[newX][newY].getColor() == color){
            return false;
        }

        return (deltaX == 1 && deltaY == 0) || (deltaX == 0 && deltaY == 1) || (deltaX == 1 && deltaY == 1);
    }
    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    public String getPieceName() {
        return "Király";
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
            return R.drawable.piece_king_white;
        } else {
            //return R.drawable.piece_king_black;
            return R.drawable.piece_king_black_r180;
        }
    }
}