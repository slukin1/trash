package com.iproov.sdk.p026return;

import com.iproov.sdk.core.Cfor;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p003case.Cdo;
import com.iproov.sdk.p005class.Cgoto;
import com.iproov.sdk.p016if.Cwhile;
import com.iproov.sdk.p017implements.Ccase;
import com.iproov.sdk.p017implements.Cimport;
import com.iproov.sdk.p035try.Cif;
import java.nio.charset.Charset;
import java.util.Objects;
import kotlin.jvm.internal.x;
import kotlin.text.b;
import kotlinx.coroutines.flow.j1;

/* renamed from: com.iproov.sdk.return.try  reason: invalid class name and invalid package */
public final class Ctry implements Cif {

    /* renamed from: case  reason: not valid java name */
    private final Cfor f1880case;

    /* renamed from: do  reason: not valid java name */
    private final String f1881do;

    /* renamed from: else  reason: not valid java name */
    private final byte[] f1882else;

    /* renamed from: for  reason: not valid java name */
    private final com.iproov.sdk.p025public.Cif f1883for;

    /* renamed from: goto  reason: not valid java name */
    private final byte[] f1884goto;

    /* renamed from: if  reason: not valid java name */
    private final Cextends f1885if;

    /* renamed from: new  reason: not valid java name */
    private final j1<Cthrows> f1886new;

    /* renamed from: try  reason: not valid java name */
    private final Cwhile f1887try;

    public Ctry(String str, Cextends extendsR, com.iproov.sdk.p025public.Cif ifVar, j1<Cthrows> j1Var, Cwhile whileR, Cfor forR) {
        this.f1881do = str;
        this.f1885if = extendsR;
        this.f1883for = ifVar;
        this.f1886new = j1Var;
        this.f1887try = whileR;
        this.f1880case = forR;
        this.f1882else = whileR.getPublicKey().getDer();
        String str2 = m1759goto();
        Charset charset = b.f56908b;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        this.f1884goto = whileR.sign(str2.getBytes(charset));
    }

    /* renamed from: case  reason: not valid java name */
    public Cdo[] m1755case() {
        if (this.f1886new.getValue().m1754do().contains(1) || this.f1886new.getValue().m1754do().contains(10)) {
            return new Cdo[]{Cdo.GENUINE_PRESENCE_ASSURANCE, Cdo.LIVENESS};
        }
        return new Cdo[]{Cdo.GENUINE_PRESENCE_ASSURANCE};
    }

    /* renamed from: do  reason: not valid java name */
    public Cextends m1756do() {
        return this.f1885if;
    }

    /* renamed from: else  reason: not valid java name */
    public int m1757else() {
        return this.f1887try.m848else().f446do;
    }

    /* renamed from: for  reason: not valid java name */
    public String[] m1758for() {
        return Cgoto.m282do(this.f1883for);
    }

    public String getPublicKey() {
        byte[] bArr;
        if (this.f1887try.m848else() == com.iproov.sdk.crypto.Cdo.UNSUPPORTED || (bArr = this.f1882else) == null) {
            return null;
        }
        try {
            return Cimport.m1016do(bArr);
        } catch (com.iproov.sdk.p031this.Cdo e11) {
            e11.printStackTrace();
            IPLog.w(Ccase.m977do(this), x.i("Failed to add device assurance info:", e11.getMessage()));
            return null;
        }
    }

    /* renamed from: goto  reason: not valid java name */
    public String m1759goto() {
        return this.f1881do;
    }

    /* renamed from: if  reason: not valid java name */
    public Cfor m1760if() {
        return this.f1880case;
    }

    /* renamed from: new  reason: not valid java name */
    public String m1761new() {
        if (this.f1887try.m848else() == com.iproov.sdk.crypto.Cdo.UNSUPPORTED || this.f1882else == null) {
            return null;
        }
        try {
            return Cimport.m1016do(this.f1884goto);
        } catch (com.iproov.sdk.p031this.Cdo e11) {
            e11.printStackTrace();
            IPLog.w(Ccase.m977do(this), x.i("Failed to add device assurance info:", e11.getMessage()));
            return null;
        }
    }

    /* renamed from: try  reason: not valid java name */
    public int[] m1762try() {
        return new int[]{this.f1886new.getValue().m1754do().contains(1), this.f1886new.getValue().m1754do().contains(10), this.f1886new.getValue().m1754do().contains(4), this.f1886new.getValue().m1754do().contains(9), this.f1886new.getValue().m1754do().contains(11)};
    }
}
