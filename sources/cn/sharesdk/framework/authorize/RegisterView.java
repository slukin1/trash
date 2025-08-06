package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.n;
import com.mob.tools.utils.ResHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.reflect.Method;

public class RegisterView extends ResizeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TitleLayout f13400a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f13401b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f13402c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f13403d;

    public RegisterView(Context context) {
        super(context);
        a(context);
    }

    private int b(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (!(context instanceof Activity) || (windowManager = ((Activity) context).getWindowManager()) == null) {
            return 0;
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public TitleLayout c() {
        return this.f13400a;
    }

    public RelativeLayout d() {
        return this.f13401b;
    }

    private void a(Context context) {
        setBackgroundColor(-1);
        setOrientation(1);
        final int b11 = b(context);
        this.f13400a = new TitleLayout(context);
        try {
            int bitmapRes = ResHelper.getBitmapRes(context, "ssdk_auth_title_back");
            if (bitmapRes > 0) {
                this.f13400a.setBackgroundResource(bitmapRes);
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
        this.f13400a.getBtnRight().setVisibility(8);
        int stringRes = ResHelper.getStringRes(getContext(), "ssdk_weibo_oauth_regiseter");
        if (stringRes > 0) {
            this.f13400a.getTvTitle().setText(stringRes);
        }
        addView(this.f13400a);
        ImageView imageView = new ImageView(context);
        int bitmapRes2 = ResHelper.getBitmapRes(context, "ssdk_logo");
        if (bitmapRes2 > 0) {
            imageView.setImageResource(bitmapRes2);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setPadding(0, 0, ResHelper.dipToPx(context, 10), 0);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        imageView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                try {
                    int stringRes = ResHelper.getStringRes(view.getContext(), "ssdk_website");
                    String str = null;
                    if (stringRes > 0) {
                        str = view.getResources().getString(stringRes);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f13400a.addView(imageView);
        this.f13401b = new RelativeLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        this.f13401b.setLayoutParams(layoutParams);
        addView(this.f13401b);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f13401b.addView(linearLayout);
        TextView textView = new TextView(context);
        this.f13403d = textView;
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, 5));
        this.f13403d.setBackgroundColor(-12929302);
        linearLayout.addView(this.f13403d);
        this.f13403d.setVisibility(8);
        WebView webView = new WebView(context);
        this.f13402c = webView;
        n.a(webView, false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        this.f13402c.setLayoutParams(layoutParams2);
        AnonymousClass2 r12 = new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i11) {
                super.onProgressChanged(webView, i11);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) RegisterView.this.f13403d.getLayoutParams();
                layoutParams.width = (b11 * i11) / 100;
                RegisterView.this.f13403d.setLayoutParams(layoutParams);
                if (i11 <= 0 || i11 >= 100) {
                    RegisterView.this.f13403d.setVisibility(8);
                } else {
                    RegisterView.this.f13403d.setVisibility(0);
                }
            }
        };
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 10 && i11 < 17) {
            try {
                Method method = this.f13402c.getClass().getMethod("removeJavascriptInterface", new Class[]{String.class});
                method.setAccessible(true);
                method.invoke(this.f13402c, new Object[]{"searchBoxJavaBridge_"});
            } catch (Throwable th3) {
                SSDKLog.b().a(th3);
            }
        }
        this.f13402c.setWebChromeClient(r12);
        linearLayout.addView(this.f13402c);
        this.f13402c.requestFocus();
    }

    public RegisterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public WebView b() {
        return this.f13402c;
    }

    public View a() {
        return this.f13400a.getBtnBack();
    }

    public void a(boolean z11) {
        this.f13400a.setVisibility(z11 ? 8 : 0);
    }
}
