package com.iproov.sdk.p026return;

import android.content.Context;
import com.iproov.sdk.p016if.Cthrow;
import com.iproov.sdk.p016if.Cwhile;
import com.iproov.sdk.p031this.Cif;
import com.iproov.sdk.utils.BaseCoroutineScope;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.class  reason: invalid class name and invalid package */
public final class Cclass extends BaseCoroutineScope implements Cwhile, Cthrow {

    /* renamed from: do  reason: not valid java name */
    private final com.iproov.sdk.crypto.Cdo f1359do;

    /* renamed from: if  reason: not valid java name */
    private final Cif f1360if;

    /* renamed from: com.iproov.sdk.return.class$do  reason: invalid class name */
    public static final class Cdo implements Cif {
        public byte[] getDer() {
            return new byte[0];
        }

        public String getPem() {
            return "";
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cclass(Context context, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(context, (i11 & 2) != 0 ? v0.a() : coroutineDispatcher);
    }

    /* renamed from: else  reason: not valid java name */
    public com.iproov.sdk.crypto.Cdo m1419else() {
        return this.f1359do;
    }

    public Cif getPublicKey() {
        return this.f1360if;
    }

    public byte[] sign(byte[] bArr) {
        return new byte[0];
    }

    public Cclass(Context context, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f1359do = com.iproov.sdk.crypto.Cdo.UNSUPPORTED;
        this.f1360if = new Cdo();
    }
}
