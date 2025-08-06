package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.b;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.cache.g;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.a;
import com.bumptech.glide.load.model.c;
import com.bumptech.glide.load.model.g;
import com.bumptech.glide.load.model.h;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.d;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.n;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s3.f;
import t3.a;
import t3.b;
import t3.c;
import y3.c;
import y3.i;

public class a implements ComponentCallbacks2 {

    /* renamed from: m  reason: collision with root package name */
    public static volatile a f63593m;

    /* renamed from: n  reason: collision with root package name */
    public static volatile boolean f63594n;

    /* renamed from: b  reason: collision with root package name */
    public final h f63595b;

    /* renamed from: c  reason: collision with root package name */
    public final e f63596c;

    /* renamed from: d  reason: collision with root package name */
    public final g f63597d;

    /* renamed from: e  reason: collision with root package name */
    public final b f63598e;

    /* renamed from: f  reason: collision with root package name */
    public final Registry f63599f;

    /* renamed from: g  reason: collision with root package name */
    public final b f63600g;

    /* renamed from: h  reason: collision with root package name */
    public final a4.g f63601h;

    /* renamed from: i  reason: collision with root package name */
    public final com.bumptech.glide.manager.b f63602i;

    /* renamed from: j  reason: collision with root package name */
    public final List<d> f63603j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final C0697a f63604k;

    /* renamed from: l  reason: collision with root package name */
    public MemoryCategory f63605l = MemoryCategory.NORMAL;

    /* renamed from: com.bumptech.glide.a$a  reason: collision with other inner class name */
    public interface C0697a {
        RequestOptions build();
    }

    public a(Context context, h hVar, g gVar, e eVar, b bVar, a4.g gVar2, com.bumptech.glide.manager.b bVar2, int i11, C0697a aVar, Map<Class<?>, TransitionOptions<?, ?>> map, List<com.bumptech.glide.request.e<Object>> list, boolean z11, boolean z12) {
        n3.e eVar2;
        n3.e eVar3;
        Context context2 = context;
        e eVar4 = eVar;
        b bVar3 = bVar;
        Class<l3.a> cls = l3.a.class;
        Class<String> cls2 = String.class;
        Class<Integer> cls3 = Integer.class;
        Class<byte[]> cls4 = byte[].class;
        this.f63595b = hVar;
        this.f63596c = eVar4;
        this.f63600g = bVar3;
        this.f63597d = gVar;
        this.f63601h = gVar2;
        this.f63602i = bVar2;
        this.f63604k = aVar;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f63599f = registry;
        registry.o(new DefaultImageHeaderParser());
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 27) {
            registry.o(new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> g11 = registry.g();
        y3.a aVar2 = new y3.a(context2, g11, eVar4, bVar3);
        n3.e<ParcelFileDescriptor, Bitmap> h11 = p.h(eVar);
        com.bumptech.glide.load.resource.bitmap.e eVar5 = new com.bumptech.glide.load.resource.bitmap.e(registry.g(), resources.getDisplayMetrics(), eVar4, bVar3);
        if (!z12 || i12 < 28) {
            eVar2 = new d(eVar5);
            eVar3 = new n(eVar5, bVar3);
        } else {
            eVar3 = new InputStreamBitmapImageDecoderResourceDecoder();
            eVar2 = new ByteBufferBitmapImageDecoderResourceDecoder();
        }
        Class<byte[]> cls5 = cls4;
        w3.d dVar = new w3.d(context2);
        int i13 = i12;
        g.c cVar = new g.c(resources);
        g.d dVar2 = new g.d(resources);
        Class<String> cls6 = cls2;
        g.b bVar4 = new g.b(resources);
        g.d dVar3 = dVar2;
        g.a aVar3 = new g.a(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(bVar3);
        Class<Integer> cls7 = cls3;
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        g.b bVar5 = bVar4;
        g.c cVar2 = cVar;
        w3.d dVar4 = dVar;
        registry.c(ByteBuffer.class, new ByteBufferEncoder()).c(InputStream.class, new f(bVar3)).e("Bitmap", ByteBuffer.class, Bitmap.class, eVar2).e("Bitmap", InputStream.class, Bitmap.class, eVar3);
        if (ParcelFileDescriptorRewinder.a()) {
            registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new k(eVar5));
        }
        w3.d dVar5 = dVar4;
        registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, h11).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, p.c(eVar)).b(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.a()).e("Bitmap", Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).d(Bitmap.class, bitmapEncoder).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, eVar2)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, eVar3)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, h11)).d(BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.b(eVar4, bitmapEncoder)).e("Gif", InputStream.class, c.class, new i(g11, aVar2, bVar3)).e("Gif", ByteBuffer.class, c.class, aVar2).d(c.class, new GifDrawableEncoder()).b(cls, cls, UnitModelLoader.Factory.a()).e("Bitmap", cls, Bitmap.class, new y3.g(eVar4)).a(Uri.class, Drawable.class, dVar5).a(Uri.class, Bitmap.class, new l(dVar5, eVar4)).p(new ByteBufferRewinder.Factory()).b(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).b(File.class, InputStream.class, new FileLoader.StreamFactory()).a(File.class, File.class, new FileDecoder()).b(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).b(File.class, File.class, UnitModelLoader.Factory.a()).p(new b.a(bVar3));
        if (ParcelFileDescriptorRewinder.a()) {
            registry.p(new ParcelFileDescriptorRewinder.Factory());
        }
        Class cls8 = Integer.TYPE;
        g.c cVar3 = cVar2;
        g.b bVar6 = bVar5;
        Class<Integer> cls9 = cls7;
        g.d dVar6 = dVar3;
        g.a aVar4 = aVar3;
        Class<String> cls10 = cls6;
        Context context3 = context;
        registry.b(cls8, InputStream.class, cVar3).b(cls8, ParcelFileDescriptor.class, bVar6).b(cls9, InputStream.class, cVar3).b(cls9, ParcelFileDescriptor.class, bVar6).b(cls9, Uri.class, dVar6).b(cls8, AssetFileDescriptor.class, aVar4).b(cls9, AssetFileDescriptor.class, aVar4).b(cls8, Uri.class, dVar6).b(cls10, InputStream.class, new DataUrlLoader.StreamFactory()).b(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).b(cls10, InputStream.class, new StringLoader.StreamFactory()).b(cls10, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).b(cls10, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).b(Uri.class, InputStream.class, new HttpUriLoader.Factory()).b(Uri.class, InputStream.class, new a.c(context.getAssets())).b(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).b(Uri.class, InputStream.class, new a.C0730a(context3)).b(Uri.class, InputStream.class, new b.a(context3));
        int i14 = i13;
        if (i14 >= 29) {
            registry.b(Uri.class, InputStream.class, new c.C0731c(context3));
            registry.b(Uri.class, ParcelFileDescriptor.class, new c.b(context3));
        }
        ContentResolver contentResolver2 = contentResolver;
        Class<byte[]> cls11 = cls5;
        BitmapBytesTranscoder bitmapBytesTranscoder2 = bitmapBytesTranscoder;
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder2 = gifDrawableBytesTranscoder;
        registry.b(Uri.class, InputStream.class, new h.d(contentResolver2)).b(Uri.class, ParcelFileDescriptor.class, new h.b(contentResolver2)).b(Uri.class, AssetFileDescriptor.class, new h.a(contentResolver2)).b(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).b(URL.class, InputStream.class, new UrlLoader.StreamFactory()).b(Uri.class, File.class, new c.a(context3)).b(s3.a.class, InputStream.class, new HttpGlideUrlLoader.Factory()).b(cls11, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).b(cls11, InputStream.class, new ByteArrayLoader.StreamFactory()).b(Uri.class, Uri.class, UnitModelLoader.Factory.a()).b(Drawable.class, Drawable.class, UnitModelLoader.Factory.a()).a(Drawable.class, Drawable.class, new UnitDrawableDecoder()).q(Bitmap.class, BitmapDrawable.class, new z3.a(resources)).q(Bitmap.class, cls11, bitmapBytesTranscoder2).q(Drawable.class, cls11, new z3.b(eVar4, bitmapBytesTranscoder2, gifDrawableBytesTranscoder2)).q(y3.c.class, cls11, gifDrawableBytesTranscoder2);
        if (i14 >= 23) {
            n3.e<ByteBuffer, Bitmap> d11 = p.d(eVar);
            registry.a(ByteBuffer.class, Bitmap.class, d11);
            registry.a(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, d11));
        }
        this.f63598e = new b(context, bVar, registry, new ImageViewTargetFactory(), aVar, map, list, hVar, z11, i11);
    }

    public static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (!f63594n) {
            f63594n = true;
            n(context, generatedAppGlideModule);
            f63594n = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    public static a d(Context context) {
        if (f63593m == null) {
            GeneratedAppGlideModule e11 = e(context.getApplicationContext());
            synchronized (a.class) {
                if (f63593m == null) {
                    a(context, e11);
                }
            }
        }
        return f63593m;
    }

    public static GeneratedAppGlideModule e(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context.getApplicationContext()});
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
        } catch (InstantiationException e11) {
            r(e11);
        } catch (IllegalAccessException e12) {
            r(e12);
        } catch (NoSuchMethodException e13) {
            r(e13);
        } catch (InvocationTargetException e14) {
            r(e14);
        }
        return null;
    }

    public static a4.g m(Context context) {
        f4.h.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return d(context).l();
    }

    public static void n(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        o(context, new GlideBuilder(), generatedAppGlideModule);
    }

    public static void o(Context context, GlideBuilder glideBuilder, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<b4.b> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new b4.c(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> d11 = generatedAppGlideModule.d();
            Iterator<b4.b> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                b4.b next = it2.next();
                if (d11.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it2.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (b4.b bVar : emptyList) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + bVar.getClass());
            }
        }
        glideBuilder.e(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        for (b4.b a11 : emptyList) {
            a11.a(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, glideBuilder);
        }
        a a12 = glideBuilder.a(applicationContext);
        for (b4.b next2 : emptyList) {
            try {
                next2.b(applicationContext, a12, a12.f63599f);
            } catch (AbstractMethodError e11) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + next2.getClass().getName(), e11);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, a12, a12.f63599f);
        }
        applicationContext.registerComponentCallbacks(a12);
        f63593m = a12;
    }

    public static void r(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static d u(Activity activity) {
        return m(activity).i(activity);
    }

    public static d v(Context context) {
        return m(context).k(context);
    }

    public static d w(View view) {
        return m(view.getContext()).l(view);
    }

    public static d x(Fragment fragment) {
        return m(fragment.getContext()).m(fragment);
    }

    public static d y(FragmentActivity fragmentActivity) {
        return m(fragmentActivity).n(fragmentActivity);
    }

    public void b() {
        f4.i.a();
        this.f63595b.e();
    }

    public void c() {
        f4.i.b();
        this.f63597d.b();
        this.f63596c.b();
        this.f63600g.b();
    }

    public com.bumptech.glide.load.engine.bitmap_recycle.b f() {
        return this.f63600g;
    }

    public e g() {
        return this.f63596c;
    }

    public com.bumptech.glide.manager.b h() {
        return this.f63602i;
    }

    public Context i() {
        return this.f63598e.getBaseContext();
    }

    public b j() {
        return this.f63598e;
    }

    public Registry k() {
        return this.f63599f;
    }

    public a4.g l() {
        return this.f63601h;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        c();
    }

    public void onTrimMemory(int i11) {
        s(i11);
    }

    public void p(d dVar) {
        synchronized (this.f63603j) {
            if (!this.f63603j.contains(dVar)) {
                this.f63603j.add(dVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    public boolean q(c4.g<?> gVar) {
        synchronized (this.f63603j) {
            for (d y11 : this.f63603j) {
                if (y11.y(gVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void s(int i11) {
        f4.i.b();
        for (d onTrimMemory : this.f63603j) {
            onTrimMemory.onTrimMemory(i11);
        }
        this.f63597d.a(i11);
        this.f63596c.a(i11);
        this.f63600g.a(i11);
    }

    public void t(d dVar) {
        synchronized (this.f63603j) {
            if (this.f63603j.contains(dVar)) {
                this.f63603j.remove(dVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }
}
