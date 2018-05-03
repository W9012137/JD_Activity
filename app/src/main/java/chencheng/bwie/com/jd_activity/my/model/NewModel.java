package chencheng.bwie.com.jd_activity.my.model;

import chencheng.bwie.com.jd_activity.my.bean.MessageBean;
import chencheng.bwie.com.jd_activity.my.persenter.NewsPresenter;
import chencheng.bwie.com.jd_activity.net.RetrofitUtils;
import io.reactivex.Flowable;
import okhttp3.MultipartBody;

/**
 * Created by dell on 2018/4/28.
 */

public class NewModel {
    private NewsPresenter presenter;

    public NewModel(NewsPresenter presenter) {
        this.presenter = presenter;
    }
    public void getData(String uid , MultipartBody.Part file){
        Flowable<MessageBean> flowable = RetrofitUtils.getServerApi().getMusicList(uid, file);
        presenter.getNews(flowable);
    }
}
