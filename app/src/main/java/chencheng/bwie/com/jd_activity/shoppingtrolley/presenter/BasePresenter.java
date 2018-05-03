package chencheng.bwie.com.jd_activity.shoppingtrolley.presenter;

import java.util.ArrayList;
import java.util.List;

import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.shoppingtrolley.bean.GetCartBean;
import chencheng.bwie.com.jd_activity.shoppingtrolley.model.GetCartModel;
import chencheng.bwie.com.jd_activity.shoppingtrolley.model.IGetCartModel;
import chencheng.bwie.com.jd_activity.shoppingtrolley.view.IGetCartView;

/**
 * Created by dell on 2018/4/23.
 */

public class BasePresenter {
    private IGetCartView iview;
    private IGetCartModel iBaseModel;

    public BasePresenter(IGetCartView iview) {
        this.iview = iview;
        iBaseModel = new GetCartModel();
    }


    public void showl(final String uid) {
        iBaseModel.getCartGW(uid, new NetListenter<GetCartBean>() {
            @Override
            public void onSccess(GetCartBean baseBean) {
                List<GetCartBean.DataBean> dataBean = baseBean.getData();
                List<List<GetCartBean.DataBean.ListBean>> childList = new ArrayList<List<GetCartBean.DataBean.ListBean>>();
                for (int i = 0; i < dataBean.size(); i++) {
                    List<GetCartBean.DataBean.ListBean> datas = dataBean.get(i).getList();
                    childList.add(datas);
                }
                iview.showList(dataBean, childList,uid);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}
