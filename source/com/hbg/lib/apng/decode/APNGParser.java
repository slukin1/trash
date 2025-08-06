package com.hbg.lib.apng.decode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import z5.a;

public class APNGParser {

    public static class FormatException extends IOException {
        public FormatException() {
            super("APNG Format error");
        }
    }

    public static List<d> a(a aVar) throws IOException {
        if (!aVar.d("PNG") || !aVar.d("\r\n\u001a\n")) {
            throw new FormatException();
        }
        ArrayList arrayList = new ArrayList();
        while (aVar.available() > 0) {
            arrayList.add(b(aVar));
        }
        return arrayList;
    }

    public static d b(a aVar) throws IOException {
        d dVar;
        int b11 = aVar.b();
        int f11 = aVar.f();
        int e11 = aVar.e();
        if (e11 == a.f66167g) {
            dVar = new a();
        } else if (e11 == e.f66190n) {
            dVar = new e();
        } else if (e11 == f.f66200f) {
            dVar = new f();
        } else if (e11 == h.f66208e) {
            dVar = new h();
        } else if (e11 == i.f66209e) {
            dVar = new i();
        } else if (e11 == j.f66210h) {
            dVar = new j();
        } else {
            dVar = new d();
        }
        dVar.f66189d = b11;
        dVar.f66187b = e11;
        dVar.f66186a = f11;
        dVar.c(aVar);
        dVar.f66188c = aVar.f();
        return dVar;
    }
}
