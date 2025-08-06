package com.tencent.thumbplayer.tcmedia.tplayer.a;

import android.content.Context;
import com.tencent.thumbplayer.tcmedia.api.reportv2.ITPReportChannelListener;
import com.tencent.thumbplayer.tcmedia.api.reportv2.ITPReportInfoGetter;
import com.tencent.thumbplayer.tcmedia.api.reportv2.TPExtendCommonKey;
import com.tencent.thumbplayer.tcmedia.common.a.b;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.tcmedia.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.tcmedia.d.b;
import com.tencent.thumbplayer.tcmedia.tplayer.a.a.a;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public class c implements a {

    /* renamed from: i  reason: collision with root package name */
    private static com.tencent.thumbplayer.tcmedia.utils.c f49493i;

    /* renamed from: a  reason: collision with root package name */
    public ITPReportInfoGetter f49494a;

    /* renamed from: b  reason: collision with root package name */
    public a f49495b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<WeakReference<ITPReportChannelListener>> f49496c;

    /* renamed from: d  reason: collision with root package name */
    public Context f49497d;

    /* renamed from: e  reason: collision with root package name */
    public l f49498e;

    /* renamed from: f  reason: collision with root package name */
    public j f49499f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f49500g = 0;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f49501h = new HashMap();

    private synchronized void a(Context context, String str) {
        if (f49493i == null) {
            f49493i = new com.tencent.thumbplayer.tcmedia.utils.c(this.f49497d, str);
        }
    }

    public static void a(Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        for (Map.Entry next : map.entrySet()) {
            if (c((String) next.getKey())) {
                map2.put(next.getKey(), next.getValue());
            } else if (b((String) next.getKey())) {
                map3.put(next.getKey(), next.getValue());
            } else {
                TPLogUtil.e("TPBaseReporter", "invalid extend info <" + ((String) next.getKey()) + ", " + ((String) next.getValue()) + "> from ITPReportInfoGetter, key valid!");
            }
        }
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("ext_");
    }

    private synchronized void c() {
        com.tencent.thumbplayer.tcmedia.utils.c cVar = f49493i;
        if (cVar != null) {
            Iterator<String> it2 = cVar.b().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                String d11 = d(next);
                com.tencent.thumbplayer.tcmedia.tplayer.a.b.a aVar = (com.tencent.thumbplayer.tcmedia.tplayer.a.b.a) f49493i.b(next);
                if (!(d11 == null || aVar == null)) {
                    Map<String, String> b11 = aVar.b();
                    b(d11, b11);
                    b.a(d11, b11);
                }
            }
            f49493i.c();
        }
    }

    public static boolean c(String str) {
        Class<TPExtendCommonKey> cls = TPExtendCommonKey.class;
        if (str == null) {
            return false;
        }
        for (Field field : cls.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                String str2 = (String) field.get(cls);
                if (str2 != null && str2.equals(str)) {
                    return true;
                }
            } catch (IllegalAccessException e11) {
                TPLogUtil.e("TPBaseReporter", (Throwable) e11);
            }
        }
        return false;
    }

    private static String d(String str) {
        Class<i> cls = i.class;
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType() == String.class) {
                try {
                    String str2 = (String) field.get(cls);
                    if (str2 != null && str.endsWith(str2)) {
                        return str2;
                    }
                } catch (IllegalAccessException unused) {
                    TPLogUtil.w("TPBaseReporter", "fail to get value of field(" + field.getName() + ") in TPReportEventId.class)");
                }
            }
        }
        return null;
    }

    public TPDynamicStatisticParams a(boolean z11) {
        a aVar = this.f49495b;
        if (aVar != null) {
            return aVar.a(z11);
        }
        TPLogUtil.e("TPBaseReporter", "getDynamicStatParamsFromCore failed, mPlayerInfoGetter is null, return default value");
        return new TPDynamicStatisticParams();
    }

    public TPGeneralPlayFlowParams a(b.a aVar) {
        TPGeneralPlayFlowParams tPGeneralPlayFlowParams;
        if (aVar instanceof b.n) {
            tPGeneralPlayFlowParams = ((b.n) aVar).d();
        } else if (aVar instanceof b.l) {
            tPGeneralPlayFlowParams = ((b.l) aVar).d();
        } else if (aVar instanceof b.i) {
            tPGeneralPlayFlowParams = ((b.i) aVar).f();
        } else {
            TPLogUtil.e("TPBaseReporter", "event info do not have generalPlayFlowParams");
            tPGeneralPlayFlowParams = null;
        }
        return tPGeneralPlayFlowParams == null ? new TPGeneralPlayFlowParams() : tPGeneralPlayFlowParams;
    }

    public void a() {
        CopyOnWriteArrayList<WeakReference<ITPReportChannelListener>> copyOnWriteArrayList = this.f49496c;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            this.f49496c = null;
        }
    }

    public void a(int i11, b.a aVar) {
    }

    public void a(Context context, l lVar) {
        this.f49497d = context;
        this.f49496c = new CopyOnWriteArrayList<>();
        this.f49498e = lVar;
        this.f49499f = new j(context);
        a(context, "TPReporterCache");
        c();
    }

    public void a(ITPReportChannelListener iTPReportChannelListener) {
        CopyOnWriteArrayList<WeakReference<ITPReportChannelListener>> copyOnWriteArrayList = this.f49496c;
        if (copyOnWriteArrayList == null) {
            TPLogUtil.w("TPBaseReporter", "mReportChannelListenerList is null");
            return;
        }
        Iterator<WeakReference<ITPReportChannelListener>> it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            if (((ITPReportChannelListener) it2.next().get()) == iTPReportChannelListener) {
                TPLogUtil.w("TPBaseReporter", "mReportChannelListenerList has contain reportChannelListener");
                return;
            }
        }
        this.f49496c.add(new WeakReference(iTPReportChannelListener));
    }

    public void a(ITPReportInfoGetter iTPReportInfoGetter) {
        this.f49494a = iTPReportInfoGetter;
    }

    public void a(a aVar) {
        this.f49495b = aVar;
    }

    public void a(b bVar) {
        a aVar = this.f49495b;
        if (aVar == null) {
            TPLogUtil.e("TPBaseReporter", "fillStreamInfoToCommonParams fail, not set mPlayerInfoGetter");
            return;
        }
        TPGeneralPlayFlowParams a11 = aVar.a();
        bVar.f49353a.a(this.f49498e.f49544i);
        bVar.f49353a.a(a11.mPlayerBaseMediaParams.mDurationMs);
        bVar.f49353a.e(a11.mPlayerBaseMediaParams.mHlsSourceType);
        bVar.f49353a.f(this.f49498e.f49542g);
        bVar.f49353a.g(this.f49498e.f49541f);
        bVar.f49353a.i(a11.mPlayerBaseMediaParams.mFormatContainer);
        bVar.f49353a.h(a11.mPlayerBaseMediaParams.mVideoEncodeFormat);
        bVar.f49353a.i(a11.mPlayerBaseMediaParams.mAudioEncodeFormat);
        bVar.f49353a.j(a11.mPlayerBaseMediaParams.mSubtitleEncodeFormat);
        bVar.f49353a.b(a11.mPlayerBaseMediaParams.mVideoStreamBitrateKbps);
        bVar.f49353a.a(a11.mPlayerBaseMediaParams.mVideoFrameRate);
        bVar.f49353a.j(this.f49498e.f49540e);
        bVar.f49353a.k(a11.mPlayerBaseMediaParams.mVideoWidth + "*" + a11.mPlayerBaseMediaParams.mVideoHeight);
        bVar.f49353a.l(TPDownloadProxyHelper.getNativeLibVersion());
        bVar.f49353a.k(bVar.f49354b);
        bVar.f49353a.o(bVar.f49357e);
        bVar.f49353a.m(bVar.f49356d);
        bVar.f49353a.n(bVar.f49355c);
        bVar.f49353a.l(this.f49498e.f49543h);
        this.f49501h.put("buffermintotaldurationms", Long.valueOf(a11.mPlayerConfigParams.mBufferMinTotalDurationMs));
        this.f49501h.put("buffermaxtotaldurationms", Long.valueOf(a11.mPlayerConfigParams.mBufferMaxTotalDurationMs));
        this.f49501h.put("preloadtotaldurationms", Long.valueOf(a11.mPlayerConfigParams.mPreloadTotalDurationMs));
        this.f49501h.put("minbufferingdurationms", Long.valueOf(a11.mPlayerConfigParams.mMinBufferingDurationMs));
        this.f49501h.put("minbufferingtimems", Long.valueOf(a11.mPlayerConfigParams.mMinBufferingTimeMs));
        this.f49501h.put("maxbufferingtimems", Long.valueOf(a11.mPlayerConfigParams.mMaxBufferingTimeMs));
        this.f49501h.put("reducelatencyaction", Integer.valueOf(a11.mPlayerConfigParams.mReduceLatencyAction));
        this.f49501h.put("reducelatencyspeed", Float.valueOf(a11.mPlayerConfigParams.mReduceLatencyPlaySpeed));
        this.f49501h.put("buffertype", Integer.valueOf(a11.mPlayerConfigParams.mBufferType));
        try {
            bVar.f49353a.p(new JSONObject(this.f49501h).toString());
        } catch (NullPointerException e11) {
            TPLogUtil.e("TPBaseReporter", (Throwable) e11);
        }
    }

    public synchronized void a(String str) {
        com.tencent.thumbplayer.tcmedia.utils.c cVar = f49493i;
        if (cVar != null) {
            Iterator<String> it2 = cVar.b().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (next.startsWith(str)) {
                    f49493i.a(next);
                    TPLogUtil.i("TPBaseReporter", "remove cache, key:".concat(next));
                }
            }
        }
    }

    public synchronized void a(String str, com.tencent.thumbplayer.tcmedia.tplayer.a.b.a aVar) {
        if (f49493i != null) {
            if (this.f49498e.f49545j.booleanValue()) {
                com.tencent.thumbplayer.tcmedia.utils.c cVar = f49493i;
                cVar.a(aVar.a() + str, aVar);
                TPLogUtil.i("TPBaseReporter", "write cache, flowid:" + aVar.a() + ", reportId:" + str);
                return;
            }
        }
        TPLogUtil.i("TPBaseReporter", "mCache is null or does not need to report to beacon, no caching!");
    }

    public void a(String str, Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str2 = ":{";
        while (true) {
            sb2.append(str2);
            if (it2.hasNext()) {
                Map.Entry next = it2.next();
                sb2.append((String) next.getKey());
                sb2.append(":");
                sb2.append((String) next.getValue());
                str2 = Constants.ACCEPT_TIME_SEPARATOR_SP;
            } else {
                sb2.append("}");
                TPLogUtil.i("TPBaseReporter", sb2.toString());
                return;
            }
        }
    }

    public TPDynamicStatisticParams b(b.a aVar) {
        TPDynamicStatisticParams tPDynamicStatisticParams;
        if (aVar instanceof b.n) {
            tPDynamicStatisticParams = ((b.n) aVar).e();
        } else if (aVar instanceof b.l) {
            tPDynamicStatisticParams = ((b.l) aVar).e();
        } else if (aVar instanceof b.i) {
            tPDynamicStatisticParams = ((b.i) aVar).g();
        } else {
            TPLogUtil.e("TPBaseReporter", "event info do not have dynamicStatisticParams");
            tPDynamicStatisticParams = null;
        }
        return tPDynamicStatisticParams == null ? new TPDynamicStatisticParams() : tPDynamicStatisticParams;
    }

    public TPGeneralPlayFlowParams b() {
        a aVar = this.f49495b;
        if (aVar != null) {
            return aVar.a();
        }
        TPLogUtil.e("TPBaseReporter", "getGeneralPlayFlowParams failed, mPlayerInfoGetter is null, return default value");
        return new TPGeneralPlayFlowParams();
    }

    public void b(b bVar) {
        ITPReportInfoGetter iTPReportInfoGetter = this.f49494a;
        if (iTPReportInfoGetter != null) {
            Map<String, String> initExtendReportInfo = iTPReportInfoGetter.getInitExtendReportInfo();
            if (initExtendReportInfo == null) {
                TPLogUtil.e("TPBaseReporter", "fillInitExtReportInfoToCommonParams fail, initExtendReportInfo is null");
                return;
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            a(initExtendReportInfo, hashMap, hashMap2);
            bVar.f49353a.a((Map<String, String>) hashMap);
            bVar.f49353a.b((Map<String, String>) hashMap2);
        }
    }

    public void b(String str, Map<String, String> map) {
        if (this.f49496c.size() != 0) {
            for (int i11 = 0; i11 < this.f49496c.size(); i11++) {
                ITPReportChannelListener iTPReportChannelListener = (ITPReportChannelListener) this.f49496c.get(i11).get();
                if (iTPReportChannelListener != null) {
                    iTPReportChannelListener.reportEvent(str, map);
                }
            }
        }
    }

    public void c(String str, Map<String, String> map) {
        if (this.f49498e.f49545j.booleanValue()) {
            com.tencent.thumbplayer.tcmedia.common.a.b.a(str, map);
        }
    }
}
