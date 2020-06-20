package com.moodanalysertesting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {
    //Test Case for sad message
    @Test
    public void givenMood_WhenSad_ShouldReturnSad() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad mood.");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",mood);
    }

    //Test Case for any mood
    @Test
    public void givenMood_WhenAnyMood_ShouldReturnHappy() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any mood.");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    //Test Case for null message
    @Test
    public void givenMood_WhenNull_ShouldThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("Entered NULL message",e.getMessage());
        }
    }

    //Test Case for empty message
    @Test
    public void givenMood_WhenEmpty_ShouldThrowException() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e){
            Assert.assertEquals("Entered Empty message",e.getMessage());
        }
    }
}
