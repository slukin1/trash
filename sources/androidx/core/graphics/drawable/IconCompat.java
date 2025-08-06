package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.h;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.google.android.exoplayer2.C;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huobi.view.roundimg.RoundedDrawable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    public static final PorterDuff.Mode f8369k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f8370a = -1;

    /* renamed from: b  reason: collision with root package name */
    public Object f8371b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f8372c = null;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f8373d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f8374e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f8375f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f8376g = null;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f8377h = f8369k;

    /* renamed from: i  reason: collision with root package name */
    public String f8378i = null;

    /* renamed from: j  reason: collision with root package name */
    public String f8379j;

    public static class a {
        public static IconCompat a(Object obj) {
            h.g(obj);
            int d11 = d(obj);
            if (d11 == 2) {
                return IconCompat.l((Resources) null, c(obj), b(obj));
            }
            if (d11 == 4) {
                return IconCompat.i(e(obj));
            }
            if (d11 == 6) {
                return IconCompat.f(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f8371b = obj;
            return iconCompat;
        }

        public static int b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e11) {
                Log.e("IconCompat", "Unable to get icon resource", e11);
                return 0;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon resource", e12);
                return 0;
            } catch (NoSuchMethodException e13) {
                Log.e("IconCompat", "Unable to get icon resource", e13);
                return 0;
            }
        }

        public static String c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e11) {
                Log.e("IconCompat", "Unable to get icon package", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon package", e12);
                return null;
            } catch (NoSuchMethodException e13) {
                Log.e("IconCompat", "Unable to get icon package", e13);
                return null;
            }
        }

        public static int d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e11) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e11);
                return -1;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e12);
                return -1;
            } catch (NoSuchMethodException e13) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e13);
                return -1;
            }
        }

        public static Uri e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e11) {
                Log.e("IconCompat", "Unable to get icon uri", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon uri", e12);
                return null;
            } catch (NoSuchMethodException e13) {
                Log.e("IconCompat", "Unable to get icon uri", e13);
                return null;
            }
        }

        public static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        public static Icon g(IconCompat iconCompat, Context context) {
            Icon icon;
            switch (iconCompat.f8370a) {
                case -1:
                    return (Icon) iconCompat.f8371b;
                case 1:
                    icon = Icon.createWithBitmap((Bitmap) iconCompat.f8371b);
                    break;
                case 2:
                    icon = Icon.createWithResource(iconCompat.o(), iconCompat.f8374e);
                    break;
                case 3:
                    icon = Icon.createWithData((byte[]) iconCompat.f8371b, iconCompat.f8374e, iconCompat.f8375f);
                    break;
                case 4:
                    icon = Icon.createWithContentUri((String) iconCompat.f8371b);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT < 26) {
                        icon = Icon.createWithBitmap(IconCompat.e((Bitmap) iconCompat.f8371b, false));
                        break;
                    } else {
                        icon = b.b((Bitmap) iconCompat.f8371b);
                        break;
                    }
                case 6:
                    int i11 = Build.VERSION.SDK_INT;
                    if (i11 >= 30) {
                        icon = d.a(iconCompat.r());
                        break;
                    } else if (context != null) {
                        InputStream s11 = iconCompat.s(context);
                        if (s11 != null) {
                            if (i11 < 26) {
                                icon = Icon.createWithBitmap(IconCompat.e(BitmapFactory.decodeStream(s11), false));
                                break;
                            } else {
                                icon = b.b(BitmapFactory.decodeStream(s11));
                                break;
                            }
                        } else {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.r());
                        }
                    } else {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.r());
                    }
                default:
                    throw new IllegalArgumentException("Unknown type");
            }
            ColorStateList colorStateList = iconCompat.f8376g;
            if (colorStateList != null) {
                icon.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f8377h;
            if (mode != IconCompat.f8369k) {
                icon.setTintMode(mode);
            }
            return icon;
        }
    }

    public static class b {
        public static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        public static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    public static class c {
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    public static class d {
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
    }

    public static String A(int i11) {
        switch (i11) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static IconCompat b(Bundle bundle) {
        int i11 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i11);
        iconCompat.f8374e = bundle.getInt("int1");
        iconCompat.f8375f = bundle.getInt("int2");
        iconCompat.f8379j = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.f8376g = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.f8377h = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i11) {
            case -1:
            case 1:
            case 5:
                iconCompat.f8371b = bundle.getParcelable("obj");
                break;
            case 2:
            case 4:
            case 6:
                iconCompat.f8371b = bundle.getString("obj");
                break;
            case 3:
                iconCompat.f8371b = bundle.getByteArray("obj");
                break;
            default:
                Log.w("IconCompat", "Unknown type " + i11);
                return null;
        }
        return iconCompat;
    }

    public static IconCompat c(Icon icon) {
        return a.a(icon);
    }

    public static IconCompat d(Icon icon) {
        if (a.d(icon) == 2 && a.b(icon) == 0) {
            return null;
        }
        return a.a(icon);
    }

    public static Bitmap e(Bitmap bitmap, boolean z11) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f11 = (float) min;
        float f12 = 0.5f * f11;
        float f13 = 0.9166667f * f12;
        if (z11) {
            float f14 = 0.010416667f * f11;
            paint.setColor(0);
            paint.setShadowLayer(f14, 0.0f, f11 * 0.020833334f, 1023410176);
            canvas.drawCircle(f12, f12, f13, paint);
            paint.setShadowLayer(f14, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f12, f12, f13, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((float) (-(bitmap.getWidth() - min))) / 2.0f, ((float) (-(bitmap.getHeight() - min))) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f12, f12, f13, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    public static IconCompat f(Uri uri) {
        androidx.core.util.b.c(uri);
        return g(uri.toString());
    }

    public static IconCompat g(String str) {
        androidx.core.util.b.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f8371b = str;
        return iconCompat;
    }

    public static IconCompat h(Bitmap bitmap) {
        androidx.core.util.b.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f8371b = bitmap;
        return iconCompat;
    }

    public static IconCompat i(Uri uri) {
        androidx.core.util.b.c(uri);
        return j(uri.toString());
    }

    public static IconCompat j(String str) {
        androidx.core.util.b.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f8371b = str;
        return iconCompat;
    }

    public static IconCompat k(Context context, int i11) {
        androidx.core.util.b.c(context);
        return l(context.getResources(), context.getPackageName(), i11);
    }

    public static IconCompat l(Resources resources, String str, int i11) {
        androidx.core.util.b.c(str);
        if (i11 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f8374e = i11;
            if (resources != null) {
                try {
                    iconCompat.f8371b = resources.getResourceName(i11);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f8371b = str;
            }
            iconCompat.f8379j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public static Resources p(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", new Object[]{str}), e11);
            return null;
        }
    }

    public void a(Context context) {
        Object obj;
        if (this.f8370a == 2 && (obj = this.f8371b) != null) {
            String str = (String) obj;
            if (str.contains(":")) {
                String str2 = str.split(":", -1)[1];
                String str3 = str2.split("/", -1)[0];
                String str4 = str2.split("/", -1)[1];
                String str5 = str.split(":", -1)[0];
                if ("0_resource_name_obfuscated".equals(str4)) {
                    Log.i("IconCompat", "Found obfuscated resource, not trying to update resource id for it");
                    return;
                }
                String o11 = o();
                int identifier = p(context, o11).getIdentifier(str4, str3, str5);
                if (this.f8374e != identifier) {
                    Log.i("IconCompat", "Id has changed for " + o11 + " " + str);
                    this.f8374e = identifier;
                }
            }
        }
    }

    public Bitmap m() {
        int i11 = this.f8370a;
        if (i11 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f8371b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        } else if (i11 == 1) {
            return (Bitmap) this.f8371b;
        } else {
            if (i11 == 5) {
                return e((Bitmap) this.f8371b, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
    }

    public int n() {
        int i11 = this.f8370a;
        if (i11 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f8371b);
        }
        if (i11 == 2) {
            return this.f8374e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String o() {
        int i11 = this.f8370a;
        if (i11 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.c(this.f8371b);
        }
        if (i11 == 2) {
            String str = this.f8379j;
            if (str == null || TextUtils.isEmpty(str)) {
                return ((String) this.f8371b).split(":", -1)[0];
            }
            return this.f8379j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int q() {
        int i11 = this.f8370a;
        return (i11 != -1 || Build.VERSION.SDK_INT < 23) ? i11 : a.d(this.f8371b);
    }

    public Uri r() {
        int i11 = this.f8370a;
        if (i11 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.e(this.f8371b);
        }
        if (i11 == 4 || i11 == 6) {
            return Uri.parse((String) this.f8371b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream s(Context context) {
        Uri r11 = r();
        String scheme = r11.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(r11);
            } catch (Exception e11) {
                Log.w("IconCompat", "Unable to load image from URI: " + r11, e11);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f8371b));
            } catch (FileNotFoundException e12) {
                Log.w("IconCompat", "Unable to load image from path: " + r11, e12);
                return null;
            }
        }
    }

    public Drawable t(Context context) {
        a(context);
        if (Build.VERSION.SDK_INT >= 23) {
            return a.f(z(context), context);
        }
        Drawable u11 = u(context);
        if (!(u11 == null || (this.f8376g == null && this.f8377h == f8369k))) {
            u11.mutate();
            u0.a.o(u11, this.f8376g);
            u0.a.p(u11, this.f8377h);
        }
        return u11;
    }

    public String toString() {
        if (this.f8370a == -1) {
            return String.valueOf(this.f8371b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        sb2.append(A(this.f8370a));
        switch (this.f8370a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f8371b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f8371b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f8379j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", new Object[]{Integer.valueOf(n())}));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f8374e);
                if (this.f8375f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f8375f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f8371b);
                break;
        }
        if (this.f8376g != null) {
            sb2.append(" tint=");
            sb2.append(this.f8376g);
        }
        if (this.f8377h != f8369k) {
            sb2.append(" mode=");
            sb2.append(this.f8377h);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public final Drawable u(Context context) {
        switch (this.f8370a) {
            case 1:
                return new BitmapDrawable(context.getResources(), (Bitmap) this.f8371b);
            case 2:
                String o11 = o();
                if (TextUtils.isEmpty(o11)) {
                    o11 = context.getPackageName();
                }
                try {
                    return ResourcesCompat.f(p(context, o11), this.f8374e, context.getTheme());
                } catch (RuntimeException e11) {
                    Log.e("IconCompat", String.format("Unable to load resource 0x%08x from pkg=%s", new Object[]{Integer.valueOf(this.f8374e), this.f8371b}), e11);
                    break;
                }
            case 3:
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.f8371b, this.f8374e, this.f8375f));
            case 4:
                InputStream s11 = s(context);
                if (s11 != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(s11));
                }
                break;
            case 5:
                return new BitmapDrawable(context.getResources(), e((Bitmap) this.f8371b, false));
            case 6:
                InputStream s12 = s(context);
                if (s12 != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        return b.a((Drawable) null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(s12)));
                    }
                    return new BitmapDrawable(context.getResources(), e(BitmapFactory.decodeStream(s12), false));
                }
                break;
        }
        return null;
    }

    public void v() {
        this.f8377h = PorterDuff.Mode.valueOf(this.f8378i);
        switch (this.f8370a) {
            case -1:
                Parcelable parcelable = this.f8373d;
                if (parcelable != null) {
                    this.f8371b = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                Parcelable parcelable2 = this.f8373d;
                if (parcelable2 != null) {
                    this.f8371b = parcelable2;
                    return;
                }
                byte[] bArr = this.f8372c;
                this.f8371b = bArr;
                this.f8370a = 3;
                this.f8374e = 0;
                this.f8375f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f8372c, Charset.forName(C.UTF16_NAME));
                this.f8371b = str;
                if (this.f8370a == 2 && this.f8379j == null) {
                    this.f8379j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f8371b = this.f8372c;
                return;
            default:
                return;
        }
    }

    public void w(boolean z11) {
        this.f8378i = this.f8377h.name();
        switch (this.f8370a) {
            case -1:
                if (!z11) {
                    this.f8373d = (Parcelable) this.f8371b;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 1:
            case 5:
                if (z11) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f8371b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f8372c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f8373d = (Parcelable) this.f8371b;
                return;
            case 2:
                this.f8372c = ((String) this.f8371b).getBytes(Charset.forName(C.UTF16_NAME));
                return;
            case 3:
                this.f8372c = (byte[]) this.f8371b;
                return;
            case 4:
            case 6:
                this.f8372c = this.f8371b.toString().getBytes(Charset.forName(C.UTF16_NAME));
                return;
            default:
                return;
        }
    }

    public Bundle x() {
        Bundle bundle = new Bundle();
        switch (this.f8370a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f8371b);
                break;
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f8371b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f8371b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f8371b);
                break;
            default:
                throw new IllegalArgumentException("Invalid icon");
        }
        bundle.putInt("type", this.f8370a);
        bundle.putInt("int1", this.f8374e);
        bundle.putInt("int2", this.f8375f);
        bundle.putString("string1", this.f8379j);
        ColorStateList colorStateList = this.f8376g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f8377h;
        if (mode != f8369k) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    @Deprecated
    public Icon y() {
        return z((Context) null);
    }

    public Icon z(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.g(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public IconCompat(int i11) {
        this.f8370a = i11;
    }
}
