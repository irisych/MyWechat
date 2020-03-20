package com.example.mywechat;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import android.app.Fragment;
import android.widget.ImageButton;
import android.widget.LinearLayout;




public class MainActivity extends Activity implements View.OnClickListener {

    private Fragment mTab01 = new weixinFragment();
    private Fragment mTab02 = new frdFragment();
    private Fragment mTab03 = new contactFragment();
    private Fragment mTab04 = new settingsFragment();

    private FragmentManager fm;

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabContact;
    private LinearLayout mTabSettings;
    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgContact;
    private ImageButton mImgSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
        initEvent();
        setSelect(0);
    }

    private void initFragment(){
        fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content,mTab01);
        transaction.add(R.id.id_content,mTab02);
        transaction.add(R.id.id_content,mTab03);
        transaction.add(R.id.id_content,mTab04);
        transaction.commit();
    }

    private void initEvent(){  //优化监听过程，将监听过程限定在四个linearlayout上面，节省内存，避免全屏监听
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabContact.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);

    }

    private void initView(){
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabContact = (LinearLayout) findViewById(R.id.id_tab_contact);
        mTabSettings = (LinearLayout) findViewById(R.id.id_tab_settings);

        mImgWeixin = (ImageButton) findViewById(R.id.id_tab_weinxin_img);
        mImgFrd = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mImgContact = (ImageButton) findViewById(R.id.id_tab_contact_img);
        mImgSettings = (ImageButton) findViewById(R.id.id_tab_settings_img);
    }

    private void setSelect(int i){
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                Log.d("setSelect","1");
                transaction.show(mTab01);
                mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(mTab02);
                mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(mTab03);
                mImgContact.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(mTab04);
                mImgSettings.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);

    }

    @Override
    public void onClick(View v) {   //给全活动监听一个响应函数

        resetimg();

        switch (v.getId()){
            case R.id.id_tab_weixin:
                setSelect(0);
                break;
            case R.id.id_tab_frd:
                setSelect(1);
                break;
            case R.id.id_tab_contact:
                setSelect(2);
                break;
            case R.id.id_tab_settings:
                setSelect(3);
                break;
            default:
                break;
        }

    }

    public void resetimg(){
        mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
        mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
        mImgContact.setImageResource(R.drawable.tab_address_normal);
        mImgSettings.setImageResource(R.drawable.tab_settings_normal);
    }
}
