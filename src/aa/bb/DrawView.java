package aa.bb;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawView extends View implements OnTouchListener {
    List<Point> points = new ArrayList<Point>();
    static Paint paint = new Paint();
    
    final static int SMALL = 5;
    final static int MEDIUM = 10;
    final static int LARGE = 20;
    
    
    static int size = SMALL;

    public DrawView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);

        this.setOnTouchListener(this);

        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
    }

    
    public void onDraw(Canvas canvas) {
        for (Point point : points) {
            canvas.drawCircle(point.x, point.y, point.size, point.color);
        }
    }

    public boolean onTouch(View view, MotionEvent event) {
        Point point = new Point();
        Paint color = new Paint();
        color.setColor(paint.getColor());
        point.x = event.getX();
        point.y = event.getY();
        point.size = size;
        point.color= color;
        points.add(point);
        invalidate();
        return true;
    }
}

class Point {
	float x, y;
	Paint color;
	int size;
}
