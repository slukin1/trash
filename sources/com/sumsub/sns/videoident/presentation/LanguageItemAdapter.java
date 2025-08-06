package com.sumsub.sns.videoident.presentation;

import android.annotation.SuppressLint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sumsub.sns.R;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.videoident.presentation.a;
import d10.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005H\u0016R6\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@GX\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/sumsub/sns/videoident/presentation/LanguageItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sumsub/sns/videoident/presentation/LanguageItemAdapter$LanguageItemViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "getItemCount", "holder", "position", "", "onBindViewHolder", "", "Lcom/sumsub/sns/internal/videoident/presentation/a$c$b;", "value", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "Lkotlin/Function1;", "selectionCallback", "Ld10/l;", "getSelectionCallback", "()Ld10/l;", "setSelectionCallback", "(Ld10/l;)V", "<init>", "()V", "LanguageItemViewHolder", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class LanguageItemAdapter extends RecyclerView.Adapter<LanguageItemViewHolder> {
    private List<a.c.b> items = CollectionsKt__CollectionsKt.k();
    private l<? super a.c.b, Unit> selectionCallback;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/videoident/presentation/LanguageItemAdapter$LanguageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/sumsub/sns/internal/videoident/presentation/a$c$b;", "item", "", "bind", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "getStatus", "status", "getTime", "time", "Landroid/view/View;", "itemView", "<init>", "(Lcom/sumsub/sns/videoident/presentation/LanguageItemAdapter;Landroid/view/View;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public final class LanguageItemViewHolder extends RecyclerView.ViewHolder {
        public LanguageItemViewHolder(View view) {
            super(view);
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m2289bind$lambda0(LanguageItemAdapter languageItemAdapter, a.c.b bVar, View view) {
            l<a.c.b, Unit> selectionCallback = languageItemAdapter.getSelectionCallback();
            if (selectionCallback != null) {
                selectionCallback.invoke(bVar);
            }
        }

        private final TextView getStatus() {
            return (TextView) this.itemView.findViewById(R.id.sns_status);
        }

        private final TextView getTime() {
            return (TextView) this.itemView.findViewById(R.id.sns_time);
        }

        private final TextView getTitle() {
            return (TextView) this.itemView.findViewById(R.id.sns_item_title);
        }

        public final void bind(a.c.b bVar) {
            TextView title = getTitle();
            if (title != null) {
                i.a(title, (CharSequence) bVar.k());
            }
            TextView status = getStatus();
            if (status != null) {
                i.a(status, (CharSequence) bVar.i());
            }
            TextView time = getTime();
            if (time != null) {
                i.a(time, (CharSequence) bVar.j());
            }
            View view = this.itemView;
            Boolean h11 = bVar.h();
            view.setSelected(h11 != null ? h11.booleanValue() : false);
            this.itemView.setOnClickListener(new a(LanguageItemAdapter.this, bVar));
        }
    }

    public int getItemCount() {
        return this.items.size();
    }

    public final List<a.c.b> getItems() {
        return this.items;
    }

    public final l<a.c.b, Unit> getSelectionCallback() {
        return this.selectionCallback;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setItems(List<a.c.b> list) {
        this.items = list;
        notifyDataSetChanged();
    }

    public final void setSelectionCallback(l<? super a.c.b, Unit> lVar) {
        this.selectionCallback = lVar;
    }

    public void onBindViewHolder(LanguageItemViewHolder languageItemViewHolder, int i11) {
        languageItemViewHolder.bind(this.items.get(i11));
    }

    public LanguageItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        SNSVideoIdentLanguageItemView sNSVideoIdentLanguageItemView = new SNSVideoIdentLanguageItemView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null);
        sNSVideoIdentLanguageItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new LanguageItemViewHolder(sNSVideoIdentLanguageItemView);
    }
}
