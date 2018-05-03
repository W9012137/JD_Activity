package chencheng.bwie.com.jd_activity.homepage.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.discover.bean.LefteBean;
import chencheng.bwie.com.jd_activity.discover.bean.RightBean;
import chencheng.bwie.com.jd_activity.discover.presenter.LeftPreseenter;
import chencheng.bwie.com.jd_activity.discover.view.IView;
import chencheng.bwie.com.jd_activity.homepage.adapter.GVAdapter;



public class fragmet01_item1 extends Fragment implements IView{
    private GridView gv;
    private GVAdapter adapter;
    private LeftPreseenter fLleftpresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item1, null);
        fLleftpresenter = new LeftPreseenter(this);
        fLleftpresenter.show();
        gv = view.findViewById(R.id.gv);
        return view;
    }



    @Override
    public void ShowLeft(List<LefteBean.DataBean> dataBeans) {
        List<LefteBean.DataBean> glist = new ArrayList<>();
        for(int i=0;i<10;i++){
            LefteBean.DataBean dataBean = dataBeans.get(i);
            glist.add(dataBean);
        }
        adapter = new GVAdapter(glist, getContext());
        gv.setAdapter(adapter);
    }

    @Override
    public void showright(List<RightBean.DataBean> group, List<List<RightBean.DataBean.ListBean>> child) {

    }
}
