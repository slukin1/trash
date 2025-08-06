package bp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$drawable;
import com.huobi.otc.bean.OtcBannerBean;
import com.huobi.otc.bean.OtcU1000DetailBean;
import com.huobi.otc.dialog.OtcOperationDialog;
import com.huobi.otc.persenter.OtcTradePresenter;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.otc.widget.BannerImageView;
import com.huobi.otc.widget.OtcOperation1000uBannerView;
import com.huobi.otc.widget.OtcOperation1000uBottomView;
import com.huobi.otc.widget.OtcOperation1000uContentView;
import com.huobi.view.rollviewpager.RollPagerView;
import com.huobi.view.rollviewpager.adapter.LoopPagerAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import u6.g;
import uf.c;

public class b extends LoopPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<OtcBannerBean> f77006a;

    /* renamed from: b  reason: collision with root package name */
    public OtcTradePresenter.i f77007b;

    /* renamed from: c  reason: collision with root package name */
    public OtcOperationDialog f77008c;

    public class a extends q6.b<OtcU1000DetailBean> {
        public a(g gVar) {
            super(gVar);
        }

        /* renamed from: a */
        public void onRequestSuccess(OtcU1000DetailBean otcU1000DetailBean) {
            super.onRequestSuccess(otcU1000DetailBean);
            Activity f11 = oa.a.g().f(OtcTradeActivity.class);
            if (f11 != null && (f11 instanceof OtcTradeActivity)) {
                OtcOperationDialog unused = b.this.f77008c = new OtcOperationDialog(new OtcOperation1000uContentView(f11), new OtcOperation1000uBottomView(f11), otcU1000DetailBean);
                if (b.this.f77008c != null && !b.this.f77008c.isVisible()) {
                    b.this.f77008c.show(((OtcTradeActivity) f11).getSupportFragmentManager(), "lottery");
                }
            }
        }
    }

    public b(RollPagerView rollPagerView, OtcTradePresenter.i iVar) {
        super(rollPagerView);
        this.f77007b = iVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(String str, int i11, Void voidR) {
        if ("ads".equals(str)) {
            d();
            return;
        }
        String jumpUrl = this.f77006a.get(i11).getJumpUrl();
        if (!TextUtils.isEmpty(jumpUrl)) {
            Activity b11 = oa.a.g().b();
            if (b11 != null) {
                OtcModuleConfig.b().W(b11, jumpUrl);
            }
            if (jumpUrl.contains("/otc/user/guide")) {
                c.b().l("click_banner_bonus", (HashMap) null);
            }
        }
    }

    public void d() {
        s8.a.a().get1000UDetail().d(new a(this.f77007b));
    }

    public void f(List<OtcBannerBean> list) {
        this.f77006a = list;
    }

    public int getRealCount() {
        List<OtcBannerBean> list = this.f77006a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public View getView(ViewGroup viewGroup, int i11) {
        Context context = viewGroup.getContext();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        frameLayout.setBackgroundColor(0);
        OtcBannerBean otcBannerBean = this.f77006a.get(i11);
        String bannerType = this.f77006a.get(i11).getBannerType();
        int i12 = R$drawable.shape_banner_error;
        BannerImageView bannerImageView = new BannerImageView(context, context.getResources().getColor(R$color.otc_trade_pay_list_bg));
        bannerImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        OtcOperation1000uBannerView otcOperation1000uBannerView = new OtcOperation1000uBannerView(viewGroup.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.dimen_15);
        if ("ads".equals(bannerType)) {
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.rightMargin = dimensionPixelSize;
            frameLayout.addView(otcOperation1000uBannerView, layoutParams);
        } else {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            frameLayout.addView(bannerImageView, layoutParams);
        }
        if (!TextUtils.isEmpty(otcBannerBean.getImageUrl())) {
            f6.c.a().f(bannerImageView, otcBannerBean.getImageUrl(), i12);
        } else {
            bannerImageView.setImageResource(i12);
        }
        if (!TextUtils.isEmpty(otcBannerBean.getImageUrl())) {
            dw.a.a(frameLayout).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new a(this, bannerType, i11));
        }
        return frameLayout;
    }
}
