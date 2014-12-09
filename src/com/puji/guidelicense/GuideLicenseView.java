package com.puji.guidelicense;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class GuideLicenseView extends View {

	private Paint mPaint = new Paint();
	ArrayList<Floor> mData;

	public GuideLicenseView(Context context) {
		super(context);
		init();
	}

	public GuideLicenseView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public GuideLicenseView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void initPaint() {

		mPaint.setColor(Color.WHITE);
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Style.FILL);
		mPaint.setStrokeWidth(5);
		mPaint.setDither(true);

	}

	private void init() {
		initPaint();
	}

	public void bindData(ArrayList<Floor> data) {
		mData = data;
		invalidate();
	}

	/**
	 * 得到文字的宽度
	 * 
	 * @return
	 */
	private int getFontWidth(float fontSize, String str) {
		Paint paint = new Paint();
		paint.setTextSize(fontSize);
		return (int) paint.measureText(str);
	}

	/**
	 * 得到字体高度
	 * 
	 * @param fontSize
	 * @return
	 */
	private int getFontHeight(float fontSize, String str) {
		Paint paint = new Paint();
		paint.setTextSize(fontSize);
		Rect rect = new Rect();
		paint.getTextBounds(str, 0, str.length(), rect);
		return rect.height();

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		if (mData != null) {
			for (int i = 0; i < mData.size(); i++) {

				canvas.drawLine(0, 20 * i, getWidth(), 20 * i, mPaint);
			}
		}

	}

	private int calculateFontSize(String str, int column) {

		int fontWidth = 0;
		int fontHeight = 0;

		int mid = 0;
		int min = 1;
		int max = 500;

		mid = min + max / 2;

		while (getFontHeight(mid, str) <= getWidth()) {

			min = mid;
			mid = (min + max) / 2;

		}

		for (int i = 1; i <= 1000; i++) {
			if (getFontWidth(1000 - i, str) <= getWidth()) {

				fontWidth = 1000 - i;
				break;
			}
		}

		for (int i = 1; i <= 1000; i++) {

			if (getFontHeight(1000 - i, str) * column <= getHeight()) {
				fontHeight = 1000 - i;
				break;
			}

		}

		System.out.println(fontWidth > fontHeight ? fontHeight : fontWidth);
		return fontWidth > fontHeight ? fontHeight : fontWidth;
	}

}
