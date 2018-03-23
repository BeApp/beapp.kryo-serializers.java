package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import fr.beapp.kryo.serializer.KryoTest;
import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.LocalTime;

public class ThreeTenLocalTimeSerializerTest {

    private Kryo kryo;

    @Before
    public void init() {
        kryo = new Kryo();
        kryo.register(LocalTime.class, new ThreeTenLocalTimeSerializer());
    }

    @Test
    public void testSerializer() {
        LocalTime value = LocalTime.of(11, 34, 20, 123);
        KryoTest.assertDerializeAndDeserialize(kryo, value, LocalTime.class);
    }

}