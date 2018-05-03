package chencheng.bwie.com.jd_activity.discover.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.List;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.discover.adapter.LeftAdapter;
import chencheng.bwie.com.jd_activity.discover.adapter.MyExp;
import chencheng.bwie.com.jd_activity.discover.bean.LefteBean;
import chencheng.bwie.com.jd_activity.discover.bean.RightBean;
import chencheng.bwie.com.jd_activity.discover.presenter.LeftPreseenter;

/**
 * Created by dell on 2018/4/10.
 */

public class TwoFragment extends Fragment implements IView {


    private ImageView mBanner;
    private MyExpandableListView mElv;
    private ScrollView mSv;
    LeftPreseenter preseenter;
    LeftAdapter adapter;
    private ListView mLv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
       preseenter = new LeftPreseenter(this);
       preseenter.show();

        initView(view);

        return view;
    }


    @Override
    public void ShowLeft(List<LefteBean.DataBean> dataBeans) {

        adapter = new LeftAdapter(getActivity(),dataBeans);
        mLv.setAdapter(adapter);
    }

    @Override
    public void showright(List<RightBean.DataBean> group, List<List<RightBean.DataBean.ListBean>> child) {
        MyExp myExp = new MyExp(getActivity(), group, child);
        mElv.setAdapter(myExp);
        for (int i=0;i<group.size();i++){
            mElv.expandGroup(i);
        }
    }


    private void initView(View view) {
        mLv = (ListView) view.findViewById(R.id.lv);
        mBanner = (ImageView) view.findViewById(R.id.banner);
        mElv = (MyExpandableListView) view.findViewById(R.id.elv);
        mSv = (ScrollView) view.findViewById(R.id.sv);
        mLv = (ListView) view.findViewById(R.id.lv);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final LefteBean.DataBean dataBean= (LefteBean.DataBean) adapterView.getItemAtPosition(i);
                adapter.changeItemSelect(i);
                int cid=dataBean.getCid();
                preseenter.showR(cid+"");
            }
        });
    }
}
