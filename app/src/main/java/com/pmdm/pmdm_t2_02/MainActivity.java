package com.pmdm.pmdm_t2_02;
import java.util.Locale;
import android.os.Bundle;
import android.widget.Toast;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private final String TAG = "pmdm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadDictionary();
    }

    private void loadDictionary(){
        Log.i(TAG, "idioma: " + Locale.getDefault().getLanguage());

        Log.i(TAG, this.getResources().getString(R.string.create));

        String words[] = this.getResources().getStringArray(R.array.words);

        for (String word: words){
            Log.i(TAG, word);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, R.string.stop, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Toast.makeText(this, R.string.restart, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, R.string.stop, Toast.LENGTH_LONG).show();
    }
}

