package chencheng.bwie.com.jd_activity.model;

import java.util.HashMap;

import chencheng.bwie.com.jd_activity.bean.UserBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/4/11.
 */

public class UserModel implements IUserModel {
    @Override
    public void getUser(String uid,final NetListenter<UserBean> netListenter) {
        final HashMap<String, String> map = new HashMap<>();
        map.put("uid",uid);
        Flowable flowable= RetrofitUtils.getServerApi().user("user/getUserInfo",map);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<UserBean>() {

                    @Override
                    public void accept(UserBean userBean) throws Exception {
                        netListenter.onSccess(userBean);
                    }


                });
    }
}
