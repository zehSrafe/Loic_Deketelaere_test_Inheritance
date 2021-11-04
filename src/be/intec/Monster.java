package be.intec;

import java.util.Objects;

public abstract class Monster {
    private int hitPoints;
    private final int maxHP;

    public Monster(int maxHP) {
        setHitPoints(maxHP);
        this.maxHP = maxHP;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void heal(int healPoints){
        setHitPoints(getHitPoints() + healPoints);
    }

    public boolean takeDamage(int damagePoints){
        setHitPoints(getHitPoints() - damagePoints);
        return getHitPoints() > damagePoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return hitPoints == monster.hitPoints && maxHP == monster.maxHP;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hitPoints, maxHP);
    }

    @Override
    public String toString() {
        return String.format("Max HP: %d, Current HP: %d%n", maxHP, getHitPoints());
    }
}
