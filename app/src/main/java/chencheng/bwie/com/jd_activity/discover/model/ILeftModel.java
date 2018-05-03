package chencheng.bwie.com.jd_activity.discover.model;

import chencheng.bwie.com.jd_activity.discover.bean.LefteBean;
import chencheng.bwie.com.jd_activity.discover.bean.RightBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/17.
 */

public interface ILeftModel {
    void getLeft(NetListenter<LefteBean> netListenter);
    void getCid(String cid, NetListenter<RightBean> netListenter);
}
