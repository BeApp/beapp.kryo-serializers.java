package fr.beapp.kryo.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.junit.Assert;

public class KryoTest {

    private KryoTest() {
    }

    public static <T> void assertDerializeAndDeserialize(final Kryo kryo, final Object o, final Class<T> clazz) {
        final byte[] serialized = serialize(kryo, o);
        final T deserialized = deserialize(kryo, serialized, clazz);
        Assert.assertEquals(deserialized, o);
        Assert.assertEquals(kryo.copy(o), o);
    }

    public static byte[] serialize(final Kryo kryo, final Object o) {
        if (o == null) {
            throw new NullPointerException("Can't serialize null");
        }

        final Output output = new Output(4096);
        kryo.writeObject(output, o);
        output.flush();
        return output.getBuffer();
    }

    public static <T> T deserialize(final Kryo kryo, final byte[] in, final Class<T> clazz) {
        final Input input = new Input(in);
        return kryo.readObject(input, clazz);
    }

}
