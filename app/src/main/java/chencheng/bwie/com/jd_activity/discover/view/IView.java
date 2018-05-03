package chencheng.bwie.com.jd_activity.discover.view;

import java.util.List;

import chencheng.bwie.com.jd_activity.discover.bean.LefteBean;
import chencheng.bwie.com.jd_activity.discover.bean.RightBean;

/**
 * Created by dell on 2018/4/17.
 */

public interface IView {
    void ShowLeft(List<LefteBean.DataBean> dataBeans);
     void showright(List<RightBean.DataBean> group, List<List<RightBean.DataBean.ListBean>> child);
}
