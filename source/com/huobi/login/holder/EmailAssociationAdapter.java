package com.huobi.login.holder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.store.AppConfigManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class EmailAssociationAdapter extends RecyclerView.Adapter<c> {

    /* renamed from: a  reason: collision with root package name */
    public b f75441a;

    /* renamed from: b  reason: collision with root package name */
    public String f75442b;

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f75443c = new ArrayList();

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f75444b;

        public a(c cVar) {
            this.f75444b = cVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (EmailAssociationAdapter.this.f75441a != null) {
                b a11 = EmailAssociationAdapter.this.f75441a;
                a11.onClick(EmailAssociationAdapter.this.f75442b + ((String) EmailAssociationAdapter.this.f75443c.get(this.f75444b.getAbsoluteAdapterPosition())));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface b {
        void onClick(String str);
    }

    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f75446a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f75447b;

        public c(View view) {
            super(view);
            this.f75446a = (TextView) view.findViewById(R.id.first);
            this.f75447b = (TextView) view.findViewById(R.id.second);
        }
    }

    /* renamed from: e */
    public void onBindViewHolder(c cVar, int i11) {
        cVar.f75446a.setText(this.f75442b);
        cVar.f75447b.setText(this.f75443c.get(cVar.getAbsoluteAdapterPosition()));
        cVar.itemView.setOnClickListener(new a(cVar));
    }

    /* renamed from: f */
    public c onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.register_email_association_item, viewGroup, false));
    }

    public void g(String str) {
        this.f75442b = str;
        this.f75443c.clear();
        int lastIndexOf = str.lastIndexOf(TIMMentionEditText.TIM_MENTION_TAG);
        List<String> k11 = AppConfigManager.k(53, String.class);
        if (lastIndexOf >= 0 && k11 != null && !k11.isEmpty()) {
            String substring = str.substring(lastIndexOf + 1);
            for (String next : k11) {
                if (!TextUtils.isEmpty(next) && next.startsWith(substring)) {
                    this.f75443c.add(next);
                    if (this.f75443c.size() >= 20) {
                        break;
                    }
                }
            }
        }
        if (!this.f75443c.isEmpty()) {
            this.f75442b = str.substring(0, lastIndexOf + 1);
        }
    }

    public int getItemCount() {
        return this.f75443c.size();
    }

    public void h(b bVar) {
        this.f75441a = bVar;
    }
}
