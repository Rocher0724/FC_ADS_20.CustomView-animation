package choongyul.android.com.study0308;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    SlideOutView slide;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slide = (SlideOutView) findViewById(R.id.slide);
        button = (Button) findViewById(R.id.button);

        slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SlideOutView)v).strike(true);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
                startActivity(intent);
            }
        });

    }
}
