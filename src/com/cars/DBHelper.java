package com.cars;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;

import com.data.CarData;

public class DBHelper extends SQLiteOpenHelper {

	private static final String TABLE_CAR_DETAILS = "CAR_DETAILS";
	public static final String KEY_CAR_ID = "_id";
	private static final String KEY_NAME = "NAME";
	private static final String KEY_BRAND = "BRAND";

	private DBHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;

	private static String DB_PATH = "/data/data/com.cars/databases/";

	private static String DB_NAME = "CARS_DB.db";

	private String selection = "null";
	private boolean flag = false;

	/**
	 * Constructor Takes and keeps a reference of the passed context in order to
	 * access to the application assets and resources.
	 * 
	 * @param context
	 */
	public DBHelper(Context context) {

		super(context, DB_NAME, null, 3);
		this.ourContext = context;
		flag = false;
		// Toast.makeText(ourContext, " Please Enter Correct ClientID",
		// Toast.LENGTH_LONG).show();
	}

	public DBHelper openForWrite() {
		ourHelper = new DBHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}

	public DBHelper openForRead() {
		ourHelper = new DBHelper(ourContext);
		ourDatabase = ourHelper.getReadableDatabase();
		return this;
	}

	public void createDataBase() throws IOException {
		Log.d("SOMETHING", "Content1");
		boolean dbExist = checkDataBase();

		if (dbExist) {
			// do nothing - database already exist
			String myPath = DB_PATH + DB_NAME;
			ourDatabase = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);

		} else {

			// By calling this method an empty database will be created into the
			// default system path
			// of your application so we gonna be able to overwrite that
			// database with our database.
			this.getReadableDatabase();

			try {

				copyDataBase();

			} catch (IOException e) {

				throw new Error("Error copying database");

			}
		}

	}

	private boolean checkDataBase() {
		boolean exist = false;
		SQLiteDatabase checkDB = null;

		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);

		} catch (SQLiteException e) {

			// database does't exist yet.

		}

		if (checkDB != null) {

			checkDB.close();
			exist = true;

		}

		return exist;
	}

	private void copyDataBase() throws IOException {

		// Open your local db as the input stream
		InputStream myInput = ourContext.getAssets().open(DB_NAME);

		// Path to the just created empty db
		String outFileName = DB_PATH + DB_NAME;

		// Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);

		// transfer bytes from the input file to the output file
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}

		// Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();

	}

	public void openDataBase() throws SQLException {
		Log.d("SOMETHING", "Content2");
		// Open the database
		try {
			createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String myPath = DB_PATH + DB_NAME;
		ourDatabase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READONLY);

	}

	@Override
	public synchronized void close() {

		if (ourDatabase != null)
			ourDatabase.close();
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	public List<String> getBrands() {
		// TODO Auto-generated method stub

		List<String> brandLabels = new ArrayList<String>();
		String[] columns = new String[] { KEY_BRAND };
		Cursor c2 = ourDatabase.query(true, TABLE_CAR_DETAILS, columns, null,
				null, null, null, null, null);
		// Cursor
		if (c2.moveToFirst()) {
			brandLabels.add("Select brand");

			do {
				brandLabels.add(c2.getString(c2.getColumnIndex(KEY_BRAND)));
			} while (c2.moveToNext());
		}

		return brandLabels;
	}

	public List<String> getModels() {
		// TODO Auto-generated method stub
		List<String> modelLabels = new ArrayList<String>();
		String[] columns = new String[] { KEY_NAME };
		Cursor c2;
		if (flag) {
			c2 = ourDatabase.query(true, TABLE_CAR_DETAILS, columns, KEY_BRAND
					+ "='" + selection + "'", null, null, null, null, null);
		} else {
			c2 = ourDatabase.query(true, TABLE_CAR_DETAILS, columns, null,
					null, null, null, null, null);
		}
		// Cursor
		if (c2.moveToNext()) {
			modelLabels.add("Select model");

			do {
				modelLabels.add(c2.getString(c2.getColumnIndex(KEY_NAME)));
			} while (c2.moveToNext());
		}

		return modelLabels;
	}

	public Cursor getSearchReults() {
		Cursor c = null;
		if (CarData.SPIN_MODEL == null) {
			c = ourDatabase.query(TABLE_CAR_DETAILS, null, KEY_BRAND + "='"
					+ CarData.SPIN_BRAND + "'", null, null, null, null);
		} else {

			c = ourDatabase.query(TABLE_CAR_DETAILS, null, KEY_BRAND + "='"
					+ CarData.SPIN_BRAND + "' AND " + KEY_NAME + "='"
					+ CarData.SPIN_MODEL + "'", null, null, null, null);
		}
		return c;
	}

	public void setModel(String selection) {
		this.selection = selection;
		flag = true;
	}

	public void setFlag() {
		flag = false;
	}

}
