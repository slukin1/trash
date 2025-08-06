package com.huobi.share.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import bh.j;
import bp.d;
import com.google.zxing.WriterException;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.invite.bean.InviterInfo;
import com.huobi.share.bean.PreviewItem;
import com.huobi.share.fragment.ShareStylePreviewFragment;
import com.huobi.share.presenter.ContentSharePresenter;
import com.huobi.share.view.RiseDownProgressBar;
import com.huobi.utils.ImageUtils;
import com.huochat.community.network.domain.DomainTool;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Locale;
import nr.e;
import nr.f;
import pro.huobi.R;
import tg.r;

public class ContentShareActivity extends BaseActivity<ContentSharePresenter, ContentSharePresenter.b> implements EasyPermissions.PermissionCallbacks, ContentSharePresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public String f81009b;

    /* renamed from: c  reason: collision with root package name */
    public String f81010c;

    /* renamed from: d  reason: collision with root package name */
    public long f81011d;

    /* renamed from: e  reason: collision with root package name */
    public long f81012e;

    /* renamed from: f  reason: collision with root package name */
    public int f81013f;

    /* renamed from: g  reason: collision with root package name */
    public int f81014g;

    /* renamed from: h  reason: collision with root package name */
    public String f81015h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f81016i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f81017j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f81018k;

    /* renamed from: l  reason: collision with root package name */
    public RadioGroup f81019l;

    /* renamed from: m  reason: collision with root package name */
    public ViewPager f81020m;

    /* renamed from: n  reason: collision with root package name */
    public List<ShareStylePreviewFragment> f81021n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public List<PreviewItem> f81022o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public float f81023p;

    /* renamed from: q  reason: collision with root package name */
    public String f81024q;

    /* renamed from: r  reason: collision with root package name */
    public PreviewItem f81025r;

    /* renamed from: s  reason: collision with root package name */
    public Bitmap f81026s = null;

    /* renamed from: t  reason: collision with root package name */
    public Bitmap f81027t = null;

    /* renamed from: u  reason: collision with root package name */
    public String f81028u;

    public class a implements tx.a {
        public a() {
        }

        public void a(String str, View view) {
        }

        public void b(String str, View view, FailReason failReason) {
        }

        public void c(String str, View view, Bitmap bitmap) {
            for (int i11 = 0; i11 < 3; i11++) {
                ContentShareActivity.this.f81022o.get(i11).setContentBmp(bitmap);
                ((ShareStylePreviewFragment) ContentShareActivity.this.f81021n.get(i11)).rh(ContentShareActivity.this.f81022o.get(i11));
                ContentShareActivity.this.f81025r.setContentBmp(bitmap);
            }
        }

        public void d(String str, View view) {
        }
    }

    public class b extends d {
        public b(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int a(Fragment fragment) {
            return 0;
        }

        public int getCount() {
            return ContentShareActivity.this.f81021n.size();
        }

        public Fragment getItem(int i11) {
            ShareStylePreviewFragment shareStylePreviewFragment = (ShareStylePreviewFragment) ContentShareActivity.this.f81021n.get(i11);
            shareStylePreviewFragment.rh(ContentShareActivity.this.f81022o.get(i11));
            return shareStylePreviewFragment;
        }
    }

    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            if (i11 == 0) {
                ContentShareActivity.this.f81019l.check(R.id.id_radio_style1);
                ContentShareActivity contentShareActivity = ContentShareActivity.this;
                PreviewItem unused = contentShareActivity.f81025r = contentShareActivity.f81022o.get(0);
            } else if (i11 == 1) {
                ContentShareActivity.this.f81019l.check(R.id.id_radio_style2);
                ContentShareActivity contentShareActivity2 = ContentShareActivity.this;
                PreviewItem unused2 = contentShareActivity2.f81025r = contentShareActivity2.f81022o.get(1);
            } else if (i11 == 2) {
                ContentShareActivity.this.f81019l.check(R.id.id_radio_style3);
                ContentShareActivity contentShareActivity3 = ContentShareActivity.this;
                PreviewItem unused3 = contentShareActivity3.f81025r = contentShareActivity3.f81022o.get(2);
            }
            for (int i12 = 0; i12 < ContentShareActivity.this.f81021n.size(); i12++) {
                if (i12 == i11) {
                    ((ShareStylePreviewFragment) ContentShareActivity.this.f81021n.get(i12)).qh(false);
                } else {
                    ((ShareStylePreviewFragment) ContentShareActivity.this.f81021n.get(i12)).qh(true);
                }
            }
        }
    }

    public static /* synthetic */ void Ah(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        HuobiToastUtil.s(R.string.otc_saveimage_path_faild_text);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bh(HBDialogFragment hBDialogFragment) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", j.c().getPackageName(), (String) null));
        startActivity(intent);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("flash_id", Long.valueOf(this.f81012e));
        hashMap.put("is_login", Boolean.valueOf(r.x().F0()));
        hashMap.put("template_id", this.f81025r.getTemplate());
        g.i("CSC_Share_and_Save_pictures", hashMap);
        Fh(th());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("flash_id", Long.valueOf(this.f81012e));
        hashMap.put("is_login", Boolean.valueOf(r.x().F0()));
        hashMap.put("template_id", this.f81025r.getTemplate());
        g.i("CSC_Share_hits", hashMap);
        Gh(th());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static String vh() {
        return !SystemUtils.c() ? wi.b.f48038b : DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void yh(RadioGroup radioGroup, int i11) {
        if (i11 == R.id.id_radio_style1) {
            this.f81020m.setCurrentItem(0);
            this.f81025r = this.f81022o.get(0);
        } else if (i11 == R.id.id_radio_style2) {
            this.f81020m.setCurrentItem(1);
            this.f81025r = this.f81022o.get(1);
        } else if (i11 == R.id.id_radio_style3) {
            this.f81020m.setCurrentItem(2);
            this.f81025r = this.f81022o.get(2);
        }
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh() {
        List<PreviewItem> list = this.f81022o;
        if (list != null && list.size() > 0) {
            this.f81020m.setCurrentItem(1);
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    public void A6(InviterInfo inviterInfo) {
        this.f81024q = inviterInfo.getInviteCode();
        this.f81028u = inviterInfo.getUsdtRate();
        try {
            ViewGroup viewGroup = (ViewGroup) this.viewFinder.b(R.id.id_share_invite_layout);
            TextView textView = (TextView) this.viewFinder.b(R.id.id_share_invite_desc);
            if (textView == null || TextUtils.isEmpty(this.f81028u)) {
                ViewUtil.m(viewGroup, false);
                return;
            }
            String format = String.format(Locale.getDefault(), "%.0f", new Object[]{Float.valueOf(Float.parseFloat(this.f81028u) * 100.0f)});
            Locale locale = Locale.getDefault();
            String string = getString(R.string.n_share_invite_reward_param);
            textView.setText(String.format(locale, string, new Object[]{format + "%"}));
            ViewUtil.m(textView, true);
            ViewUtil.m(viewGroup, true);
        } catch (IllegalFormatException e11) {
            k.o("setInviteInfo", e11.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0096 A[SYNTHETIC, Splitter:B:26:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a5 A[SYNTHETIC, Splitter:B:32:0x00a5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String Ch(android.content.Context r8, android.graphics.Bitmap r9) {
        /*
            r7 = this;
            java.lang.String r0 = "ContentShareActivity"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = android.os.Environment.DIRECTORY_DCIM
            java.io.File r2 = android.os.Environment.getExternalStoragePublicDirectory(r2)
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r2 = "Camera"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r1 = r2.exists()
            if (r1 != 0) goto L_0x002c
            r2.mkdir()
        L_0x002c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Huobi_news"
            r1.append(r3)
            long r3 = com.hbg.lib.common.utils.DateTimeUtils.v()
            r1.append(r3)
            java.lang.String r3 = ".jpg"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.io.File r3 = new java.io.File
            r3.<init>(r2, r1)
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x0087 }
            r5 = 90
            boolean r9 = r9.compress(r4, r5, r2)     // Catch:{ IOException -> 0x0087 }
            r2.flush()     // Catch:{ IOException -> 0x0087 }
            r2.close()     // Catch:{ IOException -> 0x0087 }
            android.net.Uri r4 = android.net.Uri.fromFile(r3)     // Catch:{ IOException -> 0x0087 }
            android.content.Intent r5 = new android.content.Intent     // Catch:{ IOException -> 0x0087 }
            java.lang.String r6 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r5.<init>(r6, r4)     // Catch:{ IOException -> 0x0087 }
            r8.sendBroadcast(r5)     // Catch:{ IOException -> 0x0087 }
            if (r9 == 0) goto L_0x0080
            java.lang.String r8 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x0087 }
            r2.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007f
        L_0x0077:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            i6.k.f(r0, r9)
        L_0x007f:
            return r8
        L_0x0080:
            r2.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x00a2
        L_0x0084:
            r8 = move-exception
            r1 = r2
            goto L_0x00a3
        L_0x0087:
            r8 = move-exception
            goto L_0x008d
        L_0x0089:
            r8 = move-exception
            goto L_0x00a3
        L_0x008b:
            r8 = move-exception
            r2 = r1
        L_0x008d:
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0084 }
            i6.k.f(r0, r8)     // Catch:{ all -> 0x0084 }
            if (r2 == 0) goto L_0x00a2
            r2.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x00a2
        L_0x009a:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()
            i6.k.f(r0, r8)
        L_0x00a2:
            return r1
        L_0x00a3:
            if (r1 == 0) goto L_0x00b1
            r1.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00b1
        L_0x00a9:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            i6.k.f(r0, r9)
        L_0x00b1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.share.ui.ContentShareActivity.Ch(android.content.Context, android.graphics.Bitmap):java.lang.String");
    }

    public String Dh(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
            return ImageUtils.h(bitmap, compressFormat, FileUtil.f(compressFormat.name(), false));
        } catch (Exception e11) {
            k.f("ContentShareActivity", e11.getMessage());
            return "";
        }
    }

    public void Eh() {
        DialogUtils.c0(this, getResources().getString(R.string.share_content_tip), (String) null, getResources().getString(R.string.share_cancel), getResources().getString(R.string.share_ok), f.f58703a, new e(this));
    }

    public void Fh(String str) {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{PermissionConfig.READ_EXTERNAL_STORAGE, PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        if (!EasyPermissions.hasPermissions(this, strArr)) {
            boolean z11 = false;
            for (String shouldShowRequestPermissionRationale : strArr) {
                z11 = z11 || EasyPermissions.shouldShowRequestPermissionRationale(this, shouldShowRequestPermissionRationale);
            }
            if (!z11) {
                Eh();
            } else {
                EasyPermissions.requestPermissions(this, 126, strArr);
            }
        } else if (!TextUtils.isEmpty(Ch(this, this.f81026s))) {
            HuobiToastUtil.s(R.string.save_success);
        }
    }

    public void Gh(String str) {
        Uri uri;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(str);
                    if (file.exists()) {
                        if (rh()) {
                            uri = FileProvider.getUriForFile(this, GlobalAppConfig.a() + ".fileprovider", new File(str));
                        } else {
                            uri = Uri.fromFile(file);
                        }
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setType(SelectMimeType.SYSTEM_IMAGE);
                        intent.putExtra("android.intent.extra.STREAM", uri);
                        startActivity(Intent.createChooser(intent, "share"));
                    }
                }
            } catch (NullPointerException e11) {
                k.f("ContentShareActivity", e11.getMessage());
            }
        }
    }

    public void addEvent() {
        if (!TextUtils.isEmpty(this.f81015h) && URLUtil.isValidUrl(this.f81015h)) {
            g6.b.c().m(this.f81015h, new a());
        }
        ImageView imageView = this.f81018k;
        if (imageView != null) {
            imageView.setOnClickListener(new nr.a(this));
        }
        RadioGroup radioGroup = this.f81019l;
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new nr.d(this));
        }
        ViewGroup viewGroup = this.f81017j;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new nr.b(this));
        }
        ViewGroup viewGroup2 = this.f81016i;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(new nr.c(this));
        }
        this.f81021n.clear();
        for (int i11 = 0; i11 < this.f81022o.size(); i11++) {
            ShareStylePreviewFragment shareStylePreviewFragment = (ShareStylePreviewFragment) getSupportFragmentManager().m0(String.valueOf(i11));
            if (shareStylePreviewFragment == null) {
                shareStylePreviewFragment = ShareStylePreviewFragment.ph(i11, this.f81022o.get(i11));
            }
            this.f81021n.add(shareStylePreviewFragment);
        }
        ViewPager viewPager = this.f81020m;
        if (viewPager != null) {
            viewPager.setAdapter(new b(getSupportFragmentManager()));
            this.f81020m.setOffscreenPageLimit(this.f81021n.size() - 1);
            this.f81020m.addOnPageChangeListener(new c());
        }
    }

    public boolean canFullScreen() {
        return true;
    }

    public int getContentView() {
        return R.layout.activity_content_main_share;
    }

    public void initView() {
        k.o("ContentShareActivity", "initView");
        this.f81018k = (ImageView) this.viewFinder.b(R.id.share_content_close);
        this.f81017j = (ViewGroup) this.viewFinder.b(R.id.id_screen_save_vg);
        this.f81016i = (ViewGroup) this.viewFinder.b(R.id.id_screen_share_vg);
        this.f81020m = (ViewPager) this.viewFinder.b(R.id.id_share_viewpager);
        this.f81019l = (RadioGroup) this.viewFinder.b(R.id.id_style_radio_group);
        this.f81009b = getIntent().getStringExtra("title");
        this.f81010c = getIntent().getStringExtra("content");
        this.f81011d = getIntent().getLongExtra("timeStamp", DateTimeUtils.v());
        this.f81012e = getIntent().getLongExtra("id", 0);
        this.f81013f = getIntent().getIntExtra("riseNumber", 0);
        this.f81014g = getIntent().getIntExtra("downNumber", 0);
        this.f81015h = getIntent().getStringExtra("contentImg");
        this.f81023p = getResources().getDimension(R.dimen.dimen_67);
        ViewPager viewPager = this.f81020m;
        if (viewPager != null) {
            viewPager.setPageTransformer(false, new lr.g(this, 0.1f));
        }
        for (int i11 = 0; i11 < 3; i11++) {
            String str = "1002";
            int i12 = R.layout.layout_content_share_entity_style1;
            if (i11 == 0) {
                i12 = R.layout.layout_content_share_entity_style3;
                str = "1001";
            } else if (i11 != 1 && i11 == 2) {
                i12 = R.layout.layout_content_share_entity_style2;
                str = "1003";
            }
            PreviewItem previewItem = new PreviewItem(this.f81009b, this.f81010c, this.f81011d, this.f81013f, this.f81014g, this.f81015h, i12);
            previewItem.setTemplate(str);
            this.f81022o.add(previewItem);
        }
        this.f81025r = this.f81022o.get(1);
        this.f81019l.check(R.id.id_radio_style2);
        ViewPager viewPager2 = this.f81020m;
        if (viewPager2 != null) {
            viewPager2.postDelayed(new nr.g(this), 50);
        }
    }

    public void onPermissionsDenied(int i11, List<String> list) {
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        String th2 = th();
        if (!TextUtils.isEmpty(th2)) {
            Fh(th2);
        }
    }

    public boolean rh() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: sh */
    public ContentSharePresenter createPresenter() {
        return new ContentSharePresenter();
    }

    public String th() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_content_share_preview, getParentLayout(), false);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.share_img_root);
        if (viewGroup != null) {
            viewGroup.addView(LayoutInflater.from(this).inflate(this.f81025r.getLayoutRes(), getParentLayout(), false), 0);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.share_img_qrcode);
        TextView textView = (TextView) inflate.findViewById(R.id.share_tv_invicode);
        RiseDownProgressBar riseDownProgressBar = (RiseDownProgressBar) inflate.findViewById(R.id.id_share_progressBar);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.share_content_img);
        if (!TextUtils.isEmpty(this.f81024q)) {
            textView.setText(String.format(getResources().getString(R.string.n_content_im_group_invitation_code), new Object[]{this.f81024q}));
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        try {
            imageView.setImageBitmap(ImageUtils.c(uh(), (int) this.f81023p));
        } catch (WriterException e11) {
            k.f("ContentShareActivity", e11.getMessage());
        }
        inflate.findViewById(R.id.share_img_qrcode);
        TextView textView2 = (TextView) inflate.findViewById(R.id.share_issue_time_tv);
        TextView textView3 = (TextView) inflate.findViewById(R.id.share_title);
        TextView textView4 = (TextView) inflate.findViewById(R.id.share_content);
        String i11 = DateTimeUtils.i(this.f81011d, "EEEE MM-dd HH:mm", AppLanguageHelper.getInstance().getCurAppLocale());
        if (textView2 != null) {
            textView2.setText(i11);
        }
        if (riseDownProgressBar != null) {
            riseDownProgressBar.b(this.f81013f, this.f81014g);
        }
        if (textView3 != null && !TextUtils.isEmpty(this.f81009b)) {
            textView3.setText(this.f81009b);
        }
        if (textView4 != null) {
            if (!TextUtils.isEmpty(this.f81010c)) {
                textView4.setText(this.f81010c);
            } else {
                textView4.setVisibility(8);
            }
        }
        if (!(imageView2 == null || this.f81025r.getContentBmp() == null)) {
            imageView2.setImageBitmap(this.f81025r.getContentBmp());
        }
        Bitmap b11 = ImageUtils.b(inflate);
        this.f81026s = b11;
        String Dh = Dh(b11);
        if (Dh == null || Dh.isEmpty()) {
            finish();
        }
        return Dh;
    }

    public String uh() {
        String str = vh() + (AppLanguageHelper.getInstance().isChineseLanguage() ? "/zh-cn" : "/en-us") + "/views/feed/details/news-flash-details/" + this.f81012e;
        if (!r.x().F0()) {
            return str;
        }
        return str + "?inviteCode=" + this.f81024q;
    }

    /* renamed from: wh */
    public ContentSharePresenter.b getUI() {
        return this;
    }
}
