package com.iproov.sdk.p026return;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.iproov.sdk.cameray.Orientation;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.return.extends  reason: invalid class name and invalid package */
public final class Cextends {

    /* renamed from: do  reason: not valid java name */
    private final Cclass f1465do;

    /* renamed from: for  reason: not valid java name */
    private final Cif f1466for;

    /* renamed from: if  reason: not valid java name */
    private final Ccatch f1467if;

    /* renamed from: com.iproov.sdk.return.extends$break  reason: invalid class name */
    public enum Cbreak {
        BLUR,
        CLEAR
    }

    /* renamed from: com.iproov.sdk.return.extends$case  reason: invalid class name */
    public static abstract class Ccase {
        private Ccase() {
        }

        public /* synthetic */ Ccase(r rVar) {
            this();
        }

        /* renamed from: com.iproov.sdk.return.extends$case$if  reason: invalid class name */
        public static final class Cif extends Ccase {

            /* renamed from: do  reason: not valid java name */
            private final Cbreak f1474do;

            public Cif() {
                this((Cbreak) null, 1, (r) null);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Cif(Cbreak breakR, int i11, r rVar) {
                this((i11 & 1) != 0 ? Cbreak.CLEAR : breakR);
            }

            /* renamed from: do  reason: not valid java name */
            public final Cbreak m1484do() {
                return this.f1474do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cif) && this.f1474do == ((Cif) obj).f1474do;
            }

            public int hashCode() {
                return this.f1474do.hashCode();
            }

            public String toString() {
                return "NaturalFilter(style=" + this.f1474do + ')';
            }

            public Cif(Cbreak breakR) {
                super((r) null);
                this.f1474do = breakR;
            }
        }

        /* renamed from: com.iproov.sdk.return.extends$case$do  reason: invalid class name */
        public static final class Cdo extends Ccase {

            /* renamed from: do  reason: not valid java name */
            private final Cthis f1471do;

            /* renamed from: for  reason: not valid java name */
            private final int f1472for;

            /* renamed from: if  reason: not valid java name */
            private final int f1473if;

            public Cdo() {
                this((Cthis) null, 0, 0, 7, (r) null);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Cdo(Cthis thisR, int i11, int i12, int i13, r rVar) {
                this((i13 & 1) != 0 ? Cthis.SHADED : thisR, (i13 & 2) != 0 ? Color.parseColor("#404040") : i11, (i13 & 4) != 0 ? Color.parseColor("#FAFAFA") : i12);
            }

            /* renamed from: do  reason: not valid java name */
            public final int m1481do() {
                return this.f1472for;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Cdo)) {
                    return false;
                }
                Cdo doVar = (Cdo) obj;
                return this.f1471do == doVar.f1471do && this.f1473if == doVar.f1473if && this.f1472for == doVar.f1472for;
            }

            /* renamed from: for  reason: not valid java name */
            public final Cthis m1482for() {
                return this.f1471do;
            }

            public int hashCode() {
                return (((this.f1471do.hashCode() * 31) + this.f1473if) * 31) + this.f1472for;
            }

            /* renamed from: if  reason: not valid java name */
            public final int m1483if() {
                return this.f1473if;
            }

            public String toString() {
                return "LineDrawingFilter(style=" + this.f1471do + ", foregroundColor=" + this.f1473if + ", backgroundColor=" + this.f1472for + ')';
            }

            public Cdo(Cthis thisR, int i11, int i12) {
                super((r) null);
                this.f1471do = thisR;
                this.f1473if = i11;
                this.f1472for = i12;
            }
        }
    }

    /* renamed from: com.iproov.sdk.return.extends$catch  reason: invalid class name */
    public static final class Ccatch {

        /* renamed from: do  reason: not valid java name */
        private final List<Cfor> f1475do;

        /* renamed from: if  reason: not valid java name */
        private final int f1476if;

        public Ccatch(List<? extends Cfor> list, int i11) {
            this.f1475do = list;
            this.f1476if = i11;
        }

        /* renamed from: do  reason: not valid java name */
        public final List<Cfor> m1485do() {
            return this.f1475do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ccatch)) {
                return false;
            }
            Ccatch catchR = (Ccatch) obj;
            return x.b(this.f1475do, catchR.f1475do) && this.f1476if == catchR.f1476if;
        }

        public int hashCode() {
            return (this.f1475do.hashCode() * 31) + this.f1476if;
        }

        /* renamed from: if  reason: not valid java name */
        public final int m1486if() {
            return this.f1476if;
        }

        public String toString() {
            return "Network(certificates=" + this.f1475do + ", timeoutSecs=" + this.f1476if + ')';
        }
    }

    /* renamed from: com.iproov.sdk.return.extends$class  reason: invalid class name */
    public static final class Cclass {

        /* renamed from: break  reason: not valid java name */
        private final int f1477break;

        /* renamed from: case  reason: not valid java name */
        private final Cgoto f1478case;

        /* renamed from: catch  reason: not valid java name */
        private final int f1479catch;

        /* renamed from: class  reason: not valid java name */
        private final boolean f1480class;

        /* renamed from: const  reason: not valid java name */
        private final boolean f1481const;

        /* renamed from: do  reason: not valid java name */
        private final String f1482do;

        /* renamed from: else  reason: not valid java name */
        private final boolean f1483else;

        /* renamed from: final  reason: not valid java name */
        private final int f1484final;

        /* renamed from: for  reason: not valid java name */
        private final int f1485for;

        /* renamed from: goto  reason: not valid java name */
        private final Orientation f1486goto;

        /* renamed from: if  reason: not valid java name */
        private final int f1487if;

        /* renamed from: new  reason: not valid java name */
        private final Ccase f1488new;

        /* renamed from: super  reason: not valid java name */
        private final Cdo f1489super;

        /* renamed from: this  reason: not valid java name */
        private final Cnew f1490this;

        /* renamed from: throw  reason: not valid java name */
        private final Cif f1491throw;

        /* renamed from: try  reason: not valid java name */
        private final Celse f1492try;

        /* renamed from: com.iproov.sdk.return.extends$class$do  reason: invalid class name */
        public static final class Cdo {

            /* renamed from: do  reason: not valid java name */
            private final int f1493do;

            /* renamed from: if  reason: not valid java name */
            private final int f1494if;

            public Cdo(int i11, int i12) {
                this.f1493do = i11;
                this.f1494if = i12;
            }

            /* renamed from: do  reason: not valid java name */
            public final int m1503do() {
                return this.f1494if;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Cdo)) {
                    return false;
                }
                Cdo doVar = (Cdo) obj;
                return this.f1493do == doVar.f1493do && this.f1494if == doVar.f1494if;
            }

            public int hashCode() {
                return (this.f1493do * 31) + this.f1494if;
            }

            /* renamed from: if  reason: not valid java name */
            public final int m1504if() {
                return this.f1493do;
            }

            public String toString() {
                return "GenuinePresenceAssurance(readyOvalStrokeColor=" + this.f1493do + ", notReadyOvalStrokeColor=" + this.f1494if + ')';
            }
        }

        /* renamed from: com.iproov.sdk.return.extends$class$if  reason: invalid class name */
        public static final class Cif {

            /* renamed from: do  reason: not valid java name */
            private final int f1495do;

            /* renamed from: if  reason: not valid java name */
            private final int f1496if;

            public Cif(int i11, int i12) {
                this.f1495do = i11;
                this.f1496if = i12;
            }

            /* renamed from: do  reason: not valid java name */
            public final int m1505do() {
                return this.f1496if;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Cif)) {
                    return false;
                }
                Cif ifVar = (Cif) obj;
                return this.f1495do == ifVar.f1495do && this.f1496if == ifVar.f1496if;
            }

            public int hashCode() {
                return (this.f1495do * 31) + this.f1496if;
            }

            /* renamed from: if  reason: not valid java name */
            public final int m1506if() {
                return this.f1495do;
            }

            public String toString() {
                return "LivenessAssurance(ovalStrokeColor=" + this.f1495do + ", completedOvalStrokeColor=" + this.f1496if + ')';
            }
        }

        public Cclass(String str, int i11, int i12, Ccase caseR, Celse elseR, Cgoto gotoR, boolean z11, Orientation orientation, Cnew newR, int i13, int i14, boolean z12, boolean z13, int i15, Cdo doVar, Cif ifVar) {
            this.f1482do = str;
            this.f1487if = i11;
            this.f1485for = i12;
            this.f1488new = caseR;
            this.f1492try = elseR;
            this.f1478case = gotoR;
            this.f1483else = z11;
            this.f1486goto = orientation;
            this.f1490this = newR;
            this.f1477break = i13;
            this.f1479catch = i14;
            this.f1480class = z12;
            this.f1481const = z13;
            this.f1484final = i15;
            this.f1489super = doVar;
            this.f1491throw = ifVar;
        }

        /* renamed from: break  reason: not valid java name */
        public final Orientation m1487break() {
            return this.f1486goto;
        }

        /* renamed from: case  reason: not valid java name */
        public final Cdo m1488case() {
            return this.f1489super;
        }

        /* renamed from: catch  reason: not valid java name */
        public final int m1489catch() {
            return this.f1479catch;
        }

        /* renamed from: class  reason: not valid java name */
        public final boolean m1490class() {
            return this.f1480class;
        }

        /* renamed from: const  reason: not valid java name */
        public final int m1491const() {
            return this.f1477break;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cnew m1492do() {
            return this.f1490this;
        }

        /* renamed from: else  reason: not valid java name */
        public final int m1493else() {
            return this.f1485for;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cclass)) {
                return false;
            }
            Cclass classR = (Cclass) obj;
            return x.b(this.f1482do, classR.f1482do) && this.f1487if == classR.f1487if && this.f1485for == classR.f1485for && x.b(this.f1488new, classR.f1488new) && x.b(this.f1492try, classR.f1492try) && x.b(this.f1478case, classR.f1478case) && this.f1483else == classR.f1483else && this.f1486goto == classR.f1486goto && x.b(this.f1490this, classR.f1490this) && this.f1477break == classR.f1477break && this.f1479catch == classR.f1479catch && this.f1480class == classR.f1480class && this.f1481const == classR.f1481const && this.f1484final == classR.f1484final && x.b(this.f1489super, classR.f1489super) && x.b(this.f1491throw, classR.f1491throw);
        }

        /* renamed from: final  reason: not valid java name */
        public final int m1494final() {
            return this.f1484final;
        }

        /* renamed from: for  reason: not valid java name */
        public final boolean m1495for() {
            return this.f1483else;
        }

        /* renamed from: goto  reason: not valid java name */
        public final Cif m1496goto() {
            return this.f1491throw;
        }

        public int hashCode() {
            int hashCode = ((((((this.f1482do.hashCode() * 31) + this.f1487if) * 31) + this.f1485for) * 31) + this.f1488new.hashCode()) * 31;
            Celse elseR = this.f1492try;
            int i11 = 0;
            int hashCode2 = (hashCode + (elseR == null ? 0 : elseR.hashCode())) * 31;
            Cgoto gotoR = this.f1478case;
            if (gotoR != null) {
                i11 = gotoR.hashCode();
            }
            int i12 = (hashCode2 + i11) * 31;
            boolean z11 = this.f1483else;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int hashCode3 = (((((((((i12 + (z11 ? 1 : 0)) * 31) + this.f1486goto.hashCode()) * 31) + this.f1490this.hashCode()) * 31) + this.f1477break) * 31) + this.f1479catch) * 31;
            boolean z13 = this.f1480class;
            if (z13) {
                z13 = true;
            }
            int i13 = (hashCode3 + (z13 ? 1 : 0)) * 31;
            boolean z14 = this.f1481const;
            if (!z14) {
                z12 = z14;
            }
            return ((((((i13 + (z12 ? 1 : 0)) * 31) + this.f1484final) * 31) + this.f1489super.hashCode()) * 31) + this.f1491throw.hashCode();
        }

        /* renamed from: if  reason: not valid java name */
        public final boolean m1497if() {
            return this.f1481const;
        }

        /* renamed from: new  reason: not valid java name */
        public final Ccase m1498new() {
            return this.f1488new;
        }

        /* renamed from: super  reason: not valid java name */
        public final String m1499super() {
            return this.f1482do;
        }

        /* renamed from: this  reason: not valid java name */
        public final Cgoto m1500this() {
            return this.f1478case;
        }

        /* renamed from: throw  reason: not valid java name */
        public final int m1501throw() {
            return this.f1487if;
        }

        public String toString() {
            return "UI(title=" + this.f1482do + ", titleTextColor=" + this.f1487if + ", headerBackgroundColor=" + this.f1485for + ", filter=" + this.f1488new + ", font=" + this.f1492try + ", logo=" + this.f1478case + ", enableScreenshots=" + this.f1483else + ", orientation=" + this.f1486goto + ", closeButton=" + this.f1490this + ", promptTextColor=" + this.f1477break + ", promptBackgroundColor=" + this.f1479catch + ", promptHasRoundedCorners=" + this.f1480class + ", disableExteriorEffects=" + this.f1481const + ", surroundColor=" + this.f1484final + ", genuinePresenceAssurance=" + this.f1489super + ", livenessAssurance=" + this.f1491throw + ')';
        }

        /* renamed from: try  reason: not valid java name */
        public final Celse m1502try() {
            return this.f1492try;
        }
    }

    /* renamed from: com.iproov.sdk.return.extends$do  reason: invalid class name */
    public enum Cdo {
        FRONT,
        EXTERNAL
    }

    /* renamed from: com.iproov.sdk.return.extends$else  reason: invalid class name */
    public static abstract class Celse {

        /* renamed from: com.iproov.sdk.return.extends$else$do  reason: invalid class name */
        public static final class Cdo extends Celse {

            /* renamed from: do  reason: not valid java name */
            private final String f1500do;

            public Cdo(String str) {
                super((r) null);
                this.f1500do = str;
            }

            /* renamed from: do  reason: not valid java name */
            public final String m1508do() {
                return this.f1500do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cdo) && x.b(this.f1500do, ((Cdo) obj).f1500do);
            }

            public int hashCode() {
                return this.f1500do.hashCode();
            }

            public String toString() {
                return "PathFont(path=" + this.f1500do + ')';
            }
        }

        /* renamed from: com.iproov.sdk.return.extends$else$if  reason: invalid class name */
        public static final class Cif extends Celse {

            /* renamed from: do  reason: not valid java name */
            private final int f1501do;

            public Cif(int i11) {
                super((r) null);
                this.f1501do = i11;
            }

            /* renamed from: do  reason: not valid java name */
            public final int m1509do() {
                return this.f1501do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cif) && this.f1501do == ((Cif) obj).f1501do;
            }

            public int hashCode() {
                return this.f1501do;
            }

            public String toString() {
                return "ResourceFont(resID=" + this.f1501do + ')';
            }
        }

        private Celse() {
        }

        public /* synthetic */ Celse(r rVar) {
            this();
        }
    }

    /* renamed from: com.iproov.sdk.return.extends$for  reason: invalid class name */
    public static abstract class Cfor {

        /* renamed from: com.iproov.sdk.return.extends$for$do  reason: invalid class name */
        public static final class Cdo extends Cfor {

            /* renamed from: do  reason: not valid java name */
            private final byte[] f1502do;

            public Cdo(byte[] bArr) {
                super((r) null);
                this.f1502do = bArr;
            }

            /* renamed from: do  reason: not valid java name */
            public final byte[] m1510do() {
                return this.f1502do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cdo) && x.b(this.f1502do, ((Cdo) obj).f1502do);
            }

            public int hashCode() {
                return Arrays.hashCode(this.f1502do);
            }

            public String toString() {
                return "ByteArrayCertificate(byteArray=" + Arrays.toString(this.f1502do) + ')';
            }
        }

        /* renamed from: com.iproov.sdk.return.extends$for$if  reason: invalid class name */
        public static final class Cif extends Cfor {

            /* renamed from: do  reason: not valid java name */
            private final int f1503do;

            public Cif(int i11) {
                super((r) null);
                this.f1503do = i11;
            }

            /* renamed from: do  reason: not valid java name */
            public final int m1511do() {
                return this.f1503do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cif) && this.f1503do == ((Cif) obj).f1503do;
            }

            public int hashCode() {
                return this.f1503do;
            }

            public String toString() {
                return "ResourceCertificate(resID=" + this.f1503do + ')';
            }
        }

        private Cfor() {
        }

        public /* synthetic */ Cfor(r rVar) {
            this();
        }
    }

    /* renamed from: com.iproov.sdk.return.extends$goto  reason: invalid class name */
    public static abstract class Cgoto {

        /* renamed from: com.iproov.sdk.return.extends$goto$do  reason: invalid class name */
        public static final class Cdo extends Cgoto {

            /* renamed from: do  reason: not valid java name */
            private final Bitmap f1504do;

            public Cdo(Bitmap bitmap) {
                super((r) null);
                this.f1504do = bitmap;
            }

            /* renamed from: do  reason: not valid java name */
            public final Bitmap m1512do() {
                return this.f1504do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cdo) && x.b(this.f1504do, ((Cdo) obj).f1504do);
            }

            public int hashCode() {
                return this.f1504do.hashCode();
            }

            public String toString() {
                return "BitmapIcon(imageBitmap=" + this.f1504do + ')';
            }
        }

        /* renamed from: com.iproov.sdk.return.extends$goto$for  reason: invalid class name */
        public static final class Cfor extends Cgoto {

            /* renamed from: do  reason: not valid java name */
            private final int f1505do;

            public Cfor(int i11) {
                super((r) null);
                this.f1505do = i11;
            }

            /* renamed from: do  reason: not valid java name */
            public final int m1513do() {
                return this.f1505do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cfor) && this.f1505do == ((Cfor) obj).f1505do;
            }

            public int hashCode() {
                return this.f1505do;
            }

            public String toString() {
                return "ResourceIcon(imageID=" + this.f1505do + ')';
            }
        }

        /* renamed from: com.iproov.sdk.return.extends$goto$if  reason: invalid class name */
        public static final class Cif extends Cgoto {

            /* renamed from: do  reason: not valid java name */
            private final Drawable f1506do;

            public Cif(Drawable drawable) {
                super((r) null);
                this.f1506do = drawable;
            }

            /* renamed from: do  reason: not valid java name */
            public final Drawable m1514do() {
                return this.f1506do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cif) && x.b(this.f1506do, ((Cif) obj).f1506do);
            }

            public int hashCode() {
                return this.f1506do.hashCode();
            }

            public String toString() {
                return "DrawableIcon(imageDrawable=" + this.f1506do + ')';
            }
        }

        private Cgoto() {
        }

        public /* synthetic */ Cgoto(r rVar) {
            this();
        }
    }

    /* renamed from: com.iproov.sdk.return.extends$if  reason: invalid class name */
    public static final class Cif {

        /* renamed from: do  reason: not valid java name */
        private final Cdo f1507do;

        /* renamed from: for  reason: not valid java name */
        private final Cdo f1508for;

        /* renamed from: if  reason: not valid java name */
        private final Ctry f1509if;

        /* renamed from: com.iproov.sdk.return.extends$if$do  reason: invalid class name */
        public static final class Cdo {

            /* renamed from: do  reason: not valid java name */
            private final float f1510do;

            /* renamed from: for  reason: not valid java name */
            private final float f1511for;

            /* renamed from: if  reason: not valid java name */
            private final float f1512if;

            public Cdo(float f11, float f12, float f13) {
                this.f1510do = f11;
                this.f1512if = f12;
                this.f1511for = f13;
            }

            /* renamed from: do  reason: not valid java name */
            public final float m1518do() {
                return this.f1510do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Cdo)) {
                    return false;
                }
                Cdo doVar = (Cdo) obj;
                return x.b(Float.valueOf(this.f1510do), Float.valueOf(doVar.f1510do)) && x.b(Float.valueOf(this.f1512if), Float.valueOf(doVar.f1512if)) && x.b(Float.valueOf(this.f1511for), Float.valueOf(doVar.f1511for));
            }

            /* renamed from: for  reason: not valid java name */
            public final float m1519for() {
                return this.f1512if;
            }

            public int hashCode() {
                return (((Float.floatToIntBits(this.f1510do) * 31) + Float.floatToIntBits(this.f1512if)) * 31) + Float.floatToIntBits(this.f1511for);
            }

            /* renamed from: if  reason: not valid java name */
            public final float m1520if() {
                return this.f1511for;
            }

            public String toString() {
                return "GenuinePresenceAssurance(maxPitch=" + this.f1510do + ", maxYaw=" + this.f1512if + ", maxRoll=" + this.f1511for + ')';
            }
        }

        public Cif(Cdo doVar, Ctry tryR, Cdo doVar2) {
            this.f1507do = doVar;
            this.f1509if = tryR;
            this.f1508for = doVar2;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cdo m1515do() {
            return this.f1507do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cif)) {
                return false;
            }
            Cif ifVar = (Cif) obj;
            return this.f1507do == ifVar.f1507do && this.f1509if == ifVar.f1509if && x.b(this.f1508for, ifVar.f1508for);
        }

        /* renamed from: for  reason: not valid java name */
        public final Cdo m1516for() {
            return this.f1508for;
        }

        public int hashCode() {
            return (((this.f1507do.hashCode() * 31) + this.f1509if.hashCode()) * 31) + this.f1508for.hashCode();
        }

        /* renamed from: if  reason: not valid java name */
        public final Ctry m1517if() {
            return this.f1509if;
        }

        public String toString() {
            return "Capture(camera=" + this.f1507do + ", faceDetector=" + this.f1509if + ", genuinePresenceAssurance=" + this.f1508for + ')';
        }
    }

    /* renamed from: com.iproov.sdk.return.extends$new  reason: invalid class name */
    public static final class Cnew {

        /* renamed from: do  reason: not valid java name */
        private final Cgoto f1513do;

        /* renamed from: if  reason: not valid java name */
        private final int f1514if;

        public Cnew(Cgoto gotoR, int i11) {
            this.f1513do = gotoR;
            this.f1514if = i11;
        }

        /* renamed from: do  reason: not valid java name */
        public final int m1521do() {
            return this.f1514if;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cnew)) {
                return false;
            }
            Cnew newR = (Cnew) obj;
            return x.b(this.f1513do, newR.f1513do) && this.f1514if == newR.f1514if;
        }

        public int hashCode() {
            return (this.f1513do.hashCode() * 31) + this.f1514if;
        }

        /* renamed from: if  reason: not valid java name */
        public final Cgoto m1522if() {
            return this.f1513do;
        }

        public String toString() {
            return "CloseButton(icon=" + this.f1513do + ", colorTint=" + this.f1514if + ')';
        }
    }

    /* renamed from: com.iproov.sdk.return.extends$this  reason: invalid class name */
    public enum Cthis {
        CLASSIC,
        SHADED,
        VIBRANT
    }

    /* renamed from: com.iproov.sdk.return.extends$try  reason: invalid class name */
    public enum Ctry {
        AUTO,
        CLASSIC,
        ML_KIT,
        BLAZEFACE
    }

    public Cextends(Cclass classR, Ccatch catchR, Cif ifVar) {
        this.f1465do = classR;
        this.f1467if = catchR;
        this.f1466for = ifVar;
    }

    /* renamed from: do  reason: not valid java name */
    public final Cif m1477do() {
        return this.f1466for;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cextends)) {
            return false;
        }
        Cextends extendsR = (Cextends) obj;
        return x.b(this.f1465do, extendsR.f1465do) && x.b(this.f1467if, extendsR.f1467if) && x.b(this.f1466for, extendsR.f1466for);
    }

    /* renamed from: for  reason: not valid java name */
    public final Cclass m1478for() {
        return this.f1465do;
    }

    public int hashCode() {
        return (((this.f1465do.hashCode() * 31) + this.f1467if.hashCode()) * 31) + this.f1466for.hashCode();
    }

    /* renamed from: if  reason: not valid java name */
    public final Ccatch m1479if() {
        return this.f1467if;
    }

    public String toString() {
        return "SessionOptions(ui=" + this.f1465do + ", network=" + this.f1467if + ", capture=" + this.f1466for + ')';
    }
}
