package com.finance.jackie.mddemo.rxhttp.ApiService;

import com.liangyue.commonlib.http.rxhttp.TestIPBean;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


/**
 * Created by Jackie on 2018/8/29.
 */
public interface HttpService {


//    /**
//     *普通写法
//     */
//    @GET("service/getIpInfo.php")
//    Flowable<BaseResponse<IpResult>> getData(@Query("ip") String ip);
    @GET("http://gaapi.jl.gov.cn:80/econsole/api/news/top/3")
    Flowable<TestIPBean> getData();

    @FormUrlEncoded
    @POST("https://gank.io/api/add2gank")
    Flowable<TestWeather> postWeathter(@Field("desc") String dest,
                                       @Field("debug") boolean debug,
                                       @Field("who") String id,
                                       @Field("type") String type);

    //    compile 'io.reactivex.rxjava2:rxjava:2.1.1'
//    compile 'io.reactivex.rxjava2:rxandroid:2.0.1'
//    compile 'com.squareup.retrofit2:retrofit:2.3.0'
//    compile 'com.squareup.retrofit2:converter-gson:2.3.0'
//    compile('com.squareup.retrofit2:adapter-rxjava2:2.3.0') {
//        transitive = true
//        exclude group: 'com.squareup.okhttp3'
//        exclude group: 'com.squareup.okio'
//        // exclude group: 'io.reactivex', module: 'rxjava'
//    }
//    compile 'com.squareup.okhttp3:okhttp:3.8.0'
//    compile 'com.squareup.okhttp3:logging-interceptor:3.8.0'
//    //rx管理View的生命周期
//    compile 'com.trello.rxlifecycle2:rxlifecycle:2.2.1'
//    compile 'com.trello.rxlifecycle2:rxlifecycle-components:2.2.1'

}
