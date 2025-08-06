package yg;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import c4.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.e;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.entity.HomeActivityEntity;
import com.huobi.utils.v;
import com.huobi.view.BannerImageView;
import com.huobi.view.rollviewpager.RollPagerView;
import com.huobi.view.rollviewpager.adapter.LoopPagerAdapter;
import com.huochat.community.util.ImageLoadedrManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import i6.i;
import i6.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pro.huobi.R;

public class a extends LoopPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<HomeActivityEntity> f48084a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Handler f48085b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Integer, String> f48086c;

    /* renamed from: d  reason: collision with root package name */
    public int f48087d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48088e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48089f;

    /* renamed from: yg.a$a  reason: collision with other inner class name */
    public class C0586a implements e {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f48090b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f48091c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f48092d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BannerImageView f48093e;

        /* renamed from: yg.a$a$a  reason: collision with other inner class name */
        public class C0587a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Object f48095b;

            public C0587a(Object obj) {
                this.f48095b = obj;
            }

            public void run() {
                Drawable drawable = (Drawable) this.f48095b;
                C0586a.this.f48093e.setImageDrawable(drawable);
                if (a.this.f48088e) {
                    C0586a aVar = C0586a.this;
                    if (aVar.f48090b < a.this.f48084a.size()) {
                        d.c("wuxinrong", "保存颜色(图片下载成功) ...索引 = " + C0586a.this.f48090b);
                        C0586a aVar2 = C0586a.this;
                        a.this.h(drawable, aVar2.f48090b, 5, 5);
                    }
                    C0586a aVar3 = C0586a.this;
                    int i11 = aVar3.f48090b;
                    if (i11 == 0) {
                        a.this.i(i11);
                    }
                }
            }
        }

        public C0586a(int i11, Context context, int i12, BannerImageView bannerImageView) {
            this.f48090b = i11;
            this.f48091c = context;
            this.f48092d = i12;
            this.f48093e = bannerImageView;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, g gVar, boolean z11) {
            if (!a.this.f48088e || this.f48090b >= a.this.f48084a.size()) {
                return false;
            }
            Drawable drawable = this.f48091c.getResources().getDrawable(this.f48092d);
            d.c("wuxinrong", "保存颜色(图片下载失败) ...索引 = " + this.f48090b);
            a.this.h(drawable, this.f48090b, 5, 5);
            return false;
        }

        public boolean onResourceReady(Object obj, Object obj2, g gVar, DataSource dataSource, boolean z11) {
            i.b().g(new C0587a(obj), 50);
            return false;
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomeActivityEntity f48097b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f48098c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f48099d;

        public b(HomeActivityEntity homeActivityEntity, int i11, Context context) {
            this.f48097b = homeActivityEntity;
            this.f48098c = i11;
            this.f48099d = context;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", this.f48097b.adName);
            hashMap.put("banner_id", this.f48097b.f44607id);
            hashMap.put("banner_site", Integer.valueOf(this.f48098c + 1));
            hashMap.put("testKey", "A");
            if (a.this.f48087d == 1001) {
                gs.g.i("Banner_Me_click", hashMap);
            } else {
                gs.g.i("button_click", hashMap);
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("adName", this.f48097b.adName);
                    hashMap2.put("position", Integer.valueOf(this.f48098c + 1));
                    is.a.i("4477", hashMap2);
                } catch (Exception e11) {
                    k.g("INDEX", "report data", e11);
                }
            }
            String str = this.f48097b.url;
            if (!TextUtils.isEmpty(str)) {
                v.a(this.f48099d, str, this.f48097b.title);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public a(RollPagerView rollPagerView) {
        super(rollPagerView);
        HashMap<Integer, String> hashMap = new HashMap<>();
        this.f48086c = hashMap;
        this.f48087d = 0;
        this.f48088e = true;
        this.f48089f = false;
        hashMap.clear();
    }

    public List<HomeActivityEntity> e() {
        return this.f48084a;
    }

    public HashMap<Integer, String> f() {
        return this.f48086c;
    }

    public boolean g() {
        return this.f48089f;
    }

    public int getRealCount() {
        List<HomeActivityEntity> list = this.f48084a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public View getView(ViewGroup viewGroup, int i11) {
        Context context = viewGroup.getContext();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        BannerImageView bannerImageView = new BannerImageView(context);
        BannerImageView bannerImageView2 = new BannerImageView(context);
        bannerImageView.setBackgroundColor(context.getResources().getColor(R.color.baseColorContentBackground));
        bannerImageView2.setBackgroundColor(context.getResources().getColor(R.color.baseColorContentBackground));
        bannerImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        float f11 = 0.0f;
        bannerImageView2.setRadius(this.f48087d == 1003 ? 0.0f : 8.0f);
        bannerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (this.f48087d != 1003) {
            f11 = 8.0f;
        }
        bannerImageView.setRadius(f11);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(bannerImageView2, layoutParams);
        frameLayout.addView(bannerImageView, layoutParams);
        HomeActivityEntity homeActivityEntity = this.f48084a.get(i11);
        if (!TextUtils.isEmpty(homeActivityEntity.img)) {
            ImageLoadedrManager.getInstance().display(context, homeActivityEntity.img, (ImageView) bannerImageView2, (int) R.drawable.shape_banner_error_empty, (e) new C0586a(i11, context, R.drawable.shape_banner_error_empty, bannerImageView));
        } else {
            bannerImageView.setImageResource(R.drawable.shape_banner_error_empty);
            if (this.f48088e && i11 < this.f48084a.size()) {
                Drawable drawable = context.getResources().getDrawable(R.drawable.shape_banner_error_empty);
                d.c("wuxinrong", "保存颜色(默认图片) ...索引 = " + i11);
                h(drawable, i11, 5, 5);
            }
        }
        if (!TextUtils.isEmpty(homeActivityEntity.url)) {
            frameLayout.setOnClickListener(new b(homeActivityEntity, i11, context));
        }
        return frameLayout;
    }

    public final void h(Drawable drawable, int i11, int i12, int i13) {
        String e11 = PixelUtils.e(drawable, i12, i13);
        d.c("wuxinrong", "保存颜色 ... 颜色 = " + e11);
        if (this.f48086c.containsKey(Integer.valueOf(i11))) {
            this.f48086c.remove(Integer.valueOf(i11));
        }
        this.f48086c.put(Integer.valueOf(i11), e11);
    }

    public void i(int i11) {
        if (i11 >= 0 && i11 < this.f48084a.size()) {
            String str = this.f48086c.get(Integer.valueOf(i11));
            if (!TextUtils.isEmpty(str)) {
                Message obtainMessage = this.f48085b.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = Color.parseColor(str);
                this.f48085b.sendMessage(obtainMessage);
            }
        }
    }

    public void j(Handler handler) {
        this.f48085b = handler;
    }

    public void k(List<HomeActivityEntity> list) {
        if (list != null) {
            this.f48084a.clear();
            this.f48084a.addAll(list);
        }
    }

    public void l(int i11) {
        this.f48087d = i11;
    }

    public void m(boolean z11) {
        this.f48088e = z11;
    }
}
