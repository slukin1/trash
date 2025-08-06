package com.tencent.qcloud.tuikit.timcommon.util;

import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;

public class SoftKeyBoardUtil {
    private static SharedPreferences preferences = TUIConfig.getAppContext().getSharedPreferences(TUIConstants.TUIChat.UI_PARAMS, 0);
    private static int softKeyBoardHeight;

    private static int getNavigateBarHeight(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i11 = displayMetrics.heightPixels;
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i12 = displayMetrics.heightPixels;
        if (i12 > i11) {
            return i12 - i11;
        }
        return 0;
    }

    public static int[] getScreenSize() {
        DisplayMetrics displayMetrics = TUIConfig.getAppContext().getResources().getDisplayMetrics();
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static int getSoftKeyBoardHeight() {
        int i11 = softKeyBoardHeight;
        if (i11 != 0) {
            return i11;
        }
        int i12 = preferences.getInt(TUIConstants.TUIChat.SOFT_KEY_BOARD_HEIGHT, 0);
        softKeyBoardHeight = i12;
        return i12 == 0 ? (getScreenSize()[1] * 2) / 5 : i12;
    }

    public static void hideKeyBoard(IBinder iBinder) {
        InputMethodManager inputMethodManager = (InputMethodManager) TUIConfig.getAppContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }
    }

    private static boolean isSoftInputShown(Window window) {
        View decorView = window.getDecorView();
        int height = decorView.getHeight();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        return (height - rect.bottom) - getNavigateBarHeight(window.getWindowManager()) >= 0;
    }

    public static void showKeyBoard(Window window) {
        InputMethodManager inputMethodManager = (InputMethodManager) TUIConfig.getAppContext().getSystemService("input_method");
        if (inputMethodManager != null && !isSoftInputShown(window)) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
    }

    public static void hideKeyBoard(Window window) {
        InputMethodManager inputMethodManager = (InputMethodManager) TUIConfig.getAppContext().getSystemService("input_method");
        if (inputMethodManager != null && isSoftInputShown(window)) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
    }
}
