package chencheng.bwie.com.jd_activity.discover.presenter;

import java.util.ArrayList;
import java.util.List;

import chencheng.bwie.com.jd_activity.discover.bean.LefteBean;
import chencheng.bwie.com.jd_activity.discover.bean.RightBean;
import chencheng.bwie.com.jd_activity.discover.model.ILeftModel;
import chencheng.bwie.com.jd_activity.discover.model.LeftModel;
import chencheng.bwie.com.jd_activity.discover.view.IView;
import chencheng.bwie.com.jd_activity.net.NetListenter;

/**
 * Created by dell on 2018/4/17.
 */

public class LeftPreseenter {
    private IView iView;
    private ILeftModel iLeftModel;

    public LeftPreseenter(IView iView) {
        this.iView = iView;
        iLeftModel=new LeftModel();
    }
    public void show(){
        iLeftModel.getLeft(new NetListenter<LefteBean>() {
            @Override
            public void onSccess(LefteBean lefteBean) {
                final List<LefteBean.DataBean> data = lefteBean.getData();
                iView.ShowLeft(data);
                showR(lefteBean.getData().get(0).getCid()+"");
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
    public void showR(String cid){
        iLeftModel.getCid(cid, new NetListenter<RightBean>() {
            @Override
            public void onSccess(RightBean rightBean) {

                List<List<RightBean.DataBean.ListBean>> child=new ArrayList<List<RightBean.DataBean.ListBean>>();
                List<RightBean.DataBean> group=rightBean.getData();
                for (int i=0;i<group.size();i++){
                    final RightBean.DataBean dataBean = group.get(i);
                    final List<RightBean.DataBean.ListBean> list = dataBean.getList();
                    child.add(list);
                }
                iView.showright(group,child);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}
