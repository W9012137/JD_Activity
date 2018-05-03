package chencheng.bwie.com.jd_activity.model;

import java.util.HashMap;

import chencheng.bwie.com.jd_activity.bean.LogBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/4/10.
 */

public class LogModel implements ILogModel {
    @Override
    public void getLogin(String mobile, String password,final NetListenter<LogBean> netListenter) {
        final HashMap<String,String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        Flowable logBean= RetrofitUtils.getServerApi().login("user/login",map);
        logBean.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<LogBean>() {
                    @Override
                    public void accept(LogBean logBean) throws Exception {
                        netListenter.onSccess(logBean);
                    }
                });
    }
}
