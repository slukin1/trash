package ik;

import com.huobi.engineutils.ability.EngineCurrencyCommonAbility;
import java.util.Comparator;
import org.json.JSONObject;

public final /* synthetic */ class e implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EngineCurrencyCommonAbility f55109b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f55110c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f55111d;

    public /* synthetic */ e(EngineCurrencyCommonAbility engineCurrencyCommonAbility, int i11, int i12) {
        this.f55109b = engineCurrencyCommonAbility;
        this.f55110c = i11;
        this.f55111d = i12;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f55109b.u(this.f55110c, this.f55111d, (JSONObject) obj, (JSONObject) obj2);
    }
}
