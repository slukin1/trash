package com.jumio.core.data.document;

import d10.l;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

public final class a extends Lambda implements l<JSONObject, PhysicalDocumentType> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f39127a = new a();

    public a() {
        super(1);
    }

    public final Object invoke(Object obj) {
        return new PhysicalDocumentType((JSONObject) obj);
    }
}
