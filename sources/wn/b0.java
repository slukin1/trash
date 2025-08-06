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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.module.huobi.im.view.AvatarView;
import com.huobi.account.entity.MultipleAccountData;
import com.huobi.login.holder.EmailAssociationAdapter;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.v2.ui.CountryAreaSelectActivityV2;
import com.huobi.login.v3.ui.UserLoginActivityV4;
import com.huobi.view.indexlist.EntityWrapper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import f6.c;
import i6.m;
import i6.r;
import java.util.Iterator;
import java.util.List;
import pro.huobi.R;
import sn.w;
import tg.g;

public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final a f76664a;

    /* renamed from: b  reason: collision with root package name */
    public View f76665b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f76666c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f76667d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f76668e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f76669f;

    /* renamed from: g  reason: collision with root package name */
    public ClearEditText f76670g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f76671h;

    /* renamed from: i  reason: collision with root package name */
    public View f76672i;

    /* renamed from: j  reason: collision with root package name */
    public ClearEditText f76673j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f76674k;

    /* renamed from: l  reason: collision with root package name */
    public String f76675l;

    /* renamed from: m  reason: collision with root package name */
    public String f76676m;

    /* renamed from: n  reason: collision with root package name */
    public PopupWindow f76677n;

    /* renamed from: o  reason: collision with root package name */
    public PopupWindow f76678o;

    /* renamed from: p  reason: collision with root package name */
    public RecyclerView f76679p;

    /* renamed from: q  reason: collision with root package name */
    public EmailAssociationAdapter f76680q;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence f76681r;

    /* renamed from: s  reason: collision with root package name */
    public CharSequence f76682s;

    /* renamed from: t  reason: collision with root package name */
    public CharSequence f76683t;

    /* renamed from: u  reason: collision with root package name */
    public CharSequence f76684u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f76685v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f76686w = false;

    /* renamed from: x  reason: collision with root package name */
    public final InputFilter[] f76687x = new InputFilter[2];

    public interface a {
        boolean I0();

        boolean a();

        boolean b();

        void c(String str);

        BaseActivity getActivity();
    }

    public b0(a aVar) {
        this.f76664a = aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(Activity activity, CharSequence charSequence, int i11, int i12, int i13) {
        if (TextUtils.isEmpty(charSequence.toString())) {
            this.f76670g.setTextSize(14.0f);
        } else {
            this.f76670g.setTextSize(16.0f);
        }
        this.f76664a.c(charSequence.toString());
        if (this.f76664a.b()) {
            this.f76682s = charSequence;
            PopupWindow popupWindow = this.f76678o;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.f76678o.dismiss();
            }
        } else if (this.f76664a.I0()) {
            this.f76683t = charSequence;
            PopupWindow popupWindow2 = this.f76678o;
            if (popupWindow2 != null && popupWindow2.isShowing()) {
                this.f76678o.dismiss();
            }
        } else if (this.f76664a.a() || charSequence.toString().contains(TIMMentionEditText.TIM_MENTION_TAG)) {
            this.f76681r = charSequence;
            if (activity.hasWindowFocus()) {
                if (this.f76678o == null) {
                    View inflate = LayoutInflater.from(activity).inflate(R.layout.register_email_association, (ViewGroup) null);
                    PopupWindow popupWindow3 = new PopupWindow(inflate);
                    this.f76678o = popupWindow3;
                    popupWindow3.setWidth(-1);
                    this.f76678o.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.dimen_160));
                    this.f76679p = (RecyclerView) inflate.findViewById(R.id.recyclerView);
                    EmailAssociationAdapter emailAssociationAdapter = new EmailAssociationAdapter();
                    this.f76680q = emailAssociationAdapter;
                    emailAssociationAdapter.h(new a0(this));
                    this.f76679p.setLayoutManager(new LinearLayoutManager(activity));
                    this.f76679p.setAdapter(this.f76680q);
                }
                this.f76680q.g(charSequence.toString());
                if (charSequence.length() <= 0 || this.f76680q.getItemCount() <= 0) {
                    this.f76678o.dismiss();
                } else {
                    if (!this.f76678o.isShowing()) {
                        if (this.f76686w) {
                            this.f76686w = false;
                        } else {
                            int[] iArr = new int[2];
                            this.f76670g.getLocationInWindow(iArr);
                            PopupWindow popupWindow4 = this.f76678o;
                            ClearEditText clearEditText = this.f76670g;
                            popupWindow4.showAtLocation(clearEditText, 48, 0, iArr[1] + clearEditText.getHeight() + activity.getResources().getDimensionPixelSize(R.dimen.dimen_8));
                        }
                    }
                    if (this.f76678o.isShowing()) {
                        this.f76678o.update(-1, activity.getResources().getDimensionPixelSize(R.dimen.dimen_40) * Math.min(this.f76680q.getItemCount(), 3));
                        this.f76680q.notifyDataSetChanged();
                    }
                }
            }
        } else {
            this.f76682s = "";
            this.f76683t = "";
            this.f76681r = "";
            PopupWindow popupWindow5 = this.f76678o;
            if (popupWindow5 != null && popupWindow5.isShowing()) {
                this.f76678o.dismiss();
            }
        }
        if (charSequence.length() > 0) {
            this.f76670g.setTypeface(ResourcesCompat.h(activity, R.font.roboto_medium));
        } else {
            this.f76670g.setTypeface(ResourcesCompat.h(activity, R.font.roboto_regular));
        }
        M(Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(View view, boolean z11) {
        this.f76670g.onFocusChange(view, z11);
        this.f76665b.setSelected(z11);
        if (!z11) {
            PopupWindow popupWindow = this.f76678o;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.f76678o.dismiss();
            }
            PopupWindow popupWindow2 = this.f76677n;
            if (popupWindow2 != null && popupWindow2.isShowing()) {
                this.f76677n.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void C(View view) {
        Intent intent = new Intent(this.f76664a.getActivity(), CountryAreaSelectActivityV2.class);
        intent.putExtra("choose_type", "choose_type_code");
        intent.putExtra("SHOW_COUNTRY_ICON", true);
        intent.putExtra("SHOW_ALL_COUNTRY", true);
        this.f76664a.getActivity().startActivityForResult(intent, 1001);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void D(MultipleAccountData multipleAccountData, Activity activity, View view) {
        PopupWindow popupWindow = this.f76677n;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        String d11 = ConfigPreferences.d("user_config", multipleAccountData.getUid() + "config_new_email");
        this.f76686w = true;
        this.f76670g.setText(d11);
        PopupWindow popupWindow2 = this.f76678o;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
        if (activity instanceof UserLoginActivityV4) {
            ((UserLoginActivityV4) activity).yi();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void E(Activity activity, List list, View view) {
        Activity activity2 = activity;
        PopupWindow popupWindow = this.f76677n;
        if (popupWindow == null || !popupWindow.isShowing()) {
            int a11 = PixelUtils.a(48.0f);
            if (this.f76677n == null) {
                ScrollView scrollView = new ScrollView(activity2);
                LinearLayout linearLayout = new LinearLayout(activity2);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
                marginLayoutParams.setMarginStart(PixelUtils.a(16.0f));
                marginLayoutParams.setMarginEnd(PixelUtils.a(16.0f));
                linearLayout.setLayoutParams(marginLayoutParams);
                linearLayout.setOrientation(1);
                linearLayout.setBackgroundResource(R.drawable.bg_login_email_association);
                scrollView.addView(linearLayout);
                PopupWindow popupWindow2 = new PopupWindow(scrollView);
                this.f76677n = popupWindow2;
                popupWindow2.setWidth(-1);
                PopupWindow popupWindow3 = this.f76677n;
                int i11 = 5;
                if (list.size() < 5) {
                    i11 = list.size();
                }
                popupWindow3.setHeight(i11 * a11);
                Iterator it2 = list.iterator();
                int i12 = 0;
                while (it2.hasNext()) {
                    MultipleAccountData multipleAccountData = (MultipleAccountData) it2.next();
                    i12++;
                    if (i12 >= 10) {
                        break;
                    }
                    View inflate = LayoutInflater.from(activity).inflate(R.layout.item_history_account, (ViewGroup) null);
                    AvatarView avatarView = (AvatarView) inflate.findViewById(R.id.imageHeader);
                    TextView textView = (TextView) inflate.findViewById(R.id.account_name_tv);
                    if (!TextUtils.isEmpty(multipleAccountData.getHeadImage())) {
                        avatarView.u(multipleAccountData.getHeadImage(), "NFT".equals(multipleAccountData.getHeadImageType()), multipleAccountData.getFrameUrl()).s(0, -1, (String) null, (String) null, (String) null, 0);
                        avatarView.A("BIG_V".equals(multipleAccountData.getShowExtBusinessTag()));
                    } else {
                        avatarView.z((String) null, (String) null).y(R.drawable.account_user_image, 0);
                        avatarView.A("BIG_V".equals(multipleAccountData.getShowExtBusinessTag()));
                    }
                    textView.setText(multipleAccountData.getAccount());
                    inflate.setOnClickListener(new v(this, multipleAccountData, activity2));
                    linearLayout.addView(inflate);
                }
            }
            if (!this.f76677n.isShowing()) {
                int[] iArr = new int[2];
                this.f76670g.getLocationInWindow(iArr);
                PopupWindow popupWindow4 = this.f76677n;
                ClearEditText clearEditText = this.f76670g;
                popupWindow4.showAtLocation(clearEditText, 48, 0, iArr[1] + clearEditText.getHeight() + activity.getResources().getDimensionPixelSize(R.dimen.dimen_8));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f76677n.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(View view, boolean z11) {
        this.f76673j.onFocusChange(view, z11);
        this.f76672i.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(View view, CharSequence charSequence, int i11, int i12, int i13) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f76673j.setTextSize(16.0f);
            view.setVisibility(0);
        } else {
            this.f76673j.setTextSize(14.0f);
            view.setVisibility(4);
        }
        if (charSequence.length() > 0) {
            ClearEditText clearEditText = this.f76673j;
            clearEditText.setTypeface(ResourcesCompat.h(clearEditText.getContext(), R.font.roboto_medium));
        } else {
            ClearEditText clearEditText2 = this.f76673j;
            clearEditText2.setTypeface(ResourcesCompat.h(clearEditText2.getContext(), R.font.roboto_regular));
        }
        N(false);
        this.f76684u = charSequence;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void H(ImageView imageView, View view) {
        if (this.f76685v) {
            imageView.setImageResource(R.drawable.icon_eye_close_new);
            this.f76685v = false;
            this.f76673j.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ClearEditText clearEditText = this.f76673j;
            clearEditText.setSelection(clearEditText.getText().toString().length());
        } else {
            imageView.setImageResource(R.drawable.icon_eye_open_new);
            this.f76685v = true;
            this.f76673j.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ClearEditText clearEditText2 = this.f76673j;
            clearEditText2.setSelection(clearEditText2.getText().toString().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(CountryListData countryListData) {
        this.f76675l = countryListData.a();
        this.f76676m = String.valueOf(countryListData.c());
        this.f76669f.setText(this.f76675l.replace("00", "+"));
        L(this.f76676m);
    }

    public static /* synthetic */ CharSequence y(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
        while (i11 < i12) {
            if (Character.isWhitespace(charSequence.charAt(i11))) {
                return charSequence.toString().replaceAll(" ", "");
            }
            i11++;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(String str) {
        this.f76670g.setText(str);
        this.f76670g.setSelection(str.length());
        this.f76678o.dismiss();
    }

    public void J(int i11, int i12, Intent intent) {
        if (i11 == 1001 && intent != null) {
            this.f76675l = intent.getStringExtra("phone_area_code");
            String stringExtra = intent.getStringExtra("country_area_code");
            this.f76676m = stringExtra;
            if (!TextUtils.isEmpty(stringExtra)) {
                L(this.f76676m);
            }
            String str = this.f76675l;
            if (str != null) {
                this.f76669f.setText(str.replace("00", "+"));
            }
        }
    }

    public boolean K() {
        boolean z11;
        PopupWindow popupWindow = this.f76678o;
        if (popupWindow == null || !popupWindow.isShowing()) {
            z11 = false;
        } else {
            this.f76678o.dismiss();
            z11 = true;
        }
        PopupWindow popupWindow2 = this.f76677n;
        if (popupWindow2 == null || !popupWindow2.isShowing()) {
            return z11;
        }
        this.f76677n.dismiss();
        return true;
    }

    public final void L(String str) {
        c.a().l(this.f76664a.getActivity(), w.e(str), this.f76668e, NightHelper.e().g() ? R.drawable.flag_default_night : R.drawable.flag_default);
    }

    public void M(Boolean bool) {
        if (bool.booleanValue()) {
            this.f76665b.setBackgroundResource(R.drawable.login_input_error_bg);
            this.f76671h.setVisibility(0);
            return;
        }
        this.f76665b.setBackgroundResource(R.drawable.login_input_bg);
        this.f76671h.setVisibility(8);
    }

    public void N(boolean z11) {
        if (z11) {
            this.f76672i.setBackgroundResource(R.drawable.login_input_error_bg);
            this.f76674k.setVisibility(0);
            return;
        }
        this.f76672i.setBackgroundResource(R.drawable.login_input_bg);
        this.f76674k.setVisibility(8);
    }

    public void O(String str, Boolean bool) {
        this.f76687x[1] = new InputFilter.LengthFilter(this.f76664a.b() ? 15 : EntityWrapper.TYPE_TITLE);
        this.f76670g.setFilters(this.f76687x);
        if (this.f76664a.b()) {
            this.f76667d.setVisibility(0);
            if (bool.booleanValue()) {
                this.f76670g.setText(this.f76682s);
            }
            if (TextUtils.isEmpty(this.f76675l) && TextUtils.isEmpty(this.f76676m)) {
                this.f76675l = c0.c(str);
                this.f76676m = c0.d(str);
            }
            if (TextUtils.isEmpty(this.f76675l) || TextUtils.isEmpty(this.f76676m)) {
                w.j().i(this.f76664a.getActivity()).subscribe(EasySubscriber.create(new r(this)));
            } else {
                this.f76669f.setText(this.f76675l.replace("00", "+"));
                L(this.f76676m);
            }
        } else if (this.f76664a.I0()) {
            this.f76667d.setVisibility(8);
            if (bool.booleanValue()) {
                this.f76670g.setText(this.f76683t);
            }
        } else if (this.f76664a.a()) {
            this.f76667d.setVisibility(8);
            if (bool.booleanValue()) {
                this.f76670g.setText(this.f76681r);
            }
        } else {
            this.f76667d.setVisibility(8);
        }
        if (this.f76670g.getText() != null && !TextUtils.isEmpty(l()) && bool.booleanValue()) {
            this.f76670g.setSelection(l().length());
        }
    }

    public String l() {
        return this.f76670g.getText().toString();
    }

    public String m() {
        return this.f76675l;
    }

    public String n() {
        return this.f76676m;
    }

    public CharSequence o() {
        return this.f76681r;
    }

    public int p(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (m.Y(str) && str.length() >= 4) {
            return 1;
        }
        if (StringUtils.o(str)) {
            return 0;
        }
        if (!str.matches("^[a-zA-Z][a-zA-Z0-9]*$") || str.length() <= 5 || str.length() >= 21) {
            return -1;
        }
        return 2;
    }

    public String q() {
        return this.f76673j.getText().toString();
    }

    public CharSequence r() {
        return this.f76682s;
    }

    public void s(Activity activity, r rVar) {
        this.f76665b = rVar.b(R.id.ll_account_root);
        this.f76666c = (ImageView) rVar.b(R.id.iv_login_history_arrow);
        t(activity);
        this.f76667d = (ViewGroup) rVar.b(R.id.llyt_select_country_code);
        this.f76669f = (TextView) rVar.b(R.id.tv_login_country_code);
        this.f76668e = (ImageView) rVar.b(R.id.ivCountryIcon);
        this.f76670g = (ClearEditText) rVar.b(R.id.login_account_edit);
        this.f76671h = (TextView) rVar.b(R.id.tv_account_error_tip);
        q qVar = q.f61467b;
        InputFilter[] inputFilterArr = this.f76687x;
        inputFilterArr[0] = qVar;
        inputFilterArr[1] = new InputFilter.LengthFilter(EntityWrapper.TYPE_TITLE);
        this.f76670g.setFilters(this.f76687x);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f76670g.setImportantForAutofill(2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f76670g.setOnTextChangedListener(new y(this, activity));
        this.f76670g.setOnFocusChangeListener(new w(this));
        this.f76667d.setOnClickListener(new s(this));
    }

    public final void t(Activity activity) {
        if (this.f76666c != null) {
            List<MultipleAccountData> a11 = g.a();
            if (a11 != null && !a11.isEmpty()) {
                this.f76666c.setVisibility(0);
            }
            this.f76666c.setOnClickListener(new t(this, activity, a11));
        }
    }

    public void u(r rVar) {
        this.f76672i = rVar.b(R.id.pswLayout);
        View b11 = rVar.b(R.id.divider);
        ImageView imageView = (ImageView) rVar.b(R.id.login_psw_img);
        this.f76673j = (ClearEditText) rVar.b(R.id.cet_pwd);
        this.f76674k = (TextView) rVar.b(R.id.tv_pwd_error_tip);
        ViewUtil.d(this.f76673j);
        ClearEditText clearEditText = this.f76673j;
        clearEditText.setTypeface(ResourcesCompat.h(clearEditText.getContext(), R.font.roboto_medium));
        this.f76673j.setFocusableInTouchMode(true);
        this.f76673j.setFocusable(true);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f76673j.setImportantForAutofill(2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f76673j.setOnFocusChangeListener(new x(this));
        this.f76673j.setOnTextChangedListener(new z(this, b11));
        imageView.setOnClickListener(new u(this, imageView));
    }

    public boolean v() {
        String l11 = l();
        boolean z11 = true;
        boolean z12 = p(l11) == -1;
        if (!z12 && this.f76664a.b()) {
            if (l11.length() >= 7 && l11.length() <= 15) {
                z11 = false;
            }
            z12 = z11;
        }
        M(Boolean.valueOf(z12));
        return z12;
    }

    public boolean w() {
        boolean isEmpty = TextUtils.isEmpty(this.f76684u);
        N(isEmpty);
        return isEmpty;
    }

    public void x(String str) {
        if (this.f76664a.b()) {
            this.f76682s = str;
        } else if (this.f76664a.I0()) {
            this.f76683t = str;
        } else if (this.f76664a.a()) {
            this.f76681r = str;
        }
    }
}
