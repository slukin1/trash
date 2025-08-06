package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class SVGImageView extends ImageView {

    /* renamed from: d  reason: collision with root package name */
    public static Method f64569d;

    /* renamed from: b  reason: collision with root package name */
    public SVG f64570b = null;

    /* renamed from: c  reason: collision with root package name */
    public RenderOptions f64571c = new RenderOptions();

    public class b extends AsyncTask<Integer, Integer, SVG> {

        /* renamed from: a  reason: collision with root package name */
        public Context f64572a;

        /* renamed from: b  reason: collision with root package name */
        public int f64573b;

        public b(Context context, int i11) {
            this.f64572a = context;
            this.f64573b = i11;
        }

        /* renamed from: a */
        public SVG doInBackground(Integer... numArr) {
            try {
                return SVG.i(this.f64572a, this.f64573b);
            } catch (SVGParseException e11) {
                Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", new Object[]{Integer.valueOf(this.f64573b), e11.getMessage()}));
                return null;
            }
        }

        /* renamed from: b */
        public void onPostExecute(SVG svg) {
            SVG unused = SVGImageView.this.f64570b = svg;
            SVGImageView.this.c();
        }
    }

    public class c extends AsyncTask<InputStream, Integer, SVG> {
        public c() {
        }

        /* renamed from: a */
        public SVG doInBackground(InputStream... inputStreamArr) {
            try {
                SVG h11 = SVG.h(inputStreamArr[0]);
                try {
                    inputStreamArr[0].close();
                } catch (IOException unused) {
                }
                return h11;
            } catch (SVGParseException e11) {
                Log.e("SVGImageView", "Parse error loading URI: " + e11.getMessage());
                try {
                    inputStreamArr[0].close();
                    return null;
                } catch (IOException unused2) {
                    return null;
                }
            } catch (Throwable th2) {
                try {
                    inputStreamArr[0].close();
                } catch (IOException unused3) {
                }
                throw th2;
            }
        }

        /* renamed from: b */
        public void onPostExecute(SVG svg) {
            SVG unused = SVGImageView.this.f64570b = svg;
            SVGImageView.this.c();
        }
    }

    static {
        Class<View> cls = View.class;
        try {
            f64569d = cls.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class});
        } catch (NoSuchMethodException unused) {
        }
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        d(attributeSet, 0);
    }

    private void setFromString(String str) {
        try {
            this.f64570b = SVG.k(str);
            c();
        } catch (SVGParseException unused) {
            Log.e("SVGImageView", "Could not find SVG at: " + str);
        }
    }

    public final void c() {
        SVG svg = this.f64570b;
        if (svg != null) {
            Picture p11 = svg.p(this.f64571c);
            g();
            setImageDrawable(new PictureDrawable(p11));
        }
    }

    public final void d(AttributeSet attributeSet, int i11) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.SVGImageView, i11, 0);
            try {
                String string = obtainStyledAttributes.getString(R$styleable.SVGImageView_css);
                if (string != null) {
                    this.f64571c.a(string);
                }
                int i12 = R$styleable.SVGImageView_svg;
                int resourceId = obtainStyledAttributes.getResourceId(i12, -1);
                if (resourceId != -1) {
                    setImageResource(resourceId);
                    return;
                }
                String string2 = obtainStyledAttributes.getString(i12);
                if (string2 != null) {
                    if (f(Uri.parse(string2))) {
                        obtainStyledAttributes.recycle();
                        return;
                    } else if (e(string2)) {
                        obtainStyledAttributes.recycle();
                        return;
                    } else {
                        setFromString(string2);
                    }
                }
                obtainStyledAttributes.recycle();
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final boolean e(String str) {
        try {
            InputStream open = getContext().getAssets().open(str);
            new c().execute(new InputStream[]{open});
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public final boolean f(Uri uri) {
        try {
            InputStream openInputStream = getContext().getContentResolver().openInputStream(uri);
            new c().execute(new InputStream[]{openInputStream});
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    public final void g() {
        if (f64569d != null) {
            try {
                int i11 = View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()));
                f64569d.invoke(this, new Object[]{Integer.valueOf(i11), null});
            } catch (Exception e11) {
                Log.w("SVGImageView", "Unexpected failure calling setLayerType", e11);
            }
        }
    }

    public void setCSS(String str) {
        this.f64571c.a(str);
        c();
    }

    public void setImageAsset(String str) {
        if (!e(str)) {
            Log.e("SVGImageView", "File not found: " + str);
        }
    }

    public void setImageResource(int i11) {
        new b(getContext(), i11).execute(new Integer[0]);
    }

    public void setImageURI(Uri uri) {
        if (!f(uri)) {
            Log.e("SVGImageView", "File not found: " + uri);
        }
    }

    public void setSVG(SVG svg) {
        if (svg != null) {
            this.f64570b = svg;
            c();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        d(attributeSet, i11);
    }
}
