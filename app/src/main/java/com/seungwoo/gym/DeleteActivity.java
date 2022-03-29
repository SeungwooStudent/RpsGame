package com.seungwoo.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    EditText editTextId;
    EditText editTextName;
    EditText editTextAge;
    EditText editTextPhoneNumber;
    EditText editTextDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);


        GymManager gymManager = new GymManager();
        Button deleteButton = (Button) findViewById(R.id.tv_delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setContentView(R.layout.activity_delete);
                String id = ""+editTextId.getText();
                boolean ischeckID = gymManager.isCheckID(id);
                if (!ischeckID) {
                    Toast.makeText(DeleteActivity.this, "일치하는 회원정보가 없습니다.", Toast.LENGTH_SHORT).show();
                }
                if (ischeckID) {
                    gymManager.deleteMember(id);
                    Toast.makeText(DeleteActivity.this, "삭제가 완료되었습니다", Toast.LENGTH_SHORT).show();
                }

            }



        });



    }
}