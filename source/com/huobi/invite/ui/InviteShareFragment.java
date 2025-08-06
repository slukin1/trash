package com.huobi.invite.ui;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.invite.bean.InvitePosterItem;
import com.huobi.invite.bean.InvitePosterListItem;
import com.huobi.invite.viewhandler.InvitePosterItemHandler;
import com.huobi.share.fragment.BaseShareFragment;
import com.huobi.share.fragment.LineIndicator;
import com.huobi.social.share.HBShareHelper;
import com.huobi.utils.ImageUtils;
import com.huobi.utils.x;
import com.huochat.community.util.ClipManager;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import pro.huobi.R;

public class InviteShareFragment extends BaseShareFragment {
    public String A;
    public String B;
    public String C;
    public String D;
    public LineIndicator E;
    public String F;
    public ImageView G;
    public DialogInterface.OnDismissListener H;
    public InvitePosterItemHandler.a I = new b();

    /* renamed from: w  reason: collision with root package name */
    public EasyRecyclerView<InvitePosterListItem> f74611w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f74612x;

    /* renamed from: y  reason: collision with root package name */
    public String f74613y;

    /* renamed from: z  reason: collision with root package name */
    public final List<InvitePosterListItem> f74614z = new ArrayList();

    public class a implements tx.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f74615a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c6.b f74616b;

        public a(Bitmap bitmap, c6.b bVar) {
            this.f74615a = bitmap;
            this.f74616b = bVar;
        }

        public void a(String str, View view) {
        }

        public void b(String str, View view, FailReason failReason) {
        }

        public void c(String str, View view, Bitmap bitmap) {
            c6.b bVar;
            Bitmap k11 = ImageUtils.k(this.f74615a, ImageUtils.l(bitmap, this.f74615a.getWidth(), (this.f74615a.getWidth() * bitmap.getHeight()) / bitmap.getWidth()));
            if (k11 != null && (bVar = this.f74616b) != null) {
                bVar.onCallback(k11);
            }
        }

        public void d(String str, View view) {
        }
    }

    public class b implements InvitePosterItemHandler.a {
        public b() {
        }

        public void a(InvitePosterListItem invitePosterListItem) {
            if (b(invitePosterListItem)) {
                InvitePosterListItem unused = InviteShareFragment.this.f80883q = null;
            } else {
                InvitePosterListItem unused2 = InviteShareFragment.this.f80883q = invitePosterListItem;
            }
            InviteShareFragment.this.f74611w.c();
        }

        public boolean b(InvitePosterListItem invitePosterListItem) {
            return InviteShareFragment.this.f80883q != null && InviteShareFragment.this.f80883q == invitePosterListItem;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ci(Bitmap bitmap) {
        Ch(this.A, bitmap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void di(Bitmap bitmap) {
        Ch(this.A, bitmap);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String ai() {
        String str;
        if (TextUtils.isEmpty(this.F)) {
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                if (x.d()) {
                    str = DomainSwitcher.C();
                } else {
                    str = DomainSwitcher.E();
                }
            } else if (x.d()) {
                str = DomainSwitcher.D();
            } else {
                str = DomainSwitcher.F();
            }
            this.F = str + this.f74613y;
        }
        return this.F;
    }

    public final void bi(c6.b<Bitmap> bVar) {
        if (getActivity() != null) {
            ShareQrLayout shareQrLayout = new ShareQrLayout(getActivity());
            shareQrLayout.d(this.f80883q);
            Bitmap a11 = shareQrLayout.a(this.B);
            if (a11 != null && this.f74612x && this.f80883q != null) {
                g6.b.c().m(this.f80883q.d().getImg(), new a(a11, bVar));
            }
        }
    }

    public void ei(String str) {
        this.f74613y = str;
    }

    public void fi(String str) {
        this.F = str;
    }

    public int getContentViewResId() {
        return R.layout.activity_invite_share;
    }

    public void gi(boolean z11) {
        this.f74612x = z11;
    }

    public void hi(ArrayList<InvitePosterItem> arrayList) {
        if (arrayList != null) {
            this.f74614z.clear();
            this.f80882p.clear();
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                InvitePosterListItem invitePosterListItem = new InvitePosterListItem();
                invitePosterListItem.f(arrayList.get(i11));
                invitePosterListItem.e(this.I);
                if (i11 == 1) {
                    this.f80883q = invitePosterListItem;
                }
                this.f74614z.add(invitePosterListItem);
                this.f80882p.add(invitePosterListItem);
            }
        }
    }

    public void i0(HBShareHelper.HbPlatform hbPlatform) {
        if (!this.f74612x || this.f80883q != null) {
            String string = getString(R.string.n_app_name);
            this.A = getString(R.string.invite_share_text_content);
            super.i0(hbPlatform);
            if (this.f74612x) {
                bi(new k(this));
            } else {
                Dh(string, this.A, this.B);
            }
            String str = this.D;
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.n_share_default_ten_year);
            }
            ClipManager.copy(str + Eh(this.C));
            return;
        }
        HuobiToastUtil.g(R.string.invite_share_select_a_poster);
    }

    public void initView(r rVar) {
        super.initView(rVar);
        ViewUtil.m(rVar.b(R.id.poster_layout), this.f74612x);
        ViewUtil.m(rVar.b(R.id.share_post_indicator_layout), this.f74612x);
        this.E = (LineIndicator) rVar.b(R.id.share_hindicator);
        this.G = (ImageView) rVar.b(R.id.screenshot_share_close);
        this.B = ai();
        if (this.f74612x) {
            this.f80880n.setVisibility(0);
            this.E.setVisibility(0);
            this.E.setData(this.f80882p.size());
            ViewPagerHelper.a(this.E, this.f80880n);
            ((TextView) rVar.b(R.id.share_intro_text)).setText(getString(R.string.n_user_center_selector_image_share));
        }
        this.G.setOnClickListener(new j(this));
    }

    public boolean isTransparent() {
        return true;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.H;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, list)) {
            new AppSettingsDialog.Builder((Fragment) this, getString(R.string.currency_deposit_permission_write_external_storage_apply)).setTitle(getString(R.string.currency_deposit_permission_apply)).setPositiveButton(getString(R.string.currency_deposit_go_to_settings)).setNegativeButton(getString(R.string.n_otc_new_otc_cancel), (DialogInterface.OnClickListener) null).setRequestCode(126).build().show();
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        if (this.f74612x) {
            bi(new l(this));
        }
    }
}
