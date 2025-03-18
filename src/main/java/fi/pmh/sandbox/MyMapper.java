package fi.pmh.sandbox;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MyMapper {
    MyMapper INSTANCE = Mappers.getMapper(MyMapper.class);
 
    default <T> T map(Object source, T target) {
        return CustomMapper.map(source, target);
    }
}