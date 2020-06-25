package com.moodanalysertesting;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.NO_SUCH_METHOD, "Entered +" +
                    "Wrong Method");
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.NO_SUCH_CLASS, "Entered" +
                    " Wrong Class");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object invokeMethod(Object moodAnalyserObject, String methodName) throws MoodAnalyserException {
        try {
           return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.METHOD_INVOKATION_ISSUE,
                    e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.NO_SUCH_METHOD, "NO SUCH METHOD");
        }
    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalyserException {
        try {
            Field field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject,fieldValue);
        } catch (NoSuchFieldException e) {
                throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.NO_SUCH_FIELD, "NO SUCH FIELD");
        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.moodExceptionType.FIELD_SETTING_ISSUE, "" +
                    "SETTING FIELD ISSUE");
        }
    }
}

