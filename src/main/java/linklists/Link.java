package linklists;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Link {
    private final int value;
    @Setter
    private Link next;

    public Link(final int value) {
        this.value = value;
    }
}
