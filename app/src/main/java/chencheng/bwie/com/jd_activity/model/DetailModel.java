package chencheng.bwie.com.jd_activity.model;

import chencheng.bwie.com.jd_activity.discover.bean.DetailBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/4/25.
 */

public class DetailModel implements IDetailModel {
    @Override
    public void GetDetail(String pid, final NetListenter<DetailBean> netListenter) {
        Flowable flowable= RetrofitUtils.getServerApi().detail(pid,"android");
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DetailBean>() {

                    @Override
                    public void accept(DetailBean detailBean) throws Exception {
                        netListenter.onSccess(detailBean);
                    }


                });
    }
}
