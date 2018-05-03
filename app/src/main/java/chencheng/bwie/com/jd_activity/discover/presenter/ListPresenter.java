package chencheng.bwie.com.jd_activity.discover.presenter;

import chencheng.bwie.com.jd_activity.discover.bean.ProductsBean;
import chencheng.bwie.com.jd_activity.discover.model.IListModel;
import chencheng.bwie.com.jd_activity.discover.model.ListModel;
import chencheng.bwie.com.jd_activity.discover.view.IListView;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/18.
 */

public class ListPresenter {
    private IListView iListView;
    private IListModel iListModel;

    public ListPresenter(IListView iListView) {
        this.iListView = iListView;
        iListModel=new ListModel();
    }
    public void showl(final String pscid, String page, String sort ){
        iListModel.GetList(pscid,page,sort, new NetListenter<ProductsBean>() {
            @Override
            public void onSccess(ProductsBean productsBean) {

                iListView.ShowList(productsBean.getData(),pscid);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}
