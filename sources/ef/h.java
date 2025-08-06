package ef;

import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.hbg.lib.network.hbg.core.bean.LiveHotTalkItemData;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$string;
import com.hbg.module.livesquare.view.ParallaxLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ef.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.d0;
import rd.s;

public final class h extends b {

    /* renamed from: b  reason: collision with root package name */
    public final View f28952b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28953c;

    /* renamed from: d  reason: collision with root package name */
    public ParallaxLayout f28954d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28955e;

    /* renamed from: f  reason: collision with root package name */
    public LiveSpeaker f28956f;

    /* renamed from: g  reason: collision with root package name */
    public LifecycleOwner f28957g;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f28958b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f28959c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a f28960d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f28961e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f28962f;

        public a(View view, long j11, b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11) {
            this.f28958b = view;
            this.f28959c = j11;
            this.f28960d = aVar;
            this.f28961e = liveSquareBaseData;
            this.f28962f = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f28958b) > this.f28959c || (this.f28958b instanceof Checkable)) {
                sVar.e(this.f28958b, currentTimeMillis);
                b.a aVar = this.f28960d;
                if (aVar != null) {
                    aVar.a(this.f28961e, 105, this.f28962f);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public h(View view) {
        super(view);
        this.f28952b = view;
        this.f28953c = (TextView) view.findViewById(R$id.tvLiveName);
        this.f28954d = (ParallaxLayout) view.findViewById(R$id.viewFlipper);
        this.f28955e = (TextView) view.findViewById(R$id.tvPersonNum);
    }

    public void b(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        List<LiveHotTalkItemData.UserInfo> list;
        LiveSpeaker liveSpeaker = (LiveSpeaker) liveSquareBaseData;
        this.f28956f = liveSpeaker;
        TextView textView = this.f28953c;
        Integer num = null;
        if (textView != null) {
            textView.setText(liveSpeaker != null ? liveSpeaker.title : null);
        }
        TextView textView2 = this.f28955e;
        if (textView2 != null) {
            d0 d0Var = d0.f56774a;
            String str = this.f28952b.getContext().getResources().getString(R$string.n_person_number_unit) + ' ';
            Object[] objArr = new Object[1];
            StringBuilder sb2 = new StringBuilder();
            LiveSpeaker liveSpeaker2 = this.f28956f;
            if (liveSpeaker2 != null) {
                num = Integer.valueOf(liveSpeaker2.userCount);
            }
            sb2.append(num);
            sb2.append(' ');
            objArr[0] = sb2.toString();
            textView2.setText(String.format(str, Arrays.copyOf(objArr, 1)));
        }
        LiveSpeaker liveSpeaker3 = this.f28956f;
        if (!(liveSpeaker3 == null || (list = liveSpeaker3.userList) == null)) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
            for (LiveHotTalkItemData.UserInfo avatar : list) {
                arrayList.add(avatar.getAvatar());
            }
            ParallaxLayout parallaxLayout = this.f28954d;
            if (parallaxLayout != null) {
                parallaxLayout.setItemsList(CollectionsKt___CollectionsKt.L0(arrayList));
            }
            ParallaxLayout parallaxLayout2 = this.f28954d;
            if (parallaxLayout2 != null) {
                parallaxLayout2.h(this.f28957g);
            }
        }
        s sVar = s.f23381a;
        View view = this.f28952b;
        view.setOnClickListener(new a(view, 800, aVar, liveSquareBaseData, i11));
    }

    public final void h(LifecycleOwner lifecycleOwner) {
        this.f28957g = lifecycleOwner;
    }
}
