package io.github.nicks.nms.wrapper;

import io.github.nicks.nms.tank.NmsItemUtil;
import io.github.nicks.version.Version;
import io.github.nicks.version.VersionController;
import lombok.Getter;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ItemWrapper {

    private NmsItemUtil support;
    @Getter private Object Item;

    public ItemWrapper(NmsItemUtil itemSupport, NmsItemWrapper nmsItemStackWrapper) {
        try {
            support = itemSupport;
            Method getItemMethod;

            Version version = VersionController.getINSTANCE().getVersion();;
            try {
                getItemMethod = itemSupport.getItemStackClass().getMethod("getItem");
            } catch (Exception e) {
                Map<String, String> methodNameMap = new HashMap<>();
                methodNameMap.put("v1_12_R1", "c");
                methodNameMap.put("v1_13_R1", "b");
                methodNameMap.put("v1_13_R2", "b");
                methodNameMap.put("v1_14_R1", "b");
                methodNameMap.put("v1_15_R1", "b");
                methodNameMap.put("v1_16_R2", "b");
                methodNameMap.put("v1_16_R3", "b");
                methodNameMap.put("v1_17_R1", "c");
                methodNameMap.put("v1_18_R1", "c");
                methodNameMap.put("v1_18_R2", "c");
                methodNameMap.put("v1_19_R1", "c");
                methodNameMap.put("v1_19_R2", "c");
                methodNameMap.put("v1_19_R3", "c");
                methodNameMap.put("v1_20_R1", "d");

                getItemMethod = itemSupport.getItemStackClass().getMethod(methodNameMap.get(version.getVersion()));
            }
            Item = getItemMethod.invoke(nmsItemStackWrapper.getNmsItemStack());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getUnlocalizedName(NmsItemWrapper nmsItemStack) {
        try {
            return (String) support.getGetDescriptionIdMethod().invoke(Item, nmsItemStack.getNmsItemStack());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
