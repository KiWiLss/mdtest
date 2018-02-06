package com.magicsoft.mdtest.behavior;

import android.animation.Animator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;

import com.magicsoft.mdtest.utils.DensityUtils;

public class SearchScrollBehavior extends CoordinatorLayout.Behavior<View> {

    private int searchPaneHeight = 0;//搜索框的高度
    private boolean isAnimate;//动画是否在进行
    private Context ctx;

    public SearchScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {

        if (child.getVisibility() == View.VISIBLE && searchPaneHeight == 0) {
            //获取控件高度
            searchPaneHeight = DensityUtils.dp2px(ctx, child.getHeight());
        }

        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;//判断是否竖直滚动
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        //dy大于0是向上滚动 小于0是向下滚动
        if (dy >= 0 && !isAnimate && child.getVisibility() == View.VISIBLE) {
            showSearch(child, false);
        } else if (dy < 0 && !isAnimate && child.getVisibility() == View.GONE) {
            showSearch(child, true);
        }
    }

    private void showSearch(final View searchPane, boolean visible) {
        if (searchPane == null) {
            return;
        }
        float translationY = searchPane.getTranslationY();
        if (!visible) {
            //show -> hide
            if (translationY < 0 || isAnimate) {
                return;
            }
            //L.d("hide, searchPaneHeight" + searchPaneHeight);
            ViewPropertyAnimator animator = searchPane.animate()
                    .translationY(-searchPaneHeight)
                    .setDuration(800)
                    .setInterpolator(new DecelerateInterpolator())
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            isAnimate = true;
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            searchPane.setVisibility(View.GONE);
                            isAnimate = false;
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                            showSearch(searchPane, true);
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
            animator.start();

        } else {
            //hide -> show
            if (translationY >= 0 || isAnimate) {
                return;
            }
            //L.d("show, searchPaneHeight" + searchPaneHeight);

            ViewPropertyAnimator animator = searchPane.animate()
                    .translationY(0)
                    .setDuration(500)
                    .setInterpolator(new DecelerateInterpolator())
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            searchPane.setVisibility(View.VISIBLE);
                            isAnimate = true;
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            isAnimate = false;
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                            showSearch(searchPane, false);
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
            animator.start();
        }
    }
}

