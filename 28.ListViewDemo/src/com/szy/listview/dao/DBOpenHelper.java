package com.szy.listview.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author  coolszy
 * @blog    http://blog.csdn.net/coolszy
 */
public class DBOpenHelper extends SQLiteOpenHelper
{
	private static final int VERSION = 1;
	private static final String DBNAME = "data.db";
	private static final String PERSON="t_person";
	
	public DBOpenHelper(Context context)
	{
		super(context, DBNAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL("create table "+PERSON+" (_id varchar(4) primary key,pname varchar(20),pgender varchar(2))");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1001','����','��')");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1002','����','��')");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1003','����','Ů')");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1004','��Ǯ','��')");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1005','����','Ů')");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1006','����','��')");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1007','֣��','��')");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1008','���','��')");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1009','����','Ů')");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1010','����','��')");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1011','����','��')");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1012','����','��')");
		db.execSQL("insert into t_person (_id, pname, pgender) values ('1013','����','��')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		
	}
}
