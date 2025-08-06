package com.tencent.thumbplayer.tcmedia.adapter.strategy.a;

import com.tencent.thumbplayer.tcmedia.adapter.c;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPStrategyUtils;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalParam;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f48962a = 2;

    /* renamed from: b  reason: collision with root package name */
    public int f48963b = 2;

    /* renamed from: c  reason: collision with root package name */
    public int[] f48964c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48965d = false;

    public a(c cVar) {
        if (TPStrategyUtils.isTVPlatform()) {
            this.f48963b = 4;
            this.f48962a = 2;
        }
        if (cVar != null) {
            TPOptionalParam b11 = cVar.b(210);
            if (b11 == null || b11.getParamType() != 4) {
                TPOptionalParam b12 = cVar.b(202);
                if (b12 != null && b12.getParamType() == 2 && a(b12.getParamLong().value)) {
                    this.f48963b = (int) b12.getParamLong().value;
                }
                TPOptionalParam b13 = cVar.b(203);
                if (b13 != null && b13.getParamType() == 2 && b(b13.getParamLong().value)) {
                    this.f48962a = (int) b13.getParamLong().value;
                }
                a(this.f48963b, this.f48962a);
                return;
            }
            this.f48964c = b11.getParamQueueInt().queueValue;
            this.f48965d = true;
        }
    }

    private void a(int i11, int i12) {
        if (i11 == 3 && i12 == 3) {
            throw new IllegalArgumentException("can not soft with systemplayer");
        }
    }

    private boolean a(long j11) {
        return j11 > 0 && j11 < 5;
    }

    private boolean b(long j11) {
        return j11 > 0 && j11 < 5;
    }

    public int a() {
        return this.f48963b;
    }

    public int b() {
        return this.f48962a;
    }

    public int[] c() {
        return this.f48964c;
    }

    public boolean d() {
        return this.f48965d;
    }
}
