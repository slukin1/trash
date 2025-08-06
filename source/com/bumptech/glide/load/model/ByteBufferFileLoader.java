package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import o3.d;
import s3.d;

public class ByteBufferFileLoader implements d<File, ByteBuffer> {

    public static class Factory implements d<File, ByteBuffer> {
        public d<File, ByteBuffer> b(f fVar) {
            return new ByteBufferFileLoader();
        }

        public void teardown() {
        }
    }

    public static final class a implements o3.d<ByteBuffer> {

        /* renamed from: b  reason: collision with root package name */
        public final File f63949b;

        public a(File file) {
            this.f63949b = file;
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        public void b() {
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void f(Priority priority, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.d(f4.a.a(this.f63949b));
            } catch (IOException e11) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e11);
                }
                aVar.e(e11);
            }
        }
    }

    /* renamed from: c */
    public d.a<ByteBuffer> a(File file, int i11, int i12, Options options) {
        return new d.a<>(new e4.d(file), new a(file));
    }

    /* renamed from: d */
    public boolean b(File file) {
        return true;
    }
}
