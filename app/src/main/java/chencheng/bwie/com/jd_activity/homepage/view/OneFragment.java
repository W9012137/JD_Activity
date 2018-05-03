package chencheng.bwie.com.jd_activity.homepage.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.discover.bean.LefteBean;
import chencheng.bwie.com.jd_activity.discover.bean.RightBean;
import chencheng.bwie.com.jd_activity.discover.presenter.LeftPreseenter;
import chencheng.bwie.com.jd_activity.discover.view.DetaliActivity;
import chencheng.bwie.com.jd_activity.discover.view.IView;
import chencheng.bwie.com.jd_activity.homepage.adapter.Banneradpter;
import chencheng.bwie.com.jd_activity.homepage.adapter.Miaoshaadpter;
import chencheng.bwie.com.jd_activity.homepage.baen.GetAdBean;
import chencheng.bwie.com.jd_activity.homepage.presenter.GetAdPresenter;
import chencheng.bwie.com.jd_activity.qrcode.MipcaActivityCapture;

/**
 * Created by dell on 2018/4/10.
 */

public class OneFragment extends Fragment implements IView,IOneView{
    private List<String> list = new ArrayList<>();
    private List<Fragment> flist;
    private fragmet01_item1 fragmet01_item1;
    private fragmet01_item2 fragmet01_item2;
    private ViewPager vip;
    private Banner banner;
    private View view;
    private GetAdPresenter shouYepresenter;
    private LeftPreseenter lleftpresenter;
    private RecyclerView rlv_xq;
    private RecyclerView miao_rlv;
    private ImageView saomiao;
    private EditText cz;
    private TextView mTvSecond;
    /**
     * 02
     */
    private TextView mTvHour;
    /**
     * 15
     */
    private TextView mTvMinute;
    /**
     * 36
     */
    private long mHour = 02;
    private long mMin = 15;
    private long mSecond = 36;
    private boolean isRun = true;
    //时间
    private Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                computeTime();
                if (mHour<10){
                    mTvHour.setText("0"+mHour+"");
                }else {
                    mTvHour.setText("0"+mHour+"");
                }
                if (mMin<10){
                    mTvMinute.setText("0"+mMin+"");
                }else {
                    mTvMinute.setText(mMin+"");
                }
                if (mSecond<10){
                    mTvSecond.setText("0"+mSecond+"");
                }else {
                    mTvSecond.setText(mSecond+"");
                }
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);
        mTvHour = (TextView) view.findViewById(R.id.tv_hour);
        mTvMinute = (TextView) view.findViewById(R.id.tv_minute);
        mTvSecond = (TextView) view.findViewById(R.id.tv_second);
        //扫描
        saomiao = view.findViewById(R.id.saomiao);
        saomiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //扫描二维码
                Intent intent = new Intent(getActivity(), MipcaActivityCapture.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, 1);
               // startActivityForResult(new Intent(getActivity(), MipcaActivityCapture.class), MipcaActivityCapture.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });
//        //查找
//        cz = view.findViewById(R.id.et_cz);
//        cz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), ChaxunActivity.class));
//            }
//        });
//        //客服消息
//        ImageView xiapxi = view.findViewById(R.id.xiaoxi);
//        xiapxi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), ServiceNewsActivity.class));
//            }
//        });
        shouYepresenter = new GetAdPresenter(this);
        vip = view.findViewById(R.id.vip);
       flist = new ArrayList<>();
       fragmet01_item1 = new fragmet01_item1();
        fragmet01_item2 = new fragmet01_item2();
        flist.add(fragmet01_item1);
        flist.add(fragmet01_item2);
        shouYepresenter.getAD();
        lleftpresenter = new LeftPreseenter(this);
        lleftpresenter.show();
        tuijian();
        miaoshajd();
        startRun();
        return view;
    }
    /**
     * 开启倒计时
     */
    private void startRun() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (isRun) {
                    try {
                        Thread.sleep(1000); // sleep 1000ms
                        Message message = Message.obtain();
                        message.what = 1;
                        timeHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    /**
     * 倒计时计算
     */
    private void computeTime() {
        mSecond--;
        if (mSecond < 0) {
            mMin--;
            mSecond = 59;
            if (mMin < 0) {
                mMin = 59;
                mHour--;
            }
        }
    }
    //秒杀
    private void miaoshajd() {
        miao_rlv = view.findViewById(R.id.miao_rlv);
        miao_rlv.setLayoutManager(new GridLayoutManager(getActivity(),12));
    }

    //推荐
    private void tuijian() {
        rlv_xq = view.findViewById(R.id.rlv);
        rlv_xq.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }


    //秒杀
    private void miaosha(GetAdBean sgouyeBean) {
        GetAdBean.MiaoshaBean miaosha = sgouyeBean.getMiaosha();
        Miaoshaadpter miaoshaadpter = new Miaoshaadpter(getActivity(), miaosha.getList());
        miao_rlv.setAdapter(miaoshaadpter);
        miaoshaadpter.setMiaoshaadpter(new Miaoshaadpter.OnClickms() {
            @Override
            public void onClickms(int position) {
                Intent intent = new Intent(getActivity(), DetaliActivity.class);
                intent.putExtra("pid", position);
                startActivity(intent);
            }
        });
    }
    //推荐
    private void tuijianff(GetAdBean sgouyeBean) {
        GetAdBean.TuijianBean tuijian = sgouyeBean.getTuijian();
        Banneradpter banneradpter = new Banneradpter(tuijian.getList(), getActivity());
        rlv_xq.setAdapter(banneradpter);
        banneradpter.setOnclickSpflAdpter(new Banneradpter.OnClickfl() {
            @Override
            public void onClickxq(int position) {
                Intent intent = new Intent(getActivity(), DetaliActivity.class);
                intent.putExtra("pid", position);
                startActivity(intent);
            }
        });

    }



    @Override
    public void ShowLeft(List<LefteBean.DataBean> dataBeans) {
        vip.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return flist.get(position);
            }

            @Override
            public int getCount() {
                return flist.size();
            }
        });
    }

    @Override
    public void showright(List<RightBean.DataBean> group, List<List<RightBean.DataBean.ListBean>> child) {

    }

    @Override
    public void showGetAd(GetAdBean getAdBean) {
        tuijianff(getAdBean);
        miaosha(getAdBean);
        banner = view.findViewById(R.id.banner);
        for (int i = 0; i < getAdBean.getData().size(); i++) {
            String icon = getAdBean.getData().get(i).getIcon();
            list.add(icon);
        }
        banner.setImages(list);
        banner.setImageLoader(new GlideImageLoader());
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setDelayTime(2000);
//启动banner
        banner.start();
        GetAdBean.TuijianBean tuijian = getAdBean.getTuijian();
        Banneradpter banneradpter = new Banneradpter(tuijian.getList(), getActivity());
        rlv_xq.setAdapter(banneradpter);
       banneradpter.setOnclickSpflAdpter(new Banneradpter.OnClickfl() {
           @Override
           public void onClickxq(int position) {
               Intent intent = new Intent(getActivity(), DetaliActivity.class);
               intent.putExtra("pid", position);
                startActivity(intent);
           }        });

    }
}
