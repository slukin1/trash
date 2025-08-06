package yx;

import android.graphics.Path;
import com.xiaomi.mipush.sdk.Constants;
import java.util.StringTokenizer;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¨\u0006\u000f"}, d2 = {"Lyx/b;", "", "Landroid/graphics/Path;", "toPath", "", "a", "finalPath", "", "method", "Ljava/util/StringTokenizer;", "args", "b", "originValue", "<init>", "(Ljava/lang/String;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f29419a;

    /* renamed from: b  reason: collision with root package name */
    public Path f29420b;

    public b(String str) {
        this.f29419a = StringsKt__StringsKt.R(str, Constants.ACCEPT_TIME_SEPARATOR_SP, false, 2, (Object) null) ? StringsKt__StringsJVMKt.G(str, Constants.ACCEPT_TIME_SEPARATOR_SP, " ", false, 4, (Object) null) : str;
    }

    public final void a(Path path) {
        Path path2 = this.f29420b;
        if (path2 != null) {
            path.set(path2);
            return;
        }
        Path path3 = new Path();
        StringTokenizer stringTokenizer = new StringTokenizer(this.f29419a, "MLHVCSQRAZmlhvcsqraz", true);
        String str = "";
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (!(nextToken.length() == 0)) {
                if (c.f29421a.contains(nextToken)) {
                    if (x.b(nextToken, "Z") || x.b(nextToken, "z")) {
                        b(path3, nextToken, new StringTokenizer("", ""));
                    }
                    str = nextToken;
                } else {
                    b(path3, str, new StringTokenizer(nextToken, " "));
                }
            }
        }
        this.f29420b = path3;
        path.set(path3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.graphics.Path r16, java.lang.String r17, java.util.StringTokenizer r18) {
        /*
            r15 = this;
            r7 = r16
            r8 = r17
            r0 = 0
            r9 = 0
            r10 = r0
            r1 = r9
            r2 = r1
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
        L_0x000d:
            boolean r11 = r18.hasMoreTokens()     // Catch:{ Exception -> 0x004f }
            if (r11 == 0) goto L_0x004f
            java.lang.String r11 = r18.nextToken()     // Catch:{ Exception -> 0x004f }
            int r12 = r11.length()     // Catch:{ Exception -> 0x004f }
            r13 = 1
            if (r12 != 0) goto L_0x0020
            r12 = r13
            goto L_0x0021
        L_0x0020:
            r12 = r0
        L_0x0021:
            if (r12 == 0) goto L_0x0024
            goto L_0x000d
        L_0x0024:
            if (r10 != 0) goto L_0x002a
            float r1 = java.lang.Float.parseFloat(r11)     // Catch:{ Exception -> 0x004f }
        L_0x002a:
            if (r10 != r13) goto L_0x0030
            float r2 = java.lang.Float.parseFloat(r11)     // Catch:{ Exception -> 0x004f }
        L_0x0030:
            r12 = 2
            if (r10 != r12) goto L_0x0037
            float r3 = java.lang.Float.parseFloat(r11)     // Catch:{ Exception -> 0x004f }
        L_0x0037:
            r12 = 3
            if (r10 != r12) goto L_0x003e
            float r4 = java.lang.Float.parseFloat(r11)     // Catch:{ Exception -> 0x004f }
        L_0x003e:
            r12 = 4
            if (r10 != r12) goto L_0x0045
            float r5 = java.lang.Float.parseFloat(r11)     // Catch:{ Exception -> 0x004f }
        L_0x0045:
            r12 = 5
            if (r10 != r12) goto L_0x004c
            float r6 = java.lang.Float.parseFloat(r11)     // Catch:{ Exception -> 0x004f }
        L_0x004c:
            int r10 = r10 + 1
            goto L_0x000d
        L_0x004f:
            r10 = r1
            r11 = r2
            r12 = r3
            r13 = r4
            zx.b r0 = new zx.b
            r0.<init>(r9, r9, r9)
            java.lang.String r1 = "M"
            boolean r1 = kotlin.jvm.internal.x.b(r8, r1)
            if (r1 == 0) goto L_0x0069
            r7.moveTo(r10, r11)
            zx.b r0 = new zx.b
            r0.<init>(r10, r11, r9)
            goto L_0x0085
        L_0x0069:
            java.lang.String r1 = "m"
            boolean r1 = kotlin.jvm.internal.x.b(r8, r1)
            if (r1 == 0) goto L_0x0085
            r7.rMoveTo(r10, r11)
            zx.b r1 = new zx.b
            float r2 = r0.a()
            float r2 = r2 + r10
            float r0 = r0.b()
            float r0 = r0 + r11
            r1.<init>(r2, r0, r9)
            r14 = r1
            goto L_0x0086
        L_0x0085:
            r14 = r0
        L_0x0086:
            java.lang.String r0 = "L"
            boolean r0 = kotlin.jvm.internal.x.b(r8, r0)
            if (r0 == 0) goto L_0x0092
            r7.lineTo(r10, r11)
            goto L_0x009d
        L_0x0092:
            java.lang.String r0 = "l"
            boolean r0 = kotlin.jvm.internal.x.b(r8, r0)
            if (r0 == 0) goto L_0x009d
            r7.rLineTo(r10, r11)
        L_0x009d:
            java.lang.String r0 = "C"
            boolean r0 = kotlin.jvm.internal.x.b(r8, r0)
            if (r0 == 0) goto L_0x00af
            r0 = r16
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r0.cubicTo(r1, r2, r3, r4, r5, r6)
            goto L_0x00c0
        L_0x00af:
            java.lang.String r0 = "c"
            boolean r0 = kotlin.jvm.internal.x.b(r8, r0)
            if (r0 == 0) goto L_0x00c0
            r0 = r16
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r0.rCubicTo(r1, r2, r3, r4, r5, r6)
        L_0x00c0:
            java.lang.String r0 = "Q"
            boolean r0 = kotlin.jvm.internal.x.b(r8, r0)
            if (r0 == 0) goto L_0x00cc
            r7.quadTo(r10, r11, r12, r13)
            goto L_0x00d7
        L_0x00cc:
            java.lang.String r0 = "q"
            boolean r0 = kotlin.jvm.internal.x.b(r8, r0)
            if (r0 == 0) goto L_0x00d7
            r7.rQuadTo(r10, r11, r12, r13)
        L_0x00d7:
            java.lang.String r0 = "H"
            boolean r0 = kotlin.jvm.internal.x.b(r8, r0)
            if (r0 == 0) goto L_0x00e7
            float r0 = r14.b()
            r7.lineTo(r10, r0)
            goto L_0x00f2
        L_0x00e7:
            java.lang.String r0 = "h"
            boolean r0 = kotlin.jvm.internal.x.b(r8, r0)
            if (r0 == 0) goto L_0x00f2
            r7.rLineTo(r10, r9)
        L_0x00f2:
            java.lang.String r0 = "V"
            boolean r0 = kotlin.jvm.internal.x.b(r8, r0)
            if (r0 == 0) goto L_0x0102
            float r0 = r14.a()
            r7.lineTo(r0, r10)
            goto L_0x010d
        L_0x0102:
            java.lang.String r0 = "v"
            boolean r0 = kotlin.jvm.internal.x.b(r8, r0)
            if (r0 == 0) goto L_0x010d
            r7.rLineTo(r9, r10)
        L_0x010d:
            java.lang.String r0 = "Z"
            boolean r0 = kotlin.jvm.internal.x.b(r8, r0)
            if (r0 == 0) goto L_0x0119
            r16.close()
            goto L_0x0124
        L_0x0119:
            java.lang.String r0 = "z"
            boolean r0 = kotlin.jvm.internal.x.b(r8, r0)
            if (r0 == 0) goto L_0x0124
            r16.close()
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: yx.b.b(android.graphics.Path, java.lang.String, java.util.StringTokenizer):void");
    }
}
