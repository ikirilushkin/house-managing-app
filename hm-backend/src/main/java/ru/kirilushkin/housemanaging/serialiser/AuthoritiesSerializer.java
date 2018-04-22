package ru.kirilushkin.housemanaging.serialiser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.Collection;

public class AuthoritiesSerializer extends StdSerializer<Collection<GrantedAuthority>>{

    protected AuthoritiesSerializer() {
        this(null);
    }

    protected AuthoritiesSerializer(Class<Collection<GrantedAuthority>> t) {
        super(t);
    }

    @Override
    public void serialize(Collection<GrantedAuthority> authorities, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartArray(authorities.size());
        for (GrantedAuthority authority : authorities) {
            gen.writeString(authority.toString());
        }
        gen.writeEndArray();
    }
}
