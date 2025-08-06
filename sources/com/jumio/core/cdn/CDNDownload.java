package com.jumio.core.cdn;

import android.os.SystemClock;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.core.environment.Environment;
import com.jumio.core.network.DownloadTask;
import com.jumio.core.network.b;
import d10.l;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CDNDownload implements DownloadTask.ProgressListener<Boolean> {
    public static final Companion Companion = new Companion((r) null);
    public static final int DEFAULT_TIMEOUT = 30000;

    /* renamed from: a  reason: collision with root package name */
    public final l<Boolean, Unit> f39070a;

    /* renamed from: b  reason: collision with root package name */
    public final Long f39071b;

    /* renamed from: c  reason: collision with root package name */
    public Long f39072c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f39073d;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public CDNDownload(String str, File file, int i11, l<? super Boolean, Unit> lVar) {
        File parentFile;
        this.f39070a = lVar;
        Object obj = new Object();
        this.f39073d = obj;
        boolean z11 = true;
        if (str.length() > 0) {
            File parentFile2 = file.getParentFile();
            if (((parentFile2 == null || parentFile2.exists()) ? false : z11) && (parentFile = file.getParentFile()) != null) {
                parentFile.mkdirs();
            }
            String cdn_url = Environment.INSTANCE.getCDN_URL();
            b bVar = new b(cdn_url + str, file, i11);
            bVar.setListener(this);
            bVar.start();
            synchronized (obj) {
                this.f39071b = Long.valueOf(SystemClock.elapsedRealtime());
                Unit unit = Unit.f56620a;
            }
        }
    }

    public final Long getDurationInMs() {
        Long l11;
        synchronized (this.f39073d) {
            Long l12 = this.f39071b;
            Long l13 = this.f39072c;
            if (l12 != null) {
                if (l13 != null) {
                    l11 = Long.valueOf(l13.longValue() - l12.longValue());
                }
            }
            l11 = null;
        }
        return l11;
    }

    public void onProgressException(Exception exc) {
    }

    public void onProgressUpdate(float f11) {
    }

    public void onProgressDone(Boolean bool) {
        synchronized (this.f39073d) {
            this.f39072c = Long.valueOf(SystemClock.elapsedRealtime());
            Long durationInMs = getDurationInMs();
            if (durationInMs != null) {
                MetaInfo metaInfo = new MetaInfo();
                metaInfo.put("modelDownloadTime", durationInMs);
                Analytics.Companion.add(MobileEvents.performance("CDN Download", metaInfo));
            }
            Unit unit = Unit.f56620a;
        }
        l<Boolean, Unit> lVar = this.f39070a;
        if (lVar != null) {
            lVar.invoke(Boolean.valueOf(x.b(bool, Boolean.TRUE)));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CDNDownload(String str, File file, int i11, l lVar, int i12, r rVar) {
        this(str, file, (i12 & 4) != 0 ? DEFAULT_TIMEOUT : i11, (i12 & 8) != 0 ? null : lVar);
    }
}
