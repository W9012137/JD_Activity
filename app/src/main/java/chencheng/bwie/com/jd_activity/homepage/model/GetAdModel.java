package chencheng.bwie.com.jd_activity.homepage.model;

import chencheng.bwie.com.jd_activity.homepage.baen.GetAdBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/4/11.
 */

public class GetAdModel implements IGetAdModel {
    @Override
    public void getAd(final NetListenter<GetAdBean> netListenter) {
        Flowable flowable= RetrofitUtils.getServerApi().getAd();
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<GetAdBean>() {

                    @Override
                    public void accept(GetAdBean getAdBean) throws Exception {
                        netListenter.onSccess(getAdBean);
                    }
                });
    }
}
