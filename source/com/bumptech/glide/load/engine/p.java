package com.bumptech.glide.load.engine;

import androidx.core.util.e;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.a;
import com.bumptech.glide.load.engine.g;
import f4.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<Data> f63905a;

    /* renamed from: b  reason: collision with root package name */
    public final e<List<Throwable>> f63906b;

    /* renamed from: c  reason: collision with root package name */
    public final List<? extends g<Data, ResourceType, Transcode>> f63907c;

    /* renamed from: d  reason: collision with root package name */
    public final String f63908d;

    public p(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<g<Data, ResourceType, Transcode>> list, e<List<Throwable>> eVar) {
        this.f63905a = cls;
        this.f63906b = eVar;
        this.f63907c = (List) h.c(list);
        this.f63908d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public r<Transcode> a(a<Data> aVar, Options options, int i11, int i12, g.a<ResourceType> aVar2) throws GlideException {
        List list = (List) h.d(this.f63906b.acquire());
        try {
            return b(aVar, options, i11, i12, aVar2, list);
        } finally {
            this.f63906b.release(list);
        }
    }

    public final r<Transcode> b(a<Data> aVar, Options options, int i11, int i12, g.a<ResourceType> aVar2, List<Throwable> list) throws GlideException {
        List<Throwable> list2 = list;
        int size = this.f63907c.size();
        r<Transcode> rVar = null;
        for (int i13 = 0; i13 < size; i13++) {
            try {
                rVar = ((g) this.f63907c.get(i13)).a(aVar, i11, i12, options, aVar2);
            } catch (GlideException e11) {
                list2.add(e11);
            }
            if (rVar != null) {
                break;
            }
        }
        if (rVar != null) {
            return rVar;
        }
        throw new GlideException(this.f63908d, (List<Throwable>) new ArrayList(list2));
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f63907c.toArray()) + '}';
    }
}
