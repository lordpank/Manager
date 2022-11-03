import com.google.gson.Gson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StatisticTest {
    public static Statistic statistic;
    public Gson gson = new Gson();
    public String currentDate = Client.getCurrentDate();


    @BeforeEach
    public void createStatistic(){
        statistic = new Statistic();
    }

    @Test
    void getMaxCategoryBySum() {

        Request clientRequest = gson.fromJson("{\"title\": \"булка\", \"date\": \"" + currentDate + "\", \"sum\": 35}", Request.class);
        statistic.addItem(clientRequest);

        clientRequest = gson.fromJson("{\"title\": \"колбаса\", \"date\": \"" + currentDate + "\", \"sum\": 568}", Request.class);
        statistic.addItem(clientRequest);

        clientRequest = gson.fromJson("{\"title\": \"акции\", \"date\": \"" + currentDate + "\", \"sum\": 10000}", Request.class);
        statistic.addItem(clientRequest);

        Assertions.assertEquals(10603, statistic.getMaxCategory().getSum());

    }

    @Test
    void getMaxCategoryName() {

        Request clientRequest = gson.fromJson("{\"title\": \"булка\", \"date\": \"" + currentDate + "\", \"sum\": 35}", Request.class);
        statistic.addItem(clientRequest);

        clientRequest = gson.fromJson("{\"title\": \"шапка\", \"date\": \"" + currentDate + "\", \"sum\": 2500000}", Request.class);
        statistic.addItem(clientRequest);

        clientRequest = gson.fromJson("{\"title\": \"акции\", \"date\": \"" + currentDate + "\", \"sum\": 10000}", Request.class);
        statistic.addItem(clientRequest);

        Assertions.assertEquals("другое", statistic.getMaxCategory().getCategoryName());
    }

}