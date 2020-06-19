package com.moodanalysertesting;

public class MoodAnalyserException extends Exception{
    public MoodAnalyserException(String message) {
        super(message);
    }

   enum moodExceptionType{ENTERED_EMPTY,ENTERED_NULL}

}
