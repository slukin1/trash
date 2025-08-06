package ad;

import androidx.fragment.app.FragmentManager;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.grid.bean.GridAuth;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.exchange.grid.ui.GridUserGuideFragment;
import u6.g;
import vc.b;
import yc.c;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f19368a = false;

    public class a extends BaseSubscriber<GridAuth> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentManager f19369b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f19370c;

        public a(FragmentManager fragmentManager, g gVar) {
            this.f19369b = fragmentManager;
            this.f19370c = gVar;
        }

        /* renamed from: a */
        public void onNext(GridAuth gridAuth) {
            if (!c.f()) {
                m.d(this.f19369b, this.f19370c);
            }
        }
    }

    public static void b(FragmentManager fragmentManager, g gVar) {
        if (b.a().a()) {
            c.c(false).compose(RxJavaHelper.t(gVar)).subscribe(new a(fragmentManager, gVar));
        }
    }

    public static void d(FragmentManager fragmentManager, g gVar) {
        if (!f19368a && b.a().a() && gVar.isCanBeSeen()) {
            f19368a = true;
            GridUserGuideFragment yh2 = GridUserGuideFragment.yh();
            yh2.Ah(l.f3528a);
            yh2.show(fragmentManager, "GridUserGuideDialogTag");
        }
    }
}
