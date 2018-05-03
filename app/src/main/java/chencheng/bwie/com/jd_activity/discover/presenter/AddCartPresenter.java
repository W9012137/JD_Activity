package chencheng.bwie.com.jd_activity.discover.presenter;

import chencheng.bwie.com.jd_activity.discover.bean.AddCartBean;
import chencheng.bwie.com.jd_activity.discover.model.AddCartModel;
import chencheng.bwie.com.jd_activity.discover.model.IAddCartModel;
import chencheng.bwie.com.jd_activity.discover.view.IAddCartView;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/26.
 */

public class AddCartPresenter {
    private IAddCartView iAddCartView;
    private IAddCartModel iAddCartModel;

    public AddCartPresenter(IAddCartView iAddCartView) {
        this.iAddCartView = iAddCartView;
        iAddCartModel=new AddCartModel();
    }
    public void getAdd(String uid,String pid){
        iAddCartModel.getAddCart(pid, uid, new NetListenter<AddCartBean>() {
            @Override
            public void onSccess(AddCartBean addCartBean) {
                iAddCartView.showAdd(addCartBean);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}
