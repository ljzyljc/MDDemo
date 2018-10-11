package com.finance.jackie.mddemo.rxhttp.ApiService;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.liangyue.commonlib.R;
import com.liangyue.commonlib.activity.BaseActivity;
import com.liangyue.commonlib.http.rxhttp.BaseSubscriber;
import com.liangyue.commonlib.http.rxhttp.RetrofitClient;
import com.liangyue.commonlib.http.rxhttp.TestIPBean;

import org.reactivestreams.Subscriber;

/**
 * Created by Jackie on 2018/8/29.
 */
public class TestHttpActivity extends BaseActivity {
    private static final String TAG = "TestHttpActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_http_test);
        findViewById(R.id.btn_ip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.getInstance(TestHttpActivity.this).createHttpApi()
                        .getData()
                        .compose(RetrofitClient.doApi())
                        .subscribe(new BaseSubscriber<TestIPBean>(TestHttpActivity.this) {
                            @Override
                            public void onNext(TestIPBean o) {
                                Log.i(TAG, "onNext: -----"+o.isSucc());
                            }
                        });
            }
        });
        findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.getInstance(TestHttpActivity.this).createHttpApi()
                        .postWeathter("Jackie",true,"937548639","Android")
                        .compose(RetrofitClient.doApi())
                        .subscribe(new BaseSubscriber<TestWeather>(TestHttpActivity.this) {
                            @Override
                            public void onNext(TestWeather o) {
                                Log.i(TAG, "onNext: --------------"+o.getMsg());
                            }
                        });
            }
        });
    }
}
