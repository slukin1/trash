package com.sumsub.sns.internal.core.common;

import android.os.Parcelable;
import com.sumsub.sns.internal.core.domain.model.c;
import java.io.File;

public final /* synthetic */ class k1 {
    public static /* synthetic */ void a(k0 k0Var, c cVar, Parcelable parcelable, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                parcelable = null;
            }
            k0Var.a(cVar, parcelable);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInstructions");
    }

    public static /* synthetic */ void b(k0 k0Var, File file, int i11, String str, String str2, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 8) != 0) {
                str2 = null;
            }
            k0Var.a(file, i11, str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showImage");
    }
}
