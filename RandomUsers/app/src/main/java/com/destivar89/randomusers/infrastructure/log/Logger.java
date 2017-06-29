package com.destivar89.randomusers.infrastructure.log;

import android.util.Log;

import com.destivar89.randomusers.BuildConfig;

public class Logger {
    private final String tag;
    private final Integer level;

    public static Logger getLogger(Class clazz) {
        return new Logger(clazz.getSimpleName(), BuildConfig.LogLevel);
    }

    private Logger(String tag, Integer level) {
        if (level == null || level < 0)
            this.level = 0;
        else if (level > 5)
            this.level = 5;
        else
            this.level = level;
        this.tag = tag;
    }

    public void error(String msg, Throwable tr) {
        if (level <= 4) Log.e(tag, msg, tr);
    }

    public void error(String msg) {
        if (level <= 4) Log.e(tag, msg);
    }

    public void warning(Throwable tr) {
        if (level <= 3) Log.w(tag, tr);
    }

    public void warning(String msg, Throwable tr) {
        if (level == 3) Log.w(tag, msg, tr);
    }

    public void warning(String msg) {
        if (level <= 3) Log.w(tag, msg);
    }

    public void info(String msg, Throwable tr) {
        if (level <= 2) Log.i(tag, msg, tr);
    }

    public void info(String msg) {
        if (level <= 2) Log.i(tag, msg);
    }

    public void debug(String msg, Throwable tr) {
        if (level <= 1) Log.d(tag, msg, tr);
    }

    public void debug(Throwable tr) {
        if (level <= 1) Log.d(tag, "", tr);
    }

    public void debug(String msg) {
        if (level <= 1) Log.d(tag, msg);
    }

    public void verbose(String msg, Throwable tr) {
        if (level == 0) Log.v(tag, msg, tr);
    }

    public void verbose(String msg) {
        if (level == 0) Log.v(tag, msg);
    }

}
