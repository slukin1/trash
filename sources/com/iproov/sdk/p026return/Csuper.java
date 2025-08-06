package com.iproov.sdk.p026return;

import android.content.Context;
import com.iproov.sdk.crypto.Cdo;
import com.iproov.sdk.crypto.Cif;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p016if.Cthrow;
import com.iproov.sdk.p016if.Cwhile;
import com.iproov.sdk.p017implements.Ccase;
import com.iproov.sdk.utils.BaseCoroutineScope;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.super  reason: invalid class name and invalid package */
public final class Csuper extends BaseCoroutineScope implements Cwhile, Cthrow {

    /* renamed from: do  reason: not valid java name */
    private final Context f1740do;

    /* renamed from: for  reason: not valid java name */
    private final Cdo f1741for;

    /* renamed from: if  reason: not valid java name */
    private final Cif f1742if;

    /* renamed from: new  reason: not valid java name */
    private final com.iproov.sdk.p031this.Cif f1743new;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Csuper(Context context, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(context, (i11 & 2) != 0 ? v0.a() : coroutineDispatcher);
    }

    /* renamed from: class  reason: not valid java name */
    public Context m1695class() {
        return this.f1740do;
    }

    /* renamed from: else  reason: not valid java name */
    public Cdo m1696else() {
        return this.f1741for;
    }

    public com.iproov.sdk.p031this.Cif getPublicKey() {
        return this.f1743new;
    }

    public byte[] sign(byte[] bArr) {
        return this.f1742if.m520do(bArr);
    }

    public Csuper(Context context, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f1740do = context;
        try {
            Cif ifVar = Cif.m511do(m1695class());
            this.f1742if = ifVar;
            Cdo doVar = Cif.m510do(ifVar);
            this.f1741for = doVar == null ? Cdo.UNSUPPORTED : doVar;
            this.f1743new = ifVar.m519case();
        } catch (com.iproov.sdk.p031this.Cdo e11) {
            e11.printStackTrace();
            IPLog.w(Ccase.m977do(this), x.i("Key Store Manager unavailable: ", e11.getLocalizedMessage()));
            throw e11;
        }
    }
}
