package com.moodanalysertesting;

public class MoodAnalyser {

    private String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalyserException {
        try {
            if (message.contains("sad"))
                return "SAD";
            else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            throw new MoodAnalyserException("Entered NULL, Enter proper message");
        }
    }
}
