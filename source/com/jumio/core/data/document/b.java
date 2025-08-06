package com.jumio.core.data.document;

import com.jumio.core.data.digitaldocument.DigitalDocumentType;
import d10.l;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

public final class b extends Lambda implements l<JSONObject, DigitalDocumentType> {

    /* renamed from: a  reason: collision with root package name */
    public static final b f39128a = new b();

    public b() {
        super(1);
    }

    public final Object invoke(Object obj) {
        return new DigitalDocumentType((JSONObject) obj);
    }
}
