package com.cars;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cars.CustomListViewAdapter;
import com.cars.RowItem;
import com.cars.R;

public class SearchResults extends Activity implements OnClickListener {

	TextView name, brand, price, mileage, engCapacity, noOfCylinders,valves, maxPower,
			maxTorque, fuelType, gndClearance, powSteering, adjSteering,
			seatingCapacity, abs, transmissionType, noOfAirbags, alloyWheels,
			bodyStyle, bluetooth, colors, electricOVRM, fogLights,
			powerWindows, rearAC, rearWiper;
	private ImageView imgHeaderIcon = null;

	private ListView listView;
	private List<RowItem> rowItems;

	private byte[] byteArray = null;
	private Bitmap bitmap;
	private DBHelper entry;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchresults);

		name = (TextView) findViewById(R.id.name);
		brand = (TextView) findViewById(R.id.brand);
		price= (TextView) findViewById(R.id.price);
		mileage= (TextView) findViewById(R.id.mileage);
		engCapacity= (TextView) findViewById(R.id.engCapacity);
		noOfCylinders= (TextView) findViewById(R.id.noOfCylinders);
		valves= (TextView) findViewById(R.id.valves);
		maxPower= (TextView) findViewById(R.id.maxPower);
		maxTorque= (TextView) findViewById(R.id.maxTorque);
		fuelType= (TextView) findViewById(R.id.fuelType);
		gndClearance= (TextView) findViewById(R.id.gndClearance);
		powSteering= (TextView) findViewById(R.id.powSteering);
		adjSteering= (TextView) findViewById(R.id.adjSteering);
		seatingCapacity= (TextView) findViewById(R.id.seatingCapacity);
		abs= (TextView) findViewById(R.id.abs);
		transmissionType= (TextView) findViewById(R.id.transmissionType);
		noOfAirbags= (TextView) findViewById(R.id.noOfAirbags);
		alloyWheels= (TextView) findViewById(R.id.alloyWheels);
		bodyStyle= (TextView) findViewById(R.id.bodyStyle);
		bluetooth= (TextView) findViewById(R.id.bluetooth);
		colors= (TextView) findViewById(R.id.colors);
		electricOVRM= (TextView) findViewById(R.id.electricOVRM);
		fogLights= (TextView) findViewById(R.id.fogLights);
		powerWindows= (TextView) findViewById(R.id.powerWindows);
		rearAC= (TextView) findViewById(R.id.rearAC);
		rearWiper= (TextView) findViewById(R.id.rearWiper);
		
		imgHeaderIcon = new ImageView(getApplicationContext());
		

		imgHeaderIcon = (ImageView) findViewById(R.id.headericon);
	
		imgHeaderIcon.setOnClickListener(this);
	

		entry = new DBHelper(SearchResults.this);
		entry.openForRead();
		Cursor c = entry.getSearchReults();

		
		rowItems = new ArrayList<RowItem>();
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

			
			String sname = c.getString(c.getColumnIndex("NAME"));
			String sbrand = c.getString(c.getColumnIndex("BRAND"));
			String sprice = c.getString(c.getColumnIndex("PRICE"));
			String smileage = c.getString(c.getColumnIndex("MILEAGE"));
			String sengCapacity = c.getString(c.getColumnIndex("ENGINE_CAPACITY"));
			String snoOfCylinders = c.getString(c.getColumnIndex("NO_OF_CYLINDERS"));
			String svalves = c.getString(c.getColumnIndex("VALVES_PER_CYLINDER"));
			String smaxPower = c.getString(c.getColumnIndex("MAX_POWER"));
			String smaxTorque = c.getString(c.getColumnIndex("MAX_TORQUE"));
			String sfuelType = c.getString(c.getColumnIndex("FUEL_TYPE"));
			String sgndClearance = c.getString(c.getColumnIndex("GROUND_CLEARANCE"));
			String spowSteering = c.getString(c.getColumnIndex("POWER_STEERING"));
			String sadjSteering = c.getString(c.getColumnIndex("ADJUSTABLE_STEERING_COLUMN"));
			String sseatingCapacity = c.getString(c.getColumnIndex("SEATING_CAPACITY"));
			String sabs = c.getString(c.getColumnIndex("ABS"));
			String stransmissionType = c.getString(c.getColumnIndex("TRANSMISSION_TYPE"));
			String snoOfAirbags = c.getString(c.getColumnIndex("NO_OF_AIRBAGS"));
			String salloyWheels = c.getString(c.getColumnIndex("ALLOY_WHEELS"));
			String sbodyStyle = c.getString(c.getColumnIndex("BODY_STYLE"));
			String sbluetooth = c.getString(c.getColumnIndex("BLUETOOTH"));
			String scolors = c.getString(c.getColumnIndex("COLORS"));
			String selectricOVRM = c.getString(c.getColumnIndex("ELECTRIC_ORVM"));
			String sfogLights = c.getString(c.getColumnIndex("FOG_LIGHTS"));
			String spowerWindows = c.getString(c.getColumnIndex("POWER_WINDOWS"));
			String srearAC = c.getString(c.getColumnIndex("REAR_AC_VENT"));
			String srearWiper = c.getString(c.getColumnIndex("REAR_MIRROR"));
			
			
			byteArray = null;
			bitmap = null;
			byteArray = c.getBlob(c.getColumnIndex("IMAGE")); /* This line gets the image's blob data */
			
			bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
					byteArray.length);

			RowItem item = new RowItem(bitmap,sname, sbrand, sprice, smileage, sengCapacity,
					snoOfCylinders, svalves, smaxPower, smaxTorque, sfuelType, sgndClearance,
					spowSteering, sadjSteering, sseatingCapacity, sabs, stransmissionType,
					snoOfAirbags, salloyWheels, sbodyStyle, sbluetooth, scolors,
					selectricOVRM, sfogLights, spowerWindows, srearAC, srearWiper);

			rowItems.add(item);

			listView = (ListView) findViewById(R.id.listView1);
			CustomListViewAdapter adapter = new CustomListViewAdapter(this,
					R.layout.searchdata, rowItems);
			listView.setAdapter(adapter);

		}
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.headericon) {
		Intent ihome = new Intent(getApplicationContext(),
					HomePg.class);
			startActivity(ihome);			
		}
	}
	
	@Override
	public void onBackPressed() {
		entry.close();
		SearchResults.this.finish();
	}
}
