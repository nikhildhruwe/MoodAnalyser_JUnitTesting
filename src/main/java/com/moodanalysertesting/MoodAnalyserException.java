package com.moodanalysertesting;

public class MoodAnalyserException extends Exception{
    public MoodAnalyserException(String message) {
        super(message);
    }

    public enum moodExceptionType{EMPTY,NULL}

}
