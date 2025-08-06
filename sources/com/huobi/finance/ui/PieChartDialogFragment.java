package com.huobi.finance.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.bean.ContractDataTotal;
import com.huobi.finance.bean.LinearSwapDataTotal;
import com.huobi.finance.bean.OptionDataTotal;
import com.huobi.finance.bean.SwapDataTotal;
import com.huobi.utils.ImageUtils;
import com.huobi.view.chart.PieChart;
import com.huobi.view.chart.animation.Easing;
import com.huobi.view.chart.components.Legend;
import com.huobi.view.chart.data.Entry;
import com.huobi.view.chart.data.PieData;
import com.huobi.view.chart.data.PieDataSet;
import com.huobi.view.chart.data.PieEntry;
import com.huobi.view.chart.highlight.Highlight;
import com.huobi.view.chart.listener.OnChartValueSelectedListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.rtmp.TXLivePushConfig;
import i6.d;
import i6.m;
import i6.r;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PieChartDialogFragment extends BaseDialogFragment implements OnChartValueSelectedListener, EasyPermissions.PermissionCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f46729b;

    /* renamed from: c  reason: collision with root package name */
    public PieChart f46730c;

    /* renamed from: d  reason: collision with root package name */
    public View f46731d;

    /* renamed from: e  reason: collision with root package name */
    public View f46732e;

    /* renamed from: f  reason: collision with root package name */
    public v9.a<PieEntry> f46733f;

    /* renamed from: g  reason: collision with root package name */
    public List<PieEntry> f46734g;

    /* renamed from: h  reason: collision with root package name */
    public PieDataSet f46735h;

    /* renamed from: i  reason: collision with root package name */
    public PieData f46736i;

    /* renamed from: j  reason: collision with root package name */
    public String f46737j;

    /* renamed from: k  reason: collision with root package name */
    public int f46738k = PixelUtils.a(10.0f);

    /* renamed from: l  reason: collision with root package name */
    public View f46739l;

    /* renamed from: m  reason: collision with root package name */
    public View f46740m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f46741n;

    /* renamed from: o  reason: collision with root package name */
    public BaseAssetTotal f46742o;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            PieChartDialogFragment.this.f46741n.setVisibility(0);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public float f46744b;

        /* renamed from: c  reason: collision with root package name */
        public float f46745c;

        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() instanceof Float) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f46744b = floatValue;
                this.f46745c = (floatValue * 0.2f) + 0.8f;
                PieChartDialogFragment.this.f46739l.setAlpha(this.f46744b);
                PieChartDialogFragment.this.f46739l.setScaleX(this.f46745c);
                PieChartDialogFragment.this.f46739l.setScaleY(this.f46745c);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            PieChartDialogFragment.this.yh();
            BaseModuleConfig.a().b("4464", (Map<String, Object>) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public PieChartDialogFragment() {
        ArrayList arrayList = new ArrayList();
        this.f46734g = arrayList;
        PieDataSet pieDataSet = new PieDataSet(arrayList, "");
        this.f46735h = pieDataSet;
        this.f46736i = new PieData(pieDataSet);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) PixelUtils.a(10.0f));
        gradientDrawable.setColor(ContextCompat.getColor(getActivity(), R$color.baseColorContentBackground));
        this.f46740m.setBackground(gradientDrawable);
        this.f46731d.setOnClickListener(new d7(this));
        this.f46733f = new v9.a<>(this.f46734g);
        if (this.f46734g.size() <= 1) {
            this.f46729b.setLayoutManager(new LinearLayoutManager(getActivity()));
        } else {
            this.f46729b.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            RecyclerView recyclerView = this.f46729b;
            Context context = getContext();
            int i11 = this.f46738k;
            recyclerView.addItemDecoration(new ea.a(context, i11, i11));
        }
        this.f46729b.setAdapter(this.f46733f);
        this.f46730c.setUsePercentValues(true);
        this.f46730c.getDescription().setEnabled(false);
        this.f46730c.setExtraOffsets(5.0f, 10.0f, 5.0f, 5.0f);
        this.f46730c.setDragDecelerationFrictionCoef(0.95f);
        this.f46730c.setCenterText(this.f46737j);
        this.f46730c.setCenterTextColor(ContextCompat.getColor(getActivity(), R$color.baseColorSecondaryText));
        this.f46730c.setCenterTextSizePixels(getResources().getDimension(R$dimen.global_text_size_14));
        this.f46730c.setDrawHoleEnabled(true);
        this.f46730c.setHoleColor(0);
        this.f46730c.setTransparentCircleColor(0);
        this.f46730c.setHoleRadius(70.0f);
        this.f46730c.setDrawCenterText(true);
        this.f46730c.setRotationAngle(270.0f);
        this.f46730c.setRotationEnabled(false);
        this.f46730c.setHighlightPerTapEnabled(true);
        this.f46730c.setOnChartValueSelectedListener(this);
        this.f46730c.animateY(TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE, Easing.EaseInOutQuad);
        this.f46730c.getLegend().setForm(Legend.LegendForm.NONE);
        this.f46735h.setDrawIcons(false);
        this.f46735h.setSliceSpace(3.0f);
        this.f46735h.setSelectionShift(5.0f);
        this.f46736i.setDrawValues(false);
        this.f46730c.setData(this.f46736i);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new b());
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.start();
        this.f46741n.setOnClickListener(new c());
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.fragment_pie_chart;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f46729b = (RecyclerView) rVar.b(R$id.recycler_view);
        this.f46730c = (PieChart) rVar.b(R$id.pie_chart);
        int i11 = R$id.chart_root;
        this.f46739l = rVar.b(i11);
        this.f46731d = rVar.b(R$id.dialog_close_btn);
        this.f46740m = rVar.b(R$id.dialog_bg);
        this.f46741n = (TextView) rVar.b(R$id.share);
        this.f46737j = getResources().getString(R$string.n_balance_asset_allocation);
        this.f46732e = rVar.b(R$id.pine_root);
        setStandardWidth(rVar.b(i11));
        this.f46730c.postDelayed(new a(), 800);
    }

    public boolean isTransparent() {
        return false;
    }

    public void onNothingSelected() {
        d.c("debug_pie", "nothing");
        this.f46730c.setCenterText(this.f46737j);
        List<PieEntry> list = this.f46734g;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f46734g.get(i11).setSelected(false);
            }
            v9.a<PieEntry> aVar = this.f46733f;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    public void onPermissionsDenied(int i11, List<String> list) {
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        yh();
    }

    public void onPieItemClick(int i11, PieEntry pieEntry) {
        PieChart pieChart;
        PieChart pieChart2;
        List<PieEntry> list = this.f46734g;
        if (list != null) {
            int size = list.size();
            boolean z11 = false;
            for (int i12 = 0; i12 < size; i12++) {
                if (i12 == i11) {
                    boolean isSelected = this.f46734g.get(i12).isSelected();
                    this.f46734g.get(i11).setSelected(!isSelected);
                    PieChart pieChart3 = this.f46730c;
                    if (pieChart3 != null && !isSelected) {
                        pieChart3.highlightValue((float) i11, this.f46734g.get(i11).getY(), 0, false);
                        if (!isSelected && (pieChart2 = this.f46730c) != null) {
                            pieChart2.setCenterText(wh(this.f46734g.get(i11)));
                        }
                        z11 = true;
                    }
                } else {
                    this.f46734g.get(i12).setSelected(false);
                }
            }
            if (!z11 && (pieChart = this.f46730c) != null) {
                pieChart.setCenterText(this.f46737j);
                this.f46730c.highlightValues((Highlight[]) null);
            }
            v9.a<PieEntry> aVar = this.f46733f;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    public void onValueSelected(Entry entry, Highlight highlight) {
        PieChart pieChart;
        if ((entry instanceof PieEntry) && highlight != null && this.f46734g != null) {
            d.c("debug_pie", "Value: " + entry.getY() + ", index: " + highlight.getX());
            int size = this.f46734g.size();
            int x11 = (int) highlight.getX();
            for (int i11 = 0; i11 < size; i11++) {
                if (i11 == x11) {
                    boolean isSelected = this.f46734g.get(i11).isSelected();
                    this.f46734g.get(x11).setSelected(!isSelected);
                    if (!isSelected && (pieChart = this.f46730c) != null) {
                        pieChart.setCenterText(wh((PieEntry) entry));
                    }
                } else {
                    this.f46734g.get(i11).setSelected(false);
                }
            }
            v9.a<PieEntry> aVar = this.f46733f;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    public final CharSequence wh(PieEntry pieEntry) {
        if (pieEntry == null) {
            return this.f46737j;
        }
        String title = pieEntry.getTitle() == null ? "" : pieEntry.getTitle();
        String str = m.q(new BigDecimal(String.valueOf(pieEntry.getValue())).multiply(new BigDecimal("100")), 2) + "%";
        int color = ContextCompat.getColor(getActivity(), R$color.baseColorPrimaryText);
        int intValue = pieEntry.getColor() == null ? color : pieEntry.getColor().intValue();
        SpannableString spannableString = new SpannableString(title + "\n" + str);
        spannableString.setSpan(new AbsoluteSizeSpan(PixelUtils.a(14.0f)), 0, title.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(intValue), 0, title.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(PixelUtils.a(24.0f)), title.length() + 1, title.length() + str.length() + 1, 33);
        spannableString.setSpan(new ForegroundColorSpan(color), title.length() + 1, title.length() + str.length() + 1, 33);
        return spannableString;
    }

    public void xh(BaseAssetTotal baseAssetTotal, List<PieEntry> list, List<Integer> list2) {
        if (list != null) {
            this.f46742o = baseAssetTotal;
            this.f46734g.clear();
            this.f46734g.addAll(list);
            if (this.f46729b != null) {
                if (this.f46734g.size() <= 1) {
                    this.f46729b.setLayoutManager(new LinearLayoutManager(getActivity()));
                } else {
                    this.f46729b.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    RecyclerView recyclerView = this.f46729b;
                    Context context = getContext();
                    int i11 = this.f46738k;
                    recyclerView.addItemDecoration(new ea.a(context, i11, i11));
                }
            }
            v9.a<PieEntry> aVar = this.f46733f;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            this.f46735h.setValues(this.f46734g);
            if (list2 != null) {
                this.f46735h.setColors(list2);
            }
            PieChart pieChart = this.f46730c;
            if (pieChart != null) {
                pieChart.highlightValues((Highlight[]) null);
                this.f46730c.setCenterText(this.f46737j);
                this.f46730c.notifyDataSetChanged();
            }
        }
    }

    public final void yh() {
        String str;
        Bitmap A = AssetModuleConfig.a().A(this.f46732e);
        int i11 = 0;
        String str2 = null;
        try {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
            File f11 = FileUtil.f(compressFormat.name(), false);
            ImageUtils.h(A, compressFormat, f11);
            if (Build.VERSION.SDK_INT >= 24) {
                str = FileProvider.getUriForFile(getContext(), BaseModuleConfig.a().D() + ".fileprovider", f11).toString();
            } else {
                str = Uri.fromFile(f11).toString();
            }
            if (A != null) {
                A.recycle();
            }
        } catch (Exception e11) {
            d.g(e11);
            if (A != null) {
                A.recycle();
            }
            str = null;
        } catch (Throwable th2) {
            if (A != null) {
                A.recycle();
            }
            throw th2;
        }
        BaseAssetTotal baseAssetTotal = this.f46742o;
        if (baseAssetTotal instanceof ContractDataTotal) {
            str2 = getString(R$string.n_balance_pie_chart_title_contract);
            i11 = R$drawable.asset_share_pic_futures;
        } else if (baseAssetTotal instanceof SwapDataTotal) {
            str2 = getString(R$string.n_balance_pie_chart_title_swap);
            i11 = R$drawable.asset_share_pic_futures;
        } else if (baseAssetTotal instanceof OptionDataTotal) {
            str2 = getString(R$string.n_balance_pie_chart_title_option);
            i11 = R$drawable.asset_share_pic_futures;
        } else if (baseAssetTotal instanceof LinearSwapDataTotal) {
            str2 = getString(R$string.n_balance_pie_chart_title_linear_swap_usdt);
            i11 = R$drawable.asset_share_pic_futures;
        }
        AssetModuleConfig.a().K0(getActivity(), str, str2, i11);
        dismiss();
    }
}
