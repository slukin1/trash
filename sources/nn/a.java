package nn;

import android.view.View;
import android.widget.TextView;
import com.huobi.login.presenter.CountryAreaSelectHandler;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import v9.c;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f58556b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f58557c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CountryListData f58558d;

    public /* synthetic */ a(c cVar, TextView textView, CountryListData countryListData) {
        this.f58556b = cVar;
        this.f58557c = textView;
        this.f58558d = countryListData;
    }

    public final void onClick(View view) {
        CountryAreaSelectHandler.d(this.f58556b, this.f58557c, this.f58558d, view);
    }
}
