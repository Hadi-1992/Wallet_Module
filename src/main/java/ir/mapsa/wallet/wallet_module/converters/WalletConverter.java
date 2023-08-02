package ir.mapsa.wallet.wallet_module.converters;

import ir.mapsa.wallet.wallet_module.models.dtoes.WalletDto;
import ir.mapsa.wallet.wallet_module.models.entities.WalletEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletConverter extends BaseConverter<WalletEntity, WalletDto> {

}
