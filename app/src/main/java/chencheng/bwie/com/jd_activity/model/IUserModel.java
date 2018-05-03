package chencheng.bwie.com.jd_activity.model;

import chencheng.bwie.com.jd_activity.bean.UserBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/11.
 */

public interface IUserModel {
    void getUser(String uid, NetListenter<UserBean> netListenter);
}
