package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import o3.d;
import s3.d;

public class FileLoader<Data> implements d<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final c<Data> f63956a;

    public static class FileDescriptorFactory extends a<ParcelFileDescriptor> {

        public class a implements c<ParcelFileDescriptor> {
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            /* renamed from: d */
            public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            /* renamed from: e */
            public ParcelFileDescriptor c(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public FileDescriptorFactory() {
            super(new a());
        }
    }

    public static class StreamFactory extends a<InputStream> {

        public class a implements c<InputStream> {
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: d */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: e */
            public InputStream c(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public StreamFactory() {
            super(new a());
        }
    }

    public static class a<Data> implements d<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        public final c<Data> f63957a;

        public a(c<Data> cVar) {
            this.f63957a = cVar;
        }

        public final d<File, Data> b(f fVar) {
            return new FileLoader(this.f63957a);
        }

        public final void teardown() {
        }
    }

    public static final class b<Data> implements o3.d<Data> {

        /* renamed from: b  reason: collision with root package name */
        public final File f63958b;

        /* renamed from: c  reason: collision with root package name */
        public final c<Data> f63959c;

        /* renamed from: d  reason: collision with root package name */
        public Data f63960d;

        public b(File file, c<Data> cVar) {
            this.f63958b = file;
            this.f63959c = cVar;
        }

        public Class<Data> a() {
            return this.f63959c.a();
        }

        public void b() {
            Data data = this.f63960d;
            if (data != null) {
                try {
                    this.f63959c.b(data);
                } catch (IOException unused) {
                }
            }
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void f(Priority priority, d.a<? super Data> aVar) {
            try {
                Data c11 = this.f63959c.c(this.f63958b);
                this.f63960d = c11;
                aVar.d(c11);
            } catch (FileNotFoundException e11) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e11);
                }
                aVar.e(e11);
            }
        }
    }

    public interface c<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(File file) throws FileNotFoundException;
    }

    public FileLoader(c<Data> cVar) {
        this.f63956a = cVar;
    }

    /* renamed from: c */
    public d.a<Data> a(File file, int i11, int i12, Options options) {
        return new d.a<>(new e4.d(file), new b(file, this.f63956a));
    }

    /* renamed from: d */
    public boolean b(File file) {
        return true;
    }
}
