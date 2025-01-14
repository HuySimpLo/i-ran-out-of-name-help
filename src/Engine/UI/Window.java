package Engine.UI;

import javax.swing.*;
import java.awt.*;

/**
 * The window to be shown.
 */
public class Window extends JFrame {
    /**
     * The current shown window.
     */
    private Screen currentCanonicalScreen;

    /**
     * Create a fixed window, with a fixed dimension, at center of the screen.
     *
     * @param dimension The dimension of the window.
     */
    public Window(Dimension dimension) {
        this.setSize(dimension);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * Replace the screen with another screen.
     *
     * @param anotherScreen The screen to replace with.
     */
    public void replaceCurrentScreenWith(Screen anotherScreen) {
        Screen currentOngoingScreen = getCurrentCanonicalScreen();
        if (currentOngoingScreen != null) currentOngoingScreen.dispose();

        this.getContentPane().invalidate();
        this.getContentPane().removeAll();

        this.getContentPane().add(anotherScreen);
        this.getContentPane().revalidate();
        anotherScreen.setVisible(true);

        anotherScreen.requestFocus();

        this.setCurrentCanonicalScreen(anotherScreen);
        anotherScreen.setParentWindow(this);
    }

    /**
     * Get current window's dimensions.
     *
     * @return The dimensions.
     */
    public Dimension getDimension() {
        return super.getSize();
    }

    /**
     * Get current showing screen.
     *
     * @return The current screen.
     */
    public Screen getCurrentCanonicalScreen() {
        return currentCanonicalScreen;
    }

    /**
     * Set current showing screen.
     * Not intended to be called manually for outside classes.
     * Use {@link #replaceCurrentScreenWith(Screen)} as the intended way.
     *
     * @param currentCanonicalScreen The screen.
     */
    public void setCurrentCanonicalScreen(Screen currentCanonicalScreen) {
        this.currentCanonicalScreen = currentCanonicalScreen;
    }
}
