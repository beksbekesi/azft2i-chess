package ekke.azft2i.azft2i_chess_twoplayer_20.pieces;

import ekke.azft2i.azft2i_chess_twoplayer_20.R;

public class Rook extends ChessPiece {
    public Rook(int xPosition, int yPosition, Color color) {
        super(xPosition, yPosition, color);
    }
    /**
     * A metódus visszaadja logikai érték formájában, hogy a bástya léphet-e az adott célmezőre.
     * A bástya vízszintesen vagy függőlegesen mozoghat tetszés szerint bármennyi mezőt.
     *
     * @param newX Az új X koordináta, ahová a bástya lépni szeretne.
     * @param newY Az új Y koordináta, ahová a bástya lépni szeretne.
     * @return Igaz, ha a lépés megtehető, egyébként hamis.
     */
    @Override
    public boolean isValidMove(int newX, int newY) {
        // A bástya csak vízszintesen vagy függőlegesen tud lépni bármennyi mezőt
        return newX == xPosition || newY == yPosition;
    }
    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public String getPieceName() {
        return "Bástya";
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
            return R.drawable.piece_rook_white;
        } else {
//            return R.drawable.piece_rook_black;
            return R.drawable.piece_rook_black_r180;
        }
    }
}