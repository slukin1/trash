package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;

public class s extends RequestHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Context f30132a;

    public s(Context context) {
        this.f30132a = context;
    }

    public static Bitmap j(Resources resources, int i11, q qVar) {
        BitmapFactory.Options d11 = RequestHandler.d(qVar);
        if (RequestHandler.g(d11)) {
            BitmapFactory.decodeResource(resources, i11, d11);
            RequestHandler.b(qVar.f30089h, qVar.f30090i, d11, qVar);
        }
        return BitmapFactory.decodeResource(resources, i11, d11);
    }

    public boolean c(q qVar) {
        if (qVar.f30086e != 0) {
            return true;
        }
        return "android.resource".equals(qVar.f30085d.getScheme());
    }

    public RequestHandler.a f(q qVar, int i11) throws IOException {
        Resources m11 = y.m(this.f30132a, qVar);
        return new RequestHandler.a(j(m11, y.l(m11, qVar), qVar), Picasso.LoadedFrom.DISK);
    }
}
