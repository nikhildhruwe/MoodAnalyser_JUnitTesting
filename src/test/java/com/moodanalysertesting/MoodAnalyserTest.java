package com.moodanalysertesting;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserTest {
    //**********Default constructor*********//
    @Test
    public void givenMoodAnalyserClass_UsedDefaultConstructor_WhenProper_ShouldReturnObject() throws
            MoodAnalyserException {
        MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser();
        try {
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        }catch (MoodAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClass_UsedDefaultConstructor_WhenImproper_ThrowException(){
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser();
        }catch (MoodAnalyserException e){
            Assert.assertEquals("Entered Wrong Class",e.getMessage());
        }
    }


    @Test
    public void givenMoodAnalyserConstructor_UsedDefaultConstructor_WhenImproper_ThrowException() {
        try{
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser();
        }catch (MoodAnalyserException e){
            Assert.assertEquals("Entered Wrong Method",e.getMessage());
        }
    }

    //********Parameterised constructor*********//
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
            Class<?> aClass = Class.forName("com.moodanalysertesting.MoodAnalyser");
            Constructor<?> constructor = aClass.getConstructor();
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
        } catch (Exception e) {
            Assert.assertEquals("Entered Wrong class name", e.getMessage());
        }
    }
    //********Reflection with default constructor*******//

    @Test
    public void givenHappyMessage_WithReflection_WhenProper_ShouldReturnHappy() {
        try {
           Object myObject= MoodAnalyserReflector.createMoodAnalyser("I am in a Happy mood");
            Object analyseMood = MoodAnalyserReflector.invokeMethod(myObject, "analyseMood");
            Assert.assertEquals("HAPPY",analyseMood);
        } catch (MoodAnalyserException e) {
            e.getCause().printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_WithReflection_WhenImproper_ShouldReturnHappy() {
        try {
            Object myObject= MoodAnalyserReflector.createMoodAnalyser("I am in a Happy mood");
            Object analyseMood = MoodAnalyserReflector.invokeMethod(myObject, "analyseMood1");
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }
    //************Reflection to change mood dynamically**************//


    @Test
    public void givenMoodAnalyser_WhenMoodChanges_ShouldReturnHappy() {
        try {
            Object myObject= MoodAnalyserReflector.createMoodAnalyser("");
            MoodAnalyserReflector.setFieldValue(myObject,"message", "I am in Happy mood");
            Object analyseMood = MoodAnalyserReflector.invokeMethod(myObject, "analyseMood");
            Assert.assertEquals("HAPPY",analyseMood);
        } catch (MoodAnalyserException e) {
            e.getCause().printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyser_WhenSetFieldImproper_ShouldThrowException() {
        try {
            Object myObject= MoodAnalyserReflector.createMoodAnalyser("");
            MoodAnalyserReflector.setFieldValue(myObject,"message1", "I am in Happy mood");
            Object analyseMood = MoodAnalyserReflector.invokeMethod(myObject, "analyseMood");
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());;
        }
    }
    @Test
    public void givenMoodAnalyser_WhenFieldValueNull_ShouldThrowException() {
        try {
            Object myObject= MoodAnalyserReflector.createMoodAnalyser("");
            MoodAnalyserReflector.setFieldValue(myObject,"message", null);
            Object analyseMood = MoodAnalyserReflector.invokeMethod(myObject, "analyseMood");
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());
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
