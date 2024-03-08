package ekke.azft2i.azft2i_chess_twoplayer_20;

import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class DevelopersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        WebView webView = findViewById(R.id.developersWebView);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.loadUrl("file:///android_res/raw/developers_page.html");

        Button backButton = findViewById(R.id.dev_backButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(DevelopersActivity.this, GameMainActivity.class);
            startActivity(intent);
        });
    }
}
