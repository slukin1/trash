package com.huobi.finance.ui;

import ad.b;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.finance.bean.ChainItem;
import com.huobi.finance.bean.OneOffAddress;
import com.huobi.finance.presenter.UnifyDepositPresenter;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.huobi.finance.utils.UiFillUtil;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.e1;
import com.huobi.utils.v0;
import com.huobi.view.rv.GridDividerItemDecoration;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.d;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;
import rn.c;
import tg.r;

@Route(path = "/balance/deposit")
public class UnifyDepositActivity extends BaseActivity<UnifyDepositPresenter, UnifyDepositPresenter.g> implements UnifyDepositPresenter.g, EasyPermissions.PermissionCallbacks {
    public TextView A;
    public RelativeLayout B;
    public LinearLayout C;
    public Menu D;
    public EasyRecyclerView<ChainItem> E;
    public View F;
    public DialogFragment G;
    public TextView H;
    public boolean I;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f46818b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f46819c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46820d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46821e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46822f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46823g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46824h;

    /* renamed from: i  reason: collision with root package name */
    public Toolbar f46825i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f46826j;

    /* renamed from: k  reason: collision with root package name */
    public RelativeLayout f46827k;

    /* renamed from: l  reason: collision with root package name */
    public CoordinatorLayout f46828l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingLayout f46829m;

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f46830n;

    /* renamed from: o  reason: collision with root package name */
    public LinearLayout f46831o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f46832p;

    /* renamed from: q  reason: collision with root package name */
    public Button f46833q;

    /* renamed from: r  reason: collision with root package name */
    public String f46834r;

    /* renamed from: s  reason: collision with root package name */
    public Bitmap f46835s;

    /* renamed from: t  reason: collision with root package name */
    public OldCurrencyDepositFragment f46836t;

    /* renamed from: u  reason: collision with root package name */
    public View f46837u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f46838v;

    /* renamed from: w  reason: collision with root package name */
    public LinearLayout f46839w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f46840x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f46841y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f46842z;

    public class a extends ClickableSpan {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            HBBaseWebActivity.showWebView(UnifyDepositActivity.this, ((UnifyDepositPresenter) UnifyDepositActivity.this.getPresenter()).F0(), "", "", false);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ boolean Ah(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        boolean z11 = true;
        if (itemId != R.id.action_address_record) {
            if (itemId == R.id.action_record) {
                CurrencyHistoryActivity.oh(this, ((UnifyDepositPresenter) getPresenter()).C0(), "1");
                SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
                return z11;
            }
        } else if (((UnifyDepositPresenter) getPresenter()).I0()) {
            Intent intent = new Intent(this, OneOffAddressHistoryActivity.class);
            intent.putExtra(FirebaseAnalytics.Param.CURRENCY, ((UnifyDepositPresenter) getPresenter()).C0());
            intent.putExtra("chain", DepositWithdrawHelper.a(((UnifyDepositPresenter) getPresenter()).x0()));
            startActivityForResult(intent, 300);
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return z11;
        }
        z11 = false;
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return z11;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bh(View view) {
        HBBaseWebActivity.showWebView(this, e1.a(((UnifyDepositPresenter) getPresenter()).y0()), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ch(View view) {
        ((UnifyDepositPresenter) getPresenter()).e1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dh(View view) {
        CurrencySearchActivity.lj(this, "1", true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Eh(View view) {
        Mh(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fh(boolean z11) {
        this.I = z11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gh(HBDialogFragment hBDialogFragment) {
        new v0(this, "900004337406").d();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ConfigPreferences.n("user_config", "config_deposit_chain_hrc20_tips_no_more", this.I);
        ((UnifyDepositPresenter) getPresenter()).j1();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        UnifyDepositPresenter unifyDepositPresenter = (UnifyDepositPresenter) getPresenter();
        if (unifyDepositPresenter != null) {
            String C0 = unifyDepositPresenter.C0();
            unifyDepositPresenter.h1("");
            unifyDepositPresenter.m1(C0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void wh(Activity activity, String str) {
        Intent intent = new Intent(activity, DepositActivity.class);
        if (str != null) {
            intent.putExtra("coin", str.toLowerCase(Locale.US));
        }
        if (!r.x().F0()) {
            c.i().d(activity, new JumpTarget(intent, (Intent) null));
        } else if (r.x().X()) {
            HuobiToastUtil.j(R.string.sub_account_not_support_deposit);
        } else {
            activity.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(View view) {
        try {
            ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(this.f46819c.getText(), this.f46819c.getText()));
            HuobiToastUtil.t(this, R.string.currency_deposit_copied);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void yh(View view) {
        try {
            ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(this.f46821e.getText(), this.f46821e.getText()));
            HuobiToastUtil.t(this, R.string.currency_deposit_copied);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void zh(View view) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(this.f46834r) || (bitmap = this.f46835s) == null) {
            ((UnifyDepositPresenter) getPresenter()).E0();
        } else {
            Lh(this.f46834r, bitmap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void J4(String str) {
        if (!TextUtils.isEmpty(str)) {
            ViewUtil.m(this.f46820d, true);
            UiFillUtil.a(this.f46820d, str);
            return;
        }
        ViewUtil.m(this.f46820d, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0091 A[SYNTHETIC, Splitter:B:26:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009d A[SYNTHETIC, Splitter:B:31:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean Jh(android.content.Context r5, android.graphics.Bitmap r6) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r1 = r1.getAbsolutePath()
            r0.append(r1)
            java.lang.String r1 = java.io.File.separator
            r0.append(r1)
            java.lang.String r1 = "huobi"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r0 = r1.exists()
            if (r0 != 0) goto L_0x002c
            r1.mkdir()
        L_0x002c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Huobi_"
            r0.append(r2)
            com.hbg.lib.common.mvp.ActivityPresenter r2 = r4.getPresenter()
            com.huobi.finance.presenter.UnifyDepositPresenter r2 = (com.huobi.finance.presenter.UnifyDepositPresenter) r2
            java.lang.String r2 = r2.z0()
            r0.append(r2)
            java.lang.String r2 = "_Deposit.jpg"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1, r0)
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x008b }
            r1.<init>(r2)     // Catch:{ IOException -> 0x008b }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x0086, all -> 0x0083 }
            r3 = 60
            boolean r6 = r6.compress(r0, r3, r1)     // Catch:{ IOException -> 0x0086, all -> 0x0083 }
            r1.flush()     // Catch:{ IOException -> 0x0086, all -> 0x0083 }
            r1.close()     // Catch:{ IOException -> 0x0086, all -> 0x0083 }
            android.net.Uri r0 = android.net.Uri.fromFile(r2)     // Catch:{ IOException -> 0x0086, all -> 0x0083 }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ IOException -> 0x0086, all -> 0x0083 }
            java.lang.String r3 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r2.<init>(r3, r0)     // Catch:{ IOException -> 0x0086, all -> 0x0083 }
            r5.sendBroadcast(r2)     // Catch:{ IOException -> 0x0086, all -> 0x0083 }
            if (r6 == 0) goto L_0x007f
            r5 = 1
            r1.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x007e:
            return r5
        L_0x007f:
            r1.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0083:
            r5 = move-exception
            r0 = r1
            goto L_0x009b
        L_0x0086:
            r5 = move-exception
            r0 = r1
            goto L_0x008c
        L_0x0089:
            r5 = move-exception
            goto L_0x009b
        L_0x008b:
            r5 = move-exception
        L_0x008c:
            r5.printStackTrace()     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x0099
            r0.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0099:
            r5 = 0
            return r5
        L_0x009b:
            if (r0 == 0) goto L_0x00a5
            r0.close()     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00a5
        L_0x00a1:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00a5:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.ui.UnifyDepositActivity.Jh(android.content.Context, android.graphics.Bitmap):boolean");
    }

    public void K3(List<ChainItem> list) {
        EasyRecyclerView<ChainItem> easyRecyclerView = this.E;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(list);
        }
    }

    public final void Kh() {
        this.f46829m.g();
        this.f46831o.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((UnifyDepositPresenter) getPresenter()).G0());
        String format = String.format(getString(R.string.currency_deposit_know_hint), new Object[]{((UnifyDepositPresenter) getPresenter()).z0()});
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(format);
        spannableStringBuilder2.setSpan(new a(), 0, format.length(), 34);
        spannableStringBuilder2.setSpan(new UnderlineSpan() {
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(UnifyDepositActivity.this.getResources().getColor(R.color.currency_deposit_nas_transform_hint));
                textPaint.setUnderlineText(false);
            }
        }, 0, format.length(), 34);
        spannableStringBuilder.append(spannableStringBuilder2);
        this.f46832p.setText(spannableStringBuilder);
        this.f46832p.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void Lc(String str, String str2, Bitmap bitmap) {
        this.f46829m.g();
        this.f46830n.setVisibility(8);
        this.f46826j.setVisibility(0);
        this.f46819c.setText(str);
        if (bitmap != null) {
            this.f46818b.setImageBitmap(bitmap);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f46827k.setVisibility(0);
            this.f46821e.setText(str2);
            return;
        }
        this.f46827k.setVisibility(8);
    }

    public void Lf() {
        ChainInfo x02 = ((UnifyDepositPresenter) getPresenter()).x0();
        if (x02 != null && !TextUtils.isEmpty(x02.getDepositTipsDesc())) {
            new DialogUtils.b.d(this).c1(getResources().getString(R.string.dialog_minamount_hint_title)).C0(x02.getDepositTipsDesc()).q0(false).P0(getResources().getString(R.string.dialog_minamount_hint_confrm_btn)).Q0(b.f3517a).k0().show(getSupportFragmentManager(), "");
        }
    }

    public final void Lh(String str, Bitmap bitmap) {
        this.f46836t = new OldCurrencyDepositFragment();
        Bundle bundle = new Bundle();
        bundle.putString(InnerShareParams.ADDRESS, str);
        bundle.putParcelable("bitmap", bitmap);
        bundle.putString("coin", ((UnifyDepositPresenter) getPresenter()).y0());
        bundle.putSerializable("oldcoinname", ((UnifyDepositPresenter) getPresenter()).H0());
        this.f46836t.setArguments(bundle);
        this.f46836t.show(getSupportFragmentManager(), "OldCurrencyDepositFragment");
    }

    public void M6() {
        new DialogUtils.b.d(this).c1(getString(R.string.n_deposit_chain_tips)).x0(true).C0(getString(R.string.n_deposit_chain_hrc20_tips_content)).y0(getString(R.string.n_do_not_prompt_next_time)).v0(new l8(this)).q0(false).T0(true).S0(Integer.valueOf(getResources().getColor(R.color.dialog_confirm_text_color))).R0(getString(R.string.n_withdraw_chain_hrc20_notice)).U0(new b8(this)).P0(getResources().getString(R.string.dialog_minamount_hint_confrm_btn)).Q0(new a8(this)).k0().show(getSupportFragmentManager(), "");
    }

    @AfterPermissionGranted(126)
    public void Mh(boolean z11) {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.WRITE_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(this, str)) {
            Jh(this, Nh(this, z11));
            HuobiToastUtil.t(this, R.string.currency_deposit_saved);
            return;
        }
        EasyPermissions.requestPermissions(this, 126, str);
    }

    public void Ne() {
        if (((UnifyDepositPresenter) getPresenter()).I0()) {
            this.f46830n.setVisibility(0);
            this.f46826j.setVisibility(8);
        } else {
            this.f46822f.setVisibility(8);
            this.f46826j.setVisibility(8);
            this.f46829m.k();
        }
        this.C.setVisibility(8);
        this.A.setVisibility(8);
        this.f46841y.setVisibility(8);
        this.B.setVisibility(8);
        ViewUtil.m(this.f46820d, false);
    }

    public void Nf(OneOffAddress oneOffAddress, String str, Bitmap bitmap) {
        this.f46829m.g();
        this.f46830n.setVisibility(8);
        this.f46819c.setText(oneOffAddress.getAddress());
        this.f46840x.setText(String.format(getString(R.string.currency_deposit_address_create_date), new Object[]{DateTimeUtils.j(oneOffAddress.getAssignedAt())}));
        if (bitmap != null) {
            this.f46818b.setImageBitmap(bitmap);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f46827k.setVisibility(0);
            this.f46821e.setText(str);
        } else {
            this.f46827k.setVisibility(8);
        }
        this.f46826j.setVisibility(0);
        this.f46839w.setVisibility(8);
        this.f46840x.setVisibility(0);
        this.f46822f.setVisibility(0);
    }

    public final Bitmap Nh(Activity activity, boolean z11) {
        View view;
        if (z11) {
            view = this.f46836t.getDialog().getWindow().getDecorView();
        } else {
            view = activity.getWindow().getDecorView();
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i11 = rect.top;
        int g11 = PixelUtils.g();
        int f11 = PixelUtils.f();
        if (drawingCache.getWidth() < g11) {
            g11 = drawingCache.getWidth();
        }
        if (drawingCache.getHeight() < f11) {
            f11 = drawingCache.getHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, i11, g11, f11 - i11);
        view.destroyDrawingCache();
        return createBitmap;
    }

    public void Oc(boolean z11) {
        MenuItem findItem;
        this.A.setText(String.format(getResources().getString(R.string.currency_deposit_iota_address_hint), new Object[]{((UnifyDepositPresenter) getPresenter()).z0()}));
        if (z11) {
            this.A.setVisibility(0);
            this.f46841y.setVisibility(0);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
            this.A.setVisibility(8);
            this.f46841y.setVisibility(8);
            this.B.setVisibility(8);
        }
        Menu menu = this.D;
        if (menu != null && (findItem = menu.findItem(R.id.action_address_record)) != null) {
            findItem.setVisible(z11);
        }
    }

    public Bitmap S6(String str, int i11, int i12) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
                    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
                    hashMap.put(EncodeHintType.MARGIN, 0);
                    BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i11, i12, hashMap);
                    int[] iArr = new int[(i11 * i12)];
                    for (int i13 = 0; i13 < i12; i13++) {
                        for (int i14 = 0; i14 < i11; i14++) {
                            if (encode.get(i14, i13)) {
                                iArr[(i13 * i11) + i14] = -16777216;
                            } else {
                                iArr[(i13 * i11) + i14] = -1;
                            }
                        }
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.RGB_565);
                    createBitmap.setPixels(iArr, 0, i11, 0, 0, i11, i12);
                    return createBitmap;
                }
            } catch (WriterException e11) {
                d.g(e11);
            }
        }
        return null;
    }

    public void addEvent() {
        this.f46829m.setOnRetryClickListener(new i8(this));
        this.f46825i.setOnMenuItemClickListener(new k8(this));
        this.f46842z.setOnClickListener(new h8(this));
        this.f46841y.setOnClickListener(new e8(this));
        this.f46837u.setOnClickListener(new d8(this));
        this.f46824h.setClickable(true);
        this.f46822f.setClickable(true);
        this.f46822f.setOnClickListener(new g8(this));
        this.f46824h.setOnClickListener(new j8(this));
        this.f46823g.setOnClickListener(new z7(this));
        this.f46833q.setOnClickListener(new f8(this));
    }

    public void dg(boolean z11) {
        LinearLayout linearLayout = this.f46831o;
        if (linearLayout == null) {
            return;
        }
        if (z11) {
            Kh();
        } else {
            linearLayout.setVisibility(8);
        }
    }

    public void gc(String str, Bitmap bitmap) {
        this.f46834r = str;
        this.f46835s = bitmap;
        Lh(str, bitmap);
    }

    public int getContentView() {
        return R.layout.activity_unify_deposit;
    }

    public void gf(boolean z11) {
        View view = this.F;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public void i5() {
        String z02 = ((UnifyDepositPresenter) getPresenter()).z0();
        if (this.f46838v.getText() == null || !this.f46838v.getText().toString().equals(z02)) {
            this.f46838v.setText(z02);
            this.H.setText(k.C().B(((UnifyDepositPresenter) getPresenter()).C0()));
        }
        this.f46822f.setVisibility(0);
        this.f46826j.setVisibility(0);
        this.f46827k.setVisibility(8);
        this.f46830n.setVisibility(8);
        this.f46839w.setVisibility(8);
        this.f46840x.setVisibility(4);
    }

    public void initView() {
        this.f46825i = (Toolbar) this.viewFinder.b(R.id.currency_deposit_toolbar);
        String string = getResources().getString(R.string.balance_detail_deposit);
        this.f46825i.setTitle((CharSequence) string);
        setToolBar(this.f46825i, string, true);
        this.f46828l = (CoordinatorLayout) this.viewFinder.b(R.id.main_content);
        this.f46818b = (ImageView) this.viewFinder.b(R.id.currency_deposit_qr);
        this.f46819c = (TextView) this.viewFinder.b(R.id.currency_deposit_address);
        this.f46820d = (TextView) this.viewFinder.b(R.id.currency_deposit_hint);
        this.f46824h = (TextView) this.viewFinder.b(R.id.currency_deposit_address_copy);
        this.f46823g = (TextView) this.viewFinder.b(R.id.currency_deposit_tag_copy);
        this.f46821e = (TextView) this.viewFinder.b(R.id.currency_deposit_tag);
        this.f46822f = (TextView) this.viewFinder.b(R.id.currency_deposit_copy_qr);
        this.f46826j = (RelativeLayout) this.viewFinder.b(R.id.currency_deposit_address_layout);
        this.f46829m = (LoadingLayout) this.viewFinder.b(R.id.loading_layout_unify_deposit);
        this.f46827k = (RelativeLayout) this.viewFinder.b(R.id.currency_deposit_tag_layout);
        this.f46830n = (LinearLayout) this.viewFinder.b(R.id.currency_deposit_error_ll);
        this.f46839w = (LinearLayout) this.viewFinder.b(R.id.currency_deposit_invalid_address_ll);
        this.f46840x = (TextView) this.viewFinder.b(R.id.currency_deposit_address_create_tv);
        this.f46841y = (TextView) this.viewFinder.b(R.id.currency_deposit_new_address_tv);
        this.f46842z = (TextView) this.viewFinder.b(R.id.currency_deposit_read_more);
        this.A = (TextView) this.viewFinder.b(R.id.deposit_iota_address_hint);
        this.f46831o = (LinearLayout) this.viewFinder.b(R.id.ll_transfer_old_addr);
        this.f46832p = (TextView) this.viewFinder.b(R.id.tv_nas_hint);
        this.f46833q = (Button) this.viewFinder.b(R.id.btn_action);
        this.f46837u = this.viewFinder.b(R.id.currency_select_root);
        this.f46838v = (TextView) this.viewFinder.b(R.id.currency_title);
        this.H = (TextView) this.viewFinder.b(R.id.currency_title_full_name);
        this.B = (RelativeLayout) this.viewFinder.b(R.id.currency_deposit_warning_root);
        this.C = (LinearLayout) this.viewFinder.b(R.id.currency_deposit_new_address_root);
        this.F = this.viewFinder.b(R.id.deposit_chain_root);
        EasyRecyclerView<ChainItem> easyRecyclerView = (EasyRecyclerView) this.viewFinder.b(R.id.deposit_chain_list);
        this.E = easyRecyclerView;
        easyRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        this.E.addItemDecoration(new GridDividerItemDecoration(ContextCompat.getDrawable(this, R.color.baseColorContentBackground), PixelUtils.a(10.0f)));
        RelativeLayout relativeLayout = (RelativeLayout) this.viewFinder.b(R.id.eth_deposit_address_layout);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem findItem;
        getMenuInflater().inflate(R.menu.menu_iota_currency_detail_record, menu);
        this.D = menu;
        if (menu == null || (findItem = menu.findItem(R.id.action_address_record)) == null) {
            return true;
        }
        findItem.setVisible(((UnifyDepositPresenter) getPresenter()).I0());
        return true;
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, list)) {
            new AppSettingsDialog.Builder((Activity) this, getString(R.string.currency_deposit_permission_write_external_storage_apply)).setTitle(getString(R.string.currency_deposit_permission_apply)).setPositiveButton(getString(R.string.currency_deposit_go_to_settings)).setNegativeButton(getString(R.string.n_otc_new_otc_cancel), (DialogInterface.OnClickListener) null).setRequestCode(126).build().show();
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
    }

    public void p9(Bitmap bitmap) {
        this.f46830n.setVisibility(8);
        this.f46829m.g();
        if (bitmap != null) {
            this.f46818b.setImageBitmap(bitmap);
        }
        this.f46839w.setVisibility(0);
        this.f46826j.setVisibility(8);
        this.f46840x.setVisibility(4);
        this.f46822f.setVisibility(8);
    }

    public void u8() {
        String str;
        DialogFragment dialogFragment = this.G;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
        String format = String.format(getResources().getString(R.string.currency_deposit_tag_dialog_attention), new Object[]{((UnifyDepositPresenter) getPresenter()).z0()});
        ChainInfo x02 = ((UnifyDepositPresenter) getPresenter()).x0();
        if (x02 == null || TextUtils.isEmpty(x02.getDepositTipsDesc())) {
            str = "";
        } else {
            str = "\n" + x02.getDepositTipsDesc();
        }
        HBDialogFragment k02 = new DialogUtils.b.d(this).c1(getResources().getString(R.string.dialog_minamount_hint_title)).C0(format + str).q0(false).P0(getResources().getString(R.string.dialog_minamount_hint_confrm_btn)).Q0(c8.f47075a).k0();
        this.G = k02;
        k02.show(getSupportFragmentManager(), "");
    }

    /* renamed from: uh */
    public UnifyDepositPresenter createPresenter() {
        return new UnifyDepositPresenter();
    }

    /* renamed from: vh */
    public UnifyDepositPresenter.g getUI() {
        return this;
    }
}
