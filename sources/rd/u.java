package rd;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.module.huobi.im.R$color;
import com.tencent.imsdk.common.IMLog;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class u {

    /* renamed from: h  reason: collision with root package name */
    public static volatile u f23386h;

    /* renamed from: a  reason: collision with root package name */
    public Context f23387a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<String> f23388b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<a> f23389c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public String f23390d = "((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?|(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";

    /* renamed from: e  reason: collision with root package name */
    public Pattern f23391e = Pattern.compile("((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?|(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?");

    /* renamed from: f  reason: collision with root package name */
    public Matcher f23392f;

    /* renamed from: g  reason: collision with root package name */
    public int f23393g = 33;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f23394a;

        /* renamed from: b  reason: collision with root package name */
        public int f23395b;

        public a() {
        }
    }

    public u(Context context) {
        this.f23387a = context;
    }

    public static u a(Context context) {
        if (f23386h == null) {
            f23386h = new u(context);
        }
        return f23386h;
    }

    public SpannableStringBuilder b(CharSequence charSequence, int i11) {
        this.f23388b.clear();
        this.f23389c.clear();
        if (charSequence == null) {
            charSequence = "";
        }
        this.f23392f = this.f23391e.matcher(charSequence);
        while (this.f23392f.find()) {
            a aVar = new a();
            aVar.f23394a = this.f23392f.start();
            aVar.f23395b = this.f23392f.end();
            this.f23388b.add(this.f23392f.group());
            this.f23389c.add(aVar);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            if (this.f23388b.size() <= 0 || this.f23389c.size() <= 0) {
                spannableStringBuilder.append(charSequence);
                return spannableStringBuilder;
            }
            if (this.f23388b.size() == 1) {
                spannableStringBuilder.append(charSequence.toString().substring(0, this.f23389c.get(0).f23394a));
                String str = this.f23388b.get(0);
                t tVar = new t(this.f23387a, str, i11);
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append(str, new UnderlineSpan(), this.f23393g);
                int length2 = spannableStringBuilder.length();
                if (length >= 0 && length2 > 0 && length2 > length) {
                    spannableStringBuilder.setSpan(tVar, length, length2, this.f23393g);
                }
                spannableStringBuilder.append(charSequence.toString().substring(this.f23389c.get(0).f23395b));
            } else {
                for (int i12 = 0; i12 < this.f23388b.size(); i12++) {
                    t tVar2 = new t(this.f23387a, this.f23388b.get(i12), i11);
                    if (i12 == 0) {
                        spannableStringBuilder.append(charSequence.toString().substring(0, this.f23389c.get(0).f23394a));
                    }
                    if (i12 == this.f23388b.size() - 1) {
                        int length3 = spannableStringBuilder.length();
                        spannableStringBuilder.append(this.f23388b.get(i12), new UnderlineSpan(), this.f23393g);
                        int length4 = spannableStringBuilder.length();
                        if (length3 >= 0 && length4 > 0 && length4 > length3) {
                            spannableStringBuilder.setSpan(tVar2, length3, length4, this.f23393g);
                        }
                        spannableStringBuilder.append(charSequence.toString().substring(this.f23389c.get(i12).f23395b));
                    }
                    if (i12 != this.f23388b.size() - 1) {
                        int length5 = spannableStringBuilder.length();
                        spannableStringBuilder.append(this.f23388b.get(i12), new UnderlineSpan(), this.f23393g);
                        int length6 = spannableStringBuilder.length();
                        if (length5 >= 0 && length6 > 0 && length6 > length5) {
                            spannableStringBuilder.setSpan(tVar2, length5, length6, this.f23393g);
                        }
                        spannableStringBuilder.append(charSequence.toString().substring(this.f23389c.get(i12).f23395b, this.f23389c.get(i12 + 1).f23394a));
                    }
                }
            }
            return spannableStringBuilder;
        } catch (Exception e11) {
            IMLog.e("UrlSpanUtils", e11.getMessage());
        }
    }

    public void c(TextView textView) {
        textView.setText(b(textView.getText(), ContextCompat.getColor(this.f23387a, R$color.color_0066ED)));
    }

    public void d(TextView textView, int i11) {
        textView.setText(b(textView.getText(), i11));
    }

    public void e(TextView textView, int i11, int i12) {
        SpannableStringBuilder b11 = b(textView.getText(), i12);
        UnderlineSpan[] underlineSpanArr = (UnderlineSpan[]) b11.getSpans(0, i11, UnderlineSpan.class);
        t[] tVarArr = (t[]) b11.getSpans(0, i11, t.class);
        for (UnderlineSpan removeSpan : underlineSpanArr) {
            b11.removeSpan(removeSpan);
        }
        for (t removeSpan2 : tVarArr) {
            b11.removeSpan(removeSpan2);
        }
        textView.setText(b11);
    }
}
