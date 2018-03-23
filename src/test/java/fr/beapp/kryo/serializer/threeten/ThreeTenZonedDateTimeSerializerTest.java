package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import fr.beapp.kryo.serializer.KryoTest;
import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

public class ThreeTenZonedDateTimeSerializerTest {

    private Kryo kryo;

    @Before
    public void init() {
        kryo = new Kryo();
        kryo.register(ZonedDateTime.class, new ThreeTenZonedDateTimeSerializer());
    }

    @Test
    public void testSerializer() {
        ZonedDateTime value1 = ZonedDateTime.of(2018, 3, 23, 11, 34, 20, 123, ZoneId.of("Z"));
        KryoTest.assertDerializeAndDeserialize(kryo, value1, ZonedDateTime.class);

        ZonedDateTime value2 = ZonedDateTime.of(2018, 3, 23, 11, 34, 20, 123, ZoneId.of("Europe/Paris"));
        KryoTest.assertDerializeAndDeserialize(kryo, value2, ZonedDateTime.class);
    }

}