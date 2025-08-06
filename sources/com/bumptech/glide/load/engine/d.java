package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.a;
import java.io.File;

public class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final n3.a<DataType> f63803a;

    /* renamed from: b  reason: collision with root package name */
    public final DataType f63804b;

    /* renamed from: c  reason: collision with root package name */
    public final Options f63805c;

    public d(n3.a<DataType> aVar, DataType datatype, Options options) {
        this.f63803a = aVar;
        this.f63804b = datatype;
        this.f63805c = options;
    }

    public boolean a(File file) {
        return this.f63803a.a(this.f63804b, file, this.f63805c);
    }
}
