package androidx.media;

import android.util.SparseIntArray;
import w1.b;

public class AudioAttributesCompat implements b {

    /* renamed from: b  reason: collision with root package name */
    public static final SparseIntArray f10077b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f10078c = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributesImpl f10079a;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f10080a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f10081b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f10082c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f10083d = -1;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10077b = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public static int a(boolean z11, int i11, int i12) {
        if ((i11 & 1) == 1) {
            return z11 ? 1 : 7;
        }
        if ((i11 & 4) == 4) {
            return z11 ? 0 : 6;
        }
        switch (i12) {
            case 0:
                return z11 ? Integer.MIN_VALUE : 3;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z11 ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            default:
                if (!z11) {
                    return 3;
                }
                throw new IllegalArgumentException("Unknown usage value " + i12 + " in audio attributes");
        }
    }

    public static String b(int i11) {
        switch (i11) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 16:
                return "USAGE_ASSISTANT";
            default:
                return "unknown usage " + i11;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f10079a;
        if (audioAttributesImpl != null) {
            return audioAttributesImpl.equals(audioAttributesCompat.f10079a);
        }
        if (audioAttributesCompat.f10079a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f10079a.hashCode();
    }

    public String toString() {
        return this.f10079a.toString();
    }
}
