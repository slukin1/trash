package com.google.android.recaptcha.internal;

import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;

public final class zzej implements zzen {
    private static final boolean zzb(int i11) {
        try {
            new Socket("localhost", i11).close();
            return true;
        } catch (ConnectException unused) {
            return false;
        }
    }

    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzel.zza(this, objArr);
    }

    public final Object zza(Object... objArr) {
        int length = objArr.length;
        ArrayList<Number> arrayList = new ArrayList<>(length);
        int i11 = 0;
        while (i11 < length) {
            Integer num = objArr[i11];
            if (true != (num instanceof Integer)) {
                num = null;
            }
            Integer num2 = num;
            if (num2 != null) {
                arrayList.add(Integer.valueOf(num2.intValue()));
                i11++;
            } else {
                throw new zzae(4, 5, (Throwable) null);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Number intValue : arrayList) {
            int intValue2 = intValue.intValue();
            if (zzb(intValue2)) {
                arrayList2.add(Integer.valueOf(intValue2));
            }
        }
        return arrayList2;
    }
}
