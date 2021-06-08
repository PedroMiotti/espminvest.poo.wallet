package espminvest.poo.wallet.service;

import espminvest.poo.wallet.common.datatype.WalletBean;
import espminvest.poo.wallet.model.WalletModel;
import espminvest.poo.wallet.respository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;


    public WalletBean saveWallet(WalletBean wallet){
        return walletRepository.save(new WalletModel(wallet)).toBean();
    }

    public WalletBean findBy(Integer id ){
        return walletRepository.findById(id)
                .map(walletModel -> walletModel.toBean())
                .orElse(null);
    }


}
