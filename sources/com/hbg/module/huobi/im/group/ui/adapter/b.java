package com.hbg.module.huobi.im.group.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.group.bean.ChatBlockEntity;
import com.hbg.module.huobi.im.view.AvatarView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import ld.e;
import ld.f;
import rd.s;

public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public Context f20098a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatBlockEntity> f20099b;

    /* renamed from: c  reason: collision with root package name */
    public f f20100c = new f((e) null);

    /* renamed from: d  reason: collision with root package name */
    public int f20101d;

    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final AvatarView f20102a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f20103b;

        /* renamed from: c  reason: collision with root package name */
        public final TextView f20104c;

        public a(View view) {
            super(view);
            this.f20102a = (AvatarView) view.findViewById(R$id.iv_user_icon);
            this.f20103b = (TextView) view.findViewById(R$id.tv_name);
            this.f20104c = (TextView) view.findViewById(R$id.tv_block);
        }

        public final AvatarView e() {
            return this.f20102a;
        }

        public final TextView f() {
            return this.f20104c;
        }

        public final TextView g() {
            return this.f20103b;
        }
    }

    /* renamed from: com.hbg.module.huobi.im.group.ui.adapter.b$b  reason: collision with other inner class name */
    public static final class C0143b implements dd.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f20105a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f20106b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChatBlockEntity f20107c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f20108d;

        public C0143b(Ref$IntRef ref$IntRef, b bVar, ChatBlockEntity chatBlockEntity, int i11) {
            this.f20105a = ref$IntRef;
            this.f20106b = bVar;
            this.f20107c = chatBlockEntity;
            this.f20108d = i11;
        }

        public void onFailed(int i11, String str) {
            int i12 = this.f20105a.element;
            if (i12 == 2) {
                ToastUtil.toastShortMessage(this.f20106b.d().getString(R$string.n_im_block_user_failed));
            } else if (i12 == 3) {
                ToastUtil.toastShortMessage(this.f20106b.d().getString(R$string.n_im_operation_fail));
            }
        }

        public void onSuccess() {
            int i11 = this.f20105a.element;
            if (i11 == 2) {
                ToastUtil.toastShortMessage(this.f20106b.d().getString(R$string.n_im_block_user_success));
                this.f20107c.setBlockState(1);
            } else if (i11 == 3) {
                ToastUtil.toastShortMessage(this.f20106b.d().getString(R$string.n_im_black_cancel));
                this.f20107c.setBlockState(0);
            }
            this.f20106b.notifyItemChanged(this.f20108d);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20109b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20110c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f20111d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f20112e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f20113f;

        public c(View view, long j11, b bVar, Ref$ObjectRef ref$ObjectRef, int i11) {
            this.f20109b = view;
            this.f20110c = j11;
            this.f20111d = bVar;
            this.f20112e = ref$ObjectRef;
            this.f20113f = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20109b) > this.f20110c || (this.f20109b instanceof Checkable)) {
                sVar.e(this.f20109b, currentTimeMillis);
                TextView textView = (TextView) this.f20109b;
                this.f20111d.e((ChatBlockEntity) this.f20112e.element, this.f20113f);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public b(Context context) {
        this.f20098a = context;
    }

    public static final void g(a aVar, b bVar) {
        int width = aVar.f().getWidth();
        if (width > bVar.f20101d) {
            bVar.f20101d = width;
        }
        aVar.f().getLayoutParams().width = bVar.f20101d;
    }

    public final void c(ChatBlockEntity chatBlockEntity, a aVar) {
        if (chatBlockEntity.getBlockState() == 1) {
            aVar.f().setText(this.f20098a.getString(R$string.n_im_black_cancel));
            aVar.f().setTextColor(ContextCompat.getColor(this.f20098a, R$color.baseColorPrimaryText));
            aVar.f().setBackgroundColor(ContextCompat.getColor(this.f20098a, R$color.radioButtonDefaultColor));
            return;
        }
        aVar.f().setText(this.f20098a.getString(R$string.n_im_block_user));
        aVar.f().setBackground(ContextCompat.getDrawable(this.f20098a, R$drawable.bg_block_btn));
        aVar.f().setTextColor(ContextCompat.getColor(this.f20098a, R$color.color_F95A50));
    }

    public final Context d() {
        return this.f20098a;
    }

    public final void e(ChatBlockEntity chatBlockEntity, int i11) {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = chatBlockEntity.getBlockState() == 1 ? 3 : 2;
        String account = chatBlockEntity.getAccount();
        if (account != null) {
            this.f20100c.E(account, ref$IntRef.element, new C0143b(ref$IntRef, this, chatBlockEntity, i11));
        }
    }

    /* renamed from: f */
    public void onBindViewHolder(a aVar, int i11) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        List<ChatBlockEntity> list = this.f20099b;
        T t11 = list != null ? (ChatBlockEntity) list.get(i11) : null;
        ref$ObjectRef.element = t11;
        ChatBlockEntity chatBlockEntity = (ChatBlockEntity) t11;
        if (t11 != null) {
            aVar.e().w(t11.getAvatar(), R$drawable.icon_community_user_header);
            aVar.g().setText(t11.getNickname());
            aVar.f().post(new a(aVar, this));
            c(t11, aVar);
            s sVar = s.f23381a;
            TextView f11 = aVar.f();
            f11.setOnClickListener(new c(f11, 800, this, ref$ObjectRef, i11));
        }
    }

    public int getItemCount() {
        List<ChatBlockEntity> list = this.f20099b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(LayoutInflater.from(this.f20098a).inflate(R$layout.im_item_chat_block, viewGroup, false));
    }

    public final void i(List<ChatBlockEntity> list) {
        this.f20099b = list;
    }
}
