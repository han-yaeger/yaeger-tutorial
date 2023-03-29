package com.github.hanyaeger.tutorial.settings;

public enum EnemyDamage {

    SWORDFISH(1),
    SHARKY(3),
    POISON_BUBBLE(2);

    private int damage;

    EnemyDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
