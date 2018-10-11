package com.finance.jackie.mddemo.rxhttp;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Jackie on 2018/8/29.
 */
public abstract class BaseSubscriber<T> extends DisposableSubscriber<T> {
    private static final String TAG = "BaseSubscriber";
    private Context context;
    private ProgressDialog progressDialog;
    
    public BaseSubscriber(Context context){
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("拼命加载中...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ---http-------");
        if (!NetworkUtil.isNetworkAvailable(context)) {
            Toast.makeText(context, "无网络，读取缓存数据", Toast.LENGTH_SHORT).show();
            onComplete();
        }
        if (progressDialog != null){
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            progressDialog.show();
        }
    }

    @Override
    public void onError(Throwable t) {
        Log.i(TAG, "onError: "+t.getMessage());
        if (progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        if (t instanceof ExceptionHandle.ResponeThrowable){
            onErrorHandle((ExceptionHandle.ResponeThrowable)t);
        }else{
            onErrorHandle(new ExceptionHandle.ResponeThrowable(t,ExceptionHandle.ERROR.UNKNOWN));
        }

    }

    @Override
    public void onComplete() {
        if (progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        Log.i(TAG, "onComplete: ---http--");
    }

    public void onErrorHandle(ExceptionHandle.ResponeThrowable e){
        Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
