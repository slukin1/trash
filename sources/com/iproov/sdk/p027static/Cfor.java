package com.iproov.sdk.p027static;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.iproov.sdk.IProovState;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.p016if.Cabstract;
import com.iproov.sdk.p016if.Ccontinue;
import com.iproov.sdk.p016if.Cinterface;
import com.iproov.sdk.p016if.Cprivate;
import com.iproov.sdk.p016if.Cprotected;
import com.iproov.sdk.p016if.Ctransient;
import com.iproov.sdk.p016if.Cwhile;
import com.iproov.sdk.p026return.Cconst;
import com.iproov.sdk.p026return.Cdefault;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.p026return.Cfinally;
import com.iproov.sdk.p026return.Cnative;
import com.iproov.sdk.p026return.Cpackage;
import com.iproov.sdk.p026return.Cpublic;
import com.iproov.sdk.p026return.Cswitch;
import com.iproov.sdk.p026return.Cthrows;
import d10.a;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.k1;

/* renamed from: com.iproov.sdk.static.for  reason: invalid class name and invalid package */
public final class Cfor {

    /* renamed from: break  reason: not valid java name */
    private final i f1911break = LazyKt__LazyJVMKt.a(new Cgoto(this));
    /* access modifiers changed from: private */

    /* renamed from: case  reason: not valid java name */
    public SurfaceTexture f1912case;

    /* renamed from: catch  reason: not valid java name */
    private final i f1913catch = LazyKt__LazyJVMKt.a(new Cbreak(this));

    /* renamed from: class  reason: not valid java name */
    private final i f1914class = LazyKt__LazyJVMKt.a(new Cdo(this));

    /* renamed from: const  reason: not valid java name */
    private final i f1915const = LazyKt__LazyJVMKt.a(new Ctry(this));
    /* access modifiers changed from: private */

    /* renamed from: do  reason: not valid java name */
    public final com.iproov.sdk.p004catch.Cdo f1916do;

    /* renamed from: else  reason: not valid java name */
    private final i f1917else = LazyKt__LazyJVMKt.a(new Cfor(this));
    /* access modifiers changed from: private */

    /* renamed from: final  reason: not valid java name */
    public final Cif f1918final = new Cif(this);
    /* access modifiers changed from: private */

    /* renamed from: for  reason: not valid java name */
    public final String f1919for;

    /* renamed from: goto  reason: not valid java name */
    private final i f1920goto = LazyKt__LazyJVMKt.a(Ccase.f1934do);
    /* access modifiers changed from: private */

    /* renamed from: if  reason: not valid java name */
    public final String f1921if;
    /* access modifiers changed from: private */

    /* renamed from: import  reason: not valid java name */
    public final com.iproov.sdk.p009do.Cbreak f1922import;

    /* renamed from: native  reason: not valid java name */
    private final i f1923native;

    /* renamed from: new  reason: not valid java name */
    private final Cextends f1924new;

    /* renamed from: public  reason: not valid java name */
    private final i f1925public;

    /* renamed from: return  reason: not valid java name */
    private final i f1926return;

    /* renamed from: static  reason: not valid java name */
    private final i f1927static;

    /* renamed from: super  reason: not valid java name */
    private final i f1928super = LazyKt__LazyJVMKt.a(new Celse(this));

    /* renamed from: this  reason: not valid java name */
    private final i f1929this = LazyKt__LazyJVMKt.a(Cnew.f1942do);

    /* renamed from: throw  reason: not valid java name */
    private final Cabstract f1930throw;
    /* access modifiers changed from: private */

    /* renamed from: try  reason: not valid java name */
    public final com.iproov.sdk.core.Cfor f1931try;

    /* renamed from: while  reason: not valid java name */
    private final Cprivate f1932while;

    /* renamed from: com.iproov.sdk.static.for$break  reason: invalid class name */
    public static final class Cbreak extends Lambda implements a<com.iproov.sdk.p030switch.Cnew> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cfor f1933do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cbreak(Cfor forR) {
            super(0);
            this.f1933do = forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p030switch.Cnew invoke() {
            return new com.iproov.sdk.p030switch.Cnew(this.f1933do.m1809for(), this.f1933do.m1807catch(), this.f1933do.f1912case);
        }
    }

    /* renamed from: com.iproov.sdk.static.for$case  reason: invalid class name */
    public static final class Ccase extends Lambda implements a<Cnative> {

        /* renamed from: do  reason: not valid java name */
        public static final Ccase f1934do = new Ccase();

        public Ccase() {
            super(0);
        }

        /* renamed from: do  reason: not valid java name */
        public final Cnative invoke() {
            return new Cnative(k1.a(IProovState.Connecting.INSTANCE));
        }
    }

    /* renamed from: com.iproov.sdk.static.for$catch  reason: invalid class name */
    public static final class Ccatch extends Lambda implements a<Cpackage> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cfor f1935do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ccatch(Cfor forR) {
            super(0);
            this.f1935do = forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cpackage invoke() {
            return new Cpackage(this.f1935do.m1807catch().m1478for(), this.f1935do.m1808else().m756this(), f.b(this.f1935do.m1808else().m739if()), f.b(this.f1935do.m1808else().m749public()), this.f1935do.m1808else().m738goto(), f.b(this.f1935do.m1808else().m741import()), this.f1935do.m1808else().m733else(), this.f1935do.m1808else().m737for(), this.f1935do.m1808else().m757throw(), this.f1935do.m1808else().m727catch(), this.f1935do.m1808else().m728class(), f.b(this.f1935do.m1808else().m762while()), f.b(this.f1935do.m1808else().m725break()), this.f1935do.m1808else().m745new(), f.a(this.f1935do.m1808else().m753super()), f.a(this.f1935do.m1808else().m726case()), f.a(this.f1935do.m1808else().m760try()), f.a(this.f1935do.m1808else().m729const()), f.a(this.f1935do.m1808else().m744native()), this.f1935do.m1808else().m735final(), f.b(this.f1935do.m1808else().b()), f.b(this.f1935do.m1808else().m758throws()));
        }
    }

    /* renamed from: com.iproov.sdk.static.for$class  reason: invalid class name */
    public static final class Cclass extends Lambda implements a<com.iproov.sdk.p034transient.Cdo> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cfor f1936do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cclass(Cfor forR) {
            super(0);
            this.f1936do = forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p034transient.Cdo invoke() {
            return new com.iproov.sdk.p034transient.Cdo(this.f1936do.m1809for(), this.f1936do.m1808else(), this.f1936do.f1919for, this.f1936do.m1791do(), this.f1936do.m1804try(), this.f1936do.m1806case(), this.f1936do.m1797goto(), this.f1936do.m1786class(), this.f1936do.m1799if(), this.f1936do.m1788const(), this.f1936do.m1811this(), (CoroutineDispatcher) null, 2048, (r) null);
        }
    }

    /* renamed from: com.iproov.sdk.static.for$do  reason: invalid class name */
    public static final class Cdo extends Lambda implements a<com.iproov.sdk.p026return.Cfor> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cfor f1937do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cfor forR) {
            super(0);
            this.f1937do = forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p026return.Cfor invoke() {
            return new com.iproov.sdk.p026return.Cfor(this.f1937do.m1809for(), this.f1937do.m1808else().m739if(), this.f1937do.m1808else().m749public(), f.a(this.f1937do.m1808else().m755synchronized()), this.f1937do.m1808else().m742instanceof(), this.f1937do.m1808else().m730continue(), this.f1937do.m1808else().m736finally(), this.f1937do.m1808else().m732do(), f.a(this.f1937do.m1808else().m756this()), this.f1937do.m1808else().e(), this.f1937do.m1807catch().m1477do(), this.f1937do.m1810new(), (CoroutineDispatcher) null, 4096, (r) null);
        }
    }

    /* renamed from: com.iproov.sdk.static.for$else  reason: invalid class name */
    public static final class Celse extends Lambda implements a<Cpublic> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cfor f1938do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Celse(Cfor forR) {
            super(0);
            this.f1938do = forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cpublic invoke() {
            return new Cpublic(this.f1938do.m1809for(), this.f1938do.f1918final, this.f1938do.m1807catch().m1478for(), f.b(this.f1938do.m1808else().m741import()), f.b(this.f1938do.m1808else().m739if()), f.a(this.f1938do.m1808else().m730continue()), this.f1938do.m1808else().m754switch(), (CoroutineDispatcher) null, 128, (r) null);
        }
    }

    /* renamed from: com.iproov.sdk.static.for$for  reason: invalid class name */
    public static final class Cfor extends Lambda implements a<Context> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cfor f1939do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfor(Cfor forR) {
            super(0);
            this.f1939do = forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Context invoke() {
            return this.f1939do.f1916do.getContext();
        }
    }

    /* renamed from: com.iproov.sdk.static.for$goto  reason: invalid class name */
    public static final class Cgoto extends Lambda implements a<Cconst> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cfor f1940do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cgoto(Cfor forR) {
            super(0);
            this.f1940do = forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cconst invoke() {
            return new Cconst(this.f1940do.f1919for, f.b(this.f1940do.m1808else().getCurrentState()), this.f1940do.m1801super(), (CoroutineDispatcher) null, 8, (r) null);
        }
    }

    /* renamed from: com.iproov.sdk.static.for$if  reason: invalid class name */
    public static final class Cif extends Lambda implements a<com.iproov.sdk.p026return.Ctry> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cfor f1941do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cfor forR) {
            super(0);
            this.f1941do = forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p026return.Ctry invoke() {
            return new com.iproov.sdk.p026return.Ctry(this.f1941do.f1919for, this.f1941do.m1807catch(), this.f1941do.m1810new(), f.b(this.f1941do.m1808else().h()), this.f1941do.m1806case(), this.f1941do.f1931try);
        }
    }

    /* renamed from: com.iproov.sdk.static.for$new  reason: invalid class name */
    public static final class Cnew extends Lambda implements a<com.iproov.sdk.p025public.Cif> {

        /* renamed from: do  reason: not valid java name */
        public static final Cnew f1942do = new Cnew();

        public Cnew() {
            super(0);
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p025public.Cif invoke() {
            return com.iproov.sdk.p025public.Cdo.m1286do().m1288if();
        }
    }

    /* renamed from: com.iproov.sdk.static.for$this  reason: invalid class name */
    public static final class Cthis extends Lambda implements a<Cfinally> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cfor f1943do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cthis(Cfor forR) {
            super(0);
            this.f1943do = forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cfinally invoke() {
            return new Cfinally(this.f1943do.m1809for(), this.f1943do.f1921if, this.f1943do.f1919for, this.f1943do.m1807catch().m1479if(), f.a(this.f1943do.m1808else().m759transient()), this.f1943do.m1808else().m740implements(), this.f1943do.m1808else().m750return(), this.f1943do.f1922import, (CoroutineDispatcher) null, 256, (r) null);
        }
    }

    /* renamed from: com.iproov.sdk.static.for$try  reason: invalid class name */
    public static final class Ctry extends Lambda implements a<com.iproov.sdk.p026return.Celse> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cfor f1944do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ctry(Cfor forR) {
            super(0);
            this.f1944do = forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p026return.Celse invoke() {
            return new com.iproov.sdk.p026return.Celse(this.f1944do.m1809for(), f.b(this.f1944do.m1808else().m739if()), f.b(this.f1944do.m1808else().m749public()), f.b(this.f1944do.m1808else().m724abstract()), this.f1944do.m1808else().m748protected(), f.a(this.f1944do.m1808else().m731default()), this.f1944do.m1808else().f(), this.f1944do.m1808else().m746package(), this.f1944do.m1808else().m761volatile(), (CoroutineDispatcher) null, 512, (r) null);
        }
    }

    public Cfor(com.iproov.sdk.p004catch.Cdo doVar, String str, String str2, Cextends extendsR, com.iproov.sdk.core.Cfor forR) {
        this.f1916do = doVar;
        this.f1921if = str;
        this.f1919for = str2;
        this.f1924new = extendsR;
        this.f1931try = forR;
        Cdefault defaultR = new Cdefault(m1809for(), m1808else().c(), m1808else().h(), new Cthrows(SetsKt__SetsKt.f(1, 10, 4, 9, 11)), m1808else().g(), (CoroutineDispatcher) null, 32, (r) null);
        this.f1930throw = defaultR;
        this.f1932while = new Cswitch(defaultR, f.a(m1808else().c()), m1808else().g(), (CoroutineDispatcher) null, 8, (r) null);
        this.f1922import = new com.iproov.sdk.p009do.Cbreak(f.b(m1808else().m736finally()), f.b(m1808else().m757throw()), f.b(m1808else().m761volatile()), f.b(m1808else().m751static()));
        this.f1923native = LazyKt__LazyJVMKt.a(new Cthis(this));
        this.f1925public = LazyKt__LazyJVMKt.a(new Cif(this));
        this.f1926return = LazyKt__LazyJVMKt.a(new Cclass(this));
        this.f1927static = LazyKt__LazyJVMKt.a(new Ccatch(this));
        new com.iproov.sdk.p026return.Ccase(m1809for(), f.b(m1808else().m739if()), f.b(m1808else().m749public()), f.b(m1808else().m748protected()), f.b(m1808else().m732do()), f.b(m1808else().m736finally()), f.b(m1808else().m757throw()), f.b(m1808else().m761volatile()), f.b(m1808else().m751static()), f.b(m1808else().m727catch()), f.b(m1808else().m743interface()), f.a(m1808else().m734extends()), f.a(m1808else().m752strictfp()), m1808else().b(), (CoroutineDispatcher) null, 16384, (r) null);
        com.iproov.sdk.p009do.Cnew.f489do.m576do(m1793final());
    }

    /* access modifiers changed from: private */
    /* renamed from: super  reason: not valid java name */
    public final Ctransient m1801super() {
        return (Ctransient) this.f1926return.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: class  reason: not valid java name */
    public final Ccontinue m1786class() {
        return (Ccontinue) this.f1923native.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: const  reason: not valid java name */
    public final Cinterface m1788const() {
        return (Cinterface) this.f1913catch.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final com.iproov.sdk.p016if.Cdo m1791do() {
        return (com.iproov.sdk.p016if.Cdo) this.f1914class.getValue();
    }

    /* renamed from: final  reason: not valid java name */
    private final Cprotected m1793final() {
        return (Cprotected) this.f1927static.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: goto  reason: not valid java name */
    public final com.iproov.sdk.p016if.Cfinally m1797goto() {
        return (com.iproov.sdk.p016if.Cfinally) this.f1928super.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public final com.iproov.sdk.p035try.Cif m1799if() {
        return (com.iproov.sdk.p035try.Cif) this.f1925public.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: try  reason: not valid java name */
    public final com.iproov.sdk.p016if.Ccase m1804try() {
        return (com.iproov.sdk.p016if.Ccase) this.f1915const.getValue();
    }

    /* renamed from: break  reason: not valid java name */
    public Cconst m1805break() {
        return (Cconst) this.f1911break.getValue();
    }

    /* renamed from: case  reason: not valid java name */
    public final Cwhile m1806case() throws UnexpectedErrorException {
        return this.f1916do.m244do();
    }

    /* renamed from: catch  reason: not valid java name */
    public final Cextends m1807catch() {
        return this.f1924new;
    }

    /* renamed from: else  reason: not valid java name */
    public final com.iproov.sdk.p016if.Cdefault m1808else() {
        return (com.iproov.sdk.p016if.Cdefault) this.f1920goto.getValue();
    }

    /* renamed from: for  reason: not valid java name */
    public final Context m1809for() {
        return (Context) this.f1917else.getValue();
    }

    /* renamed from: new  reason: not valid java name */
    public final com.iproov.sdk.p025public.Cif m1810new() {
        return (com.iproov.sdk.p025public.Cif) this.f1929this.getValue();
    }

    /* renamed from: this  reason: not valid java name */
    public final Cprivate m1811this() {
        return this.f1932while;
    }
}
