package com.dbenjumea.util;

import com.dbenjumea.api.Donut;
import org.bson.Document;

public class DonutMapper {
    /**
     * Map objects {@link Document} to {@link Donut}.
     *
     * @param donutDocument the information document.
     * @return A object {@link Donut}.
     */
    public static Donut map(final Document donutDocument) {
        final Donut donut = new Donut();
        donut.setId(donutDocument.getObjectId("_id"));
        donut.setFlavor(donutDocument.getString("flavor"));
        donut.setPrice(donutDocument.getDouble("price"));
        return donut;
    }
}
