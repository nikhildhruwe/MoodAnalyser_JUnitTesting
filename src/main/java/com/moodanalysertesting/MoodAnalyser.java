package com.moodanalysertesting;

public class MoodAnalyser {

    private String message;

    public MoodAnalyser() {

    }

    public MoodAnalyser(String message) {
        this.message = message;
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


}
