package com.finance.jackie.mddemo.rxhttp.ApiService;

/**
 * Created by Jackie on 2018/8/29.
 */
public class TestWeather {


    /**
     * error : true
     * msg : 地址,描述,你的ID,干货类型都不能为空
     */

    private boolean error;
    private String msg;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
