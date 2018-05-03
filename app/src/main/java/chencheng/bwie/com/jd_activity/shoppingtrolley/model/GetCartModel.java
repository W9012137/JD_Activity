package chencheng.bwie.com.jd_activity.shoppingtrolley.model;

import java.util.HashMap;

import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.net.RetrofitUtils;
import chencheng.bwie.com.jd_activity.shoppingtrolley.bean.GetCartBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/4/26.
 */

public class GetCartModel implements IGetCartModel {
    @Override
    public void getCartGW(String uid, final NetListenter<GetCartBean> netListenter) {
        final HashMap<String, String> map = new HashMap<>();
        map.put("uid",uid);
        Flowable flowable= RetrofitUtils.getServerApi().getCart("product/getCarts",map,"android" );
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GetCartBean>() {

                    @Override
                    public void accept(GetCartBean getCartBean) throws Exception {
                        netListenter.onSccess(getCartBean);
                    }


                });
    }
}
