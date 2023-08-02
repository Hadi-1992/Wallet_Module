package ir.mapsa.wallet.wallet_module.repositories;

import ir.mapsa.wallet.wallet_module.aspects.LogModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogModel, String> {
}
