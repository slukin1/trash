package com.huobi.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.w;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class AssetShareHelper {
    private static final String CLASSNAME_SHAREMANAGER = "com.huobi.sharev2.manager.ShareManager";
    private static final String METHODNAME_GETINSTANCE = "getInstance";
    private static final String METHODNAME_NEWSHAREWITHIMAGES = "newShareWithImages";

    public interface a {
        int a();

        int b();

        int c();
    }

    public static View loadNewView(Context context, String str, a aVar, int i11) {
        int i12;
        String str2;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_new_share, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R$id.tv_time)).setText(DateTimeUtils.i(System.currentTimeMillis(), "MM/dd/yyyy HH:mm", (Locale) null));
        TextView textView = (TextView) inflate.findViewById(R$id.tv_yield);
        char decimalSeparator = DecimalFormatSymbols.getInstance().getDecimalSeparator();
        if (!TextUtils.isEmpty(str)) {
            double doubleValue = Double.valueOf(str).doubleValue() * 100.0d;
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            String format = decimalFormat.format(doubleValue);
            i12 = 1;
            if (doubleValue > 0.0d) {
                str2 = "+" + format + "%";
            } else if (doubleValue < 0.0d) {
                str2 = format + "%";
            } else {
                i12 = 0;
                str2 = format + "%";
            }
            w.n(textView, str);
        } else {
            w.n(textView, "0");
            i12 = 0;
            str2 = "0" + decimalSeparator + "00%";
        }
        int indexOf = str2.indexOf(decimalSeparator);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        try {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(1.5f), i12, indexOf, 18);
        } catch (IndexOutOfBoundsException e11) {
            e11.printStackTrace();
        }
        textView.setText(spannableStringBuilder);
        ((TextView) inflate.findViewById(R$id.tv_tips)).setText(context.getString(aVar.c()));
        ((ImageView) inflate.findViewById(R$id.img_share)).setImageResource(aVar.b());
        return inflate;
    }

    public static View loadView(Context context, String str, a aVar) {
        String str2;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_share, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R$id.tv_time)).setText(DateTimeUtils.i(System.currentTimeMillis(), "MM/dd/yyyy HH:mm", (Locale) null));
        ((ImageView) inflate.findViewById(R$id.img_share)).setImageResource(aVar.b());
        TextView textView = (TextView) inflate.findViewById(R$id.tv_yield);
        if (!TextUtils.isEmpty(str)) {
            double doubleValue = Double.valueOf(str).doubleValue() * 100.0d;
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            String format = decimalFormat.format(doubleValue);
            if (doubleValue > 0.0d) {
                str2 = "+" + format + "%";
            } else if (doubleValue < 0.0d) {
                str2 = format + "%";
            } else {
                str2 = format + "%";
            }
            w.n(textView, str);
        } else {
            w.n(textView, "0");
            str2 = "0.00%";
        }
        textView.setText(str2);
        ((TextView) inflate.findViewById(R$id.tv_title)).setText(context.getString(aVar.c()));
        return inflate;
    }

    public static void newShareWithImages(ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str) {
        BaseModuleConfig.a().newShareWithImages(arrayList, z11, z12, str);
    }

    public static void share(Context context, View view) {
        Bitmap b11 = ImageUtil.b(context, view);
        ArrayList arrayList = new ArrayList();
        if (b11 != null) {
            arrayList.add(b11);
        }
        newShareWithImages(arrayList, true, false, "asset");
    }

    public static void newShareWithImages(Bitmap bitmap, String str, String str2) {
        BaseModuleConfig.a().newShareWithImages(bitmap, str, str2);
    }
}
