package zendesk.support.guide;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.h0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.guide.sdk.R$attr;
import com.zendesk.guide.sdk.R$color;
import com.zendesk.guide.sdk.R$dimen;
import com.zendesk.guide.sdk.R$drawable;
import com.zendesk.guide.sdk.R$id;
import com.zendesk.guide.sdk.R$layout;
import com.zendesk.guide.sdk.R$string;
import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;
import lz.a;
import zendesk.support.ArticleVote;
import zendesk.support.ArticleVoteStorage;
import zendesk.support.HelpCenterProvider;

class ArticleVotingView extends RelativeLayout {
    /* access modifiers changed from: private */
    public Long articleId;
    /* access modifiers changed from: private */
    public ArticleVote articleVote;
    /* access modifiers changed from: private */
    public ArticleVoteStorage articleVoteStorage;
    private ImageButton downvoteButton;
    private ViewGroup downvoteButtonFrame;
    private HelpCenterProvider helpCenterProvider;
    private ImageButton upvoteButton;
    private ViewGroup upvoteButtonFrame;

    /* renamed from: zendesk.support.guide.ArticleVotingView$6  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$zendesk$support$guide$ArticleVotingView$VoteState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                zendesk.support.guide.ArticleVotingView$VoteState[] r0 = zendesk.support.guide.ArticleVotingView.VoteState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$zendesk$support$guide$ArticleVotingView$VoteState = r0
                zendesk.support.guide.ArticleVotingView$VoteState r1 = zendesk.support.guide.ArticleVotingView.VoteState.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$zendesk$support$guide$ArticleVotingView$VoteState     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.support.guide.ArticleVotingView$VoteState r1 = zendesk.support.guide.ArticleVotingView.VoteState.UPVOTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$zendesk$support$guide$ArticleVotingView$VoteState     // Catch:{ NoSuchFieldError -> 0x0028 }
                zendesk.support.guide.ArticleVotingView$VoteState r1 = zendesk.support.guide.ArticleVotingView.VoteState.DOWNVOTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.support.guide.ArticleVotingView.AnonymousClass6.<clinit>():void");
        }
    }

    public enum VoteState {
        UPVOTED,
        DOWNVOTED,
        NONE;

        public static VoteState fromArticleVote(ArticleVote articleVote) {
            if (articleVote == null || articleVote.getValue() == null) {
                return NONE;
            }
            int intValue = articleVote.getValue().intValue();
            if (intValue > 0) {
                return UPVOTED;
            }
            if (intValue < 0) {
                return DOWNVOTED;
            }
            return NONE;
        }
    }

    public ArticleVotingView(Context context) {
        super(context);
        setupViews(context);
    }

    private GradientDrawable buildButtonBackground(Context context, int i11) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.zs_help_voting_button_border_corner_radius);
        int color = ContextCompat.getColor(context, R$color.zs_help_voting_button_border);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.zs_help_voting_button_border_width);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable.setColor(i11);
        gradientDrawable.setStroke(dimensionPixelSize2, color);
        return gradientDrawable;
    }

    private ColorStateList colorStateList(int i11, int i12) {
        return new ColorStateList(new int[][]{new int[]{16843518}, new int[]{16842919}, new int[0]}, new int[]{i11, i11, i12});
    }

    /* access modifiers changed from: private */
    public void downvoteArticle() {
        if (this.articleId == null) {
            Logger.l(ViewArticleActivity.LOG_TAG, "Cannot downvote article, articleId is null. Make sure you've called bindTo()!", new Object[0]);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("hcp == null -> ");
        sb2.append(this.helpCenterProvider == null);
        Logger.d(ViewArticleActivity.LOG_TAG, sb2.toString(), new Object[0]);
        this.helpCenterProvider.downvoteArticle(this.articleId, new ZendeskCallback<ArticleVote>() {
            public void onError(a aVar) {
                Logger.b(ViewArticleActivity.LOG_TAG, "Failed to downvote article. " + aVar, new Object[0]);
                ArticleVotingView articleVotingView = ArticleVotingView.this;
                articleVotingView.announceForAccessibility(articleVotingView.getResources().getString(R$string.zs_view_article_voted_failed_accessibility_announce));
                ArticleVotingView articleVotingView2 = ArticleVotingView.this;
                articleVotingView2.updateButtons(VoteState.fromArticleVote(articleVotingView2.articleVote));
                ArticleVotingView.this.setVotingButtonsClickable(true);
            }

            public void onSuccess(ArticleVote articleVote) {
                Logger.b(ViewArticleActivity.LOG_TAG, "Successfully downvoted article!", new Object[0]);
                ArticleVote unused = ArticleVotingView.this.articleVote = articleVote;
                ArticleVotingView articleVotingView = ArticleVotingView.this;
                articleVotingView.announceForAccessibility(articleVotingView.getResources().getString(R$string.zs_view_article_voted_no_accessibility_announce));
                ArticleVotingView.this.articleVoteStorage.storeArticleVote(ArticleVotingView.this.articleId, articleVote);
                ArticleVotingView.this.setVotingButtonsClickable(true);
            }
        });
    }

    private StateListDrawable getVotingButtonBackground(int i11) {
        GradientDrawable buildButtonBackground = buildButtonBackground(getContext(), i11);
        GradientDrawable buildButtonBackground2 = buildButtonBackground(getContext(), -1);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16843518}, buildButtonBackground);
        stateListDrawable.addState(new int[]{16842919}, buildButtonBackground);
        stateListDrawable.addState(new int[0], buildButtonBackground2);
        return stateListDrawable;
    }

    /* access modifiers changed from: private */
    public void removeVote() {
        if (this.articleId == null) {
            Logger.l(ViewArticleActivity.LOG_TAG, "Article vote was null, could not remove vote", new Object[0]);
        } else if (this.articleVote.getId() != null) {
            this.helpCenterProvider.deleteVote(this.articleVote.getId(), new ZendeskCallback<Void>() {
                public void onError(a aVar) {
                    Logger.b(ViewArticleActivity.LOG_TAG, "Failed to remove vote. " + aVar.getResponseBody() + "\n" + aVar.getResponseBodyType() + "\n" + aVar.getUrl(), new Object[0]);
                    ArticleVotingView articleVotingView = ArticleVotingView.this;
                    articleVotingView.updateButtons(VoteState.fromArticleVote(articleVotingView.articleVote));
                    ArticleVotingView.this.setVotingButtonsClickable(true);
                }

                public void onSuccess(Void voidR) {
                    Logger.b(ViewArticleActivity.LOG_TAG, "Successfully removed vote!", new Object[0]);
                    ArticleVote unused = ArticleVotingView.this.articleVote = null;
                    ArticleVotingView.this.articleVoteStorage.removeStoredArticleVote(ArticleVotingView.this.articleId);
                    ArticleVotingView.this.setVotingButtonsClickable(true);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setVotingButtonsClickable(boolean z11) {
        this.upvoteButton.setClickable(z11);
        this.downvoteButton.setClickable(z11);
    }

    private void setupViews(Context context) {
        LayoutInflater.from(context).inflate(R$layout.zs_view_article_voting, this);
        this.upvoteButtonFrame = (ViewGroup) findViewById(R$id.upvote_button_frame);
        this.upvoteButton = (ImageButton) findViewById(R$id.upvote_button);
        this.downvoteButtonFrame = (ViewGroup) findViewById(R$id.downvote_button_frame);
        this.downvoteButton = (ImageButton) findViewById(R$id.downvote_button);
        int themeAttributeToColor = UiUtils.themeAttributeToColor(R$attr.colorPrimary, getContext(), R$color.zs_fallback_text_color);
        themeVotingButton(this.upvoteButton, R$drawable.zs_ic_thumb_up, themeAttributeToColor);
        themeVotingButton(this.downvoteButton, R$drawable.zs_ic_thumb_down, themeAttributeToColor);
        this.upvoteButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                VoteState voteState;
                ArticleVotingView.this.setVotingButtonsClickable(false);
                if (ArticleVotingView.this.articleVote == null || ArticleVotingView.this.articleVote.getValue() == null || !ArticleVotingView.this.articleVote.getValue().equals(1)) {
                    voteState = VoteState.UPVOTED;
                    ArticleVotingView.this.upvoteArticle();
                } else {
                    voteState = VoteState.NONE;
                    ArticleVotingView.this.removeVote();
                }
                ArticleVotingView.this.updateButtons(voteState);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.downvoteButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                VoteState voteState;
                ArticleVotingView.this.setVotingButtonsClickable(false);
                if (ArticleVotingView.this.articleVote == null || ArticleVotingView.this.articleVote.getValue() == null || !ArticleVotingView.this.articleVote.getValue().equals(-1)) {
                    voteState = VoteState.DOWNVOTED;
                    ArticleVotingView.this.downvoteArticle();
                } else {
                    voteState = VoteState.NONE;
                    ArticleVotingView.this.removeVote();
                }
                ArticleVotingView.this.updateButtons(voteState);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void themeVotingButton(ImageButton imageButton, int i11, int i12) {
        h0.B0(imageButton, getVotingButtonBackground(i12));
        Drawable r11 = u0.a.r(ContextCompat.getDrawable(getContext(), i11));
        u0.a.o(r11, colorStateList(-1, i12));
        u0.a.p(r11, PorterDuff.Mode.SRC_IN);
        imageButton.setImageDrawable(r11);
    }

    /* access modifiers changed from: private */
    public void updateButtons(VoteState voteState) {
        if (voteState == VoteState.NONE) {
            this.upvoteButtonFrame.setActivated(false);
            this.downvoteButtonFrame.setActivated(false);
        } else if (voteState == VoteState.UPVOTED) {
            this.upvoteButtonFrame.setActivated(true);
            this.downvoteButtonFrame.setActivated(false);
        } else if (voteState == VoteState.DOWNVOTED) {
            this.upvoteButtonFrame.setActivated(false);
            this.downvoteButtonFrame.setActivated(true);
        }
        updateContentDesc(voteState);
    }

    private void updateContentDesc(VoteState voteState) {
        int i11 = AnonymousClass6.$SwitchMap$zendesk$support$guide$ArticleVotingView$VoteState[voteState.ordinal()];
        if (i11 == 1) {
            this.upvoteButton.setContentDescription(getResources().getString(R$string.zs_view_article_vote_yes_accessibility));
            this.downvoteButton.setContentDescription(getResources().getString(R$string.zs_view_article_vote_no_accessibility));
        } else if (i11 == 2) {
            this.upvoteButton.setContentDescription(getResources().getString(R$string.zs_view_article_vote_no_remove_accessibility));
            this.downvoteButton.setContentDescription(getResources().getString(R$string.zs_view_article_vote_no_accessibility));
        } else if (i11 != 3) {
            Logger.b(ViewArticleActivity.LOG_TAG, "Unhandled voteState case", new Object[0]);
        } else {
            this.upvoteButton.setContentDescription(getResources().getString(R$string.zs_view_article_vote_yes_accessibility));
            this.downvoteButton.setContentDescription(getResources().getString(R$string.zs_view_article_vote_yes_remove_accessibility));
        }
    }

    /* access modifiers changed from: private */
    public void upvoteArticle() {
        Long l11 = this.articleId;
        if (l11 == null) {
            Logger.l(ViewArticleActivity.LOG_TAG, "Cannot upvote article, articleId is null. Make sure you've called bindTo()!", new Object[0]);
        } else {
            this.helpCenterProvider.upvoteArticle(l11, new ZendeskCallback<ArticleVote>() {
                public void onError(a aVar) {
                    Logger.b(ViewArticleActivity.LOG_TAG, "Failed to upvote article. " + aVar, new Object[0]);
                    ArticleVotingView articleVotingView = ArticleVotingView.this;
                    articleVotingView.announceForAccessibility(articleVotingView.getResources().getString(R$string.zs_view_article_voted_failed_accessibility_announce));
                    ArticleVotingView articleVotingView2 = ArticleVotingView.this;
                    articleVotingView2.updateButtons(VoteState.fromArticleVote(articleVotingView2.articleVote));
                    ArticleVotingView.this.setVotingButtonsClickable(true);
                }

                public void onSuccess(ArticleVote articleVote) {
                    Logger.b(ViewArticleActivity.LOG_TAG, "Successfully upvoted article!", new Object[0]);
                    ArticleVote unused = ArticleVotingView.this.articleVote = articleVote;
                    ArticleVotingView articleVotingView = ArticleVotingView.this;
                    articleVotingView.announceForAccessibility(articleVotingView.getResources().getString(R$string.zs_view_article_voted_yes_accessibility_announce));
                    ArticleVotingView.this.articleVoteStorage.storeArticleVote(ArticleVotingView.this.articleId, articleVote);
                    ArticleVotingView.this.setVotingButtonsClickable(true);
                }
            });
        }
    }

    public void bindTo(Long l11, ArticleVoteStorage articleVoteStorage2, HelpCenterProvider helpCenterProvider2) {
        this.articleVoteStorage = articleVoteStorage2;
        this.helpCenterProvider = helpCenterProvider2;
        this.articleId = l11;
        if (l11 != null) {
            ArticleVote storedArticleVote = articleVoteStorage2.getStoredArticleVote(l11);
            this.articleVote = storedArticleVote;
            updateButtons(VoteState.fromArticleVote(storedArticleVote));
        }
    }

    public ArticleVotingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setupViews(context);
    }

    public ArticleVotingView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setupViews(context);
    }
}
