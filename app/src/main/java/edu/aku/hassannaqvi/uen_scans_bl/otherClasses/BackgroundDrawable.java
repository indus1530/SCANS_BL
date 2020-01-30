package edu.aku.hassannaqvi.uen_scans_bl.otherClasses;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/**
 * Created by Hassan.naqvi on 4/22/2017.
 */

public class BackgroundDrawable extends Drawable implements Runnable, Animatable {
    private static final long FRAME_DELAY = 1000 / 60;
    private boolean mRunning = false;
    private long mStartTime;
    private int mDuration = 1000;

    private Paint mPaint;
    private int mStripes = 7;


    private void init() {
        if (mPaint == null) {
            mPaint = new Paint();
            mPaint.setColor(Color.WHITE);
            mPaint.setAntiAlias(true);
            mPaint.setStyle(Paint.Style.FILL);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (isRunning()) {
            // animation in progress
            final int save = canvas.save();

            long timeDiff = SystemClock.uptimeMillis() - mStartTime;
            canvas.clipRect(bounds);

            float progress = ((float) timeDiff) / ((float) mDuration); // 0..1

            float width = bounds.width() / (mStripes * 2);
            for (int i = 0; i < mStripes * 2 + 2; i++) {
                mPaint.setColor(i % 2 == 0 ? Color.RED : Color.WHITE);

                canvas.drawRect(bounds.left + width * (i - 1) + progress * 2 * width, bounds.top, bounds.left + width * i + progress * 2 * width, bounds.bottom, mPaint);
            }

            canvas.restoreToCount(save);
        } else {
            // todo draw normal
        }
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        init();
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }

    @Override
    public void start() {
        if (mRunning) stop();
        mRunning = true;
        mStartTime = SystemClock.uptimeMillis();
        invalidateSelf();
        scheduleSelf(this, SystemClock.uptimeMillis() + FRAME_DELAY);
    }

    @Override
    public void stop() {
        unscheduleSelf(this);
        mRunning = false;
    }

    @Override
    public boolean isRunning() {
        return mRunning;
    }

    @Override
    public void run() {
        invalidateSelf();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis + FRAME_DELAY < mStartTime + mDuration) {
            scheduleSelf(this, uptimeMillis + FRAME_DELAY);
        } else {
            mRunning = false;
            start();
        }
    }
}