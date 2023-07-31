package ir.mapsa.wallet.wallet_module01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class AbstractService<E, R extends JpaRepository<E, Long>> {

    @Autowired
    protected R repository;

}
