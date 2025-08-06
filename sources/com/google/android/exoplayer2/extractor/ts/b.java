package com.google.android.exoplayer2.extractor.ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.c;
import java.util.Map;

public final /* synthetic */ class b implements ExtractorsFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b f65904a = new b();

    public final Extractor[] createExtractors() {
        return Ac4Extractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return c.a(this, uri, map);
    }
}
