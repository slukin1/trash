package cs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import bs.a;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.staring.helper.StaringRemindHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pro.huobi.R;
import rx.functions.Action0;
import rx.functions.Action1;
import u6.g;

public abstract class h implements a.C0828a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f83805a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f83806b;

    /* renamed from: c  reason: collision with root package name */
    public bs.a f83807c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<Long> f83808d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public g f83809e;

    /* renamed from: f  reason: collision with root package name */
    public d f83810f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f83811g;

    public class a extends q6.d {
        public a(g gVar, Action0 action0, Action1 action1, Action1 action12, Action1 action13, Action0 action02) {
            super(gVar, action0, action1, action12, action13, action02);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!"1011".equalsIgnoreCase(aPIStatusErrorException.getErrCode())) {
                super.onFailed(aPIStatusErrorException);
            }
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            boolean unused = h.this.f83806b = false;
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = h.this.f83806b = true;
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ bs.a f83814b;

        public c(bs.a aVar) {
            this.f83814b = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            h.this.G(this.f83814b.h());
            if (h.this.f83810f != null) {
                h.this.f83810f.a(this.f83814b);
            }
        }
    }

    public interface d {
        void J0();

        void a(bs.a aVar);

        void b(bs.a aVar);
    }

    public h(g gVar, d dVar) {
        this.f83809e = gVar;
        this.f83810f = dVar;
    }

    public static /* synthetic */ void A(View view, ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(View view, View view2, bs.a aVar, Object obj) {
        HuobiToastUtil.s(R.string.staring_remind_delete_success);
        this.f83807c = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{view.getWidth(), view2.getWidth()});
        ofInt.addUpdateListener(new a(view));
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(270);
        ofInt.addListener(new b());
        ofInt.start();
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{view.getHeight(), 0});
        ofInt2.addUpdateListener(new b(view2));
        ofInt2.addListener(new c(aVar));
        ofInt2.setInterpolator(new DecelerateInterpolator());
        ofInt2.setDuration(270);
        ofInt2.start();
    }

    public static /* synthetic */ void C(Object obj) {
    }

    public static /* synthetic */ void D(Object obj) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E() {
        this.f83805a = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y() {
        this.f83805a = true;
    }

    public static /* synthetic */ void z(View view, ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view.setLayoutParams(layoutParams);
    }

    public void F() {
        i((bs.a) null);
    }

    public void G(long j11) {
        this.f83808d.remove(Long.valueOf(j11));
    }

    public void H(boolean z11) {
        this.f83811g = z11;
    }

    public boolean a() {
        return this.f83811g;
    }

    public void b(boolean z11) {
        this.f83806b = z11;
    }

    public boolean c(bs.a aVar) {
        return this.f83808d.contains(Long.valueOf(aVar.h()));
    }

    public void d(boolean z11, bs.a aVar) {
        if (z11) {
            this.f83808d.remove(Long.valueOf(aVar.h()));
        } else {
            this.f83808d.add(Long.valueOf(aVar.h()));
        }
        d dVar = this.f83810f;
        if (dVar != null) {
            dVar.J0();
        }
    }

    public void h(bs.a aVar, View view, View view2) {
        if (!this.f83806b && !this.f83805a) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(aVar.h()));
            a aVar2 = new a(this.f83809e, new d(this), new e(this, view2, view, aVar), g.f53479b, f.f53478b, new c(this));
            if (f()) {
                n.u(arrayList, this.f83809e, aVar2);
            } else {
                StaringRemindHelper.m(arrayList, this.f83809e, aVar2);
            }
        }
    }

    public void i(bs.a aVar) {
        d dVar;
        if (!this.f83806b) {
            boolean z11 = false;
            bs.a aVar2 = this.f83807c;
            if (aVar2 != null) {
                aVar2.j(3);
                z11 = true;
            }
            this.f83807c = null;
            if (z11) {
                d dVar2 = this.f83810f;
                if (dVar2 != null) {
                    dVar2.J0();
                }
            } else if (aVar != null && (dVar = this.f83810f) != null) {
                dVar.b(aVar);
            }
        }
    }

    public void j(bs.a aVar) {
        if (!this.f83806b) {
            bs.a aVar2 = this.f83807c;
            if (aVar2 != null) {
                aVar2.j(3);
            }
            this.f83807c = aVar;
            aVar.j(2);
            d dVar = this.f83810f;
            if (dVar != null) {
                dVar.J0();
            }
        }
    }

    public void u(long j11) {
        this.f83808d.add(Long.valueOf(j11));
    }

    public void v() {
        this.f83808d.clear();
        F();
    }

    public List<Long> w() {
        return new ArrayList(this.f83808d);
    }

    public boolean x() {
        return this.f83807c != null;
    }
}
