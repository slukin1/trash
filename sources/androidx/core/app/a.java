package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.List;
import p0.q;

public class a implements p0.k {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8311a;

    /* renamed from: b  reason: collision with root package name */
    public final Notification.Builder f8312b;

    /* renamed from: c  reason: collision with root package name */
    public final NotificationCompat.e f8313c;

    /* renamed from: d  reason: collision with root package name */
    public RemoteViews f8314d;

    /* renamed from: e  reason: collision with root package name */
    public RemoteViews f8315e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Bundle> f8316f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f8317g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    public int f8318h;

    /* renamed from: i  reason: collision with root package name */
    public RemoteViews f8319i;

    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    public static class C0021a {
        public static Notification a(Notification.Builder builder) {
            return builder.build();
        }

        public static Notification.Builder b(Notification.Builder builder, int i11) {
            return builder.setPriority(i11);
        }

        public static Notification.Builder c(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSubText(charSequence);
        }

        public static Notification.Builder d(Notification.Builder builder, boolean z11) {
            return builder.setUsesChronometer(z11);
        }
    }

    public static class b {
        public static Notification.Builder a(Notification.Builder builder, boolean z11) {
            return builder.setShowWhen(z11);
        }
    }

    public static class c {
        public static Notification.Builder a(Notification.Builder builder, Bundle bundle) {
            return builder.setExtras(bundle);
        }
    }

    public static class d {
        public static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        public static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        public static Notification.Action.Builder e(int i11, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i11, charSequence, pendingIntent);
        }

        public static String f(Notification notification) {
            return notification.getGroup();
        }

        public static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        public static Notification.Builder h(Notification.Builder builder, boolean z11) {
            return builder.setGroupSummary(z11);
        }

        public static Notification.Builder i(Notification.Builder builder, boolean z11) {
            return builder.setLocalOnly(z11);
        }

        public static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    public static class e {
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        public static Notification.Builder c(Notification.Builder builder, int i11) {
            return builder.setColor(i11);
        }

        public static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder f(Notification.Builder builder, int i11) {
            return builder.setVisibility(i11);
        }
    }

    public static class f {
        public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        public static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        public static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    public static class g {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z11) {
            return builder.setAllowGeneratedReplies(z11);
        }

        public static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        public static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        public static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    public static class h {
        public static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static Notification.Builder b(Notification.Builder builder, int i11) {
            return builder.setBadgeIconType(i11);
        }

        public static Notification.Builder c(Notification.Builder builder, boolean z11) {
            return builder.setColorized(z11);
        }

        public static Notification.Builder d(Notification.Builder builder, int i11) {
            return builder.setGroupAlertBehavior(i11);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder g(Notification.Builder builder, long j11) {
            return builder.setTimeoutAfter(j11);
        }
    }

    public static class i {
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, int i11) {
            return builder.setSemanticAction(i11);
        }
    }

    public static class j {
        public static Notification.Builder a(Notification.Builder builder, boolean z11) {
            return builder.setAllowSystemGeneratedContextualActions(z11);
        }

        public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z11) {
            return builder.setContextual(z11);
        }

        public static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    public static class k {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z11) {
            return builder.setAuthenticationRequired(z11);
        }

        public static Notification.Builder b(Notification.Builder builder, int i11) {
            return builder.setForegroundServiceBehavior(i11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(androidx.core.app.NotificationCompat.e r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r16.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r0.f8316f = r2
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r0.f8317g = r2
            r0.f8313c = r1
            android.content.Context r2 = r1.f8252a
            r0.f8311a = r2
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 26
            if (r3 < r4) goto L_0x002a
            java.lang.String r5 = r1.L
            android.app.Notification$Builder r5 = androidx.core.app.a.h.a(r2, r5)
            r0.f8312b = r5
            goto L_0x0033
        L_0x002a:
            android.app.Notification$Builder r5 = new android.app.Notification$Builder
            android.content.Context r6 = r1.f8252a
            r5.<init>(r6)
            r0.f8312b = r5
        L_0x0033:
            android.app.Notification r5 = r1.U
            android.app.Notification$Builder r6 = r0.f8312b
            long r7 = r5.when
            android.app.Notification$Builder r6 = r6.setWhen(r7)
            int r7 = r5.icon
            int r8 = r5.iconLevel
            android.app.Notification$Builder r6 = r6.setSmallIcon(r7, r8)
            android.widget.RemoteViews r7 = r5.contentView
            android.app.Notification$Builder r6 = r6.setContent(r7)
            java.lang.CharSequence r7 = r5.tickerText
            android.widget.RemoteViews r8 = r1.f8260i
            android.app.Notification$Builder r6 = r6.setTicker(r7, r8)
            long[] r7 = r5.vibrate
            android.app.Notification$Builder r6 = r6.setVibrate(r7)
            int r7 = r5.ledARGB
            int r8 = r5.ledOnMS
            int r9 = r5.ledOffMS
            android.app.Notification$Builder r6 = r6.setLights(r7, r8, r9)
            int r7 = r5.flags
            r8 = 2
            r7 = r7 & r8
            r9 = 1
            r10 = 0
            if (r7 == 0) goto L_0x006d
            r7 = r9
            goto L_0x006e
        L_0x006d:
            r7 = r10
        L_0x006e:
            android.app.Notification$Builder r6 = r6.setOngoing(r7)
            int r7 = r5.flags
            r7 = r7 & 8
            if (r7 == 0) goto L_0x007a
            r7 = r9
            goto L_0x007b
        L_0x007a:
            r7 = r10
        L_0x007b:
            android.app.Notification$Builder r6 = r6.setOnlyAlertOnce(r7)
            int r7 = r5.flags
            r11 = 16
            r7 = r7 & r11
            if (r7 == 0) goto L_0x0088
            r7 = r9
            goto L_0x0089
        L_0x0088:
            r7 = r10
        L_0x0089:
            android.app.Notification$Builder r6 = r6.setAutoCancel(r7)
            int r7 = r5.defaults
            android.app.Notification$Builder r6 = r6.setDefaults(r7)
            java.lang.CharSequence r7 = r1.f8256e
            android.app.Notification$Builder r6 = r6.setContentTitle(r7)
            java.lang.CharSequence r7 = r1.f8257f
            android.app.Notification$Builder r6 = r6.setContentText(r7)
            java.lang.CharSequence r7 = r1.f8262k
            android.app.Notification$Builder r6 = r6.setContentInfo(r7)
            android.app.PendingIntent r7 = r1.f8258g
            android.app.Notification$Builder r6 = r6.setContentIntent(r7)
            android.app.PendingIntent r7 = r5.deleteIntent
            android.app.Notification$Builder r6 = r6.setDeleteIntent(r7)
            android.app.PendingIntent r7 = r1.f8259h
            int r12 = r5.flags
            r12 = r12 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x00bb
            r12 = r9
            goto L_0x00bc
        L_0x00bb:
            r12 = r10
        L_0x00bc:
            android.app.Notification$Builder r6 = r6.setFullScreenIntent(r7, r12)
            int r7 = r1.f8263l
            android.app.Notification$Builder r6 = r6.setNumber(r7)
            int r7 = r1.f8272u
            int r12 = r1.f8273v
            boolean r13 = r1.f8274w
            r6.setProgress(r7, r12, r13)
            r6 = 23
            r7 = 0
            if (r3 >= r6) goto L_0x00e4
            android.app.Notification$Builder r2 = r0.f8312b
            androidx.core.graphics.drawable.IconCompat r12 = r1.f8261j
            if (r12 != 0) goto L_0x00dc
            r12 = r7
            goto L_0x00e0
        L_0x00dc:
            android.graphics.Bitmap r12 = r12.m()
        L_0x00e0:
            r2.setLargeIcon(r12)
            goto L_0x00f3
        L_0x00e4:
            android.app.Notification$Builder r12 = r0.f8312b
            androidx.core.graphics.drawable.IconCompat r13 = r1.f8261j
            if (r13 != 0) goto L_0x00ec
            r2 = r7
            goto L_0x00f0
        L_0x00ec:
            android.graphics.drawable.Icon r2 = r13.z(r2)
        L_0x00f0:
            androidx.core.app.a.f.b(r12, r2)
        L_0x00f3:
            r2 = 21
            if (r3 >= r2) goto L_0x0100
            android.app.Notification$Builder r12 = r0.f8312b
            android.net.Uri r13 = r5.sound
            int r14 = r5.audioStreamType
            r12.setSound(r13, r14)
        L_0x0100:
            r12 = 20
            if (r3 < r11) goto L_0x0198
            android.app.Notification$Builder r11 = r0.f8312b
            java.lang.CharSequence r13 = r1.f8269r
            android.app.Notification$Builder r11 = androidx.core.app.a.C0021a.c(r11, r13)
            boolean r13 = r1.f8266o
            android.app.Notification$Builder r11 = androidx.core.app.a.C0021a.d(r11, r13)
            int r13 = r1.f8264m
            androidx.core.app.a.C0021a.b(r11, r13)
            if (r3 < r12) goto L_0x0139
            androidx.core.app.NotificationCompat$Style r3 = r1.f8268q
            boolean r11 = r3 instanceof androidx.core.app.NotificationCompat.CallStyle
            if (r11 == 0) goto L_0x0139
            androidx.core.app.NotificationCompat$CallStyle r3 = (androidx.core.app.NotificationCompat.CallStyle) r3
            java.util.ArrayList r3 = r3.y()
            java.util.Iterator r3 = r3.iterator()
        L_0x0129:
            boolean r11 = r3.hasNext()
            if (r11 == 0) goto L_0x014f
            java.lang.Object r11 = r3.next()
            androidx.core.app.NotificationCompat$Action r11 = (androidx.core.app.NotificationCompat.Action) r11
            r0.b(r11)
            goto L_0x0129
        L_0x0139:
            java.util.ArrayList<androidx.core.app.NotificationCompat$Action> r3 = r1.f8253b
            java.util.Iterator r3 = r3.iterator()
        L_0x013f:
            boolean r11 = r3.hasNext()
            if (r11 == 0) goto L_0x014f
            java.lang.Object r11 = r3.next()
            androidx.core.app.NotificationCompat$Action r11 = (androidx.core.app.NotificationCompat.Action) r11
            r0.b(r11)
            goto L_0x013f
        L_0x014f:
            android.os.Bundle r3 = r1.E
            if (r3 == 0) goto L_0x0158
            android.os.Bundle r11 = r0.f8317g
            r11.putAll(r3)
        L_0x0158:
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 >= r12) goto L_0x0190
            boolean r3 = r1.A
            if (r3 == 0) goto L_0x0167
            android.os.Bundle r3 = r0.f8317g
            java.lang.String r11 = "android.support.localOnly"
            r3.putBoolean(r11, r9)
        L_0x0167:
            java.lang.String r3 = r1.f8275x
            if (r3 == 0) goto L_0x0185
            android.os.Bundle r11 = r0.f8317g
            java.lang.String r13 = "android.support.groupKey"
            r11.putString(r13, r3)
            boolean r3 = r1.f8276y
            if (r3 == 0) goto L_0x017e
            android.os.Bundle r3 = r0.f8317g
            java.lang.String r11 = "android.support.isGroupSummary"
            r3.putBoolean(r11, r9)
            goto L_0x0185
        L_0x017e:
            android.os.Bundle r3 = r0.f8317g
            java.lang.String r11 = "android.support.useSideChannel"
            r3.putBoolean(r11, r9)
        L_0x0185:
            java.lang.String r3 = r1.f8277z
            if (r3 == 0) goto L_0x0190
            android.os.Bundle r11 = r0.f8317g
            java.lang.String r13 = "android.support.sortKey"
            r11.putString(r13, r3)
        L_0x0190:
            android.widget.RemoteViews r3 = r1.I
            r0.f8314d = r3
            android.widget.RemoteViews r3 = r1.J
            r0.f8315e = r3
        L_0x0198:
            int r3 = android.os.Build.VERSION.SDK_INT
            r11 = 17
            if (r3 < r11) goto L_0x01a5
            android.app.Notification$Builder r11 = r0.f8312b
            boolean r13 = r1.f8265n
            androidx.core.app.a.b.a(r11, r13)
        L_0x01a5:
            r11 = 19
            if (r3 < r11) goto L_0x01d2
            if (r3 >= r2) goto L_0x01d2
            java.util.ArrayList<androidx.core.app.Person> r11 = r1.f8254c
            java.util.List r11 = g(r11)
            java.util.ArrayList<java.lang.String> r13 = r1.X
            java.util.List r11 = e(r11, r13)
            if (r11 == 0) goto L_0x01d2
            boolean r13 = r11.isEmpty()
            if (r13 != 0) goto L_0x01d2
            android.os.Bundle r13 = r0.f8317g
            int r14 = r11.size()
            java.lang.String[] r14 = new java.lang.String[r14]
            java.lang.Object[] r11 = r11.toArray(r14)
            java.lang.String[] r11 = (java.lang.String[]) r11
            java.lang.String r14 = "android.people"
            r13.putStringArray(r14, r11)
        L_0x01d2:
            if (r3 < r12) goto L_0x01f4
            android.app.Notification$Builder r11 = r0.f8312b
            boolean r12 = r1.A
            androidx.core.app.a.d.i(r11, r12)
            android.app.Notification$Builder r11 = r0.f8312b
            java.lang.String r12 = r1.f8275x
            androidx.core.app.a.d.g(r11, r12)
            android.app.Notification$Builder r11 = r0.f8312b
            java.lang.String r12 = r1.f8277z
            androidx.core.app.a.d.j(r11, r12)
            android.app.Notification$Builder r11 = r0.f8312b
            boolean r12 = r1.f8276y
            androidx.core.app.a.d.h(r11, r12)
            int r11 = r1.Q
            r0.f8318h = r11
        L_0x01f4:
            r11 = 28
            if (r3 < r2) goto L_0x02a7
            android.app.Notification$Builder r2 = r0.f8312b
            java.lang.String r12 = r1.D
            androidx.core.app.a.e.b(r2, r12)
            android.app.Notification$Builder r2 = r0.f8312b
            int r12 = r1.F
            androidx.core.app.a.e.c(r2, r12)
            android.app.Notification$Builder r2 = r0.f8312b
            int r12 = r1.G
            androidx.core.app.a.e.f(r2, r12)
            android.app.Notification$Builder r2 = r0.f8312b
            android.app.Notification r12 = r1.H
            androidx.core.app.a.e.d(r2, r12)
            android.app.Notification$Builder r2 = r0.f8312b
            android.net.Uri r12 = r5.sound
            android.media.AudioAttributes r13 = r5.audioAttributes
            androidx.core.app.a.e.e(r2, r12, r13)
            if (r3 >= r11) goto L_0x022c
            java.util.ArrayList<androidx.core.app.Person> r2 = r1.f8254c
            java.util.List r2 = g(r2)
            java.util.ArrayList<java.lang.String> r3 = r1.X
            java.util.List r2 = e(r2, r3)
            goto L_0x022e
        L_0x022c:
            java.util.ArrayList<java.lang.String> r2 = r1.X
        L_0x022e:
            if (r2 == 0) goto L_0x024c
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x024c
            java.util.Iterator r2 = r2.iterator()
        L_0x023a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x024c
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            android.app.Notification$Builder r12 = r0.f8312b
            androidx.core.app.a.e.a(r12, r3)
            goto L_0x023a
        L_0x024c:
            android.widget.RemoteViews r2 = r1.K
            r0.f8319i = r2
            java.util.ArrayList<androidx.core.app.NotificationCompat$Action> r2 = r1.f8255d
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x02a7
            android.os.Bundle r2 = r17.k()
            java.lang.String r3 = "android.car.EXTENSIONS"
            android.os.Bundle r2 = r2.getBundle(r3)
            if (r2 != 0) goto L_0x0269
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
        L_0x0269:
            android.os.Bundle r12 = new android.os.Bundle
            r12.<init>(r2)
            android.os.Bundle r13 = new android.os.Bundle
            r13.<init>()
            r14 = r10
        L_0x0274:
            java.util.ArrayList<androidx.core.app.NotificationCompat$Action> r15 = r1.f8255d
            int r15 = r15.size()
            if (r14 >= r15) goto L_0x0293
            java.lang.String r15 = java.lang.Integer.toString(r14)
            java.util.ArrayList<androidx.core.app.NotificationCompat$Action> r9 = r1.f8255d
            java.lang.Object r9 = r9.get(r14)
            androidx.core.app.NotificationCompat$Action r9 = (androidx.core.app.NotificationCompat.Action) r9
            android.os.Bundle r9 = androidx.core.app.b.f(r9)
            r13.putBundle(r15, r9)
            int r14 = r14 + 1
            r9 = 1
            goto L_0x0274
        L_0x0293:
            java.lang.String r9 = "invisible_actions"
            r2.putBundle(r9, r13)
            r12.putBundle(r9, r13)
            android.os.Bundle r9 = r17.k()
            r9.putBundle(r3, r2)
            android.os.Bundle r2 = r0.f8317g
            r2.putBundle(r3, r12)
        L_0x02a7:
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r6) goto L_0x02b4
            java.lang.Object r3 = r1.W
            if (r3 == 0) goto L_0x02b4
            android.app.Notification$Builder r6 = r0.f8312b
            androidx.core.app.a.f.c(r6, r3)
        L_0x02b4:
            r3 = 24
            if (r2 < r3) goto L_0x02e1
            android.app.Notification$Builder r3 = r0.f8312b
            android.os.Bundle r6 = r1.E
            androidx.core.app.a.c.a(r3, r6)
            android.app.Notification$Builder r3 = r0.f8312b
            java.lang.CharSequence[] r6 = r1.f8271t
            androidx.core.app.a.g.e(r3, r6)
            android.widget.RemoteViews r3 = r1.I
            if (r3 == 0) goto L_0x02cf
            android.app.Notification$Builder r6 = r0.f8312b
            androidx.core.app.a.g.c(r6, r3)
        L_0x02cf:
            android.widget.RemoteViews r3 = r1.J
            if (r3 == 0) goto L_0x02d8
            android.app.Notification$Builder r6 = r0.f8312b
            androidx.core.app.a.g.b(r6, r3)
        L_0x02d8:
            android.widget.RemoteViews r3 = r1.K
            if (r3 == 0) goto L_0x02e1
            android.app.Notification$Builder r6 = r0.f8312b
            androidx.core.app.a.g.d(r6, r3)
        L_0x02e1:
            if (r2 < r4) goto L_0x032a
            android.app.Notification$Builder r3 = r0.f8312b
            int r6 = r1.M
            androidx.core.app.a.h.b(r3, r6)
            android.app.Notification$Builder r3 = r0.f8312b
            java.lang.CharSequence r6 = r1.f8270s
            androidx.core.app.a.h.e(r3, r6)
            android.app.Notification$Builder r3 = r0.f8312b
            java.lang.String r6 = r1.N
            androidx.core.app.a.h.f(r3, r6)
            android.app.Notification$Builder r3 = r0.f8312b
            long r12 = r1.P
            androidx.core.app.a.h.g(r3, r12)
            android.app.Notification$Builder r3 = r0.f8312b
            int r6 = r1.Q
            androidx.core.app.a.h.d(r3, r6)
            boolean r3 = r1.C
            if (r3 == 0) goto L_0x0311
            android.app.Notification$Builder r3 = r0.f8312b
            boolean r6 = r1.B
            androidx.core.app.a.h.c(r3, r6)
        L_0x0311:
            java.lang.String r3 = r1.L
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x032a
            android.app.Notification$Builder r3 = r0.f8312b
            android.app.Notification$Builder r3 = r3.setSound(r7)
            android.app.Notification$Builder r3 = r3.setDefaults(r10)
            android.app.Notification$Builder r3 = r3.setLights(r10, r10, r10)
            r3.setVibrate(r7)
        L_0x032a:
            if (r2 < r11) goto L_0x0348
            java.util.ArrayList<androidx.core.app.Person> r2 = r1.f8254c
            java.util.Iterator r2 = r2.iterator()
        L_0x0332:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0348
            java.lang.Object r3 = r2.next()
            androidx.core.app.Person r3 = (androidx.core.app.Person) r3
            android.app.Notification$Builder r6 = r0.f8312b
            android.app.Person r3 = r3.j()
            androidx.core.app.a.i.a(r6, r3)
            goto L_0x0332
        L_0x0348:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r2 < r3) goto L_0x036d
            android.app.Notification$Builder r3 = r0.f8312b
            boolean r6 = r1.S
            androidx.core.app.a.j.a(r3, r6)
            android.app.Notification$Builder r3 = r0.f8312b
            androidx.core.app.NotificationCompat$BubbleMetadata r6 = r1.T
            android.app.Notification$BubbleMetadata r6 = androidx.core.app.NotificationCompat.BubbleMetadata.k(r6)
            androidx.core.app.a.j.b(r3, r6)
            q0.b r3 = r1.O
            if (r3 == 0) goto L_0x036d
            android.app.Notification$Builder r6 = r0.f8312b
            android.content.LocusId r3 = r3.b()
            androidx.core.app.a.j.d(r6, r3)
        L_0x036d:
            r3 = 31
            if (r2 < r3) goto L_0x037a
            int r3 = r1.R
            if (r3 == 0) goto L_0x037a
            android.app.Notification$Builder r6 = r0.f8312b
            androidx.core.app.a.k.b(r6, r3)
        L_0x037a:
            boolean r1 = r1.V
            if (r1 == 0) goto L_0x03bd
            androidx.core.app.NotificationCompat$e r1 = r0.f8313c
            boolean r1 = r1.f8276y
            if (r1 == 0) goto L_0x0387
            r0.f8318h = r8
            goto L_0x038a
        L_0x0387:
            r1 = 1
            r0.f8318h = r1
        L_0x038a:
            android.app.Notification$Builder r1 = r0.f8312b
            r1.setVibrate(r7)
            android.app.Notification$Builder r1 = r0.f8312b
            r1.setSound(r7)
            int r1 = r5.defaults
            r1 = r1 & -2
            r5.defaults = r1
            r1 = r1 & -3
            r5.defaults = r1
            android.app.Notification$Builder r3 = r0.f8312b
            r3.setDefaults(r1)
            if (r2 < r4) goto L_0x03bd
            androidx.core.app.NotificationCompat$e r1 = r0.f8313c
            java.lang.String r1 = r1.f8275x
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x03b6
            android.app.Notification$Builder r1 = r0.f8312b
            java.lang.String r2 = "silent"
            androidx.core.app.a.d.g(r1, r2)
        L_0x03b6:
            android.app.Notification$Builder r1 = r0.f8312b
            int r2 = r0.f8318h
            androidx.core.app.a.h.d(r1, r2)
        L_0x03bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.a.<init>(androidx.core.app.NotificationCompat$e):void");
    }

    public static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    public static List<String> g(List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Person i11 : list) {
            arrayList.add(i11.i());
        }
        return arrayList;
    }

    public Notification.Builder a() {
        return this.f8312b;
    }

    public final void b(NotificationCompat.Action action) {
        Notification.Action.Builder builder;
        Bundle bundle;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 20) {
            IconCompat f11 = action.f();
            if (i11 >= 23) {
                builder = f.a(f11 != null ? f11.y() : null, action.j(), action.a());
            } else {
                builder = d.e(f11 != null ? f11.n() : 0, action.j(), action.a());
            }
            if (action.g() != null) {
                for (RemoteInput c11 : q.b(action.g())) {
                    d.c(builder, c11);
                }
            }
            if (action.d() != null) {
                bundle = new Bundle(action.d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", action.b());
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 24) {
                g.a(builder, action.b());
            }
            bundle.putInt("android.support.action.semanticAction", action.h());
            if (i12 >= 28) {
                i.b(builder, action.h());
            }
            if (i12 >= 29) {
                j.c(builder, action.l());
            }
            if (i12 >= 31) {
                k.a(builder, action.k());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", action.i());
            d.b(builder, bundle);
            d.a(this.f8312b, d.d(builder));
        } else if (i11 >= 16) {
            this.f8316f.add(b.j(this.f8312b, action));
        }
    }

    public Notification c() {
        Bundle k11;
        RemoteViews v11;
        RemoteViews t11;
        NotificationCompat.Style style = this.f8313c.f8268q;
        if (style != null) {
            style.b(this);
        }
        RemoteViews u11 = style != null ? style.u(this) : null;
        Notification d11 = d();
        if (u11 != null) {
            d11.contentView = u11;
        } else {
            RemoteViews remoteViews = this.f8313c.I;
            if (remoteViews != null) {
                d11.contentView = remoteViews;
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        if (!(i11 < 16 || style == null || (t11 = style.t(this)) == null)) {
            d11.bigContentView = t11;
        }
        if (!(i11 < 21 || style == null || (v11 = this.f8313c.f8268q.v(this)) == null)) {
            d11.headsUpContentView = v11;
        }
        if (!(i11 < 16 || style == null || (k11 = NotificationCompat.k(d11)) == null)) {
            style.a(k11);
        }
        return d11;
    }

    public Notification d() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            return C0021a.a(this.f8312b);
        }
        if (i11 >= 24) {
            Notification a11 = C0021a.a(this.f8312b);
            if (this.f8318h != 0) {
                if (!(d.f(a11) == null || (a11.flags & 512) == 0 || this.f8318h != 2)) {
                    h(a11);
                }
                if (d.f(a11) != null && (a11.flags & 512) == 0 && this.f8318h == 1) {
                    h(a11);
                }
            }
            return a11;
        } else if (i11 >= 21) {
            c.a(this.f8312b, this.f8317g);
            Notification a12 = C0021a.a(this.f8312b);
            RemoteViews remoteViews = this.f8314d;
            if (remoteViews != null) {
                a12.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f8315e;
            if (remoteViews2 != null) {
                a12.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f8319i;
            if (remoteViews3 != null) {
                a12.headsUpContentView = remoteViews3;
            }
            if (this.f8318h != 0) {
                if (!(d.f(a12) == null || (a12.flags & 512) == 0 || this.f8318h != 2)) {
                    h(a12);
                }
                if (d.f(a12) != null && (a12.flags & 512) == 0 && this.f8318h == 1) {
                    h(a12);
                }
            }
            return a12;
        } else if (i11 >= 20) {
            c.a(this.f8312b, this.f8317g);
            Notification a13 = C0021a.a(this.f8312b);
            RemoteViews remoteViews4 = this.f8314d;
            if (remoteViews4 != null) {
                a13.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f8315e;
            if (remoteViews5 != null) {
                a13.bigContentView = remoteViews5;
            }
            if (this.f8318h != 0) {
                if (!(d.f(a13) == null || (a13.flags & 512) == 0 || this.f8318h != 2)) {
                    h(a13);
                }
                if (d.f(a13) != null && (a13.flags & 512) == 0 && this.f8318h == 1) {
                    h(a13);
                }
            }
            return a13;
        } else if (i11 >= 19) {
            SparseArray<Bundle> a14 = b.a(this.f8316f);
            if (a14 != null) {
                this.f8317g.putSparseParcelableArray("android.support.actionExtras", a14);
            }
            c.a(this.f8312b, this.f8317g);
            Notification a15 = C0021a.a(this.f8312b);
            RemoteViews remoteViews6 = this.f8314d;
            if (remoteViews6 != null) {
                a15.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f8315e;
            if (remoteViews7 != null) {
                a15.bigContentView = remoteViews7;
            }
            return a15;
        } else if (i11 < 16) {
            return this.f8312b.getNotification();
        } else {
            Notification a16 = C0021a.a(this.f8312b);
            Bundle k11 = NotificationCompat.k(a16);
            Bundle bundle = new Bundle(this.f8317g);
            for (String str : this.f8317g.keySet()) {
                if (k11.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            k11.putAll(bundle);
            SparseArray<Bundle> a17 = b.a(this.f8316f);
            if (a17 != null) {
                NotificationCompat.k(a16).putSparseParcelableArray("android.support.actionExtras", a17);
            }
            RemoteViews remoteViews8 = this.f8314d;
            if (remoteViews8 != null) {
                a16.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f8315e;
            if (remoteViews9 != null) {
                a16.bigContentView = remoteViews9;
            }
            return a16;
        }
    }

    public Context f() {
        return this.f8311a;
    }

    public final void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i11 = notification.defaults & -2;
        notification.defaults = i11;
        notification.defaults = i11 & -3;
    }
}
