package com.huobi.kalle.connect.http;

import com.google.common.net.HttpHeaders;
import com.huobi.kalle.Headers;
import com.huobi.kalle.RequestMethod;
import com.huobi.kalle.Response;
import com.huobi.kalle.Url;
import com.huobi.kalle.b;
import com.huobi.kalle.k;
import com.huobi.kalle.p;
import com.huobi.kalle.util.IOUtils;
import hm.d;
import im.c;
import java.io.IOException;

public class RedirectInterceptor implements d {
    public Response a(c cVar) throws IOException {
        k kVar;
        k request = cVar.request();
        Response a11 = cVar.a(request);
        if (!a11.f()) {
            return a11;
        }
        Url i11 = request.l().i(a11.e().B());
        Headers c11 = request.c();
        c11.F(HttpHeaders.COOKIE);
        RequestMethod h11 = request.h();
        if (h11.allowBody()) {
            kVar = ((b.c) ((b.c) ((b.c) b.m(i11, h11).i(c11)).n(request.f())).m(request.d())).o();
        } else {
            kVar = ((p.c) p.m(i11, h11).i(c11)).k();
        }
        IOUtils.a(a11);
        return cVar.a(kVar);
    }
}
