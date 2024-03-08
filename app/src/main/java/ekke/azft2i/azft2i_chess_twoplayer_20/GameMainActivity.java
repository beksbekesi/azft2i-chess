// switch kellene, de nagyon nehéz átadni neki a nézetet, marad egyelőre a spagetti

package ekke.azft2i.azft2i_chess_twoplayer_20;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class GameMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemain);

        Button exitButton = findViewById(R.id.exitBtn);
        Button startGameButton = findViewById(R.id.startGameButton);
        Button gameRulesButton = findViewById(R.id.gameRulesButton);
        Button aboutDevButton = findViewById(R.id.aboutDevButton);

        exitButton.setOnClickListener(view -> {

            finishAffinity();//finish();//finishAffinity();//finish();//
        });

        startGameButton.setOnClickListener(view -> {
            Intent intent = new Intent(GameMainActivity.this, GameStartActivity.class);
            startActivity(intent);
        });

        gameRulesButton.setOnClickListener(view -> {
            Intent intent = new Intent(GameMainActivity.this, ChessRulesActivity.class);
            startActivity(intent);
        });

        aboutDevButton.setOnClickListener(view -> {
            Intent intent = new Intent(GameMainActivity.this, DevelopersActivity.class);
            startActivity(intent);
        });
    }
}
