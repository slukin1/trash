package cb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lite.R$drawable;
import com.hbg.lite.index.bean.LiteHomeActivityEntity;
import com.huobi.view.rollviewpager.RollPagerView;
import com.huobi.view.rollviewpager.adapter.LoopPagerAdapter;
import com.huobi.view.roundimg.RoundedImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.k;
import java.util.HashMap;
import java.util.List;
import ra.c;

public class b extends LoopPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<LiteHomeActivityEntity> f77057a;

    public b(RollPagerView rollPagerView) {
        super(rollPagerView);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void b(LiteHomeActivityEntity liteHomeActivityEntity, Context context, View view) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("adName", liteHomeActivityEntity.getAdName());
            c.c().l("4559", hashMap);
        } catch (Exception e11) {
            k.g("INDEX", "report data", e11);
        }
        c.a().c(context, liteHomeActivityEntity.getUrl(), liteHomeActivityEntity.getTitle(), liteHomeActivityEntity.getAdName());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void c(List<LiteHomeActivityEntity> list) {
        this.f77057a = list;
    }

    public int getRealCount() {
        List<LiteHomeActivityEntity> list = this.f77057a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public View getView(ViewGroup viewGroup, int i11) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RoundedImageView roundedImageView = new RoundedImageView(viewGroup.getContext());
        roundedImageView.setCornerRadius((float) PixelUtils.a(10.0f));
        roundedImageView.setOval(false);
        roundedImageView.mutateBackground(false);
        roundedImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        int a11 = PixelUtils.a(15.0f);
        layoutParams.leftMargin = a11;
        layoutParams.rightMargin = a11;
        roundedImageView.setLayoutParams(layoutParams);
        frameLayout.addView(roundedImageView);
        LiteHomeActivityEntity liteHomeActivityEntity = this.f77057a.get(i11);
        if (!TextUtils.isEmpty(liteHomeActivityEntity.getImg())) {
            g6.b.c().i(roundedImageView, liteHomeActivityEntity.getImg(), R$drawable.default_banner_image);
        } else {
            roundedImageView.setImageResource(R$drawable.default_banner_image);
        }
        Context context = viewGroup.getContext();
        if (!TextUtils.isEmpty(liteHomeActivityEntity.getUrl())) {
            frameLayout.setOnClickListener(new a(liteHomeActivityEntity, context));
        }
        return frameLayout;
    }
}
