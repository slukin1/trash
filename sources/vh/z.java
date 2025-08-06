package vh;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.view.HbgPopupWindow;
import i6.n;
import java.util.ArrayList;
import java.util.List;
import vk.k;

public class z extends HbgPopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public View f47968a = getContentView().findViewById(R$id.id_common_tips_dialog_root);

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<k> f47969b = ((EasyRecyclerView) getContentView().findViewById(R$id.asset_sort_dialog_recyclerView));

    /* renamed from: c  reason: collision with root package name */
    public final List<k> f47970c = new ArrayList();

    public z(Context context) {
        super(f(context), -2, -2);
        setBackgroundDrawable(new ColorDrawable(0));
        setCancelOnTouchOutside(true);
        c();
        d();
    }

    public static int[] e(View view, View view2) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int f11 = n.f(view.getContext());
        n.g(view.getContext());
        view2.measure(0, 0);
        int measuredHeight = view2.getMeasuredHeight();
        view2.getMeasuredWidth();
        boolean z11 = (f11 - iArr2[1]) - height < measuredHeight;
        iArr[0] = iArr2[0];
        if (z11) {
            iArr[1] = iArr2[1] - measuredHeight;
        } else {
            iArr[1] = iArr2[1] + height;
        }
        return iArr;
    }

    public static View f(Context context) {
        return View.inflate(context, R$layout.layout_asset_sort_pop_dialog, (ViewGroup) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean g(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return false;
    }

    public final void c() {
        this.f47968a.setOnTouchListener(new y(this));
    }

    public void d() {
        this.f47969b.setLayoutManager(new LinearLayoutManager(this.f47968a.getContext()));
        this.f47969b.setData(this.f47970c);
    }

    public void h(List<k> list) {
        this.f47970c.clear();
        if (list != null) {
            this.f47970c.addAll(list);
        }
        EasyRecyclerView<k> easyRecyclerView = this.f47969b;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(this.f47970c);
        }
    }

    public void i(View view) {
        try {
            int[] e11 = e(view, this.f47968a);
            showAtLocation(view, BadgeDrawable.TOP_START, e11[0], e11[1]);
        } catch (Exception e12) {
            i6.k.e("AssetSortPopDialog.show()===>" + e12);
        }
    }

    public void setCancelOnTouchOutside(boolean z11) {
        setOutsideTouchable(z11);
        setFocusable(z11);
    }
}
