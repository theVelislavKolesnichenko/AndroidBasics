package bg.tu_varna.sit.examprojectv1.tasks;

import bg.tu_varna.sit.examprojectv1.data.Repository;
import bg.tu_varna.sit.examprojectv1.listeners.OnCreateNewsListener;
import bg.tu_varna.sit.examprojectv1.models.News;

public class CreateNews implements Runnable {
    private OnCreateNewsListener onCreateNewsListener;

    public CreateNews(OnCreateNewsListener onCreateNewsListener) {
        this.onCreateNewsListener = onCreateNewsListener;
    }

    @Override
    public void run() {
        News news = Repository.createNews(0);
        onCreateNewsListener.onCreateNews(news);
    }
}
