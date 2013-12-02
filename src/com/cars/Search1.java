package com.cars;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.data.CarData;
import com.cars.R;

public class Search1 extends Activity implements OnClickListener,
		OnItemSelectedListener {

	Spinner spinBrand = null;

	Button btnReset, btnSearch;
	
	List<String> brandLabels;
	
	DBHelper entry = null;
	
	public Search1(){
		CarData.SPIN_BRAND = null;
		CarData.SPIN_MODEL = null;		
	}

	@Override
	public void onCreate(Bundle savedInstanceState)

	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search1);
		spinBrand = (Spinner) findViewById(R.id.spinBrand);
		
		btnSearch = (Button) findViewById(R.id.btnSearchHm);
		btnReset = (Button) findViewById(R.id.btnResetHm);

		

		entry = new DBHelper(Search1.this);
		entry.openForRead();

		brandLabels = entry.getBrands();
		ArrayAdapter<String> brandAdapter = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.spinnertext, brandLabels);
		brandAdapter
				.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		spinBrand.setAdapter(brandAdapter);

		
		btnSearch.setOnClickListener(this);
		btnReset.setOnClickListener(this);
		

		spinBrand.setOnItemSelectedListener(this);
		

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnSearchHm:
			Intent iSearch = new Intent(getApplicationContext(),
					SearchResults.class);
			startActivity(iSearch);
			break;
		case R.id.btnResetHm:
			CarData.SPIN_BRAND = null;
			CarData.SPIN_MODEL = null;
			onCreate(null);
			break;
		
		}
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.spinBrand:
			CarData.SPIN_BRAND = arg0.getSelectedItem().toString();
			break;
		}

	}
	
	
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void onBackPressed() {
		entry.close();
		Search1.this.finish();	
	}
}