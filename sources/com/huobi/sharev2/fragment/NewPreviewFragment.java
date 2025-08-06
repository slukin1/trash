package com.huobi.sharev2.fragment;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.cpiz.android.bubbleview.Utils;
import com.huobi.invite.bean.InvitePosterListItem;
import com.huobi.sharev2.bean.ShareInfo;
import com.huobi.sharev2.helper.NewShareHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import g6.b;
import pro.huobi.R;
import rr.f;
import xr.i;

public class NewPreviewFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public ShareInfo.ShareType f81112b;

    /* renamed from: c  reason: collision with root package name */
    public InvitePosterListItem f81113c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f81114d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f81115e;

    /* renamed from: f  reason: collision with root package name */
    public int f81116f;

    /* renamed from: g  reason: collision with root package name */
    public int f81117g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f81118h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f81119i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f81120j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f81121k;

    /* renamed from: l  reason: collision with root package name */
    public String f81122l;

    /* renamed from: m  reason: collision with root package name */
    public String f81123m;

    /* renamed from: n  reason: collision with root package name */
    public String f81124n;

    /* renamed from: o  reason: collision with root package name */
    public Bitmap f81125o;

    /* renamed from: p  reason: collision with root package name */
    public Bitmap f81126p;

    /* renamed from: q  reason: collision with root package name */
    public ImageView f81127q;

    /* renamed from: r  reason: collision with root package name */
    public Bitmap f81128r;

    /* renamed from: s  reason: collision with root package name */
    public View f81129s;

    /* access modifiers changed from: private */
    public /* synthetic */ void sh(View view) {
        int height = view.getHeight() - this.f81129s.getHeight();
        if (height > 0) {
            view.setPadding(0, height / 2, 0, 0);
        } else {
            view.setPadding(0, Utils.b(this.f81117g <= 1 ? 40 : 10), 0, 0);
        }
    }

    public static NewPreviewFragment th(int i11) {
        NewPreviewFragment newPreviewFragment = new NewPreviewFragment();
        newPreviewFragment.f81116f = i11;
        return newPreviewFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.new_item_share_poster, (ViewGroup) null);
        this.f81115e = (ImageView) inflate.findViewById(R.id.poster_image);
        this.f81120j = (ImageView) inflate.findViewById(R.id.share_img_qrcode);
        this.f81118h = (RelativeLayout) inflate.findViewById(R.id.share_img_bottom);
        this.f81119i = (TextView) inflate.findViewById(R.id.share_img_subtitle);
        this.f81127q = (ImageView) inflate.findViewById(R.id.float_image);
        this.f81114d = (TextView) inflate.findViewById(R.id.share_tv_invicode);
        this.f81129s = inflate.findViewById(R.id.share_layout);
        if (this.f81112b == ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS) {
            InvitePosterListItem invitePosterListItem = this.f81113c;
            if (!(invitePosterListItem == null || invitePosterListItem.d() == null || this.f81113c.d().getBytesFromBitmap() == null || this.f81113c.d().getBytesFromBitmap().length <= 0)) {
                Bitmap f11 = NewShareHelper.j().f(this.f81113c.d().getBytesFromBitmap());
                this.f81125o = f11;
                this.f81115e.setImageBitmap(f11);
            }
        } else {
            InvitePosterListItem invitePosterListItem2 = this.f81113c;
            if (!(invitePosterListItem2 == null || invitePosterListItem2.d() == null || this.f81113c.d().getImg() == null || this.f81113c.d().getImg().isEmpty())) {
                b.c().h(this.f81115e, this.f81113c.d().getImg());
            }
        }
        InvitePosterListItem invitePosterListItem3 = this.f81113c;
        if (!(invitePosterListItem3 == null || invitePosterListItem3.d() == null || this.f81113c.d().getBytesFloatBitmap() == null)) {
            Bitmap f12 = NewShareHelper.j().f(this.f81113c.d().getBytesFloatBitmap());
            this.f81128r = f12;
            this.f81127q.setImageBitmap(f12);
            this.f81127q.setVisibility(0);
        }
        rh();
        uh();
        this.f81129s.post(new f(this, inflate));
        return inflate;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public Bitmap qh() {
        return this.f81125o;
    }

    public final void rh() {
        String str;
        InvitePosterListItem invitePosterListItem = this.f81113c;
        if (!(invitePosterListItem == null || invitePosterListItem.d() == null)) {
            this.f81121k = this.f81113c.d().getShowNativeQr().endsWith("true");
            this.f81122l = this.f81113c.d().getQrUrl();
            this.f81123m = this.f81113c.d().getSubTitle();
            String inviteCode = this.f81113c.d().getInviteCode();
            this.f81124n = inviteCode;
            if (TextUtils.isEmpty(inviteCode) && (str = this.f81122l) != null) {
                try {
                    Uri parse = Uri.parse(str);
                    String queryParameter = parse.getQueryParameter("inviteCode");
                    this.f81124n = queryParameter;
                    if (TextUtils.isEmpty(queryParameter)) {
                        this.f81124n = parse.getQueryParameter("invite_code");
                    }
                } catch (Throwable unused) {
                }
            }
        }
        if (this.f81121k) {
            this.f81118h.setVisibility(0);
            if (!TextUtils.isEmpty(this.f81123m)) {
                this.f81119i.setText(this.f81123m);
            }
            Bitmap d11 = NewShareHelper.j().d(requireContext(), this.f81122l);
            this.f81126p = d11;
            if (d11 != null) {
                this.f81120j.setImageBitmap(d11);
            }
            if (!TextUtils.isEmpty(this.f81124n)) {
                this.f81114d.setText(String.format(getResources().getString(R.string.n_content_im_group_invitation_code), new Object[]{this.f81124n}));
                this.f81114d.setVisibility(0);
                return;
            }
            this.f81114d.setVisibility(8);
            return;
        }
        this.f81118h.setVisibility(8);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final void uh() {
        i.r().O(this.f81125o);
        i.r().O(this.f81126p);
    }

    public void vh(ShareInfo.ShareType shareType, InvitePosterListItem invitePosterListItem, int i11) {
        this.f81112b = shareType;
        this.f81113c = invitePosterListItem;
        this.f81117g = i11;
    }
}
