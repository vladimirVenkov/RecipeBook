package venkov.vladimir.recipebook.views.customView;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

import venkov.vladimir.recipebook.R;

public class CustomBookView extends View {

    private static final int PADDING = 27;
    private Bitmap mImage;

    public CustomBookView(Context context) {
        super(context);
        init(null);
    }

    public CustomBookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomBookView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomBookView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        int orientation = this.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            mImage = BitmapFactory.decodeResource(getResources(), R.drawable.art);
        } else {
            mImage = BitmapFactory.decodeResource(getResources(), R.drawable.unsplash);
        }


       getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
           @Override
           public void onGlobalLayout() {
               getViewTreeObserver().removeOnGlobalLayoutListener(this);
               mImage = getResizedImage(mImage, getWidth() - PADDING , getHeight() - PADDING);
           }
       });

    }

    private Bitmap getResizedImage(Bitmap image, int width, int height) {
        Matrix matrix = new Matrix();
        RectF src = new RectF(0, 0, image.getWidth(), image.getHeight());
        RectF dest = new RectF(0, 0, width, height);

        matrix.setRectToRect(src, dest, Matrix.ScaleToFit.CENTER);

        return Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float imageX = (getWidth() - mImage.getWidth()) / 2;
        float imageY = (getHeight() - mImage.getHeight()) / 2;
        canvas.drawBitmap(mImage, imageX, imageY, null);
    }
}
