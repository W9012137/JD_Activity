package chencheng.bwie.com.jd_activity.presenter;

import chencheng.bwie.com.jd_activity.bean.LogBean;
import chencheng.bwie.com.jd_activity.model.ILogModel;
import chencheng.bwie.com.jd_activity.model.LogModel;
import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.view.ILogView;

/**
 * Created by dell on 2018/4/10.
 */

public class LoginPresenter {
    private ILogView iLogView;
    private ILogModel iLogModel;

    public LoginPresenter(ILogView iLogView) {
        this.iLogView = iLogView;
        iLogModel=new LogModel();
    }
   public void log(String mobile, String password){
        iLogModel.getLogin(mobile, password, new NetListenter<LogBean>() {
            @Override
            public void onSccess(LogBean logBean) {
                iLogView.showlofin(logBean);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
   }
}
