package espminvest.poo.wallet.service;

import espminvest.poo.cambio.common.controller.CambioController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CambioTransactionService {

    @Autowired
    private CambioController cambioController;
    @Autowired
    private WalletService walletService;




}
