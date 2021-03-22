package me.coding.wetter.ch1;

import akka.actor.testkit.typed.javadsl.LoggingTestKit;
import akka.actor.testkit.typed.javadsl.TestKitJunitResource;
import akka.actor.typed.ActorRef;
import com.typesafe.config.ConfigFactory;
import me.coding.wetter.ch1.message.SetRequest;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author G002299
 * @version 2021/3/22
 */
public class AkkademyDbTest {

    @ClassRule
    public static final TestKitJunitResource testKit = new TestKitJunitResource();

    @Before
    public void before() {
        ConfigFactory.parseString("akka.loglevel = DEBUG \n" + "akka.log-config-on-start = on \n");
    }

    @Test
    public void itShouldPlaceKeyValueFromSetMessageIntoMap() {
        ActorRef<SetRequest> actorRef = testKit.spawn(AkkademyDb.create());
        SetRequest setRequest = new SetRequest("key", "value");

        LoggingTestKit.info("Received Set Request: " + setRequest.toString()).expect(testKit.system(), () -> {
            actorRef.tell(setRequest);
            return null;
        });
    }
}