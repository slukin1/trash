package px;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f29170a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29171b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29172c;

    /* renamed from: d  reason: collision with root package name */
    public final ox.c f29173d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageScaleType f29174e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewScaleType f29175f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageDownloader f29176g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f29177h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f29178i;

    /* renamed from: j  reason: collision with root package name */
    public final BitmapFactory.Options f29179j;

    public c(String str, String str2, String str3, ox.c cVar, ViewScaleType viewScaleType, ImageDownloader imageDownloader, DisplayImageOptions displayImageOptions) {
        this.f29170a = str;
        this.f29171b = str2;
        this.f29172c = str3;
        this.f29173d = cVar;
        this.f29174e = displayImageOptions.C();
        this.f29175f = viewScaleType;
        this.f29176g = imageDownloader;
        this.f29177h = displayImageOptions.x();
        this.f29178i = displayImageOptions.H();
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.f29179j = options;
        a(displayImageOptions.u(), options);
    }

    public final void a(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 10) {
            b(options, options2);
        }
        if (i11 >= 11) {
            c(options, options2);
        }
    }

    @TargetApi(10)
    public final void b(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    public final void c(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    public BitmapFactory.Options d() {
        return this.f29179j;
    }

    public ImageDownloader e() {
        return this.f29176g;
    }

    public Object f() {
        return this.f29177h;
    }

    public String g() {
        return this.f29170a;
    }

    public ImageScaleType h() {
        return this.f29174e;
    }

    public String i() {
        return this.f29171b;
    }

    public ox.c j() {
        return this.f29173d;
    }

    public ViewScaleType k() {
        return this.f29175f;
    }

    public boolean l() {
        return this.f29178i;
    }
}
