package ekke.azft2i.azft2i_chess_twoplayer_20.pieces;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Az absztrakt osztály a sakkfigurákhoz.
 * Az összes sakkfigura saját osztálya ebből az abstrakt osztályból származik.
 * Az absztakt ChessPiece ősosztály származhatna interfészből ...
 */
public abstract class ChessPiece {

    protected int xPosition;
    protected int yPosition;
    protected Color color;

    /**
     * Konstruktor a sakkfigura osztályhoz.
     *
     * @param xPosition Az figura kezdőpozíciójának X koordinátája.
     * @param yPosition Az figura kezdőpozíciójának Y koordinátája.
     * @param color     A figura színe (fehér vagy fekete).
     */
    public ChessPiece(int xPosition, int yPosition, Color color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }



    /**
     * A metódus visszaadja logikai érték formájában, hogy a figura léphet-e az adott célmezőre.
     *
     * @param x Az X koordináta, ahová a figura lépni szeretne.
     * @param y Az Y koordináta, ahová a figura lépni szeretne.
     * @return Igaz, ha a lépés megtehető, egyébként hamis.
     */
    public abstract boolean isValidMove(int x, int y);

    /**
     * Visszaadja a bábu szövegesen reprezentáló karaktert vagy karakterláncot.
     * A szimbólum:
     * a gyalog esetén ez "P" lesz.
     * stbstb, plusz a classokhoz a sajátja.?
     * @return a bábu szimbóluma
     */
    public abstract String getSymbol();

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Absztrakt metódus, amely visszaadja a figura elnevezését.
     *
     * @return A figura elnevezése
     */
    public abstract String getPieceName();

    /**
     * Absztrakt metódus, amely visszaadja a bábu képének a fájlnevét primitív int formában.
     *
     * @return a bábu képének a fájlneve
     */
    public abstract int getImageFileName();

    /**
     * Metódus, amely visszaadja, hogy a bábu fehér-e vagy sem. Vagyis a figura színét.
     *
     * @return igaz, ha a bábu fehér, egyébként hamis
     */
    public boolean isWhite() {
        return color ==Color.WHITE;
    }

    /**
     * Ez a metódus megadja az adott pozcióban lévő figura által elérhető összes lépést.
     * Ez a metódus megadja az összes mezőt ahová a figura a lépési szabályai szerint léphet.
     * A metódus nem veszi figyelembe, hogy az egyes mezőkön van-e fugura.
     *
     * @param board A sakktábla, amelyen az aktuális állapotot tárolja.
     * @return Egy halmaz azokkal a mezőkkel, ahova az adott bábu léphet .
     */
    public Set<Point> getPossibleAllMoves(ChessPiece[][] board) {
        Set<Point> possibleMoves = new HashSet<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isValidMove(i, j)) {
                    possibleMoves.add(new Point(i, j));
                }
            }
        }
        return possibleMoves;
    }

    /**
     * Ez a metódus megadja az adott pozcióban lévő figura által megtehető összes lépést.
     * Ez a metódus az összes megtehető lépést adja vissza, beleértve az ellenséges bábuk ütését is.
     *
     * @param board A sakktábla, amelyen az aktuális állapot van.
     * @return Egy lista azokkal a mezőkkel, ahova az adott bábu léphet, beleértve az ütéseket is.
     */
    public List<int[]> getAllPossibleMovesNEW(ChessPiece[][] board) {
        return null;
    }
    /**
     * Ez a metódus az összes olyan mezőt adja vissza, ahova az adott bábu üthet egy lépéssel.
     *
     * @param board A sakktábla, amelyen az aktuális állapot van.
     * @return Egy lista azokkal a mezőkkel, ahova az adott bábu üthet.
     */
    public List<int[]> getAllCapturingMoves(ChessPiece[][] board) {
        List<int[]> possibleCapturingMoves = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isValidMove(i, j)) {
                    if (isValidCapturingMove(i, j, board)) {
                        possibleCapturingMoves.add(new int[]{i, j});
                    }
                }
            }
        }

        return possibleCapturingMoves;
    }
    /**
     * A metódus visszaadja, hogy az kiválasztott figura üthet-e a célmezőre.
     *
     * @param x Az új X koordináta, ahová a bábu ütni szeretne.
     * @param y Az új Y koordináta, ahová a bábu ütni szeretne.
     * @param board A jelenlegi sakktábla állása, ahol az adott bábu mozog.
     * @return Igaz, ha az adott lépés érvényes ütés, egyébként hamis.
     */
    private boolean isValidCapturingMove(int x, int y, ChessPiece[][] board) {
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {
            return false;
        }

        ChessPiece targetPiece = board[x][y];

        // Amennyiben a célmegő üres, akkor nem üthetünk.
        if (targetPiece == null) {
            return false;
        }

        // Amennyiben a célmegőn saját bábu van, akkor nem üthetünk.
        if (targetPiece.getColor() == this.color) {
            return false;
        }

        // Ellenőrizzük, hogy az adott bábu érvényesen tud-e lépni az adott célmezőre.
        if (!isValidMove(x, y)) {
            return false;
        }

        // Ellenőrizzük, hogy nincs-e takarás az ütés útvonalán
        int deltaX = Math.abs(x - this.xPosition);
        int deltaY = Math.abs(y - this.yPosition);

        // A bástya csak egyenesen tud ütni, tehát az X vagy az Y koordináta változik
        if (deltaX != 0 && deltaY != 0) {
            return false;
        }

        int dirX = Integer.compare(x, this.xPosition);
        int dirY = Integer.compare(y, this.yPosition);

        int currX = this.xPosition + dirX;
        int currY = this.yPosition + dirY;

        while (currX != x || currY != y) {
            if (board[currX][currY] != null) {
                // Van takarás az ütés útvonalán, nem tud ütni
                return false;
            }
            currX += dirX;
            currY += dirY;
        }

        // Nincs takarás, érvényes ütés
        return true;
    }
}

