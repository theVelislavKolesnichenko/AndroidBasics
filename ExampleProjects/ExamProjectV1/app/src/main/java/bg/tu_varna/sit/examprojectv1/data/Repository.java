package bg.tu_varna.sit.examprojectv1.data;

import bg.tu_varna.sit.examprojectv1.models.News;

import java.util.ArrayList;
import java.util.Random;

public class Repository {

    private static int number = 0;

    public static ArrayList<News> generateNews(int count) {
        ArrayList<News> news = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            news.add(createNews(0));
        }
        return news;
    }

    public static News createNews(int step) {
        number += step;
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int rand = random.nextInt(100)+10;
        for (int i = 0; i < rand; i++) {
            stringBuilder.append("content ");
        }
        return new News("news " + number++, stringBuilder.toString());
    }
}
