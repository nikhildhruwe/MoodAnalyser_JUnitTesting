package com.moodanalysertesting;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {

    public static MoodAnalyser createMoodAnalyser(String... message) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanalysertesting.MoodAnalyser");
            Object object;
            if (message.length != 0) {
                Constructor<?> constructor = moodAnalyserClass.getConstructor(String.class);
                object = constructor.newInstance(message);
            } else {
                Constructor defaultConstructor = moodAnalyserClass.getConstructor();
                object = defaultConstructor.newInstance();
            }
            return (MoodAnalyser) object;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.NO_SUCH_CLASS,"Entered" +
                    " Wrong Class");
        }
        return null;
    }
}
