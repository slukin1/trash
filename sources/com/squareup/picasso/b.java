package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import okio.Okio;

public class b extends RequestHandler {

    /* renamed from: d  reason: collision with root package name */
    public static final int f29999d = 22;

    /* renamed from: a  reason: collision with root package name */
    public final Context f30000a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f30001b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f30002c;

    public b(Context context) {
        this.f30000a = context;
    }

    public static String j(q qVar) {
        return qVar.f30085d.toString().substring(f29999d);
    }

    public boolean c(q qVar) {
        Uri uri = qVar.f30085d;
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    public RequestHandler.a f(q qVar, int i11) throws IOException {
        if (this.f30002c == null) {
            synchronized (this.f30001b) {
                if (this.f30002c == null) {
                    this.f30002c = this.f30000a.getAssets();
                }
            }
        }
        return new RequestHandler.a(Okio.source(this.f30002c.open(j(qVar))), Picasso.LoadedFrom.DISK);
    }
}
