package cn.xuzhijun.proportional;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * 作者：徐智军
 * 创建时间：2016年11月10日 13:40
 */

public class ProportionalImageView extends AppCompatImageView {

	private float widthScale;
	private float heightScale;

	public ProportionalImageView(Context context) {
		super(context);
	}

	public ProportionalImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}

	public ProportionalImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(attrs);
	}

	private void init(AttributeSet attributeSet) {
		if (attributeSet != null) {
			TypedArray array = getContext().obtainStyledAttributes(attributeSet, R.styleable.ScaleLayout);
			widthScale = array.getFloat(R.styleable.ScaleLayout_scaleWidth, -1);
			heightScale = array.getFloat(R.styleable.ScaleLayout_scaleHeight, 1);
			array.recycle();
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);

		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);

		int widthParam  = getLayoutParams().width;
		int heightParam = getLayoutParams().height;

		if (widthScale > 0 && heightScale > 0) {
			if (widthParam != ViewGroup.LayoutParams.WRAP_CONTENT) {
				heightSize = (int) (widthSize / widthScale * heightScale);
				heightMode = MeasureSpec.EXACTLY;
			} else if (heightParam != ViewGroup.LayoutParams.WRAP_CONTENT) {
				widthSize = (int) (heightSize / heightScale * widthScale);
				widthMode = MeasureSpec.EXACTLY;
			}
		}
		super.onMeasure(MeasureSpec.makeMeasureSpec(widthSize, widthMode), MeasureSpec.makeMeasureSpec(heightSize, heightMode));
	}

	public float getWidthScale() {
		return widthScale;
	}

	public void setWidthScale(float widthScale) {
		this.widthScale = widthScale;
	}

	public float getHeightScale() {
		return heightScale;
	}

	public void setHeightScale(float heightScale) {
		this.heightScale = heightScale;
	}
}
