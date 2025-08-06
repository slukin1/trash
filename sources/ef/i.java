package ef;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.hbg.core.bean.LiveHotTalkData;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.module.content.R$id;
import com.hbg.module.livesquare.adapter.f;
import ef.b;

public class i extends b {

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f28963b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayoutManager f28964c = new LinearLayoutManager(this.f28903a, 0, false);

    /* renamed from: d  reason: collision with root package name */
    public final f f28965d;

    public i(View view, LifecycleOwner lifecycleOwner) {
        super(view);
        this.f28963b = (RecyclerView) view.findViewById(R$id.rv_hot_talk);
        f fVar = new f(this.f28903a);
        this.f28965d = fVar;
        fVar.f(lifecycleOwner);
    }

    public void b(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        super.a(liveSquareBaseData);
        if (liveSquareBaseData instanceof LiveHotTalkData) {
            this.f28963b.setLayoutManager(this.f28964c);
            this.f28963b.setAdapter(this.f28965d);
            this.f28965d.e(aVar);
            this.f28965d.d(((LiveHotTalkData) liveSquareBaseData).getGroupList());
        }
    }
}
