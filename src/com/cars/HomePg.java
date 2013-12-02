package com.cars;

import com.cars.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class HomePg extends Activity implements OnClickListener {

	ImageView imgHeaderIcon, imgAbout, imgSearch, imgSearch1 = null;
	// Drawable icon;

	// this context will use when we work with Alert Dialog
	final Context context = this;

	// just for test, when we click this button, we will see the alert dialog.
	private ImageView imgExit;
	private DBHelper helper;

	@Override
	public void onCreate(Bundle savedInstanceState)

	{
		super.onCreate(savedInstanceState);
		setRequestedOrientation(Configuration.ORIENTATION_PORTRAIT);
		setContentView(R.layout.homepg);

		helper = new DBHelper(getBaseContext());
		helper.openDataBase();

		imgSearch = new ImageView(getApplicationContext());
		imgSearch1 = new ImageView(getApplicationContext());
		imgAbout = new ImageView(getApplicationContext());

		imgHeaderIcon = new ImageView(getApplicationContext());
		imgExit = new ImageView(getApplicationContext());

		// mapping ids of images
		imgSearch = (ImageView) findViewById(R.id.imgsearch);
		imgSearch1 = (ImageView) findViewById(R.id.imgsearch1);
		imgAbout = (ImageView) findViewById(R.id.imgabout);

		imgHeaderIcon = (ImageView) findViewById(R.id.headericon);
		imgExit = (ImageView) findViewById(R.id.exitApp);

		// setting Listeners
		imgHeaderIcon.setOnClickListener(this);
		imgSearch.setOnClickListener(this);
		imgSearch1.setOnClickListener(this);
		imgAbout.setOnClickListener(this);

		imgExit.setOnClickListener(this);

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imgsearch:
			Intent iSearch = new Intent(getApplicationContext(), Search.class);
			startActivity(iSearch);
			break;

		case R.id.imgsearch1:
			Intent iSearch1 = new Intent(getApplicationContext(), Search1.class);
			startActivity(iSearch1);
			break;

		case R.id.imgabout:
			Intent iabout = new Intent(getApplicationContext(), About.class);
			startActivity(iabout);
			break;

		case R.id.headericon:
			onCreate(null);
			break;

		case R.id.exitApp:
			AlertDialog.Builder alert = new AlertDialog.Builder(context);
			alert.setTitle("Exit Application"); // Set Alert dialog title here
			alert.setMessage("Do you want to Exit ?"); // Message here

			alert.setPositiveButton("YES",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							helper.close();
							HomePg.this.finish();
						}
					}); // End of alert.setPositiveButton
			alert.setNegativeButton("NO",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// Canceled.
							dialog.cancel();
						}
					}); // End of alert.setNegativeButton
			AlertDialog alertDialog = alert.create();
			alertDialog.show();
			/* Alert Dialog Code End */
			break;
		}
	}

}
