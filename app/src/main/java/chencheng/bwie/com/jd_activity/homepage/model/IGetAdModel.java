package chencheng.bwie.com.jd_activity.homepage.model;

import chencheng.bwie.com.jd_activity.homepage.baen.GetAdBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/11.
 */

public interface IGetAdModel {
    void getAd(NetListenter<GetAdBean> netListenter);
}
