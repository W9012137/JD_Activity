package chencheng.bwie.com.jd_activity.model;

import chencheng.bwie.com.jd_activity.bean.RegisterBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/10.
 */

public interface IRegisterModel {
    void getRegister(String mobile, String password, NetListenter<RegisterBean> netListenter);
}
