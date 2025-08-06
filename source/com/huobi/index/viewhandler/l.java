package com.huobi.index.viewhandler;

import android.content.Context;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;

public final /* synthetic */ class l implements ExpandableTextView.OnExpandOrContractClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IndexInformationHandler f74468a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f74469b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NewFlashInformation f74470c;

    public /* synthetic */ l(IndexInformationHandler indexInformationHandler, Context context, NewFlashInformation newFlashInformation) {
        this.f74468a = indexInformationHandler;
        this.f74469b = context;
        this.f74470c = newFlashInformation;
    }

    public final void onClick(StatusType statusType) {
        this.f74468a.l(this.f74469b, this.f74470c, statusType);
    }
}
