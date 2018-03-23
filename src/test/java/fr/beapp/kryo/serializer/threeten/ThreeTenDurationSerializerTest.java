package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import fr.beapp.kryo.serializer.KryoTest;
import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.Duration;

public class ThreeTenDurationSerializerTest {

    private Kryo kryo;

    @Before
    public void init() {
        kryo = new Kryo();
        kryo.register(Duration.class, new ThreeTenDurationSerializer());
    }

    @Test
    public void testSerializer() {
        Duration value = Duration.ofDays(1).plusHours(5).plusMinutes(15).plusSeconds(34).plusNanos(123);
        KryoTest.assertDerializeAndDeserialize(kryo, value, Duration.class);
    }

}