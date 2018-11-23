package com.mvvmdemo.www.library_common.http.error;

/**
 * author:  zhouchaoxiang
 * date:    2018/7/25
 * explain:
 */
public class HttpErrorBean extends Exception {
    public HttpErrorBean(Throwable cause,int code) {
        super(cause);
        this.code = code;
    }

    public HttpErrorBean(String message, int code, long timestamp) {
        this.message = message;
        this.code = code;
        this.timestamp = timestamp;
    }

    /**
     * message : 库存记录模块库存记录找不到
     * code : 74002
     * timestamp : 1532506506092
     */

    private String message;
    private int code;
    private long timestamp;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
