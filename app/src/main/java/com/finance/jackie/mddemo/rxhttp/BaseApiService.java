package com.finance.jackie.mddemo.rxhttp;


import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Jackie on 2018/8/29.
 */
public interface BaseApiService {

//    @GET("http://gaapi.jl.gov.cn:80/econsole/api/news/top/3")
//    Flowable<TestIPBean> getData(@Query("ip") String ip);
    @GET("http://gaapi.jl.gov.cn:80/econsole/api/news/top/3")
    Flowable<TestIPBean> getData();

//    @GET()
//    Flowable<BaseResponse<Object>> get(@Url String url,
//                                       @QueryMap Map<String,String> maps);

    @FormUrlEncoded
    @POST()
    Flowable<ResponseBody> post(@Url String url,
                                @FieldMap Map<String, String> maps);
    @POST()
    Flowable<ResponseBody> json(@Url String url,
                                @Body RequestBody jsonStr);
    @Multipart
    @POST()
    Flowable<ResponseBody> upLoadFile(@Url String url,
                                      @Part() RequestBody requestBody);
    @POST
    Flowable<ResponseBody> upLoadFiles(@Url String url,
                                       @Path("headers") Map<String, String> headers,
                                       @Part("filename") String description,
                                       @PartMap Map<String, RequestBody> maps);
    @Streaming
    @GET
    Flowable<ResponseBody> downloadFile(@Url String fileUrl);

//    Path是网址中的参数,例如:trades/{userId}
//    Query是问号后面的参数,例如:trades/{userId}?token={token}
//    QueryMap 相当于多个@Query
//    Field用于Post请求,提交单个数据,然后要加@FormUrlEncoded
//    Body相当于多个@Field,以对象的方式提交
//    @Streaming:用于下载大文件
//    @Header,@Headers、加请求头








}
