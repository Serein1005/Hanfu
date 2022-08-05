package com.myapp.hanfu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener{
    private Fragment_Community communityFrag=new Fragment_Community();
    private Fragment_Shop shopFrag=new Fragment_Shop();
    private Fragment_User userFrag=new Fragment_User();

    private ImageView mcommunity,mshop,muser;

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //隐藏系统自带的标题栏
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        initView();
        //默认社区页选中
        mcommunity.setImageResource(R.drawable.home1);
        switchFragment(communityFrag);

        mcommunity.setOnClickListener(this);
        mshop.setOnClickListener(this);
        muser.setOnClickListener(this);
    }
    public void initView(){
        mcommunity = (ImageView) findViewById(R.id.community);
        mshop = (ImageView) findViewById(R.id.shop);
        muser = (ImageView) findViewById(R.id.user);
        /*mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);*/
    }
    //切换Fragment
    public void switchFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        transaction.replace(R.id.my_fragment,fragment);
        transaction.commit();
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.community://社区
                //其他两个导航按钮设置未选中
                mshop.setImageResource(R.drawable.apps);
                muser.setImageResource(R.drawable.user);
                switchFragment(communityFrag);
                mcommunity.setImageResource(R.drawable.home1);
                break;
            case R.id.shop://淘逛
                mcommunity.setImageResource(R.drawable.home);
                muser.setImageResource(R.drawable.user);
                switchFragment(shopFrag);
                mshop.setImageResource(R.drawable.apps1);
                break;
            case R.id.user://用户
                mcommunity.setImageResource(R.drawable.home);
                mshop.setImageResource(R.drawable.apps);
                switchFragment(userFrag);
                muser.setImageResource(R.drawable.user1);
                break;

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
            default:
        }
        return true;
    }
}