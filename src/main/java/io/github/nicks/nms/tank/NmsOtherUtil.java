package io.github.nicks.nms.tank;

import io.github.nicks.version.Version;
import io.github.nicks.version.VersionController;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class NmsOtherUtil {

    private static NmsOtherUtil instance;

    public static NmsOtherUtil getInstance() {
        if (instance == null) instance = new NmsOtherUtil();
        return instance;
    }

    private NmsOtherUtil() {}

    private final Version version = VersionController.getINSTANCE().getVersion();;
    private final String nmsPackage = "net.minecraft.server." + version.getVersion();

    private Class<?> ItemStackClass;
    public Class<?> ItemStack() {
        if (ItemStackClass == null) {
            try {
                ItemStackClass = Class.forName(nmsPackage + ".ItemStack");
            } catch (Exception ignored) {
                try {
                    ItemStackClass = Class.forName("net.minecraft.world.item.ItemStack");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return ItemStackClass;
    }

    private Class<?> CraftItemStackClass;
    public Class<?> CraftItemStack() {
        if (CraftItemStackClass == null) {
            try {
                CraftItemStackClass = Class.forName("org.bukkit.craftbukkit." + version.getVersion() + ".inventory.CraftItemStack");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return CraftItemStackClass;
    }

    private Method ItemStackSetTagMethod;
    public Method ItemStack_setTag() {
        if (ItemStackSetTagMethod == null) {
            try {
                ItemStackSetTagMethod = ItemStack().getMethod("setTag", NBTTagCompound());
            } catch (NoSuchMethodException ignored) {
                try {
                    Map<String, String> methodNameMap = new HashMap<>();
                    methodNameMap.put("v1_12_R1", "c");
                    methodNameMap.put("v1_13_R1", "c");
                    methodNameMap.put("v1_13_R2", "c");
                    methodNameMap.put("v1_14_R1", "c");
                    methodNameMap.put("v1_15_R1", "c");
                    methodNameMap.put("v1_16_R1", "c");
                    methodNameMap.put("v1_16_R2", "c");
                    methodNameMap.put("v1_16_R3", "c");
                    methodNameMap.put("v1_17_R1", "c");
                    methodNameMap.put("v1_18_R1", "c");
                    methodNameMap.put("v1_18_R2", "c");
                    methodNameMap.put("v1_19_R1", "c");
                    methodNameMap.put("v1_19_R2", "c");
                    methodNameMap.put("v1_19_R3", "c");
                    methodNameMap.put("v1_20_R1", "c");

                    ItemStackSetTagMethod = ItemStack().getDeclaredMethod(methodNameMap.get(version.getVersion()), NBTTagCompound());
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return ItemStackSetTagMethod;
    }

    private Method ItemStackGetTagMethod;
    public Method ItemStack_getTag() {
        if (ItemStackGetTagMethod == null) {
            try {
                ItemStackGetTagMethod = ItemStack().getMethod("getTag");
            } catch (NoSuchMethodException ignored) {
                try {
                    Map<String, String> methodNameMap = new HashMap<>();
                    methodNameMap.put("v1_12_R1", "u");
                    methodNameMap.put("v1_13_R1", "u");
                    methodNameMap.put("v1_13_R2", "u");
                    methodNameMap.put("v1_14_R1", "u");
                    methodNameMap.put("v1_15_R1", "u");
                    methodNameMap.put("v1_16_R1", "u");
                    methodNameMap.put("v1_16_R2", "u");
                    methodNameMap.put("v1_16_R3", "u");
                    methodNameMap.put("v1_17_R1", "u");
                    methodNameMap.put("v1_18_R1", "u");
                    methodNameMap.put("v1_18_R2", "u");
                    methodNameMap.put("v1_19_R1", "u");
                    methodNameMap.put("v1_19_R2", "u");
                    methodNameMap.put("v1_19_R3", "u");
                    methodNameMap.put("v1_20_R1", "v");

                    ItemStackGetTagMethod = ItemStack().getDeclaredMethod(methodNameMap.get(version.getVersion()));
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return ItemStackGetTagMethod;
    }

    private Class<?> NBTTagCompoundClass;
    public Class<?> NBTTagCompound() {
        if (NBTTagCompoundClass == null) {
            try {
                NBTTagCompoundClass = Class.forName(nmsPackage + ".NBTTagCompound");
            } catch (Exception ignored) {
                try {
                    NBTTagCompoundClass = Class.forName("net.minecraft.nbt.NBTTagCompound");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return NBTTagCompoundClass;
    }

    private Method getStringAtNBTTagCompound;
    public Method NBTTagCompound_getString() {
        if (getStringAtNBTTagCompound == null) {
            try {
                getStringAtNBTTagCompound = NBTTagCompound().getMethod("getString", String.class);
            } catch (Exception ignored) {
                try {
                    Map<String, String> methodNameMap = new HashMap<>();
                    methodNameMap.put("v1_12_R1", "l");
                    methodNameMap.put("v1_13_R1", "l");
                    methodNameMap.put("v1_13_R2", "l");
                    methodNameMap.put("v1_14_R1", "l");
                    methodNameMap.put("v1_15_R1", "l");
                    methodNameMap.put("v1_16_R1", "l");
                    methodNameMap.put("v1_16_R2", "l");
                    methodNameMap.put("v1_16_R3", "l");
                    methodNameMap.put("v1_17_R1", "l");
                    methodNameMap.put("v1_18_R1", "l");
                    methodNameMap.put("v1_18_R2", "l");
                    methodNameMap.put("v1_19_R1", "l");
                    methodNameMap.put("v1_19_R2", "l");
                    methodNameMap.put("v1_19_R3", "l");
                    methodNameMap.put("v1_20_R1", "l");

                    getStringAtNBTTagCompound = NBTTagCompoundClass.getDeclaredMethod(methodNameMap.get(version.getVersion()), String.class);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return getStringAtNBTTagCompound;
    }

    private Method setStringAtNBTTagCompound;
    public Method NBTTagCompound_setString() {
        if (setStringAtNBTTagCompound == null) {
            try {
                setStringAtNBTTagCompound = NBTTagCompound().getMethod("setString", String.class, String.class);
            } catch (Exception ignored) {
                try {
                    Map<String, String> methodNameMap = new HashMap<>();
                    methodNameMap.put("v1_12_R1", "a");
                    methodNameMap.put("v1_13_R1", "a");
                    methodNameMap.put("v1_13_R2", "a");
                    methodNameMap.put("v1_14_R1", "a");
                    methodNameMap.put("v1_15_R1", "a");
                    methodNameMap.put("v1_16_R1", "a");
                    methodNameMap.put("v1_16_R2", "a");
                    methodNameMap.put("v1_16_R3", "a");
                    methodNameMap.put("v1_17_R1", "a");
                    methodNameMap.put("v1_18_R1", "a");
                    methodNameMap.put("v1_18_R2", "a");
                    methodNameMap.put("v1_19_R1", "a");
                    methodNameMap.put("v1_19_R2", "a");
                    methodNameMap.put("v1_19_R3", "a");
                    methodNameMap.put("v1_20_R1", "a");

                    setStringAtNBTTagCompound = NBTTagCompoundClass.getDeclaredMethod(methodNameMap.get(version.getVersion()), String.class, String.class);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return setStringAtNBTTagCompound;
    }

    private Class<?> ItemClass;
    public Class<?> Item() {
        if (ItemClass == null) {
            try {
                ItemClass = Class.forName(nmsPackage + ".Item");
            } catch (Exception ignored) {
                try {
                    ItemClass = Class.forName("net.minecraft.world.item.Item");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return ItemClass;
    }

    private Method getDescriptionIdAtItem;
    public Method Item_getDescriptionId() {
        try {
            getDescriptionIdAtItem = ItemClass.getMethod("getDescriptionId", ItemStack());
        } catch (NoSuchMethodException ignored) {
            try {
                Map<String, String> methodNameMap = new HashMap<>();
                methodNameMap.put("v1_12_R1", "j");
                methodNameMap.put("v1_13_R2", "h");
                methodNameMap.put("v1_14_R1", "f");
                methodNameMap.put("v1_15_R1", "f");
                methodNameMap.put("v1_16_R1", "f");
                methodNameMap.put("v1_16_R2", "f");
                methodNameMap.put("v1_16_R3", "f");
                methodNameMap.put("v1_17_R1", "j");
                methodNameMap.put("v1_18_R1", "j");
                methodNameMap.put("v1_18_R2", "j");
                methodNameMap.put("v1_19_R1", "j");
                methodNameMap.put("v1_19_R2", "j");
                methodNameMap.put("v1_19_R3", "j");
                methodNameMap.put("v1_20_R1", "j");

                getDescriptionIdAtItem = ItemClass.getMethod(methodNameMap.get(version.getVersion()), ItemStack());
            } catch (NoSuchMethodException ex) {
                ex.printStackTrace();
            }
        }
        return getDescriptionIdAtItem;
    }

    private Method useAtItem;
    public Method Item_use() {
        try {
            useAtItem = ItemClass.getMethod("use", World(), EntityHuman(), EnumHand());
        } catch (NoSuchMethodException ignored) {
            try {
                Map<String, String> methodNameMap = new HashMap<>();
                methodNameMap.put("v1_12_R1", "a");
                methodNameMap.put("v1_13_R1", "a");
                methodNameMap.put("v1_13_R2", "a");
                methodNameMap.put("v1_14_R1", "a");
                methodNameMap.put("v1_15_R1", "a");
                methodNameMap.put("v1_16_R1", "a");
                methodNameMap.put("v1_16_R2", "a");
                methodNameMap.put("v1_16_R3", "a");
                methodNameMap.put("v1_17_R1", "a");
                methodNameMap.put("v1_18_R1", "a");
                methodNameMap.put("v1_18_R2", "a");
                methodNameMap.put("v1_19_R1", "a");
                methodNameMap.put("v1_19_R2", "a");
                methodNameMap.put("v1_19_R3", "a");
                methodNameMap.put("v1_20_R1", "a");

                useAtItem = ItemClass.getMethod(methodNameMap.get(version.getVersion()), World(), EntityHuman(), EnumHand());
            } catch (NoSuchMethodException ex) {
                ex.printStackTrace();
            }
        }
        return useAtItem;
    }

    private Class<?> WorldClass;
    public Class<?> World() {
        if (WorldClass == null) {
            try {
                WorldClass = Class.forName(nmsPackage + ".World");
            } catch (ClassNotFoundException ignored) {
                try {
                    WorldClass = Class.forName("net.minecraft.world.level.World");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return WorldClass;
    }

    private Class<?> EntityHumanClass;
    public Class<?> EntityHuman() {
        if (EntityHumanClass == null) {
            try {
                EntityHumanClass = Class.forName(nmsPackage + ".EntityHuman");
            } catch (ClassNotFoundException ignored) {
                try {
                    EntityHumanClass = Class.forName("net.minecraft.world.entity.player.EntityHuman");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return EntityHumanClass;
    }

    private Class<?> EnumHandClass;
    public Class<?> EnumHand() {
        if (EnumHandClass == null) {
            try {
                EnumHandClass = Class.forName(nmsPackage + ".EnumHand");
            } catch (ClassNotFoundException ignored) {
                try {
                    EnumHandClass = Class.forName("net.minecraft.world.EnumHand");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return EnumHandClass;
    }
}
