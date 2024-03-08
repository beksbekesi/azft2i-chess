package ekke.azft2i.azft2i_chess_twoplayer_20.pieces;

import ekke.azft2i.azft2i_chess_twoplayer_20.R;

public class Queen extends ChessPiece {

    public Queen(int xPosition, int yPosition, Color color) {
        super(xPosition, yPosition, color);
    }
    /**
     * A metódus visszaadja logikai érték formájában, hogy a vezér léphet-e az adott célmezőre.
     * A vezér vízszintesen, függőlegesen vagy átlósan mozoghat tetszés szerint bármennyi mezőt.
     *
     * @param newX Az új X koordináta, ahová a vezér lépni szeretne.
     * @param newY Az új Y koordináta, ahová a vezér lépni szeretne.
     * @return Igaz, ha a lépés megtehető, egyébként hamis.
     */
    @Override
    public boolean isValidMove(int newX, int newY) {
        // A királynő vízszintesen, függőlegesen vagy átlósan bármennyi mezőt tud lépni
        int deltaX = Math.abs(newX - xPosition);
        int deltaY = Math.abs(newY - yPosition);

        return deltaX == deltaY || deltaX == 0 || deltaY == 0;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    public String getPieceName() {
        return "Vezér";
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
            return R.drawable.piece_queen_white;
        } else {
//            return R.drawable.piece_queen_black;
            return R.drawable.piece_queen_black_r180;
        }
    }


}