package com.example.masks;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MaskDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MaskDB.db";

    //Move Table
    public static final String MOVE_TABLE_NAME = "moves";
    public static final String MOVE_TABLE_ID = "move_id";
    public static final String MOVE_TABLE_TITLE = "title";
    public static final String MOVE_TABLE_MOVE_TYPE = "move_type"; //T - Team, G - Group, P - Playbook, B - Basic, A - Adult

    //Playbook Move Table
    public static final String PLAYBOOK_MOVE_TABLE_NAME = "playbook_moves";
    public static final String PLAYBOOK_MOVE_TABLE_MOVE_ID = "move_id";
    public static final String PLAYBOOK_MOVE_TABLE_PLAYBOOK_ID = "playbook_id";

    //Move Text Table
    public static final String MOVE_TEXT_TABLE_NAME = "move_texts";
    public static final String MOVE_TEXT_MOVE_ID = "move_id";
    public static final String MOVE_TEXT_ORDER_NUM = "order_num";
    public static final String MOVE_TEXT_TEXT = "text";
    public static final String MOVE_TEXT_TYPE = "type";

    //Condition Table
    public static final String CONDITION_TABLE_NAME = "conditions";
    public static final String CONDITION_TABLE_ID = "condition_id";
    public static final String CONDITION_TABLE_TITLE = "title";
    public static final String CONDITION_TABLE_DESC = "desc";

    //Condition Move Table
    public static final String CONDITION_MOVE_TABLE_NAME = "condition_move";
    public static final String CONDITION_MOVE_TABLE_MOVE_ID = "move_id";
    public static final String CONDITION_MOVE_TABLE_CONDITION_ID = "condition_id";
    public static final String CONDITION_MOVE_TABLE_MODIFIER = "move_modifier";

    //Label Table
    public static final String LABEL_TABLE_NAME = "labels";
    public static final String LABEL_TABLE_ID = "label_id";
    public static final String LABEL_TABLE_TITLE = "title";
    public static final String LABEL_TABLE_DESC = "desc";

    //Move Labels Table
    public static final String MOVE_LABELS_TABLE_NAME = "move_labels";
    public static final String MOVE_LABELS_TABLE_MOVE_ID = "move_id";
    public static final String MOVE_LABELS_TABLE_LABEL_ID = "label_id";

    //Playbook Table
    public static final String PLAYBOOK_TABLE_NAME = "playbooks";
    public static final String PLAYBOOK_TABLE_ID = "id";
    public static final String PLAYBOOK_TABLE_TITLE = "title";
    public static final String PLAYBOOK_TABLE_MOMENT_OF_TRUTH = "moment_of_truth";

    //Advancement Table
    public static final String ADVANCE_TABLE_NAME = "advancements";
    public static final String ADVANCE_TABLE_ID = "id";
    public static final String ADVANCE_TABLE_DESC = "desc";
    public static final String ADVANCE_TABLE_LEVEL = "level"; //L - Lesser, G - Greater

    //Playbook Advancement Table
    public static final String PLAYBOOK_ADVANCE_TABLE_NAME = "playbook_advancements";
    public static final String PLAYBOOK_ADVANCE_TABLE_PLAYBOOK_ID = "playbook_id";
    public static final String PLAYBOOK_ADVANCE_TABLE_ADVANCE_ID = "advance_id";
    public static final String PLAYBOOK_ADVANCE_TABLE_ADVANCE_NUM = "advance_num"; //usually 1, some playbooks have an advance more than 1 time, this counts up to them.

    public MaskDB(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
