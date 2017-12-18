package ch.martinelli.sakila.entity;

public class ActorInfo {

    private final Integer actorId;
    private final String firstName;
    private final String lastName;

    public ActorInfo(Integer actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getActorId() {
        return actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
