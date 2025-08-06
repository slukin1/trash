package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.Options;
import f4.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import n3.e;
import z3.c;

public class g<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<DataType> f63824a;

    /* renamed from: b  reason: collision with root package name */
    public final List<? extends e<DataType, ResourceType>> f63825b;

    /* renamed from: c  reason: collision with root package name */
    public final c<ResourceType, Transcode> f63826c;

    /* renamed from: d  reason: collision with root package name */
    public final androidx.core.util.e<List<Throwable>> f63827d;

    /* renamed from: e  reason: collision with root package name */
    public final String f63828e;

    public interface a<ResourceType> {
        r<ResourceType> a(r<ResourceType> rVar);
    }

    public g(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends e<DataType, ResourceType>> list, c<ResourceType, Transcode> cVar, androidx.core.util.e<List<Throwable>> eVar) {
        this.f63824a = cls;
        this.f63825b = list;
        this.f63826c = cVar;
        this.f63827d = eVar;
        this.f63828e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public r<Transcode> a(com.bumptech.glide.load.data.a<DataType> aVar, int i11, int i12, Options options, a<ResourceType> aVar2) throws GlideException {
        return this.f63826c.a(aVar2.a(b(aVar, i11, i12, options)), options);
    }

    public final r<ResourceType> b(com.bumptech.glide.load.data.a<DataType> aVar, int i11, int i12, Options options) throws GlideException {
        List list = (List) h.d(this.f63827d.acquire());
        try {
            return c(aVar, i11, i12, options, list);
        } finally {
            this.f63827d.release(list);
        }
    }

    public final r<ResourceType> c(com.bumptech.glide.load.data.a<DataType> aVar, int i11, int i12, Options options, List<Throwable> list) throws GlideException {
        int size = this.f63825b.size();
        r<ResourceType> rVar = null;
        for (int i13 = 0; i13 < size; i13++) {
            e eVar = (e) this.f63825b.get(i13);
            try {
                if (eVar.a(aVar.c(), options)) {
                    rVar = eVar.b(aVar.c(), i11, i12, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e11) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + eVar, e11);
                }
                list.add(e11);
            }
            if (rVar != null) {
                break;
            }
        }
        if (rVar != null) {
            return rVar;
        }
        throw new GlideException(this.f63828e, (List<Throwable>) new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f63824a + ", decoders=" + this.f63825b + ", transcoder=" + this.f63826c + '}';
    }
}
