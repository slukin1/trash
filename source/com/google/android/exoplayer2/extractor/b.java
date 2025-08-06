package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import java.util.Map;

public final /* synthetic */ class b implements ExtractorsFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b f65889a = new b();

    public final Extractor[] createExtractors() {
        return c.c();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return c.a(this, uri, map);
    }
}
