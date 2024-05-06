package com.touch_exampledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2, et3, et4;
    private ImageView img;

    private float xDown = 0, yDown = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        xDown = event.getX();
                        yDown = event.getY();
                        et1.setText(xDown+"");
                        et2.setText(yDown+"");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float moveX = event.getX();
                        float moveY = event.getY();
                        et3.setText(moveX+"");
                        et4.setText(moveY+"");
                        float dx = moveX - xDown;
                        float dy = moveY - yDown;
                        img.setX(img.getX()+dx);
                        img.setY(img.getY()+dy);
                        break;

                }
                return true;
            }
        });
    }

    private void initView() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        img = findViewById(R.id.img);

    }
}