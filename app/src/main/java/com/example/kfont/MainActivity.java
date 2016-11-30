package com.example.kfont.themathchips;
//git is not letting me commit unless I change something - Jeff
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent continueIntent = new Intent(MainActivity.this, MainMenu.class);
                MainActivity.this.startActivity(continueIntent);
            }
        });
    }

}
