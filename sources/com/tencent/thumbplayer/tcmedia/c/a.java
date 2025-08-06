package com.tencent.thumbplayer.tcmedia.c;

import com.tencent.thumbplayer.tcmedia.adapter.a.e;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalParam;
import com.tencent.thumbplayer.tcmedia.api.TPVideoInfo;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.tcmedia.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.tcmedia.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.tcmedia.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyMsg;
import java.util.Map;

public interface a extends ITPPlayerProxy {
    e a(long j11, String str, TPVideoInfo tPVideoInfo, Map<String, String> map);

    e a(String str, Map<String, String> map);

    ITPMediaAsset a(ITPMediaAsset iTPMediaAsset);

    ITPMediaAsset a(ITPMediaAsset iTPMediaAsset, long j11, TPVideoInfo tPVideoInfo);

    String a(int i11, String str, TPDownloadParamData tPDownloadParamData);

    void a(float f11);

    void a(int i11);

    void a(long j11);

    void a(long j11, long j12);

    void a(TPOptionalParam tPOptionalParam);

    void a(TPVideoInfo tPVideoInfo);

    void a(ITPPlayListener iTPPlayListener);

    void a(String str, Object obj);

    void a(String str, String str2);

    void a(boolean z11);

    boolean a();

    byte[] a(String str, String str2, String str3);

    void b();

    boolean c();

    void d();

    void e();

    boolean f();

    String g();

    void h();

    void i();

    ITPPlayerProxyListener j();

    TPDLProxyMsg.TPPDTInfo[] k();
}
