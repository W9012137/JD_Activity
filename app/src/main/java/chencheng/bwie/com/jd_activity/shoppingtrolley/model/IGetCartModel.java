package chencheng.bwie.com.jd_activity.shoppingtrolley.model;

import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.shoppingtrolley.bean.GetCartBean;

/**
 * Created by dell on 2018/4/26.
 */

public interface IGetCartModel {
    void getCartGW(String uid, NetListenter<GetCartBean> netListenter);
}
