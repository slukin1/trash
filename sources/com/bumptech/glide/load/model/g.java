package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import java.io.InputStream;

public class g<Data> implements d<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final d<Uri, Data> f64014a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f64015b;

    public static final class a implements s3.d<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f64016a;

        public a(Resources resources) {
            this.f64016a = resources;
        }

        public d<Integer, AssetFileDescriptor> b(f fVar) {
            return new g(this.f64016a, fVar.d(Uri.class, AssetFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class b implements s3.d<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f64017a;

        public b(Resources resources) {
            this.f64017a = resources;
        }

        public d<Integer, ParcelFileDescriptor> b(f fVar) {
            return new g(this.f64017a, fVar.d(Uri.class, ParcelFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class c implements s3.d<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f64018a;

        public c(Resources resources) {
            this.f64018a = resources;
        }

        public d<Integer, InputStream> b(f fVar) {
            return new g(this.f64018a, fVar.d(Uri.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public static class d implements s3.d<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f64019a;

        public d(Resources resources) {
            this.f64019a = resources;
        }

        public d<Integer, Uri> b(f fVar) {
            return new g(this.f64019a, UnitModelLoader.c());
        }

        public void teardown() {
        }
    }

    public g(Resources resources, d<Uri, Data> dVar) {
        this.f64015b = resources;
        this.f64014a = dVar;
    }

    /* renamed from: c */
    public d.a<Data> a(Integer num, int i11, int i12, Options options) {
        Uri d11 = d(num);
        if (d11 == null) {
            return null;
        }
        return this.f64014a.a(d11, i11, i12, options);
    }

    public final Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f64015b.getResourcePackageName(num.intValue()) + '/' + this.f64015b.getResourceTypeName(num.intValue()) + '/' + this.f64015b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e11) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e11);
            return null;
        }
    }

    /* renamed from: e */
    public boolean b(Integer num) {
        return true;
    }
}
