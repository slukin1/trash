package com.hbg.lib.common.dynamic.manager;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.hbg.lib.common.dynamic.downloader.Util;
import com.huobi.webcache.ReflectionUtil;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import e6.b;

public class ColorSrcAttribute {

    /* renamed from: a  reason: collision with root package name */
    public static final String[][] f67442a = {new String[]{"background", "setBackgroundColor", "http://schemas.android.com/apk/res/android", "color"}, new String[]{"textColor", "setTextColor", "http://schemas.android.com/apk/res/android", "color"}};

    @SuppressLint({"ResourceType"})
    public void a(View view, AttributeSet attributeSet) {
        View view2 = view;
        int length = f67442a.length;
        for (int i11 = 0; i11 < length; i11++) {
            String[][] strArr = f67442a;
            String str = strArr[i11][0];
            String attributeValue = attributeSet.getAttributeValue(strArr[i11][2], str);
            if (!TextUtils.isEmpty(attributeValue) && attributeValue.startsWith(TIMMentionEditText.TIM_MENTION_TAG)) {
                try {
                    int parseInt = Integer.parseInt(attributeValue.substring(1));
                    if (Util.a()) {
                        Log.d("ColorSrcAttribute", "load() called with: key = [" + attributeValue + "], method = [" + strArr[i11][1] + "], name = [" + str + "], key.substring(1) = [" + attributeValue.substring(1) + "], view.getContext() = [" + view.getContext() + "],view=" + view2);
                    }
                    if (b.v().w(parseInt)) {
                        ReflectionUtil.a(view2, strArr[i11][1], Integer.valueOf(view.getResources().getColor(parseInt, view.getContext().getTheme())));
                    }
                } catch (Throwable th2) {
                    Log.e("ColorSrcAttribute", "ReflectionUtil.callMethod: called  Throwable: method = [" + f67442a[i11][1] + "], key.substring(1) = [" + attributeValue.substring(1) + "], view.getContext() = [" + view.getContext() + "],view=" + view2, th2);
                }
            }
        }
    }
}
