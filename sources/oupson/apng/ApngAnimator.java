package oupson.apng;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import d10.l;
import java.net.URL;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import oupson.apng.exceptions.NotApngException;
import oupson.apng.utils.ApngAnimatorOptions;
import oupson.apng.utils.Utils;

@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001!J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J \u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J/\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0018\u0010\u0019J.\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0002j\b\u0012\u0004\u0012\u00020\u001a`\u0004J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0006R*\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f8\u0006@BX\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010&\u001a\u0004\b#\u0010$R.\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010'\u001a\u0004\u0018\u00010\f8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R*\u00109\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b2\u00103\u0012\u0004\b8\u0010&\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u00103R*\u0010>\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR(\u0010D\u001a\u00020\u001f8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bC\u0010\"\u0012\u0004\bG\u0010&\u001a\u0004\bD\u0010$\"\u0004\bE\u0010FR(\u0010K\u001a\u00020\u001f8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u001c\u0010\"\u0012\u0004\bJ\u0010&\u001a\u0004\bH\u0010$\"\u0004\bI\u0010FR\u0016\u0010N\u001a\u0004\u0018\u00010L8\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010M¨\u0006O"}, d2 = {"Loupson/apng/ApngAnimator;", "", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "generatedFrame", "", "v", "Loupson/apng/CustomAnimationDrawable;", "w", "Landroid/net/Uri;", "uri", "", "speed", "Loupson/apng/utils/ApngAnimatorOptions;", "apngAnimatorOptions", "n", "(Landroid/net/Uri;Ljava/lang/Float;Loupson/apng/utils/ApngAnimatorOptions;)Loupson/apng/ApngAnimator;", "Ljava/net/URL;", "url", "p", "(Ljava/net/URL;Ljava/lang/Float;Loupson/apng/utils/ApngAnimatorOptions;)Loupson/apng/ApngAnimator;", "", "byteArray", "o", "([BLjava/lang/Float;Loupson/apng/utils/ApngAnimatorOptions;)Loupson/apng/ApngAnimator;", "Loupson/apng/b;", "extractedFrame", "k", "q", "r", "", "<set-?>", "a", "Z", "isPlaying", "()Z", "isPlaying$annotations", "()V", "value", "b", "Ljava/lang/Float;", "getSpeed", "()Ljava/lang/Float;", "u", "(Ljava/lang/Float;)V", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "imageView", "d", "Loupson/apng/CustomAnimationDrawable;", "l", "()Loupson/apng/CustomAnimationDrawable;", "s", "(Loupson/apng/CustomAnimationDrawable;)V", "getAnim$annotations", "anim", "e", "activeAnimation", "h", "Ljava/util/ArrayList;", "duration", "Landroid/widget/ImageView$ScaleType;", "i", "Landroid/widget/ImageView$ScaleType;", "scaleType", "j", "isApng", "t", "(Z)V", "isApng$annotations", "m", "setLoadNotApng", "getLoadNotApng$annotations", "loadNotApng", "Landroid/content/Context;", "Landroid/content/Context;", "context", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class ApngAnimator {

    /* renamed from: m  reason: collision with root package name */
    public static final a f52917m = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public boolean f52918a;

    /* renamed from: b  reason: collision with root package name */
    public Float f52919b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f52920c;

    /* renamed from: d  reason: collision with root package name */
    public CustomAnimationDrawable f52921d;

    /* renamed from: e  reason: collision with root package name */
    public CustomAnimationDrawable f52922e;

    /* renamed from: f  reason: collision with root package name */
    public l<? super ApngAnimator, Unit> f52923f;

    /* renamed from: g  reason: collision with root package name */
    public l<? super Integer, Unit> f52924g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Float> f52925h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView.ScaleType f52926i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f52927j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f52928k;

    /* renamed from: l  reason: collision with root package name */
    public final Context f52929l;

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Loupson/apng/ApngAnimator$a;", "", "<init>", "()V", "apng_library_release"}, k = 1, mv = {1, 4, 2})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public final ArrayList<Bitmap> k(ArrayList<b> arrayList) {
        Bitmap bitmap;
        ArrayList<b> arrayList2 = arrayList;
        ArrayList<Bitmap> arrayList3 = new ArrayList<>();
        this.f52925h = new ArrayList<>();
        int i11 = 0;
        Bitmap createBitmap = Bitmap.createBitmap(arrayList2.get(0).g().intValue(), arrayList2.get(0).f().intValue(), Bitmap.Config.ARGB_8888);
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = arrayList2.get(i12);
            Bitmap createBitmap2 = Bitmap.createBitmap(arrayList2.get(i11).g().intValue(), arrayList2.get(i11).f().intValue(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            Bitmap copy = BitmapFactory.decodeByteArray(bVar.b(), i11, bVar.b().length).copy(Bitmap.Config.ARGB_8888, true);
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
            if (bVar.a() == Utils.Companion.BlendOp.APNG_BLEND_OP_SOURCE) {
                bitmap = copy;
                canvas.drawRect((float) bVar.i(), (float) bVar.j(), ((float) copy.getWidth()) + ((float) bVar.i()), ((float) copy.getHeight()) + ((float) bVar.j()), (Paint) ApngAnimator$draw$1.INSTANCE.invoke());
            } else {
                bitmap = copy;
            }
            canvas.drawBitmap(bitmap, (float) bVar.i(), (float) bVar.j(), (Paint) null);
            arrayList3.add(createBitmap2);
            if (arrayList2.get(i12).d() == Utils.Companion.DisposeOp.APNG_DISPOSE_OP_PREVIOUS) {
                i11 = 0;
            } else if (bVar.d() == Utils.Companion.DisposeOp.APNG_DISPOSE_OP_BACKGROUND) {
                i11 = 0;
                createBitmap = Bitmap.createBitmap(arrayList2.get(0).g().intValue(), arrayList2.get(0).f().intValue(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                canvas2.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
                canvas2.drawRect((float) bVar.i(), (float) bVar.j(), ((float) bVar.h()) + ((float) bVar.i()), ((float) bVar.e()) + ((float) bVar.j()), (Paint) ApngAnimator$draw$2.INSTANCE.invoke());
            } else {
                i11 = 0;
                createBitmap = createBitmap2;
            }
            ArrayList<Float> arrayList4 = this.f52925h;
            if (arrayList4 != null) {
                float c11 = bVar.c();
                Float f11 = this.f52919b;
                arrayList4.add(Float.valueOf(c11 / (f11 != null ? f11.floatValue() : 1.0f)));
            }
        }
        return arrayList3;
    }

    public final CustomAnimationDrawable l() {
        return this.f52921d;
    }

    public final boolean m() {
        return this.f52928k;
    }

    public final ApngAnimator n(Uri uri, Float f11, ApngAnimatorOptions apngAnimatorOptions) {
        n1 unused = i.d(g1.f57277b, v0.b(), (CoroutineStart) null, new ApngAnimator$load$2(this, uri, f11, apngAnimatorOptions, (c) null), 2, (Object) null);
        return this;
    }

    public final ApngAnimator o(byte[] bArr, Float f11, ApngAnimatorOptions apngAnimatorOptions) {
        n1 unused = i.d(g1.f57277b, (CoroutineContext) null, (CoroutineStart) null, new ApngAnimator$load$3(this, f11, bArr, apngAnimatorOptions, (c) null), 3, (Object) null);
        return this;
    }

    public final ApngAnimator p(URL url, Float f11, ApngAnimatorOptions apngAnimatorOptions) {
        n1 unused = i.d(g1.f57277b, v0.b(), (CoroutineStart) null, new ApngAnimator$loadUrl$1(this, f11, url, apngAnimatorOptions, (c) null), 2, (Object) null);
        return this;
    }

    public final void q() {
        if (this.f52927j) {
            this.f52918a = false;
            CustomAnimationDrawable customAnimationDrawable = new CustomAnimationDrawable();
            CustomAnimationDrawable customAnimationDrawable2 = this.f52922e;
            if (customAnimationDrawable2 != null) {
                customAnimationDrawable2.stop();
            }
            Drawable current = this.f52922e.getCurrent();
            ArrayList<Float> arrayList = new ArrayList<>();
            CustomAnimationDrawable customAnimationDrawable3 = this.f52921d;
            int intValue = (customAnimationDrawable3 != null ? Integer.valueOf(customAnimationDrawable3.getNumberOfFrames()) : null).intValue();
            for (int i11 = 0; i11 < intValue; i11++) {
                if (this.f52922e.getFrame(i11) == current) {
                    int numberOfFrames = this.f52922e.getNumberOfFrames();
                    int i12 = i11;
                    while (true) {
                        float f11 = 1.0f;
                        if (i12 >= numberOfFrames) {
                            break;
                        }
                        Drawable frame = this.f52922e.getFrame(i12);
                        float floatValue = this.f52925h.get(i12).floatValue();
                        Float f12 = this.f52919b;
                        if (f12 != null) {
                            f11 = f12.floatValue();
                        }
                        customAnimationDrawable.addFrame(frame, (int) (floatValue / f11));
                        arrayList.add(this.f52925h.get(i12));
                        i12++;
                    }
                    for (int i13 = 0; i13 < i11; i13++) {
                        Drawable frame2 = this.f52922e.getFrame(i13);
                        float floatValue2 = this.f52925h.get(i13).floatValue();
                        Float f13 = this.f52919b;
                        customAnimationDrawable.addFrame(frame2, (int) (floatValue2 / (f13 != null ? f13.floatValue() : 1.0f)));
                        arrayList.add(this.f52925h.get(i13));
                    }
                    this.f52922e = customAnimationDrawable;
                    ImageView imageView = this.f52920c;
                    if (imageView != null) {
                        imageView.setImageDrawable(customAnimationDrawable);
                    }
                    CustomAnimationDrawable customAnimationDrawable4 = this.f52922e;
                    if (customAnimationDrawable4 != null) {
                        customAnimationDrawable4.a(this.f52924g);
                    }
                    ImageView imageView2 = this.f52920c;
                    if (imageView2 != null) {
                        imageView2.invalidate();
                    }
                    this.f52925h = arrayList;
                    return;
                }
            }
        }
    }

    public final void r() {
        if (this.f52927j) {
            this.f52918a = true;
            CustomAnimationDrawable customAnimationDrawable = this.f52922e;
            if (customAnimationDrawable != null) {
                customAnimationDrawable.start();
            }
        }
    }

    public final void s(CustomAnimationDrawable customAnimationDrawable) {
        this.f52921d = customAnimationDrawable;
    }

    public final void t(boolean z11) {
        this.f52927j = z11;
    }

    public final void u(Float f11) {
        if (this.f52927j) {
            this.f52919b = f11;
            try {
                q();
                r();
            } catch (Exception unused) {
            }
        }
    }

    public final void v(ArrayList<Bitmap> arrayList) {
        n1 unused = i.d(g1.f57277b, (CoroutineContext) null, (CoroutineStart) null, new ApngAnimator$setupAnimationDrawableAndStart$1(this, arrayList, (c) null), 3, (Object) null);
    }

    public final CustomAnimationDrawable w(ArrayList<Bitmap> arrayList) {
        if (this.f52927j) {
            CustomAnimationDrawable customAnimationDrawable = new CustomAnimationDrawable();
            customAnimationDrawable.setOneShot(false);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = new a(arrayList.get(i11));
                float floatValue = this.f52925h.get(i11).floatValue();
                Float f11 = this.f52919b;
                customAnimationDrawable.addFrame(aVar, (int) (floatValue / (f11 != null ? f11.floatValue() : 1.0f)));
            }
            return customAnimationDrawable;
        }
        throw new NotApngException();
    }
}
