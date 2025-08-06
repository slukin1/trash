package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.h0;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

public class AlertController {
    public NestedScrollView A;
    public int B = 0;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public int I = -1;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public int Q = 0;
    public Handler R;
    public final View.OnClickListener S = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Context f3730a;

    /* renamed from: b  reason: collision with root package name */
    public final e f3731b;

    /* renamed from: c  reason: collision with root package name */
    public final Window f3732c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3733d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f3734e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f3735f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f3736g;

    /* renamed from: h  reason: collision with root package name */
    public View f3737h;

    /* renamed from: i  reason: collision with root package name */
    public int f3738i;

    /* renamed from: j  reason: collision with root package name */
    public int f3739j;

    /* renamed from: k  reason: collision with root package name */
    public int f3740k;

    /* renamed from: l  reason: collision with root package name */
    public int f3741l;

    /* renamed from: m  reason: collision with root package name */
    public int f3742m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3743n = false;

    /* renamed from: o  reason: collision with root package name */
    public Button f3744o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f3745p;

    /* renamed from: q  reason: collision with root package name */
    public Message f3746q;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f3747r;

    /* renamed from: s  reason: collision with root package name */
    public Button f3748s;

    /* renamed from: t  reason: collision with root package name */
    public CharSequence f3749t;

    /* renamed from: u  reason: collision with root package name */
    public Message f3750u;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f3751v;

    /* renamed from: w  reason: collision with root package name */
    public Button f3752w;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f3753x;

    /* renamed from: y  reason: collision with root package name */
    public Message f3754y;

    /* renamed from: z  reason: collision with root package name */
    public Drawable f3755z;

    public static class RecycleListView extends ListView {

        /* renamed from: b  reason: collision with root package name */
        public final int f3756b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3757c;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecycleListView);
            this.f3757c = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f3756b = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z11, boolean z12) {
            if (!z12 || !z11) {
                setPadding(getPaddingLeft(), z11 ? getPaddingTop() : this.f3756b, getPaddingRight(), z12 ? getPaddingBottom() : this.f3757c);
            }
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            r3 = r0.f3754y;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r3) {
            /*
                r2 = this;
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r1 = r0.f3744o
                if (r3 != r1) goto L_0x000f
                android.os.Message r1 = r0.f3746q
                if (r1 == 0) goto L_0x000f
                android.os.Message r3 = android.os.Message.obtain(r1)
                goto L_0x002a
            L_0x000f:
                android.widget.Button r1 = r0.f3748s
                if (r3 != r1) goto L_0x001c
                android.os.Message r1 = r0.f3750u
                if (r1 == 0) goto L_0x001c
                android.os.Message r3 = android.os.Message.obtain(r1)
                goto L_0x002a
            L_0x001c:
                android.widget.Button r1 = r0.f3752w
                if (r3 != r1) goto L_0x0029
                android.os.Message r3 = r0.f3754y
                if (r3 == 0) goto L_0x0029
                android.os.Message r3 = android.os.Message.obtain(r3)
                goto L_0x002a
            L_0x0029:
                r3 = 0
            L_0x002a:
                if (r3 == 0) goto L_0x002f
                r3.sendToTarget()
            L_0x002f:
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Handler r0 = r3.R
                r1 = 1
                androidx.appcompat.app.e r3 = r3.f3731b
                android.os.Message r3 = r0.obtainMessage(r1, r3)
                r3.sendToTarget()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.a.onClick(android.view.View):void");
        }
    }

    public class b implements NestedScrollView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f3759a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f3760b;

        public b(View view, View view2) {
            this.f3759a = view;
            this.f3760b = view2;
        }

        public void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
            AlertController.g(nestedScrollView, this.f3759a, this.f3760b);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f3762b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f3763c;

        public c(View view, View view2) {
            this.f3762b = view;
            this.f3763c = view2;
        }

        public void run() {
            AlertController.g(AlertController.this.A, this.f3762b, this.f3763c);
        }
    }

    public class d implements AbsListView.OnScrollListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f3765b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f3766c;

        public d(View view, View view2) {
            this.f3765b = view;
            this.f3766c = view2;
        }

        public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
            AlertController.g(absListView, this.f3765b, this.f3766c);
        }

        public void onScrollStateChanged(AbsListView absListView, int i11) {
        }
    }

    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f3768b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f3769c;

        public e(View view, View view2) {
            this.f3768b = view;
            this.f3769c = view2;
        }

        public void run() {
            AlertController.g(AlertController.this.f3736g, this.f3768b, this.f3769c);
        }
    }

    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public boolean N;
        public AdapterView.OnItemSelectedListener O;
        public e P;
        public boolean Q = true;

        /* renamed from: a  reason: collision with root package name */
        public final Context f3771a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f3772b;

        /* renamed from: c  reason: collision with root package name */
        public int f3773c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f3774d;

        /* renamed from: e  reason: collision with root package name */
        public int f3775e = 0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f3776f;

        /* renamed from: g  reason: collision with root package name */
        public View f3777g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f3778h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f3779i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f3780j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f3781k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f3782l;

        /* renamed from: m  reason: collision with root package name */
        public Drawable f3783m;

        /* renamed from: n  reason: collision with root package name */
        public DialogInterface.OnClickListener f3784n;

        /* renamed from: o  reason: collision with root package name */
        public CharSequence f3785o;

        /* renamed from: p  reason: collision with root package name */
        public Drawable f3786p;

        /* renamed from: q  reason: collision with root package name */
        public DialogInterface.OnClickListener f3787q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f3788r;

        /* renamed from: s  reason: collision with root package name */
        public DialogInterface.OnCancelListener f3789s;

        /* renamed from: t  reason: collision with root package name */
        public DialogInterface.OnDismissListener f3790t;

        /* renamed from: u  reason: collision with root package name */
        public DialogInterface.OnKeyListener f3791u;

        /* renamed from: v  reason: collision with root package name */
        public CharSequence[] f3792v;

        /* renamed from: w  reason: collision with root package name */
        public ListAdapter f3793w;

        /* renamed from: x  reason: collision with root package name */
        public DialogInterface.OnClickListener f3794x;

        /* renamed from: y  reason: collision with root package name */
        public int f3795y;

        /* renamed from: z  reason: collision with root package name */
        public View f3796z;

        public class a extends ArrayAdapter<CharSequence> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RecycleListView f3797b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Context context, int i11, int i12, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i11, i12, charSequenceArr);
                this.f3797b = recycleListView;
            }

            public View getView(int i11, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i11, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i11]) {
                    this.f3797b.setItemChecked(i11, true);
                }
                return view2;
            }
        }

        public class b extends CursorAdapter {

            /* renamed from: b  reason: collision with root package name */
            public final int f3799b;

            /* renamed from: c  reason: collision with root package name */
            public final int f3800c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ RecycleListView f3801d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AlertController f3802e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Context context, Cursor cursor, boolean z11, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z11);
                this.f3801d = recycleListView;
                this.f3802e = alertController;
                Cursor cursor2 = getCursor();
                this.f3799b = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f3800c = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f3799b));
                RecycleListView recycleListView = this.f3801d;
                int position = cursor.getPosition();
                boolean z11 = true;
                if (cursor.getInt(this.f3800c) != 1) {
                    z11 = false;
                }
                recycleListView.setItemChecked(position, z11);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f3772b.inflate(this.f3802e.M, viewGroup, false);
            }
        }

        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AlertController f3804b;

            public c(AlertController alertController) {
                this.f3804b = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                f.this.f3794x.onClick(this.f3804b.f3731b, i11);
                if (!f.this.H) {
                    this.f3804b.f3731b.dismiss();
                }
            }
        }

        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RecycleListView f3806b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ AlertController f3807c;

            public d(RecycleListView recycleListView, AlertController alertController) {
                this.f3806b = recycleListView;
                this.f3807c = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i11] = this.f3806b.isItemChecked(i11);
                }
                f.this.J.onClick(this.f3807c.f3731b, i11, this.f3806b.isItemChecked(i11));
            }
        }

        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.f3771a = context;
            this.f3788r = true;
            this.f3772b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            View view = this.f3777g;
            if (view != null) {
                alertController.n(view);
            } else {
                CharSequence charSequence = this.f3776f;
                if (charSequence != null) {
                    alertController.s(charSequence);
                }
                Drawable drawable = this.f3774d;
                if (drawable != null) {
                    alertController.p(drawable);
                }
                int i11 = this.f3773c;
                if (i11 != 0) {
                    alertController.o(i11);
                }
                int i12 = this.f3775e;
                if (i12 != 0) {
                    alertController.o(alertController.d(i12));
                }
            }
            CharSequence charSequence2 = this.f3778h;
            if (charSequence2 != null) {
                alertController.q(charSequence2);
            }
            CharSequence charSequence3 = this.f3779i;
            if (!(charSequence3 == null && this.f3780j == null)) {
                alertController.l(-1, charSequence3, this.f3781k, (Message) null, this.f3780j);
            }
            CharSequence charSequence4 = this.f3782l;
            if (!(charSequence4 == null && this.f3783m == null)) {
                alertController.l(-2, charSequence4, this.f3784n, (Message) null, this.f3783m);
            }
            CharSequence charSequence5 = this.f3785o;
            if (!(charSequence5 == null && this.f3786p == null)) {
                alertController.l(-3, charSequence5, this.f3787q, (Message) null, this.f3786p);
            }
            if (!(this.f3792v == null && this.K == null && this.f3793w == null)) {
                b(alertController);
            }
            View view2 = this.f3796z;
            if (view2 == null) {
                int i13 = this.f3795y;
                if (i13 != 0) {
                    alertController.t(i13);
                }
            } else if (this.E) {
                alertController.v(view2, this.A, this.B, this.C, this.D);
            } else {
                alertController.u(view2);
            }
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v3 */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v23, types: [androidx.appcompat.app.AlertController$f$b] */
        /* JADX WARNING: type inference failed for: r1v24, types: [androidx.appcompat.app.AlertController$f$a] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(androidx.appcompat.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.f3772b
                int r1 = r11.L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r10.G
                r8 = 1
                if (r1 == 0) goto L_0x0035
                android.database.Cursor r1 = r10.K
                if (r1 != 0) goto L_0x0026
                androidx.appcompat.app.AlertController$f$a r9 = new androidx.appcompat.app.AlertController$f$a
                android.content.Context r3 = r10.f3771a
                int r4 = r11.M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.f3792v
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0026:
                androidx.appcompat.app.AlertController$f$b r9 = new androidx.appcompat.app.AlertController$f$b
                android.content.Context r3 = r10.f3771a
                android.database.Cursor r4 = r10.K
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0035:
                boolean r1 = r10.H
                if (r1 == 0) goto L_0x003c
                int r1 = r11.N
                goto L_0x003e
            L_0x003c:
                int r1 = r11.O
            L_0x003e:
                r4 = r1
                android.database.Cursor r1 = r10.K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005d
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.f3771a
                android.database.Cursor r5 = r10.K
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r1 = r10.L
                r7 = 0
                r6[r7] = r1
                int[] r1 = new int[r8]
                r1[r7] = r2
                r2 = r9
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x005d:
                android.widget.ListAdapter r9 = r10.f3793w
                if (r9 == 0) goto L_0x0062
                goto L_0x006b
            L_0x0062:
                androidx.appcompat.app.AlertController$h r9 = new androidx.appcompat.app.AlertController$h
                android.content.Context r1 = r10.f3771a
                java.lang.CharSequence[] r3 = r10.f3792v
                r9.<init>(r1, r4, r2, r3)
            L_0x006b:
                androidx.appcompat.app.AlertController$f$e r1 = r10.P
                if (r1 == 0) goto L_0x0072
                r1.a(r0)
            L_0x0072:
                r11.H = r9
                int r1 = r10.I
                r11.I = r1
                android.content.DialogInterface$OnClickListener r1 = r10.f3794x
                if (r1 == 0) goto L_0x0085
                androidx.appcompat.app.AlertController$f$c r1 = new androidx.appcompat.app.AlertController$f$c
                r1.<init>(r11)
                r0.setOnItemClickListener(r1)
                goto L_0x0091
            L_0x0085:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.J
                if (r1 == 0) goto L_0x0091
                androidx.appcompat.app.AlertController$f$d r1 = new androidx.appcompat.app.AlertController$f$d
                r1.<init>(r0, r11)
                r0.setOnItemClickListener(r1)
            L_0x0091:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.O
                if (r1 == 0) goto L_0x0098
                r0.setOnItemSelectedListener(r1)
            L_0x0098:
                boolean r1 = r10.H
                if (r1 == 0) goto L_0x00a0
                r0.setChoiceMode(r8)
                goto L_0x00a8
            L_0x00a0:
                boolean r1 = r10.G
                if (r1 == 0) goto L_0x00a8
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00a8:
                r11.f3736g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.f.b(androidx.appcompat.app.AlertController):void");
        }
    }

    public static final class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<DialogInterface> f3809a;

        public g(DialogInterface dialogInterface) {
            this.f3809a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == -3 || i11 == -2 || i11 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f3809a.get(), message.what);
            } else if (i11 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i11, int i12, CharSequence[] charSequenceArr) {
            super(context, i11, i12, charSequenceArr);
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, e eVar, Window window) {
        this.f3730a = context;
        this.f3731b = eVar;
        this.f3732c = window;
        this.R = new g(eVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.f3733d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        eVar.supportRequestWindowFeature(1);
    }

    public static boolean B(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void g(View view, View view2, View view3) {
        int i11 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i11 = 4;
            }
            view3.setVisibility(i11);
        }
    }

    public final void A() {
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f3732c.findViewById(R$id.parentPanel);
        int i11 = R$id.topPanel;
        View findViewById4 = findViewById3.findViewById(i11);
        int i12 = R$id.contentPanel;
        View findViewById5 = findViewById3.findViewById(i12);
        int i13 = R$id.buttonPanel;
        View findViewById6 = findViewById3.findViewById(i13);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R$id.customPanel);
        y(viewGroup);
        View findViewById7 = viewGroup.findViewById(i11);
        View findViewById8 = viewGroup.findViewById(i12);
        View findViewById9 = viewGroup.findViewById(i13);
        ViewGroup j11 = j(findViewById7, findViewById4);
        ViewGroup j12 = j(findViewById8, findViewById5);
        ViewGroup j13 = j(findViewById9, findViewById6);
        x(j12);
        w(j13);
        z(j11);
        char c11 = 0;
        boolean z11 = viewGroup.getVisibility() != 8;
        boolean z12 = (j11 == null || j11.getVisibility() == 8) ? false : true;
        boolean z13 = (j13 == null || j13.getVisibility() == 8) ? false : true;
        if (!(z13 || j12 == null || (findViewById2 = j12.findViewById(R$id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z12) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f3735f == null && this.f3736g == null)) {
                view = j11.findViewById(R$id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(j12 == null || (findViewById = j12.findViewById(R$id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f3736g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z12, z13);
        }
        if (!z11) {
            View view2 = this.f3736g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                if (z13) {
                    c11 = 2;
                }
                r(j12, view2, z12 | c11 ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f3736g;
        if (listView2 != null && (listAdapter = this.H) != null) {
            listView2.setAdapter(listAdapter);
            int i14 = this.I;
            if (i14 > -1) {
                listView2.setItemChecked(i14, true);
                listView2.setSelection(i14);
            }
        }
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public Button c(int i11) {
        if (i11 == -3) {
            return this.f3752w;
        }
        if (i11 == -2) {
            return this.f3748s;
        }
        if (i11 != -1) {
            return null;
        }
        return this.f3744o;
    }

    public int d(int i11) {
        TypedValue typedValue = new TypedValue();
        this.f3730a.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f3736g;
    }

    public void f() {
        this.f3731b.setContentView(k());
        A();
    }

    public boolean h(int i11, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean i(int i11, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public final ViewGroup j(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final int k() {
        int i11 = this.K;
        if (i11 == 0) {
            return this.J;
        }
        if (this.Q == 1) {
            return i11;
        }
        return this.J;
    }

    public void l(int i11, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i11, onClickListener);
        }
        if (i11 == -3) {
            this.f3753x = charSequence;
            this.f3754y = message;
            this.f3755z = drawable;
        } else if (i11 == -2) {
            this.f3749t = charSequence;
            this.f3750u = message;
            this.f3751v = drawable;
        } else if (i11 == -1) {
            this.f3745p = charSequence;
            this.f3746q = message;
            this.f3747r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m(int i11) {
        this.Q = i11;
    }

    public void n(View view) {
        this.G = view;
    }

    public void o(int i11) {
        this.C = null;
        this.B = i11;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i11 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }

    public void p(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void q(CharSequence charSequence) {
        this.f3735f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void r(ViewGroup viewGroup, View view, int i11, int i12) {
        View findViewById = this.f3732c.findViewById(R$id.scrollIndicatorUp);
        View findViewById2 = this.f3732c.findViewById(R$id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            h0.S0(view, i11, i12);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i11 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i11 & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.f3735f != null) {
                this.A.setOnScrollChangeListener(new b(findViewById, findViewById2));
                this.A.post(new c(findViewById, findViewById2));
                return;
            }
            ListView listView = this.f3736g;
            if (listView != null) {
                listView.setOnScrollListener(new d(findViewById, findViewById2));
                this.f3736g.post(new e(findViewById, findViewById2));
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
        }
    }

    public void s(CharSequence charSequence) {
        this.f3734e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void t(int i11) {
        this.f3737h = null;
        this.f3738i = i11;
        this.f3743n = false;
    }

    public void u(View view) {
        this.f3737h = view;
        this.f3738i = 0;
        this.f3743n = false;
    }

    public void v(View view, int i11, int i12, int i13, int i14) {
        this.f3737h = view;
        this.f3738i = 0;
        this.f3743n = true;
        this.f3739j = i11;
        this.f3740k = i12;
        this.f3741l = i13;
        this.f3742m = i14;
    }

    public final void w(ViewGroup viewGroup) {
        boolean z11;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.f3744o = button;
        button.setOnClickListener(this.S);
        boolean z12 = true;
        if (!TextUtils.isEmpty(this.f3745p) || this.f3747r != null) {
            this.f3744o.setText(this.f3745p);
            Drawable drawable = this.f3747r;
            if (drawable != null) {
                int i11 = this.f3733d;
                drawable.setBounds(0, 0, i11, i11);
                this.f3744o.setCompoundDrawables(this.f3747r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f3744o.setVisibility(0);
            z11 = true;
        } else {
            this.f3744o.setVisibility(8);
            z11 = false;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.f3748s = button2;
        button2.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f3749t) || this.f3751v != null) {
            this.f3748s.setText(this.f3749t);
            Drawable drawable2 = this.f3751v;
            if (drawable2 != null) {
                int i12 = this.f3733d;
                drawable2.setBounds(0, 0, i12, i12);
                this.f3748s.setCompoundDrawables(this.f3751v, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f3748s.setVisibility(0);
            z11 |= true;
        } else {
            this.f3748s.setVisibility(8);
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.f3752w = button3;
        button3.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f3753x) || this.f3755z != null) {
            this.f3752w.setText(this.f3753x);
            Drawable drawable3 = this.f3755z;
            if (drawable3 != null) {
                int i13 = this.f3733d;
                drawable3.setBounds(0, 0, i13, i13);
                this.f3752w.setCompoundDrawables(this.f3755z, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f3752w.setVisibility(0);
            z11 |= true;
        } else {
            this.f3752w.setVisibility(8);
        }
        if (B(this.f3730a)) {
            if (z11) {
                b(this.f3744o);
            } else if (z11) {
                b(this.f3748s);
            } else if (z11) {
                b(this.f3752w);
            }
        }
        if (!z11) {
            z12 = false;
        }
        if (!z12) {
            viewGroup.setVisibility(8);
        }
    }

    public final void x(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f3732c.findViewById(R$id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f3735f;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.A.removeView(this.F);
            if (this.f3736g != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.A);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f3736g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    public final void y(ViewGroup viewGroup) {
        View view = this.f3737h;
        boolean z11 = false;
        if (view == null) {
            view = this.f3738i != 0 ? LayoutInflater.from(this.f3730a).inflate(this.f3738i, viewGroup, false) : null;
        }
        if (view != null) {
            z11 = true;
        }
        if (!z11 || !a(view)) {
            this.f3732c.setFlags(131072, 131072);
        }
        if (z11) {
            FrameLayout frameLayout = (FrameLayout) this.f3732c.findViewById(R$id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f3743n) {
                frameLayout.setPadding(this.f3739j, this.f3740k, this.f3741l, this.f3742m);
            }
            if (this.f3736g != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void z(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f3732c.findViewById(R$id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f3732c.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f3734e)) || !this.P) {
            this.f3732c.findViewById(R$id.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f3732c.findViewById(R$id.alertTitle);
        this.E = textView;
        textView.setText(this.f3734e);
        int i11 = this.B;
        if (i11 != 0) {
            this.D.setImageResource(i11);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
            return;
        }
        this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
        this.D.setVisibility(8);
    }
}
