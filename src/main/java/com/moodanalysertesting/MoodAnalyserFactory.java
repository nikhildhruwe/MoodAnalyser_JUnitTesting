package com.moodanalysertesting;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    private static String className = "com.moodanalysertesting.MoodAnalyser";

    public static MoodAnalyser createMoodAnalyser(String message,String givenClass) {
        try {
                Class<?> moodAnalyserClass;
                if (className.equals(givenClass)) {
                   moodAnalyserClass = Class.forName(givenClass);
                }
                else
                {
                    throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.ENTERED_WRONG_CLASS,"Entered" +
                            " Wrong class name");
                }
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(message);
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
