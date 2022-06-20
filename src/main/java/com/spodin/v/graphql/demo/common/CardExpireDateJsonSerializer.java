package com.spodin.v.graphql.demo.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public class CardExpireDateJsonSerializer implements JsonbSerializer<Date> {

    private static final String EXPIRE_DATE_FORMAT = "yyyy-MM";

    @Override
    public void serialize(Date obj, JsonGenerator generator, SerializationContext ctx) {
        ctx.serialize(format(obj), generator);
    }

    private String format(Date date) {
        return (date == null ? null : new SimpleDateFormat(EXPIRE_DATE_FORMAT).format(date));
    }
}
