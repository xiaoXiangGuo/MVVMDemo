package com.mvvmdemo.www.library_common.utils;

import android.util.Log;

import com.orhanobut.logger.Logger;

/**
 * 日志工具类
 *
 * @author apple
 */
public final class LogUtil {

    //开关
    private final static boolean flag = true;//true 测试                 false  上线

    public static void v(String tag, String msg) {
        if (flag) {
            Logger.t(tag).v(msg);
        }
    }

    public static void d(String tag, String msg) {
        if (flag) {
            Logger.t(tag).d(msg);
        }
    }

    public static void i(String tag, String msg) {
        if (flag) {
            Logger.t(tag).i(msg);
        }
    }

    public static void w(String tag, String msg) {
        if (flag) {
            Logger.t(tag).w(msg);
        }
    }

    public static void e(String tag, String msg) {
        if (flag) {
            Logger.t(tag).e(msg);
        }
    }

    public static void v(String msg) {
        if (flag) {
            Logger.v(msg);
        }
    }

    public static void d(String msg) {
        if (flag) {
            Logger.d(msg);
        }
    }

    public static void i(String msg) {
        if (flag) {
            Logger.i(msg);
        }
    }

    public static void w(String msg) {
        if (flag) {
            Logger.w(msg);
        }
    }

    public static void e(String msg) {
        if (flag) {
            Logger.e(msg);
        }
    }

    public static void defaultV(String tag, String msg) {
        if (flag) {
            Log.v(tag, msg);
        }
    }

    public static void defaultD(String tag, String msg) {
        if (flag) {
            Log.d(tag, msg);
        }
    }

    public static void defaultI(String tag, String msg) {
        if (flag) {
            Log.i(tag, msg);
        }
    }

    public static void defaultW(String tag, String msg) {
        if (flag) {
            Log.w(tag, msg);
        }
    }

    public static void defaultE(String tag, String msg) {
        if (flag) {
            Log.e(tag, msg);
        }
    }

    public static void json(String json) {
        Logger.json(json);
    }
}
