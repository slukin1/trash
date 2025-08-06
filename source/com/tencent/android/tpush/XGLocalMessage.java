package com.tencent.android.tpush;

import android.text.TextUtils;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

public class XGLocalMessage {
    private long A = (System.currentTimeMillis() + (((long) this.f67809z) * 1000));
    private int B = 0;
    private String C = "";
    private int D = 2;
    private String E = "";
    private String F = "";
    private String G = "";
    private int H = -1;
    private String I = "";
    private int J = -1;

    /* renamed from: a  reason: collision with root package name */
    private int f67784a = 1;

    /* renamed from: b  reason: collision with root package name */
    private String f67785b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f67786c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f67787d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f67788e = "00";

    /* renamed from: f  reason: collision with root package name */
    private String f67789f = "00";

    /* renamed from: g  reason: collision with root package name */
    private int f67790g = 1;

    /* renamed from: h  reason: collision with root package name */
    private int f67791h = 1;

    /* renamed from: i  reason: collision with root package name */
    private int f67792i = 1;

    /* renamed from: j  reason: collision with root package name */
    private int f67793j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f67794k = 1;

    /* renamed from: l  reason: collision with root package name */
    private String f67795l = "";

    /* renamed from: m  reason: collision with root package name */
    private String f67796m = "";

    /* renamed from: n  reason: collision with root package name */
    private String f67797n = "";
    public String nGroupId = "";

    /* renamed from: o  reason: collision with root package name */
    private int f67798o = 1;

    /* renamed from: p  reason: collision with root package name */
    private String f67799p = "";
    public int pushChannel = 99;
    public long pushTime = 0;

    /* renamed from: q  reason: collision with root package name */
    private String f67800q = "";

    /* renamed from: r  reason: collision with root package name */
    private String f67801r = "";

    /* renamed from: s  reason: collision with root package name */
    private String f67802s = "";
    public long source = 0;

    /* renamed from: t  reason: collision with root package name */
    private String f67803t = "";
    public long targetType = 0;
    public String templateId = "";
    public String traceId = "";

    /* renamed from: u  reason: collision with root package name */
    private String f67804u = "{}";

    /* renamed from: v  reason: collision with root package name */
    private long f67805v;

    /* renamed from: w  reason: collision with root package name */
    private int f67806w = 0;

    /* renamed from: x  reason: collision with root package name */
    private long f67807x = (System.currentTimeMillis() * -1);

    /* renamed from: y  reason: collision with root package name */
    private long f67808y = 0;

    /* renamed from: z  reason: collision with root package name */
    private int f67809z = 2592000;

    public int getAction_type() {
        return this.f67798o;
    }

    public String getActivity() {
        return this.f67799p;
    }

    public int getBadgeType() {
        return this.H;
    }

    public long getBuilderId() {
        return this.f67805v;
    }

    public long getBusiMsgId() {
        return this.f67808y;
    }

    public String getChannelId() {
        return this.C;
    }

    public int getColor() {
        return this.B;
    }

    public String getContent() {
        return this.f67786c;
    }

    public String getCustom_content() {
        return this.f67804u;
    }

    public String getDate() {
        if (!j.b(this.f67787d)) {
            try {
                String substring = this.f67787d.substring(0, 8);
                this.f67787d = substring;
                Long.parseLong(substring);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                simpleDateFormat.setLenient(false);
                simpleDateFormat.parse(this.f67787d);
            } catch (ParseException e11) {
                TLogger.e("XGLocalMessage", "XGLocalMessage.getDate()", e11);
                return new SimpleDateFormat("yyyyMMdd").format(new Date());
            } catch (Throwable th2) {
                TLogger.e("XGLocalMessage", "XGLocalMessage.getDate()", th2);
                return new SimpleDateFormat("yyyyMMdd").format(new Date());
            }
        }
        return this.f67787d;
    }

    public long getExpirationTimeMs() {
        return this.A;
    }

    public String getHour() {
        if (this.f67788e.length() < 1) {
            return "00";
        }
        if (this.f67788e.length() <= 0 || this.f67788e.length() >= 2) {
            return this.f67788e;
        }
        return "0" + this.f67788e;
    }

    public String getIcon_res() {
        return this.f67796m;
    }

    public int getIcon_type() {
        return this.f67793j;
    }

    public String getIntent() {
        return this.f67801r;
    }

    public int getLights() {
        return this.f67792i;
    }

    public String getMin() {
        if (this.f67789f.length() < 1) {
            return "00";
        }
        if (this.f67789f.length() <= 0 || this.f67789f.length() >= 2) {
            return this.f67789f;
        }
        return "0" + this.f67789f;
    }

    public long getMsgId() {
        return this.f67807x;
    }

    public String getNotificationCategory() {
        String str = this.I;
        return (str == null || TextUtils.isEmpty(str.trim())) ? "" : this.I;
    }

    public int getNotificationId() {
        return this.f67806w;
    }

    public int getNotificationImportance() {
        int i11 = this.J;
        if (i11 < 0 || i11 > 5) {
            return -1;
        }
        return i11;
    }

    public int getNsModel() {
        return this.D;
    }

    public String getPackageDownloadUrl() {
        return this.f67802s;
    }

    public String getPackageName() {
        return this.f67803t;
    }

    public int getRing() {
        return this.f67790g;
    }

    public String getRing_raw() {
        return this.f67795l;
    }

    public String getSmall_icon() {
        return this.f67797n;
    }

    public int getStyle_id() {
        return this.f67794k;
    }

    public String getThreadId() {
        return this.F;
    }

    public String getThreadSumText() {
        return this.G;
    }

    public String getTitle() {
        return this.f67785b;
    }

    public String getTpns_media_resources() {
        return this.E;
    }

    public int getTtl() {
        return this.f67809z;
    }

    public int getType() {
        return this.f67784a;
    }

    public String getUrl() {
        return this.f67800q;
    }

    public int getVibrate() {
        return this.f67791h;
    }

    public void setAction_type(int i11) {
        this.f67798o = i11;
    }

    public void setActivity(String str) {
        this.f67799p = str;
    }

    public void setBadgeType(int i11) {
        this.H = i11;
    }

    public void setBuilderId(long j11) {
        this.f67805v = j11;
    }

    public void setBusiMsgId(long j11) {
        this.f67808y = j11;
    }

    public void setChannelId(String str) {
        this.C = str;
    }

    public void setColor(int i11) {
        this.B = i11;
    }

    public void setContent(String str) {
        this.f67786c = str;
    }

    public void setCustomContent(HashMap<String, Object> hashMap) {
        this.f67804u = new JSONObject(hashMap).toString();
    }

    public void setDate(String str) {
        this.f67787d = str;
    }

    public void setExpirationTimeMs(long j11) {
        if (j11 > System.currentTimeMillis()) {
            int currentTimeMillis = (int) ((j11 - System.currentTimeMillis()) / 1000);
            this.f67809z = currentTimeMillis;
            if (currentTimeMillis < 0) {
                this.f67809z = Integer.MAX_VALUE;
            }
            this.A = j11;
        }
    }

    public void setHour(String str) {
        this.f67788e = str;
    }

    public void setIcon_res(String str) {
        this.f67796m = str;
    }

    public void setIcon_type(int i11) {
        this.f67793j = i11;
    }

    public void setIntent(String str) {
        String str2;
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "";
        }
        this.f67801r = str2;
    }

    public void setLights(int i11) {
        this.f67792i = i11;
    }

    public void setMin(String str) {
        this.f67789f = str;
    }

    public void setMsgId(long j11) {
        this.f67807x = j11;
    }

    public boolean setNotificationCategory(String str) {
        this.I = str;
        return true;
    }

    public void setNotificationId(int i11) {
        this.f67806w = i11;
    }

    public boolean setNotificationImportance(int i11) {
        if (i11 <= 0 || i11 > 5) {
            TLogger.w("XGLocalMessage", "invalid notification importance , notificationImportance:" + i11);
            return false;
        }
        this.J = i11;
        return true;
    }

    public void setNsModel(int i11) {
        this.D = i11;
    }

    public void setPackageDownloadUrl(String str) {
        this.f67802s = str;
    }

    public void setPackageName(String str) {
        this.f67803t = str;
    }

    public void setRing(int i11) {
        this.f67790g = i11;
    }

    public void setRing_raw(String str) {
        this.f67795l = str;
    }

    public void setSmall_icon(String str) {
        this.f67797n = str;
    }

    public void setStyle_id(int i11) {
        this.f67794k = i11;
    }

    public void setThreadId(String str) {
        this.F = str;
    }

    public void setThreadSumText(String str) {
        this.G = str;
    }

    public void setTitle(String str) {
        this.f67785b = str;
    }

    public void setTpns_media_resources(String str) {
        this.E = str;
    }

    public void setType(int i11) {
        this.f67784a = i11;
    }

    public void setUrl(String str) {
        this.f67800q = str;
    }

    public void setVibrate(int i11) {
        this.f67791h = i11;
    }

    public String toString() {
        return "XGLocalMessage [type=" + this.f67784a + ", title=" + this.f67785b + ", content=" + this.f67786c + ", date=" + this.f67787d + ", hour=" + this.f67788e + ", min=" + this.f67789f + ", builderId=" + this.f67805v + ", msgid=" + this.f67807x + ", templateId=" + this.templateId + ", traceId=" + this.traceId + ", busiMsgId=" + this.f67808y + "]";
    }
}
