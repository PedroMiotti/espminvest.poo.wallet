package espminvest.poo.wallet.respository;

import espminvest.poo.wallet.model.StockTransactionModel;
import org.springframework.data.repository.CrudRepository;

public interface StockTransactionRepository extends CrudRepository<StockTransactionModel, Integer> {

    @Override
    StockTransactionModel save(StockTransactionModel stockTransaction);

}
