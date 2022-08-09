package com.myapp.hanfu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.litepal.LitePal;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText userName1;
    private EditText password1;
    private EditText againPWD;
    private Button register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //隐藏系统自带的标题栏
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        initView1();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName1.getText().toString();
                String pwd = password1.getText().toString();
                String again = againPWD.getText().toString();
                if("".equals(name) || "".equals(pwd) || "".equals(again)){
                    Toast.makeText(RegisterActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else if(!again.equals(pwd)){
                    Toast.makeText(RegisterActivity.this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<User> users = LitePal.findAll(User.class);
                for (User user:users) {
                    if(user.getUser().equals(name)){
                        Toast.makeText(RegisterActivity.this, "该账号已注册", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                User user = new User();
                user.setUser(name);
                user.setPwd(pwd);
                user.save();
                Toast.makeText(RegisterActivity.this, "注册成功，即将为您跳转登录", Toast.LENGTH_SHORT).show();
                Intent toLoginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                toLoginIntent.putExtra("user",name);
                toLoginIntent.putExtra("pwd",pwd);
                startActivity(toLoginIntent);
            }
        });
    }
    public void initView1(){
        userName1 = (EditText) findViewById(R.id.et_registeruser);
        password1 = (EditText) findViewById(R.id.et_registerpwd);
        againPWD = (EditText) findViewById(R.id.et_registerpwd_again);
        register =(Button) findViewById(R.id.confirm_register);
    }
}
