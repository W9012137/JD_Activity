package chencheng.bwie.com.jd_activity.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.adapter.MyFragmentAdapter;
import chencheng.bwie.com.jd_activity.classify.view.ThreeFragment;
import chencheng.bwie.com.jd_activity.discover.view.TwoFragment;
import chencheng.bwie.com.jd_activity.homepage.view.OneFragment;
import chencheng.bwie.com.jd_activity.my.view.FourFragment;
import chencheng.bwie.com.jd_activity.shoppingtrolley.view.FiveFragment;

public class Main2Activity extends FragmentActivity implements View.OnClickListener {

    private ViewAdapter mViewPager;
    private ImageView mIvS;
    private ImageView mIvF;
    private ImageView mIvX;
    private ImageView mIvG;
    private ImageView mIvW;
    List<Fragment> list;
     MyFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mViewPager = (ViewAdapter) findViewById(R.id.view_pager);
        mIvS = (ImageView) findViewById(R.id.iv_s);
        mIvS.setOnClickListener(this);
        mIvF = (ImageView) findViewById(R.id.iv_f);
        mIvF.setOnClickListener(this);
        mIvX = (ImageView) findViewById(R.id.iv_x);
        mIvX.setOnClickListener(this);
        mIvG = (ImageView) findViewById(R.id.iv_g);
        mIvG.setOnClickListener(this);
        mIvW = (ImageView) findViewById(R.id.iv_w);
        mIvW.setOnClickListener(this);
        list=new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreeFragment());
        list.add(new FiveFragment());
        list.add(new FourFragment());
        adapter=new MyFragmentAdapter(getSupportFragmentManager(),list);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
        mIvS.setImageResource(R.drawable.ac1);
        mIvF.setImageResource(R.drawable.abw);
        mIvX.setImageResource(R.drawable.aby);
        mIvG.setImageResource(R.drawable.abu);
        mIvW.setImageResource(R.drawable.ac2);
        mViewPager.setSaveEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.iv_s:
                mViewPager.setCurrentItem(0);
                mIvS.setImageResource(R.drawable.ac1);
                mIvF.setImageResource(R.drawable.abw);
                mIvX.setImageResource(R.drawable.aby);
                mIvG.setImageResource(R.drawable.abu);
                mIvW.setImageResource(R.drawable.ac2);

                break;
            case R.id.iv_f:
                mViewPager.setCurrentItem(1);
                mIvS.setImageResource(R.drawable.ac0);
                mIvF.setImageResource(R.drawable.abx);
                mIvX.setImageResource(R.drawable.aby);
                mIvG.setImageResource(R.drawable.abu);
                mIvW.setImageResource(R.drawable.ac2);
                break;
            case R.id.iv_x:
                mViewPager.setCurrentItem(2);
                mIvS.setImageResource(R.drawable.ac0);
                mIvF.setImageResource(R.drawable.abw);
                mIvX.setImageResource(R.drawable.abz);
                mIvG.setImageResource(R.drawable.abu);
                mIvW.setImageResource(R.drawable.ac2);
                break;
            case R.id.iv_g:
                mViewPager.setCurrentItem(3);
                mIvS.setImageResource(R.drawable.ac0);
                mIvF.setImageResource(R.drawable.abw);
                mIvX.setImageResource(R.drawable.aby);
                mIvG.setImageResource(R.drawable.abv);
                mIvW.setImageResource(R.drawable.ac2);
                break;
            case R.id.iv_w:
                mViewPager.setCurrentItem(4);
                mIvS.setImageResource(R.drawable.ac0);
                mIvF.setImageResource(R.drawable.abw);
                mIvX.setImageResource(R.drawable.aby);
                mIvG.setImageResource(R.drawable.abu);
                mIvW.setImageResource(R.drawable.ac3);
                break;
            default:
                break;
        }
    }
    @Override
    protected void onResume() {
        int id = getIntent().getIntExtra("userloginflag", 3);

        if (id == 1 ) {
            mViewPager.setCurrentItem(3);
            //3代表”我的京东“所在条目的位置，参考下面的源码即可理解
        }
        super.onResume();
    }
}
