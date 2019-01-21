package com.example.dna.roomwordsample;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String word;


    public Word(String word){
        this.word = word;
        //this.id = id;
    }
//..other fields, getters, setters
}