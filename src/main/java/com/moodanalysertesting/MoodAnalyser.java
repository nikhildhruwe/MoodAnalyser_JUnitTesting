package com.moodanalysertesting;

import java.util.Objects;

public class MoodAnalyser {

    private String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood(String message){
        return  analyseMood(message);
    }


    public String analyseMood() throws MoodAnalyserException {
        try {
            if(message.length() == 0)
                throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.ENTERED_EMPTY,"Entered" +
                        " Empty message");
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.ENTERED_NULL,"Entered" +
                    " NULL message");
        }
    }

    public boolean equals(MoodAnalyser another) {
        if (this.message.equals(another))
            return true;
        else
            return false;

    }
}
