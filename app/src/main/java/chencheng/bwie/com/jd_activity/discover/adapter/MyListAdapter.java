package chencheng.bwie.com.jd_activity.discover.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.discover.bean.ProductsBean;

/**
 * Created by dell on 2018/4/18.
 */

public class MyListAdapter extends RecyclerView.Adapter<RecyclerView .ViewHolder> {
 private Context context;
 private List<ProductsBean.DataBean> list;
   OnClickfl onClickfl;
    public interface OnClickfl{
        void onClickxq(int position);
    }

    public void setOnclickSpflAdpter(OnClickfl onClickfl) {
        this.onClickfl = onClickfl;
    }
    public MyListAdapter(Context context, List<ProductsBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rv_one,null);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
    MyViewHolder holder1= (MyViewHolder) holder;
    holder1.tv.setText(list.get(position).getTitle());
    holder1.price.setText("￥："+list.get(position).getPrice());
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        Glide.with(context).load(split[0]).into(holder1.iv);
        holder1.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pid = list.get(position).getPid();
                onClickfl.onClickxq(pid);

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
      private ImageView iv;
      private TextView tv;
      private TextView price;
      private LinearLayout ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            ll=itemView.findViewById(R.id.ll);
            tv=itemView.findViewById(R.id.Name);
            price=itemView.findViewById(R.id.Price);
        }
    }
}
