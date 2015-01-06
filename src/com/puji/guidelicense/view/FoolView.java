package com.puji.guidelicense.view;

import com.puji.guidelicense.R;
import com.puji.guidelicense.R.styleable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class FoolView extends View {

	private String mFloorLetterText = "F";
	private String mFloorNumberText = "1";

	private int mFloorLetterSize = 24;
	private int mFloorNumberSize = 12;

	private int mFloorLetterColor = Color.WHITE;
	private int mFloorNumberColor = Color.WHITE;

	Paint mTextPaint = new Paint();

	public void setText(String text) {

		if (text != null && text.length() > 0) {
			mFloorLetterText = text.substring(0, 1);
			mFloorNumberText = text.substring(1, text.length());
			invalidate();
		}

	}

	public int getFloorLetterSize() {
		return mFloorLetterSize;
	}

	public void setFloorLetterSize(int mFloorLetterSize) {
		this.mFloorLetterSize = mFloorLetterSize;
	}

	public int getFloorNumberSize() {
		return mFloorNumberSize;
	}

	public void setFloorNumberSize(int mFloorNumberSize) {
		this.mFloorNumberSize = mFloorNumberSize;
	}

	public int getFloorLetterColor() {
		return mFloorLetterColor;
	}

	public void setFloorLetterColor(int mFloorLetterColor) {
		this.mFloorLetterColor = mFloorLetterColor;
	}

	public int getFloorNumberColor() {
		return mFloorNumberColor;
	}

	public void setFloorNumberColor(int mFloorNumberColor) {
		this.mFloorNumberColor = mFloorNumberColor;
	}

	public FoolView(Context context) {
		super(context);
		init();
	}

	public FoolView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public FoolView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.GuideLicense, defStyleAttr, 0);

		try {
			mFloorLetterSize = a.getDimensionPixelSize(
					R.styleable.GuideLicense_letterSize, 24);
			mFloorNumberSize = a.getDimensionPixelSize(
					R.styleable.GuideLicense_numberSize, 12);
			mFloorLetterColor = a.getColor(
					R.styleable.GuideLicense_letterColor, Color.WHITE);
			mFloorNumberColor = a.getColor(
					R.styleable.GuideLicense_numberColor, Color.WHITE);
		} finally {
			a.recycle();
		}

	}

	private void init() {
		initPaint();
	}

	private void initPaint() {

		mTextPaint.setAntiAlias(true);
		mTextPaint.setDither(true);

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int h = getFontHeight(mFloorLetterSize, mFloorLetterText)
				+ getFontHeight(mFloorNumberSize, mFloorNumberText);
		int w = getFontWidth(mFloorLetterSize, mFloorLetterText)
				+ getFontWidth(mFloorNumberSize, mFloorNumberText);
		setMeasuredDimension(w, h);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mTextPaint.setTextSize(mFloorLetterSize);
		mTextPaint.setColor(Color.WHITE);
		canvas.drawText(mFloorLetterText, 0,
				getFontHeight(mFloorLetterSize, mFloorLetterText)
						+ getFontHeight(mFloorNumberSize, mFloorNumberText),
				mTextPaint);

		mTextPaint.setTextSize(mFloorNumberSize);
		mTextPaint.setColor(mFloorNumberColor);
		canvas.drawText(mFloorNumberText,
				getFontWidth(mFloorLetterSize, mFloorLetterText),
				getFontHeight(mFloorNumberSize, mFloorNumberText), mTextPaint);
	}

	/**
	 * 得到字体高度
	 * 
	 * @param fontSize
	 * @return
	 */
	private int getFontHeight(float fontSize, String content) {
		Paint paint = new Paint();
		paint.setTextSize(fontSize);
		Rect rect = new Rect();
		paint.getTextBounds(content, 0, content.length(), rect);
		return rect.height();

	}

	/**
	 * 得到文字的宽度
	 * 
	 * @return
	 */
	private int getFontWidth(float fontSize, String content) {
		Paint paint = new Paint();
		paint.setTextSize(fontSize);
		return (int) paint.measureText(content);
	}

}
