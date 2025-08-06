package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import java.io.File;
import n3.e;
import x3.a;

public class FileDecoder implements e<File, File> {
    /* renamed from: c */
    public r<File> b(File file, int i11, int i12, Options options) {
        return new a(file);
    }

    /* renamed from: d */
    public boolean a(File file, Options options) {
        return true;
    }
}
