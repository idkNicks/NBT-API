package io.github.nicks.nms.tank;

import io.github.nicks.nms.wrapper.NmsItemWrapper;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Method;

public class NmsItemStackUtil {

    private static NmsItemStackUtil instance;

    private final Method bukkitCopyMethod;
    private final Method nmsCopyMethod;
    @Getter private final Method setTagMethod;
    @Getter private final Method getTagMethod;
    @Getter private final NmsNbtTagCompoundUtil nbtCompoundUtil;
    private final NmsItemUtil nmsItemSupport;

    @Nullable
    public static NmsItemStackUtil getInstance() {
        try {
            if (instance == null) instance = new NmsItemStackUtil();
            return instance;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private NmsItemStackUtil() throws NoSuchMethodException {
        NmsOtherUtil nmsOtherUtil = NmsOtherUtil.getInstance();

        Class<?> craftItemStack = nmsOtherUtil.CraftItemStack();
        Class<?> NMSItemStack = nmsOtherUtil.ItemStack();
        setTagMethod = nmsOtherUtil.ItemStack_setTag();
        getTagMethod = nmsOtherUtil.ItemStack_getTag();

        bukkitCopyMethod = craftItemStack.getDeclaredMethod("asBukkitCopy", NMSItemStack);
        nmsCopyMethod = craftItemStack.getDeclaredMethod("asNMSCopy", ItemStack.class);

        nbtCompoundUtil = new NmsNbtTagCompoundUtil();
        nmsItemSupport = new NmsItemUtil();
    }

    public ItemStack asBukkitCopy(NmsItemWrapper nmsItemStack) {
        try {
            return (ItemStack) bukkitCopyMethod.invoke(null, nmsItemStack.getNmsItemStack());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Nullable
    public NmsItemWrapper asNMSCopy(ItemStack itemStack) {
        try {
            return new NmsItemWrapper(nmsCopyMethod.invoke(null, itemStack), nmsItemSupport, this);
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public NmsItemWrapper asWrapperCopy(ItemStack itemStack) {
        try {
            return new NmsItemWrapper(asNMSCopy(itemStack), nmsItemSupport, this);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}