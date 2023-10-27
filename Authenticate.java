package portal.screenplay.action;

import net.serenitybdd.screenplay.Actor;

public class Authenticate implements net.serenitybdd.screenplay.Ability {
    private final String username;
    private final String password;

    private Authenticate(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Authenticate with(
            String username,
            String password
    ) {
        return new Authenticate(username, password);
    }

    public static Authenticate as(Actor actor) {
//        if (actor.abilityTo(Authenticate.class) == null) {
//            throw new CannotAuthenicateException(actor.getName());
//        }

        return actor.abilityTo(Authenticate.class);
    }

    public String userName() {
        return this.username;
    }

    public String password() {
        return this.password;
    }
}
