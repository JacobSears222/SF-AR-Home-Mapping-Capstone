package com.hl3hl3.arcoremeasure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class furnitureDetail extends AppCompatActivity {

    private Button save_button, width_capture_button, length_capture_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_detail);
        save_button = findViewById(R.id.save_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Save detail
            }
        });

        width_capture_button = findViewById(R.id.width_capture_button);
        length_capture_button = findViewById(R.id.length_capture_button);

        View.OnClickListener arWidthClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arIntent = new Intent(view.getContext(), ArMeasureActivity.class);
                startActivityForResult(arIntent, 0);
            }
        };

        View.OnClickListener arLengthClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arIntent = new Intent(view.getContext(), ArMeasureActivity.class);
                startActivityForResult(arIntent, 1);
            }
        };

        width_capture_button.setOnClickListener(arWidthClickListener);
        length_capture_button.setOnClickListener(arLengthClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0)
        {
            double result = data.getDoubleExtra("RESULT", -1);

            TextView width = findViewById(R.id.width);
            width.setText("Width: " + result);
        }
        else if(requestCode == 1)
        {
            double result = data.getDoubleExtra("RESULT", -1);

            TextView width = findViewById(R.id.length);
            width.setText("Length: " + result);
        }
    }
}
