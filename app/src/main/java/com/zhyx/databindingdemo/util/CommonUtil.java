package com.zhyx.databindingdemo.util;

import android.content.res.Resources;

public class CommonUtil {
    /**
     * 计算状态栏高度高度
     * getStatusBarHeight
     */
    public static int getStatusBarHeight() {
        return getInternalDimensionSize(Resources.getSystem(), "status_bar_height");
    }

    private static int getInternalDimensionSize(Resources res, String key) {
        int result = 0;
        int resourceId = res.getIdentifier(key, "dimen", "android");
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
