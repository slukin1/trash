package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import m1.a;

public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
    public ImageHeaderParser.ImageType a(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public int b(InputStream inputStream, b bVar) throws IOException {
        int i11 = new a(inputStream).i("Orientation", 1);
        if (i11 == 0) {
            return -1;
        }
        return i11;
    }

    public ImageHeaderParser.ImageType c(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
