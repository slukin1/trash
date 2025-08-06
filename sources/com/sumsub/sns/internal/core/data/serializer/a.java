package com.sumsub.sns.internal.core.data.serializer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class a implements b<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32955a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final f f32956b = SerialDescriptorsKt.a("DateSerializer", e.i.f57638a);

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f32957c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);

    /* renamed from: a */
    public void serialize(d dVar, Date date) {
        dVar.v(f32957c.format(date));
    }

    public f getDescriptor() {
        return f32956b;
    }

    /* renamed from: a */
    public Date deserialize(c cVar) {
        try {
            Date parse = f32957c.parse(cVar.q());
            if (parse == null) {
                return new Date();
            }
            return parse;
        } catch (Throwable unused) {
            return new Date();
        }
    }
}
