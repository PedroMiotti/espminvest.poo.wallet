package espminvest.poo.wallet.rest;

import espminvest.poo.cambio.common.controller.CambioController;
import espminvest.poo.wallet.common.controller.WalletController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients(basePackages = "espminvest.poo.cambio.common.controller")
@RestController
public class walletResource implements WalletController {

    @Autowired
    private CambioController cambioController;

    @Override
    public WalletController wallet(String id) {
        return null;
    }
}
