package io.github.nicks.nms.tank;

import lombok.Getter;

import java.lang.reflect.Method;

@Getter
public class NmsItemUtil {

    private final Class<?> itemClass;
    private final Class<?> itemStackClass;
    private final Method getDescriptionIdMethod;
    private final Method useMethod;

    public NmsItemUtil() {
        NmsOtherUtil nmsOtherUtil = NmsOtherUtil.getInstance();

        this.itemClass = nmsOtherUtil.Item();
        this.itemStackClass = nmsOtherUtil.ItemStack();
        this.getDescriptionIdMethod = nmsOtherUtil.Item_getDescriptionId();
        this.useMethod = nmsOtherUtil.Item_use();
    }
}
