package me.coding.wetter;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import me.coding.wetter.message.SetRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author G002299
 * @version 2021/3/22
 */
public class AkkademyDb extends AbstractBehavior<SetRequest> {

    protected final Map<String, Object> map = new HashMap<>();

    public AkkademyDb(ActorContext<SetRequest> context) {
        super(context);
    }

    public static Behavior<SetRequest> create() {
        return Behaviors.setup(AkkademyDb::new);
    }

    @Override
    public Receive<SetRequest> createReceive() {
        return newReceiveBuilder().onMessage(SetRequest.class, this::onSetRequest).build();
    }

    private Behavior<SetRequest> onSetRequest(SetRequest request) {
        getContext().getLog().info("Received Set request: {}", request);
        map.put(request.getKey(), request.getValue());
        return this;
    }
}
