package com.seungwoo.gym;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class GameLoginActivity extends AppCompatActivity {
    private EditText login_id, login_password;
    private Button login_Button, signup_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamelogin);

        login_id = findViewById(R.id.id_Input);
        login_password = findViewById(R.id.password_Input);

        signup_Button = findViewById(R.id.signup_Button);
        signup_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameLoginActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });


        login_Button = findViewById(R.id.login_Button);
        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserId = login_id.getText().toString();
                String UserPwd = login_password.getText().toString();

//                Response.Listener<String> responseListener = new Response.Listener<String>() {
//
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            boolean success = jsonObject.getBoolean("success");
//
//                            if (success) {//로그인 성공시
//
//                                String UserEmail = jsonObject.getString("UserEmail");
//                                String UserPwd = jsonObject.getString("UserPwd");
//                                String UserName = jsonObject.getString("UserName");
//
//                                Toast.makeText(getApplicationContext(), String.format("%s님 환영합니다.", UserName), Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(GameLoginActivity.this, GameActivity.class);
//
//                                intent.putExtra("UserEmail", UserEmail);
//                                intent.putExtra("UserPwd", UserPwd);
//                                intent.putExtra("UserName", UserName);
//
//                                startActivity(intent);
//
//                            } else {//로그인 실패시
//                                Toast.makeText(getApplicationContext(), "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
//                                return;
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//                LoginRequest loginRequest = new LoginRequest(UserEmail, UserPwd, responseListener);
//                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
//                queue.add(loginRequest);

            }
        });
    }
}
//}
