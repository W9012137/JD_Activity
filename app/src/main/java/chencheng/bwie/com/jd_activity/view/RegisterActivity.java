package chencheng.bwie.com.jd_activity.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.bean.RegisterBean;
import chencheng.bwie.com.jd_activity.presenter.RegisterPresenter;

/**
 * Created by dell on 2018/4/10.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,IRegisterview {
    private ImageView mImageView4;
    /**
     * 请输入账号
     */
    private EditText mPhone;
    /**
     * 请输入密码
     */
    private EditText mPwd;
    /**
     * 立即注册
     */
    private Button mButton;
    private String name;
    private String pwd;
    RegisterPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initView();
        presenter=new RegisterPresenter(this);
    }

    private void initView() {
        mImageView4 = (ImageView) findViewById(R.id.imageView4);
        mPhone = (EditText) findViewById(R.id.phone);
        mPwd = (EditText) findViewById(R.id.pwd);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button:
                name=mPhone.getText().toString().trim();
                pwd=mPwd.getText().toString().trim();
                presenter.register(name,pwd);
                break;
        }
    }

    @Override
    public void showregister(RegisterBean registerBean) {
        final String msg = registerBean.getMsg();
        Toast.makeText(RegisterActivity.this,msg,Toast.LENGTH_SHORT).show();
    }
}
