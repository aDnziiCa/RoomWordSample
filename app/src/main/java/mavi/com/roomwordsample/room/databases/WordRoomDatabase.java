package mavi.com.roomwordsample.room.databases;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import mavi.com.roomwordsample.room.dao.WordDao;
import mavi.com.roomwordsample.room.entitys.Word;

/**
 * Created by aDnziiCa
 * on 27/06/2018.
 */
@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WordDao wordDao();

    private static WordRoomDatabase INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context){
        if (INSTANCE==null)
        {
            synchronized (WordRoomDatabase.class){
                if (INSTANCE==null){

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordRoomDatabase.class,"word_database")
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback callback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void>{

        private final WordDao mDao;

        PopulateDbAsync(WordRoomDatabase db){
            mDao=db.wordDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mDao.deleteAll();
            Word word = new Word("Hello");
            mDao.insert(word);
            word = new Word("World");
            mDao.insert(word);
            return null;

        }
    }

}
