package ir.mapsa.wallet.wallet_module01.converters;

import ir.mapsa.wallet.wallet_module01.models.dtoes.WalletDto;
import ir.mapsa.wallet.wallet_module01.models.entities.WalletEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletConverter extends BaseConverter<WalletEntity, WalletDto> {

}
