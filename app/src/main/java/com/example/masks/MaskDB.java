package com.example.masks;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MaskDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MaskDB.db";

    //Primary Key Table Names
    private static final String TABLE_NAME_PLAYBOOKS = "playbooks";
    private static final String TABLE_NAME_CHARACTERS = "characters";
    private static final String TABLE_NAME_ABILITIES = "abilities";
    private static final String TABLE_NAME_ADVANCEMENTS = "advancements";
    private static final String TABLE_NAME_POWERS = "powers";
    private static final String TABLE_NAME_ACTIONS = "actions";
    private static final String TABLE_NAME_LABELS = "labels";
    private static final String TABLE_NAME_CONDITIONS = "conditions";
    private static final String TABLE_NAME_NPCS = "npcs";
    private static final String TABLE_NAME_POWER_INPUTS = "powerInputs";
    private static final String TABLE_NAME_POWER_INPUT_GROUPS = "powerInputGroups";
    private static final String TABLE_NAME_POWER_OPTIONS = "powerOptions";
    private static final String TABLE_NAME_MODULES = "modules";

    //Foreign Key Table Names
    private static final String TABLE_NAME_PLAYBOOK_QUESTIONS = "playbookQuestions";
    private static final String TABLE_NAME_PLAYBOOK_ABILITIES = "playbookAbilities";
    private static final String TABLE_NAME_PLAYBOOK_ADVANCEMENTS = "playbookAdvances";
    private static final String TABLE_NAME_PLAYBOOK_POWERS = "playbookPowers";
    private static final String TABLE_NAME_PARENT_POWERS = "parentPowers";
    private static final String TABLE_NAME_POWER_EXECUTION_OPTIONS = "powerExecutionOptions";
    private static final String TABLE_NAME_POWER_OPTION_ACTIONS = "powerOptionActions";
    private static final String TABLE_NAME_POWER_LABELS = "powerLabels";
    private static final String TABLE_NAME_POWER_INPUT_LABELS = "powerInputLabels";
    private static final String TABLE_NAME_POWER_CONDITIONS = "powerConditions";
    private static final String TABLE_NAME_CHARACTER_HOLDS = "characterHolds";
    private static final String TABLE_NAME_CHARACTER_CONDITIONS = "characterConditions";
    private static final String TABLE_NAME_CHARACTER_LABELS = "characterLabels";
    private static final String TABLE_NAME_CHARACTER_DESCRIPTIONS = "characterDescription";
    private static final String TABLE_NAME_CHARACTER_POWER_INPUTS = "characterPowerInputs";
    private static final String TABLE_NAME_CHARACTER_POWERS = "characterPowers";
    private static final String TABLE_NAME_CHARACTER_ABILITIES = "characterAbilities";
    private static final String TABLE_NAME_CHARACTER_ADVANCEMENTS = "characterAdvancements";
    private static final String TABLE_NAME_CHARACTER_PLAYBOOK_ANSWERS = "characterPlaybookAnswers";
    private static final String TABLE_NAME_INFLUENCES = "influence";
    private static final String TABLE_NAME_ADVANCEMENT_ACTIONS = "advancementActions";

    //Primary Keys
    private static final String PK_PLAYBOOK_ID = "playbookID";
    private static final String PK_POWER_ID = "powerID";
    private static final String PK_MODULE_ID = "moduleID";
    private static final String PK_LABEL_ID = "labelID";
    private static final String PK_CONDITION_ID = "conditionID";
    private static final String PK_ABILITY_ID = "abilityID";
    private static final String PK_ADVANCEMENT_ID = "advancementID";
    private static final String PK_QUESTION_ID = "questionID";
    private static final String PK_CHARACTER_ID = "characterID";
    private static final String PK_POWER_OPTION_ID = "powerOptionID";
    private static final String PK_POWER_INPUT_GROUP_ID = "powerInputGroupID";
    private static final String PK_NPC_ID = "npcID";
    private static final String PK_ACTION_ID = "actionID";

    //Common Column Names
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESC = "desc";
    private static final String COLUMN_INPUT = "input";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_ORDER = "order";
    private static final String COLUMN_MOD = "mod";
    private static final String COLUMN_LOCKED = "locked";
    private static final String COLUMN_VALUE = "value";

    //Custom Columns
    private static final String COLUMN_NUM_STARTING_MOVES = "numStartingMoves";
    private static final String COLUMN_MAX_NUM_ABILITIES = "maxNumAbilities";
    private static final String COLUMN_MIN_NUM_ABILITIES = "minNumAbilities";
    private static final String COLUMN_GATED = "gated";
    private static final String COLUMN_PROMPT = "prompt";
    private static final String COLUMN_ROLL = "roll";
    private static final String COLUMN_QUESTION = "question";
    private static final String COLUMN_ANSWER = "answer";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_OWNER = "owner";
    private static final String COLUMN_SOURCE_ID = "sourceID";
    private static final String COLUMN_SOURCE_TYPE = "sourceType";
    private static final String COLUMN_LEVEL = "level";
    private static final String COLUMN_NUMBER_OF_OUTCOMES = "numberOfOutcomes";
    private static final String COLUMN_EXECUTION_RANGE = "executionRange";
    private static final String COLUMN_HOLD_COST = "holdCost";
    private static final String COLUMN_HOLD_AMOUNT = "holdAmount";
    private static final String COLUMN_OPTIONAL = "optional";
    private static final String COLUMN_MIN_NUM_SELECTION = "mimNumSelections";
    private static final String COLUMN_MAX_NUM_SELECTIONS = "maxNumSelections";
    private static final String COLUMN_HOLDS = "holds";
    private static final String COLUMN_HELD = "held";
    private static final String COLUMN_POTENTIAL = "potential";

    public MaskDB(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Primary Key Tables
        String sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING, %s STRING);", TABLE_NAME_MODULES, PK_MODULE_ID, COLUMN_NAME, COLUMN_DESC);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING, %s STRING, %s INTEGER, %s INTEGER, %s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_NAME_PLAYBOOKS, PK_PLAYBOOK_ID, COLUMN_NAME, COLUMN_DESC, COLUMN_NUM_STARTING_MOVES, COLUMN_MAX_NUM_ABILITIES, COLUMN_MIN_NUM_ABILITIES, PK_MODULE_ID, TABLE_NAME_MODULES, PK_MODULE_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s INTEGER, %s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_NAME_POWER_OPTIONS, PK_POWER_OPTION_ID, COLUMN_EXECUTION_RANGE, COLUMN_DESC, COLUMN_MOD, COLUMN_HOLD_COST, PK_POWER_ID, TABLE_NAME_POWERS, PK_POWER_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_NAME_PLAYBOOK_QUESTIONS, PK_QUESTION_ID, COLUMN_TYPE, COLUMN_QUESTION, COLUMN_ORDER, PK_PLAYBOOK_ID, TABLE_NAME_PLAYBOOKS, PK_PLAYBOOK_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s INTEGER, %s INTEGER, %s CHAR(2));", TABLE_NAME_CHARACTERS, PK_CHARACTER_ID, COLUMN_POTENTIAL, COLUMN_AGE, COLUMN_GENDER);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING);", TABLE_NAME_ABILITIES, PK_ABILITY_ID, COLUMN_DESC);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING);", TABLE_NAME_ADVANCEMENTS, PK_ADVANCEMENT_ID, COLUMN_DESC);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING);", TABLE_NAME_ACTIONS, PK_ACTION_ID, COLUMN_DESC);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING, %s STRING);", TABLE_NAME_CONDITIONS, PK_CONDITION_ID, COLUMN_NAME, COLUMN_DESC);
        db.execSQL(sqlStmt);


        
        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s STRING, %s roll);", TABLE_NAME_POWERS, PK_POWER_ID, COLUMN_TYPE, COLUMN_NAME, COLUMN_PROMPT, COLUMN_ROLL);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s STRING, %s roll);", TABLE_NAME_POWERS, PK_POWER_ID, COLUMN_TYPE, COLUMN_NAME, COLUMN_PROMPT, COLUMN_ROLL);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s STRING, %s roll);", TABLE_NAME_POWERS, PK_POWER_ID, COLUMN_TYPE, COLUMN_NAME, COLUMN_PROMPT, COLUMN_ROLL);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s STRING, %s roll);", TABLE_NAME_POWERS, PK_POWER_ID, COLUMN_TYPE, COLUMN_NAME, COLUMN_PROMPT, COLUMN_ROLL);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s STRING, %s roll);", TABLE_NAME_POWERS, PK_POWER_ID, COLUMN_TYPE, COLUMN_NAME, COLUMN_PROMPT, COLUMN_ROLL);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s STRING, %s roll);", TABLE_NAME_POWERS, PK_POWER_ID, COLUMN_TYPE, COLUMN_NAME, COLUMN_PROMPT, COLUMN_ROLL);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s STRING, %s roll);", TABLE_NAME_POWERS, PK_POWER_ID, COLUMN_TYPE, COLUMN_NAME, COLUMN_PROMPT, COLUMN_ROLL);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s STRING, %s roll);", TABLE_NAME_POWERS, PK_POWER_ID, COLUMN_TYPE, COLUMN_NAME, COLUMN_PROMPT, COLUMN_ROLL);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s STRING, %s roll);", TABLE_NAME_POWERS, PK_POWER_ID, COLUMN_TYPE, COLUMN_NAME, COLUMN_PROMPT, COLUMN_ROLL);
        db.execSQL(sqlStmt);
    }

    private void createPlaybooks() {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
