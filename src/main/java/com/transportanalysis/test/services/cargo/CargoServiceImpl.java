package main.java.com.transportanalysis.test.services.cargo;

import main.java.com.transportanalysis.test.models.Product;
import org.springframework.stereotype.Component;

@Component
public class CargoServiceImpl implements CargoService {

//    protected TransactionRepository repository;
//
//    @Autowired
//    public CargoServiceImpl(@Qualifier("transaction_repository_inmemory")
//                                  TransactionRepository repository) {
//
//        this.repository = repository;
//
//    }
//
//    public Transaction getTransactionById(long transactionId) throws TransactionNotFoundException {
//
//        Transaction transaction = this.repository.getTransactionById(transactionId);
//
//        if (null == transaction) {
//            throw new TransactionNotFoundException("Transaction with id " + transactionId + " not found");
//        }
//
//        return transaction;
//    }
//
//    protected Transaction saveTransactionToRepository(Transaction transaction) {
//        return this.repository.saveTransaction(transaction);
//    }
//
//    public Transaction createNewTransaction(double amount, String type) {
//        Transaction transaction = new Transaction(amount, type);
//        return this.saveTransactionToRepository(transaction);
//    }
//
//    public Transaction createNewTransaction(double amount, String type, long parentId) throws TransactionNotFoundException {
//        /**
//         * Get parent transaction
//         */
//        Transaction parentTransaction = this.getTransactionById(parentId);
//        Transaction transaction = new Transaction(amount, type, parentTransaction);
//        return this.saveTransactionToRepository(transaction);
//    }
//
//    public Sum calculateSum(Transaction transaction) {
//        double sum = 0;
//
//        Map<Long, Transaction> children = repository.getTransactionByCriteria("value", transaction.getId());
//        Iterator it = children.values().iterator();
//
//        while (it.hasNext()) {
//            sum += ((Transaction) it.next()).getAmount();
//        }
//
//        return new Sum(sum);
//    }
//
//    public ArrayList<Long> getTransactionsByType(String type) {
//
//        ArrayList<Long> transactions = new ArrayList<>();
//        Map<Long, Transaction> children = repository.getTransactionByCriteria("name", type);
//
//        children.forEach((key, object) -> {
//            transactions.add(object.getId());
//        });
//
//        return transactions;
//    }

    @Override
    public Product getProductById(long productId) throws Exception {
        return null;
    }

    @Override
    public Product createNewProduct(double amount, String type) {
        return null;
    }
}
