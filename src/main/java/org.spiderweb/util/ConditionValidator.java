package org.spiderweb.util;


import org.spiderweb.objects.Condition;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: abhinavp
 * Date: 15/08/13
 * Time: 5:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConditionValidator {

    public static <T> boolean validate(T validationObject, Condition<T> condition)
    {
        if(validationObject instanceof List)
        {
            return validate((List)validationObject,condition);
        }
        switch (condition.getConditionType())
        {
            case EQUAL:
                if(condition.getValue().equals(validationObject))
                    return true;
                else
                    return false;

            case LESSTHAN:
                 if(validationObject.getClass().equals(Integer.class) || validationObject.getClass().equals(Double.class) || validationObject.getClass().equals(Float.class) )
                 {
                    if(Float.parseFloat(validationObject.toString()) > Float.parseFloat(condition.getValue().toString()))
                        return true;
                    else
                        return false;
                 }
                 else
                     return false;
            case GREATHERTHAN:
                 if(validationObject.getClass().equals(Integer.class) || validationObject.getClass().equals(Double.class) || validationObject.getClass().equals(Float.class) )
                 {
                    if(Float.parseFloat(validationObject.toString()) < Float.parseFloat(condition.getValue().toString()))
                        return true;
                    else
                        return false;
                 }
                 else
                     return false;
            default:
                return false;
        }
    }

    public static <T> boolean validate(List<T> validationObject, Condition<T> condition)
    {
        switch (condition.getConditionType())
        {
              case INLIST:
                  if(validationObject.contains(condition.getValue()))
                      return true;
                  else
                      return false;

            default:
                return false;
        }
    }
}
