package com.hbg.lib.common.glide;

import android.graphics.drawable.PictureDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import com.caverock.androidsvg.SVG;
import u3.a;
import z3.c;

public class SvgDrawableTranscoder implements c<SVG, PictureDrawable> {
    public r<PictureDrawable> a(r<SVG> rVar, Options options) {
        return new a(new PictureDrawable(rVar.get().n()));
    }
}
