package com.gyf.immersionbar.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.BarParams;
import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.OSUtils;
import com.gyf.immersionbar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.drawer)
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        ImmersionBar.with(this)
//                .transparentStatusBar()  //透明状态栏，不写默认透明色
//                .transparentNavigationBar()  //透明导航栏，不写默认黑色(设置此方法，fullScreen()方法自动为true)
//                .transparentBar()             //透明状态栏和导航栏，不写默认状态栏为透明色，导航栏为黑色（设置此方法，fullScreen()方法自动为true）
//                .statusBarColor(R.color.colorPrimary)     //状态栏颜色，不写默认透明色
//                .navigationBarColor(R.color.colorPrimary) //导航栏颜色，不写默认黑色
//                .barColor(R.color.colorPrimary)  //同时自定义状态栏和导航栏颜色，不写默认状态栏为透明色，导航栏为黑色
//                .statusBarAlpha(0.3f)  //状态栏透明度，不写默认0.0f
//                .navigationBarAlpha(0.4f)  //导航栏透明度，不写默认0.0F
//                .barAlpha(0.3f)  //状态栏和导航栏透明度，不写默认0.0f
//                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
//                .fullScreen(true)      //有导航栏的情况下，activity全屏显示，也就是activity最下面被导航栏覆盖，不写默认非全屏
//                .hideBar(BarHide.FLAG_HIDE_BAR)  //隐藏状态栏或导航栏或两者，不写默认不隐藏
//                .setViewSupportTransformColor(toolbar) //设置支持view变色，支持一个view，不指定颜色，默认和状态栏同色，还有两个重载方法
//                .addViewSupportTransformColor(toolbar)  //设置支持view变色，可以添加多个view，不指定颜色，默认和状态栏同色，还有两个重载方法
//                .statusBarView(view)  //解决状态栏和布局重叠问题
//                .fitsSystemWindows(false)    //解决状态栏和布局重叠问题，默认为false，当为true时一定要指定statusBarColor()，不然状态栏为透明色
//                .statusBarColorTransform(R.color.orange)  //状态栏变色后的颜色
//                .navigationBarColorTransform(R.color.orange) //导航栏变色后的颜色
//                .barColorTransform(R.color.orange)  //状态栏和导航栏变色后的颜色
//                .removeSupportView()  //移除通过setViewSupportTransformColor()方法指定的view
//                .removeSupportView(toolbar)  //移除指定view支持
//                .removeSupportAllView() //移除全部view支持
//                .init();  //必须调用方可沉浸式
    }


    @OnClick({R.id.btn_pic_color, R.id.btn_pic, R.id.btn_color, R.id.btn_swipe_back, R.id.btn_fragment,
            R.id.btn_drawer, R.id.btn_over, R.id.btn_key_board, R.id.btn_status_hide, R.id.btn_navigation_hide, R.id.btn_bar_hide,
            R.id.btn_bar_show, R.id.btn_full, R.id.btn_bar_font_dark, R.id.btn_bar_font_light})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pic_color:
                startActivity(new Intent(MainActivity.this, PicAndColorActivity.class));
                break;
            case R.id.btn_pic:
                startActivity(new Intent(MainActivity.this, PicActivity.class));
                break;
            case R.id.btn_color:
                startActivity(new Intent(MainActivity.this, ColorActivity.class));
                break;
            case R.id.btn_swipe_back:
                startActivity(new Intent(MainActivity.this, BackActivity.class));
                break;
            case R.id.btn_fragment:
                startActivity(new Intent(MainActivity.this, FragmentActivity.class));
                break;
            case R.id.btn_drawer:
                drawer.openDrawer(Gravity.START);
                break;
            case R.id.btn_over:
                startActivity(new Intent(MainActivity.this, OverActivity.class));
                break;
            case R.id.btn_key_board:
                startActivity(new Intent(MainActivity.this, KeyBoardActivity.class));
                break;
            case R.id.btn_status_hide:
                ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_STATUS_BAR).init();
                break;
            case R.id.btn_navigation_hide:
                ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR).init();
                break;
            case R.id.btn_bar_hide:
                ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_BAR).init();
                break;
            case R.id.btn_full:
                BarParams barParams = ImmersionBar.with(this).getBarParams();
                if (barParams.fullScreen)
                    ImmersionBar.with(this).fullScreen(false).init();
                else
                    ImmersionBar.with(this).fullScreen(true).init();
                break;
            case R.id.btn_bar_show:
                ImmersionBar.with(this).hideBar(BarHide.FLAG_SHOW_BAR).init();
                break;
            case R.id.btn_bar_font_dark:
                ImmersionBar.with(this).statusBarDarkFont(true).init();
                break;
            case R.id.btn_bar_font_light:
                ImmersionBar.with(this).statusBarDarkFont(false).init();
                break;
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        drawer.closeDrawer(Gravity.START);
    }
}
