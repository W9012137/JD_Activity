package chencheng.bwie.com.jd_activity.discover.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.discover.adapter.MyListAdapter;
import chencheng.bwie.com.jd_activity.discover.bean.ProductsBean;
import chencheng.bwie.com.jd_activity.discover.presenter.ListPresenter;

/**
 * Created by dell on 2018/4/18.
 */

public class ListActivity extends AppCompatActivity implements IListView, View.OnClickListener {
    private RecyclerView mRv;
    /**
     * 综合
     */
    private TextView mTvZhonghe;
    /**
     * 销量
     */
    private TextView mTvXiaoliang;
    /**
     * 价格
     */
    private TextView mTvPrice;
    /**
     * 筛选
     */
    private boolean b = false;

    private TextView mTvShaixuan;
    private SpringView mSv;
    private String pscid;
    private String sort = "0";
    private int page = 1;
    private ListPresenter presenter;
    private MyListAdapter adapter;
    List<ProductsBean.DataBean> list = new ArrayList<>();
    private ImageView mIvG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
        Intent it = getIntent();
        pscid = it.getStringExtra("pscid");
        presenter = new ListPresenter(this);
        presenter.showl(pscid, page + "", "0");
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mTvZhonghe = (TextView) findViewById(R.id.tvZhonghe);
        mTvZhonghe.setOnClickListener(this);
        mTvXiaoliang = (TextView) findViewById(R.id.tvXiaoliang);
        mTvXiaoliang.setOnClickListener(this);
        mTvPrice = (TextView) findViewById(R.id.tvPrice);
        mTvPrice.setOnClickListener(this);
        mTvShaixuan = (TextView) findViewById(R.id.tvShaixuan);
        mSv = (SpringView) findViewById(R.id.sv);
        mSv.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                presenter.showl(pscid, page + "", sort);
            }

            @Override
            public void onLoadmore() {
                page++;
                presenter.showl(pscid, page + "", sort);
            }
        });
        mIvG = (ImageView) findViewById(R.id.iv_g);
        mIvG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListActivity.this, "点击了切换视图按钮", Toast.LENGTH_SHORT).show();
                if (b == false) {
//点击后想要变成什么要的布局样式就搞一个你的需求
                    mRv .setLayoutManager(new GridLayoutManager(ListActivity.this, 2));
//给布尔值重新赋值
                    b = true;
//给点击按钮的图片重新赋值
                    /*im.setImageResource(R.mipmap.ic_linear);*/
                } else if (b == true) {
                    mRv.setLayoutManager(new LinearLayoutManager(ListActivity.this));
//给布尔值重新赋值
                    b = false;
                    mIvG.setImageResource(R.drawable.kind_grid);
//给点击按钮的图片重新赋值
                 /*   cIv.setImageResource(R.mipmap.ic_grid);*/
                }
            }
        });

        mRv.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvZhonghe:
                sort = "0";
                presenter.showl(pscid, "1", sort);
                break;
            case R.id.tvXiaoliang:
                sort = "1";
                presenter.showl(pscid, "1", sort);
                break;
            case R.id.tvPrice:
                sort = "2";
                presenter.showl(pscid, "1", sort);
                break;
        }
    }

    @Override
    public void ShowList(List<ProductsBean.DataBean> dataBeans,String pscid) {
        adapter = new MyListAdapter(this, dataBeans);
        mRv.setAdapter(adapter);
        adapter.setOnclickSpflAdpter(new MyListAdapter.OnClickfl() {
            @Override
            public void onClickxq(int position) {
                Intent intent = new Intent(ListActivity.this, DetaliActivity.class);
                intent.putExtra("pid", position);
                startActivity(intent);

            }
        });
    }
}
