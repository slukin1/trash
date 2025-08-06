package com.iproov.sdk;

import android.content.Context;
import com.iproov.sdk.IProov;
import com.iproov.sdk.p017implements.Ccase;
import com.iproov.sdk.p026return.Cconst;
import com.iproov.sdk.p027static.Cfor;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/iproov/sdk/return/const;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class IProovFlowLauncher$launch$2 extends Lambda implements a<Cconst> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ IProov.Options $options;
    public final /* synthetic */ String $streamingUrl;
    public final /* synthetic */ String $token;
    public final /* synthetic */ IProovFlowLauncher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IProovFlowLauncher$launch$2(IProovFlowLauncher iProovFlowLauncher, Context context, String str, String str2, IProov.Options options) {
        super(0);
        this.this$0 = iProovFlowLauncher;
        this.$context = context;
        this.$streamingUrl = str;
        this.$token = str2;
        this.$options = options;
    }

    public final Cconst invoke() {
        Cfor forR = new Cfor(this.this$0.getAppComponent(this.$context.getApplicationContext()), this.$streamingUrl, this.$token, Cdo.m557do(this.$options, this.$context), this.this$0.internalOptions);
        Ccase.m977do(this.this$0);
        Cconst constR = forR.m1805break();
        constR.m1423try();
        return constR;
    }
}
