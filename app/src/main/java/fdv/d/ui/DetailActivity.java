package fdv.d.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fdv.d.R;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_acrivity);
        // Add DetailFragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container, new DetailFragment())
                    .commitNow();
    }
}
