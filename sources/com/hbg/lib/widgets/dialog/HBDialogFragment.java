package com.hbg.lib.widgets.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import i6.r;
import java.util.HashMap;
import java.util.Map;

public class HBDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, View.OnClickListener> f71859b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnDismissListener f71860c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71861d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f71862e;

    /* renamed from: f  reason: collision with root package name */
    public int f71863f;

    /* renamed from: g  reason: collision with root package name */
    public a f71864g;

    public interface a {
        void a(View view, HBDialogFragment hBDialogFragment);
    }

    public HBDialogFragment() {
    }

    public static HBDialogFragment uh(int i11, a aVar) {
        HBDialogFragment hBDialogFragment = new HBDialogFragment(aVar);
        Bundle bundle = new Bundle();
        bundle.putInt("arg_layout_res", i11);
        hBDialogFragment.setArguments(bundle);
        return hBDialogFragment;
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return this.f71863f;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
    }

    public boolean isFullScreen() {
        return false;
    }

    public boolean isTransparent() {
        return false;
    }

    public void onAttach(Context context) {
        try {
            super.onAttach(context);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f71863f = arguments.getInt("arg_layout_res");
        }
        View inflate = layoutInflater.inflate(this.f71863f, viewGroup);
        a aVar = this.f71864g;
        if (aVar != null) {
            aVar.a(inflate, this);
        }
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f71860c;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public void onResume() {
        super.onResume();
        View view = getView();
        if (this.f71859b.size() > 0 && view != null) {
            for (Integer next : this.f71859b.keySet()) {
                View findViewById = view.findViewById(next.intValue());
                if (findViewById != null) {
                    findViewById.setOnClickListener(this.f71859b.get(next));
                }
            }
        }
        if (getDialog() != null) {
            getDialog().setCanceledOnTouchOutside(this.f71861d);
            if (this.f71862e != null) {
                getDialog().setOnCancelListener(this.f71862e);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z11) {
        this.f71861d = z11;
        if (getDialog() != null) {
            getDialog().setCanceledOnTouchOutside(z11);
        }
    }

    public void sh() {
        if (getDialog() != null) {
            getDialog().cancel();
        }
    }

    public boolean th() {
        if (getDialog() != null) {
            return getDialog().isShowing();
        }
        return isAdded();
    }

    public void vh(DialogInterface.OnCancelListener onCancelListener) {
        this.f71862e = onCancelListener;
        if (getDialog() != null && onCancelListener != null) {
            getDialog().setOnCancelListener(onCancelListener);
        }
    }

    public void wh(DialogInterface.OnDismissListener onDismissListener) {
        this.f71860c = onDismissListener;
    }

    public void xh(int i11, View.OnClickListener onClickListener) {
        View findViewById;
        this.f71859b.put(Integer.valueOf(i11), onClickListener);
        View view = getView();
        if (view != null && (findViewById = view.findViewById(i11)) != null) {
            findViewById.setOnClickListener(onClickListener);
        }
    }

    public HBDialogFragment(a aVar) {
        this.f71864g = aVar;
    }
}
