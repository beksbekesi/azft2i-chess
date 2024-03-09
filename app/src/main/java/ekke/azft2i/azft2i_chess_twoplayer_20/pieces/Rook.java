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
    public boolean isValidMove(int newX, int newY, ChessPiece[][] board, boolean isWhiteMove) {
        // csak egy iranyba lephet
        if(newX != xPosition && newY!=yPosition){
            return false;
        }


        //ha vizszintes, megnézzük az összes mezőt az aktuális pozi és az end pozi között, hogy üres-e
        if(newX != xPosition){
            int direction = (newX-xPosition > 0) ? 1 : -1;
            for(int x = xPosition+direction; x!=newX; x = x + direction) {
                if(board[x][yPosition] != null){
                    return false;
                }
            }
        }else if(newY != yPosition){ //ha függöleges, ugyanez
            int direction = (newY-yPosition > 0) ? 1 : -1;
            for(int y = yPosition+direction; y!=newY; y = y + direction) {
                if(board[xPosition][y] != null){
                    return false;
                }
            }
        }
        // checkoljuk, ha üt akkor ellenséges bábut üt-e
        if(board[newX][newY] != null && board[newX][newY].getColor() == color){
            return false;
        }

        return true;
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