package Game.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NPCAggressive extends Player {
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public NPCAggressive(int x, int y) {
        super(x, y);
        // Set animation paths for idle state
        this.animationIdleUp = "/Player/wizzard_m_idle_anim_f0.png";
        this.animationIdleDown = "/Player/wizzard_m_idle_anim_f1.png";
        this.animationIdleLeft = "/Player/wizzard_m_idle_anim_f2.png";
        this.animationIdleRight = "/Player/wizzard_m_idle_anim_f3.png";
        // Set animation paths for running state
        this.animationRunUp = "/Player/wizzard_m_run_anim_f0.png";
        this.animationRunDown = "/Player/wizzard_m_run_anim_f1.png";
        this.animationRunLeft = "/Player/wizzard_m_run_anim_f2.png";
        this.animationRunRight = "/Player/wizzard_m_run_anim_f3.png";
    }


    //   @Override
    public void update() {
        //   super.update();
        // Implement aggressive AI logic movement

        Player player = null;

        // Get the player instance here (Assuming Player is a class with getX() and getY() methods)

        int playerX = player.getX();
        int playerY = player.getY();

        int deltaX = playerX - getX();
        int deltaY = playerY - getY();

        // Choose a direction towards the player and move
        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            // Move horizontally
            if (deltaX > 0) {
                setDirection(Direction.RIGHT);
                addX(1);
            } else {
                setDirection(Direction.LEFT);
                addX(-1);
            }
        } else {
            // Move vertically
            if (deltaY > 0) {
                setDirection(Direction.DOWN);
                addY(1);
            } else {
                setDirection(Direction.UP);
                addY(-1);
            }
        }

        spriteCounter++;

    }
}