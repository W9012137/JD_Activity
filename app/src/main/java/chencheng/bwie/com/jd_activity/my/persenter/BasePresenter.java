package chencheng.bwie.com.jd_activity.my.persenter;

import okhttp3.MultipartBody;

/**
 * Created by dell on 2018/4/28.
 */

public interface BasePresenter {
    void getData(String uid, MultipartBody.Part file);
}
