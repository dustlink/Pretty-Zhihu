package site.hanschen.pretty.db.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import site.hanschen.pretty.db.bean.Question;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "QUESTION".
*/
public class QuestionDao extends AbstractDao<Question, Long> {

    public static final String TABLENAME = "QUESTION";

    /**
     * Properties of entity Question.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property QuestionId = new Property(1, int.class, "questionId", false, "QUESTION_ID");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property AnswerCount = new Property(3, int.class, "answerCount", false, "ANSWER_COUNT");
    }

    private DaoSession daoSession;


    public QuestionDao(DaoConfig config) {
        super(config);
    }
    
    public QuestionDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"QUESTION\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"QUESTION_ID\" INTEGER NOT NULL UNIQUE ," + // 1: questionId
                "\"TITLE\" TEXT NOT NULL ," + // 2: title
                "\"ANSWER_COUNT\" INTEGER NOT NULL );"); // 3: answerCount
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"QUESTION\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Question entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getQuestionId());
        stmt.bindString(3, entity.getTitle());
        stmt.bindLong(4, entity.getAnswerCount());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Question entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getQuestionId());
        stmt.bindString(3, entity.getTitle());
        stmt.bindLong(4, entity.getAnswerCount());
    }

    @Override
    protected final void attachEntity(Question entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Question readEntity(Cursor cursor, int offset) {
        Question entity = new Question( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // questionId
            cursor.getString(offset + 2), // title
            cursor.getInt(offset + 3) // answerCount
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Question entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setQuestionId(cursor.getInt(offset + 1));
        entity.setTitle(cursor.getString(offset + 2));
        entity.setAnswerCount(cursor.getInt(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Question entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Question entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Question entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}