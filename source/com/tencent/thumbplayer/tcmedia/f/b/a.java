package com.tencent.thumbplayer.tcmedia.f.b;

import android.os.SystemClock;
import com.iproov.sdk.bridge.OptionsBridge;
import com.jumio.analytics.MobileEvents;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.tencent.thumbplayer.tcmedia.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.tcmedia.utils.i;
import com.tencent.thumbplayer.tcmedia.utils.l;
import com.tencent.thumbplayer.tcmedia.utils.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import okhttp3.internal.http.StatusLine;

public class a implements com.tencent.thumbplayer.tcmedia.tplayer.plugins.a {

    /* renamed from: a  reason: collision with root package name */
    public m f49182a = new m();

    /* renamed from: b  reason: collision with root package name */
    private String f49183b;

    /* renamed from: c  reason: collision with root package name */
    private String f49184c;

    /* renamed from: d  reason: collision with root package name */
    private TPRichMediaFeature[] f49185d;

    /* renamed from: e  reason: collision with root package name */
    private int f49186e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f49187f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f49188g = -1;

    /* renamed from: h  reason: collision with root package name */
    private long f49189h = 0;

    /* renamed from: i  reason: collision with root package name */
    private List<b> f49190i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private Map<Integer, C0622a> f49191j = new HashMap();

    /* renamed from: com.tencent.thumbplayer.tcmedia.f.b.a$a  reason: collision with other inner class name */
    public static class C0622a {

        /* renamed from: a  reason: collision with root package name */
        public int f49192a;

        /* renamed from: b  reason: collision with root package name */
        public long f49193b;

        private C0622a() {
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f49194a;

        /* renamed from: b  reason: collision with root package name */
        public int f49195b;

        /* renamed from: c  reason: collision with root package name */
        public long f49196c;

        private b() {
        }
    }

    private void a(int i11) {
        this.f49186e++;
        b bVar = new b();
        bVar.f49194a = i11;
        bVar.f49195b = this.f49186e;
        bVar.f49196c = SystemClock.elapsedRealtime();
        this.f49190i.add(bVar);
    }

    private void a(int i11, int i12) {
        b(i11, i12);
        c(i11, i12);
    }

    private void a(com.tencent.thumbplayer.tcmedia.common.a.a aVar) {
        aVar.a("url", this.f49184c);
        aVar.a("flowid", this.f49183b);
        aVar.a(TPDownloadProxyEnum.USER_GUID, TPPlayerConfig.getGuid());
        aVar.a("appplatform", TPPlayerConfig.getPlatform());
        aVar.a(OptionsBridge.NETWORK_KEY, i.b());
    }

    private void a(C0622a aVar, String str, int i11) {
        l lVar = new l();
        lVar.a(IBridgeMediaLoader.COLUMN_DURATION, SystemClock.elapsedRealtime() - aVar.f49193b);
        lVar.a("code", i11);
        lVar.a("seq", aVar.f49192a);
        lVar.a("featuretype", str);
        lVar.a("position", this.f49188g);
        a("rich_media_feature_data_callback", (com.tencent.thumbplayer.tcmedia.common.a.a) lVar);
    }

    private void a(b bVar, String str, int i11) {
        l lVar = new l();
        lVar.a(IBridgeMediaLoader.COLUMN_DURATION, SystemClock.elapsedRealtime() - bVar.f49196c);
        lVar.a("code", i11);
        lVar.a("seq", bVar.f49195b);
        lVar.a("featuretype", str);
        lVar.a("position", this.f49188g);
        a("rich_media_feature_select", (com.tencent.thumbplayer.tcmedia.common.a.a) lVar);
    }

    private void a(Object obj) {
        if (obj instanceof TPRichMediaFeature[]) {
            this.f49185d = (TPRichMediaFeature[]) obj;
        }
        l(0);
    }

    private void a(String str) {
        this.f49183b = UUID.randomUUID().toString() + System.nanoTime() + "_" + TPPlayerConfig.getPlatform();
        this.f49184c = str;
    }

    private void a(String str, com.tencent.thumbplayer.tcmedia.common.a.a aVar) {
        a(aVar);
    }

    private void b(int i11) {
        b(i11, 0);
        if (!this.f49191j.containsKey(Integer.valueOf(i11))) {
            this.f49187f++;
            C0622a aVar = new C0622a();
            aVar.f49192a = this.f49187f;
            aVar.f49193b = SystemClock.elapsedRealtime();
            this.f49191j.put(Integer.valueOf(i11), aVar);
        }
    }

    private void b(int i11, int i12) {
        String k11 = k(i11);
        Iterator<b> it2 = this.f49190i.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            if (next.f49194a == i11) {
                a(next, k11, i12);
                it2.remove();
            }
        }
    }

    private void c() {
        this.f49189h = SystemClock.elapsedRealtime();
    }

    private void c(int i11) {
        b(i11, 0);
    }

    private void c(int i11, int i12) {
        if (this.f49191j.containsKey(Integer.valueOf(i11))) {
            a(this.f49191j.get(Integer.valueOf(i11)), k(i11), i12);
            this.f49191j.remove(Integer.valueOf(i11));
        }
    }

    private void d() {
        g(0);
    }

    private void d(int i11) {
        c(i11, 0);
    }

    private void e() {
        g(0);
    }

    private void e(int i11) {
        g(i11);
    }

    private void f() {
        this.f49185d = null;
        this.f49186e = 0;
        this.f49187f = 0;
        this.f49189h = 0;
        this.f49190i.clear();
        this.f49191j.clear();
    }

    private void f(int i11) {
        this.f49188g = i11;
    }

    private void g(int i11) {
        h(i11);
        f();
    }

    private void h(int i11) {
        l(i11);
        i(i11);
        j(i11);
    }

    private void i(int i11) {
        if (this.f49185d != null) {
            for (int i12 = 0; i12 < this.f49185d.length; i12++) {
                b(i12, 0);
            }
        }
    }

    private void j(int i11) {
        if (this.f49185d != null) {
            for (int i12 = 0; i12 < this.f49185d.length; i12++) {
                c(i12, 0);
            }
        }
    }

    private String k(int i11) {
        TPRichMediaFeature[] tPRichMediaFeatureArr = this.f49185d;
        return (tPRichMediaFeatureArr == null || i11 < 0 || i11 >= tPRichMediaFeatureArr.length) ? "" : tPRichMediaFeatureArr[i11].getFeatureType();
    }

    private void l(int i11) {
        if (this.f49189h > 0) {
            l lVar = new l();
            lVar.a(IBridgeMediaLoader.COLUMN_DURATION, SystemClock.elapsedRealtime() - this.f49189h);
            lVar.a("code", i11);
            a("rich_media_prepare", (com.tencent.thumbplayer.tcmedia.common.a.a) lVar);
            this.f49189h = 0;
        }
    }

    public void a() {
    }

    public void a(int i11, int i12, int i13, String str, Object obj) {
        this.f49182a.writeLock().lock();
        switch (i11) {
            case 300:
                c();
                break;
            case 301:
                a(obj);
                break;
            case 302:
                a(i12);
                break;
            case 303:
                b(i12);
                break;
            case 304:
                c(i12);
                break;
            case MobileEvents.EVENTTYPE_EXCEPTION:
                d(i12);
                break;
            case MobileEvents.EVENTTYPE_SDKPARAMETERS:
                d();
                break;
            case 307:
                e();
                break;
            case StatusLine.HTTP_PERM_REDIRECT /*308*/:
                e(i12);
                break;
            case MobileEvents.EVENTTYPE_NETWORKCALL:
                a(str);
                break;
            case 310:
                a(i12, i13);
                break;
            case 311:
                f(i12);
                break;
        }
        this.f49182a.writeLock().unlock();
    }

    public void b() {
    }
}
