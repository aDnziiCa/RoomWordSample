package mavi.com.roomwordsample.room.entitys;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by aDnziiCa
 * on 27/06/2018.
 */
@Entity(tableName = "word_table")
public class Word {

    public Word() {
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    public String mWord;

    public Word(String mword) {
        this.mWord = mword;
    }

    public String getWord() {
        return mWord;
    }
}
