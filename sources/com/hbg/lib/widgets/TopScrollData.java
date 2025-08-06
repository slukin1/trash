package com.hbg.lib.widgets;

import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.HomePageNoticeData;

public class TopScrollData {

    /* renamed from: a  reason: collision with root package name */
    public String f71623a;

    /* renamed from: b  reason: collision with root package name */
    public String f71624b;

    /* renamed from: c  reason: collision with root package name */
    public String f71625c;

    /* renamed from: d  reason: collision with root package name */
    public int f71626d;

    /* renamed from: e  reason: collision with root package name */
    public String f71627e;

    /* renamed from: f  reason: collision with root package name */
    public long f71628f;

    public boolean a(Object obj) {
        return obj instanceof TopScrollData;
    }

    public int b() {
        if (TextUtils.isEmpty(this.f71627e)) {
            return R$color.color_0066ED;
        }
        String str = this.f71627e;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1307282352:
                if (str.equals(HomePageNoticeData.TAG_Promotions)) {
                    c11 = 0;
                    break;
                }
                break;
            case 321102183:
                if (str.equals(HomePageNoticeData.TAG_Announcement)) {
                    c11 = 1;
                    break;
                }
                break;
            case 1440520720:
                if (str.equals(HomePageNoticeData.TAG_NEW_COIN)) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return R$color.color_6951FF;
            case 1:
                return R$color.color_0066ED;
            case 2:
                return R$color.color_20B452;
            default:
                return R$color.color_0066ED;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r0.equals(com.hbg.lib.network.hbg.core.bean.HomePageNoticeData.TAG_Promotions) == false) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int c() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f71627e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.String r0 = r4.f71627e
            r0.hashCode()
            r2 = -1
            int r3 = r0.hashCode()
            switch(r3) {
                case -1307282352: goto L_0x002f;
                case 321102183: goto L_0x0024;
                case 1440520720: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            r1 = r2
            goto L_0x0038
        L_0x0019:
            java.lang.String r1 = "New_Coin"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0022
            goto L_0x0017
        L_0x0022:
            r1 = 2
            goto L_0x0038
        L_0x0024:
            java.lang.String r1 = "Announcement"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002d
            goto L_0x0017
        L_0x002d:
            r1 = 1
            goto L_0x0038
        L_0x002f:
            java.lang.String r3 = "Promotions"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0038
            goto L_0x0017
        L_0x0038:
            switch(r1) {
                case 0: goto L_0x0044;
                case 1: goto L_0x0041;
                case 2: goto L_0x003e;
                default: goto L_0x003b;
            }
        L_0x003b:
            int r0 = com.hbg.lib.widgets.R$string.n_notice_hot
            goto L_0x0046
        L_0x003e:
            int r0 = com.hbg.lib.widgets.R$string.n_notice_new_coin
            goto L_0x0046
        L_0x0041:
            int r0 = com.hbg.lib.widgets.R$string.n_notice_hot
            goto L_0x0046
        L_0x0044:
            int r0 = com.hbg.lib.widgets.R$string.n_notice_event
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.TopScrollData.c():int");
    }

    public int d() {
        return this.f71626d;
    }

    public String e() {
        return this.f71623a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TopScrollData)) {
            return false;
        }
        TopScrollData topScrollData = (TopScrollData) obj;
        if (!topScrollData.a(this)) {
            return false;
        }
        String e11 = e();
        String e12 = topScrollData.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = topScrollData.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String j11 = j();
        String j12 = topScrollData.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        if (d() != topScrollData.d()) {
            return false;
        }
        String h11 = h();
        String h12 = topScrollData.h();
        if (h11 != null ? h11.equals(h12) : h12 == null) {
            return g() == topScrollData.g();
        }
        return false;
    }

    public String f() {
        return this.f71624b;
    }

    public long g() {
        return this.f71628f;
    }

    public String h() {
        return this.f71627e;
    }

    public int hashCode() {
        String e11 = e();
        int i11 = 43;
        int hashCode = e11 == null ? 43 : e11.hashCode();
        String f11 = f();
        int hashCode2 = ((hashCode + 59) * 59) + (f11 == null ? 43 : f11.hashCode());
        String j11 = j();
        int hashCode3 = (((hashCode2 * 59) + (j11 == null ? 43 : j11.hashCode())) * 59) + d();
        String h11 = h();
        int i12 = hashCode3 * 59;
        if (h11 != null) {
            i11 = h11.hashCode();
        }
        long g11 = g();
        return ((i12 + i11) * 59) + ((int) ((g11 >>> 32) ^ g11));
    }

    public int i() {
        if (TextUtils.isEmpty(this.f71627e)) {
            return R$drawable.home_news_image;
        }
        String str = this.f71627e;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1307282352:
                if (str.equals(HomePageNoticeData.TAG_Promotions)) {
                    c11 = 0;
                    break;
                }
                break;
            case 321102183:
                if (str.equals(HomePageNoticeData.TAG_Announcement)) {
                    c11 = 1;
                    break;
                }
                break;
            case 1440520720:
                if (str.equals(HomePageNoticeData.TAG_NEW_COIN)) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return R$drawable.home_news_image_active;
            case 1:
                return R$drawable.home_news_image;
            case 2:
                return R$drawable.home_news_image_new_coin;
            default:
                return R$drawable.home_news_image;
        }
    }

    public String j() {
        return this.f71625c;
    }

    public void k(int i11) {
        this.f71626d = i11;
    }

    public void l(String str) {
        this.f71623a = str;
    }

    public void m(String str) {
        this.f71624b = str;
    }

    public void n(String str) {
        this.f71625c = str;
    }

    public String toString() {
        return "[" + this.f71623a + " " + this.f71624b + "]";
    }
}
