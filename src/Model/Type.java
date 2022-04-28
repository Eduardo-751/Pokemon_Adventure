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
            new String[]{"Steel"});

    private final String[] SuperEffective;
    private final String[] NotVeryEffective;
    private final String[] NoEffect;

    //Check if the type have weakness
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
