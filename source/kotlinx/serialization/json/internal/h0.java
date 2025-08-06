package kotlinx.serialization.json.internal;

import java.lang.annotation.Annotation;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.d;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.g;
import kotlinx.serialization.internal.n0;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.a;

public final class h0 {
    public static final void b(h hVar) {
        if (hVar instanceof h.b) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        } else if (hVar instanceof e) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        } else if (hVar instanceof d) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
        }
    }

    public static final String c(f fVar, a aVar) {
        for (Annotation next : fVar.getAnnotations()) {
            if (next instanceof kotlinx.serialization.json.e) {
                return ((kotlinx.serialization.json.e) next).discriminator();
            }
        }
        return aVar.f().c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        r2 = kotlinx.serialization.json.i.l(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T d(kotlinx.serialization.json.f r4, kotlinx.serialization.a<? extends T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.serialization.internal.AbstractPolymorphicSerializer
            if (r0 == 0) goto L_0x0095
            kotlinx.serialization.json.a r0 = r4.d()
            kotlinx.serialization.json.JsonConfiguration r0 = r0.f()
            boolean r0 = r0.l()
            if (r0 == 0) goto L_0x0014
            goto L_0x0095
        L_0x0014:
            kotlinx.serialization.descriptors.f r0 = r5.getDescriptor()
            kotlinx.serialization.json.a r1 = r4.d()
            java.lang.String r0 = c(r0, r1)
            kotlinx.serialization.json.g r1 = r4.t()
            kotlinx.serialization.descriptors.f r2 = r5.getDescriptor()
            boolean r3 = r1 instanceof kotlinx.serialization.json.JsonObject
            if (r3 == 0) goto L_0x005c
            kotlinx.serialization.json.JsonObject r1 = (kotlinx.serialization.json.JsonObject) r1
            java.lang.Object r2 = r1.get(r0)
            kotlinx.serialization.json.g r2 = (kotlinx.serialization.json.g) r2
            if (r2 == 0) goto L_0x0041
            kotlinx.serialization.json.t r2 = kotlinx.serialization.json.i.l(r2)
            if (r2 == 0) goto L_0x0041
            java.lang.String r2 = r2.a()
            goto L_0x0042
        L_0x0041:
            r2 = 0
        L_0x0042:
            kotlinx.serialization.internal.AbstractPolymorphicSerializer r5 = (kotlinx.serialization.internal.AbstractPolymorphicSerializer) r5
            kotlinx.serialization.a r5 = r5.c(r4, r2)
            if (r5 == 0) goto L_0x0053
            kotlinx.serialization.json.a r4 = r4.d()
            java.lang.Object r4 = kotlinx.serialization.json.internal.o0.b(r4, r0, r1, r5)
            return r4
        L_0x0053:
            e(r2, r1)
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        L_0x005c:
            r4 = -1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Expected "
            r5.append(r0)
            java.lang.Class<kotlinx.serialization.json.JsonObject> r0 = kotlinx.serialization.json.JsonObject.class
            kotlin.reflect.c r0 = kotlin.jvm.internal.Reflection.b(r0)
            r5.append(r0)
            java.lang.String r0 = " as the serialized body of "
            r5.append(r0)
            java.lang.String r0 = r2.h()
            r5.append(r0)
            java.lang.String r0 = ", but had "
            r5.append(r0)
            java.lang.Class r0 = r1.getClass()
            kotlin.reflect.c r0 = kotlin.jvm.internal.Reflection.b(r0)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            kotlinx.serialization.json.internal.JsonDecodingException r4 = kotlinx.serialization.json.internal.w.e(r4, r5)
            throw r4
        L_0x0095:
            java.lang.Object r4 = r5.deserialize(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.h0.d(kotlinx.serialization.json.f, kotlinx.serialization.a):java.lang.Object");
    }

    public static final Void e(String str, JsonObject jsonObject) {
        String str2;
        if (str == null) {
            str2 = "missing class discriminator ('null')";
        } else {
            str2 = "class discriminator '" + str + '\'';
        }
        throw w.f(-1, "Polymorphic serializer was not found for " + str2, jsonObject.toString());
    }

    public static final void f(g<?> gVar, g<Object> gVar2, String str) {
        if ((gVar instanceof SealedClassSerializer) && n0.a(gVar2.getDescriptor()).contains(str)) {
            String h11 = gVar.getDescriptor().h();
            String h12 = gVar2.getDescriptor().h();
            throw new IllegalStateException(("Sealed class '" + h12 + "' cannot be serialized as base class '" + h11 + "' because it has property name that conflicts with JSON class discriminator '" + str + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
        }
    }
}
