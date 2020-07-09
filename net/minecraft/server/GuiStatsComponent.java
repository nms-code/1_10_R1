package net.minecraft.server;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JComponent;
import javax.swing.Timer;

public class GuiStatsComponent extends JComponent {

    private static final DecimalFormat a = new DecimalFormat("########0.000");
    private final int[] b = new int[256];
    private int c;
    private final String[] d = new String[11];
    private final MinecraftServer e;

    public GuiStatsComponent(MinecraftServer minecraftserver) {
        this.e = minecraftserver;
        this.setPreferredSize(new Dimension(456, 246));
        this.setMinimumSize(new Dimension(456, 246));
        this.setMaximumSize(new Dimension(456, 246));
        (new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent actionevent) {
                GuiStatsComponent.this.a();
            }
        })).start();
        this.setBackground(Color.BLACK);
    }

    private void a() {
        long i = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.gc();
        this.d[0] = "Memory use: " + i / 1024L / 1024L + " mb (" + Runtime.getRuntime().freeMemory() * 100L / Runtime.getRuntime().maxMemory() + "% free)";
        this.d[1] = "Avg tick: " + GuiStatsComponent.a.format(this.a(this.e.h) * 1.0E-6D) + " ms";
        this.repaint();
    }

    private double a(long[] along) {
        long i = 0L;
        long[] along1 = along;
        int j = along.length;

        for (int k = 0; k < j; ++k) {
            long l = along1[k];

            i += l;
        }

        return (double) i / (double) along.length;
    }

    public void paint(Graphics graphics) {
        graphics.setColor(new Color(16777215));
        graphics.fillRect(0, 0, 456, 246);

        int i;

        for (i = 0; i < 256; ++i) {
            int j = this.b[i + this.c & 255];

            graphics.setColor(new Color(j + 28 << 16));
            graphics.fillRect(i, 100 - j, 1, j);
        }

        graphics.setColor(Color.BLACK);

        for (i = 0; i < this.d.length; ++i) {
            String s = this.d[i];

            if (s != null) {
                graphics.drawString(s, 32, 116 + i * 16);
            }
        }

    }
}
