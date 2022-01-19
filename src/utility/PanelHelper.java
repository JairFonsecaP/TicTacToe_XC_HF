package utility;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelHelper
{
    private static final int SmallSize = 10;
    private static final int LargeSize = 20;

    private PanelHelper()
    { }

    public static Component createSmallSeparator()
    {
        return createSeparator(SmallSize, SmallSize);
    }

    public static Component createLargeSeparator()
    {
        return createSeparator(LargeSize, LargeSize);
    }

    public static Component createSeparator(int width, int height)
    {
        return Box.createRigidArea(new Dimension(width, height));
    }

    public static Border createSmallEmptyBorder()
    {
        return createEmptyBorder(SmallSize, SmallSize, SmallSize, SmallSize);
    }

    public static Border createLargeEmptyBorder()
    {
        return createEmptyBorder(LargeSize, LargeSize, LargeSize, LargeSize);
    }

    public static Border createEmptyBorder(int top, int left, int bottom, int right)
    {
        return BorderFactory.createEmptyBorder(top, left, bottom, right);
    }

}
