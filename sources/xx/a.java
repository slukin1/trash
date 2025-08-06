package xx;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.utils.SVGAScaleInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import yx.f;
import yx.g;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0005R\u00020\u00000\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\t2\u0010\u0010\b\u001a\f\u0012\b\u0012\u00060\u0005R\u00020\u00000\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lxx/a;", "", "", "frameIndex", "", "Lxx/a$a;", "e", "(I)Ljava/util/List;", "sprites", "", "d", "(Ljava/util/List;)V", "Landroid/graphics/Canvas;", "canvas", "Landroid/widget/ImageView$ScaleType;", "scaleType", "a", "Lcom/opensource/svgaplayer/utils/SVGAScaleInfo;", "scaleInfo", "Lcom/opensource/svgaplayer/utils/SVGAScaleInfo;", "b", "()Lcom/opensource/svgaplayer/utils/SVGAScaleInfo;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "c", "()Lcom/opensource/svgaplayer/SVGAVideoEntity;", "<init>", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final SVGAScaleInfo f29379a = new SVGAScaleInfo();

    /* renamed from: b  reason: collision with root package name */
    public final zx.a<C0259a> f29380b;

    /* renamed from: c  reason: collision with root package name */
    public final SVGAVideoEntity f29381c;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0004\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lxx/a$a;", "", "", "c", "()Ljava/lang/String;", "matteKey", "b", "imageKey", "Lyx/g;", "a", "()Lyx/g;", "frameEntity", "_matteKey", "Ljava/lang/String;", "get_matteKey", "f", "(Ljava/lang/String;)V", "_imageKey", "get_imageKey", "e", "_frameEntity", "Lyx/g;", "get_frameEntity", "d", "(Lyx/g;)V", "<init>", "(Lxx/a;Ljava/lang/String;Ljava/lang/String;Lyx/g;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    /* renamed from: xx.a$a  reason: collision with other inner class name */
    public final class C0259a {

        /* renamed from: a  reason: collision with root package name */
        public String f29382a;

        /* renamed from: b  reason: collision with root package name */
        public String f29383b;

        /* renamed from: c  reason: collision with root package name */
        public g f29384c;

        public C0259a(String str, String str2, g gVar) {
            this.f29382a = str;
            this.f29383b = str2;
            this.f29384c = gVar;
        }

        public final g a() {
            g gVar = this.f29384c;
            if (gVar == null) {
                x.j();
            }
            return gVar;
        }

        public final String b() {
            return this.f29383b;
        }

        public final String c() {
            return this.f29382a;
        }

        public final void d(g gVar) {
            this.f29384c = gVar;
        }

        public final void e(String str) {
            this.f29383b = str;
        }

        public final void f(String str) {
            this.f29382a = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0259a(a aVar, String str, String str2, g gVar, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : gVar);
        }
    }

    public a(SVGAVideoEntity sVGAVideoEntity) {
        this.f29381c = sVGAVideoEntity;
        this.f29380b = new zx.a<>(Math.max(1, sVGAVideoEntity.q().size()));
    }

    public void a(Canvas canvas, int i11, ImageView.ScaleType scaleType) {
        this.f29379a.f((float) canvas.getWidth(), (float) canvas.getHeight(), (float) this.f29381c.r().b(), (float) this.f29381c.r().a(), scaleType);
    }

    public final SVGAScaleInfo b() {
        return this.f29379a;
    }

    public final SVGAVideoEntity c() {
        return this.f29381c;
    }

    public final void d(List<C0259a> list) {
        for (C0259a c11 : list) {
            this.f29380b.c(c11);
        }
    }

    public final List<C0259a> e(int i11) {
        String b11;
        List<f> q11 = this.f29381c.q();
        ArrayList arrayList = new ArrayList();
        for (f fVar : q11) {
            C0259a aVar = null;
            if (i11 >= 0 && i11 < fVar.a().size() && (b11 = fVar.b()) != null && (StringsKt__StringsJVMKt.v(b11, ".matte", false, 2, (Object) null) || fVar.a().get(i11).a() > 0.0d)) {
                aVar = this.f29380b.a();
                if (aVar == null) {
                    aVar = new C0259a(this, (String) null, (String) null, (g) null, 7, (r) null);
                }
                aVar.f(fVar.c());
                aVar.e(fVar.b());
                aVar.d(fVar.a().get(i11));
            }
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
