package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.threeten.bp.Duration;

/**
 * A Kryo serializer for ThreeTen {@link Duration}.
 * <p>
 * The LocalDateTime object is read or written as hour, minute, second and nano written in different integers.
 */
public class ThreeTenDurationSerializer extends Serializer<Duration> {

    public ThreeTenDurationSerializer() {
        setImmutable(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Duration read(final Kryo kryo, final Input input, final Class<Duration> type) {
        long seconds = input.readLong();
        int nano = input.readInt();
        return Duration.ofSeconds(seconds, nano);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(final Kryo kryo, final Output output, final Duration obj) {
        output.writeLong(obj.getSeconds());
        output.writeInt(obj.getNano());
    }
}
