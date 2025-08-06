package com.iproov.sdk;

import android.content.Context;
import com.iproov.sdk.CommonApi;
import com.iproov.sdk.IProov;
import com.iproov.sdk.IProovState;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.exception.InvalidOptionsException;
import com.iproov.sdk.p009do.Ccase;
import com.iproov.sdk.p009do.Celse;
import com.iproov.sdk.p009do.Cgoto;
import com.iproov.sdk.p009do.Cthis;
import com.iproov.sdk.p016if.Cwhile;
import com.iproov.sdk.p026return.Cconst;
import com.iproov.sdk.p026return.Cextends;
import d10.a;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.h0;

/* renamed from: com.iproov.sdk.do  reason: invalid class name */
public final class Cdo {

    /* renamed from: com.iproov.sdk.do$do  reason: invalid class name */
    public /* synthetic */ class Cdo {

        /* renamed from: break  reason: not valid java name */
        public static final /* synthetic */ int[] f464break;

        /* renamed from: case  reason: not valid java name */
        public static final /* synthetic */ int[] f465case;

        /* renamed from: catch  reason: not valid java name */
        public static final /* synthetic */ int[] f466catch;

        /* renamed from: class  reason: not valid java name */
        public static final /* synthetic */ int[] f467class;

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f468do;

        /* renamed from: else  reason: not valid java name */
        public static final /* synthetic */ int[] f469else;

        /* renamed from: for  reason: not valid java name */
        public static final /* synthetic */ int[] f470for;

        /* renamed from: goto  reason: not valid java name */
        public static final /* synthetic */ int[] f471goto;

        /* renamed from: if  reason: not valid java name */
        public static final /* synthetic */ int[] f472if;

        /* renamed from: new  reason: not valid java name */
        public static final /* synthetic */ int[] f473new;

        /* renamed from: this  reason: not valid java name */
        public static final /* synthetic */ int[] f474this;

        /* renamed from: try  reason: not valid java name */
        public static final /* synthetic */ int[] f475try;

        static {
            int[] iArr = new int[IProov.LineDrawingStyle.values().length];
            iArr[IProov.LineDrawingStyle.CLASSIC.ordinal()] = 1;
            iArr[IProov.LineDrawingStyle.SHADED.ordinal()] = 2;
            iArr[IProov.LineDrawingStyle.VIBRANT.ordinal()] = 3;
            f468do = iArr;
            int[] iArr2 = new int[IProov.NaturalStyle.values().length];
            iArr2[IProov.NaturalStyle.BLUR.ordinal()] = 1;
            iArr2[IProov.NaturalStyle.CLEAR.ordinal()] = 2;
            f472if = iArr2;
            int[] iArr3 = new int[IProov.Camera.values().length];
            iArr3[IProov.Camera.FRONT.ordinal()] = 1;
            iArr3[IProov.Camera.EXTERNAL.ordinal()] = 2;
            f470for = iArr3;
            int[] iArr4 = new int[IProov.FaceDetector.values().length];
            iArr4[IProov.FaceDetector.AUTO.ordinal()] = 1;
            iArr4[IProov.FaceDetector.CLASSIC.ordinal()] = 2;
            iArr4[IProov.FaceDetector.BLAZEFACE.ordinal()] = 3;
            iArr4[IProov.FaceDetector.ML_KIT.ordinal()] = 4;
            f473new = iArr4;
            int[] iArr5 = new int[IProov.Orientation.values().length];
            iArr5[IProov.Orientation.PORTRAIT.ordinal()] = 1;
            iArr5[IProov.Orientation.REVERSE_PORTRAIT.ordinal()] = 2;
            iArr5[IProov.Orientation.LANDSCAPE.ordinal()] = 3;
            iArr5[IProov.Orientation.REVERSE_LANDSCAPE.ordinal()] = 4;
            f475try = iArr5;
            int[] iArr6 = new int[Cextends.Cbreak.values().length];
            iArr6[Cextends.Cbreak.BLUR.ordinal()] = 1;
            iArr6[Cextends.Cbreak.CLEAR.ordinal()] = 2;
            f465case = iArr6;
            int[] iArr7 = new int[Cextends.Cthis.values().length];
            iArr7[Cextends.Cthis.CLASSIC.ordinal()] = 1;
            iArr7[Cextends.Cthis.SHADED.ordinal()] = 2;
            iArr7[Cextends.Cthis.VIBRANT.ordinal()] = 3;
            f469else = iArr7;
            int[] iArr8 = new int[Orientation.values().length];
            iArr8[Orientation.PORTRAIT.ordinal()] = 1;
            iArr8[Orientation.REVERSE_PORTRAIT.ordinal()] = 2;
            iArr8[Orientation.LANDSCAPE.ordinal()] = 3;
            iArr8[Orientation.REVERSE_LANDSCAPE.ordinal()] = 4;
            f471goto = iArr8;
            int[] iArr9 = new int[Cextends.Cdo.values().length];
            iArr9[Cextends.Cdo.FRONT.ordinal()] = 1;
            iArr9[Cextends.Cdo.EXTERNAL.ordinal()] = 2;
            f474this = iArr9;
            int[] iArr10 = new int[Cextends.Ctry.values().length];
            iArr10[Cextends.Ctry.AUTO.ordinal()] = 1;
            iArr10[Cextends.Ctry.CLASSIC.ordinal()] = 2;
            iArr10[Cextends.Ctry.BLAZEFACE.ordinal()] = 3;
            iArr10[Cextends.Ctry.ML_KIT.ordinal()] = 4;
            f464break = iArr10;
            int[] iArr11 = new int[Cif.values().length];
            iArr11[Cif.USER.ordinal()] = 1;
            iArr11[Cif.f643if.ordinal()] = 2;
            f466catch = iArr11;
            int[] iArr12 = new int[Cfor.values().length];
            iArr12[Cfor.f560for.ordinal()] = 1;
            iArr12[Cfor.TOO_MUCH_MOVEMENT.ordinal()] = 2;
            iArr12[Cfor.TOO_BRIGHT.ordinal()] = 3;
            iArr12[Cfor.TOO_DARK.ordinal()] = 4;
            iArr12[Cfor.MISALIGNED_FACE.ordinal()] = 5;
            iArr12[Cfor.EYES_CLOSED.ordinal()] = 6;
            iArr12[Cfor.FACE_TOO_FAR.ordinal()] = 7;
            iArr12[Cfor.FACE_TOO_CLOSE.ordinal()] = 8;
            iArr12[Cfor.SUNGLASSES.ordinal()] = 9;
            iArr12[Cfor.OBSCURED_FACE.ordinal()] = 10;
            iArr12[Cfor.USER_TIMEOUT.ordinal()] = 11;
            iArr12[Cfor.NOT_SUPPORTED.ordinal()] = 12;
            f467class = iArr12;
        }
    }

    /* renamed from: com.iproov.sdk.do$for  reason: invalid class name */
    public static final class Cfor extends Lambda implements a<Boolean> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ccase f481do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfor(Ccase caseR) {
            super(0);
            this.f481do = caseR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Boolean invoke() {
            return Boolean.valueOf(this.f481do.isActive());
        }
    }

    /* renamed from: com.iproov.sdk.do$if  reason: invalid class name */
    public static final class Cif extends Lambda implements a<IProov.IProovState> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ccase f488do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Ccase caseR) {
            super(0);
            this.f488do = caseR;
        }

        /* renamed from: do  reason: not valid java name */
        public final IProov.IProovState invoke() {
            return Cdo.m534do(this.f488do.getCurrentState());
        }
    }

    /* renamed from: com.iproov.sdk.do$new  reason: invalid class name */
    public static final class Cnew extends Lambda implements a<Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ccase f494do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cnew(Ccase caseR) {
            super(0);
            this.f494do = caseR;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m578do() {
            this.f494do.cancel();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m578do();
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.do$try  reason: invalid class name */
    public static final class Ctry extends Lambda implements l<byte[], byte[]> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cwhile f509do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ctry(Cwhile whileR) {
            super(1);
            this.f509do = whileR;
        }

        /* renamed from: do  reason: not valid java name */
        public final byte[] invoke(byte[] bArr) {
            return this.f509do.sign(bArr);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cextends.Cthis m555do(IProov.LineDrawingStyle lineDrawingStyle) {
        int i11 = Cdo.f468do[lineDrawingStyle.ordinal()];
        if (i11 == 1) {
            return Cextends.Cthis.CLASSIC;
        }
        if (i11 == 2) {
            return Cextends.Cthis.SHADED;
        }
        if (i11 == 3) {
            return Cextends.Cthis.VIBRANT;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cextends.Cbreak m547do(IProov.NaturalStyle naturalStyle) {
        int i11 = Cdo.f472if[naturalStyle.ordinal()];
        if (i11 == 1) {
            return Cextends.Cbreak.BLUR;
        }
        if (i11 == 2) {
            return Cextends.Cbreak.CLEAR;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cextends.Cdo m550do(IProov.Camera camera) {
        int i11 = Cdo.f470for[camera.ordinal()];
        if (i11 == 1) {
            return Cextends.Cdo.FRONT;
        }
        if (i11 == 2) {
            return Cextends.Cdo.EXTERNAL;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cextends.Ctry m556do(IProov.FaceDetector faceDetector) {
        int i11 = Cdo.f473new[faceDetector.ordinal()];
        if (i11 == 1) {
            return Cextends.Ctry.AUTO;
        }
        if (i11 == 2) {
            return Cextends.Ctry.CLASSIC;
        }
        if (i11 == 3) {
            return Cextends.Ctry.BLAZEFACE;
        }
        if (i11 == 4) {
            return Cextends.Ctry.ML_KIT;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cextends.Cfor m552do(IProov.Options.Certificate certificate) {
        if (certificate instanceof IProov.Options.Certificate.ResourceCertificate) {
            return new Cextends.Cfor.Cif(((IProov.Options.Certificate.ResourceCertificate) certificate).getResID());
        }
        if (certificate instanceof IProov.Options.Certificate.ByteArrayCertificate) {
            return new Cextends.Cfor.Cdo(((IProov.Options.Certificate.ByteArrayCertificate) certificate).getByteArray());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cextends.Celse m551do(IProov.Options.Font font) {
        if (font instanceof IProov.Options.Font.PathFont) {
            return new Cextends.Celse.Cdo(((IProov.Options.Font.PathFont) font).getPath());
        }
        if (font instanceof IProov.Options.Font.ResourceFont) {
            return new Cextends.Celse.Cif(((IProov.Options.Font.ResourceFont) font).getPathID());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cextends.Cgoto m553do(IProov.Options.Icon icon) {
        if (icon instanceof IProov.Options.Icon.BitmapIcon) {
            return new Cextends.Cgoto.Cdo(((IProov.Options.Icon.BitmapIcon) icon).getImageBitmap());
        }
        if (icon instanceof IProov.Options.Icon.DrawableIcon) {
            return new Cextends.Cgoto.Cif(((IProov.Options.Icon.DrawableIcon) icon).getImageDrawable());
        }
        if (icon instanceof IProov.Options.Icon.ResourceIcon) {
            return new Cextends.Cgoto.Cfor(((IProov.Options.Icon.ResourceIcon) icon).getImageID());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final Orientation m546do(IProov.Orientation orientation) {
        int i11 = Cdo.f475try[orientation.ordinal()];
        if (i11 == 1) {
            return Orientation.PORTRAIT;
        }
        if (i11 == 2) {
            return Orientation.REVERSE_PORTRAIT;
        }
        if (i11 == 3) {
            return Orientation.LANDSCAPE;
        }
        if (i11 == 4) {
            return Orientation.REVERSE_LANDSCAPE;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cextends.Cnew m554do(IProov.Options.CloseButton closeButton) {
        return new Cextends.Cnew(m553do(closeButton.getIcon()), closeButton.getColorTint());
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cextends m557do(IProov.Options options, Context context) throws InvalidOptionsException {
        String title = options.getTitle();
        int titleTextColor = options.getTitleTextColor();
        int headerBackgroundColor = options.getHeaderBackgroundColor();
        Cextends.Ccase caseR = m549do(options.getFilter());
        IProov.Options.Font font = options.getFont();
        Cextends.Celse elseR = font == null ? null : m551do(font);
        IProov.Options.Icon logo = options.getLogo();
        Cextends.Cgoto gotoR = logo == null ? null : m553do(logo);
        boolean enableScreenshots = options.getEnableScreenshots();
        Orientation orientation = m546do(options.getOrientation());
        Cextends.Cnew newR = m554do(options.getCloseButton());
        int promptTextColor = options.getPromptTextColor();
        int promptBackgroundColor = options.getPromptBackgroundColor();
        boolean promptRoundedCorners = options.getPromptRoundedCorners();
        boolean disableExteriorEffects = options.getDisableExteriorEffects();
        int surroundColor = options.getSurroundColor();
        Cextends.Cclass.Cdo doVar = r0;
        Cextends.Cclass.Cdo doVar2 = new Cextends.Cclass.Cdo(options.getGenuinePresenceAssurance().getReadyOvalStrokeColor(), options.getGenuinePresenceAssurance().getNotReadyOvalStrokeColor());
        Cextends.Cclass.Cif ifVar = r0;
        Cextends.Cclass.Cif ifVar2 = new Cextends.Cclass.Cif(options.getLivenessAssurance().getOvalStrokeColor(), options.getLivenessAssurance().getCompletedOvalStrokeColor());
        Cextends.Cclass classR = r0;
        Cextends.Cclass classR2 = new Cextends.Cclass(title, titleTextColor, headerBackgroundColor, caseR, elseR, gotoR, enableScreenshots, orientation, newR, promptTextColor, promptBackgroundColor, promptRoundedCorners, disableExteriorEffects, surroundColor, doVar, ifVar);
        List<IProov.Options.Certificate> certificates = options.getCertificates();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(certificates, 10));
        for (IProov.Options.Certificate certificate : certificates) {
            arrayList.add(m552do(certificate));
        }
        return new Cextends(classR, new Cextends.Ccatch(arrayList, options.getTimeoutSecs()), new Cextends.Cif(m550do(options.getCamera()), m556do(options.getFaceDetector()), new Cextends.Cif.Cdo(options.getGenuinePresenceAssurance().getMaxPitch(), options.getGenuinePresenceAssurance().getMaxYaw(), options.getGenuinePresenceAssurance().getMaxRoll())));
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.Options m542do(Cextends extendsR) {
        String str = extendsR.m1478for().m1499super();
        int i11 = extendsR.m1478for().m1501throw();
        int i12 = extendsR.m1478for().m1493else();
        IProov.Options.Filter filter = m539do(extendsR.m1478for().m1498new());
        int i13 = extendsR.m1478for().m1494final();
        Cextends.Celse elseR = extendsR.m1478for().m1502try();
        IProov.Options.Font font = elseR == null ? null : m540do(elseR);
        Cextends.Cgoto gotoR = extendsR.m1478for().m1500this();
        IProov.Options.Icon icon = gotoR == null ? null : m541do(gotoR);
        boolean z11 = extendsR.m1478for().m1495for();
        IProov.Options.CloseButton closeButton = m538do(extendsR.m1478for().m1492do());
        int i14 = extendsR.m1478for().m1491const();
        int i15 = extendsR.m1478for().m1489catch();
        boolean z12 = extendsR.m1478for().m1490class();
        boolean z13 = extendsR.m1478for().m1497if();
        List<Cextends.Cfor> list = extendsR.m1479if().m1485do();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (Cextends.Cfor forR : list) {
            arrayList.add(m537do(forR));
        }
        int i16 = extendsR.m1479if().m1486if();
        IProov.Orientation orientation = m543do(extendsR.m1478for().m1487break());
        IProov.Camera camera = m528do(extendsR.m1477do().m1515do());
        IProov.FaceDetector faceDetector = m530do(extendsR.m1477do().m1517if());
        IProov.Options.GenuinePresenceAssurance genuinePresenceAssurance = r21;
        IProov.Options.GenuinePresenceAssurance genuinePresenceAssurance2 = new IProov.Options.GenuinePresenceAssurance(extendsR.m1478for().m1488case().m1504if(), extendsR.m1478for().m1488case().m1503do(), extendsR.m1477do().m1516for().m1518do(), extendsR.m1477do().m1516for().m1519for(), extendsR.m1477do().m1516for().m1520if());
        IProov.Options.LivenessAssurance livenessAssurance = r0;
        ArrayList arrayList2 = arrayList;
        IProov.Options.LivenessAssurance livenessAssurance2 = new IProov.Options.LivenessAssurance(extendsR.m1478for().m1496goto().m1506if(), extendsR.m1478for().m1496goto().m1505do());
        return new IProov.Options(str, i11, i12, filter, i13, font, icon, z11, closeButton, i14, i15, z12, z13, arrayList2, i16, orientation, camera, faceDetector, genuinePresenceAssurance, livenessAssurance);
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cextends.Ccase.Cdo m548do(IProov.Options.Filter.LineDrawingFilter lineDrawingFilter) {
        return new Cextends.Ccase.Cdo(m555do(lineDrawingFilter.getStyle()), lineDrawingFilter.getForegroundColor(), lineDrawingFilter.getBackgroundColor());
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.Options.Filter m539do(Cextends.Ccase caseR) {
        if (caseR instanceof Cextends.Ccase.Cif) {
            return new IProov.Options.Filter.NaturalFilter(m536do(((Cextends.Ccase.Cif) caseR).m1484do()));
        }
        if (caseR instanceof Cextends.Ccase.Cdo) {
            Cextends.Ccase.Cdo doVar = (Cextends.Ccase.Cdo) caseR;
            return new IProov.Options.Filter.LineDrawingFilter(m535do(doVar.m1482for()), doVar.m1483if(), doVar.m1481do());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.NaturalStyle m536do(Cextends.Cbreak breakR) {
        int i11 = Cdo.f465case[breakR.ordinal()];
        if (i11 == 1) {
            return IProov.NaturalStyle.BLUR;
        }
        if (i11 == 2) {
            return IProov.NaturalStyle.CLEAR;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.LineDrawingStyle m535do(Cextends.Cthis thisR) {
        int i11 = Cdo.f469else[thisR.ordinal()];
        if (i11 == 1) {
            return IProov.LineDrawingStyle.CLASSIC;
        }
        if (i11 == 2) {
            return IProov.LineDrawingStyle.SHADED;
        }
        if (i11 == 3) {
            return IProov.LineDrawingStyle.VIBRANT;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.Options.Font m540do(Cextends.Celse elseR) {
        if (elseR instanceof Cextends.Celse.Cdo) {
            return new IProov.Options.Font.PathFont(((Cextends.Celse.Cdo) elseR).m1508do());
        }
        if (elseR instanceof Cextends.Celse.Cif) {
            return new IProov.Options.Font.ResourceFont(((Cextends.Celse.Cif) elseR).m1509do());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.Options.Icon m541do(Cextends.Cgoto gotoR) {
        if (gotoR instanceof Cextends.Cgoto.Cdo) {
            return new IProov.Options.Icon.BitmapIcon(((Cextends.Cgoto.Cdo) gotoR).m1512do());
        }
        if (gotoR instanceof Cextends.Cgoto.Cif) {
            return new IProov.Options.Icon.DrawableIcon(((Cextends.Cgoto.Cif) gotoR).m1514do());
        }
        if (gotoR instanceof Cextends.Cgoto.Cfor) {
            return new IProov.Options.Icon.ResourceIcon(((Cextends.Cgoto.Cfor) gotoR).m1513do());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.Options.CloseButton m538do(Cextends.Cnew newR) {
        return new IProov.Options.CloseButton(m541do(newR.m1522if()), newR.m1521do());
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.Options.Certificate m537do(Cextends.Cfor forR) {
        if (forR instanceof Cextends.Cfor.Cif) {
            return new IProov.Options.Certificate.ResourceCertificate(((Cextends.Cfor.Cif) forR).m1511do());
        }
        if (forR instanceof Cextends.Cfor.Cdo) {
            return new IProov.Options.Certificate.ByteArrayCertificate(((Cextends.Cfor.Cdo) forR).m1510do());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.Orientation m543do(Orientation orientation) {
        int i11 = Cdo.f471goto[orientation.ordinal()];
        if (i11 == 1) {
            return IProov.Orientation.PORTRAIT;
        }
        if (i11 == 2) {
            return IProov.Orientation.REVERSE_PORTRAIT;
        }
        if (i11 == 3) {
            return IProov.Orientation.LANDSCAPE;
        }
        if (i11 == 4) {
            return IProov.Orientation.REVERSE_LANDSCAPE;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.Camera m528do(Cextends.Cdo doVar) {
        int i11 = Cdo.f474this[doVar.ordinal()];
        if (i11 == 1) {
            return IProov.Camera.FRONT;
        }
        if (i11 == 2) {
            return IProov.Camera.EXTERNAL;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.FaceDetector m530do(Cextends.Ctry tryR) {
        int i11 = Cdo.f464break[tryR.ordinal()];
        if (i11 == 1) {
            return IProov.FaceDetector.AUTO;
        }
        if (i11 == 2) {
            return IProov.FaceDetector.CLASSIC;
        }
        if (i11 == 3) {
            return IProov.FaceDetector.BLAZEFACE;
        }
        if (i11 == 4) {
            return IProov.FaceDetector.ML_KIT;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cextends.Ccase m549do(IProov.Options.Filter filter) {
        if (filter instanceof IProov.Options.Filter.LineDrawingFilter) {
            return m548do((IProov.Options.Filter.LineDrawingFilter) filter);
        }
        if (filter instanceof IProov.Options.Filter.NaturalFilter) {
            return new Cextends.Ccase.Cif(m547do(((IProov.Options.Filter.NaturalFilter) filter).getStyle()));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.IProovState m534do(IProovState iProovState) {
        IProov.IProovState error;
        if (iProovState instanceof IProovState.Connecting) {
            return IProov.IProovState.Connecting.INSTANCE;
        }
        if (iProovState instanceof IProovState.Connected) {
            return IProov.IProovState.Connected.INSTANCE;
        }
        if (iProovState instanceof IProovState.Processing) {
            IProovState.Processing processing = (IProovState.Processing) iProovState;
            error = new IProov.IProovState.Processing(processing.getProgress(), processing.getMessage());
        } else if (iProovState instanceof IProovState.Success) {
            error = new IProov.IProovState.Success(m545do(((IProovState.Success) iProovState).getSuccessResult()));
        } else if (iProovState instanceof IProovState.Failure) {
            error = new IProov.IProovState.Failure(m532do(((IProovState.Failure) iProovState).getFailureResult()));
        } else if (iProovState instanceof IProovState.Cancelled) {
            error = new IProov.IProovState.Cancelled(m529do(((IProovState.Cancelled) iProovState).getCanceller()));
        } else if (iProovState instanceof IProovState.Error) {
            error = new IProov.IProovState.Error(((IProovState.Error) iProovState).getException());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return error;
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.Canceller m529do(Cif ifVar) {
        int i11 = Cdo.f466catch[ifVar.ordinal()];
        if (i11 == 1) {
            return IProov.Canceller.USER;
        }
        if (i11 == 2) {
            return IProov.Canceller.APP;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.SuccessResult m545do(Cthis thisR) {
        return new IProov.SuccessResult(thisR.m579do());
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.FailureReason m531do(Cfor forR) {
        switch (Cdo.f467class[forR.ordinal()]) {
            case 1:
                return IProov.FailureReason.UNKNOWN;
            case 2:
                return IProov.FailureReason.TOO_MUCH_MOVEMENT;
            case 3:
                return IProov.FailureReason.TOO_BRIGHT;
            case 4:
                return IProov.FailureReason.TOO_DARK;
            case 5:
                return IProov.FailureReason.MISALIGNED_FACE;
            case 6:
                return IProov.FailureReason.EYES_CLOSED;
            case 7:
                return IProov.FailureReason.FACE_TOO_FAR;
            case 8:
                return IProov.FailureReason.FACE_TOO_CLOSE;
            case 9:
                return IProov.FailureReason.SUNGLASSES;
            case 10:
                return IProov.FailureReason.OBSCURED_FACE;
            case 11:
                return IProov.FailureReason.USER_TIMEOUT;
            case 12:
                return IProov.FailureReason.NOT_SUPPORTED;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.FailureResult m532do(com.iproov.sdk.p009do.Cif ifVar) {
        return new IProov.FailureResult(m531do(ifVar.m570if()), ifVar.m569do());
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.Session m544do(Ccase caseR) {
        if (caseR instanceof Cconst) {
            return new Celse(caseR.getUuid(), caseR.getToken(), new Cif(caseR), new Cfor(caseR), new Cnew(caseR));
        }
        return new Cgoto(caseR.getUuid(), caseR.getToken(), m534do(caseR.getCurrentState()));
    }

    /* renamed from: do  reason: not valid java name */
    public static final IProov.IProovSessionState m533do(IProovSessionState iProovSessionState, h0 h0Var) {
        return new IProov.IProovSessionState(m544do(iProovSessionState.getSession()), m534do(iProovSessionState.getState()));
    }

    /* renamed from: do  reason: not valid java name */
    public static final CommonApi.KeyPair m527do(Cwhile whileR) {
        return new com.iproov.sdk.p009do.Ctry(whileR.getPublicKey(), new Ctry(whileR));
    }
}
