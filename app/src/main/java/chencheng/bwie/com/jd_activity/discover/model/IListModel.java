package chencheng.bwie.com.jd_activity.discover.model;

import chencheng.bwie.com.jd_activity.discover.bean.ProductsBean;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/18.
 */

public interface IListModel {
    void GetList(String pscid,String page,String sort , NetListenter<ProductsBean> netListenter);
}
