package com.rabbitmqexample.market.service;

public class kullanılmıcak {


    /*           ÖRNEK SENERYO


@Service
public class MarketRequestService {

    @Autowired
    private MarketRepository marketRepository;

    @RabbitListener(queues = "firstQueue")
    @Transactional
    public void receiveMarketRequest(MarketRequest marketRequest) {
        try {
            MarketItem marketItem = marketRepository.findByUrunId(marketRequest.getUrunId())
                .orElseThrow(() -> new RuntimeException("Item not found with urunId: " + marketRequest.getUrunId()));

            // ozelNumara kontrolü
            if (!marketItem.getOzelNumara().equals(marketRequest.getOzelNumara())) {
                throw new RuntimeException("Invalid ozelNumara: " + marketRequest.getOzelNumara());
            }

            // quantityFound kontrolü
            if (marketRequest.getQuantityFound() > marketItem.getQuantity()) {
                throw new RuntimeException("Insufficient quantity for urunId: " + marketRequest.getUrunId());
            }

            validatePrice(marketRequest.getPrice(), marketItem.getPrice());

            // İşlem süreci: MarketRequest'e göre işlemleri yap
            processMarketRequest(marketRequest, marketItem);

            // Başarılı yanıt gönder
            sendSuccessResponse(marketRequest);
        } catch (Exception e) {
            // Hata durumunda geri bildirim gönder
            sendErrorResponse(marketRequest, e.getMessage());
        }
    }

    private void validatePrice(Integer requestPrice, Integer itemPrice) {
        if (requestPrice < itemPrice) {
            throw new IllegalArgumentException("Request price is lower than the item price.");
        }
    }

    private void processMarketRequest(MarketRequest marketRequest, MarketItem marketItem) {
        // Burada marketRequest ve marketItem kullanılarak gerekli işlemler yapılır
        // Örneğin, stok güncellemesi, sipariş oluşturma, veritabanı güncellemeleri vs.
    }

    private void sendSuccessResponse(MarketRequest marketRequest) {
        // Başarılı işlem sonrası müşteriye veya ilgili sisteme geri bildirim gönderme işlemleri
    }

    private void sendErrorResponse(MarketRequest marketRequest, String errorMessage) {
        // Hata durumunda müşteriye veya ilgili sisteme hata bildirimi gönderme işlemleri
    }
}


     */
}
