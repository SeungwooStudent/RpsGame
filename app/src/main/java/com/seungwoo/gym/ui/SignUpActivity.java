package com.seungwoo.gym.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.seungwoo.gym.model.GymManager;
import com.seungwoo.gym.model.Member;
import com.seungwoo.gym.R;

public class SignUpActivity extends AppCompatActivity {
    EditText editTextId;
    EditText editTextName;
    EditText editTextAge;
    EditText editTextPhoneNumber;
    EditText editTextDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        editTextName = (EditText) findViewById(R.id.tv_name);
        editTextAge= (EditText) findViewById(R.id.tv_age);
        editTextPhoneNumber = (EditText) findViewById(R.id.tv_phone_number);
        editTextDate = (EditText) findViewById(R.id.tv_date);

        GymManager gymManager = new GymManager();
        Button saveButton = (Button) findViewById(R.id.tv_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                String name = ""+editTextName.getText();
//                int age = Integer.parseInt(""+editTextAge.getText());
//                String phoneNumber = ""+editTextPhoneNumber.getText();
//                String date = ""+editTextDate.getText();
//
//                Member member = new Member(name,age,phoneNumber,date);
//
//                gymManager.addMember(member);
//                gymManager.printAll();

            }

        });



    }
}