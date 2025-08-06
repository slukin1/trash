package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import m1.a;
import okio.Okio;

public class j extends f {
    public j(Context context) {
        super(context);
    }

    public static int k(Uri uri) throws IOException {
        return new a(uri.getPath()).i("Orientation", 1);
    }

    public boolean c(q qVar) {
        return "file".equals(qVar.f30085d.getScheme());
    }

    public RequestHandler.a f(q qVar, int i11) throws IOException {
        return new RequestHandler.a((Bitmap) null, Okio.source(j(qVar)), Picasso.LoadedFrom.DISK, k(qVar.f30085d));
    }
}
