package com.myapp.hanfu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText user;
    private EditText pwd;
    private Button login;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //隐藏系统自带的标题栏
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        initView();
    }

    private void initView() {
        user = (EditText) findViewById(R.id.et_user);
        pwd = (EditText) findViewById(R.id.et_pwd);
        login = (Button) findViewById(R.id.bt_login);
        register = (Button) findViewById(R.id.bt_register);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_login:
                String name = user.getText().toString();
                String password = pwd.getText().toString();
                if ("".equals(name) || "".equals(password)) {
                    Toast.makeText(LoginActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<User> users = LitePal.findAll(User.class);
                for (User user : users) {
                    if (!user.getUser().equals(name)) {
                        Toast.makeText(LoginActivity.this, "账号未注册！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (user.getUser().equals(name) && !user.getPwd().equals(password)) {
                        Toast.makeText(LoginActivity.this, "账号或密码有误！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (user.getUser().equals(name) && user.getPwd().equals(password)) {
                        Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                break;
            case R.id.bt_register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
        }

    }
}