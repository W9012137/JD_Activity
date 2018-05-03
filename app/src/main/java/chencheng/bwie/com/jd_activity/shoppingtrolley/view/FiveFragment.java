package chencheng.bwie.com.jd_activity.shoppingtrolley.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.shoppingtrolley.adpter.MyAdapter;
import chencheng.bwie.com.jd_activity.shoppingtrolley.bean.GetCartBean;
import chencheng.bwie.com.jd_activity.shoppingtrolley.presenter.BasePresenter;

/**
 * Created by dell on 2018/4/10.
 */

public class FiveFragment extends Fragment implements IGetCartView {
    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    /**
     * 0
     */
    private TextView mTvPrice;
    /**
     * 结算(0)
     */
    private TextView mTvNum;
    BasePresenter presenter;
    MyAdapter adapter;

    SharedPreferences sharedPreferences;
    String uid;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_five, container, false);
        EventBus.getDefault().register(this);
        initView();
        presenter = new BasePresenter(this);
        //创建SharedPreferences对象
        sharedPreferences=getActivity().getSharedPreferences("user",0);
        uid=sharedPreferences.getString("uid",0+"");
        presenter.showl(uid);
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
        return view;
    }

    @Override
    public void showList(List<GetCartBean.DataBean> groupList, List<List<GetCartBean.DataBean.ListBean>> childList,String uid) {

        adapter = new MyAdapter(getActivity(), groupList, childList);
        mElv.setAdapter(adapter);
        mElv.setGroupIndicator(null);
        groupList.remove(groupList);
        groupList.remove(groupList);
        //默认让其全部展开
        for (int i = 0; i < groupList.size(); i++) {
            mElv.expandGroup(i);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);


    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {

        mCheckbox2.setChecked(event.isChecked());
    }


    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mTvNum.setText("结算(" + event.getCount() + ")");
        mTvPrice.setText(event.getPrice() + "");
    }

    private void initView() {
        mElv = (ExpandableListView) view.findViewById(R.id.elv);
        mCheckbox2 = (CheckBox) view.findViewById(R.id.checkbox2);
        mTvPrice = (TextView) view.findViewById(R.id.tv_price);
        mTvNum = (TextView) view.findViewById(R.id.tv_num);
    }
}
