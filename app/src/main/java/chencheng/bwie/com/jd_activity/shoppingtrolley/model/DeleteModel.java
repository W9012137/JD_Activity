package chencheng.bwie.com.jd_activity.shoppingtrolley.model;

import java.util.HashMap;

import chencheng.bwie.com.jd_activity.net.NetListenter;
import chencheng.bwie.com.jd_activity.net.RetrofitUtils;
import chencheng.bwie.com.jd_activity.shoppingtrolley.bean.DeleteBean;
import io.reactivex.Flowable;

/**
 * Created by dell on 2018/4/28.
 */

public class DeleteModel implements IDeleteModel {
    @Override
    public void Getdelete(String uid, String pid, NetListenter<DeleteBean> netListenter) {
        final HashMap<String, String> map = new HashMap<>();
        map.put("uid",uid);
        map.put("pid",pid);
        Flowable flowable= RetrofitUtils.getServerApi().delete("product/deleteCart",map,"android");
    }
}
