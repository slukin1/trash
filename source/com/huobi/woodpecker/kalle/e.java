package com.huobi.woodpecker.kalle;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.huobi.woodpecker.kalle.util.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class e extends BasicOutData<e> implements b {

    /* renamed from: b  reason: collision with root package name */
    public File f21054b;

    public e(File file) {
        this.f21054b = file;
    }

    public void a(OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(this.f21054b);
        IOUtils.j(fileInputStream, outputStream);
        IOUtils.a(fileInputStream);
    }

    public String contentType() {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f21054b.getName()));
        return TextUtils.isEmpty(mimeTypeFromExtension) ? "application/octet-stream" : mimeTypeFromExtension;
    }

    public long length() {
        return this.f21054b.length();
    }

    public String name() {
        return this.f21054b.getName();
    }
}
