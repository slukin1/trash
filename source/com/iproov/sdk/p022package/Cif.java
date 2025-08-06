package com.iproov.sdk.p022package;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.NetworkException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.core.exception.UnsupportedDeviceException;
import com.iproov.sdk.p022package.Cdo;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONException;

/* renamed from: com.iproov.sdk.package.if  reason: invalid class name and invalid package */
public abstract class Cif {

    /* renamed from: do  reason: not valid java name */
    public static final Cdo f1093do = new Cdo((r) null);

    /* renamed from: com.iproov.sdk.package.if$for  reason: invalid class name */
    public static final class Cfor extends Cif {

        /* renamed from: if  reason: not valid java name */
        private final com.iproov.sdk.p003case.Cif f1094if;

        public Cfor(com.iproov.sdk.p003case.Cif ifVar) {
            super((r) null);
            this.f1094if = ifVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p003case.Cif m1239do() {
            return this.f1094if;
        }
    }

    /* renamed from: com.iproov.sdk.package.if$if  reason: invalid class name */
    public static final class Cif extends Cif {

        /* renamed from: if  reason: not valid java name */
        private final IProovException f1095if;

        public Cif(IProovException iProovException) {
            super((r) null);
            this.f1095if = iProovException;
        }

        /* renamed from: do  reason: not valid java name */
        public final IProovException m1240do() {
            return this.f1095if;
        }
    }

    private Cif() {
    }

    public /* synthetic */ Cif(r rVar) {
        this();
    }

    /* renamed from: com.iproov.sdk.package.if$do  reason: invalid class name */
    public static final class Cdo {
        private Cdo() {
        }

        public /* synthetic */ Cdo(r rVar) {
            this();
        }

        /* renamed from: do  reason: not valid java name */
        public final Cif m1238do(Context context, Cdo doVar) {
            if (!(doVar instanceof Cdo.Cif)) {
                return new Cif(new NetworkException(context, "No data/ack received"));
            }
            Cdo.Cif ifVar = (Cdo.Cif) doVar;
            if (!(ifVar.m1229do().optString("error").length() == 0)) {
                return new Cif(m1237do(context, ifVar.m1229do().optString("error", "no error given"), ifVar.m1229do().optString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION, "no description given")));
            }
            try {
                return new Cfor(new com.iproov.sdk.p003case.Cif(context, ((Cdo.Cif) doVar).m1229do()));
            } catch (JSONException e11) {
                return new Cif(new UnexpectedErrorException(context, (Exception) e11));
            }
        }

        /* renamed from: do  reason: not valid java name */
        private final IProovException m1237do(Context context, String str, String str2) {
            if (x.b("invalid_device", str)) {
                return new UnsupportedDeviceException(context, str2);
            }
            return new NetworkException(context, str2);
        }
    }
}
