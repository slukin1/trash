package com.hbg.lib.imsdk;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.huobi.im.imsignal.ImSdkModuleConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import e7.e;
import h7.b;
import i6.d;
import i6.r;
import java.util.List;

public class HbImDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public HbgDialogWebView f69108b;

    /* renamed from: c  reason: collision with root package name */
    public String f69109c;

    /* renamed from: d  reason: collision with root package name */
    public int f69110d = -1;

    /* renamed from: e  reason: collision with root package name */
    public e f69111e;

    /* renamed from: f  reason: collision with root package name */
    public f7.a f69112f;

    /* renamed from: g  reason: collision with root package name */
    public long f69113g;

    /* renamed from: h  reason: collision with root package name */
    public String f69114h;

    public class a implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f69115b;

        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:50:0x0115 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0116  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                r7 = this;
                com.hbg.lib.imsdk.HbImDialogFragment r0 = com.hbg.lib.imsdk.HbImDialogFragment.this
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                r1 = 0
                if (r0 == 0) goto L_0x011d
                android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r9)
                float r2 = r9.getRawX()
                float r3 = r9.getRawY()
                r0.setLocation(r2, r3)
                com.hbg.lib.imsdk.HbImDialogFragment r2 = com.hbg.lib.imsdk.HbImDialogFragment.this
                com.hbg.lib.imsdk.HbgDialogWebView r2 = r2.f69108b
                float r2 = r2.getAlpha()
                r3 = 0
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 != 0) goto L_0x002e
                com.hbg.lib.imsdk.HbImDialogFragment r1 = com.hbg.lib.imsdk.HbImDialogFragment.this
                boolean r8 = r1.xh(r9, r8, r0)
                return r8
            L_0x002e:
                com.hbg.lib.imsdk.HbImDialogFragment r2 = com.hbg.lib.imsdk.HbImDialogFragment.this
                int r2 = r2.f69110d
                if (r2 >= 0) goto L_0x0037
                return r1
            L_0x0037:
                r2 = 255(0xff, float:3.57E-43)
                int r4 = r9.getAction()
                if (r4 == 0) goto L_0x008f
                r5 = 1
                if (r4 == r5) goto L_0x0068
                r5 = 2
                if (r4 == r5) goto L_0x004b
                r5 = 3
                if (r4 == r5) goto L_0x0068
                r4 = r1
                goto L_0x00b5
            L_0x004b:
                android.graphics.Bitmap r4 = r7.f69115b     // Catch:{ Exception -> 0x0062 }
                float r5 = r9.getX()     // Catch:{ Exception -> 0x0062 }
                int r5 = (int) r5     // Catch:{ Exception -> 0x0062 }
                float r6 = r9.getY()     // Catch:{ Exception -> 0x0062 }
                int r6 = (int) r6     // Catch:{ Exception -> 0x0062 }
                int r4 = r4.getPixel(r5, r6)     // Catch:{ Exception -> 0x0062 }
                int r2 = android.graphics.Color.alpha(r4)     // Catch:{ Exception -> 0x0060 }
                goto L_0x00b5
            L_0x0060:
                r5 = move-exception
                goto L_0x0064
            L_0x0062:
                r5 = move-exception
                r4 = r1
            L_0x0064:
                r5.printStackTrace()
                goto L_0x00b5
            L_0x0068:
                android.graphics.Bitmap r4 = r7.f69115b     // Catch:{ Exception -> 0x007f }
                float r5 = r9.getX()     // Catch:{ Exception -> 0x007f }
                int r5 = (int) r5     // Catch:{ Exception -> 0x007f }
                float r6 = r9.getY()     // Catch:{ Exception -> 0x007f }
                int r6 = (int) r6     // Catch:{ Exception -> 0x007f }
                int r4 = r4.getPixel(r5, r6)     // Catch:{ Exception -> 0x007f }
                int r2 = android.graphics.Color.alpha(r4)     // Catch:{ Exception -> 0x007d }
                goto L_0x0084
            L_0x007d:
                r5 = move-exception
                goto L_0x0081
            L_0x007f:
                r5 = move-exception
                r4 = r1
            L_0x0081:
                r5.printStackTrace()
            L_0x0084:
                android.graphics.Bitmap r5 = r7.f69115b     // Catch:{ Exception -> 0x008a }
                r5.recycle()     // Catch:{ Exception -> 0x008a }
                goto L_0x00b5
            L_0x008a:
                r5 = move-exception
                r5.printStackTrace()
                goto L_0x00b5
            L_0x008f:
                com.hbg.lib.imsdk.HbImDialogFragment r4 = com.hbg.lib.imsdk.HbImDialogFragment.this     // Catch:{ Exception -> 0x00b0 }
                com.hbg.lib.imsdk.HbgDialogWebView r4 = r4.f69108b     // Catch:{ Exception -> 0x00b0 }
                android.graphics.Bitmap r4 = com.hbg.lib.imsdk.HbImDialogFragment.yh(r4)     // Catch:{ Exception -> 0x00b0 }
                r7.f69115b = r4     // Catch:{ Exception -> 0x00b0 }
                float r5 = r9.getX()     // Catch:{ Exception -> 0x00b0 }
                int r5 = (int) r5     // Catch:{ Exception -> 0x00b0 }
                float r6 = r9.getY()     // Catch:{ Exception -> 0x00b0 }
                int r6 = (int) r6     // Catch:{ Exception -> 0x00b0 }
                int r4 = r4.getPixel(r5, r6)     // Catch:{ Exception -> 0x00b0 }
                int r2 = android.graphics.Color.alpha(r4)     // Catch:{ Exception -> 0x00ae }
                goto L_0x00b5
            L_0x00ae:
                r5 = move-exception
                goto L_0x00b2
            L_0x00b0:
                r5 = move-exception
                r4 = r1
            L_0x00b2:
                r5.printStackTrace()
            L_0x00b5:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "ImSdkManager--> pixel:"
                r5.append(r6)
                r5.append(r4)
                java.lang.String r4 = " event.getAction():"
                r5.append(r4)
                int r4 = r9.getAction()
                r5.append(r4)
                java.lang.String r4 = " mWebView.getAlpha():"
                r5.append(r4)
                com.hbg.lib.imsdk.HbImDialogFragment r4 = com.hbg.lib.imsdk.HbImDialogFragment.this
                com.hbg.lib.imsdk.HbgDialogWebView r4 = r4.f69108b
                float r4 = r4.getAlpha()
                r5.append(r4)
                java.lang.String r4 = " alpha:"
                r5.append(r4)
                r5.append(r2)
                java.lang.String r4 = "server alpha:"
                r5.append(r4)
                com.hbg.lib.imsdk.HbImDialogFragment r4 = com.hbg.lib.imsdk.HbImDialogFragment.this
                int r4 = r4.f69110d
                r5.append(r4)
                java.lang.String r4 = r5.toString()
                java.lang.String r5 = "HBgDialog"
                i6.d.c(r5, r4)
                com.hbg.lib.imsdk.HbImDialogFragment r4 = com.hbg.lib.imsdk.HbImDialogFragment.this
                com.hbg.lib.imsdk.HbgDialogWebView r4 = r4.f69108b
                float r4 = r4.getAlpha()
                int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
                if (r3 <= 0) goto L_0x0116
                com.hbg.lib.imsdk.HbImDialogFragment r3 = com.hbg.lib.imsdk.HbImDialogFragment.this
                int r3 = r3.f69110d
                if (r2 <= r3) goto L_0x0116
                return r1
            L_0x0116:
                com.hbg.lib.imsdk.HbImDialogFragment r1 = com.hbg.lib.imsdk.HbImDialogFragment.this
                boolean r8 = r1.xh(r9, r8, r0)
                return r8
            L_0x011d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.imsdk.HbImDialogFragment.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class b implements b.a {
        public b() {
        }

        public void a(String str, int i11) {
            if (HbImDialogFragment.this.f69111e != null) {
                HbImDialogFragment.this.f69111e.a(str, HbImDialogFragment.this.f69113g, i11);
            }
        }

        public void onShow() {
        }
    }

    public static Bitmap yh(View view) {
        if (view == null || view.getHeight() == 0 || view.getWidth() == 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        new Canvas(createBitmap).drawBitmap(drawingCache, 0.0f, 0.0f, paint);
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void addEvent(r rVar) {
        this.f69108b.setOnTouchListener(new a());
    }

    public void afterInit() {
        setCanDismissOnBackPress(false);
        setCanceledOnTouchOutside(false);
        this.f69108b.c(getActivity());
        ImSdkModuleConfig.a().b(this.f69108b);
        HbgDialogWebView hbgDialogWebView = this.f69108b;
        hbgDialogWebView.addJavascriptInterface(new h7.b(hbgDialogWebView, new b()), "hbWallet");
        HbgDialogWebView hbgDialogWebView2 = this.f69108b;
        String str = this.f69109c;
        hbgDialogWebView2.loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(hbgDialogWebView2, str);
    }

    public void checkStatusHeight(View view) {
    }

    public int getContentViewResId() {
        return R$layout.hb_im_dialog;
    }

    public int getGravity() {
        return 48;
    }

    public void initView(r rVar) {
        HbgDialogWebView hbgDialogWebView = (HbgDialogWebView) rVar.b(R$id.hb_im_dialog_webView);
        this.f69108b = hbgDialogWebView;
        hbgDialogWebView.setBackgroundColor(0);
        this.f69108b.setAlpha(0.0f);
    }

    public boolean isTransparent() {
        return true;
    }

    public void onStart() {
        super.onStart();
        setWindowDimAmount(0.0f);
        setStatusBarColorIfPossible(0);
    }

    public final boolean xh(MotionEvent motionEvent, View view, MotionEvent motionEvent2) {
        if (getActivity() == null) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent2);
        List<Fragment> B0 = getActivity().getSupportFragmentManager().B0();
        if (!B0.isEmpty()) {
            int i11 = -1;
            for (int size = B0.size() - 1; size >= 0; size--) {
                Fragment fragment = B0.get(size);
                if (fragment.isVisible() && (fragment instanceof DialogFragment)) {
                    if (!(fragment instanceof HbImDialogFragment)) {
                        if (!(i11 == -1 || fragment.getView() == null)) {
                            int[] iArr = new int[2];
                            fragment.getView().getLocationOnScreen(iArr);
                            obtain.setLocation(obtain.getX() - ((float) iArr[0]), obtain.getY() - ((float) iArr[1]));
                            d.b("ImSdkManager:" + fragment.toString() + "=======" + this.f69114h);
                            return fragment.getView().dispatchTouchEvent(obtain);
                        }
                    } else if (fragment.toString().equals(toString())) {
                        i11 = size;
                    } else if (!(i11 == -1 || fragment.getView() == null)) {
                        obtain.setLocation(motionEvent.getX(), motionEvent.getY());
                        d.b("ImSdkManager:" + fragment.toString() + "=======" + this.f69114h);
                        return fragment.getView().dispatchTouchEvent(obtain);
                    }
                }
            }
        }
        Dialog h11 = com.hbg.lib.core.util.r.h();
        if (!(h11 == null || h11.getWindow() == null)) {
            int[] iArr2 = new int[2];
            h11.getWindow().getDecorView().getLocationOnScreen(iArr2);
            obtain.setLocation(obtain.getX() - ((float) iArr2[0]), obtain.getY() - ((float) iArr2[1]));
            if (h11.dispatchTouchEvent(obtain)) {
                return true;
            }
        }
        f7.a aVar = this.f69112f;
        if (aVar == null || !aVar.viewDispatchTouch(motionEvent2)) {
            return getActivity().dispatchTouchEvent(motionEvent2);
        }
        return true;
    }
}
