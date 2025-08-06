package com.huobi.woodpecker.kalle.connect.http;

import com.google.common.net.HttpHeaders;
import com.huobi.woodpecker.kalle.Headers;
import com.huobi.woodpecker.kalle.RequestMethod;
import com.huobi.woodpecker.kalle.Response;
import com.huobi.woodpecker.kalle.Url;
import com.huobi.woodpecker.kalle.c;
import com.huobi.woodpecker.kalle.k;
import com.huobi.woodpecker.kalle.q;
import com.huobi.woodpecker.kalle.util.IOUtils;
import java.io.IOException;
import xu.d;
import yu.c;

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
            kVar = ((c.C0162c) ((c.C0162c) ((c.C0162c) com.huobi.woodpecker.kalle.c.m(i11, h11).i(c11)).n(request.f())).m(request.d())).o();
        } else {
            kVar = ((q.c) q.m(i11, h11).i(c11)).k();
        }
        IOUtils.a(a11);
        return cVar.a(kVar);
    }
}
