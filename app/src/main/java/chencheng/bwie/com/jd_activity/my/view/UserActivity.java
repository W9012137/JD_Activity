package chencheng.bwie.com.jd_activity.my.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.bean.UserBean;
import chencheng.bwie.com.jd_activity.my.persenter.UserPresenter;

/**
 * Created by dell on 2018/4/11.
 */

public class UserActivity extends AppCompatActivity implements View.OnClickListener,IFourView {
    private ImageView mIView;
    /**
     * 个人信息
     */
    private TextView mTextView;
    /**
     * 头像
     */
    private TextView mTextView2;
    private SimpleDraweeView mIvUser;
    /**
     * 称昵
     */
    private TextView mTextView3;
    /**
     * 京东
     */
    private TextView mName;
    UserPresenter presenter;
    SharedPreferences sp;
private String uid;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);
        presenter=new UserPresenter(this);
        sp=UserActivity.this.getSharedPreferences("user",0);
        uid=sp.getString("uid",uid+"");
        presenter.User(uid);
        initView();
    }

    private void initView() {
        mIView = (ImageView) findViewById(R.id.iView);
        mIView.setOnClickListener(this);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mIvUser = (SimpleDraweeView) findViewById(R.id.iv_user);
        mIvUser.setOnClickListener(this);
        mTextView3 = (TextView) findViewById(R.id.textView3);
        mName = (TextView) findViewById(R.id.name);
        mName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iView:
                startActivity(new Intent(UserActivity.this,FourFragment.class));
                break;
            case R.id.iv_user:
                break;
            case R.id.name:
                break;
        }
    }

    @Override
    public void showUser(UserBean.DataBean dataBeans, String uid) {
        if (dataBeans.getNickname()==null){
            mName.setText(dataBeans.getAppkey());
            mIvUser.setActualImageResource(R.drawable.user);
        }else{
            mName.setText(dataBeans.getNickname());
            mIvUser.setActualImageResource(Integer.parseInt(dataBeans.getIcon()));
        }
    }
}
