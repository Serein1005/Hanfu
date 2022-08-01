package com.myapp.hanfu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText user;
    private EditText pwd;
    private Button login;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //隐藏系统自带的标题栏
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        user = (EditText) findViewById(R.id.et_user);
        pwd = (EditText) findViewById(R.id.et_pwd);
        login = (Button) findViewById(R.id.bt_login);
        register = (Button) findViewById(R.id.bt_register);
        login.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_login:
                if("admin".equals(user.getText().toString())&&"123456".equals(pwd.getText().toString())){
                    Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "用户名或密码错误，请重新输入！", Toast.LENGTH_SHORT).show();
                }
            case R.id.bt_register:
        }

    }
}