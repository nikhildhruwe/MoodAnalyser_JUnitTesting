package com.moodanalysertesting;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    private static String mame = "com.moodanalysertesting.MoodAnalyser";

    public static MoodAnalyser createMoodAnalyser(String message,String name) {
        try {
            Class<?> moodAnalyserClass;
            if (name.equals(name)) {
                moodAnalyserClass = Class.forName(name);
            }
             else {
                throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.ENTERED_WRONG_CLASS, "Entered" +
                        " Wrong class name");
            }
            Constructor moodConstructor = moodAnalyserClass.getConstructor();
            Object moodObject;
            if ( message == null || message instanceof String ) {
                moodConstructor = moodAnalyserClass.getConstructor(String.class);
                moodObject = moodConstructor.newInstance(message);
            } else {
                throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.NO_SUCH_METHOD, "NO SUCH METHOD");
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
