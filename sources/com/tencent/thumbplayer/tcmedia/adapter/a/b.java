package com.tencent.thumbplayer.tcmedia.adapter.a;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.tcmedia.adapter.a.c;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureCallBack;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureParams;
import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalParam;
import com.tencent.thumbplayer.tcmedia.api.TPProgramInfo;
import com.tencent.thumbplayer.tcmedia.api.TPTrackInfo;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.tcmedia.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;
import java.util.List;
import java.util.Map;

public interface b {
    void a(float f11);

    void a(int i11);

    void a(int i11, @TPCommonEnum.TPSeekMode int i12);

    void a(int i11, long j11);

    void a(AssetFileDescriptor assetFileDescriptor);

    void a(ParcelFileDescriptor parcelFileDescriptor);

    void a(Surface surface);

    void a(SurfaceHolder surfaceHolder);

    void a(c.a aVar);

    void a(c.b bVar);

    void a(c.C0614c cVar);

    void a(c.d dVar);

    void a(c.e eVar);

    void a(c.f fVar);

    void a(c.g gVar);

    void a(c.h hVar);

    void a(c.i iVar);

    void a(c.j jVar);

    void a(c.l lVar);

    void a(c.m mVar);

    void a(c.n nVar);

    void a(c.o oVar);

    void a(c.p pVar);

    void a(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack);

    void a(TPOptionalParam tPOptionalParam);

    void a(ITPMediaAsset iTPMediaAsset);

    void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i11, long j11);

    void a(com.tencent.thumbplayer.tcmedia.e.b bVar);

    void a(String str);

    void a(String str, @TPCommonEnum.TPSwitchDefMode int i11, long j11);

    void a(String str, Map<String, String> map);

    void a(String str, Map<String, String> map, @TPCommonEnum.TPSwitchDefMode int i11, long j11);

    void a(String str, Map<String, String> map, String str2, String str3);

    void a(String str, Map<String, String> map, String str2, List<TPOptionalParam> list);

    void a(boolean z11);

    void a(boolean z11, long j11, long j12);

    long b(int i11);

    void b(float f11);

    void b(int i11, long j11);

    void b(boolean z11);

    TPDynamicStatisticParams c(boolean z11);

    String c(int i11);

    void c(int i11, long j11);

    void g();

    void h();

    void i();

    void j();

    void k();

    void l();

    void m();

    long n();

    long o();

    long p();

    int q();

    int r();

    TPTrackInfo[] s();

    TPProgramInfo[] t();

    long u();

    TPGeneralPlayFlowParams v();
}
