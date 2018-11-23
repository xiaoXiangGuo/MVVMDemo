package com.mvvmdemo.www.library_common.http.error;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.mvvmdemo.www.library_common.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * 错误帮助类
 * Created by Administrator on 2018/4/25.
 */

public class HttpErrorHandle {
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;
    private static final int FAIL_QUEST = 406;//无法使用请求的内容特性来响应请求的网页
    private static final int BAD_REQUEST = 400;

    /**
     * 约定异常
     */
    public class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 解析no content错误
         */
        public static final int PARSE_EmptyERROR = 1007;
        /**
         * 网络错误
         */
        public static final int NETWORD_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = 1005;

        /**
         * 连接超时
         */
        public static final int TIMEOUT_ERROR = 1006;
        public static final int LOGIN_ERROR = -1000;
        public static final int DATA_EMPTY = -2000;
    }

    public static HttpErrorBean handleException(Throwable e) {
        HttpErrorBean ex;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new HttpErrorBean(e, ERROR.HTTP_ERROR);
            switch (httpException.code()) {
                case UNAUTHORIZED:
                    break;
                case FORBIDDEN:
                    ex.setMessage("服务器已经理解请求，但是拒绝执行它");
                    break;
                case NOT_FOUND:
                    ex.setMessage("服务器异常，请稍后再试");
                    break;
                case REQUEST_TIMEOUT:
                    ex.setMessage("请求超时");
                    break;
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                    ex.setMessage("服务器遇到了一个未曾预料的状况，无法完成对请求的处理");
                    break;
                case BAD_REQUEST:
                    break;
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                case FAIL_QUEST:
                    ResponseBody body = ((HttpException) e).response().errorBody();
                    if (body == null) break;
                    try {
                        String message = body.string();
                        HttpErrorBean errorBean = JsonUtils.toBean(message, HttpErrorBean.class);
                        if (errorBean.getMessage() != null) {
                            ex.setMessage("服务器已经理解请求，但是拒绝执行它");
                        } else {
                            ex.setMessage("");
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                default:
                    ex.setMessage("网络错误");
                    break;
            }
            return ex;
        } else if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException) {
            ex = new HttpErrorBean(e, ERROR.PARSE_ERROR);
            ex.setMessage("解析错误");
            return ex;
        } else if (e instanceof ConnectException) {
            ex = new HttpErrorBean(e, ERROR.NETWORD_ERROR);
            ex.setMessage("连接失败");
            return ex;
        } else if (e instanceof SSLHandshakeException) {
            ex = new HttpErrorBean(e, ERROR.SSL_ERROR);
            ex.setMessage("证书验证失败");
            return ex;
        } else if (e instanceof SocketTimeoutException) {
            ex = new HttpErrorBean(e, ERROR.TIMEOUT_ERROR);
            //ex.setMessage("连接超时");
            ex.setMessage("当前网络连接不顺畅，请稍后再试！");
            return ex;
        } else if (e instanceof UnknownHostException) {
            ex = new HttpErrorBean(e, ERROR.TIMEOUT_ERROR);
            //ex.setMessage("连接超时");
            ex.setMessage("网络中断，请检查网络状态！");
            return ex;
        } else if (e instanceof SSLException) {
            ex = new HttpErrorBean(e, ERROR.TIMEOUT_ERROR);
            ex.setMessage("网络中断，请检查网络状态！");
            return ex;
        } else if (e instanceof java.io.EOFException) {
            ex = new HttpErrorBean(e, ERROR.PARSE_EmptyERROR);
            ex.setMessage("1007");
            return ex;
        } else if (e instanceof NullPointerException) {
            ex = new HttpErrorBean(e, ERROR.PARSE_EmptyERROR);
            ex.setMessage("数据为空，显示失败");
            return ex;
        } else if (e instanceof ServerException) {
            ServerException resultException = (ServerException) e;
            ex = new HttpErrorBean(resultException, resultException.code);
            ex.setMessage(resultException.message);
            return ex;
        } else {
            ex = new HttpErrorBean(e, ERROR.UNKNOWN);
            ex.setMessage("未知错误");
            return ex;
        }

    }

    /**
     * 自定义错误
     */
    public class ServerException extends RuntimeException {
        public int code;
        public String message;

        public ServerException(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

}
