//HIDE
package pkg;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rectangle implements Shape
{
    private Color color = Color.BLACK;
    private boolean filled = false;
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle()
    {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
    }

    public Rectangle(double x, double y, double width, double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX()
    {
        return (int) Math.round(x);
    }

	public int getY()
    {
        return (int) Math.round(y);
    }

    public int getWidth()
    {
        return (int) Math.round(width);
    }


    public int getHeight()
    {
        return (int) Math.round(height);
    }


    public void translate(double dx, double dy)
    {
        x += dx;
        y += dy;
        Canvas.getInstance().repaint();
    }

    public void grow(double dw, double dh)
    {
        width += 2 * dw;
        height += 2 * dh;
        x -= dw;
        y -= dh;
        Canvas.getInstance().repaint();
    }

    public void setColor(Color newColor)
    {
        color = newColor;
        Canvas.getInstance().repaint();
    }

    public void draw()
    {
        filled = false;
        Canvas.getInstance().show(this);
    }

    public void fill()
    {
        filled = true;
        Canvas.getInstance().show(this);
    }


    public void undraw()
    {
        Canvas.getInstance().unshow(this);
    }

    public String toString()
    {
        return "Rectangle[x=" + getX() + ",y=" + getY() + ",width=" + getWidth() + ",height=" + getHeight() + "]";
    }

    public void paintShape(Graphics2D g2)
    {
        Rectangle2D.Double rect = new Rectangle2D.Double(getX(), getY(),
                getWidth(), getHeight());
        g2.setColor(new java.awt.Color((int) color.getRed(), (int) color.getGreen(), (int) color.getBlue()));
        if (filled)
        {
            g2.fill(rect);
        }
        else
        {
            g2.draw(rect);
        }
    }
	
	public boolean contains(Rectangle a)
	{
		if(x < a.getX() + a.getWidth() && x + width > a.getX() && y < a.getY() + a.getHeight() && y + height > a.getY())
		{
			return true;
		}
		return false;
	}
}
