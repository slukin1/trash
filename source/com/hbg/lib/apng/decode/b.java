package com.hbg.lib.apng.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.hbg.lib.apng.decode.FrameSeqDecoder;
import com.hbg.lib.apng.io.APNGWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b extends FrameSeqDecoder<z5.a, APNGWriter> {

    /* renamed from: v  reason: collision with root package name */
    public APNGWriter f66170v;

    /* renamed from: w  reason: collision with root package name */
    public int f66171w;

    /* renamed from: x  reason: collision with root package name */
    public final Paint f66172x;

    /* renamed from: y  reason: collision with root package name */
    public C0715b f66173y = new C0715b();

    /* renamed from: com.hbg.lib.apng.decode.b$b  reason: collision with other inner class name */
    public class C0715b {

        /* renamed from: a  reason: collision with root package name */
        public byte f66174a;

        /* renamed from: b  reason: collision with root package name */
        public Rect f66175b;

        /* renamed from: c  reason: collision with root package name */
        public ByteBuffer f66176c;

        public C0715b() {
            this.f66175b = new Rect();
        }
    }

    public b(a6.b bVar, FrameSeqDecoder.j jVar) {
        super(bVar, jVar);
        Paint paint = new Paint();
        this.f66172x = paint;
        paint.setAntiAlias(true);
    }

    public void H() {
        this.f66173y.f66176c = null;
        this.f66170v = null;
    }

    public void J(g gVar) {
        if (gVar != null && this.f66149p != null) {
            try {
                Bitmap E = E(this.f66149p.width() / this.f66144k, this.f66149p.height() / this.f66144k);
                Canvas canvas = this.f66147n.get(E);
                if (canvas == null) {
                    canvas = new Canvas(E);
                    this.f66147n.put(E, canvas);
                }
                Canvas canvas2 = canvas;
                if (gVar instanceof c) {
                    this.f66148o.rewind();
                    E.copyPixelsFromBuffer(this.f66148o);
                    if (this.f66138e == 0) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else {
                        canvas2.save();
                        canvas2.clipRect(this.f66173y.f66175b);
                        C0715b bVar = this.f66173y;
                        byte b11 = bVar.f66174a;
                        if (b11 == 1) {
                            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                        } else if (b11 == 2) {
                            bVar.f66176c.rewind();
                            E.copyPixelsFromBuffer(this.f66173y.f66176c);
                        }
                        canvas2.restore();
                    }
                    if (((c) gVar).f66182h == 2) {
                        C0715b bVar2 = this.f66173y;
                        if (bVar2.f66174a != 2) {
                            bVar2.f66176c.rewind();
                            E.copyPixelsToBuffer(this.f66173y.f66176c);
                        }
                    }
                    this.f66173y.f66174a = ((c) gVar).f66182h;
                    canvas2.save();
                    if (((c) gVar).f66181g == 0) {
                        int i11 = gVar.f66205d;
                        int i12 = this.f66144k;
                        int i13 = gVar.f66206e;
                        canvas2.clipRect(i11 / i12, i13 / i12, (i11 + gVar.f66203b) / i12, (i13 + gVar.f66204c) / i12);
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    }
                    Rect rect = this.f66173y.f66175b;
                    int i14 = gVar.f66205d;
                    int i15 = this.f66144k;
                    int i16 = gVar.f66206e;
                    rect.set(i14 / i15, i16 / i15, (i14 + gVar.f66203b) / i15, (i16 + gVar.f66204c) / i15);
                    canvas2.restore();
                }
                Bitmap E2 = E(gVar.f66203b, gVar.f66204c);
                G(gVar.a(canvas2, this.f66172x, this.f66144k, E2, z()));
                G(E2);
                this.f66148o.rewind();
                E.copyPixelsToBuffer(this.f66148o);
                G(E);
            } catch (Error | Exception unused) {
            }
        }
    }

    /* renamed from: Q */
    public z5.a x(y5.a aVar) {
        return new z5.a(aVar);
    }

    /* renamed from: R */
    public APNGWriter z() {
        if (this.f66170v == null) {
            this.f66170v = new APNGWriter();
        }
        return this.f66170v;
    }

    /* renamed from: S */
    public Rect F(z5.a aVar) throws IOException {
        List<d> a11 = APNGParser.a(aVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        Iterator<d> it2 = a11.iterator();
        c cVar = null;
        boolean z11 = false;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            d next = it2.next();
            if (next instanceof a) {
                this.f66171w = ((a) next).f66169f;
                z11 = true;
            } else if (next instanceof e) {
                cVar = new c(aVar, (e) next);
                cVar.f66185k = arrayList;
                cVar.f66183i = bArr;
                this.f66137d.add(cVar);
            } else if (next instanceof f) {
                if (cVar != null) {
                    cVar.f66184j.add(next);
                }
            } else if (next instanceof h) {
                if (!z11) {
                    k kVar = new k(aVar);
                    kVar.f66203b = i11;
                    kVar.f66204c = i12;
                    this.f66137d.add(kVar);
                    this.f66171w = 1;
                    break;
                } else if (cVar != null) {
                    cVar.f66184j.add(next);
                }
            } else if (next instanceof j) {
                j jVar = (j) next;
                i11 = jVar.f66211e;
                i12 = jVar.f66212f;
                bArr = jVar.f66213g;
            } else if (!(next instanceof i)) {
                arrayList.add(next);
            }
        }
        int i13 = i11 * i12;
        int i14 = this.f66144k;
        this.f66148o = ByteBuffer.allocate(((i13 / (i14 * i14)) + 1) * 4);
        C0715b bVar = this.f66173y;
        int i15 = this.f66144k;
        bVar.f66176c = ByteBuffer.allocate(((i13 / (i15 * i15)) + 1) * 4);
        return new Rect(0, 0, i11, i12);
    }

    public int v() {
        return this.f66171w;
    }
}
