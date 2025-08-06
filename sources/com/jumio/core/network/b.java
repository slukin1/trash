package com.jumio.core.network;

import com.jumio.commons.log.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.io.a;

public final class b extends DownloadTask<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final File f39436g;

    public b(String str, File file, int i11) {
        super(str, i11);
        this.f39436g = file;
    }

    public final Object processInputStream(InputStream inputStream, int i11) {
        boolean z11 = false;
        if (inputStream != null) {
            try {
                a.b(inputStream, new FileOutputStream(this.f39436g), 0, 2, (Object) null);
            } catch (Exception e11) {
                Log.printStackTrace(e11);
            }
        }
        z11 = true;
        return Boolean.valueOf(z11);
    }
}
