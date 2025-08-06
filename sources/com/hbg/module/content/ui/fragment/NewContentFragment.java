package com.hbg.module.content.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.hbg.lib.network.hbg.core.bean.NewFlashCategory;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.ui.activity.live.edgeengine.TabDialogFragment;
import com.hbg.module.content.ui.fragment.NewsChildFragment;
import com.hbg.module.libkt.base.ext.f;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.jumio.sdk.reject.JumioRejectReason;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import lc.a2;
import org.json.JSONArray;
import org.json.JSONObject;
import rd.s;

public final class NewContentFragment extends BaseFragment<a2> {
    public static final a B = new a((r) null);
    public int A;

    /* renamed from: p  reason: collision with root package name */
    public final String f18767p = "nav.newsNavList";

    /* renamed from: q  reason: collision with root package name */
    public final String f18768q = "nav.getNewsNav()";

    /* renamed from: r  reason: collision with root package name */
    public final String f18769r = "nav.deepNavList";

    /* renamed from: s  reason: collision with root package name */
    public final String f18770s = "nav.getDeepNav()";

    /* renamed from: t  reason: collision with root package name */
    public final String f18771t = "nav.allNavList";

    /* renamed from: u  reason: collision with root package name */
    public final String f18772u = "nav.getAllNewsNav()";

    /* renamed from: v  reason: collision with root package name */
    public int f18773v = 1;

    /* renamed from: w  reason: collision with root package name */
    public rj.b f18774w;

    /* renamed from: x  reason: collision with root package name */
    public final ArrayList<TabData> f18775x = new ArrayList<>();

    /* renamed from: y  reason: collision with root package name */
    public final ArrayList<Fragment> f18776y = new ArrayList<>();

    /* renamed from: z  reason: collision with root package name */
    public int f18777z = -1;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public static /* synthetic */ NewContentFragment b(a aVar, rj.b bVar, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i11 = 1;
            }
            return aVar.a(bVar, i11);
        }

        public final NewContentFragment a(rj.b bVar, int i11) {
            NewContentFragment newContentFragment = new NewContentFragment();
            newContentFragment.di(bVar);
            Bundle bundle = new Bundle();
            bundle.putInt("tabType", i11);
            newContentFragment.setArguments(bundle);
            return newContentFragment;
        }
    }

    public static final class b implements ne.c {
        public void a(int i11) {
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18778b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18779c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewContentFragment f18780d;

        public c(View view, long j11, NewContentFragment newContentFragment) {
            this.f18778b = view;
            this.f18779c = j11;
            this.f18780d = newContentFragment;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18778b) > this.f18779c || (this.f18778b instanceof Checkable)) {
                sVar.e(this.f18778b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18778b;
                new TabDialogFragment(this.f18780d.f18774w, this.f18780d.f18773v).show(this.f18780d.getChildFragmentManager(), "");
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final void Zh(NewContentFragment newContentFragment, Object obj) {
        Fragment fragment;
        ArrayList arrayList = (ArrayList) f.e().fromJson(f.f(obj), new NewContentFragment$initView$lambda$3$$inlined$gsonToBean$1().getType());
        if (arrayList != null) {
            if (!com.hbg.module.libkt.base.ext.b.w(arrayList)) {
                newContentFragment.f18775x.clear();
                newContentFragment.f18776y.clear();
                newContentFragment.A = 0;
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    NewFlashCategory newFlashCategory = (NewFlashCategory) it2.next();
                    int i11 = 1;
                    if (newFlashCategory.isChoose == 1) {
                        newContentFragment.f18775x.add(new TabData(newFlashCategory.title, 0, 0, 6, (r) null));
                        ArrayList<Fragment> arrayList2 = newContentFragment.f18776y;
                        int i12 = newContentFragment.f18773v;
                        if (i12 == 8) {
                            if (newFlashCategory.categoryType != 2) {
                                i11 = 3;
                            }
                            fragment = newContentFragment.Wh(i11, newFlashCategory);
                        } else {
                            fragment = newContentFragment.Wh(i12, newFlashCategory);
                        }
                        arrayList2.add(fragment);
                    }
                }
                if (!com.hbg.module.libkt.base.ext.b.w(newContentFragment.f18775x)) {
                    he.a aVar = new he.a(newContentFragment.getActivity());
                    aVar.a(newContentFragment.f18776y);
                    ((a2) newContentFragment.uh()).E.setAdapter(aVar);
                    newContentFragment.Yh();
                }
            }
            Unit unit = Unit.f56620a;
        }
    }

    public static final void ai(NewContentFragment newContentFragment, Object obj) {
        try {
            if (x.b(obj.toString(), JumioRejectReason.NOT_READABLE)) {
                newContentFragment.ci();
            }
        } catch (Throwable unused) {
        }
    }

    public static final void bi(NewContentFragment newContentFragment, Object obj) {
        ArrayList arrayList = (ArrayList) f.e().fromJson(f.f(obj), new NewContentFragment$initView$lambda$6$$inlined$gsonToBean$1().getType());
        if (arrayList != null && !com.hbg.module.libkt.base.ext.b.w(arrayList)) {
            JSONArray jSONArray = new JSONArray();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                NewFlashCategory newFlashCategory = (NewFlashCategory) it2.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", newFlashCategory.categoryId);
                jSONObject.put("topicType", newFlashCategory.categoryType);
                jSONArray.put(jSONObject);
            }
            rj.b bVar = newContentFragment.f18774w;
            if (bVar != null) {
                bVar.I("nav.saveNav(" + jSONArray + ')');
            }
        }
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f18773v = arguments.getInt("tabType");
        }
    }

    public final Fragment Wh(int i11, NewFlashCategory newFlashCategory) {
        if (i11 != 1) {
            return DeepNewsChildFragment.f18731x.a(newFlashCategory.categoryId);
        }
        NewsChildFragment.a aVar = NewsChildFragment.H;
        int i12 = newFlashCategory.categoryId;
        String str = newFlashCategory.title;
        int i13 = this.A;
        if (i13 == 0) {
            this.A = i13 + 1;
            i13 = -2;
        }
        return NewsChildFragment.a.b(aVar, i12, str, (String) null, i13, 4, (Object) null);
    }

    /* renamed from: Xh */
    public a2 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return a2.K(layoutInflater, viewGroup, false);
    }

    public final void Yh() {
        if (com.hbg.module.libkt.base.ext.b.e(getActivity())) {
            ((a2) uh()).E.setOffscreenPageLimit(this.f18775x.size());
            ne.b.f(getActivity(), this.f18775x, ((a2) uh()).B, ((a2) uh()).E, 12.0f, new b(), R$color.baseColorSecondaryText, R$color.baseColorMajorTheme100, 0, R$drawable.bg_content_2nd_nav_sel, 8.0f, 4.0f, 8.0f, 4.0f, 256, (Object) null);
        }
    }

    public final void ci() {
        String str;
        rj.b bVar = this.f18774w;
        if (bVar != null) {
            int i11 = this.f18773v;
            if (i11 == 1) {
                str = this.f18768q;
            } else if (i11 != 3) {
                str = this.f18772u;
            } else {
                str = this.f18770s;
            }
            bVar.I(str);
        }
    }

    public final void di(rj.b bVar) {
        this.f18774w = bVar;
    }

    public void initView() {
        String str;
        rj.b bVar = this.f18774w;
        if (bVar != null) {
            int i11 = this.f18773v;
            if (i11 == 1) {
                str = this.f18767p;
            } else if (i11 != 3) {
                str = this.f18771t;
            } else {
                str = this.f18769r;
            }
            bVar.u(str, new h(this));
        }
        rj.b bVar2 = this.f18774w;
        if (bVar2 != null) {
            bVar2.u("nav.saveNavStatus", new f(this));
        }
        rj.b bVar3 = this.f18774w;
        if (bVar3 != null) {
            bVar3.u("nav.tabSelectList", new g(this));
        }
        ci();
        s sVar = s.f23381a;
        ImageView imageView = ((a2) uh()).C;
        imageView.setOnClickListener(new c(imageView, 800, this));
    }
}
