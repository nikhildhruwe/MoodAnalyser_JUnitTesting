package com.moodanalysertesting;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserTest {

  /*  @Test
    public void givenMoodAnalyserClass_UsedDefaultConstructor_WhenProper_ShouldReturnObject()
            throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser(null
                , "com.moodanalysertesting.MoodAnalyser");
        Assert.assertEquals(true, equals(moodAnalyser));
    }


    @Test
    public void givenClassName_WhenImproper_ForDefaultConstructor_ShouldThrowException()
    throws MoodAnalyserException {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser(null,
                    "com.moodanalysertesting.MoodAnalysera");
        } catch (Exception e) {
            Assert.assertEquals("Entered Wrong class name", e.getMessage());
        }
    }

   */

    /*@Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappyMood() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser
                    ("I am in a Happy mood","com.moodanalysertesting.MoodAnalyser");
            Assert.assertEquals("HAPPY",MoodAnalyserReflector.createMoodAnalyser(moodAnalyser));
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
    }*/
    //Default constructor

    //Parameterised constructor
    @Test
    public void givenMoodAnalyserClass_UsedParameterisedConstructor_WhenProper_ShouldReturnObject() throws
            MoodAnalyserException{
        MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser("I am in a happy mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenMoodAnalyser_UsedParameterisedConstructor_WhenClassNameImproper_ShouldThrowException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser("I am in a Ha" +
                    "ppy mood");
        } catch (Exception e) {
            Assert.assertEquals("Entered Wrong class name", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyser_UsedParameterisedConstructor_WhenConstructorNameImproper_ShouldThrowException()
            throws MoodAnalyserException {
        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.moodanalysertesting.MoodAnalyser");
            Constructor<?> constructor = aClass.getConstructor(int.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
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
                Assert.assertEquals("HAPPY", mood);
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
        Assert.assertEquals("SAD", mood);
    }

    //Test Case for any mood
    @Test
    public void givenMood_WhenAnyMood_ShouldReturnHappy() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any mood.");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }

    //Test Case for null message
    @Test
    public void givenMood_WhenNull_ShouldThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("Entered NULL message", e.getMessage());
        }
    }

    //Test Case for empty message
    @Test
    public void givenMood_WhenEmpty_ShouldThrowException() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("Entered Empty message", e.getMessage());
        }
    }
}
