package chencheng.bwie.com.jd_activity.model;

import chencheng.bwie.com.jd_activity.discover.bean.DetailBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/25.
 */

public interface IDetailModel {
    void GetDetail(String pid, NetListenter<DetailBean> netListenter);
}
