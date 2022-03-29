package com.seungwoo.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GameSignUpActivity extends AppCompatActivity {
    GameManager gameManager;
    EditText editTextId;
    EditText editTextName;
    EditText editTextAge;
    EditText editTextPhoneNumber;
    EditText editTextDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamesignup);


        EditText editTextId = (EditText) findViewById(R.id.game_id);
        EditText editTextPassWord = (EditText) findViewById(R.id.game_password);
        EditText editTextPassWordCheck = (EditText) findViewById(R.id.password_check);
        EditText editTextDate = (EditText) findViewById(R.id.game_name);

        gameManager = new GameManager();
        Button singUpSaveButton = (Button) findViewById(R.id.game_save_button);
        singUpSaveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String id = ""+editTextId.getText();
                String passWord = ""+editTextPassWord.getText();
                String passWordCheck = (""+editTextPassWordCheck.getText());
                String name = ""+editTextName.getText();


                GameMember gamemember = new GameMember(id,passWord,passWordCheck,name);

                gameManager.addMember(gamemember);


            }

        });



    }
}