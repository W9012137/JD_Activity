package chencheng.bwie.com.jd_activity.discover.model;


import chencheng.bwie.com.jd_activity.discover.bean.LefteBean;
import chencheng.bwie.com.jd_activity.discover.bean.RightBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/4/17.
 */

public class LeftModel implements ILeftModel {
    @Override
    public void getLeft(final NetListenter<LefteBean> netListenter) {
        Flowable flowable= RetrofitUtils.getServerApi().leftBean();
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<LefteBean>() {

                    @Override
                    public void accept(LefteBean lefteBean) throws Exception {
                        netListenter.onSccess(lefteBean);
                    }
                });
    }

    @Override
    public void getCid(String cid, final NetListenter<RightBean> netListenter) {
        Flowable flowable= RetrofitUtils.getServerApi().products(cid);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RightBean>() {

                    @Override
                    public void accept(RightBean rightBean) throws Exception {
                        netListenter.onSccess(rightBean);
                    }


                });
    }
}
