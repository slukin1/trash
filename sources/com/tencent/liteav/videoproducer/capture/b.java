package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videoproducer.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class b {
    public static Size a(List<Size> list, k kVar, int i11, int i12) {
        double d11;
        k kVar2 = kVar;
        Size size = new Size(i11, i12);
        LiteavLog.i("CameraSupervisor", "preview wanted: " + size + " cameraRotation:" + kVar2);
        if (list == null) {
            LiteavLog.e("CameraSupervisor", "findBestMatchedPreviewSize getPreviewSizes null");
            return size;
        }
        if (kVar2 == k.ROTATION_90 || kVar2 == k.ROTATION_270) {
            size.swap();
        }
        double aspectRatio = size.aspectRatio();
        Size size2 = new Size(com.sumsub.sns.internal.ml.autocapture.b.f34944a, com.sumsub.sns.internal.ml.autocapture.b.f34944a);
        int i13 = size.width;
        int i14 = size2.width;
        if (i13 > i14 || size.height > size2.height) {
            int i15 = size.height;
            if (i13 > i15) {
                size2.height = (i14 * i15) / i13;
            } else {
                size2.width = (size2.height * i13) / i15;
            }
        } else {
            size2.set(size);
        }
        ArrayList<Size> arrayList = new ArrayList<>();
        StringBuilder sb2 = new StringBuilder();
        long j11 = Long.MAX_VALUE;
        for (Size next : list) {
            sb2.append(next);
            sb2.append(", ");
            long round = (next.width < size2.width || next.height < size2.height) ? Long.MAX_VALUE : Math.round(Math.abs(next.aspectRatio() - aspectRatio) * 10.0d);
            int i16 = (round > j11 ? 1 : (round == j11 ? 0 : -1));
            if (i16 < 0) {
                arrayList.clear();
                arrayList.add(next);
                j11 = round;
            } else if (i16 == 0) {
                arrayList.add(next);
            }
        }
        LiteavLog.i("CameraSupervisor", "support preview size list: ".concat(String.valueOf(sb2)));
        Collections.sort(arrayList, c.a());
        Size size3 = (Size) arrayList.get(0);
        int area = size.getArea();
        double d12 = Double.MAX_VALUE;
        for (Size size4 : arrayList) {
            LiteavLog.i("CameraSupervisor", "size in same buck ".concat(String.valueOf(size4)));
            if (aspectRatio > size4.aspectRatio()) {
                int i17 = size4.width;
                d11 = ((double) (i17 * i17)) / aspectRatio;
            } else {
                int i18 = size4.height;
                d11 = ((double) (i18 * i18)) * aspectRatio;
            }
            double d13 = (double) area;
            if (d11 / d13 >= 0.9d) {
                double d14 = d11 - d13;
                if (Math.abs(d14) < d12) {
                    d12 = Math.abs(d14);
                    size3 = size4;
                }
            }
        }
        LiteavLog.i("CameraSupervisor", "best match preview size ".concat(String.valueOf(size3)));
        return new Size(size3.width, size3.height);
    }

    public static a a(a[] aVarArr, int i11, boolean z11) {
        if (!(aVarArr == null || aVarArr.length == 0)) {
            int i12 = 0;
            for (a valueOf : aVarArr) {
                LiteavLog.i("CameraSupervisor", "supported fps range: ".concat(String.valueOf(valueOf)));
            }
            if (z11) {
                Arrays.sort(aVarArr, d.a());
                int length = aVarArr.length;
                while (i12 < length) {
                    a aVar = aVarArr[i12];
                    if (aVar.f22516a >= i11) {
                        return aVar;
                    }
                    i12++;
                }
            } else {
                Arrays.sort(aVarArr, e.a());
                int length2 = aVarArr.length;
                while (i12 < length2) {
                    a aVar2 = aVarArr[i12];
                    if (aVar2.f22516a <= i11 && i11 <= aVar2.f22517b) {
                        return aVar2;
                    }
                    i12++;
                }
            }
        }
        return null;
    }
}
