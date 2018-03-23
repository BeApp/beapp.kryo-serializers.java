package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import fr.beapp.kryo.serializer.KryoTest;
import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.LocalDate;

public class ThreeTenLocalDateSerializerTest {

    private Kryo kryo;

    @Before
    public void init() {
        kryo = new Kryo();
        kryo.register(LocalDate.class, new ThreeTenLocalDateSerializer());
    }

    @Test
    public void testSerializer() {
        LocalDate value = LocalDate.of(2018, 3, 23);
        KryoTest.assertDerializeAndDeserialize(kryo, value, LocalDate.class);
    }

}