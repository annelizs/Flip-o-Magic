package aa.bb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Draw extends Activity {
	DrawView drawView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		drawView = new DrawView(this);
		setContentView(drawView);
		drawView.requestFocus();
		drawView.setBackgroundColor(Color.WHITE);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mainmenu, menu);
		return true;
	} 

	public boolean onOptionsItemSelected(MenuItem item) {
		final ImageView image = (ImageView)findViewById(R.id.ImageView01);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("Pick an Image!")
		.setMessage("Please Select Image One or Image Two:")
		.setCancelable(false)

		.setPositiveButton("IMAGE 1", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				image.setImageResource(R.drawable.image1);
			}
		})

		.setNegativeButton("IMAGE 2", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				image.setImageResource(R.drawable.image2);
			}
		});
	

		switch (item.getItemId()) {
		// color submenu
		case R.id.red:
			DrawView.paint.setColor(Color.RED);
			return true;
		case R.id.orange:
			DrawView.paint.setColor(Color.rgb(255, 200, 0));
			return true;
		case R.id.yellow:
			DrawView.paint.setColor(Color.YELLOW);
			return true;
		case R.id.green:
			DrawView.paint.setColor(Color.GREEN);
			return true;
		case R.id.blue:
			DrawView.paint.setColor(Color.BLUE);
			return true;
		case R.id.indigo:
			DrawView.paint.setColor(Color.rgb(111, 0, 255));
			return true;
		case R.id.violet:
			DrawView.paint.setColor(Color.rgb(143, 0, 255));
			return true;
		case R.id.black:
			DrawView.paint.setColor(Color.BLACK);
			return true;
		case R.id.white:
			DrawView.paint.setColor(Color.WHITE);
			return true;
		
		// size submenu
		case R.id.small:
			DrawView.size=DrawView.SMALL;
			return true;
		case R.id.medium:
			DrawView.size=DrawView.MEDIUM;
			return true;
		case R.id.large:
			DrawView.size=DrawView.LARGE;
			return true;
		case R.id.buttonthree:
			drawView.setBackgroundColor(Color.WHITE);
			return true;
		case R.id.buttonfour:
			drawView.setBackgroundColor(Color.BLACK);
			return true;
		case R.id.buttonfive:
			builder.show();        
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}