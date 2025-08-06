package pa;

import android.app.Activity;
import com.hbg.lib.widgets.utils.PermissionUtils;
import com.luck.picture.lib.basic.PictureSelector;

public final /* synthetic */ class b implements PermissionUtils.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f52998a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f52999b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PictureSelector f53000c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f53001d;

    public /* synthetic */ b(d dVar, Activity activity, PictureSelector pictureSelector, e eVar) {
        this.f52998a = dVar;
        this.f52999b = activity;
        this.f53000c = pictureSelector;
        this.f53001d = eVar;
    }

    public final void onResult(int i11) {
        this.f52998a.A(this.f52999b, this.f53000c, this.f53001d, i11);
    }
}
