package com.huobi.sharev2.helper;

import android.content.Context;
import cn.sharesdk.line.Line;
import cn.sharesdk.telegram.Telegram;
import cn.sharesdk.whatsapp.WhatsApp;
import com.huobi.social.share.HBShareHelper;
import com.tencent.imsdk.v2.V2TIMConversation;
import io.flutter.plugins.firebase.crashlytics.Constants;
import pro.huobi.R;

public class NewShareChannelHelper {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f81130a;

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
                f81130a = r0
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_FACEBOOK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f81130a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_TWITTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f81130a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_INSTAGRAM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f81130a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_TELEGRAM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f81130a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_COPY_TEXT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f81130a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_POSTER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f81130a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_SAVE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f81130a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_MORE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f81130a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_COMMUNITY     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f81130a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_GROUP     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f81130a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_KA_KAO     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f81130a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_LINE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f81130a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_WHATSAPP     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.sharev2.helper.NewShareChannelHelper.a.<clinit>():void");
        }
    }

    public static String a(String str, String str2) {
        return NewShareHelper.p(str) ? NewShareHelper.n() : str;
    }

    public static HBShareHelper.HbPlatform b(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1480249367:
                if (str.equals("community")) {
                    c11 = 0;
                    break;
                }
                break;
            case 3260:
                if (str.equals("fb")) {
                    c11 = 1;
                    break;
                }
                break;
            case 3715:
                if (str.equals("tw")) {
                    c11 = 2;
                    break;
                }
                break;
            case 104430:
                if (str.equals("ins")) {
                    c11 = 3;
                    break;
                }
                break;
            case 114715:
                if (str.equals("tel")) {
                    c11 = 4;
                    break;
                }
                break;
            case 3321844:
                if (str.equals(Constants.LINE)) {
                    c11 = 5;
                    break;
                }
                break;
            case 98629247:
                if (str.equals(V2TIMConversation.CONVERSATION_GROUP_TYPE)) {
                    c11 = 6;
                    break;
                }
                break;
            case 101812419:
                if (str.equals("kakao")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1934780818:
                if (str.equals("whatsapp")) {
                    c11 = 8;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return HBShareHelper.HbPlatform.TYPE_COMMUNITY;
            case 1:
                return HBShareHelper.HbPlatform.TYPE_FACEBOOK;
            case 2:
                return HBShareHelper.HbPlatform.TYPE_TWITTER;
            case 3:
                return HBShareHelper.HbPlatform.TYPE_INSTAGRAM;
            case 4:
                return HBShareHelper.HbPlatform.TYPE_TELEGRAM;
            case 5:
                return HBShareHelper.HbPlatform.TYPE_LINE;
            case 6:
                return HBShareHelper.HbPlatform.TYPE_GROUP;
            case 7:
                return HBShareHelper.HbPlatform.TYPE_KA_KAO;
            case 8:
                return HBShareHelper.HbPlatform.TYPE_WHATSAPP;
            default:
                return HBShareHelper.HbPlatform.NONE;
        }
    }

    public static int c(HBShareHelper.HbPlatform hbPlatform) {
        switch (a.f81130a[hbPlatform.ordinal()]) {
            case 1:
                return R.drawable.icon_new_share_facebook;
            case 2:
                return R.drawable.icon_new_share_twitter;
            case 3:
                return R.drawable.icon_new_share_ins;
            case 4:
                return R.drawable.icon_new_share_telegram;
            case 5:
                return R.drawable.icon_new_share_copy_link;
            case 6:
                return R.drawable.icon_new_share_poster;
            case 7:
                return R.drawable.icon_new_share_save;
            case 8:
                return R.drawable.icon_new_share_system;
            case 9:
                return R.drawable.icon_new_share_feed;
            case 10:
                return R.drawable.icon_new_share_community;
            case 11:
                return R.drawable.icon_new_share_kakao;
            case 12:
                return R.drawable.icon_new_share_line;
            case 13:
                return R.drawable.icon_new_share_whatsapp;
            default:
                return -1;
        }
    }

    public static String d(HBShareHelper.HbPlatform hbPlatform, Context context) {
        if (context == null) {
            return "";
        }
        switch (a.f81130a[hbPlatform.ordinal()]) {
            case 1:
                return "Facebook";
            case 2:
                return "X";
            case 3:
                return "Instagram";
            case 4:
                return Telegram.NAME;
            case 5:
                return context.getString(R.string.n_red_envelope_copy_url);
            case 6:
                return context.getString(R.string.n_share_poster_share);
            case 7:
                return context.getString(R.string.n_share_save_image);
            case 8:
                return context.getString(R.string.n_user_center_share_more);
            case 9:
                return context.getString(R.string.n_share_huobi_community);
            case 10:
                return context.getString(R.string.n_share_huobi_group);
            case 11:
                return "Kakao";
            case 12:
                return Line.NAME;
            case 13:
                return WhatsApp.NAME;
            default:
                return "";
        }
    }
}
