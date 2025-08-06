package com.huobi.edgeengine.template.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.huobi.edgeengine.template.widget.view.EngineImageView;
import com.huobi.edgeengine.util.IdentifierUtil;
import java.util.Map;
import rj.n;
import rj.p;
import yj.e;

public class ImageWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public String f44079h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f44080i0;

    /* renamed from: j0  reason: collision with root package name */
    public int f44081j0;

    /* renamed from: k0  reason: collision with root package name */
    public String f44082k0;

    public class a extends b {
        public a(View view) {
            super(view);
        }

        public void b(View view, String str) {
            if (!TextUtils.isEmpty(str)) {
                int unused = ImageWidget.this.f44081j0 = IdentifierUtil.a(view.getContext(), str, "drawable");
                ((ImageView) view).setImageResource(ImageWidget.this.f44081j0);
            }
        }
    }

    public class b extends b {
        public b(View view) {
            super(view);
        }

        public void b(View view, String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    ((ImageView) view).setImageResource(IdentifierUtil.a(view.getContext(), str, "drawable"));
                } catch (Exception e11) {
                    Log.e("EdgeEngine.Widget", String.format("image resource not found: %s", new Object[]{str}));
                    e11.printStackTrace();
                }
            }
        }
    }

    public class c extends b {
        public c(View view) {
            super(view);
        }

        public static /* synthetic */ void d(View view, String str, String str2) {
            try {
                ((ImageView) view).setImageResource(IdentifierUtil.a(view.getContext(), str2, "drawable"));
            } catch (Exception e11) {
                Log.e("EdgeEngine.Widget", String.format("image resource not found: %s", new Object[]{str}));
                e11.printStackTrace();
            }
        }

        public void b(View view, String str) {
            if (!ImageWidget.this.y(str, new e(view, str))) {
                p g11 = ImageWidget.this.f44152d0.g();
                if (g11 == null) {
                    g11 = rj.b.j();
                }
                if (g11 != null) {
                    g11.a((ImageView) view, str, ImageWidget.this.f44081j0);
                }
            }
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44079h0 = map.get("src");
        this.f44080i0 = map.get("placeholder");
        this.f44082k0 = map.get("scaleType");
    }

    public View Q(Context context, n nVar) {
        EngineImageView engineImageView = (EngineImageView) super.Q(context, nVar);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        if ("matrix".equals(this.f44082k0)) {
            scaleType = ImageView.ScaleType.MATRIX;
        } else if (TtmlNode.CENTER.equals(this.f44082k0)) {
            scaleType = ImageView.ScaleType.CENTER;
        } else if ("fitXY".equals(this.f44082k0) || "fit_xy".equals(this.f44082k0)) {
            scaleType = ImageView.ScaleType.FIT_XY;
        } else if ("center_crop".equals(this.f44082k0)) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        } else if ("fitStart".equals(this.f44082k0)) {
            scaleType = ImageView.ScaleType.FIT_START;
        } else if ("fitEnd".equals(this.f44082k0)) {
            scaleType = ImageView.ScaleType.FIT_END;
        }
        engineImageView.setScaleType(scaleType);
        engineImageView.setRadius(t());
        y(this.f44080i0, new a(engineImageView));
        if (!y(this.f44079h0, new b(engineImageView))) {
            w(context, this.f44079h0, new c(engineImageView), nVar);
        }
        return engineImageView;
    }

    /* renamed from: Z */
    public EngineImageView q(Context context) {
        return new EngineImageView(context);
    }
}
