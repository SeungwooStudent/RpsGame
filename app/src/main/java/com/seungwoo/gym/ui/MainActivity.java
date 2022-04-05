package com.seungwoo.gym.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.seungwoo.gym.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.menu02Button);
        Button deleteButton = findViewById(R.id.menu03Button);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
            }
            public void delete(View view){
                Intent intent2=new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(intent2);
            }

        });



    }

}