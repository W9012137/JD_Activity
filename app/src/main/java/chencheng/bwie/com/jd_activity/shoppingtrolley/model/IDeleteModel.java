package chencheng.bwie.com.jd_activity.shoppingtrolley.model;

import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.shoppingtrolley.bean.DeleteBean;

/**
 * Created by dell on 2018/4/28.
 */

public interface IDeleteModel {
    void Getdelete(String uid, String pid, NetListenter<DeleteBean> netListenter);
}
