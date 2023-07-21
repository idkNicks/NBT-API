package io.github.nicks.nms.wrapper;

import io.github.nicks.nms.tank.NmsNbtTagCompoundUtil;
import io.github.nicks.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NBTTagCompoundWrapper {

    private Object nbtTagCompound;
    private NmsNbtTagCompoundUtil wrapper;

    public String getString(String key) {
        try {
            Object result = wrapper.getGetStringMethod().invoke(nbtTagCompound, key);
            if (result == null) return null;
            else return (String) result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void setString(String key, String value) {
        try {
            wrapper.getSetStringMethod().invoke(nbtTagCompound, key, value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public <T> T getObject(Class<T> clazz) {
        try {
            String result = getString(clazz.getSimpleName());

            if (result == null) return null;
            else return JsonUtil.fromJson(result, clazz);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public <T> void setObject(T object, Class<T> clazz) {
        try {
            setString(clazz.getSimpleName(), JsonUtil.toJson(object));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}