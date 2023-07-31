package ir.mapsa.wallet.wallet_module01.repositories;

import ir.mapsa.wallet.wallet_module01.aspects.LogModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogModel, String> {
}
