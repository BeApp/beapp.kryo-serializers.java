package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

/**
 * A Kryo serializer for ThreeTen {@link ZonedDateTime}.
 * <p>
 * The LocalDateTime object is read or written as year, month and day-of-month, hour, minute, second and nano written in different integers.
 * The Zone object is read or written as id in dedicated string.
 */
public class ThreeTenZonedDateTimeSerializer extends Serializer<ZonedDateTime> {

    public ThreeTenZonedDateTimeSerializer() {
        setImmutable(true);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ZonedDateTime read(final Kryo kryo, final Input input, final Class<ZonedDateTime> type) {
        int year = input.readInt();
        int month = input.readInt();
        int day = input.readInt();
        int hour = input.readInt();
        int minute = input.readInt();
        int second = input.readInt();
        int nano = input.readInt();
        String zoneId = input.readString();
        return ZonedDateTime.of(year, month, day, hour, minute, second, nano, ZoneId.of(zoneId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(final Kryo kryo, final Output output, final ZonedDateTime obj) {
        output.writeInt(obj.getYear());
        output.writeInt(obj.getMonthValue());
        output.writeInt(obj.getDayOfMonth());
        output.writeInt(obj.getHour());
        output.writeInt(obj.getMinute());
        output.writeInt(obj.getSecond());
        output.writeInt(obj.getNano());
        output.writeString(obj.getZone().getId());
    }
}
