package com.huobi.staring.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.annotation.Keep;
import androidx.viewpager.widget.ViewPager;
import bh.j;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.view.TabTitleLayout;
import cs.p;
import ds.d;
import gs.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;

@Route(path = "/reminder/all")
public class AllRemindNewActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public TabTitleLayout f81181b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f81182c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<AllRemindNewFragment> f81183d;

    /* renamed from: e  reason: collision with root package name */
    public List<io.a> f81184e;

    /* renamed from: f  reason: collision with root package name */
    public final io.c f81185f = new io.c(1, R.drawable.alert_add_remind, new d(this));

    /* renamed from: g  reason: collision with root package name */
    public final io.c f81186g = new io.c(2, R.drawable.market_icon_edit, new a());

    /* renamed from: h  reason: collision with root package name */
    public final io.b f81187h = new io.b(3, 0, j.d(R.string.market_edit_collection_finish_text), new b());

    public class a implements ho.a {
        public a() {
        }

        public void o7(io.a aVar) {
            AllRemindNewFragment allRemindNewFragment = (AllRemindNewFragment) AllRemindNewActivity.this.f81183d.get(p.c().a());
            allRemindNewFragment.ui(true);
            allRemindNewFragment.Wh().j();
            allRemindNewFragment.ri(false);
        }
    }

    public class b implements ho.a {
        public b() {
        }

        public void o7(io.a aVar) {
            AllRemindNewFragment allRemindNewFragment = (AllRemindNewFragment) AllRemindNewActivity.this.f81183d.get(p.c().a());
            allRemindNewFragment.ui(false);
            allRemindNewFragment.Wh().j();
            allRemindNewFragment.ri(false);
        }
    }

    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            p.c().h(i11);
            Iterator it2 = AllRemindNewActivity.this.f81183d.iterator();
            while (it2.hasNext()) {
                AllRemindNewFragment allRemindNewFragment = (AllRemindNewFragment) it2.next();
                if (allRemindNewFragment.ui(false)) {
                    allRemindNewFragment.Wh().j();
                    allRemindNewFragment.ri(false);
                }
            }
            AllRemindNewActivity.this.gg(i11);
        }
    }

    public static Intent Og(Activity activity) {
        return new Intent(activity, AllRemindNewActivity.class);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oh(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ph(io.a aVar) {
        RemindSearchListActivity.gg(this);
        HashMap hashMap = new HashMap();
        hashMap.put("Page_name", p.c().g() ? "Derivatives" : "Spot");
        g.i("Alert_Create_icon_Me_click", hashMap);
    }

    public final void Pg() {
        this.f81183d = new ArrayList<>();
        this.f81183d.add(new ProRemindFragment());
        this.f81183d.add(new AllRemindNewFragment(true));
        this.f81182c.setAdapter(new as.a(getSupportFragmentManager(), this.f81183d));
    }

    public final void Qg() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.n_title_spot));
        arrayList.add(getString(R.string.n_tab_contract));
        ArrayList arrayList2 = new ArrayList();
        this.f81184e = arrayList2;
        this.f81181b.initTitleMenu(this.f81182c, arrayList, arrayList2);
        this.f81181b.setOnBackClickCallback(new ds.c(this));
    }

    public void addEvent() {
        super.addEvent();
    }

    public void afterInit() {
        super.afterInit();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        this.f81182c.setCurrentItem(p.c().b());
    }

    public int getContentView() {
        return R.layout.activity_all_remind_new;
    }

    public final void gg(int i11) {
        AllRemindNewFragment allRemindNewFragment = this.f81183d.get(i11);
        if (allRemindNewFragment.bi()) {
            this.f81184e.clear();
            this.f81181b.updateMenu(this.f81184e);
            return;
        }
        this.f81184e.clear();
        if (allRemindNewFragment.Ph()) {
            this.f81184e.add(this.f81187h);
        } else {
            this.f81184e.add(this.f81185f);
            this.f81184e.add(this.f81186g);
        }
        this.f81181b.updateMenu(this.f81184e);
    }

    public void initView() {
        super.initView();
        this.f81181b = (TabTitleLayout) this.viewFinder.b(R.id.layout_title);
        ViewPager viewPager = (ViewPager) this.viewFinder.b(R.id.id_trade_order_viewPager);
        this.f81182c = viewPager;
        viewPager.addOnPageChangeListener(new c());
        Pg();
        Qg();
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    public void onRestart() {
        super.onRestart();
        this.f81182c.setCurrentItem(p.c().b());
        ArrayList<AllRemindNewFragment> arrayList = this.f81183d;
        if (arrayList != null) {
            Iterator<AllRemindNewFragment> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().Th(false);
            }
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(this, new JumpTarget((Intent) null, (Intent) null));
        finish();
    }

    public void qh(int i11) {
        if (i11 == p.c().a()) {
            gg(i11);
        }
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
