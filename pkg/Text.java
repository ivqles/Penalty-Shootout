//HIDE
package pkg;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class Text implements Shape
{
    private Color color = Color.BLACK;
    private JLabel label = new JLabel();
    private double x;
    private double y;
    private double xGrow;
    private double yGrow;

    public Text(double x, double y, String message)
    {
        this.x = x;
        this.y = y;
        label.setText(message);
    }


    public int getX()
    {
        return (int) Math.round(x - xGrow) ;
    }

    public int getY()
    {
        return (int) Math.round(y - yGrow);
    }

    public int getWidth()
    {
        return (int) Math.round(label.getPreferredSize().getWidth() + 2 * xGrow);
    }

    public int getHeight()
    {
        return (int) Math.round(label.getPreferredSize().getHeight() + 2 * yGrow);
    }

    public void translate(double dx, double dy)
    {
        x += dx;
        y += dy;
        Canvas.getInstance().repaint();
    }

    public void grow(double dw, double dh)
    {
        xGrow += dw;
        yGrow += dh;
        Canvas.getInstance().repaint();
    }

	public void setColor(Color newColor)
    {
        color = newColor;
        Canvas.getInstance().repaint();
    }

    public void draw()
    {
        Canvas.getInstance().show(this);
    }

    public void undraw()
    {
        Canvas.getInstance().unshow(this);
    }

    public void setText(String update)
	{
		label.setText(update);
		Canvas.getInstance().repaint();
	}

    public String toString()
    {
        return "Text[x=" + getX() + ",y=" + getY() + ",message=" + label.getText() + "]";
    }

    public void paintShape(Graphics2D g2)
    {
        if (color != null)
        {
            label.setForeground(new java.awt.Color((int) color.getRed(), (int) color.getGreen(), (int) color.getBlue()));
            Dimension dim = label.getPreferredSize();
            if (dim.width > 0 && dim.height > 0)
            {
                label.setBounds(0, 0, dim.width, dim.height);
                g2.translate(getX(), getY());
                g2.scale(getWidth() / dim.width, getHeight() / dim.height);
                label.paint(g2);
            }
        }
    }
}
