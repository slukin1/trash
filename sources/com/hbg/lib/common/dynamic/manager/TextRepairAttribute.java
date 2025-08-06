package com.hbg.lib.common.dynamic.manager;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.hbg.lib.common.dynamic.downloader.Util;
import com.huobi.webcache.ReflectionUtil;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import e6.d;

public class TextRepairAttribute {
    @SuppressLint({"ResourceType"})
    public void a(View view, AttributeSet attributeSet) {
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        if (TextUtils.isEmpty(attributeValue) || !attributeValue.startsWith(TIMMentionEditText.TIM_MENTION_TAG)) {
            String attributeValue2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "title");
            String attributeValue3 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "titleText");
            if (!TextUtils.isEmpty(attributeValue2) && attributeValue2.startsWith(TIMMentionEditText.TIM_MENTION_TAG)) {
                try {
                    int parseInt = Integer.parseInt(attributeValue2.substring(1));
                    if (d.r().u(parseInt)) {
                        ReflectionUtil.a(view, "setTitle", view.getContext().getString(parseInt));
                    }
                } catch (Throwable th2) {
                    Log.e("TextRepairAttribute", "load: called setTitle Throwable: rs = [" + attributeValue + "], rs.substring(1) = [" + attributeValue.substring(1) + "], view.getContext() = [" + view.getContext() + "],view=" + view, th2);
                }
            } else if (!TextUtils.isEmpty(attributeValue3) && attributeValue3.startsWith(TIMMentionEditText.TIM_MENTION_TAG)) {
                try {
                    int parseInt2 = Integer.parseInt(attributeValue3.substring(1));
                    if (d.r().u(parseInt2)) {
                        ReflectionUtil.a(view, "setTitle", view.getContext().getString(parseInt2));
                    }
                } catch (Throwable th3) {
                    Log.e("TextRepairAttribute", "load: called setTitle Throwable: rs = [" + attributeValue + "], rs.substring(1) = [" + attributeValue.substring(1) + "], view.getContext() = [" + view.getContext() + "],view=" + view, th3);
                }
            }
        } else {
            try {
                int parseInt3 = Integer.parseInt(attributeValue.substring(1));
                if (Util.a()) {
                    Log.d("TextRepairAttribute", "load() called with: rs = [" + attributeValue + "], value = [" + parseInt3 + "], rs.substring(1) = [" + attributeValue.substring(1) + "], view.getContext() = [" + view.getContext() + "]" + view.getContext().getString(parseInt3) + ",view=" + view);
                }
                if (d.r().u(parseInt3)) {
                    ReflectionUtil.a(view, "setText", view.getContext().getString(parseInt3));
                }
            } catch (Throwable th4) {
                Log.e("TextRepairAttribute", "load: called setText Throwable: rs = [" + attributeValue + "], rs.substring(1) = [" + attributeValue.substring(1) + "], view.getContext() = [" + view.getContext() + "],view=" + view, th4);
            }
        }
    }
}
