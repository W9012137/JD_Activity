package chencheng.bwie.com.jd_activity.model;

import chencheng.bwie.com.jd_activity.bean.LogBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/10.
 */

public interface ILogModel {
    void getLogin(String mobile, String password, NetListenter<LogBean> netListenter);


}
