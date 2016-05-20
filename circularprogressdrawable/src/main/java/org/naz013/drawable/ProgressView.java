/*
 * Copyright (C) 2016 Nazar Suhovich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.naz013.drawable;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class ProgressView extends ImageView {

    private CircularDrawable mDrawable;
    private AnimatorSet mAnimationSet;

    public ProgressView(Context context) {
        super(context);
        init(context, null);
    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        int strokeWidth = getResources().getDimensionPixelSize(R.dimen.drawable_ring_size);
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
        mDrawable = new CircularDrawable(strokeWidth, getColor(R.color.colorRed), getColor(R.color.colorYellow),
                getColor(R.color.colorGreen), getColor(R.color.colorBlue), getColor(R.color.colorRedA),
                getColor(R.color.colorYellowA), getColor(R.color.colorGreenA), b, typeface);
        setBackground(mDrawable);
        initAnimation();
    }

    public boolean isRunning() {
        return mAnimationSet.isRunning();
    }

    public void startAnimation() {
        if (!mAnimationSet.isRunning()) {
            mAnimationSet.start();
        }
    }

    public void stopAnimation() {
        if (mAnimationSet.isRunning()) {
            mAnimationSet.cancel();
        }
    }

    private void initAnimation() {
        mAnimationSet = new AnimatorSet();
        ObjectAnimator progressAnimation = ObjectAnimator.ofFloat(mDrawable, CircularDrawable.C_1,
                1f, 0f);
        progressAnimation.setDuration(1900);
        progressAnimation.setRepeatCount(ObjectAnimator.INFINITE);
        progressAnimation.setInterpolator(new LinearInterpolator());

        ObjectAnimator progressAnimation2 = ObjectAnimator.ofFloat(mDrawable, CircularDrawable.C_2,
                0f, 1f);
        progressAnimation2.setDuration(1700);
        progressAnimation2.setRepeatCount(ObjectAnimator.INFINITE);
        progressAnimation2.setInterpolator(new LinearInterpolator());

        ObjectAnimator progressAnimation3 = ObjectAnimator.ofFloat(mDrawable, CircularDrawable.C_3,
                1f, 0f);
        progressAnimation3.setDuration(1300);
        progressAnimation3.setRepeatCount(ObjectAnimator.INFINITE);
        progressAnimation3.setInterpolator(new LinearInterpolator());

        mAnimationSet.playTogether(progressAnimation, progressAnimation2, progressAnimation3);
    }

    private int getColor(int res) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getResources().getColor(res, null);
        } else {
            return getResources().getColor(res);
        }
    }
}
