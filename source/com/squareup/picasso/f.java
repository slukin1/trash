package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import okio.Okio;

public class f extends RequestHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Context f30033a;

    public f(Context context) {
        this.f30033a = context;
    }

    public boolean c(q qVar) {
        return "content".equals(qVar.f30085d.getScheme());
    }

    public RequestHandler.a f(q qVar, int i11) throws IOException {
        return new RequestHandler.a(Okio.source(j(qVar)), Picasso.LoadedFrom.DISK);
    }

    public InputStream j(q qVar) throws FileNotFoundException {
        return this.f30033a.getContentResolver().openInputStream(qVar.f30085d);
    }
}
