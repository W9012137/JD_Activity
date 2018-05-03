package chencheng.bwie.com.jd_activity.model;

import java.util.HashMap;
import java.util.Map;

import chencheng.bwie.com.jd_activity.bean.RegisterBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/4/10.
 */

public class RegisterModel implements IRegisterModel {
    @Override
    public void getRegister(String mobile, String password, final NetListenter<RegisterBean> netListenter) {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        Flowable registerBean= RetrofitUtils.getServerApi().register("user/reg",map);
        registerBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterBean>() {
                    @Override
                    public void accept(RegisterBean registerBean) throws Exception {
                        netListenter.onSccess(registerBean);
                    }
                });
    }
}
