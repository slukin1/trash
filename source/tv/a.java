package tv;

import android.app.Activity;
import android.view.View;
import androidx.core.util.c;
import com.huochat.community.viewholder.CommunityHolder;
import java.util.ArrayList;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f60474b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c[] f60475c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f60476d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f60477e;

    public /* synthetic */ a(Activity activity, c[] cVarArr, ArrayList arrayList, int i11) {
        this.f60474b = activity;
        this.f60475c = cVarArr;
        this.f60476d = arrayList;
        this.f60477e = i11;
    }

    public final void onClick(View view) {
        CommunityHolder.loadNineGridImages$lambda$36$lambda$35(this.f60474b, this.f60475c, this.f60476d, this.f60477e, view);
    }
}
