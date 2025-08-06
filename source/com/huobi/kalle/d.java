package com.huobi.kalle;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.huobi.kalle.util.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class d extends BasicOutData<d> implements a {

    /* renamed from: b  reason: collision with root package name */
    public File f74696b;

    public d(File file) {
        this.f74696b = file;
    }

    public void a(OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(this.f74696b);
        IOUtils.j(fileInputStream, outputStream);
        IOUtils.a(fileInputStream);
    }

    public String contentType() {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f74696b.getName()));
        return TextUtils.isEmpty(mimeTypeFromExtension) ? "application/octet-stream" : mimeTypeFromExtension;
    }

    public long length() {
        return this.f74696b.length();
    }

    public String name() {
        return this.f74696b.getName();
    }
}
