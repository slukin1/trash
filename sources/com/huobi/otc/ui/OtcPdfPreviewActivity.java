package com.huobi.otc.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.pdf.PdfPageData;
import com.huobi.otc.persenter.OtcPdfPreviewPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.n;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import sp.d2;
import sp.e2;

public class OtcPdfPreviewActivity extends BaseActivity<OtcPdfPreviewPresenter, OtcPdfPreviewPresenter.a> implements OtcPdfPreviewPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<PdfPageData> f79505b;

    /* renamed from: c  reason: collision with root package name */
    public Toolbar f79506c;

    /* renamed from: d  reason: collision with root package name */
    public LoadingLayout f79507d;

    /* renamed from: e  reason: collision with root package name */
    public String f79508e;

    /* renamed from: f  reason: collision with root package name */
    public String f79509f;

    /* renamed from: g  reason: collision with root package name */
    public String f79510g;

    /* renamed from: h  reason: collision with root package name */
    public long f79511h;

    /* renamed from: i  reason: collision with root package name */
    public PdfRenderer f79512i;

    /* renamed from: j  reason: collision with root package name */
    public com.bumptech.glide.load.engine.bitmap_recycle.e f79513j;

    /* renamed from: k  reason: collision with root package name */
    public t8.a f79514k;

    /* renamed from: l  reason: collision with root package name */
    public int f79515l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f79516m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f79517n;

    public class a implements t8.a {
        public a() {
        }

        public void a(HttpUrl httpUrl, long j11, long j12, boolean z11) {
            if (z11) {
                OtcPdfPreviewActivity.this.wh();
            }
        }

        public void b(HttpUrl httpUrl, IOException iOException) {
            OtcPdfPreviewActivity.this.xh();
        }
    }

    public class b extends BaseSubscriber<ArrayList<PdfPageData>> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(ArrayList<PdfPageData> arrayList) {
            if (!CollectionsUtils.b(arrayList)) {
                OtcPdfPreviewActivity.this.f79505b.setData(arrayList);
                OtcPdfPreviewActivity.this.f79507d.g();
                return;
            }
            OtcPdfPreviewActivity.this.f79507d.k();
        }

        public void onError(Throwable th2) {
            OtcPdfPreviewActivity.this.xh();
        }
    }

    public class c implements Func1<String, ArrayList<PdfPageData>> {
        public c() {
        }

        /* renamed from: a */
        public ArrayList<PdfPageData> call(String str) {
            File file = new File(str);
            try {
                OtcPdfPreviewActivity.this.f79512i = new PdfRenderer(ParcelFileDescriptor.open(file, 268435456));
                int pageCount = OtcPdfPreviewActivity.this.f79512i.getPageCount();
                ArrayList<PdfPageData> arrayList = new ArrayList<>();
                for (int i11 = 0; i11 < pageCount; i11++) {
                    PdfPageData pdfPageData = new PdfPageData();
                    pdfPageData.setPdfPath(str);
                    pdfPageData.setRenderer(OtcPdfPreviewActivity.this.f79512i);
                    pdfPageData.setPageIndex(i11);
                    pdfPageData.setBitmapPool(OtcPdfPreviewActivity.this.f79513j);
                    pdfPageData.setScreenWidth(OtcPdfPreviewActivity.this.f79515l);
                    arrayList.add(pdfPageData);
                }
                return arrayList;
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    public class d implements Func1<String, String> {
        public d() {
        }

        /* renamed from: a */
        public String call(String str) {
            OtcPdfPreviewActivity.this.f79516m.setVisibility(0);
            return str;
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            OtcPdfPreviewActivity.this.f79507d.k();
        }
    }

    public class f implements Action1<Void> {
        public f() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            HuobiToastUtil.v(OtcPdfPreviewActivity.this.getString(R$string.otc_saveimage_path_text) + OtcPdfPreviewActivity.this.f79508e);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void uh(View view) {
        this.f79507d.p();
        rh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void vh(Context context, String str, String str2, long j11) {
        Intent intent = new Intent(context, OtcPdfPreviewActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("key_pdf_url", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("key_pdf_name", str2);
        }
        if (j11 > 0) {
            intent.putExtra("key_pdf_file_size", j11);
        }
        context.startActivity(intent);
    }

    public void addEvent() {
        this.f79506c.setNavigationOnClickListener(new e2(this));
        this.f79507d.setOnRetryClickListener(new d2(this));
        dw.a.a(this.f79516m).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new f());
    }

    public boolean canFullScreen() {
        return false;
    }

    public int getContentView() {
        return R$layout.activity_pdf_preview;
    }

    public final void initData() {
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("key_pdf_url")) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("key_pdf_url");
        this.f79509f = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
        }
        this.f79510g = intent.getStringExtra("key_pdf_name");
        this.f79511h = intent.getLongExtra("key_pdf_file_size", 0);
    }

    public void initView() {
        initData();
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R$id.toolbar);
        this.f79506c = toolbar;
        String str = "";
        setToolBar(toolbar, str, true);
        this.f79507d = (LoadingLayout) this.viewFinder.b(R$id.otc_chat_loading_layout);
        this.f79516m = (ImageView) this.viewFinder.b(R$id.iv_pdf_download);
        TextView textView = (TextView) this.viewFinder.b(R$id.otc_pdf_name);
        this.f79517n = textView;
        textView.setText(this.f79510g);
        this.f79507d.p();
        this.f79513j = com.bumptech.glide.a.d(this).g();
        this.f79505b = (EasyRecyclerView) this.viewFinder.b(R$id.rv_otc_pdf);
        String str2 = this.f79510g;
        if (str2 != null && str2.lastIndexOf(".pdf") > 0) {
            str = sh();
        }
        if (TextUtils.isEmpty(str)) {
            str = System.currentTimeMillis() + ".pdf";
        }
        this.f79508e = pa.d.o().p() + File.separator + str;
        this.f79515l = n.g(this);
        rh();
    }

    public void onDestroy() {
        super.onDestroy();
        PdfRenderer pdfRenderer = this.f79512i;
        if (pdfRenderer != null) {
            pdfRenderer.close();
        }
        com.bumptech.glide.load.engine.bitmap_recycle.e eVar = this.f79513j;
        if (eVar != null) {
            eVar.b();
        }
        if (this.f79514k != null) {
            OtcModuleConfig.a().L(this.f79514k);
        }
    }

    /* renamed from: qh */
    public OtcPdfPreviewPresenter createPresenter() {
        return new OtcPdfPreviewPresenter();
    }

    public final void rh() {
        if (!TextUtils.isEmpty(this.f79508e)) {
            File file = new File(this.f79508e);
            if (file.exists() && file.length() == this.f79511h) {
                wh();
                return;
            }
        }
        this.f79514k = new a();
        OtcModuleConfig.a().z(this.f79509f, this.f79508e, this.f79514k);
    }

    public final String sh() {
        if (TextUtils.isEmpty(this.f79510g) || TextUtils.isEmpty(this.f79509f)) {
            return null;
        }
        String str = this.f79510g;
        String substring = str.substring(0, str.lastIndexOf(".pdf"));
        String str2 = this.f79509f;
        String substring2 = str2.substring(str2.lastIndexOf("/") + 1);
        String substring3 = substring2.substring(0, substring2.indexOf(".pdf"));
        return substring + "_" + substring3 + ".pdf";
    }

    /* renamed from: th */
    public OtcPdfPreviewPresenter.a getUI() {
        return this;
    }

    public final void wh() {
        Observable.just(this.f79508e).subscribeOn(AndroidSchedulers.mainThread()).map(new d()).observeOn(Schedulers.io()).map(new c()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b());
    }

    public final void xh() {
        runOnUiThread(new e());
    }
}
