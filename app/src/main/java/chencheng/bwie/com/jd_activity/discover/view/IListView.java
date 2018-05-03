package chencheng.bwie.com.jd_activity.discover.view;

import java.util.List;

import chencheng.bwie.com.jd_activity.discover.bean.ProductsBean;

/**
 * Created by dell on 2018/4/18.
 */

public interface IListView {
    void ShowList(List<ProductsBean.DataBean> dataBeans,String pscid);


}
