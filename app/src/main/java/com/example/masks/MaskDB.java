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
    private static final String TABLE_PLAYBOOKS = "playbooks";
    private static final String TABLE_CHARACTERS = "characters";
    private static final String TABLE_ABILITIES = "abilities";
    private static final String TABLE_ADVANCEMENTS = "advancements";
    private static final String TABLE_POWERS = "powers";
    private static final String TABLE_ACTIONS = "actions";
    private static final String TABLE_LABELS = "labels";
    private static final String TABLE_CONDITIONS = "conditions";
    private static final String TABLE_NPCS = "npcs";
    private static final String TABLE_POWER_INPUTS = "powerInputs";
    private static final String TABLE_POWER_INPUT_GROUPS = "powerInputGroups";
    private static final String TABLE_POWER_OPTIONS = "powerOptions";
    private static final String TABLE_MODULES = "modules";
    private static final String TABLE_PLAYBOOK_QUESTIONS = "playbookQuestions";

    //Foreign Key Table Names
    private static final String TABLE_PLAYBOOK_ABILITIES = "playbookAbilities";
    private static final String TABLE_PLAYBOOK_ADVANCEMENTS = "playbookAdvances";
    private static final String TABLE_PLAYBOOK_POWERS = "playbookPowers";
    private static final String TABLE_PARENT_POWERS = "parentPowers";
    private static final String TABLE_POWER_EXECUTION_OPTIONS = "powerExecutionOptions";
    private static final String TABLE_POWER_OPTION_ACTIONS = "powerOptionActions";
    private static final String TABLE_POWER_LABELS = "powerLabels";
    private static final String TABLE_POWER_INPUT_LABELS = "powerInputLabels";
    private static final String TABLE_POWER_CONDITIONS = "powerConditions";
    private static final String TABLE_CHARACTER_HOLDS = "characterHolds";
    private static final String TABLE_CHARACTER_CONDITIONS = "characterConditions";
    private static final String TABLE_CHARACTER_LABELS = "characterLabels";
    private static final String TABLE_CHARACTER_DESCRIPTIONS = "characterDescription";
    private static final String TABLE_CHARACTER_POWER_INPUTS = "characterPowerInputs";
    private static final String TABLE_CHARACTER_POWERS = "characterPowers";
    private static final String TABLE_CHARACTER_ABILITIES = "characterAbilities";
    private static final String TABLE_CHARACTER_ADVANCEMENTS = "characterAdvancements";
    private static final String TABLE_CHARACTER_PLAYBOOK_ANSWERS = "characterPlaybookAnswers";
    private static final String TABLE_INFLUENCES = "influence";
    private static final String TABLE_ADVANCEMENT_ACTIONS = "advancementActions";

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
    private static final String PK_POWER_INPUT_ID = "powerInputID";
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
    private static final String COLUMN_PARENT_POWER_ID = "parentPowerID";

    public MaskDB(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //-----------CREATE PRIMARY KEY TABLES---------------
        String sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING, %s STRING);", TABLE_MODULES, PK_MODULE_ID, COLUMN_NAME, COLUMN_DESC);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING, %s STRING);", TABLE_LABELS, PK_LABEL_ID, COLUMN_NAME, COLUMN_DESC);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s INTEGER, %s INTEGER, %s CHAR(2));", TABLE_CHARACTERS, PK_CHARACTER_ID, COLUMN_POTENTIAL, COLUMN_AGE, COLUMN_GENDER);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s STRING, %s roll);", TABLE_POWERS, PK_POWER_ID, COLUMN_TYPE, COLUMN_NAME, COLUMN_PROMPT, COLUMN_ROLL);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING);", TABLE_ABILITIES, PK_ABILITY_ID, COLUMN_DESC);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING);", TABLE_ADVANCEMENTS, PK_ADVANCEMENT_ID, COLUMN_DESC);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING);", TABLE_ACTIONS, PK_ACTION_ID, COLUMN_DESC);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING, %s STRING);", TABLE_CONDITIONS, PK_CONDITION_ID, COLUMN_NAME, COLUMN_DESC);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING, %s STRING);", TABLE_NPCS, PK_NPC_ID, COLUMN_NAME, COLUMN_DESC);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s INTEGER, %s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_POWER_OPTIONS, PK_POWER_OPTION_ID, COLUMN_EXECUTION_RANGE, COLUMN_DESC, COLUMN_MOD, COLUMN_HOLD_COST, PK_POWER_ID, TABLE_POWERS, PK_POWER_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s CHAR(1), %s STRING, %s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_PLAYBOOK_QUESTIONS, PK_QUESTION_ID, COLUMN_TYPE, COLUMN_QUESTION, COLUMN_ORDER, PK_PLAYBOOK_ID, TABLE_PLAYBOOKS, PK_PLAYBOOK_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s STRING, %s STRING, %s INTEGER, %s INTEGER, %s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_PLAYBOOKS, PK_PLAYBOOK_ID, COLUMN_NAME, COLUMN_DESC, COLUMN_NUM_STARTING_MOVES, COLUMN_MAX_NUM_ABILITIES, COLUMN_MIN_NUM_ABILITIES, PK_MODULE_ID, TABLE_MODULES, PK_MODULE_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s INTEGER, %s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_POWER_INPUT_GROUPS, PK_POWER_INPUT_GROUP_ID, COLUMN_MAX_NUM_SELECTIONS, COLUMN_MIN_NUM_SELECTION, PK_POWER_ID, TABLE_POWERS, PK_POWER_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s INTEGER, %s STRING, %s CHAR(1), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_POWER_INPUTS, PK_POWER_INPUT_ID, COLUMN_ORDER, COLUMN_NAME, COLUMN_TYPE, PK_POWER_INPUT_GROUP_ID, TABLE_POWER_INPUT_GROUPS, PK_POWER_INPUT_GROUP_ID);
        db.execSQL(sqlStmt);
        //-----------END CREATE PRIMARY KEY TABLES-----------

        //-----------CREATE FOREIGN KEY TABLES-----------
        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_PLAYBOOK_ABILITIES, COLUMN_ORDER, PK_PLAYBOOK_ID, TABLE_PLAYBOOKS, PK_PLAYBOOK_ID, PK_ABILITY_ID, TABLE_ABILITIES, PK_ABILITY_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s BOOLEAN, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_PLAYBOOK_POWERS, COLUMN_GATED, PK_PLAYBOOK_ID, TABLE_PLAYBOOKS, PK_PLAYBOOK_ID, PK_POWER_ID, TABLE_POWERS, PK_POWER_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER, %s CHAR(1), FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_PLAYBOOK_ADVANCEMENTS, COLUMN_ORDER, COLUMN_LEVEL, PK_PLAYBOOK_ID, TABLE_PLAYBOOKS, PK_PLAYBOOK_ID, PK_ADVANCEMENT_ID, TABLE_ADVANCEMENTS, PK_ADVANCEMENT_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s STRING, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_CHARACTER_PLAYBOOK_ANSWERS, COLUMN_ANSWER, PK_CHARACTER_ID, TABLE_CHARACTERS, PK_CHARACTER_ID, PK_QUESTION_ID, TABLE_PLAYBOOK_QUESTIONS, PK_QUESTION_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s STRING, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_CHARACTER_PLAYBOOK_ANSWERS, COLUMN_ANSWER, PK_CHARACTER_ID, TABLE_CHARACTERS, PK_CHARACTER_ID, PK_QUESTION_ID, TABLE_PLAYBOOK_QUESTIONS, PK_QUESTION_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_PARENT_POWERS, COLUMN_PARENT_POWER_ID, TABLE_POWERS, COLUMN_PARENT_POWER_ID, PK_POWER_ID, TABLE_POWERS, PK_POWER_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s CHAR(1), %s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_POWER_EXECUTION_OPTIONS, COLUMN_EXECUTION_RANGE, COLUMN_NUMBER_OF_OUTCOMES, PK_POWER_ID, TABLE_POWERS, PK_POWER_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s CHAR(1), %s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_POWER_EXECUTION_OPTIONS, COLUMN_EXECUTION_RANGE, COLUMN_NUMBER_OF_OUTCOMES, PK_POWER_ID, TABLE_POWERS, PK_POWER_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER, %s BOOLEAN, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_POWER_OPTION_ACTIONS, COLUMN_ORDER, COLUMN_OPTIONAL, PK_POWER_OPTION_ID, TABLE_POWER_OPTIONS, PK_POWER_OPTION_ID, PK_ACTION_ID, TABLE_ACTIONS, PK_ACTION_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s BOOLEAN, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_POWER_LABELS, COLUMN_LOCKED, PK_LABEL_ID, TABLE_POWER_LABELS, PK_LABEL_ID, PK_POWER_ID, TABLE_POWERS, PK_POWER_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_POWER_INPUT_LABELS, PK_POWER_INPUT_ID, TABLE_POWER_INPUTS, PK_POWER_INPUT_ID, PK_POWER_INPUT_GROUP_ID, TABLE_POWER_INPUT_GROUPS, PK_POWER_INPUT_GROUP_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_POWER_CONDITIONS, COLUMN_MOD, PK_POWER_ID, TABLE_POWERS, PK_POWER_ID, PK_CONDITION_ID, TABLE_CONDITIONS, PK_CONDITION_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_CHARACTER_HOLDS, COLUMN_HOLD_AMOUNT, PK_CHARACTER_ID, TABLE_CHARACTERS, PK_CHARACTER_ID, PK_POWER_ID, TABLE_POWERS, PK_POWER_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_CHARACTER_CONDITIONS, PK_CHARACTER_ID, TABLE_CHARACTERS, PK_CHARACTER_ID, PK_CONDITION_ID, TABLE_CONDITIONS, PK_CONDITION_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER, %s BOOLEAN, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_CHARACTER_LABELS, COLUMN_VALUE, COLUMN_LOCKED, PK_CHARACTER_ID, TABLE_CHARACTERS, PK_CHARACTER_ID, PK_LABEL_ID, TABLE_LABELS, PK_LABEL_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s STRING, %s STRING, FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_CHARACTER_DESCRIPTIONS, COLUMN_NAME, COLUMN_DESC, PK_CHARACTER_ID, TABLE_CHARACTERS, PK_CHARACTER_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER, %s BOOLEAN, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_POWER_OPTION_ACTIONS, COLUMN_ORDER, COLUMN_OPTIONAL, PK_POWER_OPTION_ID, TABLE_POWER_OPTIONS, PK_POWER_OPTION_ID, PK_ACTION_ID, TABLE_ACTIONS, PK_ACTION_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s STRING, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_CHARACTER_POWER_INPUTS, COLUMN_INPUT, PK_CHARACTER_ID, TABLE_CHARACTERS, PK_CHARACTER_ID, PK_POWER_INPUT_ID, TABLE_POWER_INPUTS, PK_POWER_INPUT_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER, %s CHAR(1), FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_CHARACTER_POWERS, COLUMN_SOURCE_ID, COLUMN_SOURCE_TYPE, PK_POWER_ID, TABLE_POWERS, PK_POWER_ID, PK_CHARACTER_ID, TABLE_CHARACTERS, PK_CHARACTER_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s CHAR(1), FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_CHARACTER_ABILITIES, COLUMN_OWNER, PK_CHARACTER_ID, TABLE_CHARACTERS, PK_CHARACTER_ID, PK_ABILITY_ID, TABLE_ABILITIES, PK_ABILITY_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_CHARACTER_ADVANCEMENTS,  COLUMN_ORDER, PK_CHARACTER_ID, TABLE_CHARACTERS, PK_CHARACTER_ID, PK_ADVANCEMENT_ID, TABLE_ADVANCEMENTS, PK_ADVANCEMENT_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (%s INTEGER, %s BOOLEAN, FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_INFLUENCES, COLUMN_HOLDS, COLUMN_HELD, PK_NPC_ID, TABLE_NPCS, PK_NPC_ID, PK_CHARACTER_ID, TABLE_CHARACTERS, PK_CHARACTER_ID);
        db.execSQL(sqlStmt);

        sqlStmt = String.format("CREATE TABLE %s (FOREIGN_KEY(%s) REFERENCES %s(%s), FOREIGN_KEY(%s) REFERENCES %s(%s));", TABLE_ADVANCEMENT_ACTIONS, PK_ADVANCEMENT_ID, TABLE_ADVANCEMENTS, PK_ADVANCEMENT_ID, PK_ACTION_ID, TABLE_ACTIONS, PK_ACTION_ID);
        db.execSQL(sqlStmt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
