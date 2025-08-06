package com.iproov.sdk.p022package;

import android.graphics.RectF;
import com.iproov.sdk.cameray.Cbreak;
import com.iproov.sdk.p005class.Celse;
import com.iproov.sdk.p009do.Cbreak;
import com.iproov.sdk.p026return.Cstatic;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.package.new  reason: invalid class name and invalid package */
public interface Cnew {

    /* renamed from: com.iproov.sdk.package.new$case  reason: invalid class name */
    public static final class Ccase implements Cnew {

        /* renamed from: break  reason: not valid java name */
        private final RectF f1096break;

        /* renamed from: case  reason: not valid java name */
        private final int f1097case;

        /* renamed from: catch  reason: not valid java name */
        private final Long f1098catch;

        /* renamed from: class  reason: not valid java name */
        private final String f1099class;

        /* renamed from: const  reason: not valid java name */
        private final byte[] f1100const;

        /* renamed from: do  reason: not valid java name */
        private final String f1101do;

        /* renamed from: else  reason: not valid java name */
        private final boolean f1102else;

        /* renamed from: for  reason: not valid java name */
        private final Cbreak f1103for;

        /* renamed from: goto  reason: not valid java name */
        private final List<Cstatic> f1104goto;

        /* renamed from: if  reason: not valid java name */
        private final int f1105if;

        /* renamed from: new  reason: not valid java name */
        private final int f1106new;

        /* renamed from: this  reason: not valid java name */
        private final com.iproov.sdk.core.Cif f1107this;

        /* renamed from: try  reason: not valid java name */
        private final Celse f1108try;

        public Ccase(String str, int i11, Cbreak breakR, int i12, Celse elseR, int i13, boolean z11, List<Cstatic> list, com.iproov.sdk.core.Cif ifVar, RectF rectF, Long l11, String str2, byte[] bArr) {
            this.f1101do = str;
            this.f1105if = i11;
            this.f1103for = breakR;
            this.f1106new = i12;
            this.f1108try = elseR;
            this.f1097case = i13;
            this.f1102else = z11;
            this.f1104goto = list;
            this.f1107this = ifVar;
            this.f1096break = rectF;
            this.f1098catch = l11;
            this.f1099class = str2;
            this.f1100const = bArr;
        }

        /* renamed from: break  reason: not valid java name */
        public final Long m1241break() {
            return this.f1098catch;
        }

        /* renamed from: case  reason: not valid java name */
        public final com.iproov.sdk.core.Cif m1242case() {
            return this.f1107this;
        }

        /* renamed from: catch  reason: not valid java name */
        public final String m1243catch() {
            return this.f1101do;
        }

        /* renamed from: class  reason: not valid java name */
        public final int m1244class() {
            return this.f1105if;
        }

        /* renamed from: const  reason: not valid java name */
        public final boolean m1245const() {
            return this.f1102else;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cbreak m1246do() {
            return this.f1103for;
        }

        /* renamed from: else  reason: not valid java name */
        public final int m1247else() {
            return this.f1106new;
        }

        /* renamed from: for  reason: not valid java name */
        public final byte[] m1248for() {
            return this.f1100const;
        }

        /* renamed from: goto  reason: not valid java name */
        public final List<Cstatic> m1249goto() {
            return this.f1104goto;
        }

        /* renamed from: if  reason: not valid java name */
        public final RectF m1250if() {
            return this.f1096break;
        }

        /* renamed from: new  reason: not valid java name */
        public final Celse m1251new() {
            return this.f1108try;
        }

        /* renamed from: this  reason: not valid java name */
        public final String m1252this() {
            return this.f1099class;
        }

        /* renamed from: try  reason: not valid java name */
        public final int m1253try() {
            return this.f1097case;
        }
    }

    /* renamed from: com.iproov.sdk.package.new$do  reason: invalid class name */
    public static final class Cdo implements Cnew {

        /* renamed from: do  reason: not valid java name */
        private final String f1109do;

        public Cdo(String str) {
            this.f1109do = str;
        }

        /* renamed from: do  reason: not valid java name */
        public final String m1254do() {
            return this.f1109do;
        }
    }

    /* renamed from: com.iproov.sdk.package.new$for  reason: invalid class name */
    public static final class Cfor implements Cnew {

        /* renamed from: do  reason: not valid java name */
        private final long f1110do;

        /* renamed from: if  reason: not valid java name */
        private final int f1111if;

        public Cfor(long j11, int i11) {
            this.f1110do = j11;
            this.f1111if = i11;
        }

        /* renamed from: do  reason: not valid java name */
        public final int m1255do() {
            return this.f1111if;
        }

        /* renamed from: if  reason: not valid java name */
        public final long m1256if() {
            return this.f1110do;
        }
    }

    /* renamed from: com.iproov.sdk.package.new$if  reason: invalid class name */
    public static final class Cif implements Cnew {

        /* renamed from: do  reason: not valid java name */
        private final com.iproov.sdk.p035try.Cif f1112do;

        /* renamed from: if  reason: not valid java name */
        private final JSONObject f1113if;

        public Cif(com.iproov.sdk.p035try.Cif ifVar, JSONObject jSONObject) {
            this.f1112do = ifVar;
            this.f1113if = jSONObject;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p035try.Cif m1257do() {
            return this.f1112do;
        }

        /* renamed from: if  reason: not valid java name */
        public final JSONObject m1258if() {
            return this.f1113if;
        }
    }

    /* renamed from: com.iproov.sdk.package.new$new  reason: invalid class name */
    public static final class Cnew implements Cnew {

        /* renamed from: do  reason: not valid java name */
        private final com.iproov.sdk.p033throws.Cbreak f1114do;

        public Cnew(com.iproov.sdk.p033throws.Cbreak breakR) {
            this.f1114do = breakR;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p033throws.Cbreak m1259do() {
            return this.f1114do;
        }
    }

    /* renamed from: com.iproov.sdk.package.new$try  reason: invalid class name */
    public static final class Ctry implements Cnew {

        /* renamed from: do  reason: not valid java name */
        private final Cbreak.Cfor f1115do;

        public Ctry(Cbreak.Cfor forR) {
            this.f1115do = forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cbreak.Cfor m1260do() {
            return this.f1115do;
        }
    }
}
