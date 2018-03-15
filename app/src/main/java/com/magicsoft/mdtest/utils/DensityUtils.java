package com.magicsoft.mdtest.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/2/6
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class DensityUtils {


    /**
     * dp转pixel
     *
     * @param context 上下文对象
     * @param dp      dp
     * @return pixel
     */
    public static int dp2px(Context context, float dp) {
        DisplayMetrics metrics = getMetrics(context);
        return (int) (dp * (metrics.densityDpi / 160f));
    }

    public static DisplayMetrics getMetrics(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }
}
