package com.moodanalysertesting;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    private static String className = "com.moodanalysertesting.MoodAnalyser";
    private static String constructorName = "MoodAnalyser";
    public static MoodAnalyser createMoodAnalyser(String message,String givenClass) {
        try {
            Class<?> moodAnalyserClass;
            if (className.equals(givenClass)) {
                moodAnalyserClass = Class.forName(givenClass);
            } else {
                throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.ENTERED_WRONG_CLASS, "Entered" +
                        " Wrong class name");
            }

            Object moodObject;
            if (moodAnalyserClass.getConstructor().equals(constructorName)) {
                Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
                moodObject = moodConstructor.newInstance(message);
            } else {
                throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.NO_SUCH_METHOD, "NO_SUCH_METHOD");
            }

            return (MoodAnalyser) moodObject;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
        return null;
    }
}
