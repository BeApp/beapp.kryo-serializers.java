package fr.beapp.kryo.serializer.threeten;

import com.esotericsoftware.kryo.Kryo;
import org.threeten.bp.*;

public final class ThreeTenSerializers {

    private ThreeTenSerializers() {
    }

    public static void registerAllSerializers(Kryo kryo) {
        if (kryo == null)
            return;

        kryo.register(Duration.class, new ThreeTenDurationSerializer());
        kryo.register(LocalDate.class, new ThreeTenLocalDateSerializer());
        kryo.register(LocalDateTime.class, new ThreeTenLocalDateTimeSerializer());
        kryo.register(LocalTime.class, new ThreeTenLocalTimeSerializer());
        kryo.register(OffsetDateTime.class, new ThreeTenOffsetDateTimeSerializer());
        kryo.register(ZonedDateTime.class, new ThreeTenZonedDateTimeSerializer());
    }

}
