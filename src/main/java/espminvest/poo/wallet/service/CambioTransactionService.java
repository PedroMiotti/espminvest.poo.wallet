package espminvest.poo.wallet.service;

import espminvest.poo.cambio.common.controller.CambioController;
import espminvest.poo.cambio.common.datatype.CurrencyBean;
import espminvest.poo.cambio.common.datatype.EstimateBean;
import espminvest.poo.wallet.common.datatype.CambioTransactionBean;
import espminvest.poo.wallet.common.datatype.TransactionBean;
import espminvest.poo.wallet.common.datatype.WalletBean;
import espminvest.poo.wallet.model.CambioTransactionModel;
import espminvest.poo.wallet.respository.CambioTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CambioTransactionService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private CambioTransactionRepository cambioTransactionRepository;

    @Autowired CambioController CambioController;

    @Autowired
    private WalletService walletService;

    public CambioTransactionBean buyCambioTransaction(Integer walletId, TransactionBean cambioTransaction){

        WalletBean wallet = walletService.findByWalletId(walletId);
        if(wallet == null){
            throw new RuntimeException("Wallet not found : " + walletId);
        }

        Date now = new Date();


        CurrencyBean currency = CambioController.getCurrency(String.valueOf(cambioTransaction.getCurrencyId()));
        if (currency == null) {
            throw new RuntimeException("Currency does not exist : " + cambioTransaction.getCurrencyId());
        }


        EstimateBean estimate = CambioController.getEstimate(String.valueOf(currency.getId()), sdf.format(now));
        if (estimate == null) {
            throw new RuntimeException("Estimate not found : " + sdf.format(now));
        }

        CambioTransactionBean ct = new CambioTransactionBean();
        ct.setWallet(wallet);
        ct.setEstimate(estimate);
        ct.setQtd(cambioTransaction.getQtd());
        ct.setDate(now);

        Double transactionTotal = cambioTransaction.getQtd() * estimate.getValue();
        Double newBalanceValue = (wallet.getBalance() == null ? 0 : wallet.getBalance()) - transactionTotal;

        if(transactionTotal > wallet.getBalance()){
            throw new RuntimeException("Error : Insuficient funds !");
        }
        else{
            walletService.updateBalance(newBalanceValue, walletId);
            return cambioTransactionRepository.save(new CambioTransactionModel(ct)).toBean();
        }
    }

    public CambioTransactionBean sellCambioTransaction(Integer walletId, TransactionBean cambioTransaction){

        WalletBean wallet = walletService.findByWalletId(walletId);
        if(wallet == null){
            throw new RuntimeException("Wallet not found : " + walletId);
        }

        Date now = new Date();


        CurrencyBean currency = CambioController.getCurrency(String.valueOf(cambioTransaction.getCurrencyId()));
        if (currency == null) {
            throw new RuntimeException("Currency does not exist : " + cambioTransaction.getCurrencyId());
        }


        EstimateBean estimate = CambioController.getEstimate(String.valueOf(currency.getId()), sdf.format(now));
        if (estimate == null) {
            throw new RuntimeException("Estimate not found : " + sdf.format(now));
        }

        CambioTransactionBean ct = new CambioTransactionBean();
        ct.setWallet(wallet);
        ct.setEstimate(estimate);
        ct.setQtd(cambioTransaction.getQtd());
        ct.setDate(now);

        Double transactionTotal = cambioTransaction.getQtd() * estimate.getValue();
        Double newBalanceValue = (wallet.getBalance() == null ? 0 : wallet.getBalance()) + transactionTotal;
        walletService.updateBalance(newBalanceValue, walletId);

        return cambioTransactionRepository.save(new CambioTransactionModel(ct)).toBean();

    }

}
