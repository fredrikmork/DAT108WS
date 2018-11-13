import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

class GraphicPanel extends JPanel {
    private boolean display_plot;
    private DataPanel d;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.black);
        g2d.setStroke(new BasicStroke());
        g2d.setFont(new Font("Century Schoolbook", Font.PLAIN, 12));
        if (d.isInitialized() && display_plot) {
            d.refreshData();
            Float xLower = d.getXLower();
            Float xUpper = d.getXUpper();
            Float xInterval = d.getXInterval();
            Float yLower = d.getYLower();
            Float yUpper = d.getYUpper();
            Float yInterval = d.getYInterval();
            Float dx = xUpper - xLower;
            Float dy = yUpper - yLower;

            drawCenteredString(g2d, d.getTitle(), 250, 25, (float) 0.);
            drawCenteredString(g2d, d.getXTitle(), 250, 475, (float) 0.);
            drawCenteredString(g2d, d.getYTitle(), 25, 250,
                (float) -Math.PI / 2);
            drawCenteredString(g2d, xLower.toString(), 50, 475, (float) 0);
            drawCenteredString(g2d, xUpper.toString(), 450, 475, (float) 0);
            drawCenteredString(g2d, yLower.toString(), 25, 450, (float) 0);
            drawCenteredString(g2d, yUpper.toString(), 25, 50, (float) 0);

            g2d.setPaint(Color.gray);
            for (Float x = 50f; x <= 450; x += 400 * xInterval / dx)
                g2d.draw(new Line2D.Float(x, 450, x, 50));
            for (Float y = 50f; y <= 450; y += 400 * yInterval / dy)
                g2d.draw(new Line2D.Float(45, y, 450, y));

            g2d.setPaint(Color.red);
            Float diam = 8f;
            int num_points = d.getNumberOfPoints();
            for (int i = 0; i < num_points; i++) {
                Float ex = 400 * (d.getPoint(i).x - xLower) / dx + 50;
                ex -= diam / 2;
                Float ey = -400 * (d.getPoint(i).y - yLower) / dy + 450;
                ey -= diam / 2;
                g2d.fill(new Ellipse2D.Float(ex, ey, diam, diam));
            }
        }
    }

    void setDataPanel(DataPanel new_d) {
        d = new_d;
    }

    void setDisplayPlot(boolean new_display) {
        display_plot = new_display;
    }

    private void drawCenteredString(Graphics2D g2d, String string,
                                    int x0, int y0, float angle) {
        FontRenderContext frc = g2d.getFontRenderContext();
        Rectangle2D bounds = g2d.getFont().getStringBounds(string, frc);
        LineMetrics metrics = g2d.getFont().getLineMetrics(string, frc);
        if (angle == 0) {
            g2d.drawString(string, x0 - (float) bounds.getWidth() / 2,
                y0 + metrics.getHeight() / 2);
        } else {
            g2d.rotate(angle, x0, y0);
            g2d.drawString(string, x0 - (float) bounds.getWidth() / 2,
                y0 + metrics.getHeight() / 2);
            g2d.rotate(-angle, x0, y0);
        }
    }
}
