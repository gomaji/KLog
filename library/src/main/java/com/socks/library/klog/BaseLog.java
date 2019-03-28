package com.socks.library.klog;

import android.util.Log;

import com.hypertrack.hyperlog.HyperLog;
import com.socks.library.KLog;

/**
 * Created by zhaokaiqiang on 15/11/18.
 */
public class BaseLog {

    private static final int MAX_LENGTH = 4000;

    public static void printDefault(int type, String tag, String msg) {

        int index = 0;
        int length = msg.length();
        int countOfSub = length / MAX_LENGTH;

        if (countOfSub > 0) {
            for (int i = 0; i < countOfSub; i++) {
                String sub = msg.substring(index, index + MAX_LENGTH);
                printSub(type, tag, sub);
                index += MAX_LENGTH;
            }
            printSub(type, tag, msg.substring(index, length));
        } else {
            printSub(type, tag, msg);
        }
    }

    private static void printSub(int type, String tag, String sub) {
        switch (type) {
            case KLog.V:
                if (KLog.IS_UPLOAD_LOG) {
                    HyperLog.v(tag, sub);
                }
                else{
                    Log.v(tag, sub);
                }
                break;
            case KLog.D:
                if (KLog.IS_UPLOAD_LOG) {
                    HyperLog.d(tag, sub);
                }
                else {
                    Log.d(tag, sub);
                }
                break;
            case KLog.I:
                if (KLog.IS_UPLOAD_LOG) {
                    HyperLog.i(tag, sub);
                }
                else {
                    Log.i(tag, sub);
                }
                break;
            case KLog.W:
                if (KLog.IS_UPLOAD_LOG) {
                    HyperLog.w(tag, sub);
                }
                else {
                    Log.w(tag, sub);
                }
                break;
            case KLog.E:
                if (KLog.IS_UPLOAD_LOG) {
                    HyperLog.e(tag, sub);
                }
                else {
                    Log.e(tag, sub);
                }
                break;
            case KLog.A:
                Log.wtf(tag, sub);
                break;
        }
    }

}
