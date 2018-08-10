package com.example.hemant.miwok;

/**
 * Created by Hemant on 7/10/2017.
 */

public class Word {
    private String mDefaultTranslation;
    private  String mMiwokTranslation;
    private int mImageresource;
    private int mMusicresource;
    Word(String DefaultTranslation,String MiwokTranslation,int ImageResource,int MusicResource){
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mImageresource = ImageResource;
        mMusicresource = MusicResource;
    }
    Word(String DefaultTranslation,String MiwokTranslation,int MusicResource){
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
       mMusicresource = MusicResource;
    }
    Word(String DefaultTranslation,String MiwokTranslation){
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
    }
    public String getDefaultTransltion(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getmImageresource(){return mImageresource;}
    public  int getmMusicresource(){return mMusicresource;}
}
