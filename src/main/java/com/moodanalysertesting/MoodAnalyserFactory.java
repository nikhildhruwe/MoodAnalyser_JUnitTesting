package com.moodanalysertesting;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser createMoodAnalyser(String message) {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanalysertesting.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObject;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
