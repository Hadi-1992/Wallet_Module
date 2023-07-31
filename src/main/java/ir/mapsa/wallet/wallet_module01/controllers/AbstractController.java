package ir.mapsa.wallet.wallet_module01.controllers;

import ir.mapsa.wallet.wallet_module01.converters.BaseConverter;
import ir.mapsa.wallet.wallet_module01.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;


public class AbstractController<E, D, S extends AbstractService<E, ? extends JpaRepository<E, Long>>> {

    @Autowired
    protected S service;
    @Autowired
    protected BaseConverter<E, D> converter;
}
