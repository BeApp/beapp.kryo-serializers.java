package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.threeten.bp.LocalDateTime;

/**
 * A Kryo serializer for ThreeTen {@link LocalDateTime}.
 * <p>
 * The LocalDateTime object is read or written as year, month and day-of-month, hour, minute, second and nano written in different integers.
 */
public class ThreeTenLocalDateTimeSerializer extends Serializer<LocalDateTime> {

    public ThreeTenLocalDateTimeSerializer() {
        setImmutable(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime read(final Kryo kryo, final Input input, final Class<LocalDateTime> type) {
        int year = input.readInt();
        int month = input.readInt();
        int day = input.readInt();
        int hour = input.readInt();
        int minute = input.readInt();
        int second = input.readInt();
        int nano = input.readInt();
        return LocalDateTime.of(year, month, day, hour, minute, second, nano);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(final Kryo kryo, final Output output, final LocalDateTime obj) {
        output.writeInt(obj.getYear());
        output.writeInt(obj.getMonthValue());
        output.writeInt(obj.getDayOfMonth());
        output.writeInt(obj.getHour());
        output.writeInt(obj.getMinute());
        output.writeInt(obj.getSecond());
        output.writeInt(obj.getNano());
    }
}
