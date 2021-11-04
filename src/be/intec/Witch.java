package be.intec;

import java.util.Objects;

public class Witch extends MagicMonster{
    private String name;

    public Witch(){
        this(100);
    }

    public Witch(int hp){
        this(hp, 150);
    }

    public Witch(int hp, int magicP){
        this(hp, magicP, "Gargamel");
    }

    public Witch(int hp, int magicP, String name){
        super(hp, magicP);
        this.name = name;
    }

    public int fireballAttack(){
        if (super.useMP(5)){
            super.setMagicPoints(super.getMagicPoints() - 5);
            System.out.println("Witch attacks! fwooosh!!");
            return 8;
        } else {
            System.out.println("Witch attacks! out of magic points");
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Witch witch = (Witch) o;
        return Objects.equals(name, witch.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return String.format("Witch: %s%n%s", name, super.toString());
    }
}
