package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.threeten.bp.LocalTime;

/**
 * A Kryo serializer for ThreeTen {@link LocalTime}.
 * <p>
 * The LocalDateTime object is read or written as hour, minute, second and nano written in different integers.
 */
public class ThreeTenLocalTimeSerializer extends Serializer<LocalTime> {

    public ThreeTenLocalTimeSerializer() {
        setImmutable(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime read(final Kryo kryo, final Input input, final Class<LocalTime> type) {
        int hour = input.readInt();
        int minute = input.readInt();
        int second = input.readInt();
        int nano = input.readInt();
        return LocalTime.of(hour, minute, second, nano);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(final Kryo kryo, final Output output, final LocalTime obj) {
        output.writeInt(obj.getHour());
        output.writeInt(obj.getMinute());
        output.writeInt(obj.getSecond());
        output.writeInt(obj.getNano());
    }
}
