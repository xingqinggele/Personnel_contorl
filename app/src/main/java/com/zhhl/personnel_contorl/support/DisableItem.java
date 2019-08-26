package com.zhhl.personnel_contorl.support;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


import com.zhhl.personnel_contorl.R;

import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

public class DisableItem extends FrameLayout {

    private int position;
    private boolean removed;
    private FrameLayout mRoot;
    private String TAG = getClass().getSimpleName();

    private DisableItem.OnDismissListener dismiss;

    public DisableItem(Context context) {
        this(context, null);
    }

    public DisableItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DisableItem(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public DisableItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initContent(attrs);
//        measure(0,0);
    }


    public void setOnDismissListener(OnDismissListener listener) {
        this.dismiss = listener;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void show() {
        resume(0);
    }

    public interface OnDismissListener {
        void dismissed(DisableItem disableItem);
    }

    private void initContent(AttributeSet attrs) {
        mRoot = (FrameLayout) View.inflate(getContext(), R.layout.item_wrapper, null);
        addView(mRoot, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        if (attrs != null) {
            TypedArray arrays = getContext().obtainStyledAttributes(attrs, R.styleable.DisableItem);
            int resourceId = arrays.getResourceId(R.styleable.DisableItem_layout, -1);
            if (resourceId != -1) {
                View.inflate(getContext(), resourceId, mRoot);
            }
            Log.e(TAG, "initContent: " + resourceId);
            arrays.recycle();
        }
    }


    private int dx;

    //    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return (ev.isFromSource(InputDevice.SOURCE_MOUSE)
//                && ev.getAction() == MotionEvent.ACTION_DOWN) ||
//                (ev.isFromSource(InputDevice.SOURCE_MOUSE)
//                        && ev.getAction() == MotionEvent.ACTION_MOVE);
//
//    }
    private boolean enabled = false;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (enabled)
            switch (ev.getAction()) {
                case ACTION_DOWN:
                    dx = (int) ev.getX();
                    break;
                case ACTION_MOVE:
                    int mx = (int) ev.getX();
                    if (dx - mx > 0) {
                        changePos(mx - dx);
                    } else if (dx - mx < 0) {
                        changePos(mx - dx);
                    }

                    break;
                case ACTION_UP:
                    int ux = (int) ev.getX();
                    if (Math.abs(dx - ux) > getWidth() / 2) {
                        clear(ux - dx);
                        return true;
                    } else {
                        resume(ux - dx);
                    }
                    break;
                case ACTION_CANCEL:
                    int cx = (int) ev.getX();
                    resume(cx - dx);

                    break;
            }


        return super.onTouchEvent(ev);
    }

    private void resume(int offset) {
        Log.e(TAG, "resume: " + offset);
        ValueAnimator resume = ValueAnimator.ofInt(offset, 0);
        resume.setDuration(500);
        resume.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                mRoot.setTranslationX(animatedValue);
            }
        });
        resume.start();
    }

    private void clear(int offset) {
//        Log.e(TAG, "clear: "+offset );
        ValueAnimator clear = ValueAnimator.ofInt(offset, offset > 0 ? getWidth() : -getWidth());
        clear.setDuration(500);
        clear.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                mRoot.setTranslationX(animatedValue);
            }
        });

        clear.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                ValueAnimator rm = ValueAnimator.ofInt(getHeight(), 0);
                rm.setDuration(500);
                rm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        ViewGroup.LayoutParams layoutParams = getLayoutParams();
                        layoutParams.height = (int) animation.getAnimatedValue();
                        setLayoutParams(layoutParams);
                    }
                });
                rm.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        removed = true;
                        if (dismiss != null) {
                            dismiss.dismissed(DisableItem.this);
                        }
                    }
                });
                rm.start();
            }
        });
        clear.start();
    }

    private void changePos(int abs) {
        Log.e(TAG, "changeMarginStart: " + abs);
        mRoot.setTranslationX(abs);
    }

}
