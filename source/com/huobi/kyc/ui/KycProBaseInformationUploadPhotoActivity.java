package com.huobi.kyc.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.kyc.presenter.KycProBaseInformationUploadPhotoPresenter;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pro.huobi.R;
import um.n;
import um.o;

public class KycProBaseInformationUploadPhotoActivity extends BaseActivity<KycProBaseInformationUploadPhotoPresenter, KycProBaseInformationUploadPhotoPresenter.b> implements KycProBaseInformationUploadPhotoPresenter.b, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f74891b;

    /* renamed from: c  reason: collision with root package name */
    public View f74892c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f74893d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f74894e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74895f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f74896g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f74897h;

    /* renamed from: i  reason: collision with root package name */
    public BottomMenuFragment f74898i = new BottomMenuFragment();

    /* renamed from: j  reason: collision with root package name */
    public List<MenuItem> f74899j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public Toolbar f74900k;

    /* renamed from: l  reason: collision with root package name */
    public MenuItemOnClickListener f74901l = new o(this);

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Og(View view) {
        onBackPressed();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Pg(View view, MenuItem menuItem, int i11) {
        if (i11 == 0) {
            ((KycProBaseInformationUploadPhotoPresenter) getPresenter()).X();
        } else if (i11 == 1) {
            ((KycProBaseInformationUploadPhotoPresenter) getPresenter()).U();
        }
        this.f74898i.dismiss();
    }

    public void Ea() {
        this.f74893d.setProgress(0);
        this.f74894e.setVisibility(0);
        this.f74894e.setText(R.string.verification_upload_message);
        this.f74891b.setImageResource(R.drawable.verification_upload_photos_default);
        this.f74897h = false;
        Qg(false);
        HuobiToastUtil.s(R.string.verification_upload_failed);
    }

    public void Fd(Uri uri) {
        this.f74893d.setProgress(0);
        this.f74894e.setVisibility(8);
        this.f74897h = true;
        Qg(true);
        HuobiToastUtil.s(R.string.verification_upload_complete);
    }

    public final void Qg(boolean z11) {
        this.f74895f.setEnabled(z11);
    }

    public void Xd(Uri uri) {
        this.f74896g = uri;
        this.f74894e.setVisibility(0);
        this.f74894e.setText(R.string.verification_upload_msg);
        this.f74893d.setProgress(0);
        this.f74891b.setImageURI(uri);
    }

    /* renamed from: Zf */
    public KycProBaseInformationUploadPhotoPresenter createPresenter() {
        return new KycProBaseInformationUploadPhotoPresenter();
    }

    public void addEvent() {
        this.f74892c.setOnClickListener(this);
        this.f74895f.setOnClickListener(this);
    }

    /* renamed from: fg */
    public KycProBaseInformationUploadPhotoPresenter.b getUI() {
        return this;
    }

    public int getContentView() {
        return R.layout.activity_verification_step_2;
    }

    public final void gg() {
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f74900k = toolbar;
        setToolBar(toolbar, getString(R.string.setting_upload_photos), true);
        this.f74900k.setNavigationOnClickListener(new n(this));
    }

    public void initView() {
        this.f74892c = this.viewFinder.b(R.id.rl_upload_example);
        this.f74891b = (ImageView) this.viewFinder.b(R.id.iv_upload_default);
        this.f74893d = (ProgressBar) this.viewFinder.b(R.id.pb_upload_photo);
        this.f74894e = (TextView) this.viewFinder.b(R.id.tv_upload_msg);
        this.f74895f = (TextView) this.viewFinder.b(R.id.btn_verification_next);
        this.f74893d.setMax(99);
        this.f74893d.setProgress(0);
        boolean z11 = this.f74896g != null;
        if (z11) {
            this.f74893d.setProgress(0);
            this.f74894e.setVisibility(8);
            this.f74891b.setImageURI(this.f74896g);
        }
        this.f74895f.setEnabled(z11);
        gg();
    }

    public void oh() {
        this.f74898i.show(getFragmentManager(), "BottomMenuFragment");
    }

    public void onBackPressed() {
        if (this.f74897h && this.f74896g != null) {
            Intent intent = new Intent();
            intent.putExtra("THUMBNAIL_URI_KEY", this.f74896g);
            setResult(-1, intent);
        }
        super.onBackPressed();
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.btn_verification_next) {
            String stringExtra = getIntent().getStringExtra("FIRST_NAME_KEY");
            String stringExtra2 = getIntent().getStringExtra("LAST_NAME_KEY");
            String stringExtra3 = getIntent().getStringExtra("CARD_NUMBER_KEY");
            String stringExtra4 = getIntent().getStringExtra("COUNTRY_ID_KEY");
            String stringExtra5 = getIntent().getStringExtra("DM_SOURCE_KEY");
            HashMap hashMap = new HashMap();
            hashMap.put("first_name", stringExtra);
            hashMap.put("last_name", stringExtra2);
            hashMap.put("card_no", stringExtra3);
            hashMap.put("countries_id", stringExtra4);
            hashMap.put("source_from", stringExtra5);
            hashMap.put("method", "do_auth_pro");
            ((KycProBaseInformationUploadPhotoPresenter) getPresenter()).Y(hashMap);
        } else if (id2 == R.id.rl_upload_example) {
            oh();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        this.f74896g = (Uri) getIntent().getParcelableExtra("THUMBNAIL_URI_KEY");
        List<MenuItem> list = this.f74899j;
        String string = getString(R.string.setting_take_a_picture);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        list.add(new MenuItem("", string, menuItemStyle, this.f74901l));
        this.f74899j.add(new MenuItem("", getString(R.string.setting_choose_from_camera), menuItemStyle, this.f74901l));
        this.f74898i.setMenuItems(this.f74899j);
        super.onCreate(bundle);
    }

    public void q0() {
        this.f74898i.dismiss();
    }

    public void r4(int i11) {
        this.f74893d.setProgress(i11);
    }
}
