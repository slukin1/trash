package jumio.dui;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.jumio.defaultui.view.RejectFragment;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.handler.JumioRejectHandler;
import com.jumio.sdk.views.JumioRejectView;
import d10.l;
import java.util.List;

public final class e extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public final l<Context, JumioRejectView> f56391a;

    /* renamed from: b  reason: collision with root package name */
    public JumioRejectHandler f56392b;

    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final JumioRejectView f56393a;

        public a(JumioRejectView jumioRejectView) {
            super(jumioRejectView);
            this.f56393a = jumioRejectView;
        }
    }

    public e(RejectFragment.b bVar) {
        this.f56391a = bVar;
    }

    public final int getItemCount() {
        List<JumioCredentialPart> parts;
        JumioRejectHandler jumioRejectHandler = this.f56392b;
        if (jumioRejectHandler == null || (parts = jumioRejectHandler.getParts()) == null) {
            return 0;
        }
        return parts.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        a aVar = (a) viewHolder;
        JumioRejectHandler jumioRejectHandler = this.f56392b;
        if (jumioRejectHandler != null) {
            jumioRejectHandler.renderPart(jumioRejectHandler.getParts().get(i11), aVar.f56393a);
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(this.f56391a.invoke(viewGroup.getContext()));
    }
}
