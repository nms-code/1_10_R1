package net.minecraft.server;

public class DataInspectorItem extends DataInspectorTagged {

    private final String[] a;

    public DataInspectorItem(String s, String... astring) {
        super("id", s);
        this.a = astring;
    }

    NBTTagCompound b(DataConverter dataconverter, NBTTagCompound nbttagcompound, int i) {
        String[] astring = this.a;
        int j = astring.length;

        for (int k = 0; k < j; ++k) {
            String s = astring[k];

            nbttagcompound = DataConverterRegistry.a(dataconverter, nbttagcompound, i, s);
        }

        return nbttagcompound;
    }
}
