package com.tencent.thumbplayer.tcmedia.common;

import com.tencent.thumbplayer.tcmedia.adapter.a.b;
import com.tencent.thumbplayer.tcmedia.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;

public class a implements com.tencent.thumbplayer.tcmedia.tplayer.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    private b f49109a;

    public a(b bVar) {
        this.f49109a = bVar;
    }

    public TPDynamicStatisticParams a(boolean z11) {
        b bVar = this.f49109a;
        if (bVar == null) {
            TPLogUtil.e("TPPlayerInfoGetterImpl", "playerBase is null, return default dynamic statistic params");
            return new TPDynamicStatisticParams();
        }
        TPDynamicStatisticParams c11 = bVar.c(z11);
        if (c11 != null) {
            return c11;
        }
        TPLogUtil.e("TPPlayerInfoGetterImpl", "cannot get params from core, return default dynamic statistic params");
        return new TPDynamicStatisticParams();
    }

    public TPGeneralPlayFlowParams a() {
        b bVar = this.f49109a;
        if (bVar == null) {
            TPLogUtil.e("TPPlayerInfoGetterImpl", "playerBase is null, return default general play flow params");
            return new TPGeneralPlayFlowParams();
        }
        TPGeneralPlayFlowParams v11 = bVar.v();
        if (v11 != null) {
            return v11;
        }
        TPLogUtil.e("TPPlayerInfoGetterImpl", "cannot get params from core, return default general play flow params");
        return new TPGeneralPlayFlowParams();
    }
}
