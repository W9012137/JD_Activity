package chencheng.bwie.com.jd_activity.discover.presenter;


import chencheng.bwie.com.jd_activity.discover.bean.DetailBean;
import chencheng.bwie.com.jd_activity.discover.view.IOne;
import chencheng.bwie.com.jd_activity.model.DetailModel;
import chencheng.bwie.com.jd_activity.model.IDetailModel;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/1/12.
 */

public class DetailPresenter {
    IOne iOne;
    private IDetailModel iDetailModel;

    public DetailPresenter(IOne iOne){
        this.iOne=iOne;
        iDetailModel = new DetailModel();
    }
    public void Show(final String pid){
     iDetailModel.GetDetail(pid,new NetListenter<DetailBean>() {
         @Override
         public void onSccess(DetailBean detailBean) {
             iOne.ShowDetail(detailBean,pid);
         }

         @Override
         public void onFailuer(Exception e) {

         }
     });
    }
}
