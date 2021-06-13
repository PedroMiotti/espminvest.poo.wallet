package espminvest.poo.wallet.respository;

import espminvest.poo.wallet.common.datatype.CambioTransactionBean;
import espminvest.poo.wallet.model.CambioTransactionModel;
import org.springframework.data.repository.CrudRepository;

public interface CambioTransactionRepository extends CrudRepository<CambioTransactionModel, Integer> {

    @Override
    CambioTransactionModel save(CambioTransactionModel cambioTransaction);



}
