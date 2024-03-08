package ekke.azft2i.azft2i_chess_twoplayer_20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameStartActivity extends AppCompatActivity {

    private EditText whitePlayerEditText;
    private EditText blackPlayerEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

        whitePlayerEditText = findViewById(R.id.whitePlayerEditText);
        blackPlayerEditText = findViewById(R.id.blackPlayerEditText);

        Button backButtonGameStart = findViewById(R.id.backButtonGameStart);
        backButtonGameStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Az Activity bezárása és visszatérés az előző Activity-hez
            }
        });

        Button startGameButton = findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });


    }

    private void startGame() {
        String whitePlayerName = whitePlayerEditText.getText().toString().trim();
        String blackPlayerName = blackPlayerEditText.getText().toString().trim();

        // Ellenőrizzük, hogy a játékosok megadták-e a nevüket
        if (whitePlayerName.isEmpty() || blackPlayerName.isEmpty()) {
            // Ha valamelyik név üres, hibaüzenetet jelenítünk meg
            Toast.makeText(this, "Kérlek add meg mindkét játékos nevét", Toast.LENGTH_SHORT).show();
        } else {
            // Átnavigálás a GameActivity-re és átadása a játékos neveknek
            Intent intent = new Intent(GameStartActivity.this, GameActivity.class);
            intent.putExtra("WHITE_PLAYER_NAME", whitePlayerName);
            intent.putExtra("BLACK_PLAYER_NAME", blackPlayerName);
            startActivity(intent);
        }
    }
}
