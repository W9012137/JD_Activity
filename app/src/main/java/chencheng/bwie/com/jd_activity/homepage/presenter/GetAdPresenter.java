package chencheng.bwie.com.jd_activity.homepage.presenter;

import chencheng.bwie.com.jd_activity.homepage.baen.GetAdBean;
import chencheng.bwie.com.jd_activity.homepage.model.GetAdModel;
import chencheng.bwie.com.jd_activity.homepage.model.IGetAdModel;
import chencheng.bwie.com.jd_activity.homepage.view.IOneView;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/11.
 */

public class GetAdPresenter {
    private IOneView iOneView;
    private IGetAdModel iGetAdModel;

    public GetAdPresenter(IOneView iOneView) {
        this.iOneView = iOneView;
        iGetAdModel=new GetAdModel();
    }
    public void getAD(){
        iGetAdModel.getAd(new NetListenter<GetAdBean>() {
            @Override
            public void onSccess(GetAdBean getAdBean) {
                iOneView.showGetAd(getAdBean);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}
