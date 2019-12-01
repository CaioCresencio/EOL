package br.com.ifsp.eol.resources.converters;

import br.com.ifsp.eol.model.enums.TypeOrder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TypeOrderConverter implements Converter<String, TypeOrder> {

    @Override
    public TypeOrder convert(String source) {
        if("Monofasico".equals(source)){
            return TypeOrder.MONO;
        } else if("Bifasico".equals(source)) {
            return TypeOrder.BI;
        } else {
            return TypeOrder.TRI;
        }
    }
}
