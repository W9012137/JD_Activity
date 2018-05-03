package chencheng.bwie.com.jd_activity.net;

import java.util.Map;

import chencheng.bwie.com.jd_activity.bean.LogBean;
import chencheng.bwie.com.jd_activity.bean.RegisterBean;
import chencheng.bwie.com.jd_activity.bean.UserBean;
import chencheng.bwie.com.jd_activity.discover.bean.AddCartBean;
import chencheng.bwie.com.jd_activity.discover.bean.DetailBean;
import chencheng.bwie.com.jd_activity.discover.bean.LefteBean;
import chencheng.bwie.com.jd_activity.discover.bean.ProductsBean;
import chencheng.bwie.com.jd_activity.discover.bean.RightBean;
import chencheng.bwie.com.jd_activity.homepage.baen.GetAdBean;
import chencheng.bwie.com.jd_activity.my.bean.MessageBean;
import chencheng.bwie.com.jd_activity.shoppingtrolley.bean.DeleteBean;
import chencheng.bwie.com.jd_activity.shoppingtrolley.bean.GetCartBean;
import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by dell on 2018/4/9.
 */

public interface ServerApi {
    //注册
    @POST
    Flowable<RegisterBean> register(@Url String url, @QueryMap Map<String ,String> map);
    @POST
    //登录
    Flowable<LogBean> login(@Url String url,@QueryMap Map<String,String> map);
    //用户信息
    @POST
    Flowable<UserBean> user(@Url String url,@QueryMap Map<String,String> map);
    @GET("ad/getAd")
    Flowable<GetAdBean> getAd();
    //分类list
    @GET("product/getCatagory")
    Flowable<LefteBean> leftBean();
    @GET("product/getProductCatagory")
   Flowable<RightBean> products(@Query("cid") String cid);
    @POST
    Flowable<ProductsBean> listrv(@Url String url,@QueryMap Map<String ,String> map);
    //详情
    @GET("product/getProductDetail")
    Flowable<DetailBean> detail (@Query("pid") String pid, @Query("source") String source);
    //添加购物车
    @POST
    Flowable<AddCartBean> addCart (@Url String url,@QueryMap Map<String ,String> map,@Query("source") String source);
    //查询购物车
    @POST
    Flowable<GetCartBean> getCart(@Url String url,@QueryMap Map<String,String> map,@Query("source") String source);
  //删除购物车
    @POST
    Flowable<DeleteBean> delete(@Url String url,@QueryMap Map<String,String> map,@Query("source") String source);
    @Multipart
    @POST("upload")
    Flowable<MessageBean> getMusicList(@Query("uid") String uid, @Part MultipartBody.Part file);
}
