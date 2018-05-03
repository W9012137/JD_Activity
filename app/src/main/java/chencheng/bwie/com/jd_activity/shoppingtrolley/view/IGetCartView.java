package chencheng.bwie.com.jd_activity.shoppingtrolley.view;

import java.util.List;

import chencheng.bwie.com.jd_activity.shoppingtrolley.bean.GetCartBean;

/**
 * Created by dell on 2018/4/26.
 */

public interface IGetCartView {
    public void showList(List<GetCartBean.DataBean> groupList, List<List<GetCartBean.DataBean.ListBean>> childList ,String uid);
}
