package com.ta.a.d;

import android.text.TextUtils;
import com.ta.a.e.h;
import com.tencent.qcloud.tuicore.TUIConstants;
import uy.d;
import vy.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f40357a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f40358b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f40359c = "";

    /* renamed from: d  reason: collision with root package name */
    public byte[] f40360d = null;

    /* renamed from: e  reason: collision with root package name */
    public long f40361e = 0;

    public static boolean a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                h.g("", "result", str, TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, str2);
                if (str2.equals(b.f(d.e(str).getBytes(), 2))) {
                    h.e("", "signature is ok");
                    return true;
                }
                h.e("", "signature is error");
            }
        } catch (Exception e11) {
            h.e("", e11);
        }
        return false;
    }
}
