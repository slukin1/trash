package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bumptech.glide.load.data.a;
import java.io.IOException;

public final class ParcelFileDescriptorRewinder implements a<ParcelFileDescriptor> {

    /* renamed from: a  reason: collision with root package name */
    public final a f63669a;

    public static final class Factory implements a.C0699a<ParcelFileDescriptor> {
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }

        /* renamed from: c */
        public a<ParcelFileDescriptor> b(ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final ParcelFileDescriptor f63670a;

        public a(ParcelFileDescriptor parcelFileDescriptor) {
            this.f63670a = parcelFileDescriptor;
        }

        public ParcelFileDescriptor a() throws IOException {
            try {
                Os.lseek(this.f63670a.getFileDescriptor(), 0, OsConstants.SEEK_SET);
                return this.f63670a;
            } catch (ErrnoException e11) {
                throw new IOException(e11);
            }
        }
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.f63669a = new a(parcelFileDescriptor);
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void b() {
    }

    /* renamed from: d */
    public ParcelFileDescriptor c() throws IOException {
        return this.f63669a.a();
    }
}
