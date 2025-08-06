package com.huobi.staring.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import as.b;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.huobi.view.TabTitleLayout;
import cs.p;
import ds.w0;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class RemindSearchListActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public TabTitleLayout f81246b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<RemindSearchListFragment> f81247c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager f81248d;

    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            p.c().h(i11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fg(View view) {
        finish();
    }

    public static void gg(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, RemindSearchListActivity.class));
        }
    }

    public final void Yf() {
        this.f81247c = new ArrayList<>();
        this.f81247c.add(new RemindSearchListFragment());
        this.f81247c.add(new RemindSearchListFragment(true));
        this.f81248d.setAdapter(new b(getSupportFragmentManager(), this.f81247c));
    }

    public final void Zf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.n_title_spot));
        arrayList.add(getString(R.string.n_tab_contract));
        this.f81246b.initTitleMenu(this.f81248d, arrayList, (List<io.a>) null);
        this.f81246b.setOnBackClickCallback(new w0(this));
    }

    public void addEvent() {
        super.addEvent();
    }

    public void afterInit() {
        super.afterInit();
        this.f81248d.setCurrentItem(p.c().b());
    }

    public int getContentView() {
        return R.layout.activity_remind_coin_list;
    }

    public void initView() {
        super.initView();
        this.f81246b = (TabTitleLayout) this.viewFinder.b(R.id.layout_title);
        ViewPager viewPager = (ViewPager) this.viewFinder.b(R.id.id_trade_order_viewPager);
        this.f81248d = viewPager;
        viewPager.addOnPageChangeListener(new a());
        Yf();
        Zf();
    }

    public void onRestart() {
        super.onRestart();
        this.f81248d.setCurrentItem(p.c().b());
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
