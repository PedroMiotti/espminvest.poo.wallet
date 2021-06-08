package espminvest.poo.wallet.rest;


import espminvest.poo.cambio.common.controller.CambioController;
import espminvest.poo.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients(basePackages = {"espminvest.poo.cambio.common.controller", "espminvest.poo.user.common.controller", "espminvest.poo.wallet.common.controller"})
@RestController
public class CambioTransactionResource {

    @Autowired
    private CambioController cambioController;
    @Autowired
    private WalletService walletService;

}
