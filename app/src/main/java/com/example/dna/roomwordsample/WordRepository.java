package com.example.dna.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {
    private LiveData<List<Word>> allWords;
    private WordDao mWordDao;
    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getWordDatabase(application);
        mWordDao = db.wordDao();
        allWords = mWordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    public void insert (Word word){
        new insertAsyncTask(mWordDao).execute(word);
    }
    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
