package chencheng.bwie.com.jd_activity.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.bean.LogBean;
import chencheng.bwie.com.jd_activity.net.Toasts;
import chencheng.bwie.com.jd_activity.presenter.LoginPresenter;

/**
 * Created by dell on 2018/4/10.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILogView{
    /**
     * 请输入账号
     */
    private EditText mPhone;
    /**
     * 请输入密码
     */
    private EditText mPwd;
    /**
     * 登录
     */
    private Button mButton;
    /**
     * 注册
     */
    private Button mButton2;
    private ImageView mImageView2;
    private ImageView mImageView3;
    LoginPresenter presenter;
    private String name;
    private String pwd;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        presenter=new LoginPresenter(this);
        initView();
    }

    private void initView() {
        mPhone = (EditText) findViewById(R.id.phone);
        mPwd = (EditText) findViewById(R.id.pwd);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
        mImageView2 = (ImageView) findViewById(R.id.imageView2);
        mImageView2.setOnClickListener(this);
        mImageView3 = (ImageView) findViewById(R.id.imageView3);
        mImageView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button:
                name=mPhone.getText().toString().trim();
                pwd=mPwd.getText().toString().trim();
                presenter.log(name,pwd);
                break;
            case R.id.button2:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.imageView2:
                break;
            case R.id.imageView3:
                break;
        }
    }

    @Override
    public void showlofin(LogBean logBean) {
        final LogBean.DataBean data = logBean.getData();
        SharedPreferences sp=getSharedPreferences("user",0);
        sp.edit().putString("name", data.getMobile()+"")
                .putString("uid", data.getUid()+"")
                .putString("pwd", data.getPassword()+"")
                .putString("token", data.getToken()+"").commit();
        Toasts.showLong(this, "登录成功");
        final Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }
}
