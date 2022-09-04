package presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

public class BorderRound extends AbstractBorder {

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
//        Color oldColor = c.getParent().getBackground();
        g2d.setColor(Color.black);
        int offs = 1;
        int size = offs + offs;
        float arc = 0.2F * offs;
        Shape outer = new RoundRectangle2D.Float((x / 2), (y / 2), width, height, (offs * width), (offs * height));
        Shape inner = new RoundRectangle2D.Float((x + offs - 2), (y + offs - 2), (width - size + 4), (height - size + 4), arc, arc);
        Path2D path = new Path2D.Float(0);
        g2d.addRenderingHints(this.antialiasing);
        path.append(outer, false);
        path.append(inner, false);
        g2d.fill(path);
    }

    private final RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
}
