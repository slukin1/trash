package com.hbg.lib.common.glide;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import java.io.IOException;
import java.io.InputStream;
import n3.e;
import u3.a;

public class SvgDecoder implements e<InputStream, SVG> {
    /* renamed from: c */
    public r<SVG> b(InputStream inputStream, int i11, int i12, Options options) throws IOException {
        try {
            return new a(SVG.h(inputStream));
        } catch (SVGParseException e11) {
            throw new IOException("Cannot load SVG from stream", e11);
        }
    }

    /* renamed from: d */
    public boolean a(InputStream inputStream, Options options) {
        return true;
    }
}
