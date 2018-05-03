package chencheng.bwie.com.jd_activity.discover.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.discover.view.XqFragmenr.XqFragment1;
import chencheng.bwie.com.jd_activity.discover.view.XqFragmenr.XqFragment2;
import chencheng.bwie.com.jd_activity.discover.view.XqFragmenr.XqFragment3;

/**
 * Created by dell on 2018/4/25.
 */

public class DetaliActivity extends AppCompatActivity{

    private ImageView mFh;
    /**
     * 发现
     */
    private RadioButton mSp;
    /**
     * 详情
     */
    private RadioButton mXq;
    /**
     * 评价
     */
    private RadioButton mPj;
    private RadioGroup mTabMenu;
    private XqFragment1 xqFragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        initView();
    }

    private void initView() {
        xqFragment1 = new XqFragment1();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, xqFragment1).commit();
        mFh = (ImageView) findViewById(R.id.fh);
        mFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mSp = (RadioButton) findViewById(R.id.sp);
        mXq = (RadioButton) findViewById(R.id.xq);
        mPj = (RadioButton) findViewById(R.id.pj);
        mTabMenu = (RadioGroup) findViewById(R.id.tab_menu);
        mTabMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            private XqFragment3 xqFragment3;
            private XqFragment2 xqFragment2;

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.sp:
                        xqFragment1 = new XqFragment1();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, xqFragment1).commit();
                        break;
                    case R.id.xq:
                        xqFragment2 = new XqFragment2();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, xqFragment2).commit();
                        break;
                    case R.id.pj:
                        xqFragment3 = new XqFragment3();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, xqFragment3).commit();
                        break;
                }
            }
        });

    }



}
