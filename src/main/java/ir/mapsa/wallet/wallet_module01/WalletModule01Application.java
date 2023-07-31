package ir.mapsa.wallet.wallet_module01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WalletModule01Application {

    public static void main(String[] args) {
        SpringApplication.run(WalletModule01Application.class, args);
    }

}
