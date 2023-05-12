package com.github.hanyaeger.tutorial.platforms;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.Player;
import com.github.hanyaeger.tutorial.text.Text;


public class SecondenPlatform extends Platform implements Collided, TimerContainer, UpdateExposer {
    private Text secondenText;
    private int seconden;
    private boolean aangeraakt= false;

    public SecondenPlatform(Text secondenText, Coordinate2D initialLocation, int seconden) {
        super(initialLocation);
        this.seconden = seconden;
        this.secondenText = secondenText;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Player){
            aangeraakt = true;
            if (seconden <= 0){
                remove();
                secondenText.remove();
            }
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new Timer(1000) {
            @Override
            public void onAnimationUpdate(long l) {
                if (aangeraakt) {
                    seconden--;
                }
            }
        });
    }


    @Override
    public void explicitUpdate(long l) {
        secondenText.setText("sec over ", seconden);
        aangeraakt = false;
    }
}
