package com.sumsub.sentry;

import com.sumsub.sns.internal.core.common.x;
import com.sumsub.sns.internal.log.c;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.p;
import kotlinx.serialization.h;
import kotlinx.serialization.json.a;
import kotlinx.serialization.modules.d;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f30426a = new m();

    /* renamed from: b  reason: collision with root package name */
    public static final a f30427b = x.a(false, 1, (Object) null);

    public final /* synthetic */ <T> String a(T t11) {
        a a11 = f30427b;
        d a12 = a11.a();
        kotlin.jvm.internal.x.f(6, "T");
        MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
        return a11.b(h.d(a12, (p) null), t11);
    }

    public final /* synthetic */ <T> T a(String str) {
        a a11 = f30427b;
        d a12 = a11.a();
        kotlin.jvm.internal.x.f(6, "T");
        MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
        return a11.c(h.d(a12, (p) null), str);
    }

    public final void a(v vVar, OutputStream outputStream) {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(outputStream), "UTF-8"));
        try {
            w a11 = vVar.a();
            a a12 = f30427b;
            d a13 = a12.a();
            p n11 = Reflection.n(w.class);
            MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
            bufferedWriter.write(a12.b(h.d(a13, n11), a11));
            bufferedWriter.write("\n");
            for (x xVar : vVar.b()) {
                y b11 = xVar.b();
                a a14 = f30427b;
                d a15 = a14.a();
                p n12 = Reflection.n(y.class);
                MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                bufferedWriter.write(a14.b(h.d(a15, n12), b11));
                bufferedWriter.write("\n");
                bufferedWriter.flush();
                outputStream.write(xVar.a());
                bufferedWriter.write("\n");
            }
            bufferedWriter.flush();
        } catch (Exception e11) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a16 = c.a(f30426a);
            com.sumsub.log.logger.a.b(aVar, a16, "Failed to serialize item: " + xVar + 10 + e11, (Throwable) null, 4, (Object) null);
        } catch (Throwable th2) {
            bufferedWriter.flush();
            throw th2;
        }
    }
}
