package com.iproov.sdk.p030switch;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.impl.ui.FullLandscapeActivity;
import com.iproov.sdk.impl.ui.FullPortraitActivity;
import com.iproov.sdk.impl.ui.FullReverseLandscapeActivity;
import com.iproov.sdk.impl.ui.FullReversePortraitActivity;
import com.iproov.sdk.p016if.Cinterface;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.utils.BaseCoroutineScope;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: com.iproov.sdk.switch.new  reason: invalid class name and invalid package */
public final class Cnew extends BaseCoroutineScope implements Cinterface {

    /* renamed from: do  reason: not valid java name */
    private final Context f2014do;

    /* renamed from: for  reason: not valid java name */
    private final SurfaceTexture f2015for;

    /* renamed from: if  reason: not valid java name */
    private final Cextends f2016if;

    /* renamed from: com.iproov.sdk.switch.new$do  reason: invalid class name */
    public /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f2017do;

        static {
            int[] iArr = new int[Orientation.values().length];
            iArr[Orientation.PORTRAIT.ordinal()] = 1;
            iArr[Orientation.LANDSCAPE.ordinal()] = 2;
            iArr[Orientation.REVERSE_PORTRAIT.ordinal()] = 3;
            iArr[Orientation.REVERSE_LANDSCAPE.ordinal()] = 4;
            f2017do = iArr;
        }
    }

    public Cnew(Context context, Cextends extendsR, SurfaceTexture surfaceTexture) {
        super((CoroutineDispatcher) null, 1, (r) null);
        this.f2014do = context;
        this.f2016if = extendsR;
        this.f2015for = surfaceTexture;
    }

    /* renamed from: do  reason: not valid java name */
    public void m1897do(com.iproov.sdk.p003case.Cdo doVar) {
        Class cls;
        if (doVar != com.iproov.sdk.p003case.Cdo.LIVENESS || this.f2015for == null) {
            int i11 = Cdo.f2017do[this.f2016if.m1478for().m1487break().ordinal()];
            if (i11 == 1) {
                cls = FullPortraitActivity.class;
            } else if (i11 == 2) {
                cls = FullLandscapeActivity.class;
            } else if (i11 == 3) {
                cls = FullReversePortraitActivity.class;
            } else if (i11 == 4) {
                cls = FullReverseLandscapeActivity.class;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Intent intent = new Intent(this.f2014do, cls);
            intent.addFlags(268435456);
            this.f2014do.startActivity(intent);
            return;
        }
        throw new NotImplementedError((String) null, 1, (r) null);
    }
}
