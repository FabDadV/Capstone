package fdv.d.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import fdv.d.R;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView addImage = findViewById(R.id.iv_add);
/*
        OnClickListener onClickImage = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "addImage");

            }
        };
*/
        FloatingActionButton fab = findViewById(R.id.save_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void AddThumb(View view) {
        Log.d("TAG", "addThumb");
    }

}
