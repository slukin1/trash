package com.huobi.social.share.event;

import android.text.TextUtils;
import bh.j;
import com.huobi.social.share.HBShareHelper;
import pro.huobi.R;

public class ShareBusEvent {

    /* renamed from: a  reason: collision with root package name */
    public HBShareHelper.HbPlatform f81156a;

    /* renamed from: b  reason: collision with root package name */
    public Type f81157b;

    /* renamed from: c  reason: collision with root package name */
    public String f81158c;

    public enum Type {
        SUCCESS,
        CANCEL,
        COMPLETED,
        FAILURE
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f81159a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.social.share.HBShareHelper$HbPlatform[] r0 = com.huobi.social.share.HBShareHelper.HbPlatform.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f81159a = r0
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_WEIBO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f81159a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_QQ     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f81159a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_WECHAT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f81159a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_TWITTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f81159a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_FACEBOOK     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f81159a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_TELEGRAM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f81159a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_WECHAT_MOMENTS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.social.share.event.ShareBusEvent.a.<clinit>():void");
        }
    }

    public ShareBusEvent(HBShareHelper.HbPlatform hbPlatform, Type type) {
        this.f81156a = hbPlatform;
        this.f81157b = type;
    }

    public String a() {
        switch (a.f81159a[this.f81156a.ordinal()]) {
            case 1:
                this.f81158c = j.c().getResources().getString(R.string.ssdk_sinaweibo);
                break;
            case 2:
                this.f81158c = j.c().getResources().getString(R.string.ssdk_qq);
                break;
            case 3:
                this.f81158c = j.c().getResources().getString(R.string.ssdk_wechat);
                break;
            case 4:
                this.f81158c = j.c().getResources().getString(R.string.ssdk_twitter);
                break;
            case 5:
                this.f81158c = j.c().getResources().getString(R.string.ssdk_facebook);
                break;
            case 6:
                this.f81158c = j.c().getResources().getString(R.string.ssdk_telegram);
                break;
            case 7:
                this.f81158c = j.c().getResources().getString(R.string.ssdk_wechatmoments);
                break;
        }
        String string = j.c().getResources().getString(c() ? R.string.invite_share_completed : R.string.invite_share_fail);
        if (b()) {
            string = j.c().getResources().getString(R.string.invite_share_completed);
        }
        if (TextUtils.isEmpty(this.f81158c)) {
            return string;
        }
        return this.f81158c + " " + string;
    }

    public boolean b() {
        return this.f81157b == Type.COMPLETED;
    }

    public boolean c() {
        return this.f81157b == Type.SUCCESS;
    }
}
