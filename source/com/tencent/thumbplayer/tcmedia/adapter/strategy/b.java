package com.tencent.thumbplayer.tcmedia.adapter.strategy;

import com.tencent.thumbplayer.tcmedia.adapter.strategy.a.a;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPStrategyUtils;

public abstract class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public a f48970a;

    public b(a aVar) {
        this.f48970a = aVar;
    }

    public int a(com.tencent.thumbplayer.tcmedia.adapter.b bVar) {
        int a11 = this.f48970a.a();
        if (a11 != 0) {
            if (a11 == 1) {
                return b(bVar) ? 2 : 0;
            }
            if (a11 != 2) {
                if (a11 == 3) {
                    return c(bVar) ? 1 : 0;
                }
                if (a11 != 4) {
                    return 0;
                }
                if (c(bVar)) {
                    return 1;
                }
                return TPStrategyUtils.isThumbPlayerEnable() ? 2 : 0;
            } else if (b(bVar)) {
                return 2;
            } else {
                return TPStrategyUtils.isSystemPlayerEnable() ? 1 : 0;
            }
        } else if (b(bVar)) {
            return 2;
        } else {
            return TPStrategyUtils.isSystemPlayerEnable() ? 1 : 0;
        }
    }

    public int a(com.tencent.thumbplayer.tcmedia.adapter.b bVar, com.tencent.thumbplayer.tcmedia.adapter.strategy.a.b bVar2) {
        int a11 = this.f48970a.a();
        if (bVar2 != null && bVar2.a() == 0) {
            return a(bVar);
        }
        if (!a(bVar2)) {
            return 0;
        }
        return a11 != 0 ? a11 != 2 ? (a11 == 4 && bVar2 != null && bVar2.a() == 1 && b(bVar)) ? 2 : 0 : (bVar2 == null || bVar2.a() != 2 || !c(bVar)) ? 0 : 1 : (bVar2 == null || bVar2.a() != 1) ? (bVar2 == null || bVar2.a() != 2 || !c(bVar)) ? 0 : 1 : b(bVar) ? 2 : 0;
    }

    public boolean a(com.tencent.thumbplayer.tcmedia.adapter.strategy.a.b bVar) {
        return false;
    }

    public int[] a() {
        int b11 = this.f48970a.b();
        if (b11 != 0) {
            if (b11 == 1) {
                return new int[]{102};
            } else if (b11 != 2) {
                if (b11 == 3) {
                    return new int[]{101};
                } else if (b11 != 4) {
                    return null;
                } else {
                    return new int[]{101, 102};
                }
            }
        }
        return new int[]{102, 101};
    }

    public boolean b(com.tencent.thumbplayer.tcmedia.adapter.b bVar) {
        return TPStrategyUtils.isTVPlatform() ? TPStrategyUtils.isThumbPlayerEnable() : TPStrategyUtils.isThumbPlayerEnable() && TPStrategyUtils.enablePlayByThumbPlayer(bVar);
    }

    public boolean c(com.tencent.thumbplayer.tcmedia.adapter.b bVar) {
        if (TPStrategyUtils.isTVPlatform()) {
            return true;
        }
        return TPStrategyUtils.isSystemPlayerEnable() && TPStrategyUtils.enablePlayBySystemPlayer(bVar);
    }
}
