package ekke.azft2i.azft2i_chess_twoplayer_20;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import ekke.azft2i.azft2i_chess_twoplayer_20.board.ChessBoard;


public class GameActivity extends AppCompatActivity {



    ChessBoard chessBoard;
    private boolean isWhiteMove;
    public LinearLayout whiteCapturedPiecesLayout; // singleton kell ?!?
    public LinearLayout blackCapturedPiecesLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // nevek és színek kinyerése az intentből
        String whitePlayerName = getIntent().getStringExtra("WHITE_PLAYER_NAME");
        String blackPlayerName = getIntent().getStringExtra("BLACK_PLAYER_NAME");

        // A nevek megjelenítése a megfelelő TextView-ekben
        TextView whitePlayerTextView = findViewById(R.id.whitePlayerTextView);
        //whitePlayerTextView.setText("@string/white_player_name " + whitePlayerName);
        whitePlayerTextView.setText(getResources().getString(R.string.white_player_name) + " " + whitePlayerName);

        TextView blackPlayerTextView = findViewById(R.id.blackPlayerTextView);
       // blackPlayerTextView.setText("@string/black_player_name " + blackPlayerName);
        blackPlayerTextView.setText(getResources().getString(R.string.black_player_name) + " " + blackPlayerName);

        chessBoard = new ChessBoard(this);
        isWhiteMove = true; // A játék kezdetén a fehér játékos kezd

        // figurák kirajzolása a sakktáblára
        FrameLayout chessBoardContainer = findViewById(R.id.chessBoard);
        chessBoard.drawPieces(chessBoardContainer);

//        LinearLayout whiteCapturedPiecesLayout = findViewById(R.id.whiteCapturedPiecesLayout);
//        LinearLayout blackCapturedPiecesLayout = findViewById(R.id.blackCapturedPiecesLayout);
        initializeCapturedPiecesLayouts();




    }



    public void switchTurn() {
        isWhiteMove = !isWhiteMove; // Játékosváltás
    }


    // jelenleg 16 helyre működik, de dimanikusan kellene, lehet több mint 16 a figurák száma, ha van gyalog átalakulás. 24 asszem optimális akkor is ha minde  gyalogot bevisz a vaddisznó
    private void initializeCapturedPiecesLayouts() {
        // Fekete játékos által elvesztett bábuk képeinek inicializálása
        this.blackCapturedPiecesLayout = findViewById(R.id.blackCapturedPiecesLayout);
        for (int i = 0; i < 24; i++) {
            ImageView capturedPieceImageView = new ImageView(this);
            //capturedPieceImageView.setImageResource(R.drawable.empty_piece);  // Üres kép inicializálása
            capturedPieceImageView.setLayoutParams(new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
            capturedPieceImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            blackCapturedPiecesLayout.addView(capturedPieceImageView);
        }

        // Fehér játékos
        this.whiteCapturedPiecesLayout = findViewById(R.id.whiteCapturedPiecesLayout);
        for (int i = 0; i < 24; i++) {
            ImageView capturedPieceImageView = new ImageView(this);
            //capturedPieceImageView.setImageResource(R.drawable.empty_piece);  // Üres kép inicializálása
            capturedPieceImageView.setLayoutParams(new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
            capturedPieceImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            whiteCapturedPiecesLayout.addView(capturedPieceImageView);
        }
//                ImageView tesztView = new ImageView(this);
//                ChessPiece tesztpiece = new Knight(1,1,Color.BLACK);
//                tesztView.setImageResource(tesztpiece.getImageFileName());
//             whiteCapturedPiecesLayout.addView(tesztView);
    }


}
