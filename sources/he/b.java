package he;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.module.libkt.R$color;
import com.hbg.module.libkt.R$drawable;
import com.hbg.module.libkt.R$string;
import com.hbg.module.libkt.base.ext.c;
import com.hbg.module.libkt.custom.SubSpanType;
import com.hbg.module.libkt.utils.s;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import ke.f;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f25274a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final DecimalFormat f25275b = new DecimalFormat("#,###");

    /* renamed from: c  reason: collision with root package name */
    public static final DecimalFormat f25276c = new DecimalFormat("#,###k");

    /* renamed from: d  reason: collision with root package name */
    public static final DecimalFormat f25277d = new DecimalFormat("#,###m");

    public static final String a(int i11) {
        if (i11 < 1000) {
            return String.valueOf(i11);
        }
        if (i11 < 10000) {
            return f25275b.format(Integer.valueOf(i11));
        }
        if (i11 < 1000000) {
            DecimalFormat decimalFormat = f25276c;
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            return decimalFormat.format(Integer.valueOf(i11 / 1000));
        }
        DecimalFormat decimalFormat2 = f25277d;
        decimalFormat2.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat2.format(Integer.valueOf(i11 / 1000000));
    }

    public static /* synthetic */ String d(b bVar, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return bVar.c(str, z11);
    }

    public static final String e(String str) {
        if (com.hbg.module.libkt.base.ext.b.x(str)) {
            return "0";
        }
        try {
            double parseDouble = Double.parseDouble(str);
            if (parseDouble < 1000.0d) {
                return str;
            }
            return f25274a.b(parseDouble / ((double) 1000)) + 'k';
        } catch (NumberFormatException e11) {
            e11.printStackTrace();
            return "0";
        }
    }

    public static final void f(ImageView imageView, String str) {
        com.hbg.module.libkt.base.ext.b.z(imageView, str);
    }

    public static final void g(TextView textView, String str, String str2) {
        d0 d0Var = d0.f56774a;
        Object[] objArr = new Object[1];
        if (com.hbg.module.libkt.base.ext.b.x(str2)) {
            str2 = "0";
        }
        objArr[0] = str2;
        textView.setText(String.format(str, Arrays.copyOf(objArr, 1)));
    }

    public static final void h(ImageView imageView, String str) {
        com.hbg.module.libkt.base.ext.b.B(imageView, str);
    }

    public static final void i(ImageView imageView, String str) {
        com.hbg.module.libkt.base.ext.b.D(imageView, str);
    }

    public static final void j(TextView textView, String str) {
        if (com.hbg.module.libkt.base.ext.b.x(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
    }

    public static final void k(TextView textView, String str, String str2) {
        String d11 = d(f25274a, str, false, 2, (Object) null);
        if (!com.hbg.module.libkt.base.ext.b.x(d11) && !x.b(d11, "0")) {
            str2 = d11;
        }
        textView.setText(str2);
    }

    public static final void l(TextView textView, String str) {
        textView.setText(d(f25274a, str, false, 2, (Object) null));
    }

    public static final void m(TextView textView, String str) {
        textView.setText(f25274a.c(str, true));
    }

    public static final void n(TextView textView, String str, int i11, String str2, String str3, int i12) {
        String str4;
        Context context = textView.getContext();
        if (context != null) {
            String str5 = "";
            if (i11 == 0) {
                str4 = str5;
            } else {
                str4 = "  " + context.getResources().getString(R$string.n_content_author) + "  ";
            }
            if (com.hbg.module.libkt.base.ext.b.x(str2)) {
                str2 = str5;
            } else {
                str5 = context.getResources().getString(R$string.n_reply);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + str4 + str5 + str2 + l.f34627b + str3 + "  ");
            Resources resources = textView.getContext().getResources();
            int i13 = R$color.baseColorPrimaryText;
            spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(i13)), 0, str.length(), 33);
            if (!com.hbg.module.libkt.base.ext.b.x(str4)) {
                spannableStringBuilder.setSpan(new RelativeSizeSpan(0.6666667f), str.length() + 1, (str.length() + str4.length()) - 1, 33);
                spannableStringBuilder.setSpan(new f(textView.getContext(), SubSpanType.CENTER), str.length() + 1, (str.length() + str4.length()) - 1, 33);
            }
            if (!com.hbg.module.libkt.base.ext.b.x(str2)) {
                int length = str.length() + str4.length() + str5.length();
                spannableStringBuilder.setSpan(new ForegroundColorSpan(textView.getContext().getResources().getColor(i13)), length, str2.length() + length + 1, 33);
                spannableStringBuilder.setSpan(new StyleSpan(1), length, str2.length() + length + 1, 33);
            }
            if (i12 == 1) {
                Drawable i14 = com.hbg.module.libkt.base.ext.b.i(R$drawable.ic_comment_have_image);
                if (i14 != null) {
                    i14.setBounds(0, 0, c.a(12.0f), c.a(10.0f));
                }
                spannableStringBuilder.setSpan(new s(i14), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 18);
            }
            textView.setText(spannableStringBuilder);
        }
    }

    public static final void o(ImageView imageView, String str, float f11, int i11) {
        com.hbg.module.libkt.base.ext.b.M(imageView, str, f11, i11);
    }

    public static final void p(ImageView imageView, String str, int i11) {
        com.hbg.module.libkt.base.ext.b.K(imageView, str, i11);
    }

    public final String b(double d11) {
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(d11);
    }

    public final String c(String str, boolean z11) {
        if (com.hbg.module.libkt.base.ext.b.x(str)) {
            return "0";
        }
        try {
            double parseDouble = Double.parseDouble(str);
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                if (parseDouble < 10000.0d) {
                    return str;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b(parseDouble / ((double) 10000)));
                sb2.append(z11 ? "w" : "万");
                return sb2.toString();
            } else if (parseDouble < 1000.0d) {
                return str;
            } else {
                return b(parseDouble / ((double) 1000)) + 'k';
            }
        } catch (NumberFormatException e11) {
            e11.printStackTrace();
            return "0";
        }
    }
}
