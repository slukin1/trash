package com.huobi.social.share;

import android.content.Context;
import android.content.Intent;
import vr.c;
import vr.d;
import vr.h;
import vr.i;
import vr.k;
import vr.l;
import vr.m;
import vr.n;
import yr.b;

public class HBShareHelper extends vr.a {

    /* renamed from: d  reason: collision with root package name */
    public vr.a f81152d;

    public enum HbPlatform {
        TYPE_FACEBOOK("FACEBOOK"),
        TYPE_TWITTER("TWITTER"),
        TYPE_INSTAGRAM("INSTAGRAM"),
        TYPE_TELEGRAM("TELEGRAM"),
        TYPE_COMMUNITY("COMMUNITY"),
        TYPE_GROUP("GROUP"),
        TYPE_COPY_TEXT("COPY_TEXT"),
        TYPE_SAVE("TYPE_SAVE"),
        TYPE_MORE("MORE"),
        TYPE_KA_KAO("KA_KAO"),
        TYPE_LINE("LINE"),
        TYPE_WHATSAPP("WHATSAPP"),
        NONE("NONE"),
        TYPE_QQ("QQ"),
        TYPE_WECHAT("WECHAT"),
        TYPE_WECHAT_MOMENTS("WECHAT_MOMENTS"),
        TYPE_WEIBO("WEIBO"),
        TYPE_POSTER("TYPE_POSTER");
        
        public final String value;

        private HbPlatform(String str) {
            this.value = str;
        }
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f81153a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.social.share.HBShareHelper$HbPlatform[] r0 = com.huobi.social.share.HBShareHelper.HbPlatform.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f81153a = r0
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_WECHAT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f81153a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_WECHAT_MOMENTS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f81153a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_TELEGRAM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f81153a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_FACEBOOK     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f81153a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_COPY_TEXT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f81153a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_MORE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f81153a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_INSTAGRAM     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f81153a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_TWITTER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f81153a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_COMMUNITY     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f81153a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_GROUP     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f81153a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_KA_KAO     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f81153a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_LINE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f81153a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_WHATSAPP     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.social.share.HBShareHelper.a.<clinit>():void");
        }
    }

    public HBShareHelper(Context context, HbPlatform hbPlatform) {
        super(context);
        this.f85013a = true;
        switch (a.f81153a[hbPlatform.ordinal()]) {
            case 1:
            case 2:
                this.f81152d = new b(context, hbPlatform);
                return;
            case 3:
                this.f81152d = new wr.a(context);
                return;
            case 4:
                this.f81152d = new a(context);
                return;
            case 5:
                this.f81152d = new d(context);
                return;
            case 6:
                this.f81152d = new l(context);
                return;
            case 7:
                this.f81152d = new i(context);
                return;
            case 8:
                this.f81152d = new m(context);
                return;
            case 9:
                this.f81152d = new h(context);
                return;
            case 10:
                this.f81152d = new c(context);
                return;
            case 11:
                this.f81152d = new b(context);
                return;
            case 12:
                this.f81152d = new k(context);
                return;
            case 13:
                this.f81152d = new n(context);
                return;
            default:
                return;
        }
    }

    public void b(int i11, int i12, Intent intent) {
        super.b(i11, i12, intent);
        vr.a aVar = this.f81152d;
        if (aVar != null) {
            aVar.b(i11, i12, intent);
        }
    }

    public void c(String str, String str2, String str3) {
        vr.a aVar = this.f81152d;
        if (aVar != null) {
            aVar.g(str, str2, str3);
        }
    }

    public void d(String str) {
        vr.a aVar = this.f81152d;
        if (aVar != null) {
            aVar.h(str);
        }
    }

    public void e(String str, String str2, String str3) {
        vr.a aVar = this.f81152d;
        if (aVar != null) {
            aVar.i(str, str2, str3);
        }
    }

    public void f(String str, String str2, String str3, String str4) {
        vr.a aVar = this.f81152d;
        if (aVar != null) {
            aVar.j(str, str2, str3, str4);
        }
    }
}
