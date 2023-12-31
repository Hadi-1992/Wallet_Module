package ir.mapsa.wallet.wallet_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WalletModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletModuleApplication.class, args);
    }

}
