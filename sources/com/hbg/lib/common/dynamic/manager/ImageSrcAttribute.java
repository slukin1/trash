package com.hbg.lib.common.dynamic.manager;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.hbg.lib.common.dynamic.downloader.Util;
import com.huobi.webcache.ReflectionUtil;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import e6.g;

public class ImageSrcAttribute {

    /* renamed from: a  reason: collision with root package name */
    public static final String[][] f67457a = {new String[]{"background", "setBackgroundDrawable", "http://schemas.android.com/apk/res/android", "drawable"}, new String[]{"src", "setImageDrawable", "http://schemas.android.com/apk/res/android", "drawable"}, new String[]{"empty_img_res", "updateImageDrawable", "http://schemas.android.com/apk/res-auto", "drawable"}, new String[]{"drawable_checked", "setImageDrawable", "http://schemas.android.com/apk/res-auto", "drawable"}, new String[]{"drawable_unchecked", "setImageDrawable", "http://schemas.android.com/apk/res-auto", "drawable"}, new String[]{"divider", "setDividerDrawable", "http://schemas.android.com/apk/res/android", "drawable"}, new String[]{"button", "setButtonDrawable", "http://schemas.android.com/apk/res/android", "drawable"}, new String[]{"progressDrawable", "setProgressDrawable", "http://schemas.android.com/apk/res/android", "drawable"}};

    @SuppressLint({"ResourceType"})
    public void a(View view, AttributeSet attributeSet) {
        View view2 = view;
        int length = f67457a.length;
        for (int i11 = 0; i11 < length; i11++) {
            String[][] strArr = f67457a;
            String str = strArr[i11][0];
            String attributeValue = attributeSet.getAttributeValue(strArr[i11][2], str);
            if (!TextUtils.isEmpty(attributeValue) && attributeValue.startsWith(TIMMentionEditText.TIM_MENTION_TAG)) {
                try {
                    int parseInt = Integer.parseInt(attributeValue.substring(1));
                    if (Util.a()) {
                        Log.d("ImageSrcAttribute", "load() called with: key = [" + attributeValue + "], method = [" + strArr[i11][1] + "], name = [" + str + "], key.substring(1) = [" + attributeValue.substring(1) + "], view.getContext() = [" + view.getContext() + "],view=" + view2);
                    }
                    if (g.v().w(parseInt)) {
                        if (strArr[i11][3].equals("id")) {
                            ReflectionUtil.a(view2, strArr[i11][1], Integer.valueOf(parseInt));
                        } else {
                            ReflectionUtil.a(view2, strArr[i11][1], view.getContext().getDrawable(parseInt));
                        }
                    }
                } catch (Throwable th2) {
                    Log.e("ImageSrcAttribute", "ReflectionUtil.callMethod: called  Throwable: method = [" + f67457a[i11][1] + "], key.substring(1) = [" + attributeValue.substring(1) + "], view.getContext() = [" + view.getContext() + "],view=" + view2, th2);
                }
            }
        }
    }
}
