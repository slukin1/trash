package com.tencent.thumbplayer.tcmedia.adapter.strategy;

import com.tencent.thumbplayer.tcmedia.adapter.b;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.a.a;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;

public class d extends b {

    /* renamed from: b  reason: collision with root package name */
    private int f48971b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int[] f48972c;

    public d(a aVar) {
        super(aVar);
        int[] c11 = aVar.c();
        this.f48972c = c11;
        if (c11 == null || c11.length == 0) {
            this.f48972c = new int[1];
        }
    }

    public int a(b bVar) {
        int[] iArr = this.f48972c;
        int length = iArr.length;
        int i11 = this.f48971b;
        int i12 = 0;
        int i13 = length > i11 ? iArr[i11] : 0;
        if (!(i13 == 2 || i13 == 3) || b(bVar)) {
            i12 = i13;
        }
        TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForOpen, playerType:".concat(String.valueOf(i12)));
        return i12;
    }

    public int a(b bVar, com.tencent.thumbplayer.tcmedia.adapter.strategy.a.b bVar2) {
        int i11;
        if (bVar2 != null && bVar2.a() == 0) {
            return a(bVar);
        }
        int[] iArr = this.f48972c;
        int length = iArr.length - 1;
        int i12 = this.f48971b;
        int i13 = 0;
        if (length > i12) {
            int i14 = i12 + 1;
            this.f48971b = i14;
            i11 = iArr[i14];
        } else {
            i11 = 0;
        }
        if (!(i11 == 2 || i11 == 3) || b(bVar)) {
            i13 = i11;
        }
        TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForRetry, playerType:".concat(String.valueOf(i13)));
        return i13;
    }

    public int[] a() {
        StringBuilder sb2;
        int i11;
        int[] iArr = {-1};
        int i12 = this.f48971b;
        int[] iArr2 = this.f48972c;
        if (i12 >= iArr2.length) {
            sb2 = new StringBuilder("strategyForDec error, decType:");
            i11 = iArr[0];
        } else {
            if (iArr2[i12] == 1 || iArr2[i12] == 2) {
                iArr[0] = 102;
            } else if (iArr2[i12] == 3) {
                iArr[0] = 101;
            }
            sb2 = new StringBuilder("strategyForDec, decType:");
            i11 = iArr[0];
        }
        sb2.append(i11);
        TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", sb2.toString());
        return iArr;
    }
}
