package com.clark.basemodel.view.canvas_analysis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/**
 * Created By Clark
 * Description :
 *
 * @date 2019/5/8.
 */
public class CanvasAnalysisView extends View {

    public CanvasAnalysisView(Context context) {
        this(context, null);
    }

    public CanvasAnalysisView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasAnalysisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.BLACK);
        canvas.drawColor(Color.parseColor("#88880000"));
    }
}
