package com.lokesh.customgrid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by LCHOW08 on 2/14/2017.
 */

public class DrawDividers extends View {

    private Paint       paint = null;
    private int         offsetValue = 16;
    private int         startX = offsetValue;
    private int         startY = offsetValue;
    private int         viewWidth = 0;
    private int         viewHeight = 0;

    public DrawDividers(Context context, AttributeSet attr) {
        super(context, attr);
        paint = new Paint();
        paint.setStrokeWidth(5f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            viewHeight = getMeasuredHeight() - offsetValue;
            viewWidth = getResources().getDisplayMetrics().widthPixels - offsetValue;

            // Divider lines
            canvas.drawLine(startX, startY, viewWidth, startY, paint);
            canvas.drawLine(startX, startY, startX, viewHeight, paint);
            canvas.drawLine(startX, viewHeight / 2, viewWidth, viewHeight / 2, paint);
            canvas.drawLine(viewWidth / 2, startY, viewWidth / 2, viewHeight, paint);
            canvas.drawLine(startX, viewHeight, viewWidth, viewHeight, paint);
            canvas.drawLine(viewWidth, startY, viewWidth, viewHeight, paint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void invalidateView() {
        invalidate();
    }
}
