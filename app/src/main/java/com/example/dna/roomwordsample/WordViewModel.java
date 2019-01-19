package com.example.dna.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository mWordRepository;
    private LiveData<List<Word>> cachedWords;
    public WordViewModel(Application application) {
        super(application);
        mWordRepository = new WordRepository(application);
        cachedWords = mWordRepository.getAllWords();
    }
    public LiveData<List<Word>> getAllWords() {
        return cachedWords;
    }
    public void insert (Word word) {
        mWordRepository.insert(word);
    }
}
