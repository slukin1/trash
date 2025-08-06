package wn;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.input.ClearEditText;
import com.huobi.login.holder.EmailAssociationAdapter;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.v2.ui.CountryAreaSelectActivityV2;
import com.huobi.view.indexlist.EntityWrapper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import f6.c;
import i6.m;
import i6.r;
import pro.huobi.R;
import q6.d;
import sn.w;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public final a f76772a;

    /* renamed from: b  reason: collision with root package name */
    public View f76773b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f76774c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f76775d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f76776e;

    /* renamed from: f  reason: collision with root package name */
    public View f76777f;

    /* renamed from: g  reason: collision with root package name */
    public ClearEditText f76778g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f76779h;

    /* renamed from: i  reason: collision with root package name */
    public View f76780i;

    /* renamed from: j  reason: collision with root package name */
    public ClearEditText f76781j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f76782k;

    /* renamed from: l  reason: collision with root package name */
    public String f76783l;

    /* renamed from: m  reason: collision with root package name */
    public String f76784m;

    /* renamed from: n  reason: collision with root package name */
    public PopupWindow f76785n;

    /* renamed from: o  reason: collision with root package name */
    public RecyclerView f76786o;

    /* renamed from: p  reason: collision with root package name */
    public EmailAssociationAdapter f76787p;

    /* renamed from: q  reason: collision with root package name */
    public CharSequence f76788q;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence f76789r;

    /* renamed from: s  reason: collision with root package name */
    public CharSequence f76790s;

    /* renamed from: t  reason: collision with root package name */
    public CharSequence f76791t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f76792u = false;

    /* renamed from: v  reason: collision with root package name */
    public final InputFilter[] f76793v = new InputFilter[2];

    public interface a {
        boolean I0();

        boolean a();

        boolean b();

        BaseActivity getActivity();
    }

    public p(a aVar) {
        this.f76772a = aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(View view, boolean z11) {
        this.f76781j.onFocusChange(view, z11);
        this.f76780i.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(View view, CharSequence charSequence, int i11, int i12, int i13) {
        if (!TextUtils.isEmpty(charSequence)) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
        if (charSequence.length() > 0) {
            ClearEditText clearEditText = this.f76781j;
            clearEditText.setTypeface(ResourcesCompat.h(clearEditText.getContext(), R.font.roboto_medium));
        } else {
            ClearEditText clearEditText2 = this.f76781j;
            clearEditText2.setTypeface(ResourcesCompat.h(clearEditText2.getContext(), R.font.roboto_regular));
        }
        if (!TextUtils.isEmpty(charSequence) || !TextUtils.equals(this.f76791t, charSequence) || this.f76782k.getVisibility() != 0) {
            this.f76780i.setBackgroundResource(R.drawable.login_input_bg);
            this.f76782k.setVisibility(8);
        } else {
            this.f76782k.setVisibility(0);
            this.f76780i.setBackgroundResource(R.drawable.login_input_error_bg);
        }
        this.f76791t = charSequence;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void C(ImageView imageView, View view) {
        if (this.f76792u) {
            imageView.setImageResource(R.drawable.icon_eye_close);
            this.f76792u = false;
            this.f76781j.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ClearEditText clearEditText = this.f76781j;
            clearEditText.setSelection(clearEditText.getText().toString().length());
        } else {
            imageView.setImageResource(R.drawable.icon_eye_open);
            this.f76792u = true;
            this.f76781j.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ClearEditText clearEditText2 = this.f76781j;
            clearEditText2.setSelection(clearEditText2.getText().toString().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(CountryListData countryListData) {
        this.f76783l = countryListData.a();
        this.f76784m = String.valueOf(countryListData.c());
        this.f76776e.setText(this.f76783l.replace("00", "+"));
        G(this.f76784m);
    }

    public static /* synthetic */ CharSequence v(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
        while (i11 < i12) {
            if (Character.isWhitespace(charSequence.charAt(i11))) {
                return charSequence.toString().replaceAll(" ", "");
            }
            i11++;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(String str) {
        this.f76778g.setText(str);
        this.f76778g.setSelection(str.length());
        this.f76785n.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(Activity activity, CharSequence charSequence, int i11, int i12, int i13) {
        if (this.f76772a.b()) {
            this.f76789r = charSequence;
            PopupWindow popupWindow = this.f76785n;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.f76785n.dismiss();
            }
        } else if (this.f76772a.I0()) {
            this.f76790s = charSequence;
            PopupWindow popupWindow2 = this.f76785n;
            if (popupWindow2 != null && popupWindow2.isShowing()) {
                this.f76785n.dismiss();
            }
        } else {
            this.f76788q = charSequence;
            if (activity.hasWindowFocus()) {
                if (this.f76785n == null) {
                    View inflate = LayoutInflater.from(activity).inflate(R.layout.register_email_association, (ViewGroup) null);
                    PopupWindow popupWindow3 = new PopupWindow(inflate);
                    this.f76785n = popupWindow3;
                    popupWindow3.setWidth(-1);
                    this.f76785n.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.dimen_160));
                    this.f76786o = (RecyclerView) inflate.findViewById(R.id.recyclerView);
                    EmailAssociationAdapter emailAssociationAdapter = new EmailAssociationAdapter();
                    this.f76787p = emailAssociationAdapter;
                    emailAssociationAdapter.h(new n(this));
                    this.f76786o.setLayoutManager(new LinearLayoutManager(activity));
                    this.f76786o.setAdapter(this.f76787p);
                }
                this.f76787p.g(charSequence.toString());
                if (charSequence.length() <= 0 || this.f76787p.getItemCount() <= 0) {
                    this.f76785n.dismiss();
                } else {
                    if (!this.f76785n.isShowing()) {
                        int[] iArr = new int[2];
                        this.f76778g.getLocationInWindow(iArr);
                        PopupWindow popupWindow4 = this.f76785n;
                        ClearEditText clearEditText = this.f76778g;
                        popupWindow4.showAtLocation(clearEditText, 48, 0, iArr[1] + clearEditText.getHeight() + activity.getResources().getDimensionPixelSize(R.dimen.dimen_8));
                    }
                    this.f76785n.update(-1, activity.getResources().getDimensionPixelSize(R.dimen.dimen_40) * Math.min(this.f76787p.getItemCount(), 3));
                    this.f76787p.notifyDataSetChanged();
                }
            }
        }
        if (charSequence.length() > 0) {
            this.f76778g.setTypeface(ResourcesCompat.h(activity, R.font.roboto_medium));
        } else {
            this.f76778g.setTypeface(ResourcesCompat.h(activity, R.font.roboto_regular));
        }
        this.f76779h.setVisibility(8);
        this.f76773b.setBackgroundResource(R.drawable.login_input_bg);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(View view, boolean z11) {
        PopupWindow popupWindow;
        this.f76778g.onFocusChange(view, z11);
        this.f76773b.setSelected(z11);
        if (!z11 && (popupWindow = this.f76785n) != null && popupWindow.isShowing()) {
            this.f76785n.dismiss();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void z(View view) {
        Intent intent = new Intent(this.f76772a.getActivity(), CountryAreaSelectActivityV2.class);
        intent.putExtra("choose_type", "choose_type_code");
        intent.putExtra("SHOW_COUNTRY_ICON", true);
        intent.putExtra("SHOW_ALL_COUNTRY", true);
        this.f76772a.getActivity().startActivityForResult(intent, 1001);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void E(int i11, int i12, Intent intent) {
        if (i11 == 1001 && intent != null) {
            this.f76783l = intent.getStringExtra("phone_area_code");
            String stringExtra = intent.getStringExtra("country_area_code");
            this.f76784m = stringExtra;
            if (!TextUtils.isEmpty(stringExtra)) {
                G(this.f76784m);
            }
            String str = this.f76783l;
            if (str != null) {
                this.f76776e.setText(str.replace("00", "+"));
            }
        }
    }

    public boolean F() {
        PopupWindow popupWindow = this.f76785n;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return false;
        }
        this.f76785n.dismiss();
        return true;
    }

    public final void G(String str) {
        c.a().l(this.f76772a.getActivity(), w.e(str), this.f76775d, NightHelper.e().g() ? R.drawable.flag_default_night : R.drawable.flag_default);
    }

    public void H(String str) {
        this.f76793v[1] = new InputFilter.LengthFilter(this.f76772a.b() ? 15 : EntityWrapper.TYPE_TITLE);
        this.f76778g.setFilters(this.f76793v);
        if (this.f76772a.b()) {
            this.f76774c.setVisibility(0);
            this.f76777f.setVisibility(0);
            this.f76778g.setText(this.f76789r);
            this.f76778g.setHint(p(R.string.n_login_phone_input_placeholder));
            this.f76778g.setInputType(3);
            if (TextUtils.isEmpty(this.f76783l) && TextUtils.isEmpty(this.f76784m)) {
                this.f76783l = c0.c(str);
                this.f76784m = c0.d(str);
            }
            if (TextUtils.isEmpty(this.f76783l) || TextUtils.isEmpty(this.f76784m)) {
                w.j().i(this.f76772a.getActivity()).subscribe(d.c(this.f76772a.getActivity(), new o(this)));
            } else {
                this.f76776e.setText(this.f76783l.replace("00", "+"));
                G(this.f76784m);
            }
        } else if (this.f76772a.I0()) {
            this.f76774c.setVisibility(8);
            this.f76777f.setVisibility(8);
            this.f76778g.setText(this.f76790s);
            this.f76778g.setHint(p(R.string.n_login_login_sub_account_input_hint));
            this.f76778g.setInputType(33);
        } else {
            this.f76774c.setVisibility(8);
            this.f76777f.setVisibility(8);
            this.f76778g.setText(this.f76788q);
            this.f76778g.setHint(p(R.string.n_login_email_input_placeholder));
            this.f76778g.setInputType(33);
        }
        if (this.f76778g.getText() != null && !TextUtils.isEmpty(j())) {
            this.f76778g.setSelection(j().length());
        }
    }

    public void I() {
        this.f76780i.setBackgroundResource(R.drawable.login_input_bg);
        this.f76782k.setVisibility(8);
    }

    public String j() {
        return this.f76778g.getText().toString();
    }

    public String k() {
        return this.f76783l;
    }

    public String l() {
        return this.f76784m;
    }

    public CharSequence m() {
        return this.f76788q;
    }

    public String n() {
        return this.f76781j.getText().toString();
    }

    public CharSequence o() {
        return this.f76789r;
    }

    public final String p(int i11) {
        return this.f76772a.getActivity().getString(i11);
    }

    public void q(Activity activity, r rVar) {
        this.f76773b = rVar.b(R.id.accountLayout);
        this.f76774c = (ViewGroup) rVar.b(R.id.llyt_select_country_code);
        this.f76776e = (TextView) rVar.b(R.id.tv_login_country_code);
        this.f76775d = (ImageView) rVar.b(R.id.ivCountryIcon);
        this.f76777f = rVar.b(R.id.space_divider);
        this.f76778g = (ClearEditText) rVar.b(R.id.login_account_edit);
        this.f76779h = (TextView) rVar.b(R.id.tv_account_error_tip);
        g gVar = g.f61439b;
        InputFilter[] inputFilterArr = this.f76793v;
        inputFilterArr[0] = gVar;
        inputFilterArr[1] = new InputFilter.LengthFilter(EntityWrapper.TYPE_TITLE);
        this.f76778g.setFilters(this.f76793v);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f76778g.setImportantForAutofill(2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f76778g.setOnTextChangedListener(new l(this, activity));
        this.f76778g.setOnFocusChangeListener(new j(this));
        this.f76774c.setOnClickListener(new h(this));
    }

    public void r(r rVar) {
        this.f76780i = rVar.b(R.id.pswLayout);
        View b11 = rVar.b(R.id.divider);
        ImageView imageView = (ImageView) rVar.b(R.id.login_psw_img);
        this.f76781j = (ClearEditText) rVar.b(R.id.login_psw_edit);
        this.f76782k = (TextView) rVar.b(R.id.tv_pwd_error_tip);
        ViewUtil.d(this.f76781j);
        ClearEditText clearEditText = this.f76781j;
        clearEditText.setTypeface(ResourcesCompat.h(clearEditText.getContext(), R.font.roboto_medium));
        this.f76781j.setFocusableInTouchMode(true);
        this.f76781j.setFocusable(true);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f76781j.setImportantForAutofill(2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f76781j.setOnFocusChangeListener(new k(this));
        this.f76781j.setOnTextChangedListener(new m(this, b11));
        imageView.setOnClickListener(new i(this, imageView));
    }

    public boolean s() {
        String str;
        String str2;
        String str3;
        boolean z11 = true;
        if (this.f76772a.b()) {
            if (!TextUtils.isEmpty(this.f76789r)) {
                if (StringUtils.o(this.f76789r.toString()) || (m.Y(this.f76789r.toString()) && this.f76789r.toString().length() >= 5)) {
                    return true;
                }
                z11 = false;
            }
            this.f76773b.setBackgroundResource(R.drawable.login_input_error_bg);
            TextView textView = this.f76779h;
            if (z11) {
                str3 = p(R.string.n_login_phone_input_placeholder);
            } else {
                str3 = p(R.string.n_login_phone_error_hint);
            }
            textView.setText(str3);
            this.f76779h.setVisibility(0);
            return false;
        } else if (this.f76772a.I0()) {
            if (!TextUtils.isEmpty(this.f76790s)) {
                int length = this.f76790s.toString().length();
                if (length >= 5 && length <= 19 && !m.Y(this.f76790s.subSequence(0, 1).toString())) {
                    return true;
                }
                z11 = false;
            }
            this.f76773b.setBackgroundResource(R.drawable.login_input_error_bg);
            TextView textView2 = this.f76779h;
            if (z11) {
                str2 = p(R.string.n_login_login_sub_account_input_hint);
            } else {
                str2 = p(R.string.n_login_sub_account_error_hint);
            }
            textView2.setText(str2);
            this.f76779h.setVisibility(0);
            return false;
        } else {
            if (this.f76772a.a()) {
                if (!TextUtils.isEmpty(this.f76788q)) {
                    if (!StringUtils.o(this.f76788q.toString()) && (!m.Y(this.f76788q.toString()) || this.f76788q.toString().length() < 5)) {
                        z11 = false;
                    }
                }
                this.f76773b.setBackgroundResource(R.drawable.login_input_error_bg);
                TextView textView3 = this.f76779h;
                if (z11) {
                    str = p(R.string.n_login_email_input_placeholder);
                } else {
                    str = p(R.string.n_zdcchat_right_email);
                }
                textView3.setText(str);
                this.f76779h.setVisibility(0);
                return false;
            }
            return true;
        }
    }

    public boolean t() {
        boolean z11 = !TextUtils.isEmpty(this.f76791t);
        if (!z11) {
            this.f76780i.setBackgroundResource(R.drawable.login_input_error_bg);
            this.f76782k.setVisibility(0);
        }
        return z11;
    }

    public void u(String str) {
        if (this.f76772a.b()) {
            this.f76789r = str;
        } else if (this.f76772a.I0()) {
            this.f76790s = str;
        } else {
            this.f76788q = str;
        }
    }
}
