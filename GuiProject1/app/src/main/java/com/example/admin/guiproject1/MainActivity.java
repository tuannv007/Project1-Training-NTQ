package com.example.admin.guiproject1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsername,edtPassword;
    private ImageButton imbLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        edtUsername = (EditText) this.findViewById(R.id.edtUsername);
        edtPassword = (EditText) this.findViewById(R.id.edtPassword);
        imbLogin = (ImageButton) this.findViewById(R.id.btnLogin);
        imbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUsername.getText().toString().equals("admin") && edtPassword.getText().toString().equals("admin")){
                    Intent intent = new Intent(getApplicationContext(),AcessWeb.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),R.string.checkLogin,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
