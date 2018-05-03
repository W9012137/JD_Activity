package chencheng.bwie.com.jd_activity.discover.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.discover.bean.LefteBean;


/**
 * Created by dell on 2018/4/17.
 */

public class LeftAdapter extends BaseAdapter {
    private Context context;
    private List<LefteBean.DataBean> list;
    private LayoutInflater inflater;

    public LeftAdapter(Context context, List<LefteBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            holder=new ViewHolder();
            view=inflater.inflate(R.layout.list_item,null);
            holder.tv=view.findViewById(R.id.tv);
            holder.ll=view.findViewById(R.id.ll);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        final LefteBean.DataBean dataBean = list.get(i);
        holder.tv.setText(dataBean.getName());
        if (dataBean.ischeckd()){
            holder.ll.setBackgroundColor(Color.parseColor("#33000000"));
        }else{
            holder.ll.setBackgroundColor(Color.WHITE);
        }
        return view;
    }
    class ViewHolder{
        TextView tv;
        LinearLayout ll;
    }
    public void changeItemSelect(int position){
        for (int i=0;i<list.size();i++){
            final LefteBean.DataBean dataBean = list.get(i);
            dataBean.setIscheckd(false);
        }
        final LefteBean.DataBean dataBean = list.get(position);
        dataBean.setIscheckd(true);
        notifyDataSetChanged();
    }
}
