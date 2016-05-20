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

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class CircularDrawable extends Drawable {

    public static final int PROGRESS_FACTOR = -360;
    public static final String C_1 = "circle1";
    public static final String C_2 = "circle2";
    public static final String C_3 = "circle3";
    public static final String TAG = "ProgressDrawable";

    private final Paint paint;
    protected float circle1;
    protected float circle2;
    protected float circle3;
    protected final RectF arcElements;
    protected final RectF arcElements2;
    protected final RectF arcElements3;
    protected final int ringWidth;
    protected final int ringWidth2;
    protected final int ringWidth3;
    protected final int ringColor;
    protected final int ringColor2;
    protected final int ringColor3;
    protected final int outlineColor;
    protected final int outlineColor2;
    protected final int outlineColor3;
    protected int centerColor;
    private Bitmap mDroid;
    private Typeface mTypeface;

    public CircularDrawable(int ringWidth, int ringColor, int ringColor2, int ringColor3, int centerColor,
                            int outlineColor, int outlineColor2, int outlineColor3, Bitmap droid, Typeface typeface) {
        this.circle1 = 0;
        this.circle1 = 45;
        this.circle1 = 135;
        this.centerColor = centerColor;
        this.outlineColor = outlineColor;
        this.outlineColor2 = outlineColor2;
        this.outlineColor3 = outlineColor3;
        this.ringColor = ringColor;
        this.ringColor2 = ringColor2;
        this.ringColor3 = ringColor3;
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.ringWidth = ringWidth;
        this.ringWidth2 = ((int) (ringWidth * 0.8));
        this.ringWidth3 = ((int) (ringWidth * 0.6));
        this.arcElements = new RectF();
        this.arcElements2 = new RectF();
        this.arcElements3 = new RectF();
        this.mDroid = droid;
        this.mTypeface = typeface;
    }

    @Override
    public void draw(Canvas canvas) {
        final Rect bounds = getBounds();

        int size3 = Math.min((int) (bounds.height() * 0.6), (int) (bounds.width() * 0.6));
        float outerRadius3 = (size3 / 2) - (ringWidth3 / 2);
        float offsetX3 = (bounds.width() - outerRadius3 * 2) / 2;
        float offsetY3 = (bounds.height() - outerRadius3 * 2) / 2;

        int halfRingWidth3 = ringWidth3 / 2;
        float arcX03 = offsetX3 + halfRingWidth3;
        float arcY03 = offsetY3 + halfRingWidth3;
        float arcX3 = offsetX3 + outerRadius3 * 2 - halfRingWidth3;
        float arcY3 = offsetY3 + outerRadius3 * 2 - halfRingWidth3;

        //Draw blue circle
        float innerRadius = outerRadius3 * 0.5f;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(centerColor);
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), innerRadius, paint);

        //Draw transparent circle
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ringWidth3 * 2);
        paint.setColor(outlineColor3);
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), outerRadius3, paint);

        // Outer Circle
        paint.setColor(ringColor3);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ringWidth3 * 2);
        paint.setStrokeCap(Paint.Cap.ROUND);
        arcElements3.set(arcX03, arcY03, arcX3, arcY3);
        canvas.drawArc(arcElements3, circle3, 45, false, paint);


        int size2 = Math.min((int) (bounds.height() * 0.8), (int) (bounds.width() * 0.8));
        float outerRadius2 = (size2 / 2) - (ringWidth2 / 2);
        float offsetX2 = (bounds.width() - outerRadius2 * 2) / 2;
        float offsetY2 = (bounds.height() - outerRadius2 * 2) / 2;

        int halfRingWidth2 = ringWidth2 / 2;
        float arcX02 = offsetX2 + halfRingWidth2;
        float arcY02 = offsetY2 + halfRingWidth2;
        float arcX2 = offsetX2 + outerRadius2 * 2 - halfRingWidth2;
        float arcY2 = offsetY2 + outerRadius2 * 2 - halfRingWidth2;

        //Draw transparent circle
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ringWidth2 * 2);
        paint.setColor(outlineColor2);
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), outerRadius2, paint);

        // Outer Circle
        paint.setColor(ringColor2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ringWidth2 * 2);
        paint.setStrokeCap(Paint.Cap.ROUND);
        arcElements2.set(arcX02, arcY02, arcX2, arcY2);
        canvas.drawArc(arcElements2, circle2, 75, false, paint);

        int size = Math.min(bounds.height(), bounds.width());
        float outerRadius = (size / 2) - (ringWidth / 2);
        float offsetX = (bounds.width() - outerRadius * 2) / 2;
        float offsetY = (bounds.height() - outerRadius * 2) / 2;

        int halfRingWidth = ringWidth / 2;
        float arcX0 = offsetX + halfRingWidth;
        float arcY0 = offsetY + halfRingWidth;
        float arcX = offsetX + outerRadius * 2 - halfRingWidth;
        float arcY = offsetY + outerRadius * 2 - halfRingWidth;

        //Draw transparent circle
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ringWidth * 2);
        paint.setColor(outlineColor);
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), outerRadius, paint);

        // Outer Circle
        paint.setColor(ringColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ringWidth * 2);
        paint.setStrokeCap(Paint.Cap.ROUND);
        arcElements.set(arcX0, arcY0, arcX, arcY);
        canvas.drawArc(arcElements, circle1, 135, false, paint);

        float rad = innerRadius * 0.5f;
        Bitmap tmp = Bitmap.createScaledBitmap(mDroid, (int ) (rad * 2), (int) (rad * 2), true);
        canvas.drawBitmap(tmp, bounds.centerX() - rad, bounds.centerY() - rad, paint);
    }

    public float getCircle1() {
        return circle1 / PROGRESS_FACTOR;
    }

    public float getCircle2() {
        return circle2 / PROGRESS_FACTOR;
    }

    public float getCircle3() {
        return circle3 / PROGRESS_FACTOR;
    }

    public void setCircle1(float circle1) {
        this.circle1 = circle1 * PROGRESS_FACTOR;
        invalidateSelf();
    }

    public void setCircle2(float circle2) {
        this.circle2 = circle2 * PROGRESS_FACTOR;
        invalidateSelf();
    }

    public void setCircle3(float circle3) {
        this.circle3 = circle3 * PROGRESS_FACTOR;
        invalidateSelf();
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return 1 - paint.getAlpha();
    }
}
