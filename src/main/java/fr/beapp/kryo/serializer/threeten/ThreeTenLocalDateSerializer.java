package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.threeten.bp.LocalDate;

/**
 * A Kryo serializer for ThreeTen {@link LocalDate}.
 * <p>
 * The LocalDate object is read or written as year, month and day-of-month written in different integers.
 */
public class ThreeTenLocalDateSerializer extends Serializer<LocalDate> {

    public ThreeTenLocalDateSerializer() {
        setImmutable(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate read(final Kryo kryo, final Input input, final Class<LocalDate> type) {
        int year = input.readInt();
        int month = input.readInt();
        int day = input.readInt();
        return LocalDate.of(year, month, day);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(final Kryo kryo, final Output output, final LocalDate obj) {
        output.writeInt(obj.getYear());
        output.writeInt(obj.getMonthValue());
        output.writeInt(obj.getDayOfMonth());
    }

}
