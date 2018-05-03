package chencheng.bwie.com.jd_activity.discover.model;

import chencheng.bwie.com.jd_activity.discover.bean.AddCartBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/26.
 */

public interface IAddCartModel {
void getAddCart(String pid, String uid,  NetListenter<AddCartBean>netListenter);
}
