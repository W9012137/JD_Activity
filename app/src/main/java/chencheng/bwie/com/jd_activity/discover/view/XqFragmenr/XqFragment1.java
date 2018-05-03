package chencheng.bwie.com.jd_activity.discover.view.XqFragmenr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.discover.adapter.Spxqadpter;
import chencheng.bwie.com.jd_activity.discover.bean.AddCartBean;
import chencheng.bwie.com.jd_activity.discover.bean.BaseBean;
import chencheng.bwie.com.jd_activity.discover.bean.DetailBean;
import chencheng.bwie.com.jd_activity.discover.presenter.AddCartPresenter;
import chencheng.bwie.com.jd_activity.discover.presenter.DetailPresenter;
import chencheng.bwie.com.jd_activity.discover.view.IAddCartView;
import chencheng.bwie.com.jd_activity.discover.view.IOne;
import chencheng.bwie.com.jd_activity.homepage.view.GlideImageLoader;


/**
 * Created by 杨杰 on 2017/12/18.
 */

public class XqFragment1 extends Fragment implements IAddCartView,IOne {
    private List<String> list = new ArrayList<>();
    private Banner banner;
    private RecyclerView rlv;
    private View view;
   SharedPreferences sharedPreferences;
   AddCartPresenter presenter;
   String uid;
    private String token;
    DetailPresenter detailPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.xq_item1, null);
        rlv = view.findViewById(R.id.rlv_xq);
        //创建SharedPreferences对象
        sharedPreferences=getActivity().getSharedPreferences("user",0);
       token = sharedPreferences.getString("token", null);
      uid=sharedPreferences.getString("uid","0");
        //实例加入购物车的P层
        presenter=new AddCartPresenter(this);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        Intent intent = getActivity().getIntent();
        int pid = intent.getIntExtra("pid",0);
        detailPresenter = new DetailPresenter(this);
        detailPresenter.Show(pid+"");



        return view;
    }



    @Override
    public void ShowDetail(DetailBean detailBean, String pid) {
        Spxqadpter spxqadpter = new Spxqadpter(getActivity(),detailBean.getData());
        rlv.setAdapter(spxqadpter);
        banner = view.findViewById(R.id.banner);
        String icon[] = detailBean.getData().getImages().split("\\|");
        for(int i=0;i<icon.length;i++)
        {
            list.add(icon[i]);
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setImages(list);
        banner.setDelayTime(5000000);
//启动banner
        banner.start();
        spxqadpter.setOnAddCar(new Spxqadpter.OnAddCar() {
            @Override
            public void addCar(int pid) {
                presenter.getAdd(pid+"",uid);
            }
        });
    }

    @Override
    public void ShowAdd(BaseBean baseBean) {

    }


    @Override
    public void showAdd(AddCartBean addCartBean) {
        Toast.makeText(getActivity(),addCartBean.getMsg(),Toast.LENGTH_SHORT).show();
    }
}
