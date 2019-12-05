package com.madonasyombua.migrationexample.db.contracts;

import android.provider.BaseColumns;


/**
 * @author madona
 */

public class ItemContract  {


    //  Create an inner class named Item_Entry class that implements the BaseColumns interface
    public class ItemEntry implements BaseColumns{


        public static final String TABLE_NAME = "item_table";
        public static final String item = "item_id";
        public static final String item1 = "item1";
        public static final String item2 = "item2";


    }

}
