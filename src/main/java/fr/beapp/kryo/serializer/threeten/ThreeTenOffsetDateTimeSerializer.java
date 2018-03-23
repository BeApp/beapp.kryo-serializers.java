package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;

/**
 * A Kryo serializer for ThreeTen {@link OffsetDateTime}.
 * <p>
 * The LocalDateTime object is read or written as year, month and day-of-month, hour, minute, second and nano written in different integers.
 * The Offset object is read or written as total seconds in dedicated integer.
 */
public class ThreeTenOffsetDateTimeSerializer extends Serializer<OffsetDateTime> {

    public ThreeTenOffsetDateTimeSerializer() {
        setImmutable(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime read(final Kryo kryo, final Input input, final Class<OffsetDateTime> type) {
        int year = input.readInt();
        int month = input.readInt();
        int day = input.readInt();
        int hour = input.readInt();
        int minute = input.readInt();
        int second = input.readInt();
        int nano = input.readInt();
        int offsetSeconds = input.readInt();
        return OffsetDateTime.of(year, month, day, hour, minute, second, nano, ZoneOffset.ofTotalSeconds(offsetSeconds));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(final Kryo kryo, final Output output, final OffsetDateTime obj) {
        output.writeInt(obj.getYear());
        output.writeInt(obj.getMonthValue());
        output.writeInt(obj.getDayOfMonth());
        output.writeInt(obj.getHour());
        output.writeInt(obj.getMinute());
        output.writeInt(obj.getSecond());
        output.writeInt(obj.getNano());
        output.writeInt(obj.getOffset().getTotalSeconds());
    }
}
