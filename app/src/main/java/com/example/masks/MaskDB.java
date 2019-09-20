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

    //Data Tables
    public static final String TABLE_NAME_PLAYBOOK = "playbooks";
    public static final String TABLE_NAME_MODULES = "modules;
    public static final String TABLE_NAME_TEXTS = "texts";
    public static final String TABLE_NAME_POWERS = "powers";
    public static final String TABLE_NAME_MOVES = "moves";
    public static final String TABLE_NAME_ADVANCEMENTS = "advancements";
    public static final String TABLE_NAME_ABILITIES = "abilities";
    public static final String TABLE_NAME_LABELS = "labels";
    public static final String TABLE_NAME_CONDITIONS = "conditions";
    public static final String TABLE_NAME_CHARACTER = "characters";
    
    //Relational Tables - Playbooks
    public static final String TABLE_NAME_PLAYBOOK_POWERS = "playbookPowers";
    public static final String TABLE_NAME_PLAYBOOK_ADVANCEMENTS = "playbookAdvancements";
    public static final String TABLE_NAME_PLAYBOOK_ABILITIES = "playbookAbilities";
    public static final String TABLE_NAME_PLAYBOOK_QUESTIONS = "playbookQuestions";
    
    //Relational Tables - Characters
    public static final String TABLE_NAME_CHARACTER_CONDITIONS = "characterConditions";
    public static final String TABLE_NAME_CHARACTER_DESCRIPTIONS = "characterDescriptions";
    public static final String TABLE_NAME_CHARACTER_MODS = "characterMods";
    public static final String TABLE_NAME_CHARACTER_LABELS = "characteLabels";
    public static final String TABLE_NAME_CHARACTER_ADVANCEMENTS = "characterAdvancements";
    public static final String TABLE_NAME_CHARACTER_ABILITIES = "characterAbilities"
    
    //Relational Tables - Powers/Moves
    public static final String TABLE_NAME_POWER_TEXTS = "powerTexts";
    public static final String TABLE_NAME_MOVE_TEXTS = "moveTexts";
    public static final String TABLE_NAME_POWER_MOVES = "powerMoves";
    public static final String TABLE_NAME_POWER_LABELS = "powerLabels";
    public static final String TABLE_NAME_POWER_HOLDS = "powerHolds";
    public static final String TABLE_NAME_POWER_MODS = "powerMods";
    public static final String TABLE_NAME_MOVE_MODS = "moveMods";
    
    //Custom Columns    
    public static final String COLUMN_NAME_MAX_NUM_ABILITIES = "maxNumAbilities";
    public static final String COLUMN_NAME_MIN_NUM_ABILITIES = "minNumAbilities";
    public static final String COLUMN_NAME_NUM_STARTING_MOVES = "numStartingMoves";
        
    //Common Columns
    public static final String COLUMN_NAME_DESC = "desc";
    public static final String COLUMN_NAME_ORDER = "order";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_VALUE = "value";
    public static final String COLUMN_NAME_TYPE = "type";
    
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
