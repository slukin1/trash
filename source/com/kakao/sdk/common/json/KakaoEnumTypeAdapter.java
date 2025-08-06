package com.kakao.sdk.common.json;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.x;
import yw.c;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u0004\u0018\u00018\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/kakao/sdk/common/json/KakaoEnumTypeAdapter;", "T", "Lcom/google/gson/TypeAdapter;", "Lcom/google/gson/stream/JsonWriter;", "out", "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "Lcom/google/gson/stream/JsonReader;", "in", "read", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "enumClass", "<init>", "(Ljava/lang/Class;)V", "common_release"}, k = 1, mv = {1, 6, 0})
public final class KakaoEnumTypeAdapter<T> extends TypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<T> f25086a;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25087a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            iArr[JsonToken.NUMBER.ordinal()] = 1;
            iArr[JsonToken.STRING.ordinal()] = 2;
            f25087a = iArr;
        }
    }

    public KakaoEnumTypeAdapter(Class<T> cls) {
        this.f25086a = cls;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T read(com.google.gson.stream.JsonReader r12) {
        /*
            r11 = this;
            r0 = 0
            if (r12 != 0) goto L_0x0005
            r1 = r0
            goto L_0x0009
        L_0x0005:
            com.google.gson.stream.JsonToken r1 = r12.peek()
        L_0x0009:
            com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.NULL
            if (r1 != r2) goto L_0x0011
            r12.nextNull()
            return r0
        L_0x0011:
            if (r12 != 0) goto L_0x0015
            r1 = r0
            goto L_0x0019
        L_0x0015:
            com.google.gson.stream.JsonToken r1 = r12.peek()
        L_0x0019:
            if (r1 != 0) goto L_0x001d
            r1 = -1
            goto L_0x0025
        L_0x001d:
            int[] r2 = com.kakao.sdk.common.json.KakaoEnumTypeAdapter.a.f25087a
            int r1 = r1.ordinal()
            r1 = r2[r1]
        L_0x0025:
            r2 = 1
            if (r1 == r2) goto L_0x003b
            r2 = 2
            if (r1 == r2) goto L_0x0031
            kotlin.Pair r12 = new kotlin.Pair
            r12.<init>(r0, r0)
            goto L_0x0049
        L_0x0031:
            kotlin.Pair r1 = new kotlin.Pair
            java.lang.String r12 = r12.nextString()
            r1.<init>(r0, r12)
            goto L_0x0048
        L_0x003b:
            kotlin.Pair r1 = new kotlin.Pair
            long r2 = r12.nextLong()
            java.lang.Long r12 = java.lang.Long.valueOf(r2)
            r1.<init>(r12, r0)
        L_0x0048:
            r12 = r1
        L_0x0049:
            java.lang.Class<T> r1 = r11.f25086a
            java.lang.Object[] r1 = r1.getEnumConstants()
            if (r1 != 0) goto L_0x0053
            goto L_0x00d7
        L_0x0053:
            r2 = 0
            int r3 = r1.length
        L_0x0055:
            if (r2 >= r3) goto L_0x00d7
            r0 = r1[r2]
            int r2 = r2 + 1
            if (r0 == 0) goto L_0x00c9
            r4 = r0
            java.lang.Enum r4 = (java.lang.Enum) r4     // Catch:{ NoSuchFieldException -> 0x00c7 }
            java.lang.String r4 = r4.name()     // Catch:{ NoSuchFieldException -> 0x00c7 }
            java.lang.Class<T> r5 = r11.f25086a     // Catch:{ NoSuchFieldException -> 0x00c7 }
            java.lang.reflect.Field r5 = r5.getField(r4)     // Catch:{ NoSuchFieldException -> 0x00c7 }
            java.lang.Object r6 = r12.getFirst()     // Catch:{ NoSuchFieldException -> 0x00c7 }
            if (r6 == 0) goto L_0x0094
            java.lang.Class<com.google.gson.annotations.SerializedName> r4 = com.google.gson.annotations.SerializedName.class
            java.lang.annotation.Annotation r4 = r5.getAnnotation(r4)     // Catch:{ NoSuchFieldException -> 0x00c7 }
            com.google.gson.annotations.SerializedName r4 = (com.google.gson.annotations.SerializedName) r4     // Catch:{ NoSuchFieldException -> 0x00c7 }
            if (r4 == 0) goto L_0x00be
            java.lang.Object r6 = r12.getFirst()     // Catch:{ NoSuchFieldException -> 0x00c7 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ NoSuchFieldException -> 0x00c7 }
            java.lang.String r4 = r4.value()     // Catch:{ NoSuchFieldException -> 0x00c7 }
            long r7 = java.lang.Long.parseLong(r4)     // Catch:{ NoSuchFieldException -> 0x00c7 }
            if (r6 != 0) goto L_0x008b
            goto L_0x00be
        L_0x008b:
            long r9 = r6.longValue()     // Catch:{ NoSuchFieldException -> 0x00c7 }
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x00be
            return r0
        L_0x0094:
            java.lang.Object r6 = r12.getSecond()     // Catch:{ NoSuchFieldException -> 0x00c7 }
            if (r6 == 0) goto L_0x00be
            java.lang.Object r6 = r12.getSecond()     // Catch:{ NoSuchFieldException -> 0x00c7 }
            boolean r4 = kotlin.jvm.internal.x.b(r6, r4)     // Catch:{ NoSuchFieldException -> 0x00c7 }
            if (r4 == 0) goto L_0x00a5
            return r0
        L_0x00a5:
            java.lang.Class<com.google.gson.annotations.SerializedName> r4 = com.google.gson.annotations.SerializedName.class
            java.lang.annotation.Annotation r4 = r5.getAnnotation(r4)     // Catch:{ NoSuchFieldException -> 0x00c7 }
            com.google.gson.annotations.SerializedName r4 = (com.google.gson.annotations.SerializedName) r4     // Catch:{ NoSuchFieldException -> 0x00c7 }
            if (r4 == 0) goto L_0x00be
            java.lang.Object r6 = r12.getSecond()     // Catch:{ NoSuchFieldException -> 0x00c7 }
            java.lang.String r4 = r4.value()     // Catch:{ NoSuchFieldException -> 0x00c7 }
            boolean r4 = kotlin.jvm.internal.x.b(r6, r4)     // Catch:{ NoSuchFieldException -> 0x00c7 }
            if (r4 == 0) goto L_0x00be
            return r0
        L_0x00be:
            java.lang.Class<yw.e> r4 = yw.e.class
            java.lang.annotation.Annotation r4 = r5.getAnnotation(r4)     // Catch:{ NoSuchFieldException -> 0x00c7 }
            yw.e r4 = (yw.e) r4     // Catch:{ NoSuchFieldException -> 0x00c7 }
            goto L_0x0055
        L_0x00c7:
            r12 = move-exception
            goto L_0x00d1
        L_0x00c9:
            java.lang.NullPointerException r12 = new java.lang.NullPointerException     // Catch:{ NoSuchFieldException -> 0x00c7 }
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Enum<*>"
            r12.<init>(r0)     // Catch:{ NoSuchFieldException -> 0x00c7 }
            throw r12     // Catch:{ NoSuchFieldException -> 0x00c7 }
        L_0x00d1:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r12)
            throw r0
        L_0x00d7:
            if (r0 == 0) goto L_0x00da
            return r0
        L_0x00da:
            java.io.IOException r12 = new java.io.IOException
            java.lang.String r0 = "No matching enum field"
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.common.json.KakaoEnumTypeAdapter.read(com.google.gson.stream.JsonReader):java.lang.Object");
    }

    public void write(JsonWriter jsonWriter, T t11) {
        if (t11 != null) {
            boolean isAnnotationPresent = this.f25086a.isAnnotationPresent(c.class);
            Object[] enumConstants = this.f25086a.getEnumConstants();
            if (enumConstants != null) {
                int i11 = 0;
                int length = enumConstants.length;
                while (i11 < length) {
                    Object obj = enumConstants[i11];
                    i11++;
                    if (obj != null) {
                        try {
                            SerializedName serializedName = (SerializedName) this.f25086a.getField(((Enum) obj).name()).getAnnotation(SerializedName.class);
                            if (serializedName != null && x.b(obj, t11)) {
                                if (isAnnotationPresent) {
                                    if (jsonWriter != null) {
                                        jsonWriter.value((Number) Integer.valueOf(Integer.parseInt(serializedName.value())));
                                        return;
                                    }
                                    return;
                                } else if (jsonWriter != null) {
                                    jsonWriter.value(serializedName.value());
                                    return;
                                } else {
                                    return;
                                }
                            }
                        } catch (NoSuchFieldException e11) {
                            throw new IOException(e11);
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
                    }
                }
            }
            if (jsonWriter != null) {
                jsonWriter.value(t11.toString());
            }
        } else if (jsonWriter != null) {
            jsonWriter.nullValue();
        }
    }
}
