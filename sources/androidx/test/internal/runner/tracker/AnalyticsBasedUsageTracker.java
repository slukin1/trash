package androidx.test.internal.runner.tracker;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.test.internal.util.Checks;
import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public final class AnalyticsBasedUsageTracker implements UsageTracker {

    /* renamed from: a  reason: collision with root package name */
    public final String f11582a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11583b;

    /* renamed from: c  reason: collision with root package name */
    public final URL f11584c;

    /* renamed from: d  reason: collision with root package name */
    public final String f11585d;

    /* renamed from: e  reason: collision with root package name */
    public final String f11586e;

    /* renamed from: f  reason: collision with root package name */
    public final String f11587f;

    /* renamed from: g  reason: collision with root package name */
    public final String f11588g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, String> f11589h;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final Context f11590a;

        /* renamed from: b  reason: collision with root package name */
        public Uri f11591b = new Uri.Builder().scheme(Constants.SCHEME).authority("www.google-analytics.com").path("collect").build();

        /* renamed from: c  reason: collision with root package name */
        public String f11592c = "UA-36650409-3";

        /* renamed from: d  reason: collision with root package name */
        public String f11593d = String.valueOf(Build.VERSION.SDK_INT);

        /* renamed from: e  reason: collision with root package name */
        public String f11594e = Build.MODEL;

        /* renamed from: f  reason: collision with root package name */
        public String f11595f;

        /* renamed from: g  reason: collision with root package name */
        public URL f11596g;

        /* renamed from: h  reason: collision with root package name */
        public String f11597h;

        /* renamed from: i  reason: collision with root package name */
        public String f11598i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f11599j;

        public Builder(Context context) {
            Objects.requireNonNull(context, "Context null!?");
            this.f11590a = context;
        }

        public UsageTracker h() {
            if (!i()) {
                Log.d("InfraTrack", "Tracking disabled due to lack of internet permissions");
                return null;
            }
            if (this.f11595f == null) {
                j(this.f11590a.getPackageName());
            }
            if (this.f11595f.contains("com.google.analytics")) {
                Log.d("InfraTrack", "Refusing to use analytics while testing analytics.");
                return null;
            }
            try {
                if (!this.f11595f.startsWith("com.google.") && !this.f11595f.startsWith("com.android.")) {
                    if (!this.f11595f.startsWith("android.support.")) {
                        if (!this.f11599j) {
                            MessageDigest instance = MessageDigest.getInstance("SHA-256");
                            instance.reset();
                            instance.update(this.f11595f.getBytes("UTF-8"));
                            String valueOf = String.valueOf(new BigInteger(instance.digest()).toString(16));
                            this.f11595f = valueOf.length() != 0 ? "sha256-".concat(valueOf) : new String("sha256-");
                        }
                        this.f11599j = true;
                    }
                }
                try {
                    this.f11596g = new URL(this.f11591b.toString());
                    if (this.f11597h == null) {
                        Display defaultDisplay = ((WindowManager) this.f11590a.getSystemService("window")).getDefaultDisplay();
                        if (defaultDisplay == null) {
                            this.f11597h = "0x0";
                        } else {
                            this.f11597h = defaultDisplay.getWidth() + "x" + defaultDisplay.getHeight();
                        }
                    }
                    if (this.f11598i == null) {
                        this.f11598i = UUID.randomUUID().toString();
                    }
                    return new AnalyticsBasedUsageTracker(this);
                } catch (MalformedURLException e11) {
                    String valueOf2 = String.valueOf(this.f11591b.toString());
                    Log.w("InfraTrack", valueOf2.length() != 0 ? "Tracking disabled bad url: ".concat(valueOf2) : new String("Tracking disabled bad url: "), e11);
                    return null;
                }
            } catch (NoSuchAlgorithmException e12) {
                Log.d("InfraTrack", "Cannot hash package name.", e12);
                return null;
            } catch (UnsupportedEncodingException e13) {
                Log.d("InfraTrack", "Impossible - no utf-8 encoding?", e13);
                return null;
            }
        }

        public final boolean i() {
            return this.f11590a.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
        }

        public Builder j(String str) {
            this.f11599j = false;
            this.f11595f = str;
            return this;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2 = "an=" + java.net.URLEncoder.encode(r11.f11583b, "UTF-8") + "&tid=" + java.net.URLEncoder.encode(r11.f11582a, "UTF-8") + "&v=1" + "&z=" + android.os.SystemClock.uptimeMillis() + "&cid=" + java.net.URLEncoder.encode(r11.f11588g, "UTF-8") + "&sr=" + java.net.URLEncoder.encode(r11.f11585d, "UTF-8") + "&cd2=" + java.net.URLEncoder.encode(r11.f11586e, "UTF-8") + "&cd3=" + java.net.URLEncoder.encode(r11.f11587f, "UTF-8") + "&t=appview" + "&sc=start";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00a0, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00a1, code lost:
        android.util.Log.w("InfraTrack", "Impossible error happened. analytics disabled.", r2);
        r2 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r11 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r11.f11589h
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.String> r1 = r11.f11589h     // Catch:{ all -> 0x019d }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x019d }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x019d }
            return
        L_0x000d:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x019d }
            java.util.Map<java.lang.String, java.lang.String> r2 = r11.f11589h     // Catch:{ all -> 0x019d }
            r1.<init>(r2)     // Catch:{ all -> 0x019d }
            java.util.Map<java.lang.String, java.lang.String> r2 = r11.f11589h     // Catch:{ all -> 0x019d }
            r2.clear()     // Catch:{ all -> 0x019d }
            monitor-exit(r0)     // Catch:{ all -> 0x019d }
            r0 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a0 }
            r2.<init>()     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = "an="
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = r11.f11583b     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r4 = "UTF-8"
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r4)     // Catch:{ IOException -> 0x00a0 }
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = "&tid="
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = r11.f11582a     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r4 = "UTF-8"
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r4)     // Catch:{ IOException -> 0x00a0 }
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = "&v=1"
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = "&z="
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            long r3 = android.os.SystemClock.uptimeMillis()     // Catch:{ IOException -> 0x00a0 }
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = "&cid="
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = r11.f11588g     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r4 = "UTF-8"
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r4)     // Catch:{ IOException -> 0x00a0 }
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = "&sr="
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = r11.f11585d     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r4 = "UTF-8"
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r4)     // Catch:{ IOException -> 0x00a0 }
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = "&cd2="
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = r11.f11586e     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r4 = "UTF-8"
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r4)     // Catch:{ IOException -> 0x00a0 }
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = "&cd3="
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = r11.f11587f     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r4 = "UTF-8"
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r4)     // Catch:{ IOException -> 0x00a0 }
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = "&t=appview"
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r3 = "&sc=start"
            r2.append(r3)     // Catch:{ IOException -> 0x00a0 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00a0 }
            goto L_0x00a9
        L_0x00a0:
            r2 = move-exception
            java.lang.String r3 = "InfraTrack"
            java.lang.String r4 = "Impossible error happened. analytics disabled."
            android.util.Log.w(r3, r4, r2)
            r2 = r0
        L_0x00a9:
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x00b1:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x019c
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.net.URL r4 = r11.f11584c     // Catch:{ IOException -> 0x0167, all -> 0x0163 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0167, all -> 0x0163 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x0167, all -> 0x0163 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0161 }
            r5.<init>()     // Catch:{ IOException -> 0x0161 }
            r5.append(r2)     // Catch:{ IOException -> 0x0161 }
            java.lang.String r6 = "&cd="
            r5.append(r6)     // Catch:{ IOException -> 0x0161 }
            java.lang.Object r6 = r3.getKey()     // Catch:{ IOException -> 0x0161 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x0161 }
            java.lang.String r7 = "UTF-8"
            java.lang.String r6 = java.net.URLEncoder.encode(r6, r7)     // Catch:{ IOException -> 0x0161 }
            r5.append(r6)     // Catch:{ IOException -> 0x0161 }
            java.lang.String r6 = "&av="
            r5.append(r6)     // Catch:{ IOException -> 0x0161 }
            java.lang.Object r6 = r3.getValue()     // Catch:{ IOException -> 0x0161 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x0161 }
            java.lang.String r7 = "UTF-8"
            java.lang.String r6 = java.net.URLEncoder.encode(r6, r7)     // Catch:{ IOException -> 0x0161 }
            r5.append(r6)     // Catch:{ IOException -> 0x0161 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0161 }
            byte[] r5 = r5.getBytes()     // Catch:{ IOException -> 0x0161 }
            r6 = 3000(0xbb8, float:4.204E-42)
            r4.setConnectTimeout(r6)     // Catch:{ IOException -> 0x0161 }
            r6 = 5000(0x1388, float:7.006E-42)
            r4.setReadTimeout(r6)     // Catch:{ IOException -> 0x0161 }
            r6 = 1
            r4.setDoOutput(r6)     // Catch:{ IOException -> 0x0161 }
            int r6 = r5.length     // Catch:{ IOException -> 0x0161 }
            r4.setFixedLengthStreamingMode(r6)     // Catch:{ IOException -> 0x0161 }
            java.io.OutputStream r6 = r4.getOutputStream()     // Catch:{ IOException -> 0x0161 }
            r6.write(r5)     // Catch:{ IOException -> 0x0161 }
            int r5 = r4.getResponseCode()     // Catch:{ IOException -> 0x0161 }
            int r5 = r5 / 100
            r6 = 2
            if (r5 == r6) goto L_0x0190
            java.lang.String r5 = "InfraTrack"
            java.lang.String r6 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x0161 }
            int r7 = r4.getResponseCode()     // Catch:{ IOException -> 0x0161 }
            java.lang.String r8 = r4.getResponseMessage()     // Catch:{ IOException -> 0x0161 }
            int r9 = r6.length()     // Catch:{ IOException -> 0x0161 }
            int r9 = r9 + 45
            java.lang.String r10 = java.lang.String.valueOf(r8)     // Catch:{ IOException -> 0x0161 }
            int r10 = r10.length()     // Catch:{ IOException -> 0x0161 }
            int r9 = r9 + r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0161 }
            r10.<init>(r9)     // Catch:{ IOException -> 0x0161 }
            java.lang.String r9 = "Analytics post: "
            r10.append(r9)     // Catch:{ IOException -> 0x0161 }
            r10.append(r6)     // Catch:{ IOException -> 0x0161 }
            java.lang.String r6 = " failed. code: "
            r10.append(r6)     // Catch:{ IOException -> 0x0161 }
            r10.append(r7)     // Catch:{ IOException -> 0x0161 }
            java.lang.String r6 = " - "
            r10.append(r6)     // Catch:{ IOException -> 0x0161 }
            r10.append(r8)     // Catch:{ IOException -> 0x0161 }
            java.lang.String r6 = r10.toString()     // Catch:{ IOException -> 0x0161 }
            android.util.Log.w(r5, r6)     // Catch:{ IOException -> 0x0161 }
            goto L_0x0190
        L_0x0161:
            r5 = move-exception
            goto L_0x0169
        L_0x0163:
            r1 = move-exception
            r4 = r0
            r0 = r1
            goto L_0x0196
        L_0x0167:
            r5 = move-exception
            r4 = r0
        L_0x0169:
            java.lang.String r6 = "InfraTrack"
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0195 }
            int r7 = r3.length()     // Catch:{ all -> 0x0195 }
            int r7 = r7 + 25
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0195 }
            r8.<init>(r7)     // Catch:{ all -> 0x0195 }
            java.lang.String r7 = "Analytics post: "
            r8.append(r7)     // Catch:{ all -> 0x0195 }
            r8.append(r3)     // Catch:{ all -> 0x0195 }
            java.lang.String r3 = " failed. "
            r8.append(r3)     // Catch:{ all -> 0x0195 }
            java.lang.String r3 = r8.toString()     // Catch:{ all -> 0x0195 }
            android.util.Log.w(r6, r3, r5)     // Catch:{ all -> 0x0195 }
            if (r4 == 0) goto L_0x00b1
        L_0x0190:
            r4.disconnect()
            goto L_0x00b1
        L_0x0195:
            r0 = move-exception
        L_0x0196:
            if (r4 == 0) goto L_0x019b
            r4.disconnect()
        L_0x019b:
            throw r0
        L_0x019c:
            return
        L_0x019d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x019d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.internal.runner.tracker.AnalyticsBasedUsageTracker.a():void");
    }

    public void b(String str, String str2) {
        synchronized (this.f11589h) {
            this.f11589h.put(str, str2);
        }
    }

    public AnalyticsBasedUsageTracker(Builder builder) {
        this.f11589h = new HashMap();
        this.f11582a = (String) Checks.b(builder.f11592c);
        this.f11583b = (String) Checks.b(builder.f11595f);
        this.f11584c = (URL) Checks.b(builder.f11596g);
        this.f11586e = (String) Checks.b(builder.f11593d);
        this.f11587f = (String) Checks.b(builder.f11594e);
        this.f11585d = (String) Checks.b(builder.f11597h);
        this.f11588g = (String) Checks.b(builder.f11598i);
    }
}
