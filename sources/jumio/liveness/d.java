package jumio.liveness;

import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;
import com.jumio.core.extraction.JumioRect;
import com.jumio.core.models.LivenessSettingsModel;
import kotlin.jvm.internal.r;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Size f56445a;

    /* renamed from: b  reason: collision with root package name */
    public final double f56446b;

    /* renamed from: c  reason: collision with root package name */
    public final double f56447c;

    /* renamed from: d  reason: collision with root package name */
    public final double f56448d;

    /* renamed from: e  reason: collision with root package name */
    public final double f56449e;

    /* renamed from: f  reason: collision with root package name */
    public JumioRect f56450f = new JumioRect(0, 0, 0, 0, 15, (r) null);

    /* renamed from: g  reason: collision with root package name */
    public Integer f56451g;

    /* renamed from: h  reason: collision with root package name */
    public a f56452h;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56453a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f56453a = iArr;
        }
    }

    public d(Size size, LivenessSettingsModel livenessSettingsModel) {
        this.f56445a = size;
        this.f56446b = Math.max(1.0d, livenessSettingsModel.getMinNearFarRatio());
        double tooNearThreshold = livenessSettingsModel.getTooNearThreshold();
        this.f56447c = tooNearThreshold;
        double tooFarThreshold = livenessSettingsModel.getTooFarThreshold();
        this.f56448d = tooFarThreshold;
        this.f56449e = (tooNearThreshold + tooFarThreshold) * 0.5d;
    }

    public final a a() {
        a aVar = this.f56452h;
        int i11 = aVar == null ? -1 : a.f56453a[aVar.ordinal()];
        if (i11 == 1) {
            return a.FAR;
        }
        if (i11 != 2) {
            return null;
        }
        return a.NEAR;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r10 >= r0.width()) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final jumio.liveness.a b(int r10) {
        /*
            r9 = this;
            double r0 = (double) r10
            com.jumio.commons.camera.Size r2 = r9.f56445a
            int r2 = r2.getWidth()
            double r2 = (double) r2
            double r4 = r9.f56447c
            double r2 = r2 * r4
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r2 >= 0) goto L_0x0013
            r2 = r3
            goto L_0x0014
        L_0x0013:
            r2 = r4
        L_0x0014:
            if (r2 != 0) goto L_0x001a
            jumio.liveness.a r10 = jumio.liveness.a.TOO_NEAR
            goto L_0x0084
        L_0x001a:
            com.jumio.commons.camera.Size r2 = r9.f56445a
            int r2 = r2.getWidth()
            double r5 = (double) r2
            double r7 = r9.f56448d
            double r5 = r5 * r7
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r3 = r4
        L_0x002a:
            if (r3 != 0) goto L_0x002f
            jumio.liveness.a r10 = jumio.liveness.a.TOO_FAR
            goto L_0x0084
        L_0x002f:
            jumio.liveness.a r2 = r9.f56452h
            if (r2 == 0) goto L_0x0071
            com.jumio.core.extraction.JumioRect r2 = r9.f56450f
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x003c
            goto L_0x0071
        L_0x003c:
            com.jumio.core.extraction.JumioRect r0 = r9.f56450f
            jumio.liveness.a r1 = r9.f56452h
            jumio.liveness.a r2 = jumio.liveness.a.NEAR
            if (r1 != r2) goto L_0x0059
            int r1 = r0.width()
            double r3 = (double) r1
            double r5 = r9.f56446b
            double r3 = r3 / r5
            int r1 = (int) r3
            if (r10 >= r1) goto L_0x0052
            jumio.liveness.a r10 = jumio.liveness.a.FAR
            goto L_0x0084
        L_0x0052:
            int r0 = r0.width()
            if (r10 < r0) goto L_0x006f
            goto L_0x0064
        L_0x0059:
            int r1 = r0.width()
            double r3 = (double) r1
            double r5 = r9.f56446b
            double r3 = r3 * r5
            int r1 = (int) r3
            if (r10 <= r1) goto L_0x0066
        L_0x0064:
            r10 = r2
            goto L_0x0084
        L_0x0066:
            int r0 = r0.width()
            if (r10 > r0) goto L_0x006f
            jumio.liveness.a r10 = jumio.liveness.a.FAR
            goto L_0x0084
        L_0x006f:
            r10 = 0
            goto L_0x0084
        L_0x0071:
            com.jumio.commons.camera.Size r10 = r9.f56445a
            int r10 = r10.getWidth()
            double r2 = (double) r10
            double r0 = r0 / r2
            double r2 = r9.f56449e
            int r10 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r10 <= 0) goto L_0x0082
            jumio.liveness.a r10 = jumio.liveness.a.NEAR
            goto L_0x0084
        L_0x0082:
            jumio.liveness.a r10 = jumio.liveness.a.FAR
        L_0x0084:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.liveness.d.b(int):jumio.liveness.a");
    }

    public final void a(a aVar, JumioRect jumioRect) {
        if ((aVar == a.FAR || aVar == a.NEAR) && !jumioRect.isEmpty()) {
            String name = aVar.name();
            Log.d("LivenessDistanceCalculator", "First distance is set to " + name);
            this.f56452h = aVar;
            this.f56450f = JumioRect.copy$default(jumioRect, 0, 0, 0, 0, 15, (Object) null);
            return;
        }
        Log.d("LivenessDistanceCalculator", "First distance is invalid or roi is empty, ignoring...");
    }

    public final void a(int i11) {
        double d11;
        int width = this.f56450f.width();
        if (this.f56452h == a.NEAR) {
            d11 = ((double) width) / this.f56446b;
        } else {
            d11 = ((double) width) * this.f56446b;
        }
        int i12 = (int) d11;
        int abs = Math.abs(width - i12);
        Integer valueOf = Integer.valueOf(abs / (i11 + 1));
        this.f56451g = valueOf;
        Log.d("LivenessDistanceCalculator", "Calculated transitionStep=" + valueOf + ", referenceWidth=" + width + ", nearToFarWidth=" + abs + ", calculatedTargetRoiWidth=" + i12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r7, jumio.liveness.a r8, int r9) {
        /*
            r6 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.Integer r8 = r6.f56451g
            if (r8 == 0) goto L_0x005e
            int r8 = r8.intValue()
            jumio.liveness.a r1 = r6.f56452h
            jumio.liveness.a r2 = jumio.liveness.a.NEAR
            java.lang.String r3 = "LivenessDistanceCalculator"
            java.lang.String r4 = ", current ROI width is "
            java.lang.String r5 = "Transition width is "
            if (r1 != r2) goto L_0x003b
            com.jumio.core.extraction.JumioRect r1 = r6.f56450f
            int r1 = r1.width()
            int r9 = r9 * r8
            int r1 = r1 - r9
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            r8.append(r1)
            r8.append(r4)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            com.jumio.commons.log.Log.d((java.lang.String) r3, (java.lang.String) r8)
            if (r7 > r1) goto L_0x005e
            goto L_0x005d
        L_0x003b:
            com.jumio.core.extraction.JumioRect r1 = r6.f56450f
            int r1 = r1.width()
            int r9 = r9 * r8
            int r9 = r9 + r1
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            r8.append(r9)
            r8.append(r4)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            com.jumio.commons.log.Log.d((java.lang.String) r3, (java.lang.String) r8)
            if (r7 < r9) goto L_0x005e
        L_0x005d:
            r0 = 1
        L_0x005e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.liveness.d.a(int, jumio.liveness.a, int):boolean");
    }
}
