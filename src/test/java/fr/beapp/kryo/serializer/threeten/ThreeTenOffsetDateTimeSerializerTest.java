package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import fr.beapp.kryo.serializer.KryoTest;
import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;

public class ThreeTenOffsetDateTimeSerializerTest {

    private Kryo kryo;

    @Before
    public void init() {
        kryo = new Kryo();
        kryo.register(OffsetDateTime.class, new ThreeTenOffsetDateTimeSerializer());
    }

    @Test
    public void testSerializer() {
        OffsetDateTime value1 = OffsetDateTime.of(2018, 3, 23, 11, 34, 20, 123, ZoneOffset.UTC);
        KryoTest.assertDerializeAndDeserialize(kryo, value1, OffsetDateTime.class);

        OffsetDateTime value2 = OffsetDateTime.of(2018, 3, 23, 11, 34, 20, 123, ZoneOffset.ofHours(2));
        KryoTest.assertDerializeAndDeserialize(kryo, value2, OffsetDateTime.class);
    }

}