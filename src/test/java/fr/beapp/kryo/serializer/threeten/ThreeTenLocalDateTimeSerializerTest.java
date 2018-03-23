package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import fr.beapp.kryo.serializer.KryoTest;
import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.LocalDateTime;

public class ThreeTenLocalDateTimeSerializerTest {

    private Kryo kryo;

    @Before
    public void init() {
        kryo = new Kryo();
        kryo.register(LocalDateTime.class, new ThreeTenLocalDateTimeSerializer());
    }

    @Test
    public void testSerializer() {
        LocalDateTime value = LocalDateTime.of(2018, 3, 23, 11, 34, 20, 123);
        KryoTest.assertDerializeAndDeserialize(kryo, value, LocalDateTime.class);
    }

}