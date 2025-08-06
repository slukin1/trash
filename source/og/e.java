package og;

import android.view.View;
import com.huobi.account.entity.ChooseCityEntity;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f58823b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f58824c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ChooseCityEntity f58825d;

    public /* synthetic */ e(f fVar, int i11, ChooseCityEntity chooseCityEntity) {
        this.f58823b = fVar;
        this.f58824c = i11;
        this.f58825d = chooseCityEntity;
    }

    public final void onClick(View view) {
        this.f58823b.c(this.f58824c, this.f58825d, view);
    }
}
