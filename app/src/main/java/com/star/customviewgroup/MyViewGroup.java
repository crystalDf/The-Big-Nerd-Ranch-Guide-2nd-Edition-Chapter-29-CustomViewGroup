package com.star.customviewgroup;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MyViewGroup extends ViewGroup {

    private static final String TAG = "MyViewGroup";

    private Context mContext;

    public MyViewGroup(Context context) {
        super(context);

        mContext = context;

        init();
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int childCount = getChildCount();

        Log.i(TAG, "the size of this ViewGroup is ----> " + childCount) ;

        Log.i(TAG, "***** onMeasure() start *****") ;

        int measureSpecWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureSpecHeight = MeasureSpec.getSize(heightMeasureSpec);

        Log.i(TAG, "***** widthMeasureSpec " + widthMeasureSpec +
                " * heightMeasureSpec   *****" + heightMeasureSpec) ;

        Log.i(TAG, "***** measureSpecWidth " + measureSpecWidth +
                " * measureSpecHeight   *****" + measureSpecHeight) ;

        setMeasuredDimension(measureSpecWidth, measureSpecHeight);

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);

            child.measure(50, 50);
        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int childCount = getChildCount();

        int startLeft = 0;
        int startTop = 10;

        Log.i(TAG, "***** onLayout() start *****") ;

        for (int i = 0; i < childCount; i++) {

            Log.i(TAG, "***** onLayout startLeft *****" + startLeft) ;

            View child = getChildAt(i);

            child.layout(startLeft, startTop, startLeft + child.getMeasuredWidth(),
                    startTop + child.getMeasuredHeight());

            startLeft += child.getMeasuredWidth() + 10;

        }

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        Log.i(TAG, "***** dispatchDraw() start *****") ;
    }

    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {

        Log.i(TAG, "***** drawChild() start *****") ;

        return super.drawChild(canvas, child, drawingTime);
    }

    private void init() {

        Button button = new Button(mContext);
        button.setText("I'm a Button");

        this.addView(button);

        ImageView imageView = new ImageView(mContext);
        imageView.setBackgroundResource(R.mipmap.ic_launcher);

        this.addView(imageView);

        TextView textView = new TextView(mContext);
        textView.setText("Only Text");

        this.addView(textView);

        MyView myView = new MyView(mContext);
        this.addView(myView);
    }

}
