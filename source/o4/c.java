package o4;

import android.content.Context;
import com.example.flutterimagecompress.FlutterImageCompressPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
import s4.a;

public final class c extends g {

    /* renamed from: f  reason: collision with root package name */
    public final MethodCall f66536f;

    public c(MethodCall methodCall, MethodChannel.Result result) {
        super(result);
        this.f66536f = methodCall;
    }

    public static final void h(c cVar, Context context) {
        int i11;
        int i12;
        c cVar2 = cVar;
        List list = (List) cVar2.f66536f.arguments;
        int i13 = 0;
        String str = (String) list.get(0);
        int intValue = ((Integer) list.get(1)).intValue();
        int intValue2 = ((Integer) list.get(2)).intValue();
        int intValue3 = ((Integer) list.get(3)).intValue();
        int intValue4 = ((Integer) list.get(4)).intValue();
        boolean booleanValue = ((Boolean) list.get(5)).booleanValue();
        int intValue5 = ((Integer) list.get(6)).intValue();
        boolean booleanValue2 = ((Boolean) list.get(7)).booleanValue();
        int intValue6 = ((Integer) list.get(8)).intValue();
        int intValue7 = ((Integer) list.get(9)).intValue();
        a a11 = r4.a.f66597a.a(intValue5);
        if (a11 == null) {
            u4.a.a(cVar2, "No support format.");
            cVar2.c((Object) null);
            return;
        }
        if (booleanValue) {
            i13 = p4.a.f66556a.b(FilesKt__FileReadWriteKt.a(new File(str)));
        }
        if (i13 == 90 || i13 == 270) {
            i11 = intValue;
            i12 = intValue2;
        } else {
            i12 = intValue;
            i11 = intValue2;
        }
        int i14 = intValue4 + i13;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a11.b(context, str, byteArrayOutputStream, i12, i11, intValue3, i14, booleanValue2, intValue6, intValue7);
            cVar2.c(byteArrayOutputStream.toByteArray());
        } catch (Exception e11) {
            if (FlutterImageCompressPlugin.f64984d.a()) {
                e11.printStackTrace();
            }
            cVar2.c((Object) null);
        } catch (Throwable th2) {
            byteArrayOutputStream.close();
            throw th2;
        }
        byteArrayOutputStream.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00db A[Catch:{ all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void j(o4.c r16, android.content.Context r17) {
        /*
            r1 = r16
            io.flutter.plugin.common.MethodCall r0 = r1.f66536f
            java.lang.Object r0 = r0.arguments
            java.util.List r0 = (java.util.List) r0
            r2 = 0
            java.lang.Object r3 = r0.get(r2)
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6
            r3 = 1
            java.lang.Object r3 = r0.get(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = 2
            java.lang.Object r4 = r0.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r5 = 3
            java.lang.Object r5 = r0.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r10 = r5.intValue()
            r5 = 4
            java.lang.Object r5 = r0.get(r5)
            r15 = r5
            java.lang.String r15 = (java.lang.String) r15
            r5 = 5
            java.lang.Object r5 = r0.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r7 = 6
            java.lang.Object r7 = r0.get(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0060
            java.io.File r2 = new java.io.File
            r2.<init>(r6)
            byte[] r2 = kotlin.io.FilesKt__FileReadWriteKt.a(r2)
            p4.a r7 = p4.a.f66556a
            int r2 = r7.b(r2)
        L_0x0060:
            r7 = 7
            java.lang.Object r7 = r0.get(r7)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r8 = 8
            java.lang.Object r8 = r0.get(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r12 = r8.booleanValue()
            r8 = 9
            java.lang.Object r8 = r0.get(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r13 = r8.intValue()
            r8 = 10
            java.lang.Object r0 = r0.get(r8)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r14 = r0.intValue()
            r4.a r0 = r4.a.f66597a
            s4.a r0 = r0.a(r7)
            r11 = 0
            if (r0 != 0) goto L_0x00a1
            java.lang.String r0 = "No support format."
            u4.a.a(r1, r0)
            r1.c(r11)
            return
        L_0x00a1:
            r7 = 90
            if (r2 == r7) goto L_0x00ac
            r7 = 270(0x10e, float:3.78E-43)
            if (r2 == r7) goto L_0x00ac
            r8 = r3
            r9 = r4
            goto L_0x00ae
        L_0x00ac:
            r9 = r3
            r8 = r4
        L_0x00ae:
            int r2 = r2 + r5
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            r4.<init>(r15)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            r4 = r0
            r5 = r17
            r7 = r3
            r11 = r2
            r4.b(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00cb, all -> 0x00c8 }
            r1.c(r15)     // Catch:{ Exception -> 0x00cb, all -> 0x00c8 }
            r3.close()
            goto L_0x00e7
        L_0x00c8:
            r0 = move-exception
            r11 = r3
            goto L_0x00e9
        L_0x00cb:
            r0 = move-exception
            r11 = r3
            goto L_0x00d3
        L_0x00ce:
            r0 = move-exception
            r11 = 0
            goto L_0x00e9
        L_0x00d1:
            r0 = move-exception
            r11 = 0
        L_0x00d3:
            com.example.flutterimagecompress.FlutterImageCompressPlugin$a r2 = com.example.flutterimagecompress.FlutterImageCompressPlugin.f64984d     // Catch:{ all -> 0x00e8 }
            boolean r2 = r2.a()     // Catch:{ all -> 0x00e8 }
            if (r2 == 0) goto L_0x00de
            r0.printStackTrace()     // Catch:{ all -> 0x00e8 }
        L_0x00de:
            r2 = 0
            r1.c(r2)     // Catch:{ all -> 0x00e8 }
            if (r11 == 0) goto L_0x00e7
            r11.close()
        L_0x00e7:
            return
        L_0x00e8:
            r0 = move-exception
        L_0x00e9:
            if (r11 == 0) goto L_0x00ee
            r11.close()
        L_0x00ee:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.c.j(o4.c, android.content.Context):void");
    }

    public final void g(Context context) {
        g.f66538c.a().execute(new b(this, context));
    }

    public final void i(Context context) {
        g.f66538c.a().execute(new a(this, context));
    }
}
