package com.tencent.thumbplayer.tcmedia.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalParam;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMgr;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg;
import com.tencent.thumbplayer.tcmedia.api.TPVideoInfo;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.tcmedia.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.tcmedia.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.tcmedia.b.h;
import com.tencent.thumbplayer.tcmedia.b.j;
import com.tencent.thumbplayer.tcmedia.b.l;
import com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyMsg;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.f;
import com.tencent.thumbplayer.tcmedia.utils.i;
import com.tencent.thumbplayer.tcmedia.utils.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class e implements a, f.a, i.b {

    /* renamed from: g  reason: collision with root package name */
    private static int f49055g = -1;

    /* renamed from: a  reason: collision with root package name */
    private Context f49056a;

    /* renamed from: b  reason: collision with root package name */
    private a f49057b;

    /* renamed from: c  reason: collision with root package name */
    private ITPDownloadProxy f49058c;

    /* renamed from: d  reason: collision with root package name */
    private int f49059d = 0;

    /* renamed from: e  reason: collision with root package name */
    private b f49060e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ITPPlayListener f49061f;

    /* renamed from: h  reason: collision with root package name */
    private int f49062h = f49055g;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<TPDownloadParamData> f49063i;

    /* renamed from: j  reason: collision with root package name */
    private String f49064j;

    /* renamed from: k  reason: collision with root package name */
    private int f49065k;

    /* renamed from: l  reason: collision with root package name */
    private TPVideoInfo f49066l;

    /* renamed from: m  reason: collision with root package name */
    private String f49067m;

    /* renamed from: n  reason: collision with root package name */
    private ITPPlayerProxyListener f49068n = null;

    /* renamed from: o  reason: collision with root package name */
    private LinkedList<c> f49069o;

    /* renamed from: p  reason: collision with root package name */
    private HashMap<String, Integer> f49070p;

    /* renamed from: q  reason: collision with root package name */
    private long f49071q;

    /* renamed from: r  reason: collision with root package name */
    private long f49072r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f49073s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f49074t = true;

    /* renamed from: u  reason: collision with root package name */
    private boolean f49075u = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f49076v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f49077w = false;

    /* renamed from: x  reason: collision with root package name */
    private long f49078x = 100000000;

    /* renamed from: y  reason: collision with root package name */
    private boolean f49079y = false;

    /* renamed from: z  reason: collision with root package name */
    private m f49080z;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (e.this.f49061f == null) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "handleMessage failed, mPlayListener is null and return");
                return;
            }
            int i11 = message.what;
            if (i11 == 4196) {
                e.this.g(message.arg1);
            } else if (i11 != 4197) {
                switch (i11) {
                    case 4097:
                        e.this.f49061f.onDownloadFinish();
                        return;
                    case 4098:
                        e.this.f49061f.onDownloadError(message.arg1, message.arg2, (String) message.obj);
                        return;
                    case 4099:
                        e.this.f49061f.onDownloadCdnUrlUpdate((String) message.obj);
                        return;
                    case 4100:
                        TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = (TPPlayerMsg.TPCDNURLInfo) message.obj;
                        e.this.f49061f.onDownloadCdnUrlInfoUpdate(tPCDNURLInfo.url, tPCDNURLInfo.cdnIp, tPCDNURLInfo.uIp, tPCDNURLInfo.errorStr);
                        return;
                    case 4101:
                        e.this.f49061f.onDownloadStatusUpdate(message.arg1);
                        return;
                    case 4102:
                        TPPlayerMsg.TPProtocolInfo tPProtocolInfo = (TPPlayerMsg.TPProtocolInfo) message.obj;
                        e.this.f49061f.onDownloadProtocolUpdate(tPProtocolInfo.protocolName, tPProtocolInfo.protocolVersion);
                        return;
                    case 4103:
                        e.this.f49061f.onDownloadCdnUrlExpired((Map) message.obj);
                        return;
                    case 4104:
                        C0617e eVar = (C0617e) message.obj;
                        f fVar = (f) eVar.f49087a;
                        eVar.f49088b.a(e.this.f49061f.onPlayCallback(fVar.f49089a, fVar.f49090b, fVar.f49091c, fVar.f49092d, fVar.f49093e));
                        return;
                    case 4105:
                        C0617e eVar2 = (C0617e) message.obj;
                        eVar2.f49088b.a(e.this.f49061f.getPlayInfo(((Long) eVar2.f49087a).longValue()));
                        return;
                    case 4106:
                        TPPlayerMsg.TPDownLoadProgressInfo tPDownLoadProgressInfo = (TPPlayerMsg.TPDownLoadProgressInfo) message.obj;
                        e.this.f49061f.onDownloadProgressUpdate((int) tPDownLoadProgressInfo.playableDurationMS, tPDownLoadProgressInfo.downloadSpeedKBps, tPDownLoadProgressInfo.currentDownloadSize, tPDownLoadProgressInfo.totalFileSize, tPDownLoadProgressInfo.extraInfo);
                        return;
                    case 4107:
                        C0617e eVar3 = (C0617e) message.obj;
                        eVar3.f49088b.a(e.this.f49061f.getPlayInfo((String) eVar3.f49087a));
                        return;
                    default:
                        return;
                }
            } else {
                e.this.h(message.arg1);
            }
        }
    }

    public class b implements ITPPlayListener {
        private b() {
        }

        public long getAdvRemainTime() {
            return e.this.f49061f.getAdvRemainTime();
        }

        public String getContentType(int i11, String str) {
            return e.this.f49061f.getContentType(i11, str);
        }

        public int getCurrentPlayClipNo() {
            return e.this.f49061f.getCurrentPlayClipNo();
        }

        public long getCurrentPlayOffset() {
            return e.this.f49061f.getCurrentPlayOffset();
        }

        public long getCurrentPosition() {
            return e.this.f49061f.getCurrentPosition();
        }

        public String getDataFilePath(int i11, String str) {
            return e.this.f49061f.getDataFilePath(i11, str);
        }

        public long getDataTotalSize(int i11, String str) {
            return e.this.f49061f.getDataTotalSize(i11, str);
        }

        public Object getPlayInfo(long j11) {
            com.tencent.thumbplayer.tcmedia.utils.e eVar = new com.tencent.thumbplayer.tcmedia.utils.e();
            C0617e eVar2 = new C0617e();
            eVar2.f49087a = Long.valueOf(j11);
            eVar2.f49088b = eVar;
            e.this.a(4105, (Object) eVar2);
            return e.this.a(eVar);
        }

        public Object getPlayInfo(String str) {
            com.tencent.thumbplayer.tcmedia.utils.e eVar = new com.tencent.thumbplayer.tcmedia.utils.e();
            C0617e eVar2 = new C0617e();
            eVar2.f49087a = str;
            eVar2.f49088b = eVar;
            e.this.a(4107, (Object) eVar2);
            return e.this.a(eVar);
        }

        public long getPlayerBufferLength() {
            return e.this.f49061f.getPlayerBufferLength();
        }

        public void onDownloadCdnUrlExpired(Map<String, String> map) {
            e.this.a(4103, (Object) map);
        }

        public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
            TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
            tPCDNURLInfo.url = str;
            tPCDNURLInfo.cdnIp = str2;
            tPCDNURLInfo.uIp = str3;
            tPCDNURLInfo.errorStr = str4;
            e.this.a(4100, (Object) tPCDNURLInfo);
        }

        public void onDownloadCdnUrlUpdate(String str) {
            e.this.a(4099, (Object) str);
        }

        public void onDownloadError(int i11, int i12, String str) {
            e.this.a(4098, i11, i12, str, false, false, 0);
        }

        public void onDownloadFinish() {
            e.this.a(4097, (Object) null);
        }

        public void onDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
            TPPlayerMsg.TPDownLoadProgressInfo tPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
            tPDownLoadProgressInfo.playableDurationMS = (long) i11;
            tPDownLoadProgressInfo.downloadSpeedKBps = i12;
            tPDownLoadProgressInfo.currentDownloadSize = j11;
            tPDownLoadProgressInfo.totalFileSize = j12;
            tPDownLoadProgressInfo.extraInfo = str;
            e.this.a(4106, (Object) tPDownLoadProgressInfo);
        }

        public void onDownloadProtocolUpdate(String str, String str2) {
            TPPlayerMsg.TPProtocolInfo tPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
            tPProtocolInfo.protocolVersion = str2;
            tPProtocolInfo.protocolName = str;
            e.this.a(4102, (Object) tPProtocolInfo);
        }

        public void onDownloadStatusUpdate(int i11) {
            e.this.a(4101, i11, 0, (Object) null, false, false, 0);
        }

        public Object onPlayCallback(int i11, Object obj, Object obj2, Object obj3, Object obj4) {
            f fVar = new f();
            fVar.f49089a = i11;
            fVar.f49090b = obj;
            fVar.f49091c = obj2;
            fVar.f49092d = obj3;
            fVar.f49093e = obj4;
            com.tencent.thumbplayer.tcmedia.utils.e eVar = new com.tencent.thumbplayer.tcmedia.utils.e();
            C0617e eVar2 = new C0617e();
            eVar2.f49087a = fVar;
            eVar2.f49088b = eVar;
            e.this.a(4104, (Object) eVar2);
            return e.this.a(eVar);
        }

        public int onReadData(int i11, String str, long j11, long j12) {
            return e.this.f49061f.onReadData(i11, str, j11, j12);
        }

        public int onStartReadData(int i11, String str, long j11, long j12) {
            return e.this.f49061f.onStartReadData(i11, str, j11, j12);
        }

        public int onStopReadData(int i11, String str, int i12) {
            return e.this.f49061f.onStopReadData(i11, str, i12);
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f49083a;

        /* renamed from: b  reason: collision with root package name */
        public int f49084b;

        public c(long j11, int i11) {
            this.f49083a = j11;
            this.f49084b = i11;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f49085a;

        /* renamed from: b  reason: collision with root package name */
        public int f49086b;

        public d(int i11, int i12) {
            this.f49085a = i11;
            this.f49086b = i12;
        }
    }

    /* renamed from: com.tencent.thumbplayer.tcmedia.c.e$e  reason: collision with other inner class name */
    public static class C0617e {

        /* renamed from: a  reason: collision with root package name */
        public Object f49087a;

        /* renamed from: b  reason: collision with root package name */
        public com.tencent.thumbplayer.tcmedia.utils.e f49088b;

        private C0617e() {
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f49089a;

        /* renamed from: b  reason: collision with root package name */
        public Object f49090b;

        /* renamed from: c  reason: collision with root package name */
        public Object f49091c;

        /* renamed from: d  reason: collision with root package name */
        public Object f49092d;

        /* renamed from: e  reason: collision with root package name */
        public Object f49093e;

        private f() {
        }
    }

    public e(Context context, Looper looper) {
        this.f49056a = context;
        this.f49057b = new a(looper);
        com.tencent.thumbplayer.tcmedia.utils.f.a(this);
        i.a().a((i.b) this);
        this.f49060e = new b();
        this.f49061f = new f("TPThumbPlayer[TPPlayManagerImpl.java]");
        this.f49070p = new HashMap<>();
        this.f49063i = new ArrayList<>();
        this.f49080z = new m();
    }

    private int a(List<ITPMediaTrackClip> list, String str, ArrayList<TPDownloadParamData> arrayList) {
        int i11 = -1;
        if (com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) list)) {
            TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "clipList is empty, return");
            return -1;
        }
        int size = list.size();
        HashMap hashMap = new HashMap();
        int i12 = 1;
        for (int i13 = 0; i13 < size; i13++) {
            ITPMediaTrackClip iTPMediaTrackClip = list.get(i13);
            if ((iTPMediaTrackClip instanceof h) && com.tencent.thumbplayer.tcmedia.utils.b.b(((h) iTPMediaTrackClip).getFilePath())) {
                hashMap.put(iTPMediaTrackClip, new d(i12, i13));
                i12++;
            }
        }
        if (com.tencent.thumbplayer.tcmedia.utils.b.a((Map<? extends Object, ? extends Object>) hashMap)) {
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "all urls is local file url, return");
            return -1;
        }
        try {
            int startClipPlay = this.f49058c.startClipPlay(str, hashMap.size(), this.f49060e);
            if (startClipPlay > 0) {
                try {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        ITPMediaTrackClip iTPMediaTrackClip2 = (ITPMediaTrackClip) entry.getKey();
                        d dVar = (d) entry.getValue();
                        if (iTPMediaTrackClip2 instanceof h) {
                            h hVar = (h) iTPMediaTrackClip2;
                            TPDownloadParamData a11 = a(arrayList, dVar.f49086b);
                            if (a11 == null) {
                                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "fatal err, paramData is null.");
                                return -1;
                            }
                            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "multi trackClipIndex:" + dVar.f49086b + ", download seq:" + dVar.f49085a + ", clip.url:" + hVar.getUrl() + ", clip.getFilePath:" + hVar.getFilePath() + ", paramData.savePath:" + a11.getSavePath() + ", paramData.DownloadFileID:" + a11.getDownloadFileID());
                            if (this.f49058c.setClipInfo(startClipPlay, dVar.f49085a, a11.getDownloadFileID(), a(hVar.getFilePath(), a11, hVar.getHttpHeader(), s()))) {
                                hVar.a(this.f49058c.getClipPlayUrl(startClipPlay, dVar.f49085a, 1));
                            }
                        }
                    }
                    return startClipPlay;
                } catch (Throwable th2) {
                    th = th2;
                    i11 = startClipPlay;
                    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
                    return i11;
                }
            } else {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start clip play failed, cause : playId < 0");
                return startClipPlay;
            }
        } catch (Throwable th3) {
            th = th3;
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
            return i11;
        }
    }

    private com.tencent.thumbplayer.tcmedia.adapter.a.e a(long j11, String str, TPDownloadParamData tPDownloadParamData, Map<String, String> map) {
        com.tencent.thumbplayer.tcmedia.adapter.a.e eVar = new com.tencent.thumbplayer.tcmedia.adapter.a.e(str);
        if (!com.tencent.thumbplayer.tcmedia.utils.b.b(str) || p()) {
            return eVar;
        }
        if (this.f49069o == null) {
            this.f49069o = new LinkedList<>();
        }
        String str2 = null;
        TPDownloadParam a11 = tPDownloadParamData != null ? a(str, tPDownloadParamData, map, s()) : null;
        if (tPDownloadParamData != null) {
            try {
                str2 = tPDownloadParamData.getDownloadFileID();
            } catch (Throwable th2) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2, "p2p proxy switch def failed");
            }
        }
        int startPlay = this.f49058c.startPlay(str2, a11, this.f49060e);
        if (startPlay > 0) {
            String playUrl = this.f49058c.getPlayUrl(startPlay, 1);
            if (TextUtils.isEmpty(playUrl)) {
                playUrl = str;
            }
            eVar.b(playUrl);
            String playUrl2 = this.f49058c.getPlayUrl(startPlay, 0);
            if (!TextUtils.isEmpty(playUrl2)) {
                str = playUrl2;
            }
            eVar.a(str);
            this.f49069o.offer(new c(j11, startPlay));
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + j11 + ",playId:" + startPlay);
            return eVar;
        }
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def failed, cause : playId <= 0");
        return eVar;
    }

    private ITPMediaAsset a(ITPMediaDRMAsset iTPMediaDRMAsset, long j11, TPVideoInfo tPVideoInfo) {
        iTPMediaDRMAsset.setDrmPlayUrl(a(j11, iTPMediaDRMAsset.getDrmPlayUrl(), (tPVideoInfo.getDownloadPraramList() == null || tPVideoInfo.getDownloadPraramList().size() <= 0) ? null : tPVideoInfo.getDownloadPraramList().get(0), iTPMediaDRMAsset.getHttpHeader()).b());
        return iTPMediaDRMAsset;
    }

    private ITPMediaAsset a(j jVar) {
        jVar.setDrmPlayUrl(a(jVar.getDrmPlayUrl(), jVar.getHttpHeader()).b());
        return jVar;
    }

    private ITPMediaAsset a(l lVar) {
        lVar.setStreamUrl(a(lVar.getStreamUrl(), lVar.getHttpHeader()).b());
        return lVar;
    }

    private ITPMediaAsset a(l lVar, long j11, TPVideoInfo tPVideoInfo) {
        lVar.setStreamUrl(a(j11, lVar.getStreamUrl(), tPVideoInfo, lVar.getHttpHeader()).b());
        return lVar;
    }

    private TPDownloadParamData a(ArrayList<TPDownloadParamData> arrayList, int i11) {
        if (com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) arrayList) || i11 >= arrayList.size()) {
            return null;
        }
        return arrayList.get(i11);
    }

    private TPDownloadParam a(String str, TPDownloadParamData tPDownloadParamData, Map<String, String> map, Map<String, Object> map2) {
        return k.a(str, tPDownloadParamData, map, map2);
    }

    /* access modifiers changed from: private */
    public Object a(com.tencent.thumbplayer.tcmedia.utils.e eVar) {
        try {
            return eVar.a(500);
        } catch (Throwable th2) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "onPlayCallback getResult has exception:" + th2.toString());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, int i12, int i13, Object obj, boolean z11, boolean z12, long j11) {
        StringBuilder sb2;
        String str;
        this.f49080z.readLock().lock();
        a aVar = this.f49057b;
        if (aVar == null) {
            sb2 = new StringBuilder();
            sb2.append(f(i11));
            str = " , send failed , handler null";
        } else if (!z11 || obj != null) {
            if (z12) {
                aVar.removeMessages(i11);
            }
            Message obtainMessage = this.f49057b.obtainMessage();
            obtainMessage.what = i11;
            obtainMessage.arg1 = i12;
            obtainMessage.arg2 = i13;
            obtainMessage.obj = obj;
            this.f49057b.sendMessageDelayed(obtainMessage, j11);
            this.f49080z.readLock().unlock();
        } else {
            sb2 = new StringBuilder();
            sb2.append(f(i11));
            str = ", send failed , params null";
        }
        sb2.append(str);
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", sb2.toString());
        this.f49080z.readLock().unlock();
    }

    /* access modifiers changed from: private */
    public void a(int i11, Object obj) {
        a(i11, 0, 0, obj, false, false, 0);
    }

    private ITPMediaAsset b(ITPMediaAsset iTPMediaAsset) {
        List<ITPMediaTrackClip> c11 = c(iTPMediaAsset);
        if (!com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) c11)) {
            this.f49065k = a(c11, q(), this.f49063i);
            m();
            n();
        }
        return iTPMediaAsset;
    }

    private ITPMediaAsset b(ITPMediaAsset iTPMediaAsset, long j11, TPVideoInfo tPVideoInfo) {
        List<ITPMediaTrackClip> c11 = c(iTPMediaAsset);
        if (!com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) c11) && tPVideoInfo != null) {
            int a11 = a(c11, tPVideoInfo.getProxyFileID(), tPVideoInfo.getDownloadPraramList());
            if (a11 > 0) {
                this.f49069o.offer(new c(j11, a11));
                TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + j11 + ",playId:" + a11);
                return iTPMediaAsset;
            }
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch clip def failed, cause : playId < 0");
        }
        return iTPMediaAsset;
    }

    private void b(TPVideoInfo tPVideoInfo) {
        String str;
        if (!p()) {
            this.f49066l = tPVideoInfo;
            if (tPVideoInfo == null || tPVideoInfo.getDownloadPraramList() == null) {
                str = "video or downloadParamList is null, return";
            } else if (this.f49065k <= 0) {
                str = "p2p proxy not start, return";
            } else {
                try {
                    ArrayList<TPDownloadParamData> downloadPraramList = tPVideoInfo.getDownloadPraramList();
                    for (int i11 = 0; i11 < downloadPraramList.size(); i11++) {
                        TPDownloadParamData tPDownloadParamData = downloadPraramList.get(i11);
                        if (!this.f49058c.setClipInfo(this.f49065k, tPDownloadParamData.getClipNo(), tPDownloadParamData.getDownloadFileID(), a(tPDownloadParamData.getUrl(), tPDownloadParamData, (Map<String, String>) null, s()))) {
                            TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "setClipInfo failed, playID:" + this.f49065k + ", clipNo:" + tPDownloadParamData.getClipNo() + ", downloadFileID:" + tPDownloadParamData.getDownloadFileID());
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2);
                    return;
                }
            }
            TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", str);
        }
    }

    private boolean b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        HashMap hashMap = new HashMap();
        hashMap.put(TPDownloadProxyEnum.DLPARAM_DATA_TRANSFER_MODE, 1);
        try {
            return this.f49058c.setClipInfo(this.f49065k, 2, str2, new TPDownloadParam(arrayList, 3, hashMap));
        } catch (Throwable th2) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2);
            return false;
        }
    }

    private List<ITPMediaTrackClip> c(ITPMediaAsset iTPMediaAsset) {
        ITPMediaTrack iTPMediaTrack;
        if (iTPMediaAsset instanceof com.tencent.thumbplayer.tcmedia.b.e) {
            List<ITPMediaTrack> allAVTracks = ((com.tencent.thumbplayer.tcmedia.b.e) iTPMediaAsset).getAllAVTracks();
            if (com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) allAVTracks) || (iTPMediaTrack = allAVTracks.get(0)) == null || com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) iTPMediaTrack.getAllTrackClips())) {
                return null;
            }
            return iTPMediaTrack.getAllTrackClips();
        } else if (iTPMediaAsset instanceof ITPMediaTrack) {
            ITPMediaTrack iTPMediaTrack2 = (ITPMediaTrack) iTPMediaAsset;
            if (!com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) iTPMediaTrack2.getAllTrackClips())) {
                return iTPMediaTrack2.getAllTrackClips();
            }
            return null;
        } else if (!(iTPMediaAsset instanceof ITPMediaTrackClip)) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add((ITPMediaTrackClip) iTPMediaAsset);
            return arrayList;
        }
    }

    private void c(int i11) {
        try {
            this.f49058c.pauseDownload(i11);
        } catch (Throwable th2) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2, "p2p proxy pause download failed, taskId:".concat(String.valueOf(i11)));
        }
    }

    private void d(int i11) {
        try {
            this.f49058c.resumeDownload(this.f49065k);
        } catch (Throwable th2) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2, "p2p proxy resume download failed, taskId:".concat(String.valueOf(i11)));
        }
    }

    private void e(int i11) {
        if (!p()) {
            try {
                this.f49058c.stopPlay(i11);
            } catch (Throwable th2) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2, "p2p proxy stop play failed, taskID:".concat(String.valueOf(i11)));
            }
        }
    }

    private String f(int i11) {
        switch (i11) {
            case 4097:
                return "onDownloadFinish";
            case 4098:
                return "onDownloadError";
            case 4099:
                return "onDownloadCdnUrlUpdate";
            case 4100:
                return "onDownloadCdnUrlInfoUpdate";
            case 4101:
                return "onDownloadStatusUpdate";
            case 4102:
                return "onDownloadProtocolUpdate";
            case 4103:
                return "onDownloadCdnUrlExpired";
            case 4104:
                return "onPlayCallback";
            case 4105:
            case 4107:
                return "getPlayInfo";
            case 4106:
                return "onDownloadProgressUpdate";
            default:
                return "unknown";
        }
    }

    /* access modifiers changed from: private */
    public void g(int i11) {
        switch (i11) {
            case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND:
                b(13);
                return;
            case TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND:
                b(14);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public void h(int i11) {
        if (i11 == 1) {
            b(1);
            b(10);
        } else if (i11 == 2) {
            b(2);
            b(9);
        } else if (i11 == 3) {
            b(2);
            b(10);
        }
    }

    private boolean l() {
        if (this.f49062h == f49055g) {
            this.f49062h = TPPlayerConfig.getProxyServiceType();
        }
        b a11 = i.a().a(this.f49062h);
        if (a11 == null || a11.a() == null) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "initProxy failed, serviceType:" + this.f49062h + ", playProxyManager:" + a11);
            return false;
        }
        try {
            ITPDownloadProxy a12 = a11.a();
            this.f49058c = a12;
            a12.setUserData(TPDownloadProxyEnum.USER_IS_VIP, Boolean.valueOf(TPPlayerConfig.isUserIsVip()));
            if (!TextUtils.isEmpty(TPPlayerConfig.getUserUin())) {
                this.f49058c.setUserData(TPDownloadProxyEnum.USER_UIN, TPPlayerConfig.getUserUin());
            }
            if (!TextUtils.isEmpty(TPPlayerConfig.getAppVersionName(this.f49056a))) {
                this.f49058c.setUserData(TPDownloadProxyEnum.USER_APP_VERSION, TPPlayerConfig.getAppVersionName(this.f49056a));
            }
            if (TPPlayerConfig.getBuildNumber(this.f49056a) != -1) {
                this.f49058c.setUserData("app_version_code", String.valueOf(TPPlayerConfig.getBuildNumber(this.f49056a)));
            }
            this.f49058c.setUserData(TPDownloadProxyEnum.USER_UPC, TPPlayerConfig.getUserUpc());
            this.f49058c.setUserData(TPDownloadProxyEnum.USER_UPC_STATE, Integer.valueOf(TPPlayerConfig.getUserUpcState()));
            this.f49058c.setUserData(TPDownloadProxyEnum.USER_EXTERNAL_NETWORK_IP, TPPlayerConfig.getOutNetIp());
            this.f49058c.setUserData(TPDownloadProxyEnum.TAB_ABUSERID, TPPlayerConfig.getAbUserId());
            return true;
        } catch (Throwable th2) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2);
            return false;
        }
    }

    private void m() {
        try {
            this.f49058c.setPlayState(this.f49065k, this.f49074t ? 101 : 100);
        } catch (Throwable th2) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2);
        }
    }

    private void n() {
        int i11 = this.f49065k;
        if (i11 > 0) {
            this.f49058c.updateTaskInfo(i11, TPDownloadProxyEnum.TASKINFO_ADAPTIVE_DYNAMIC_SWITCH, Integer.valueOf((this.f49075u || this.f49076v) ? 1 : 0));
            this.f49058c.updateTaskInfo(this.f49065k, TPDownloadProxyEnum.TASKINFO_MAX_BITRATE, Long.valueOf(this.f49078x));
            this.f49058c.updateTaskInfo(this.f49065k, TPDownloadProxyEnum.DLPARAM_MULTI_NETWORK, Integer.valueOf(this.f49077w ? 1 : 0));
        }
    }

    private void o() {
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "reset");
        this.f49064j = "";
        this.f49067m = "";
        this.f49066l = null;
        this.f49071q = 0;
        this.f49072r = 0;
        this.f49073s = false;
        this.f49074t = true;
        this.f49075u = false;
        this.f49076v = false;
        this.f49077w = false;
        if (!com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) this.f49063i)) {
            this.f49063i.clear();
        }
        this.f49059d = 0;
        this.f49062h = f49055g;
        this.f49058c = null;
        this.f49078x = 100000000;
    }

    private boolean p() {
        if (!TPPlayerConfig.isUseP2P()) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "config set don't use download proxy!");
            return true;
        }
        if (this.f49059d == 0) {
            this.f49059d = l() ? 2 : 1;
        }
        return this.f49059d == 1;
    }

    private String q() {
        return this.f49064j;
    }

    private void r() {
        try {
            this.f49058c.setUserData(TPDownloadProxyEnum.DLPARAM_PLAY_START_TIME, Long.valueOf(this.f49071q));
            this.f49058c.setUserData(TPDownloadProxyEnum.DLPARAM_PLAY_END_TIME, Long.valueOf(this.f49072r));
        } catch (Throwable th2) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2);
        }
    }

    private Map<String, Object> s() {
        HashMap hashMap = new HashMap();
        hashMap.put(TPDownloadProxyEnum.DLPARAM_ADAPTIVE_TYPE, Integer.valueOf((this.f49076v || this.f49075u) ? 1 : 0));
        hashMap.put(TPDownloadProxyEnum.DLPARAM_MULTI_NETWORK, Integer.valueOf(this.f49077w ? 1 : 0));
        return hashMap;
    }

    private void t() {
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "inner event : release handler");
        this.f49080z.writeLock().lock();
        a aVar = this.f49057b;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages((Object) null);
            this.f49057b = null;
        }
        this.f49080z.writeLock().unlock();
    }

    public com.tencent.thumbplayer.tcmedia.adapter.a.e a(long j11, String str, TPVideoInfo tPVideoInfo, Map<String, String> map) {
        if (tPVideoInfo == null) {
            return new com.tencent.thumbplayer.tcmedia.adapter.a.e(str);
        }
        TPDownloadParamData tPDownloadParamData = null;
        if (tPVideoInfo.getDownloadPraramList() != null && tPVideoInfo.getDownloadPraramList().size() > 0) {
            tPDownloadParamData = tPVideoInfo.getDownloadPraramList().get(0);
        }
        return a(j11, str, tPDownloadParamData, map);
    }

    public com.tencent.thumbplayer.tcmedia.adapter.a.e a(String str, Map<String, String> map) {
        com.tencent.thumbplayer.tcmedia.adapter.a.e eVar = new com.tencent.thumbplayer.tcmedia.adapter.a.e(str);
        if (!com.tencent.thumbplayer.tcmedia.utils.b.b(str) || p()) {
            return eVar;
        }
        r();
        this.f49067m = str;
        TPDownloadParamData a11 = a(this.f49063i, 0);
        if (this.f49079y && a11 != null && a11.getDlType() == 1) {
            a11 = new TPDownloadParamData(11);
        }
        TPDownloadParam a12 = a11 != null ? a(str, a11, map, s()) : null;
        try {
            StringBuilder sb2 = new StringBuilder("single url:");
            sb2.append(str);
            sb2.append(", paramData.savePath:");
            String str2 = OptionsBridge.NULL_VALUE;
            sb2.append(a11 != null ? a11.getSavePath() : str2);
            sb2.append(", paramData.DownloadFileID:");
            if (a11 != null) {
                str2 = a11.getDownloadFileID();
            }
            sb2.append(str2);
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", sb2.toString());
            int startPlay = this.f49058c.startPlay(q(), a12, this.f49060e);
            if (startPlay > 0) {
                String playUrl = this.f49058c.getPlayUrl(startPlay, 0);
                if (TextUtils.isEmpty(playUrl)) {
                    playUrl = str;
                }
                TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "startDownloadPlay, playId:".concat(String.valueOf(startPlay)));
                eVar.b(playUrl);
                String playUrl2 = this.f49058c.getPlayUrl(startPlay, 1);
                if (!TextUtils.isEmpty(playUrl2)) {
                    str = playUrl2;
                }
                eVar.a(str);
                this.f49065k = startPlay;
                m();
                n();
            } else {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId <= 0");
            }
        } catch (Throwable th2) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2, "p2p proxy start play failed");
        }
        return eVar;
    }

    public ITPMediaAsset a(ITPMediaAsset iTPMediaAsset) {
        if (p()) {
            return iTPMediaAsset;
        }
        r();
        return iTPMediaAsset instanceof j ? a((j) iTPMediaAsset) : iTPMediaAsset instanceof l ? a((l) iTPMediaAsset) : b(iTPMediaAsset);
    }

    public ITPMediaAsset a(ITPMediaAsset iTPMediaAsset, long j11, TPVideoInfo tPVideoInfo) {
        if (p() || iTPMediaAsset == null) {
            return iTPMediaAsset;
        }
        if (this.f49069o == null) {
            this.f49069o = new LinkedList<>();
        }
        return tPVideoInfo == null ? iTPMediaAsset : iTPMediaAsset instanceof ITPMediaDRMAsset ? a((ITPMediaDRMAsset) iTPMediaAsset, j11, tPVideoInfo) : iTPMediaAsset instanceof l ? a((l) iTPMediaAsset, j11, tPVideoInfo) : b(iTPMediaAsset, j11, tPVideoInfo);
    }

    public String a(int i11, String str, TPDownloadParamData tPDownloadParamData) {
        String str2;
        TPDownloadParam tPDownloadParam;
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "return coz url is empty";
        } else if (!com.tencent.thumbplayer.tcmedia.utils.b.b(str)) {
            str3 = "return coz url is locol url, not need use proxy";
        } else if (p()) {
            str3 = "return coz download proxy init failed";
        } else {
            int i12 = 2;
            int i13 = 1;
            if (tPDownloadParamData != null) {
                try {
                    tPDownloadParam = k.a(str, tPDownloadParamData, (Map<String, String>) null, (Map<String, Object>) null);
                    if (tPDownloadParamData.getTaskType() != 1) {
                        i12 = 1;
                    }
                    str2 = tPDownloadParamData.getDownloadFileID();
                    if (TextUtils.isEmpty(str2)) {
                        str2 = com.tencent.thumbplayer.tcmedia.utils.b.a(str);
                    }
                    i13 = i12;
                } catch (Throwable th2) {
                    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed:".concat(String.valueOf(th2)));
                    return str;
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                int i14 = 0;
                if (i11 == 2) {
                    i14 = 3;
                }
                tPDownloadParam = new TPDownloadParam(arrayList, i14, (Map<String, Object>) null);
                str2 = com.tencent.thumbplayer.tcmedia.utils.b.a(str);
            }
            int startPlay = this.f49058c.startPlay(str2, tPDownloadParam, this.f49060e);
            if (startPlay > 0) {
                TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play, url type".concat(String.valueOf(i13)));
                String playUrl = this.f49058c.getPlayUrl(startPlay, i13);
                this.f49070p.put(playUrl, Integer.valueOf(startPlay));
                return playUrl;
            }
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId <= 0");
            return str;
        }
        TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", str3);
        return str;
    }

    public void a(float f11) {
        if (!p()) {
            if (f11 <= 0.0f) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "set play speed ratio, value invalid:".concat(String.valueOf(f11)));
                return;
            }
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "set play speed value to proxy:".concat(String.valueOf(f11)));
            this.f49058c.updateTaskInfo(this.f49065k, TPDownloadProxyEnum.TASKINFO_SPEED_RATIO, Float.valueOf(f11));
        }
    }

    public void a(int i11) {
        TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState: ".concat(String.valueOf(i11)));
        if (!p()) {
            try {
                this.f49058c.setPlayState(this.f49065k, i11);
                if ((i11 == 5 || i11 == 0) && !com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) this.f49069o)) {
                    Iterator it2 = this.f49069o.iterator();
                    while (it2.hasNext()) {
                        c cVar = (c) it2.next();
                        if (cVar != null) {
                            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState definitionID:" + cVar.f49083a + ", taskID:" + cVar.f49084b + ", state:" + i11);
                            this.f49058c.setPlayState(cVar.f49084b, i11);
                        }
                    }
                }
            } catch (Throwable th2) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2);
            }
        }
    }

    public void a(int i11, int i12, int i13, int i14) {
        TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", "onNetworkStatusChanged oldNetStatus: " + i11 + ", netStatus: " + i12);
        a(4197, i12, 0, (Object) null, false, false, 0);
    }

    public void a(int i11, int i12, int i13, Object obj) {
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "onEvent eventId: " + i11 + ", arg1: " + i12 + ", arg2: " + i13 + ", object" + obj);
        a(4196, i11, 0, (Object) null, false, false, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0051 A[Catch:{ Exception -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(long r6) {
        /*
            r5 = this;
            java.lang.String r0 = "TPThumbPlayer[TPPlayManagerImpl.java]"
            boolean r1 = r5.p()
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.util.LinkedList<com.tencent.thumbplayer.tcmedia.c.e$c> r1 = r5.f49069o     // Catch:{ Exception -> 0x0079 }
            boolean r1 = com.tencent.thumbplayer.tcmedia.utils.b.a((java.util.Collection<? extends java.lang.Object>) r1)     // Catch:{ Exception -> 0x0079 }
            if (r1 != 0) goto L_0x0078
            java.util.LinkedList<com.tencent.thumbplayer.tcmedia.c.e$c> r1 = r5.f49069o     // Catch:{ Exception -> 0x0079 }
            java.lang.Object r1 = r1.peek()     // Catch:{ Exception -> 0x0079 }
        L_0x0017:
            com.tencent.thumbplayer.tcmedia.c.e$c r1 = (com.tencent.thumbplayer.tcmedia.c.e.c) r1     // Catch:{ Exception -> 0x0079 }
            if (r1 == 0) goto L_0x004f
            long r2 = r1.f49083a     // Catch:{ Exception -> 0x0079 }
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x004f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0079 }
            java.lang.String r3 = "stop proxy definitionID:"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0079 }
            long r3 = r1.f49083a     // Catch:{ Exception -> 0x0079 }
            r2.append(r3)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r3 = ", taskID:"
            r2.append(r3)     // Catch:{ Exception -> 0x0079 }
            int r3 = r1.f49084b     // Catch:{ Exception -> 0x0079 }
            r2.append(r3)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0079 }
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.i(r0, r2)     // Catch:{ Exception -> 0x0079 }
            int r1 = r1.f49084b     // Catch:{ Exception -> 0x0079 }
            r5.e(r1)     // Catch:{ Exception -> 0x0079 }
            java.util.LinkedList<com.tencent.thumbplayer.tcmedia.c.e$c> r1 = r5.f49069o     // Catch:{ Exception -> 0x0079 }
            r1.removeFirst()     // Catch:{ Exception -> 0x0079 }
            java.util.LinkedList<com.tencent.thumbplayer.tcmedia.c.e$c> r1 = r5.f49069o     // Catch:{ Exception -> 0x0079 }
            java.lang.Object r1 = r1.peek()     // Catch:{ Exception -> 0x0079 }
            goto L_0x0017
        L_0x004f:
            if (r1 == 0) goto L_0x0078
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0079 }
            java.lang.String r7 = "stop proxy task id:"
            r6.<init>(r7)     // Catch:{ Exception -> 0x0079 }
            int r7 = r1.f49084b     // Catch:{ Exception -> 0x0079 }
            r6.append(r7)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0079 }
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.i(r0, r6)     // Catch:{ Exception -> 0x0079 }
            int r6 = r5.f49065k     // Catch:{ Exception -> 0x0079 }
            r5.e(r6)     // Catch:{ Exception -> 0x0079 }
            int r6 = r1.f49084b     // Catch:{ Exception -> 0x0079 }
            r5.f49065k = r6     // Catch:{ Exception -> 0x0079 }
            r5.m()     // Catch:{ Exception -> 0x0079 }
            r5.n()     // Catch:{ Exception -> 0x0079 }
            java.util.LinkedList<com.tencent.thumbplayer.tcmedia.c.e$c> r6 = r5.f49069o     // Catch:{ Exception -> 0x0079 }
            r6.remove(r1)     // Catch:{ Exception -> 0x0079 }
        L_0x0078:
            return
        L_0x0079:
            r6 = move-exception
            java.lang.String r7 = "playerSwitchDefComplete exception"
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.e(r0, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.c.e.a(long):void");
    }

    public void a(long j11, long j12) {
        ITPDownloadProxy iTPDownloadProxy;
        if (!p() && (iTPDownloadProxy = this.f49058c) != null) {
            iTPDownloadProxy.switchToResolution(this.f49065k, (int) j11, (int) j12);
        }
    }

    public void a(TPOptionalParam tPOptionalParam) {
        if (p() || tPOptionalParam == null) {
            return;
        }
        if (tPOptionalParam.getKey() == 100) {
            this.f49071q = tPOptionalParam.getParamLong().value;
        } else if (tPOptionalParam.getKey() == 500) {
            try {
                long j11 = tPOptionalParam.getParamLong().value;
                this.f49072r = j11;
                if (this.f49065k > 0) {
                    this.f49058c.setUserData(TPDownloadProxyEnum.DLPARAM_PLAY_END_TIME, Long.valueOf(j11));
                }
            } catch (Throwable th2) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2);
            }
        } else if (tPOptionalParam.getKey() == 503) {
            this.f49078x = tPOptionalParam.getParamLong().param1;
            n();
        } else if (tPOptionalParam.getKey() == 508) {
            this.f49075u = tPOptionalParam.getParamBoolean().value;
            n();
        } else if (tPOptionalParam.getKey() == 504) {
            this.f49076v = tPOptionalParam.getParamLong().value != 0;
            n();
        } else if (tPOptionalParam.getKey() == 509) {
            this.f49077w = tPOptionalParam.getParamBoolean().value;
            n();
        }
    }

    public void a(TPVideoInfo tPVideoInfo) {
        if (tPVideoInfo == null) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, param is null ");
            return;
        }
        if (this.f49066l != null) {
            b(tPVideoInfo);
        }
        this.f49066l = tPVideoInfo;
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, enter");
        this.f49064j = tPVideoInfo.getProxyFileID();
        if (!com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) this.f49063i)) {
            this.f49063i.clear();
        }
        if (tPVideoInfo.getDownloadPraramList() != null && tPVideoInfo.getDownloadPraramList().size() > 0) {
            this.f49063i.addAll(tPVideoInfo.getDownloadPraramList());
        }
    }

    public void a(ITPPlayListener iTPPlayListener) {
        if (iTPPlayListener == null) {
            this.f49061f = new f("TPThumbPlayer[TPPlayManagerImpl.java]");
        } else {
            this.f49061f = iTPPlayListener;
        }
    }

    public void a(String str, Object obj) {
        ITPDownloadProxy iTPDownloadProxy = this.f49058c;
        if (iTPDownloadProxy != null) {
            iTPDownloadProxy.updateTaskInfo(this.f49065k, str, obj);
        }
    }

    public void a(String str, String str2) {
        if (!com.tencent.thumbplayer.tcmedia.utils.b.b(str) || TextUtils.isEmpty(str2)) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "startRemuxer, audioTrackUrl:" + str + ", keyId:" + str2);
        } else if (p()) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "startRemuxer, download proxy init failed.");
        } else {
            if (this.f49073s) {
                int i11 = this.f49065k;
                if (i11 > 0) {
                    e(i11);
                }
                this.f49065k = 0;
                a(this.f49067m, (Map<String, String>) null);
                if (!b(str, str2)) {
                    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "startRemuxer, addAudioTrack err.");
                    return;
                }
            } else if (!b(str, str2)) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "startRemuxer, addAudioTrack err.");
                return;
            }
            this.f49073s = true;
        }
    }

    public void a(boolean z11) {
        this.f49079y = z11;
    }

    public boolean a() {
        return this.f49079y;
    }

    public byte[] a(String str, String str2, String str3) {
        ITPDownloadProxy iTPDownloadProxy;
        if (!p() && (iTPDownloadProxy = this.f49058c) != null) {
            return iTPDownloadProxy.getOfflineLicenseKeySetId(str, str2, str3);
        }
        return null;
    }

    public void b() {
        if (p()) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "stopRemuxer, download proxy init failed.");
            return;
        }
        if (this.f49073s) {
            int i11 = this.f49065k;
            if (i11 > 0) {
                e(i11);
            }
            this.f49065k = 0;
            a(this.f49067m, (Map<String, String>) null);
        }
        this.f49073s = false;
    }

    public void b(int i11) {
        if (!p()) {
            try {
                this.f49058c.pushEvent(i11);
            } catch (Throwable th2) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2, "p2p proxy pushEvent failed, event:".concat(String.valueOf(i11)));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r2.f49069o;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c() {
        /*
            r2 = this;
            boolean r0 = r2.p()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.LinkedList<com.tencent.thumbplayer.tcmedia.c.e$c> r0 = r2.f49069o
            if (r0 == 0) goto L_0x0014
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0014
            r0 = 1
            return r0
        L_0x0014:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.c.e.c():boolean");
    }

    public void d() {
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload, playId:" + this.f49065k);
        int i11 = this.f49065k;
        if (i11 > 0) {
            e(i11);
        }
        this.f49065k = 0;
        if (!com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) this.f49069o)) {
            Iterator it2 = this.f49069o.iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                if (cVar != null) {
                    e(cVar.f49084b);
                }
            }
            this.f49069o.clear();
        }
        if (!com.tencent.thumbplayer.tcmedia.utils.b.a((Map<? extends Object, ? extends Object>) this.f49070p)) {
            for (Integer intValue : this.f49070p.values()) {
                e(intValue.intValue());
            }
            this.f49070p.clear();
        }
        o();
    }

    public void e() {
        d();
        i.a().b((i.b) this);
        com.tencent.thumbplayer.tcmedia.utils.f.b(this);
        t();
        this.f49068n = null;
        this.f49061f = new f("TPThumbPlayer[TPPlayManagerImpl.java]");
        this.f49060e = null;
        this.f49058c = null;
    }

    public boolean f() {
        return !p();
    }

    public String g() {
        if (p()) {
            return null;
        }
        try {
            return this.f49058c.getPlayErrorCodeStr(this.f49065k);
        } catch (Throwable th2) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th2);
            return null;
        }
    }

    public void h() {
        if (!p()) {
            c(this.f49065k);
            if (!com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) this.f49069o)) {
                Iterator it2 = this.f49069o.iterator();
                while (it2.hasNext()) {
                    c cVar = (c) it2.next();
                    if (cVar != null) {
                        c(cVar.f49084b);
                    }
                }
            }
            if (!com.tencent.thumbplayer.tcmedia.utils.b.a((Map<? extends Object, ? extends Object>) this.f49070p)) {
                for (Integer intValue : this.f49070p.values()) {
                    c(intValue.intValue());
                }
            }
        }
    }

    public void i() {
        if (!p()) {
            d(this.f49065k);
            if (!com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) this.f49069o)) {
                Iterator it2 = this.f49069o.iterator();
                while (it2.hasNext()) {
                    c cVar = (c) it2.next();
                    if (cVar != null) {
                        d(cVar.f49084b);
                    }
                }
            }
            if (!com.tencent.thumbplayer.tcmedia.utils.b.a((Map<? extends Object, ? extends Object>) this.f49070p)) {
                for (Integer intValue : this.f49070p.values()) {
                    d(intValue.intValue());
                }
            }
        }
    }

    public ITPPlayerProxyListener j() {
        return this.f49068n;
    }

    public TPDLProxyMsg.TPPDTInfo[] k() {
        ITPDownloadProxy iTPDownloadProxy;
        if (!p() && (iTPDownloadProxy = this.f49058c) != null) {
            return iTPDownloadProxy.getPDTInfos(this.f49065k);
        }
        return null;
    }

    public void pushEvent(int i11) {
        if (!p()) {
            try {
                b(h.b(i11));
            } catch (IllegalArgumentException e11) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", (Throwable) e11);
            }
        }
    }

    public void setIsActive(boolean z11) {
        TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setIsActive: ".concat(String.valueOf(z11)));
        this.f49074t = z11;
        if (!p()) {
            m();
        }
    }

    public void setProxyServiceType(int i11) {
        this.f49062h = i11;
    }

    public void setTPPlayerProxyListener(ITPPlayerProxyListener iTPPlayerProxyListener) {
        this.f49068n = iTPPlayerProxyListener;
    }
}
