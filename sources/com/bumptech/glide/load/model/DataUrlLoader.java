package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import o3.d;
import s3.d;

public final class DataUrlLoader<Model, Data> implements d<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final a<Data> f63950a;

    public static final class StreamFactory<Model> implements d<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final a<InputStream> f63951a = new a();

        public class a implements a<InputStream> {
            public a() {
            }

            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: d */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: e */
            public InputStream c(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        }

        public d<Model, InputStream> b(f fVar) {
            return new DataUrlLoader(this.f63951a);
        }

        public void teardown() {
        }
    }

    public interface a<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(String str) throws IllegalArgumentException;
    }

    public static final class b<Data> implements o3.d<Data> {

        /* renamed from: b  reason: collision with root package name */
        public final String f63953b;

        /* renamed from: c  reason: collision with root package name */
        public final a<Data> f63954c;

        /* renamed from: d  reason: collision with root package name */
        public Data f63955d;

        public b(String str, a<Data> aVar) {
            this.f63953b = str;
            this.f63954c = aVar;
        }

        public Class<Data> a() {
            return this.f63954c.a();
        }

        public void b() {
            try {
                this.f63954c.b(this.f63955d);
            } catch (IOException unused) {
            }
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void f(Priority priority, d.a<? super Data> aVar) {
            try {
                Data c11 = this.f63954c.c(this.f63953b);
                this.f63955d = c11;
                aVar.d(c11);
            } catch (IllegalArgumentException e11) {
                aVar.e(e11);
            }
        }
    }

    public DataUrlLoader(a<Data> aVar) {
        this.f63950a = aVar;
    }

    public d.a<Data> a(Model model, int i11, int i12, Options options) {
        return new d.a<>(new e4.d(model), new b(model.toString(), this.f63950a));
    }

    public boolean b(Model model) {
        return model.toString().startsWith("data:image");
    }
}
