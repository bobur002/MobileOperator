package uz.pdp.service.interfaceFiles;

import java.util.List;

public interface BaseModelService<T,K> {

    K add(T t);
    List<T> getList();
    boolean delete(T t);
}
