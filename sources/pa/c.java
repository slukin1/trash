package pa;

import com.luck.picture.lib.basic.PictureSelector;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f53002b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PictureSelector f53003c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f53004d;

    public /* synthetic */ c(d dVar, PictureSelector pictureSelector, e eVar) {
        this.f53002b = dVar;
        this.f53003c = pictureSelector;
        this.f53004d = eVar;
    }

    public final void run() {
        this.f53002b.z(this.f53003c, this.f53004d);
    }
}
