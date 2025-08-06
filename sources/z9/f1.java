package z9;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.huobi.view.HbgPopupWindow;
import java.util.ArrayList;
import java.util.List;

public class f1 extends HbgPopupWindow {

    /* renamed from: b  reason: collision with root package name */
    public View f76971b = getContentView().findViewById(R$id.id_common_tips_dialog_root);

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView<ba.a> f76972c = ((EasyRecyclerView) getContentView().findViewById(R$id.id_common_tips_dialog_recyclerView));

    /* renamed from: d  reason: collision with root package name */
    public final List<ba.a> f76973d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public int f76974e;

    /* renamed from: f  reason: collision with root package name */
    public int f76975f;

    /* renamed from: g  reason: collision with root package name */
    public int f76976g;

    public class a extends RecyclerView.ItemDecoration {
        public a() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.left = recyclerView.getChildAdapterPosition(view) > 0 ? f1.this.f76974e : 0;
        }
    }

    public f1(Context context) {
        super(f(context), -2, -2);
        setWidth(context.getResources().getDisplayMetrics().widthPixels);
        setBackgroundDrawable(new ColorDrawable(0));
        setCancelOnTouchOutside(true);
        d();
        e();
    }

    public static View f(Context context) {
        return View.inflate(context, R$layout.layout_market_item_tips_dialog, (ViewGroup) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean g(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return false;
    }

    public final void d() {
        this.f76971b.setOnTouchListener(new e1(this));
    }

    public void e() {
        this.f76974e = getContentView().getResources().getDimensionPixelOffset(R$dimen.dimen_6);
        this.f76972c.addItemDecoration(new a());
        StableLinearLayoutManager stableLinearLayoutManager = new StableLinearLayoutManager(getContentView().getContext());
        stableLinearLayoutManager.setOrientation(0);
        this.f76972c.setLayoutManager(stableLinearLayoutManager);
        this.f76972c.setData(this.f76973d);
    }

    public void h(List<ba.a> list) {
        this.f76973d.clear();
        if (list != null) {
            this.f76973d.addAll(list);
        }
        EasyRecyclerView<ba.a> easyRecyclerView = this.f76972c;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(this.f76973d);
        }
    }

    public void i(View view) {
        view.getHeight();
        if (this.f76975f == 0) {
            this.f76975f = view.getResources().getDimensionPixelOffset(R$dimen.dimen_55);
        }
        if (this.f76976g == 0) {
            this.f76976g = view.getResources().getDimensionPixelOffset(R$dimen.dimen_3);
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        showAtLocation(view, 49, 0, (iArr[1] - this.f76975f) + this.f76976g);
    }

    public void setCancelOnTouchOutside(boolean z11) {
        setOutsideTouchable(z11);
        setFocusable(z11);
    }
}
