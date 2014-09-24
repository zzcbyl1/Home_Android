package com.example.android_listview;

import android.R.integer;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MyListViewActivity extends ListActivity {

	private ListView lv;
	private int idCol = -1;
	private int nameCol = -1;
	private int timesContactedCol = -1;
	private Button myBtn;
	private Cursor c;
	private SimpleCursorAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listxml);

		myBtn = (Button) findViewById(R.id.myBtn);
		lv = getListView();
		String[] pro = new String[] { Contacts._ID, Contacts.DISPLAY_NAME };
		c = getContentResolver().query(Contacts.CONTENT_URI, pro, null, null,
				Contacts.DISPLAY_NAME);
		idCol = c.getColumnIndex(Contacts._ID);
		nameCol = c.getColumnIndex(Contacts.DISPLAY_NAME);
		timesContactedCol = c.getColumnIndex(Contacts.TIMES_CONTACTED);

		String[] cols = new String[] { Contacts.DISPLAY_NAME };
		int[] views = new int[] { android.R.id.text1 };
		adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_multiple_choice, c, cols,
				views);
		this.setListAdapter(adapter);
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

		myBtn.setOnClickListener(btnListener);
	}

	private OnClickListener btnListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			/*
			 * int count = lv.getCount(); SparseBooleanArray viewItem =
			 * lv.getCheckedItemPositions(); for (int i = 0; i < count; i++) {
			 * c.moveToPosition(i); long id = c.getLong(idCol); String name =
			 * c.getString(nameCol); int timesContacted =
			 * c.getInt(timesContactedCol);
			 * 
			 * Log.i("---Tag--", "Name=" + name + " ID =" + String.valueOf(id) +
			 * " Times=" + String.valueOf(timesContacted));
			 * 
			 * }
			 */

			if (!adapter.hasStableIds()) {
				Log.i("---tag---", "no data");
				return;
			}

			long[] ids = lv.getCheckedItemIds();
			for (int i = 0; i < ids.length; i++) {
				Uri selectView = ContentUris.withAppendedId(
						Contacts.CONTENT_URI, ids[i]);

				Log.i("--data--", selectView.toString() + " is checked");
			}
		}
	};

}
