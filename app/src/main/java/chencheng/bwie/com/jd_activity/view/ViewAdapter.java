package chencheng.bwie.com.jd_activity.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by dell on 2018/4/10.
 */

public class ViewAdapter extends ViewPager {

    public ViewAdapter(Context context) {
        super(context);
    }


    public ViewAdapter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        return false;
    }
}
