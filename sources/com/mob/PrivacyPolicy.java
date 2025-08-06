package com.mob;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.commons.m;
import com.mob.commons.u;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.ClassKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.UIHandler;
import java.io.Serializable;
import java.util.Locale;
import org.json.JSONObject;

@Deprecated
public class PrivacyPolicy implements ClassKeeper, PublicMemberKeeper, Serializable {
    public static final int POLICY_TYPE_TXT = 2;
    public static final int POLICY_TYPE_URL = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f26837a;

    /* renamed from: b  reason: collision with root package name */
    private String f26838b;

    /* renamed from: c  reason: collision with root package name */
    private int f26839c;

    /* renamed from: d  reason: collision with root package name */
    private long f26840d;

    public interface OnPolicyListener extends ClassKeeper, PublicMemberKeeper {
        void onComplete(PrivacyPolicy privacyPolicy);

        void onFailure(Throwable th2);
    }

    public PrivacyPolicy() {
    }

    private String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String a11 = u.a();
            return new String(Data.AES128Decode(Data.rawMD5(a11 + ":" + DH.SyncMtd.getPackageName() + ":" + getTimestamp()), Base64.decode(str, 0)), "UTF-8");
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public static PrivacyPolicy getPrivacyPolicy(int i11, Locale locale) throws Throwable {
        return null;
    }

    @Deprecated
    public static void getPrivacyPolicyAsync(int i11, OnPolicyListener onPolicyListener) {
        getPrivacyPolicyAsync(i11, (Locale) null, onPolicyListener);
    }

    public String getContent() {
        return this.f26838b;
    }

    public int getPpVersion() {
        return this.f26839c;
    }

    public long getTimestamp() {
        return this.f26840d;
    }

    public String getTitle() {
        return this.f26837a;
    }

    public void setContent(String str) {
        this.f26838b = str;
    }

    public void setPpVersion(int i11) {
        this.f26839c = i11;
    }

    public void setTimestamp(long j11) {
        this.f26840d = j11;
    }

    public void setTitle(String str) {
        this.f26837a = str;
    }

    public PrivacyPolicy(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                setTimestamp(jSONObject.optLong(m.a("009g]bgbdQd)dg0gb$bdEh")));
                setTitle(a(jSONObject.optString("title")));
                setContent(a(jSONObject.optString(m.a("007a(bi]cgdcg"))));
                String a11 = a(jSONObject.optString("ppVersion"));
                if (!TextUtils.isEmpty(a11)) {
                    setPpVersion(Integer.parseInt(a11.trim()));
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    @Deprecated
    public static void getPrivacyPolicyAsync(int i11, Locale locale, final OnPolicyListener onPolicyListener) {
        if (onPolicyListener != null) {
            final Throwable th2 = new Throwable("This api is Deprecated, please do not call it");
            UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                public boolean handleMessage(Message message) {
                    OnPolicyListener.this.onFailure(th2);
                    return false;
                }
            });
        }
    }
}
