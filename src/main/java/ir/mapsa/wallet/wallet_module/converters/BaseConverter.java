package ir.mapsa.wallet.wallet_module.converters;


import java.util.List;
import java.util.stream.Collectors;

public interface BaseConverter<E, D> {

    D convertEntity(E e);

    E convertDto(D d);

    default List<E> convertDto(List<D> dList) {

        if (dList != null) {
            return dList.stream()
                    .map(i -> {
                                try {
                                    return convertDto(i);
                                } catch (Exception ex) {
                                    return null;
                                }
                            }
                    ).collect(Collectors.toList());
        }
        return null;
    }

    default List<D> convertEntity(List<E> eList) {

        if (eList != null) {
            return eList.stream()
                    .map(this::convertEntity).collect(Collectors.toList());
        }
        return null;

    }
}



