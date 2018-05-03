package chencheng.bwie.com.jd_activity.discover.model;

import java.util.HashMap;

import chencheng.bwie.com.jd_activity.discover.bean.ProductsBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/4/18.
 */

public class ListModel implements IListModel {
    @Override
    public void GetList(String pscid,String page,String sort,final NetListenter<ProductsBean> netListenter) {
        final HashMap<String, String> map = new HashMap<>();
        map.put("pscid",pscid);
        map.put("page",page);
        map.put("sort",sort);
        Flowable flowable= RetrofitUtils.getServerApi().listrv("product/getProducts",map);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ProductsBean>() {

                    @Override
                    public void accept(ProductsBean productsBean) throws Exception {
                        netListenter.onSccess(productsBean);
                    }


                });
    }
}
