package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import java.util.Map;

public final /* synthetic */ class c {
    static {
        ExtractorsFactory extractorsFactory = ExtractorsFactory.EMPTY;
    }

    public static Extractor[] a(ExtractorsFactory extractorsFactory, Uri uri, Map map) {
        return extractorsFactory.createExtractors();
    }

    public static /* synthetic */ Extractor[] c() {
        return new Extractor[0];
    }
}
