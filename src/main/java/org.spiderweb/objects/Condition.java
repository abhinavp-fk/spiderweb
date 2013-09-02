package org.spiderweb.objects;

import java.lang.reflect.Type;

/**
 * Created by IntelliJ IDEA.
 * User: abhinavp
 * Date: 29/07/13
 * Time: 11:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Condition<T> {
    String key;
    T value;

    String group;

    ConditionType conditionType;

   public enum ConditionType
    {
        EQUAL,
        INLIST,
        LESSTHAN,
        GREATHERTHAN
    }
    public Condition(String key, T value, String group, ConditionType conditionType)
    {
         this.key = key;
         this.value = value;
         this.group = group;
         this.conditionType = conditionType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return (T)value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    public Type getDataType()
    {
        return value.getClass();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", group='" + group + '\'' +
                ", conditionType=" + conditionType +
                '}';
    }
}
