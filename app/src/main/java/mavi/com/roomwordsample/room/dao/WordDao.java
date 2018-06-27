package mavi.com.roomwordsample.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import mavi.com.roomwordsample.room.entitys.Word;

/**
 * Created by aDnziiCa
 * on 27/06/2018.
 */
@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("Delete from word_table")
    void deleteAll();

    @Query("SELECT * from word_table order by word asc")
    LiveData<List<Word>> getAllWords();


}
