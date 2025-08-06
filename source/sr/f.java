package sr;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huobi.sharev2.bean.ShareInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final r f84867a;

    /* renamed from: b  reason: collision with root package name */
    public final View f84868b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f84869c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84870d = true;

    /* renamed from: e  reason: collision with root package name */
    public c f84871e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f84872f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f84873g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f84874h;

    /* renamed from: i  reason: collision with root package name */
    public float f84875i;

    /* renamed from: j  reason: collision with root package name */
    public ObjectAnimator f84876j;

    /* renamed from: k  reason: collision with root package name */
    public ObjectAnimator f84877k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f84878l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f84879m;

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f84880n;

    /* renamed from: o  reason: collision with root package name */
    public RelativeLayout f84881o;

    /* renamed from: p  reason: collision with root package name */
    public ShareInfo f84882p;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            f.this.f84873g.setBackgroundResource(R.drawable.shape_share_bt_layout_bg);
            f.this.f84869c = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public class b implements Animator.AnimatorListener {
        public b() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            f fVar = f.this;
            fVar.f84869c = false;
            fVar.f84872f.setBackgroundResource(R.drawable.shape_share_bt_layout_bg);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public interface c {
        void a(View view);

        void b(boolean z11);

        void c(View view);

        void d(View view);

        void e(View view);

        void f(View view);
    }

    public f(View view) {
        this.f84867a = new r(view);
        this.f84868b = view;
        l();
        j();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(View view) {
        if (!this.f84869c) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f84876j.start();
        this.f84873g.setBackground((Drawable) null);
        this.f84872f.setSelected(false);
        this.f84873g.setSelected(true);
        ShareInfo shareInfo = this.f84882p;
        if (shareInfo == null || shareInfo.getDefaultTab() != 0) {
            this.f84871e.a(view);
            this.f84871e.b(false);
            this.f84878l.setImageResource(R.drawable.share_icon_save);
            this.f84879m.setText(R.string.n_share_btn_save);
            this.f84870d = false;
        } else {
            this.f84871e.c(view);
            this.f84871e.b(true);
            this.f84878l.setImageResource(R.drawable.share_icon_copy);
            this.f84879m.setText(R.string.n_share_btn_copy);
            this.f84870d = true;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o(View view) {
        if (this.f84869c) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f84877k.start();
        this.f84869c = true;
        this.f84872f.setBackground((Drawable) null);
        this.f84872f.setSelected(true);
        this.f84873g.setSelected(false);
        ShareInfo shareInfo = this.f84882p;
        if (shareInfo == null || shareInfo.getDefaultTab() != 0) {
            this.f84871e.c(view);
            this.f84871e.b(true);
            this.f84878l.setImageResource(R.drawable.share_icon_copy);
            this.f84879m.setText(R.string.n_share_btn_copy);
            this.f84870d = true;
        } else {
            this.f84871e.a(view);
            this.f84871e.b(false);
            this.f84878l.setImageResource(R.drawable.share_icon_save);
            this.f84879m.setText(R.string.n_share_btn_save);
            this.f84870d = false;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void p(View view) {
        if (this.f84870d) {
            this.f84871e.d(view);
        } else {
            this.f84871e.e(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q() {
        this.f84875i = (float) this.f84872f.getLayoutParams().width;
        this.f84881o.setVisibility(0);
        i();
        this.f84872f.setBackground((Drawable) null);
        this.f84872f.setSelected(true);
        this.f84873g.setSelected(false);
        ShareInfo shareInfo = this.f84882p;
        if (shareInfo == null || shareInfo.getDefaultTab() != 0) {
            this.f84871e.c(this.f84868b);
            this.f84871e.b(true);
            this.f84878l.setImageResource(R.drawable.share_icon_copy);
            this.f84879m.setText(R.string.n_share_btn_copy);
            this.f84870d = true;
            return;
        }
        this.f84871e.a(this.f84868b);
        this.f84871e.b(false);
        this.f84878l.setImageResource(R.drawable.share_icon_save);
        this.f84879m.setText(R.string.n_share_btn_save);
        this.f84870d = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r() {
        if (this.f84882p.getShareType() == ShareInfo.ShareType.SHARE_CONTENT || (this.f84882p.getBase64Bitmap() == null && TextUtils.isEmpty(this.f84882p.getBase64Image()) && com.hbg.module.libkt.base.ext.b.w(this.f84882p.getImageBitmaps()) && com.hbg.module.libkt.base.ext.b.w(this.f84882p.getImageUrls()))) {
            this.f84881o.setVisibility(8);
            this.f84873g.setSelected(true);
            this.f84878l.setImageResource(R.drawable.share_icon_copy);
            this.f84879m.setText(R.string.n_share_btn_copy);
            this.f84870d = true;
            this.f84869c = false;
            this.f84873g.setTextColor(this.f84868b.getContext().getResources().getColor(R.color.share_text_color));
            this.f84871e.b(true);
        }
    }

    public void h() {
        this.f84871e.f(this.f84872f);
        this.f84871e.b(false);
    }

    public final void i() {
        this.f84877k = ObjectAnimator.ofFloat(this.f84874h, "translationX", new float[]{this.f84875i, 0.0f});
        this.f84876j = ObjectAnimator.ofFloat(this.f84874h, "translationX", new float[]{0.0f, this.f84875i});
        this.f84877k.setDuration(200);
        this.f84876j.setDuration(200);
        this.f84877k.addListener(new a());
        this.f84876j.addListener(new b());
    }

    public final void j() {
        this.f84873g.setOnClickListener(new c(this));
        this.f84872f.setOnClickListener(new b(this));
        this.f84880n.setOnClickListener(new a(this));
    }

    public final void k() {
        this.f84881o.post(new e(this));
    }

    public final void l() {
        this.f84873g = (TextView) this.f84867a.b(R.id.share_link);
        this.f84872f = (TextView) this.f84867a.b(R.id.share_image);
        this.f84874h = (ImageView) this.f84867a.b(R.id.slideImage);
        this.f84878l = (ImageView) this.f84867a.b(R.id.save_icon);
        this.f84879m = (TextView) this.f84867a.b(R.id.save_text);
        this.f84878l.setImageResource(R.drawable.share_icon_save);
        this.f84879m.setText(R.string.n_share_btn_save);
        this.f84870d = false;
        this.f84880n = (LinearLayout) this.f84867a.b(R.id.save_layout);
        this.f84881o = (RelativeLayout) this.f84867a.b(R.id.switch_layout);
        this.f84873g.setBackgroundResource(R.drawable.shape_share_bt_layout_bg);
        this.f84872f.setBackground((Drawable) null);
        this.f84872f.setSelected(true);
    }

    public void m(ShareInfo shareInfo) {
        this.f84882p = shareInfo;
        k();
        ShareInfo shareInfo2 = this.f84882p;
        if (shareInfo2 != null) {
            if (shareInfo2.getDefaultTab() == 0) {
                this.f84873g.setText(this.f84868b.getContext().getResources().getString(R.string.n_share_btn_share_link));
                this.f84872f.setText(this.f84868b.getContext().getResources().getString(R.string.n_share_btn_share_image));
            } else {
                this.f84873g.setText(this.f84868b.getContext().getResources().getString(R.string.n_share_btn_share_image));
                this.f84872f.setText(this.f84868b.getContext().getResources().getString(R.string.n_share_btn_share_link));
            }
            if (this.f84882p.getShareType() == ShareInfo.ShareType.SHARE_CONTENT) {
                this.f84881o.setVisibility(8);
                this.f84873g.setSelected(true);
                this.f84878l.setImageResource(R.drawable.share_icon_copy);
                this.f84879m.setText(R.string.n_share_btn_copy);
                this.f84870d = true;
                this.f84869c = false;
                this.f84873g.setTextColor(this.f84868b.getContext().getResources().getColor(R.color.share_text_color));
                this.f84871e.b(true);
            } else {
                h();
                if ((this.f84882p.getShareContent() == null || this.f84882p.getShareContent().isEmpty()) && ((this.f84882p.getShareText() == null || this.f84882p.getShareText().isEmpty()) && (this.f84882p.getShareUrl() == null || this.f84882p.getShareUrl().isEmpty()))) {
                    this.f84881o.setVisibility(8);
                    this.f84872f.setSelected(true);
                    this.f84872f.setTextColor(this.f84868b.getContext().getResources().getColor(R.color.share_text_color));
                } else {
                    this.f84881o.setVisibility(0);
                    this.f84872f.setVisibility(0);
                    this.f84873g.setVisibility(0);
                    this.f84874h.setVisibility(0);
                }
            }
            this.f84881o.post(new d(this));
        }
    }

    public void s(c cVar) {
        this.f84871e = cVar;
    }
}
