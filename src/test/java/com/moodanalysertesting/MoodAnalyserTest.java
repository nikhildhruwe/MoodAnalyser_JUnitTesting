package com.moodanalysertesting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {
  /*  @Test
    public void givenMoodAnalyserClass_UsedDefaultConstructor_WhenProper_ShouldReturnObject() {

        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in a Ha" +
                "ppy mood","com.moodanalysertesting.MoodAnalyser");
    }*/

    @Test
    public void givenMoodAnalyserClass_UsedParameterisedConstructor_WhenProper_ShouldReturnObject() {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in a Ha" +
                "ppy mood","com.moodanalysertesting.MoodAnalyser");
        Assert.assertEquals(new MoodAnalyser("I am in a Happy mood"),moodAnalyser );

    }

    @Test
    public void givenMoodAnalyser_UsedParameterisedConstructor_WhenImproper_ShouldThrowException() {
        try{
            MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in a Ha" +
                    "ppy mood","com.moodanalysertesting.MoodAnalysertest");
        } catch (Exception e) {
            Assert.assertEquals("Entered Wrong class name",e.getMessage());
        }
    }


    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.moodanalysertesting.MoodAnalyser").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Object myObj = constructor.newInstance("I am in a Happy mood.");
            MoodAnalyser moodAnalyser = (MoodAnalyser) myObj;
            try {
                String mood = moodAnalyser.analyseMood();
                Assert.assertEquals("HAPPY",mood);
            } catch (MoodAnalyserException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

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
