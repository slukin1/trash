package cn.sharesdk.framework;

import android.app.Activity;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.f;
import cn.sharesdk.framework.utils.k;
import com.mob.MobSDK;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class j extends f {

    /* renamed from: b  reason: collision with root package name */
    private a f13475b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, HashMap<String, String>> f13476c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Platform> f13477d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Integer> f13478e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private HashMap<Integer, String> f13479f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private HashMap<Integer, CustomPlatform> f13480g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private HashMap<Integer, HashMap<String, Object>> f13481h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private HashMap<Integer, Service> f13482i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private boolean f13483j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13484k;

    public enum a {
        INITIALIZING,
        READY
    }

    private void h() {
        XmlPullParser newPullParser;
        InputStream inputStream;
        synchronized (this.f13476c) {
            this.f13476c.clear();
            try {
                XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
                newInstance.setNamespaceAware(true);
                newPullParser = newInstance.newPullParser();
                inputStream = null;
                inputStream = MobSDK.getContext().getAssets().open("ShareSDK.xml");
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
            }
            newPullParser.setInput(inputStream, "utf-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    HashMap hashMap = new HashMap();
                    int attributeCount = newPullParser.getAttributeCount();
                    for (int i11 = 0; i11 < attributeCount; i11++) {
                        hashMap.put(newPullParser.getAttributeName(i11), newPullParser.getAttributeValue(i11).trim());
                    }
                    this.f13476c.put(name, hashMap);
                }
            }
            inputStream.close();
        }
    }

    public void b(Message message) {
    }

    public boolean b() {
        return i.c();
    }

    public void c() {
        this.f13475b = a.INITIALIZING;
        SSDKLog.a();
        EventRecorder.prepare();
        h();
        super.c();
    }

    public void d(Class<? extends CustomPlatform> cls) {
        synchronized (this.f13480g) {
            if (!this.f13480g.containsKey(Integer.valueOf(cls.hashCode()))) {
                try {
                    CustomPlatform customPlatform = (CustomPlatform) cls.newInstance();
                    this.f13480g.put(Integer.valueOf(cls.hashCode()), customPlatform);
                    if (customPlatform != null && customPlatform.b()) {
                        this.f13479f.put(Integer.valueOf(customPlatform.getPlatformId()), customPlatform.getName());
                        this.f13478e.put(customPlatform.getName(), Integer.valueOf(customPlatform.getPlatformId()));
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().b(th2);
                }
            }
        }
    }

    public void e(Class<? extends CustomPlatform> cls) {
        int hashCode = cls.hashCode();
        synchronized (this.f13480g) {
            this.f13480g.remove(Integer.valueOf(hashCode));
        }
    }

    public boolean f() {
        synchronized (this.f13481h) {
            HashMap<Integer, HashMap<String, Object>> hashMap = this.f13481h;
            if (hashMap == null || hashMap.size() <= 0) {
                return false;
            }
            return true;
        }
    }

    public void g() {
        try {
            ResHelper.clearCache(MobSDK.getContext());
        } catch (Throwable th2) {
            SSDKLog.b().b(th2);
        }
    }

    public void b(Class<? extends Service> cls) {
        synchronized (this.f13482i) {
            int hashCode = cls.hashCode();
            if (this.f13482i.containsKey(Integer.valueOf(hashCode))) {
                this.f13482i.get(Integer.valueOf(hashCode)).onUnbind();
                this.f13482i.remove(Integer.valueOf(hashCode));
            }
        }
    }

    public void a(Activity activity) {
        i.a(activity);
    }

    public Activity a() {
        return i.b();
    }

    public boolean e() {
        return this.f13484k;
    }

    public void a(boolean z11) {
        i.a(z11);
    }

    public <T extends Service> T c(Class<T> cls) {
        T t11;
        synchronized (this.f13482i) {
            if (this.f13475b == a.INITIALIZING) {
                try {
                    this.f13482i.wait();
                } catch (Throwable th2) {
                    SSDKLog.b().b(th2);
                }
            }
            try {
                t11 = (Service) cls.cast(this.f13482i.get(Integer.valueOf(cls.hashCode())));
            } catch (Throwable th3) {
                SSDKLog.b().b(th3);
                return null;
            }
        }
        return t11;
    }

    public void a(Message message) {
        HashMap<Integer, Service> hashMap;
        synchronized (this.f13482i) {
            synchronized (this.f13477d) {
                try {
                    String checkRecord = EventRecorder.checkRecord(ShareSDK.SDK_TAG);
                    if (!TextUtils.isEmpty(checkRecord)) {
                        cn.sharesdk.framework.a.a.a().a((HashMap<String, Object>) null);
                        SSDKLog b11 = SSDKLog.b();
                        b11.a("EventRecorder checkRecord result ==" + checkRecord);
                        g();
                    }
                    EventRecorder.clear();
                } catch (Throwable th2) {
                    try {
                        SSDKLog.b().b(th2);
                        this.f13475b = a.READY;
                        this.f13477d.notify();
                        hashMap = this.f13482i;
                    } catch (Throwable th3) {
                        this.f13475b = a.READY;
                        this.f13477d.notify();
                        this.f13482i.notify();
                        throw th3;
                    }
                }
                this.f13477d.clear();
                ArrayList<Platform> a11 = i.a();
                if (a11 != null) {
                    this.f13477d.addAll(a11);
                }
                Iterator<Platform> it2 = this.f13477d.iterator();
                while (it2.hasNext()) {
                    Platform next = it2.next();
                    this.f13479f.put(Integer.valueOf(next.getPlatformId()), next.getName());
                    this.f13478e.put(next.getName(), Integer.valueOf(next.getPlatformId()));
                }
                i.a(this.f13521a);
                a aVar = a.READY;
                this.f13475b = aVar;
                new Thread() {
                    public void run() {
                        j.this.a((ShareSDKCallback<Boolean>) null);
                    }
                }.start();
                this.f13475b = aVar;
                this.f13477d.notify();
                hashMap = this.f13482i;
                hashMap.notify();
            }
        }
    }

    public void b(int i11) {
        NetworkHelper.readTimout = i11;
    }

    public void b(boolean z11) {
        this.f13484k = z11;
    }

    public int b(String str) {
        synchronized (this.f13477d) {
            synchronized (this.f13480g) {
                if (!this.f13478e.containsKey(str)) {
                    return 0;
                }
                int intValue = this.f13478e.get(str).intValue();
                return intValue;
            }
        }
    }

    public Platform[] d() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f13477d) {
            if (this.f13475b == a.INITIALIZING) {
                try {
                    this.f13477d.wait();
                } catch (Throwable th2) {
                    SSDKLog.b().b(th2);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Platform> it2 = this.f13477d.iterator();
        while (it2.hasNext()) {
            Platform next = it2.next();
            if (next != null && next.b()) {
                next.a();
                arrayList.add(next);
            }
        }
        i.a((ArrayList<Platform>) arrayList);
        for (Map.Entry<Integer, CustomPlatform> value : this.f13480g.entrySet()) {
            Platform platform = (Platform) value.getValue();
            if (platform != null && platform.b()) {
                arrayList.add(platform);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        int size = arrayList.size();
        Platform[] platformArr = new Platform[size];
        for (int i11 = 0; i11 < size; i11++) {
            platformArr[i11] = (Platform) arrayList.get(i11);
        }
        SSDKLog.b().c("sort list use time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return platformArr;
    }

    public String c(int i11) {
        String str;
        synchronized (this.f13477d) {
            synchronized (this.f13480g) {
                str = this.f13479f.get(Integer.valueOf(i11));
            }
        }
        return str;
    }

    public String b(String str, String str2) {
        synchronized (this.f13476c) {
            HashMap hashMap = this.f13476c.get(str);
            if (hashMap == null) {
                return null;
            }
            String str3 = (String) hashMap.get(str2);
            return str3;
        }
    }

    public void a(Class<? extends Service> cls) {
        synchronized (this.f13482i) {
            if (!this.f13482i.containsKey(Integer.valueOf(cls.hashCode()))) {
                try {
                    Service service = (Service) cls.newInstance();
                    this.f13482i.put(Integer.valueOf(cls.hashCode()), service);
                    service.onBind();
                } catch (Throwable th2) {
                    SSDKLog.b().b(th2);
                }
            }
        }
    }

    public Platform a(String str) {
        Platform[] d11;
        if (str == null || (d11 = d()) == null) {
            return null;
        }
        for (Platform platform : d11) {
            if (str.equals(platform.getName())) {
                return platform;
            }
        }
        return null;
    }

    public void a(int i11) {
        NetworkHelper.connectionTimeout = i11;
    }

    public void a(int i11, Platform platform) {
        i.a(i11, platform);
    }

    public void a(String str, int i11) {
        i.a(str, i11);
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        synchronized (this.f13476c) {
            HashMap hashMap2 = this.f13476c.get(str);
            if (hashMap2 == null) {
                hashMap2 = new HashMap();
            }
            synchronized (hashMap2) {
                for (Map.Entry next : hashMap.entrySet()) {
                    String str2 = (String) next.getKey();
                    Object value = next.getValue();
                    if (value != null) {
                        hashMap2.put(str2, String.valueOf(value));
                    }
                }
            }
            this.f13476c.put(str, hashMap2);
        }
        synchronized (this.f13477d) {
            if (this.f13475b == a.INITIALIZING) {
                try {
                    this.f13477d.wait();
                } catch (Throwable th2) {
                    SSDKLog.b().b(th2);
                }
            }
        }
        Iterator<Platform> it2 = this.f13477d.iterator();
        while (it2.hasNext()) {
            Platform next2 = it2.next();
            if (next2 != null && next2.getName().equals(str)) {
                next2.a();
                return;
            }
        }
    }

    public void a(List<HashMap<String, Object>> list) {
        synchronized (this.f13476c) {
            for (HashMap<String, Object> entrySet : list) {
                String str = null;
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : entrySet.entrySet()) {
                    String str2 = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (str2.equals("platformName")) {
                        str = String.valueOf(entry.getValue());
                    }
                    if (value != null) {
                        hashMap.put(str2, String.valueOf(value));
                    }
                }
                this.f13476c.put(str, hashMap);
            }
        }
        synchronized (this.f13477d) {
            if (this.f13475b == a.INITIALIZING) {
                try {
                    this.f13477d.wait();
                } catch (Throwable th2) {
                    SSDKLog.b().b(th2);
                }
            }
        }
    }

    public void a(String str, String str2) {
        synchronized (this.f13476c) {
            this.f13476c.put(str2, this.f13476c.get(str));
        }
    }

    public void a(int i11, int i12) {
        synchronized (this.f13481h) {
            this.f13481h.put(Integer.valueOf(i12), this.f13481h.get(Integer.valueOf(i11)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(int r3, java.lang.String r4) {
        /*
            r2 = this;
            java.util.HashMap<java.lang.Integer, java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r2.f13481h
            monitor-enter(r0)
            java.util.HashMap<java.lang.Integer, java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r2.f13481h     // Catch:{ all -> 0x0021 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0021 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0021 }
            java.util.HashMap r3 = (java.util.HashMap) r3     // Catch:{ all -> 0x0021 }
            r1 = 0
            if (r3 != 0) goto L_0x0014
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r1
        L_0x0014:
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0021 }
            if (r3 != 0) goto L_0x001b
            goto L_0x001f
        L_0x001b:
            java.lang.String r1 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0021 }
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r1
        L_0x0021:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.j.a(int, java.lang.String):java.lang.String");
    }

    public void a(final ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            if (a.READY != this.f13475b) {
                SSDKLog.b().a("Statistics module unopened", new Object[0]);
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.FALSE);
                    return;
                }
                return;
            }
            DH.requester(MobSDK.getContext()).getDeviceKey().request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    try {
                        final String deviceKey = dHResponse.getDeviceKey();
                        boolean z11 = false;
                        if (TextUtils.isEmpty(deviceKey)) {
                            SSDKLog.b().a("dk null", new Object[0]);
                            ShareSDKCallback shareSDKCallback = shareSDKCallback;
                            if (shareSDKCallback != null) {
                                shareSDKCallback.onCallback(Boolean.FALSE);
                                return;
                            }
                            return;
                        }
                        final cn.sharesdk.framework.a.a a11 = cn.sharesdk.framework.a.a.a();
                        HashMap a12 = j.this.a(a11, a11.c(), deviceKey);
                        if (a12 != null && a12.size() > 0) {
                            z11 = j.this.a((HashMap<String, Object>) a12);
                        }
                        if (z11) {
                            k.a(new k.a() {
                                public void a() throws Throwable {
                                    AnonymousClass2 r02 = AnonymousClass2.this;
                                    j.this.a(a11, (ShareSDKCallback<Boolean>) shareSDKCallback, deviceKey);
                                }
                            });
                        } else {
                            j.this.a(a11, (ShareSDKCallback<Boolean>) shareSDKCallback, deviceKey);
                        }
                    } catch (Throwable th2) {
                        SSDKLog.b().a(th2);
                        ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                        if (shareSDKCallback2 != null) {
                            shareSDKCallback2.onCallback(Boolean.FALSE);
                        }
                    }
                }
            });
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(cn.sharesdk.framework.a.a aVar, ShareSDKCallback<Boolean> shareSDKCallback, String str) {
        try {
            HashMap<String, Object> b11 = aVar.b(str);
            HashMap<String, Object> a11 = a(aVar, b11, str);
            if (a11 == null || a11.size() <= 0) {
                SSDKLog.b().a("d i n");
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.FALSE);
                }
            } else if (a(a11)) {
                aVar.a(b11);
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.TRUE);
                }
            }
        } catch (Throwable th2) {
            SSDKLog.b().b(th2);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> a(cn.sharesdk.framework.a.a aVar, HashMap<String, Object> hashMap, String str) {
        try {
            if (hashMap.containsKey("error")) {
                SSDKLog.b().c("ShareSDK parse sns config ==>>", new Hashon().fromHashMap(hashMap));
                return null;
            } else if (!hashMap.containsKey("res")) {
                SSDKLog.b().a("ShareSDK platform config result ==>>", "SNS configuration is empty");
                return null;
            } else {
                String str2 = (String) hashMap.get("res");
                if (str2 == null) {
                    return null;
                }
                return aVar.a(str2, str);
            }
        } catch (Throwable th2) {
            SSDKLog.b().b(th2);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public boolean a(HashMap<String, Object> hashMap) {
        synchronized (this.f13481h) {
            HashMap<Integer, HashMap<String, Object>> a11 = i.a(hashMap);
            if (a11 == null || a11.size() <= 0) {
                return false;
            }
            this.f13481h.clear();
            this.f13481h = a11;
            return true;
        }
    }

    public void a(String str, boolean z11, int i11, String str2, ShareSDKCallback<String> shareSDKCallback) {
        if (a.READY == this.f13475b) {
            cn.sharesdk.framework.a.a.a().a(str, i11, z11, str2, shareSDKCallback);
        } else if (shareSDKCallback != null) {
            shareSDKCallback.onCallback(str);
        }
    }
}
