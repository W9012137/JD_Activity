package chencheng.bwie.com.jd_activity.my.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import chencheng.bwie.com.jd_activity.R;
import chencheng.bwie.com.jd_activity.my.bean.MessageBean;
import chencheng.bwie.com.jd_activity.my.model.NewsView;
import chencheng.bwie.com.jd_activity.my.persenter.NewsPresenter;
import chencheng.bwie.com.jd_activity.my.persenter.UserPresenter;
import chencheng.bwie.com.jd_activity.view.LoginActivity;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by dell on 2018/4/10.
 */

public class FourFragment extends Fragment implements View.OnClickListener,NewsView{

    private SimpleDraweeView mImageView;
    /**
     * 登录/注册
     */
    private String[] mCustomItems = new String[]{"本地相册", "相机拍照","取消"};
    private TextView mLogin;
 UserPresenter presenter;
 SharedPreferences sp;
 String uid;
 String token;
    SharedPreferences sharedPreferences;
    private File tempFile;
    private static final String PHOTO_FILE_NAME = "temp_photo.jpg";
    private static final int PHOTO_REQUEST_CAREMA = 1;// 拍照
    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    private static final int PHOTO_REQUEST_CUT = 3;// 结果
    private NewsPresenter newsPresenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        initView(view);
        newsPresenter=new NewsPresenter();
        newsPresenter.attachView(this);
        return view;
    }

    private void initView(View view) {
      mImageView = (SimpleDraweeView) view.findViewById(R.id.imageView);
        mImageView.setOnClickListener(this);
        mLogin = (TextView) view.findViewById(R.id.login);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
          case R.id.imageView:
              showDialogCustom();
               break;
            case R.id.login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
    }
    private void showDialogCustom() {
        //创建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("请选择：");
        builder.setItems(mCustomItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    //相册
                    // 在这里跳转到手机系统相册里面
                    Intent intent1 = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent1.setType("image/*");
                    // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
                    startActivityForResult(intent1, PHOTO_REQUEST_GALLERY);
                } else if (which == 1) {
                    //照相机
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, PHOTO_REQUEST_CAREMA);

                }
            }
        });
        builder.create().show();
    }

    /*
* 判断sdcard是否被挂载
*/
    private boolean hasSdcard() {
        //判断ＳＤ卡手否是安装好的　　　media_mounted
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
    /*
    * 剪切图片
    */
    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);

        intent.putExtra("outputFormat", "JPEG");// 图片格式
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CUT
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTO_REQUEST_GALLERY) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                crop(uri);
            }
        } else if (requestCode == PHOTO_REQUEST_CAREMA) {
            // 从相机返回的数据
            if (hasSdcard()) {
                crop(Uri.fromFile(tempFile));
            } else {
                Toast.makeText(getActivity(), "未找到存储卡，无法存储照片！", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == PHOTO_REQUEST_CUT) {
            // 从剪切图片返回的数据
            if (data != null) {
                Bitmap bitmap = data.getParcelableExtra("data");
                /**
                 * 获得图片
                 */
                mImageView.setImageBitmap(bitmap);
                setImgByStr( bitmap);
            }
            try {
                // 将临时文件删除
                tempFile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    /**
     * 上传头像
     */
    public  void setImgByStr(Bitmap bitmap) {
        if(bitmap != null){
            // 拿着imagePath上传了
            // ...
        }
        String imagePath = ImageUtils.savePhoto(bitmap, Environment
                .getExternalStorageDirectory().getAbsolutePath(), String
                .valueOf(System.currentTimeMillis()));
        Log.d("zxz","imagePath:"+imagePath);
        if(imagePath!=null){
            File file=new File(imagePath);//将要保存图片的路径

            try {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                bos.flush();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/png"), file);
            MultipartBody.Part photo = MultipartBody.Part.createFormData("file", file.getName(), photoRequestBody);
            sharedPreferences=getActivity().getSharedPreferences("user",0);
            token = sharedPreferences.getString("token", null);
            uid=sharedPreferences.getString("uid","0");
            newsPresenter.getData(uid,photo);
        }

    }

    @Override
    public void onResume() {
        super.onResume();

    }
    @Override
    public void onSuccess(MessageBean messageBean) {
        String msg = messageBean.getMsg();
        Log.e("zxz",msg);
    }
}
