package p0;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.util.h;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public final String f16309a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f16310b;

    /* renamed from: c  reason: collision with root package name */
    public int f16311c;

    /* renamed from: d  reason: collision with root package name */
    public String f16312d;

    /* renamed from: e  reason: collision with root package name */
    public String f16313e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16314f = true;

    /* renamed from: g  reason: collision with root package name */
    public Uri f16315g = Settings.System.DEFAULT_NOTIFICATION_URI;

    /* renamed from: h  reason: collision with root package name */
    public AudioAttributes f16316h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16317i;

    /* renamed from: j  reason: collision with root package name */
    public int f16318j = 0;

    /* renamed from: k  reason: collision with root package name */
    public boolean f16319k;

    /* renamed from: l  reason: collision with root package name */
    public long[] f16320l;

    /* renamed from: m  reason: collision with root package name */
    public String f16321m;

    /* renamed from: n  reason: collision with root package name */
    public String f16322n;

    public static class a {
        public static boolean a(NotificationChannel notificationChannel) {
            return notificationChannel.canBypassDnd();
        }

        public static boolean b(NotificationChannel notificationChannel) {
            return notificationChannel.canShowBadge();
        }

        public static NotificationChannel c(String str, CharSequence charSequence, int i11) {
            return new NotificationChannel(str, charSequence, i11);
        }

        public static void d(NotificationChannel notificationChannel, boolean z11) {
            notificationChannel.enableLights(z11);
        }

        public static void e(NotificationChannel notificationChannel, boolean z11) {
            notificationChannel.enableVibration(z11);
        }

        public static AudioAttributes f(NotificationChannel notificationChannel) {
            return notificationChannel.getAudioAttributes();
        }

        public static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getDescription();
        }

        public static String h(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        public static String i(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        public static int j(NotificationChannel notificationChannel) {
            return notificationChannel.getImportance();
        }

        public static int k(NotificationChannel notificationChannel) {
            return notificationChannel.getLightColor();
        }

        public static int l(NotificationChannel notificationChannel) {
            return notificationChannel.getLockscreenVisibility();
        }

        public static CharSequence m(NotificationChannel notificationChannel) {
            return notificationChannel.getName();
        }

        public static Uri n(NotificationChannel notificationChannel) {
            return notificationChannel.getSound();
        }

        public static long[] o(NotificationChannel notificationChannel) {
            return notificationChannel.getVibrationPattern();
        }

        public static void p(NotificationChannel notificationChannel, String str) {
            notificationChannel.setDescription(str);
        }

        public static void q(NotificationChannel notificationChannel, String str) {
            notificationChannel.setGroup(str);
        }

        public static void r(NotificationChannel notificationChannel, int i11) {
            notificationChannel.setLightColor(i11);
        }

        public static void s(NotificationChannel notificationChannel, boolean z11) {
            notificationChannel.setShowBadge(z11);
        }

        public static void t(NotificationChannel notificationChannel, Uri uri, AudioAttributes audioAttributes) {
            notificationChannel.setSound(uri, audioAttributes);
        }

        public static void u(NotificationChannel notificationChannel, long[] jArr) {
            notificationChannel.setVibrationPattern(jArr);
        }

        public static boolean v(NotificationChannel notificationChannel) {
            return notificationChannel.shouldShowLights();
        }

        public static boolean w(NotificationChannel notificationChannel) {
            return notificationChannel.shouldVibrate();
        }
    }

    public static class b {
        public static String a(NotificationChannel notificationChannel) {
            return notificationChannel.getConversationId();
        }

        public static String b(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }

        public static boolean c(NotificationChannel notificationChannel) {
            return notificationChannel.isImportantConversation();
        }

        public static void d(NotificationChannel notificationChannel, String str, String str2) {
            notificationChannel.setConversationId(str, str2);
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final l f16323a;

        public c(String str, int i11) {
            this.f16323a = new l(str, i11);
        }

        public l a() {
            return this.f16323a;
        }

        public c b(CharSequence charSequence) {
            this.f16323a.f16310b = charSequence;
            return this;
        }
    }

    public l(String str, int i11) {
        this.f16309a = (String) h.g(str);
        this.f16311c = i11;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f16316h = Notification.AUDIO_ATTRIBUTES_DEFAULT;
        }
    }

    public NotificationChannel a() {
        String str;
        String str2;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            return null;
        }
        NotificationChannel c11 = a.c(this.f16309a, this.f16310b, this.f16311c);
        a.p(c11, this.f16312d);
        a.q(c11, this.f16313e);
        a.s(c11, this.f16314f);
        a.t(c11, this.f16315g, this.f16316h);
        a.d(c11, this.f16317i);
        a.r(c11, this.f16318j);
        a.u(c11, this.f16320l);
        a.e(c11, this.f16319k);
        if (!(i11 < 30 || (str = this.f16321m) == null || (str2 = this.f16322n) == null)) {
            b.d(c11, str, str2);
        }
        return c11;
    }
}
