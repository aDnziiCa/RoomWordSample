package mavi.com.roomwordsample.room.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import mavi.com.roomwordsample.room.entitys.Word;
import mavi.com.roomwordsample.room.repository.WordRepository;

/**
 * Created by aDnziiCa
 * on 27/06/2018.
 */
public class WordViewModel extends AndroidViewModel{
    private WordRepository mWordRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mWordRepository = new WordRepository(application);
        mAllWords = mWordRepository.getmAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) { mWordRepository.insert(word); }
}
