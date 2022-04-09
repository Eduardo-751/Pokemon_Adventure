package Model;

public enum Type {
    NORMAL(new String[]{},
            new String[]{"Rock"},
            new String[]{"Ghost"}),
    FIRE(new String[]{"Grass", "Ice", "Bug"},
            new String[]{"Fire", "Water", "Rock", "Dragon"},
            new String[]{}),
    WATER(new String[]{"Fire", "Rock", "Ground"},
            new String[]{"Water", "Grass", "Dragon"},
            new String[]{}),
    GRASS(new String[]{"Water", "Ground", "Rock"},
            new String[]{"Fire", "Grass", "Poison", "Flying", "Bug", "Dragon", "Steel"},
            new String[]{}),
    BUG(new String[]{"Grass", "Psychic", "Dark"},
            new String[]{"Fighting", "Flying", "Poison", "Ghost", "Steel", "Fire"},
            new String[]{}),
    ROCK(new String[]{"Flying", "Bug", "Fire"},
            new String[]{"Fighting", "Ground", "Steel"},
            new String[]{}),
    DRAGON(new String[]{"Dragon"},
            new String[]{"Steel"},
            new String[]{}),
    DARK(new String[]{"Psychic", "Ghost"},
            new String[]{"Fighting", "Dark", "Steel"},
            new String[]{}),
    FIGHTING(new String[]{"Normal", "Rock", "Steel", "Ice", "Dark"},
            new String[]{"Flying", "Poison", "Bug", "Psychic"},
            new String[]{"Ghost"}),
    POISON(new String[]{"Grass"},
            new String[]{"Poison", "Ground", "Rock", "Bug"},
            new String[]{"Steel"}),
    FLYING(new String[]{"Fighting", "Grass"},
            new String[]{"Rock", "Steel", "Electric"},
            new String[]{}),
    GROUND(new String[]{"Poison", "Rock", "Steel", "Fire", "Electric"},
            new String[]{"Bug", "Grass"},
            new String[]{"Flying"}),
    GHOST(new String[]{"Ghost", "Psychic"},
            new String[]{"Steel", "Dark"},
            new String[]{"Normal"}),
    STEEL(new String[]{"Rock", "Ice"},
            new String[]{"Steel", "Fire", "Water", "Electric"},
            new String[]{}),
    ELECTRIC(new String[]{"Water", "Flying"},
            new String[]{"Grass", "Electric", "Dragon"},
            new String[]{"Ground"}),
    PSYCHIC(new String[]{"Fighting", "Poison"},
            new String[]{"Psychic", "Steel"},
            new String[]{"Dark"}),
    ICE(new String[]{"Grass", "Ground", "Flying", "Dragon"},
            new String[]{"Fire", "Water", "Ice", "Steel"},
            new String[]{});

    private final String[] SuperEffective;
    private final String[] NotVeryEffective;
    private final String[] NoEffect;

    Type(String[] superEffective, String[] notVeryEffective, String[] noEffect) {
        SuperEffective = superEffective;
        NotVeryEffective = notVeryEffective;
        NoEffect = noEffect;
    }

    private boolean contains(String[] t, Type p) {
        if (t.length == 0) {
            return false;
        }

        for (String type : t) {
            if (type.equalsIgnoreCase(p + "")) {
                return true;
            }
        }
        return false;
    }

    public boolean SuperEffective(Type t) {
        return contains(SuperEffective, t);
    }

    public boolean NotVeryEffective(Type t) {
        return contains(NotVeryEffective, t);
    }

    public boolean NoEffect(Type t) {
        return contains(NoEffect, t);
    }
}
