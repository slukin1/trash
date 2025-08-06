package ac;

import al.p;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import com.hbg.lib.core.BaseModuleConfig;
import com.tencent.android.tpush.common.Constants;
import e6.g;
import f6.c;
import zb.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f76981a = new b();

    public static final void e(ImageView imageView, String str, int i11) {
        try {
            if (imageView.getContext() == null) {
                return;
            }
            if (!a.c(str)) {
                if (StringsKt__StringsJVMKt.M(str, "http", false, 2, (Object) null)) {
                    if (i11 == 0) {
                        i11 = p.m();
                    }
                    c.a().h(imageView, str, i11);
                    return;
                }
                Drawable s11 = g.v().s(imageView.getContext().getResources(), str);
                if (s11 == null && i11 != 0) {
                    s11 = imageView.getResources().getDrawable(i11);
                }
                imageView.setImageDrawable(s11);
            }
        } catch (Throwable th2) {
            Log.e("EdgeEngine", "image 加载异常 " + th2.getMessage());
            th2.printStackTrace();
        }
    }

    public final rj.b b(Context context) {
        rj.b F = BaseModuleConfig.a().F(context, Constants.FLAG_ACCOUNT);
        d(F);
        return F;
    }

    public final void c(rj.b bVar) {
        if (bVar != null) {
            BaseModuleConfig.a().C(Constants.FLAG_ACCOUNT);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void d(rj.b bVar) {
        bVar.J(a.f3516a);
    }
}
