package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.huobi.view.roundimg.RoundedDrawable;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaCodecProfileLevel;

public final class FeatureManager {

    /* renamed from: com.facebook.internal.FeatureManager$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$internal$FeatureManager$Feature;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.internal.FeatureManager$Feature[] r0 = com.facebook.internal.FeatureManager.Feature.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$internal$FeatureManager$Feature = r0
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.RestrictiveDataFiltering     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.Instrument     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.CrashReport     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.ErrorReport     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.AAM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.PrivacyProtection     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.SuggestedEvents     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.PIIFiltering     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x006c }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.EventDeactivation     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.Core     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.AppEvents     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.CodelessEvents     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x009c }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.Login     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.Share     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$facebook$internal$FeatureManager$Feature     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.Places     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FeatureManager.AnonymousClass2.<clinit>():void");
        }
    }

    public interface Callback {
        void onCompleted(boolean z11);
    }

    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        PIIFiltering(66562),
        EventDeactivation(66816),
        Instrument(131072),
        CrashReport(131328),
        ErrorReport(131584),
        Login(16777216),
        Share(TPMediaCodecProfileLevel.HEVCHighTierLevel62),
        Places(50331648);
        
        private final int code;

        private Feature(int i11) {
            this.code = i11;
        }

        public static Feature fromInt(int i11) {
            for (Feature feature : values()) {
                if (feature.code == i11) {
                    return feature;
                }
            }
            return Unknown;
        }

        public Feature getParent() {
            int i11 = this.code;
            if ((i11 & 255) > 0) {
                return fromInt(i11 & -256);
            }
            if ((65280 & i11) > 0) {
                return fromInt(i11 & -65536);
            }
            if ((16711680 & i11) > 0) {
                return fromInt(i11 & RoundedDrawable.DEFAULT_BORDER_COLOR);
            }
            return fromInt(0);
        }

        public String toString() {
            switch (AnonymousClass2.$SwitchMap$com$facebook$internal$FeatureManager$Feature[ordinal()]) {
                case 1:
                    return "RestrictiveDataFiltering";
                case 2:
                    return "Instrument";
                case 3:
                    return "CrashReport";
                case 4:
                    return "ErrorReport";
                case 5:
                    return "AAM";
                case 6:
                    return "PrivacyProtection";
                case 7:
                    return "SuggestedEvents";
                case 8:
                    return "PIIFiltering";
                case 9:
                    return "EventDeactivation";
                case 10:
                    return "CoreKit";
                case 11:
                    return "AppEvents";
                case 12:
                    return "CodelessEvents";
                case 13:
                    return "LoginKit";
                case 14:
                    return "ShareKit";
                case 15:
                    return "PlacesKit";
                default:
                    return "unknown";
            }
        }
    }

    public static void checkFeature(final Feature feature, final Callback callback) {
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync(new FetchedAppGateKeepersManager.Callback() {
            public void onCompleted() {
                callback.onCompleted(FeatureManager.isEnabled(feature));
            }
        });
    }

    private static boolean defaultStatus(Feature feature) {
        switch (AnonymousClass2.$SwitchMap$com$facebook$internal$FeatureManager$Feature[feature.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                return true;
        }
    }

    private static boolean getGKStatus(Feature feature) {
        return FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeature" + feature.toString(), FacebookSdk.getApplicationId(), defaultStatus(feature));
    }

    public static boolean isEnabled(Feature feature) {
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        Feature parent = feature.getParent();
        if (parent == feature) {
            return getGKStatus(feature);
        }
        if (!isEnabled(parent) || !getGKStatus(feature)) {
            return false;
        }
        return true;
    }
}
