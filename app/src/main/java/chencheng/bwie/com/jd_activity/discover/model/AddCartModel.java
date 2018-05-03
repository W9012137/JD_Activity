package chencheng.bwie.com.jd_activity.discover.model;

import java.util.HashMap;

import chencheng.bwie.com.jd_activity.discover.bean.AddCartBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/4/26.
 */

public class AddCartModel implements IAddCartModel {
    @Override
    public void getAddCart(String pid, String uid,  final NetListenter<AddCartBean> netListenter) {
         HashMap<String, String> map = new HashMap<>();
         map.put("pid",pid);
        map.put("uid",uid);
        Flowable flowable= RetrofitUtils.getServerApi().addCart("product/addCart",map,"android");
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<AddCartBean>() {

                    @Override
                    public void accept(AddCartBean addCartBean) throws Exception {
                        netListenter.onSccess(addCartBean);
                    }


                });
    }
}
