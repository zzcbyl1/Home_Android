package com.example.android_listview;

import android.R.anim;
import android.R.integer;
import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	private ListView myLV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myLV = (ListView) findViewById(android.R.id.list);

		/*
		 * String[] data = new String[] { "11111", "2222", "3333" };
		 * 
		 * ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		 * android.R.layout.simple_expandable_list_item_1, data);
		 * 
		 * myLV.setAdapter(adapter);
		 */

		Cursor c = getContentResolver().query(Contacts.CONTENT_URI, null, null,
				null, Contacts.DISPLAY_NAME + " ASC");
		startManagingCursor(c);

		String[] strArr = new String[] { Contacts.DISPLAY_NAME };
		int[] cols = new int[] { android.R.id.text1 };
		ListAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_expandable_list_item_1, c, strArr, cols);

		myLV.setAdapter(adapter); // this.setListAdapter(adapter);

		setContentView(myLV);

	}
}
