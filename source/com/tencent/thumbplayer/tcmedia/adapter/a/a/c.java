package com.tencent.thumbplayer.tcmedia.adapter.a.a;

import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.adapter.a.a.a;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.tcmedia.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.tcmedia.core.subtitle.ITPSubtitleParserCallback;
import com.tencent.thumbplayer.tcmedia.core.subtitle.TPNativeSubtitleRenderParams;
import com.tencent.thumbplayer.tcmedia.core.subtitle.TPSubtitleParser;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.o;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public int f48711a = 0;

    /* renamed from: b  reason: collision with root package name */
    public TPNativeSubtitleRenderParams f48712b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a.C0611a f48713c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a.d f48714d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a.c f48715e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a.b f48716f;

    /* renamed from: g  reason: collision with root package name */
    private TPSubtitleParser f48717g;

    /* renamed from: h  reason: collision with root package name */
    private String f48718h;

    /* renamed from: i  reason: collision with root package name */
    private Future<?> f48719i = null;

    /* renamed from: j  reason: collision with root package name */
    private final Object f48720j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private a f48721k = a.IDLE;

    public enum a {
        IDLE,
        INITED,
        PREPARED,
        STOPED,
        ERROR
    }

    /* access modifiers changed from: private */
    public void a(long j11) {
        if (this.f48721k != a.INITED) {
            TPLogUtil.e("TPSysPlayerExternalSubtitle", "prepare, illegalState, state:" + this.f48721k);
            return;
        }
        TPMediaTrackInfo[] trackInfo = this.f48717g.getTrackInfo();
        if (trackInfo == null || trackInfo.length <= 0) {
            TPLogUtil.w("TPSysPlayerExternalSubtitle", "prepare, err, trackInfos is empty.");
            this.f48721k = a.ERROR;
        } else if (trackInfo[0].trackType != 3) {
            this.f48721k = a.ERROR;
            TPLogUtil.w("TPSysPlayerExternalSubtitle", "prepare, err, track type not match.");
        } else {
            this.f48717g.selectTrackAsync(0, j11);
            this.f48721k = a.PREPARED;
            if (this.f48711a == 0) {
                synchronized (this.f48720j) {
                    Future<?> future = this.f48719i;
                    if (future != null) {
                        future.cancel(true);
                        this.f48719i = null;
                    }
                    this.f48719i = o.a().e().scheduleAtFixedRate(new Runnable() {
                        public void run() {
                            c.this.b(0);
                        }
                    }, 0, 200, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(int i11) {
        a.d dVar = this.f48714d;
        a.C0611a aVar = this.f48713c;
        if (dVar == null || aVar == null) {
            TPLogUtil.w("TPSysPlayerExternalSubtitle", "subPollFunc, posLis:" + dVar + ", subLis:" + aVar);
            return;
        }
        long a11 = dVar.a();
        if (a11 < 0) {
            TPLogUtil.w("TPSysPlayerExternalSubtitle", "subPollFunc, cur position:".concat(String.valueOf(a11)));
            return;
        }
        String subtitleText = this.f48717g.getSubtitleText(a11, i11);
        if (!TextUtils.equals(this.f48718h, subtitleText)) {
            this.f48718h = subtitleText;
            aVar.a(new a.e(subtitleText));
        }
    }

    public void a() {
        if (this.f48721k != a.INITED) {
            TPLogUtil.e("TPSysPlayerExternalSubtitle", "prepare, illegalState, state:" + this.f48721k);
            return;
        }
        TPLogUtil.i("TPSysPlayerExternalSubtitle", "prepare.");
        this.f48717g.init();
        this.f48717g.loadAsync();
        TPNativeSubtitleRenderParams tPNativeSubtitleRenderParams = this.f48712b;
        if (tPNativeSubtitleRenderParams != null) {
            this.f48717g.setRenderParams(tPNativeSubtitleRenderParams);
        }
    }

    public void a(int i11) {
        this.f48711a = i11;
    }

    public void a(a.C0611a aVar) {
        this.f48713c = aVar;
    }

    public void a(a.b bVar) {
        this.f48716f = bVar;
    }

    public void a(a.c cVar) {
        this.f48715e = cVar;
    }

    public void a(a.d dVar) {
        this.f48714d = dVar;
    }

    public void a(TPSubtitleRenderModel tPSubtitleRenderModel) {
        TPNativeSubtitleRenderParams a11 = com.tencent.thumbplayer.tcmedia.adapter.a.b.c.a(tPSubtitleRenderModel);
        this.f48712b = a11;
        TPSubtitleParser tPSubtitleParser = this.f48717g;
        if (tPSubtitleParser != null) {
            tPSubtitleParser.setRenderParams(a11);
        }
    }

    public void a(String str, Map<String, String> map, final long j11) {
        if (this.f48721k != a.IDLE) {
            TPLogUtil.e("TPSysPlayerExternalSubtitle", "setDataSource, illegalState, state:" + this.f48721k);
        } else if (TextUtils.isEmpty(str)) {
            TPLogUtil.e("TPSysPlayerExternalSubtitle", "setDataSource, illegal argument, url:".concat(String.valueOf(str)));
        } else {
            TPLogUtil.i("TPSysPlayerExternalSubtitle", "setDataSource, url: ".concat(String.valueOf(str)));
            if (this.f48717g != null) {
                TPLogUtil.w("TPSysPlayerExternalSubtitle", "setDataSource, mTpSubParser != null.");
                try {
                    this.f48717g.stop();
                    this.f48717g.unInit();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                this.f48717g = null;
            }
            this.f48717g = new TPSubtitleParser(str, map, new ITPSubtitleParserCallback() {
                public long onGetCurrentPlayPositionMs() {
                    if (c.this.f48714d != null) {
                        return c.this.f48714d.a();
                    }
                    return 0;
                }

                public void onLoadResult(int i11) {
                    TPLogUtil.i("TPSysPlayerExternalSubtitle", "onLoadResult, index:".concat(String.valueOf(i11)));
                    c.this.a(j11);
                }

                public void onSelectResult(int i11, long j11) {
                    TPLogUtil.i("TPSysPlayerExternalSubtitle", "onSelectResult, errCode:" + i11 + ", selectOpaque:" + j11 + ", opaque =" + j11);
                    if (i11 == 0 && c.this.f48715e != null) {
                        c.this.f48715e.a(j11);
                    } else if (i11 != 0 && c.this.f48715e != null) {
                        c.this.f48715e.a(i11, j11);
                    }
                }

                public void onSubtitleError(int i11, int i12) {
                    TPLogUtil.i("TPSysPlayerExternalSubtitle", "onSubtitleError, index:" + i11 + ", errorCode:" + i12);
                    c.this.f48716f.a(i11, i12);
                }

                public void onSubtitleFrame(TPSubtitleFrame tPSubtitleFrame) {
                    TPLogUtil.i("TPSysPlayerExternalSubtitle", "onSubtitleFrame");
                    if (c.this.f48713c != null) {
                        c.this.f48713c.a(tPSubtitleFrame);
                    }
                }

                public void onSubtitleNote(String str) {
                    TPLogUtil.i("TPSysPlayerExternalSubtitle", "onSubtitleNote");
                    if (c.this.f48713c != null) {
                        c.this.f48713c.a(str);
                    }
                }
            }, this.f48711a);
            this.f48721k = a.INITED;
        }
    }

    public void b() {
        if (this.f48721k != a.PREPARED) {
            TPLogUtil.e("TPSysPlayerExternalSubtitle", "startAsync, illegalState, state:" + this.f48721k);
            return;
        }
        TPLogUtil.i("TPSysPlayerExternalSubtitle", "startAsync");
        this.f48717g.startAsync();
    }

    public void c() {
        if (this.f48721k != a.PREPARED) {
            TPLogUtil.e("TPSysPlayerExternalSubtitle", "pauseAsync, illegalState, state:" + this.f48721k);
            return;
        }
        TPLogUtil.i("TPSysPlayerExternalSubtitle", "pauseAsync");
        this.f48717g.pauseAsync();
    }

    public void d() {
        TPLogUtil.i("TPSysPlayerExternalSubtitle", "stop.");
        a aVar = this.f48721k;
        if (aVar == a.INITED || aVar == a.PREPARED || aVar == a.ERROR) {
            TPSubtitleParser tPSubtitleParser = this.f48717g;
            if (tPSubtitleParser != null) {
                try {
                    tPSubtitleParser.stop();
                    this.f48717g.unInit();
                } catch (Exception e11) {
                    TPLogUtil.e("TPSysPlayerExternalSubtitle", (Throwable) e11);
                }
            }
            this.f48717g = null;
        }
        if (this.f48711a == 0) {
            synchronized (this.f48720j) {
                Future<?> future = this.f48719i;
                if (future != null) {
                    future.cancel(true);
                    this.f48719i = null;
                }
            }
        }
        this.f48721k = a.STOPED;
    }

    public void e() {
        TPLogUtil.i("TPSysPlayerExternalSubtitle", "reset.");
        if (this.f48721k != a.IDLE) {
            TPSubtitleParser tPSubtitleParser = this.f48717g;
            if (tPSubtitleParser != null) {
                try {
                    tPSubtitleParser.stop();
                    this.f48717g.unInit();
                } catch (Exception e11) {
                    TPLogUtil.e("TPSysPlayerExternalSubtitle", (Throwable) e11);
                }
            }
            this.f48717g = null;
        }
        synchronized (this.f48720j) {
            Future<?> future = this.f48719i;
            if (future != null) {
                future.cancel(true);
                this.f48719i = null;
            }
        }
        this.f48721k = a.IDLE;
    }

    public void f() {
        TPLogUtil.i("TPSysPlayerExternalSubtitle", "release.");
        this.f48714d = null;
        this.f48713c = null;
    }
}
