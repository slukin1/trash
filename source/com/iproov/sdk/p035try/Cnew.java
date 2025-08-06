package com.iproov.sdk.p035try;

import android.util.Size;
import com.iproov.sdk.cameray.Cconst;
import com.iproov.sdk.p021new.Ctry;
import com.sumsub.sns.internal.ml.autocapture.b;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import zv.a;

/* renamed from: com.iproov.sdk.try.new  reason: invalid class name and invalid package */
public class Cnew implements Ctry {
    /* renamed from: if  reason: not valid java name */
    private static int m2145if(Size size) {
        return size.getWidth() * size.getHeight();
    }

    /* renamed from: do  reason: not valid java name */
    public Size m2146do(Cconst constR, List<Size> list) {
        return m2143do(m2144do(list, b.f34944a, TXVodDownloadDataSource.QUALITY_480P, 0.7d)).get(0);
    }

    /* renamed from: do  reason: not valid java name */
    private static List<Size> m2143do(List<Size> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, a.f63116b);
        return arrayList;
    }

    /* renamed from: do  reason: not valid java name */
    private static double m2141do(Size size) {
        return ((double) size.getHeight()) / ((double) size.getWidth());
    }

    /* renamed from: do  reason: not valid java name */
    private static List<Size> m2144do(List<Size> list, int i11, int i12, double d11) {
        ArrayList arrayList = new ArrayList();
        for (Size next : list) {
            if (next.getWidth() >= i11 && next.getHeight() >= i12 && m2141do(next) >= d11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
