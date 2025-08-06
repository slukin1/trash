package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Options;
import f4.h;
import java.util.Collections;
import java.util.List;
import n3.b;

public interface d<Model, Data> {

    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final b f63993a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f63994b;

        /* renamed from: c  reason: collision with root package name */
        public final o3.d<Data> f63995c;

        public a(b bVar, o3.d<Data> dVar) {
            this(bVar, Collections.emptyList(), dVar);
        }

        public a(b bVar, List<b> list, o3.d<Data> dVar) {
            this.f63993a = (b) h.d(bVar);
            this.f63994b = (List) h.d(list);
            this.f63995c = (o3.d) h.d(dVar);
        }
    }

    a<Data> a(Model model, int i11, int i12, Options options);

    boolean b(Model model);
}
