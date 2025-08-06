package vh;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.view.HbgPopupWindow;
import i6.k;
import i6.n;
import java.util.ArrayList;
import java.util.List;
import vk.j;

public class x extends HbgPopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public View f47961a;

    /* renamed from: b  reason: collision with root package name */
    public Context f47962b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView<j> f47963c;

    /* renamed from: d  reason: collision with root package name */
    public final List<j> f47964d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<j> f47965e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public j.a f47966f = new w(this);

    /* renamed from: g  reason: collision with root package name */
    public a f47967g;

    public interface a {
        void onCurrencyMethodChanged(String str);
    }

    public x(Context context) {
        super(h(context), -2, -2);
        this.f47962b = context;
        this.f47961a = getContentView().findViewById(R$id.id_common_tips_dialog_root);
        this.f47963c = (EasyRecyclerView) getContentView().findViewById(R$id.asset_sort_dialog_recyclerView);
        setBackgroundDrawable(new ColorDrawable(0));
        setCancelOnTouchOutside(true);
        d();
        e();
    }

    public static int[] f(View view, View view2) {
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

    public static int[] g(View view, View view2) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int width = view.getWidth();
        int f11 = n.f(view.getContext());
        n.g(view.getContext());
        view2.measure(0, 0);
        int measuredHeight = view2.getMeasuredHeight();
        int measuredWidth = view2.getMeasuredWidth();
        boolean z11 = (f11 - iArr2[1]) - height < measuredHeight;
        iArr[0] = (iArr2[0] - measuredWidth) + width + PixelUtils.a(view.getContext().getResources().getDimension(R$dimen.dimen_5));
        if (z11) {
            iArr[1] = iArr2[1] - measuredHeight;
        } else {
            iArr[1] = iArr2[1] + height;
        }
        return iArr;
    }

    public static View h(Context context) {
        return View.inflate(context, R$layout.layout_asset_sort_pop_dialog, (ViewGroup) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean j(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return false;
    }

    public final void d() {
        this.f47961a.setOnTouchListener(new v(this));
    }

    public void e() {
        i();
        this.f47963c.setLayoutManager(new LinearLayoutManager(this.f47961a.getContext()));
        this.f47963c.setData(this.f47964d);
    }

    public final void i() {
        boolean z11;
        boolean z12;
        boolean z13;
        String d11 = LegalCurrencyConfigUtil.d();
        k.c("initPriceMethodPopList priceMethod = " + d11);
        d11.hashCode();
        boolean z14 = true;
        char c11 = 65535;
        switch (d11.hashCode()) {
            case 97873:
                if (d11.equals("btc")) {
                    c11 = 0;
                    break;
                }
                break;
            case 116102:
                if (d11.equals("usd")) {
                    c11 = 1;
                    break;
                }
                break;
            case 3599278:
                if (d11.equals("usdt")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                d11 = "eur";
                z11 = true;
                z13 = false;
                z14 = false;
                z12 = false;
                break;
            case 1:
                d11 = "eur";
                z13 = true;
                z14 = false;
                z12 = false;
                break;
            case 2:
                d11 = "eur";
                z12 = true;
                z13 = false;
                z14 = false;
                z11 = false;
                break;
            default:
                z13 = false;
                z12 = false;
                break;
        }
        z11 = z12;
        this.f47965e.clear();
        this.f47965e.add(new j(z14, d11, this.f47966f));
        this.f47965e.add(new j(z13, "usd", this.f47966f));
        this.f47965e.add(new j(z12, "usdt", this.f47966f));
        this.f47965e.add(new j(z11, "btc", this.f47966f));
        this.f47965e.add(new j(false, this.f47962b.getString(R$string.n_home_index_earn_more), this.f47966f));
        this.f47964d.clear();
        this.f47964d.addAll(this.f47965e);
    }

    public void l(a aVar) {
        this.f47967g = aVar;
    }

    public void m(View view) {
        try {
            int[] f11 = f(view, this.f47961a);
            showAtLocation(view, BadgeDrawable.TOP_START, f11[0], f11[1]);
        } catch (Exception e11) {
            k.e("AssetPriceMethodPopDialog.show()===>" + e11);
        }
    }

    public void n(View view) {
        try {
            int[] g11 = g(view, this.f47961a);
            showAtLocation(view, BadgeDrawable.TOP_START, g11[0], g11[1]);
        } catch (Exception e11) {
            k.e("AssetPriceMethodPopDialog.show()===>" + e11);
        }
    }

    /* renamed from: o */
    public final void k(String str) {
        a aVar = this.f47967g;
        if (aVar != null) {
            aVar.onCurrencyMethodChanged(str);
        }
    }

    public void setCancelOnTouchOutside(boolean z11) {
        setOutsideTouchable(z11);
        setFocusable(z11);
    }
}
