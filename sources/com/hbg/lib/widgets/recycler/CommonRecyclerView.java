package com.hbg.lib.widgets.recycler;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import ka.a;

public class CommonRecyclerView<I extends ka.a> extends RecyclerView {

    /* renamed from: h  reason: collision with root package name */
    public static HandlerThread f72286h;

    /* renamed from: b  reason: collision with root package name */
    public Context f72287b;

    /* renamed from: c  reason: collision with root package name */
    public ja.a<I> f72288c;

    /* renamed from: d  reason: collision with root package name */
    public final List<I> f72289d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public Callback<I> f72290e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f72291f = new a(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public Handler f72292g;

    public static abstract class Callback<I extends ka.a> {
        public abstract void a(List<I> list);

        public void b(List<I> list) {
        }

        public boolean c(RecyclerView.ViewHolder viewHolder, I i11, int i12) {
            return false;
        }

        public void d(List<I> list) {
        }
    }

    public class a extends Handler {

        /* renamed from: com.hbg.lib.widgets.recycler.CommonRecyclerView$a$a  reason: collision with other inner class name */
        public class C0793a extends ja.a<I> {
            public C0793a(Context context, List list) {
                super(context, list);
            }

            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
                if (CommonRecyclerView.this.f72290e == null || !CommonRecyclerView.this.f72290e.c(viewHolder, c(i11), i11)) {
                    super.onBindViewHolder(viewHolder, i11);
                }
            }
        }

        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                CommonRecyclerView commonRecyclerView = CommonRecyclerView.this;
                ja.a<I> aVar = commonRecyclerView.f72288c;
                if (aVar == null) {
                    commonRecyclerView.f72288c = new C0793a(commonRecyclerView.f72287b, CommonRecyclerView.this.f72289d);
                    CommonRecyclerView commonRecyclerView2 = CommonRecyclerView.this;
                    commonRecyclerView2.setAdapter(commonRecyclerView2.f72288c);
                } else {
                    aVar.e(commonRecyclerView.f72289d);
                    CommonRecyclerView.this.f72288c.notifyDataSetChanged();
                }
                if (CommonRecyclerView.this.f72290e != null) {
                    CommonRecyclerView.this.f72290e.d(CommonRecyclerView.this.f72289d);
                }
            }
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 1) {
                synchronized (CommonRecyclerView.this.f72289d) {
                    if (CommonRecyclerView.this.f72290e != null) {
                        CommonRecyclerView.this.f72290e.b(CommonRecyclerView.this.f72289d);
                    }
                    CommonRecyclerView.this.j();
                }
            } else if (i11 == 2) {
                synchronized (CommonRecyclerView.this.f72289d) {
                    if (CommonRecyclerView.this.f72290e != null) {
                        ArrayList arrayList = new ArrayList();
                        CommonRecyclerView.this.f72290e.a(arrayList);
                        CommonRecyclerView.this.f72289d.clear();
                        CommonRecyclerView.this.f72289d.addAll(arrayList);
                        CommonRecyclerView.this.k();
                    }
                }
            }
        }
    }

    public CommonRecyclerView(Context context) {
        super(context);
        f(context);
    }

    public static synchronized Looper getNonUiLooper() {
        Looper looper;
        synchronized (CommonRecyclerView.class) {
            if (f72286h == null) {
                HandlerThread handlerThread = new HandlerThread("crv");
                f72286h = handlerThread;
                handlerThread.start();
            }
            looper = f72286h.getLooper();
        }
        return looper;
    }

    public void d() {
        synchronized (this.f72289d) {
            this.f72289d.clear();
            j();
        }
    }

    public ka.a e(int i11) {
        ja.a<I> aVar = this.f72288c;
        if (aVar != null) {
            return aVar.c(i11);
        }
        return null;
    }

    public final void f(Context context) {
        this.f72287b = context;
        h();
        setLayoutManager(g(this.f72287b));
    }

    public RecyclerView.LayoutManager g(Context context) {
        return new StableLinearLayoutManager(context);
    }

    public List<I> getDataList() {
        return this.f72289d;
    }

    public int getItemCount() {
        ja.a<I> aVar = this.f72288c;
        if (aVar != null) {
            return aVar.getItemCount();
        }
        return 0;
    }

    public final void h() {
        if (!isInEditMode()) {
            this.f72292g = new b(getNonUiLooper());
        }
    }

    public boolean i() {
        return this.f72289d.isEmpty();
    }

    public void j() {
        Handler handler = this.f72291f;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    public final void k() {
        Handler handler = this.f72292g;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    public void l() {
        Handler handler = this.f72292g;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
    }

    public void m(I i11) {
        synchronized (this.f72289d) {
            try {
                this.f72289d.remove(i11);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void onAttachedToWindow() {
        if (!isInEditMode()) {
            super.onAttachedToWindow();
        }
    }

    public void setCallback(Callback<I> callback) {
        this.f72290e = callback;
    }

    public void setData(List<I> list) {
        synchronized (this.f72289d) {
            this.f72289d.clear();
            this.f72289d.addAll(list);
        }
        j();
    }

    public ja.a<I> getAdapter() {
        return this.f72288c;
    }

    public CommonRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(context);
    }

    public CommonRecyclerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        f(context);
    }
}
