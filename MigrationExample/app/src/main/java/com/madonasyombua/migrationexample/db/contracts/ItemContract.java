package com.madonasyombua.migrationexample.db.contracts;

import android.provider.BaseColumns;


/**
 * @author madona
 */

public class ItemContract  {


    //  Create an inner class named Item_Entry class that implements the BaseColumns interface
    public class ItemEntry implements BaseColumns{


        //Inside create a static final members for the table name and each of the db columns

        public static final String TABLE_NAME = "item_table";
        public static final String COLUMN_ITEM_ONE = "item_one";
        public static final String COLUMN_ITEM_TWO = "item_two";
        public static final String COLUMN_ITEM_THREE = "item_three";

    }

}
