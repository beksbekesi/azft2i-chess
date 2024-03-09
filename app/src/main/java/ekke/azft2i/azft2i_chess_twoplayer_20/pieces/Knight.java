package ekke.azft2i.azft2i_chess_twoplayer_20.pieces;

import ekke.azft2i.azft2i_chess_twoplayer_20.R;

public class Knight extends ChessPiece {

    public Knight(int xPosition, int yPosition, Color color) {
        super(xPosition, yPosition, color);
    }
    /**
     * Ellenőrzi, hogy a huszár léphet-e az adott célmezőre.
     * A huszár "L" alakban mozoghat.
     * A metódus a Math függvényre támaszkodva vágzi el a számítást.
     *
     * @param newX Az új X koordináta, ahová a huszár lépni szeretne.
     * @param newY Az új Y koordináta, ahová a huszár lépni szeretne.
     * @return Igaz, ha a lépés megtehető, egyébként hamis.
     */
    @Override
    public boolean isValidMove(int newX, int newY, ChessPiece[][] board, boolean isWhiteMove) {
        // A huszár "L" alakban tud lépni
        int deltaX = Math.abs(newX - xPosition);
        int deltaY = Math.abs(newY - yPosition);

        if(board[newX][newY] != null && board[newX][newY].getColor() == color){
            return false;
        }

        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
    }

    @Override
    public String getSymbol() {
        return "N";
    }

    @Override
    public String getPieceName() {
        return "Huszár";
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
            return R.drawable.piece_knight_white;
        } else {
            //return R.drawable.piece_knight_black;
            return R.drawable.piece_knight_black_r180;
        }
    }

}
