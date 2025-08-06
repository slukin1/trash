package com.tencent.thumbplayer.tcmedia.common.a;

import com.tencent.thumbplayer.tcmedia.api.TPNativeException;
import com.tencent.thumbplayer.tcmedia.api.capability.TPCapability;
import com.tencent.thumbplayer.tcmedia.api.capability.TPVCodecCapabilityForGet;
import com.tencent.thumbplayer.tcmedia.common.a.d;
import com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.l;
import java.util.UUID;

public class c {
    private void a(d.a aVar, a aVar2) {
        TPVCodecCapabilityForGet b11 = b();
        if (b11 != null) {
            aVar.f49116a = b11.getMaxProfile();
            aVar.f49117b = b11.getMaxLevel();
        }
        aVar.a(aVar2);
    }

    private void a(d.b bVar, a aVar) {
        bVar.f49121c = TPSystemInfo.SDK_INT;
        bVar.f49119a = UUID.randomUUID().toString() + System.nanoTime() + "_" + TPPlayerConfig.getPlatform();
        bVar.f49120b = TPPlayerConfig.getPlatform();
        bVar.f49122d = String.format("Android %s", new Object[]{TPSystemInfo.getOsVersion()});
        bVar.f49123e = String.format("%s_%s", new Object[]{TPSystemInfo.getDeviceManufacturer(), TPSystemInfo.getDeviceName()});
        bVar.f49125g = TPSystemInfo.getCpuHarewareName();
        bVar.a(aVar);
    }

    private void a(d.c cVar, a aVar) {
        TPVCodecCapabilityForGet e11 = e();
        if (e11 != null) {
            cVar.f49127a = e11.getMaxProfile();
            cVar.f49128b = e11.getMaxLevel();
        }
        cVar.a(aVar);
    }

    private void a(d.C0618d dVar, a aVar) {
        TPVCodecCapabilityForGet d11 = d();
        if (d11 != null) {
            dVar.f49130a = d11.getMaxProfile();
            dVar.f49131b = d11.getMaxLevel();
        }
        dVar.a(aVar);
    }

    private void a(d.e eVar, a aVar) {
        TPVCodecCapabilityForGet c11 = c();
        if (c11 != null) {
            eVar.f49133a = c11.getMaxProfile();
            eVar.f49134b = c11.getMaxLevel();
        }
        eVar.a(aVar);
    }

    private static TPVCodecCapabilityForGet b() {
        TPVCodecCapabilityForGet tPVCodecCapabilityForGet;
        try {
            tPVCodecCapabilityForGet = TPCapability.getThumbPlayerVCodecTypeMaxCapability(1029, 102);
        } catch (TPNativeException e11) {
            TPLogUtil.e("TPDeviceCapabilityReportManager", (Throwable) e11);
            tPVCodecCapabilityForGet = null;
        }
        if (tPVCodecCapabilityForGet == TPVCodecCapabilityForGet.mDefaultVCodecCapability) {
            return null;
        }
        return tPVCodecCapabilityForGet;
    }

    private static TPVCodecCapabilityForGet c() {
        TPVCodecCapabilityForGet tPVCodecCapabilityForGet;
        try {
            tPVCodecCapabilityForGet = TPCapability.getThumbPlayerVCodecTypeMaxCapability(166, 102);
        } catch (TPNativeException e11) {
            TPLogUtil.e("TPDeviceCapabilityReportManager", (Throwable) e11);
            tPVCodecCapabilityForGet = null;
        }
        if (tPVCodecCapabilityForGet == TPVCodecCapabilityForGet.mDefaultVCodecCapability) {
            return null;
        }
        return tPVCodecCapabilityForGet;
    }

    private static TPVCodecCapabilityForGet d() {
        TPVCodecCapabilityForGet tPVCodecCapabilityForGet;
        try {
            tPVCodecCapabilityForGet = TPCapability.getThumbPlayerVCodecTypeMaxCapability(138, 102);
        } catch (TPNativeException e11) {
            TPLogUtil.e("TPDeviceCapabilityReportManager", (Throwable) e11);
            tPVCodecCapabilityForGet = null;
        }
        if (tPVCodecCapabilityForGet == TPVCodecCapabilityForGet.mDefaultVCodecCapability) {
            return null;
        }
        return tPVCodecCapabilityForGet;
    }

    private static TPVCodecCapabilityForGet e() {
        TPVCodecCapabilityForGet tPVCodecCapabilityForGet;
        try {
            tPVCodecCapabilityForGet = TPCapability.getThumbPlayerVCodecTypeMaxCapability(172, 102);
        } catch (TPNativeException e11) {
            TPLogUtil.e("TPDeviceCapabilityReportManager", (Throwable) e11);
            tPVCodecCapabilityForGet = null;
        }
        if (tPVCodecCapabilityForGet == TPVCodecCapabilityForGet.mDefaultVCodecCapability) {
            return null;
        }
        return tPVCodecCapabilityForGet;
    }

    private void f() {
        d dVar = new d();
        l lVar = new l();
        a(dVar.a(), (a) lVar);
        a(dVar.b(), (a) lVar);
        a(dVar.c(), (a) lVar);
        a(dVar.d(), (a) lVar);
        a(dVar.e(), (a) lVar);
    }

    public void a() {
        f();
    }
}
