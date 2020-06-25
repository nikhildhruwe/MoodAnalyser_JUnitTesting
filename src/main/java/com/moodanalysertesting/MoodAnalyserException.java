package com.moodanalysertesting;

public class MoodAnalyserException extends Exception{
    public MoodAnalyserException(moodExceptionType type,String message) {
        super(message);
        this.type=type;
    }

    enum moodExceptionType{
         ENTERED_EMPTY,ENTERED_NULL,NO_SUCH_METHOD,NO_SUCH_CLASS,METHOD_INVOKATION_ISSUE
    }
    moodExceptionType type;
}
