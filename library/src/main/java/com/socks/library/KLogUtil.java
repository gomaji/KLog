package com.socks.library;

import android.text.TextUtils;
import android.util.Log;

import com.hypertrack.hyperlog.HyperLog;

/**
 * Created by zhaokaiqiang on 15/12/11.
 */
public class KLogUtil {

    public static boolean isEmpty(String line) {
        return TextUtils.isEmpty(line) || line.equals("\n") || line.equals("\t") || TextUtils.isEmpty(line.trim());
    }

    public static void printLine(String tag, boolean isTop) {
        if (isTop) {
            if (KLog.IS_UPLOAD_LOG) {
                HyperLog.d(tag,  "╔═══════════════════════════════════════════════════════════════════════════════════════");
            }
            else {
                Log.d(tag, "╔═══════════════════════════════════════════════════════════════════════════════════════");
            }
        } else {
            if (KLog.IS_UPLOAD_LOG) {
                HyperLog.d(tag, "╚═══════════════════════════════════════════════════════════════════════════════════════");
            }
            else {
                Log.d(tag, "╚═══════════════════════════════════════════════════════════════════════════════════════");
            }
        }
    }

}
