package com.huobi.index.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.index.bean.QuickAdditionFeature;
import com.huobi.index.bean.QuickAdditionItem;
import com.huobi.index.presenter.QuickAdditionPresenter;
import com.huobi.index.presenter.h0;
import com.huobi.index.ui.widget.QuickAdditionAdapter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import f6.c;
import gs.g;
import i6.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pro.huobi.R;
import rx.subjects.BehaviorSubject;
import z9.g1;

@Route(path = "/home/ReplaceFunction")
public class QuickAdditionFragment extends BaseDialogFragment implements View.OnClickListener, QuickAdditionAdapter.c, QuickAdditionPresenter.c {

    /* renamed from: b  reason: collision with root package name */
    public ConstraintLayout f74070b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f74071c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f74072d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f74073e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f74074f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f74075g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f74076h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f74077i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f74078j;

    /* renamed from: k  reason: collision with root package name */
    public Button f74079k;

    /* renamed from: l  reason: collision with root package name */
    public Button f74080l;

    /* renamed from: m  reason: collision with root package name */
    public QuickAdditionAdapter f74081m;

    /* renamed from: n  reason: collision with root package name */
    public QuickAdditionPresenter f74082n;

    /* renamed from: o  reason: collision with root package name */
    public g1 f74083o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f74084p = false;
    @Autowired(name = "title")

    /* renamed from: q  reason: collision with root package name */
    public String f74085q;
    @Autowired(name = "imgUrl")

    /* renamed from: r  reason: collision with root package name */
    public String f74086r;
    @Autowired(name = "groupCode")

    /* renamed from: s  reason: collision with root package name */
    public String f74087s;

    /* renamed from: t  reason: collision with root package name */
    public ArrayList<IndexFeatureItem> f74088t = new ArrayList<>();

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            int lineCount = QuickAdditionFragment.this.f74075g.getLineCount();
            Log.d("QuickAdditionFragment", "lineCount:" + lineCount);
            if (lineCount > 1) {
                QuickAdditionFragment.this.f74075g.setTextSize(1, 9.0f);
            } else {
                QuickAdditionFragment.this.f74075g.setTextSize(1, 11.0f);
            }
            QuickAdditionFragment.this.f74075g.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public void T3(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("updateFailure:");
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        Log.d("QuickAdditionFragment", sb2.toString());
        if (this.f74088t.size() >= 19) {
            HuobiToastUtil.p(R.string.n_quick_addition_replace_failure);
        } else {
            HuobiToastUtil.p(R.string.n_quick_addition_add_failure);
        }
        dismiss();
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
        this.f74075g.setText(this.f74085q);
        this.f74075g.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        c.a().f(this.f74074f, this.f74086r, NightHelper.e().g() ? R.drawable.home_ac_image_night : R.drawable.home_ac_image);
        QuickAdditionAdapter quickAdditionAdapter = new QuickAdditionAdapter();
        this.f74081m = quickAdditionAdapter;
        quickAdditionAdapter.a(this);
        this.f74077i.setLayoutManager(new GridLayoutManager(getContext(), 5));
        this.f74077i.setAdapter(this.f74081m);
        QuickAdditionPresenter quickAdditionPresenter = this.f74082n;
        if (quickAdditionPresenter != null) {
            quickAdditionPresenter.onUIReady((BaseCoreActivity) getActivity(), this);
        }
        QuickAdditionPresenter quickAdditionPresenter2 = this.f74082n;
        if (quickAdditionPresenter2 != null) {
            quickAdditionPresenter2.T();
        }
    }

    public boolean contentViewIsFullWidth() {
        return true;
    }

    public void dismissProgressDialog() {
        g1 g1Var = this.f74083o;
        if (g1Var != null) {
            g1Var.dismiss();
        }
    }

    public int getContentViewResId() {
        return R.layout.dialog_quick_addition;
    }

    public int getGravity() {
        return 80;
    }

    public /* synthetic */ BehaviorSubject getUIChangeSubject() {
        return h0.a(this);
    }

    public void initView(r rVar) {
        this.f74070b = (ConstraintLayout) rVar.b(R.id.add_to_quick_container);
        this.f74071c = (TextView) rVar.b(R.id.add_to_quick_title);
        this.f74072d = (TextView) rVar.b(R.id.add_to_quick_top_cancel);
        this.f74073e = (LinearLayout) rVar.b(R.id.add_to_quick_item_layout);
        this.f74074f = (ImageView) rVar.b(R.id.add_to_quick_item_icon);
        this.f74075g = (TextView) rVar.b(R.id.add_to_quick_item_text);
        this.f74076h = (ImageView) rVar.b(R.id.add_to_quick_arrow);
        this.f74077i = (RecyclerView) rVar.b(R.id.add_to_quick_recycler_view);
        this.f74078j = (TextView) rVar.b(R.id.add_to_quick_desc);
        this.f74079k = (Button) rVar.b(R.id.add_to_quick_cancel);
        this.f74080l = (Button) rVar.b(R.id.add_to_quick_confirm);
        this.f74072d.setOnClickListener(this);
        this.f74079k.setOnClickListener(this);
        this.f74080l.setOnClickListener(this);
    }

    public void initWindow(Window window) {
        super.initWindow(window);
    }

    public boolean isAlive() {
        return this.f74084p;
    }

    public /* synthetic */ boolean isCanBeSeen() {
        return h0.b(this);
    }

    public boolean isFullScreen() {
        return false;
    }

    public boolean isTransparent() {
        return false;
    }

    public void m4(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("updateSuccess:");
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        Log.d("QuickAdditionFragment", sb2.toString());
        if (this.f74088t.size() >= 19) {
            HuobiToastUtil.p(R.string.n_quick_addition_replace_success);
        } else {
            HuobiToastUtil.p(R.string.n_quick_addition_has_added_to_home);
        }
        dismiss();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.d("QuickAdditionFragment", "onActivityCreated");
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(getDialog().getContext().getResources().getDisplayMetrics().widthPixels, -2);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("QuickAdditionFragment", "onAttach");
        if (this.f74082n == null) {
            this.f74082n = th();
        }
    }

    @SuppressLint({"NonConstantResourceId"})
    @SensorsDataInstrumented
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_to_quick_cancel:
                g.i("addServer2home_cancel_click", (HashMap) null);
                dismiss();
                break;
            case R.id.add_to_quick_confirm:
                g.i("addServer2home_replace_click", (HashMap) null);
                if (this.f74082n != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i11 = 0; i11 < this.f74088t.size(); i11++) {
                        if ("0".equals(this.f74088t.get(i11).getHomePageFixed())) {
                            if (this.f74088t.get(i11).isSelected()) {
                                arrayList.add(this.f74087s);
                            } else {
                                arrayList.add(this.f74088t.get(i11).getGroupCode());
                            }
                        }
                    }
                    this.f74082n.V(arrayList);
                    break;
                }
                break;
            case R.id.add_to_quick_top_cancel:
                dismiss();
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f74084p = true;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f74085q = arguments.getString("title");
            this.f74086r = arguments.getString("imgUrl");
            this.f74087s = arguments.getString("groupCode");
        }
        Log.d("QuickAdditionFragment", "onCreate -- > title:" + this.f74085q + " imageUrl:" + this.f74086r + " groupCode:" + this.f74087s);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d("QuickAdditionFragment", "onDestroy");
        this.f74084p = false;
        QuickAdditionPresenter quickAdditionPresenter = this.f74082n;
        if (quickAdditionPresenter != null) {
            quickAdditionPresenter.U();
        }
    }

    public void onItemClick(View view, int i11) {
        int i12 = 0;
        while (true) {
            boolean z11 = true;
            if (i12 >= this.f74088t.size()) {
                break;
            }
            IndexFeatureItem indexFeatureItem = this.f74088t.get(i12);
            if (i12 != i11) {
                z11 = false;
            }
            indexFeatureItem.setSelected(z11);
            i12++;
        }
        this.f74078j.setText(String.format(getResources().getString(R.string.n_quick_addition_be_replaced_desc), new Object[]{this.f74088t.get(i11).getTitle()}));
        QuickAdditionAdapter quickAdditionAdapter = this.f74081m;
        if (quickAdditionAdapter != null) {
            quickAdditionAdapter.notifyDataSetChanged();
        }
    }

    public void onResume() {
        super.onResume();
        Log.d("QuickAdditionFragment", "onResume");
    }

    public void onStart() {
        super.onStart();
        wh();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Log.d("QuickAdditionFragment", "onViewCreated");
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
        Log.d("QuickAdditionFragment", "show:" + str);
    }

    public void showProgressDialog() {
        Log.d("QuickAdditionFragment", "showProgressDialog");
    }

    public /* synthetic */ void showProgressDialog(boolean z11) {
        h0.c(this, z11);
    }

    public QuickAdditionPresenter th() {
        return new QuickAdditionPresenter();
    }

    public final boolean uh(ArrayList<IndexFeatureItem> arrayList) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            if (this.f74087s.equals(arrayList.get(i11).getGroupCode())) {
                return true;
            }
        }
        return false;
    }

    public boolean useWindowBg() {
        return true;
    }

    public void v3(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("requestFailure:");
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        Log.d("QuickAdditionFragment", sb2.toString());
        HuobiToastUtil.j(R.string.n_quick_addition_add_failure);
        dismiss();
    }

    public final void vh() {
        if (getDialog() != null) {
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.3f;
            window.setAttributes(attributes);
        }
    }

    public final void wh() {
        if (getDialog() != null) {
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
        }
    }

    public void ya(QuickAdditionFeature quickAdditionFeature) {
        Log.d("QuickAdditionFragment", "requestSuccess");
        List<QuickAdditionItem> quickAdditionItems = quickAdditionFeature.getQuickAdditionItems();
        if (quickAdditionItems == null || quickAdditionItems.size() == 0) {
            Log.d("QuickAdditionFragment", "data is null");
            return;
        }
        QuickAdditionItem quickAdditionItem = quickAdditionItems.get(0);
        if (quickAdditionItem != null && quickAdditionItem.getIndexFeatureItems() != null) {
            ArrayList<IndexFeatureItem> indexFeatureItems = quickAdditionItem.getIndexFeatureItems();
            this.f74088t = indexFeatureItems;
            if (indexFeatureItems == null || indexFeatureItems.size() <= 0) {
                Log.e("QuickAdditionFragment", "request data error");
            } else if (uh(this.f74088t)) {
                HuobiToastUtil.s(R.string.n_quick_addition_has_added_to_home);
                dismiss();
            } else if (this.f74088t.size() < 19) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < this.f74088t.size(); i11++) {
                    arrayList.add(this.f74088t.get(i11).getGroupCode());
                }
                arrayList.add(this.f74087s);
                this.f74082n.V(arrayList);
            } else {
                if (this.f74081m != null) {
                    ArrayList<IndexFeatureItem> arrayList2 = this.f74088t;
                    if ("0".equals(arrayList2.get(arrayList2.size() - 1).getHomePageFixed())) {
                        ArrayList<IndexFeatureItem> arrayList3 = this.f74088t;
                        arrayList3.get(arrayList3.size() - 1).isSelected = true;
                        String string = getResources().getString(R.string.n_quick_addition_be_replaced_desc);
                        ArrayList<IndexFeatureItem> arrayList4 = this.f74088t;
                        this.f74078j.setText(String.format(string, new Object[]{arrayList4.get(arrayList4.size() - 1).getTitle()}));
                    } else {
                        this.f74078j.setVisibility(4);
                    }
                    this.f74081m.c(this.f74088t);
                    this.f74081m.notifyDataSetChanged();
                }
                vh();
                this.f74070b.setVisibility(0);
                g.i("addServer2home_show", (HashMap) null);
            }
        }
    }

    public void showProgressDialog(String str, boolean z11) {
        if (getContext() != null) {
            if (this.f74083o == null) {
                this.f74083o = new g1(getContext());
            }
            this.f74083o.show();
            this.f74083o.setCanceledOnTouchOutside(z11);
            this.f74083o.setCancelable(z11);
        }
    }
}
