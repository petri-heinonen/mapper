package fi.pmh.sandbox;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MyMapper {
    MyMapper INSTANCE = Mappers.getMapper(MyMapper.class);
 
    default <S, T> T map(S source, T target) {
        return CustomMapper.map(source, target);
    }
}