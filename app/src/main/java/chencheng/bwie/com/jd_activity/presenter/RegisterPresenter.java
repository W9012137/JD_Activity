package chencheng.bwie.com.jd_activity.presenter;

import chencheng.bwie.com.jd_activity.bean.RegisterBean;
import chencheng.bwie.com.jd_activity.model.IRegisterModel;
import chencheng.bwie.com.jd_activity.model.RegisterModel;
import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.view.IRegisterview;

/**
 * Created by dell on 2018/4/10.
 */

public class RegisterPresenter {
    private IRegisterview iRegisterview;
    private IRegisterModel iRegisterModel;

    public RegisterPresenter(IRegisterview iRegisterview) {
        this.iRegisterview = iRegisterview;
        iRegisterModel=new RegisterModel();
    }
   public void register(String mobile, String password ){
        iRegisterModel.getRegister(mobile,password, new NetListenter<RegisterBean>() {
            @Override
            public void onSccess(RegisterBean registerBean) {
                iRegisterview.showregister(registerBean);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
   }
}
