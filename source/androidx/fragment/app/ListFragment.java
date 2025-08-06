package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public final Handler f9662b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f9663c = new a();

    /* renamed from: d  reason: collision with root package name */
    public final AdapterView.OnItemClickListener f9664d = new b();

    /* renamed from: e  reason: collision with root package name */
    public ListAdapter f9665e;

    /* renamed from: f  reason: collision with root package name */
    public ListView f9666f;

    /* renamed from: g  reason: collision with root package name */
    public View f9667g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f9668h;

    /* renamed from: i  reason: collision with root package name */
    public View f9669i;

    /* renamed from: j  reason: collision with root package name */
    public View f9670j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f9671k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f9672l;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ListView listView = ListFragment.this.f9666f;
            listView.focusableViewAvailable(listView);
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            ListFragment.this.qh((ListView) adapterView, view, i11, j11);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, (AttributeSet) null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void onDestroyView() {
        this.f9662b.removeCallbacks(this.f9663c);
        this.f9666f = null;
        this.f9672l = false;
        this.f9670j = null;
        this.f9669i = null;
        this.f9667g = null;
        this.f9668h = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ph();
    }

    public final void ph() {
        if (this.f9666f == null) {
            View view = getView();
            if (view != null) {
                if (view instanceof ListView) {
                    this.f9666f = (ListView) view;
                } else {
                    TextView textView = (TextView) view.findViewById(16711681);
                    this.f9668h = textView;
                    if (textView == null) {
                        this.f9667g = view.findViewById(16908292);
                    } else {
                        textView.setVisibility(8);
                    }
                    this.f9669i = view.findViewById(16711682);
                    this.f9670j = view.findViewById(16711683);
                    View findViewById = view.findViewById(16908298);
                    if (findViewById instanceof ListView) {
                        ListView listView = (ListView) findViewById;
                        this.f9666f = listView;
                        View view2 = this.f9667g;
                        if (view2 != null) {
                            listView.setEmptyView(view2);
                        } else {
                            CharSequence charSequence = this.f9671k;
                            if (charSequence != null) {
                                this.f9668h.setText(charSequence);
                                this.f9666f.setEmptyView(this.f9668h);
                            }
                        }
                    } else if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    } else {
                        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                    }
                }
                this.f9672l = true;
                this.f9666f.setOnItemClickListener(this.f9664d);
                ListAdapter listAdapter = this.f9665e;
                if (listAdapter != null) {
                    this.f9665e = null;
                    rh(listAdapter);
                } else if (this.f9669i != null) {
                    sh(false, false);
                }
                this.f9662b.post(this.f9663c);
                return;
            }
            throw new IllegalStateException("Content view not yet created");
        }
    }

    public void qh(ListView listView, View view, int i11, long j11) {
    }

    public void rh(ListAdapter listAdapter) {
        boolean z11 = false;
        boolean z12 = this.f9665e != null;
        this.f9665e = listAdapter;
        ListView listView = this.f9666f;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (!this.f9672l && !z12) {
                if (requireView().getWindowToken() != null) {
                    z11 = true;
                }
                sh(true, z11);
            }
        }
    }

    public final void sh(boolean z11, boolean z12) {
        ph();
        View view = this.f9669i;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.f9672l != z11) {
            this.f9672l = z11;
            if (z11) {
                if (z12) {
                    view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                    this.f9670j.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                } else {
                    view.clearAnimation();
                    this.f9670j.clearAnimation();
                }
                this.f9669i.setVisibility(8);
                this.f9670j.setVisibility(0);
                return;
            }
            if (z12) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                this.f9670j.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
            } else {
                view.clearAnimation();
                this.f9670j.clearAnimation();
            }
            this.f9669i.setVisibility(0);
            this.f9670j.setVisibility(8);
        }
    }
}
