package com.twitter.sdk.android.core.internal;

import android.text.TextUtils;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.twitter.sdk.android.core.models.User;

public final class UserUtils {

    /* renamed from: com.twitter.sdk.android.core.internal.UserUtils$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$twitter$sdk$android$core$internal$UserUtils$AvatarSize;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.twitter.sdk.android.core.internal.UserUtils$AvatarSize[] r0 = com.twitter.sdk.android.core.internal.UserUtils.AvatarSize.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$twitter$sdk$android$core$internal$UserUtils$AvatarSize = r0
                com.twitter.sdk.android.core.internal.UserUtils$AvatarSize r1 = com.twitter.sdk.android.core.internal.UserUtils.AvatarSize.NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$twitter$sdk$android$core$internal$UserUtils$AvatarSize     // Catch:{ NoSuchFieldError -> 0x001d }
                com.twitter.sdk.android.core.internal.UserUtils$AvatarSize r1 = com.twitter.sdk.android.core.internal.UserUtils.AvatarSize.BIGGER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$twitter$sdk$android$core$internal$UserUtils$AvatarSize     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.twitter.sdk.android.core.internal.UserUtils$AvatarSize r1 = com.twitter.sdk.android.core.internal.UserUtils.AvatarSize.MINI     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$twitter$sdk$android$core$internal$UserUtils$AvatarSize     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.twitter.sdk.android.core.internal.UserUtils$AvatarSize r1 = com.twitter.sdk.android.core.internal.UserUtils.AvatarSize.ORIGINAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$twitter$sdk$android$core$internal$UserUtils$AvatarSize     // Catch:{ NoSuchFieldError -> 0x003e }
                com.twitter.sdk.android.core.internal.UserUtils$AvatarSize r1 = com.twitter.sdk.android.core.internal.UserUtils.AvatarSize.REASONABLY_SMALL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.UserUtils.AnonymousClass1.<clinit>():void");
        }
    }

    public enum AvatarSize {
        NORMAL("_normal"),
        BIGGER("_bigger"),
        MINI("_mini"),
        ORIGINAL("_original"),
        REASONABLY_SMALL("_reasonably_small");
        
        private final String suffix;

        private AvatarSize(String str) {
            this.suffix = str;
        }

        public String getSuffix() {
            return this.suffix;
        }
    }

    private UserUtils() {
    }

    public static CharSequence formatScreenName(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        if (charSequence.charAt(0) == '@') {
            return charSequence;
        }
        return TIMMentionEditText.TIM_MENTION_TAG + charSequence;
    }

    public static String getProfileImageUrlHttps(User user, AvatarSize avatarSize) {
        String str;
        if (user == null || (str = user.profileImageUrlHttps) == null) {
            return null;
        }
        if (avatarSize == null || str == null) {
            return str;
        }
        int i11 = AnonymousClass1.$SwitchMap$com$twitter$sdk$android$core$internal$UserUtils$AvatarSize[avatarSize.ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4 || i11 == 5) {
            return str.replace(AvatarSize.NORMAL.getSuffix(), avatarSize.getSuffix());
        }
        return str;
    }
}
