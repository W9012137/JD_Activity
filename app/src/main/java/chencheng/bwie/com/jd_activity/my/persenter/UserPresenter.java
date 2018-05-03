package chencheng.bwie.com.jd_activity.my.persenter;

import chencheng.bwie.com.jd_activity.bean.UserBean;
import chencheng.bwie.com.jd_activity.model.IUserModel;
import chencheng.bwie.com.jd_activity.model.UserModel;
import chencheng.bwie.com.jd_activity.my.view.IFourView;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/11.
 */

public class UserPresenter {
    private IFourView iFourView;
    private IUserModel iUserModel;

    public UserPresenter(IFourView iFourView) {
        this.iFourView = iFourView;
        iUserModel=new UserModel();
    }
    public void User(final String uid){
        iUserModel.getUser(uid,  new NetListenter<UserBean>() {
            @Override
            public void onSccess(UserBean userBean) {
                final UserBean.DataBean data = userBean.getData();
                iFourView.showUser(data,uid);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}
